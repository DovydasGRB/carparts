package com.example.individualtrackdg.Controller;

import com.example.individualtrackdg.Model.CarPart;
import com.example.individualtrackdg.Model.MakeOfCar;
import com.example.individualtrackdg.Repository.FakeData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/makeofcar")
public class MakeOfCarController {
    private static final FakeData fakeData = new FakeData();

    @GetMapping("{id}")
    public ResponseEntity<MakeOfCar> getMakeOfCarPath(@PathVariable(value = "id") int id) {
        MakeOfCar makeOfCar = fakeData.getMakeOfCar(id);

        if(makeOfCar != null) {
            return ResponseEntity.ok().body(makeOfCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<MakeOfCar>> getAllMakesOfCars(@RequestParam(value = "id") Optional<Integer> id) {
        List<MakeOfCar> makeOfCars = null;
        if(id.isPresent()) {
            MakeOfCar m = fakeData.getMakeOfCar(id.get());
        }
        makeOfCars = fakeData.getCarMakeList();

        if(makeOfCars != null) {
            return ResponseEntity.ok().body(makeOfCars);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
