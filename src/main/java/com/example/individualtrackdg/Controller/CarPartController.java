package com.example.individualtrackdg.Controller;

import com.example.individualtrackdg.Model.CarPart;
import com.example.individualtrackdg.Model.MakeOfCar;
import com.example.individualtrackdg.Repository.FakeData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carpart")
public class CarPartController {
    private static final FakeData fakeData = new FakeData();

    @GetMapping("{id}")
    public ResponseEntity<CarPart> getCarPartPath(@PathVariable(value = "id") int id) {
        CarPart carPart = fakeData.getCarPart(id);

        if(carPart != null) {
            return ResponseEntity.ok().body(carPart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<CarPart>> getAllCarParts(@RequestParam(value = "makeModel") Optional <Integer> id) {
        List<CarPart> carParts = null;
        if(id.isPresent()) {
            MakeOfCar m = fakeData.getMakeOfCar(id.get());
            carParts = fakeData.getCarPartList(m);
        }
        else
        {
            carParts = fakeData.getCarPartList();
        }

        if(carParts != null) {
            return ResponseEntity.ok().body(carParts);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    //DELETE at http://localhost:8080/carpart/X
    public ResponseEntity deletePost(@PathVariable int id) {
        fakeData.deleteCarPart(id);
        // Idempotent method. Always return the same response (even if the resource has already been deleted before).
        return ResponseEntity.ok().build();

    }

    @PostMapping()
    //POST at http://localhost:8080/carpart/
    public ResponseEntity<CarPart> createCarPart(@RequestBody CarPart carPart) {
        if (!fakeData.add(carPart)){
            String entity =  "Car part with ID " + carPart.getID() + " already exists.";
            return new ResponseEntity(entity, HttpStatus.CONFLICT);
        } else {
            String url = "carpart" + "/" + carPart.getID();
            URI uri = URI.create(url);
            return new ResponseEntity(uri,HttpStatus.CREATED);
        }

    }

    @PutMapping()
    //PUT at http://localhost:8080/carpart/


    public ResponseEntity<CarPart> updateStudent(@RequestBody CarPart carPart) {
        if (fakeData.update(carPart)) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity("Please provide a valid car part ID.",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    //PUT at http://localhost:8080/carpart/X
    public ResponseEntity<CarPart> updateCarPart(@PathVariable("id") int id,  @RequestParam("name") String name, @RequestParam("makeModel") String makeModel,@RequestParam("year") int year) {
        CarPart carPart = fakeData.getCarPart(id);
        if (carPart == null){
            return new ResponseEntity("Please provide a valid car part ID.",HttpStatus.NOT_FOUND);
        }

        MakeOfCar makeOfCar = fakeData.getMakeOfCar(id);
        if (makeOfCar == null){
            return new ResponseEntity("Please provide a valid make ID.",HttpStatus.BAD_REQUEST);
        }

        carPart.setName(name);
        carPart.setMakeModel(makeOfCar);
        carPart.setYear(year);
        return ResponseEntity.noContent().build();
    }

}

