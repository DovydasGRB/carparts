package com.example.individualtrackdg.Repository;

import com.example.individualtrackdg.Model.CarPart;
import com.example.individualtrackdg.Model.MakeOfCar;

import java.util.ArrayList;
import java.util.List;

public class FakeData {
    private final List<CarPart> carPartList = new ArrayList<>();
    private final List<MakeOfCar> carMakeList = new ArrayList<>();

    public FakeData(){
        MakeOfCar MakeModel1 = new MakeOfCar(1,"BMW");
        MakeOfCar MakeModel2 = new MakeOfCar(2,"Audi");
        MakeOfCar MakeModel3 = new MakeOfCar(3,"Mercedes Benz");
        MakeOfCar MakeModel4 = new MakeOfCar(4,"Hyundai");
        MakeOfCar MakeModel5 = new MakeOfCar(5,"Porsche");
        carMakeList.add(MakeModel1);
        carMakeList.add(MakeModel2);
        carMakeList.add(MakeModel3);
        carMakeList.add(MakeModel4);
        carMakeList.add(MakeModel5);

        carPartList.add(new CarPart(1,MakeModel1,"Headlight",2015));
        carPartList.add(new CarPart(2,MakeModel2,"Front bumper",2009));
        carPartList.add(new CarPart(3,MakeModel3,"Piston",2019));
        carPartList.add(new CarPart(4,MakeModel4,"Windscreen",2008));
        carPartList.add(new CarPart(5,MakeModel5,"Driver's door",2020));
    }
    public List<CarPart> getCarPartList() {
        return carPartList;
    }
    public List<MakeOfCar> getCarMakeList() {
        return carMakeList;
    }

    public List<CarPart> getCarPartList(MakeOfCar makeOfCar) {
        List<CarPart> filtered = new ArrayList<>();
        for (CarPart carPart : carPartList) {
            if (carPart.getMake().equals(makeOfCar)) {
                filtered.add(carPart);
            }
        }
        return filtered;
    }

    public CarPart getCarPart(int id) {
        for (CarPart carPart : carPartList) {
            if (carPart.getID() == id)
                return carPart;
        }
        return null;
    }

    public boolean deleteCarPart(int id) {
        CarPart carPart = getCarPart(id);
        if (carPart == null){
            return false;
        }

        return carPartList.remove(carPart);
    }


    public boolean add(CarPart carPart) {
        if (this.getCarPart(carPart.getID()) != null){
            return false;
        }
        carPartList.add(carPart);
        return true;
    }

    public boolean update(CarPart carPart) {
        CarPart old = this.getCarPart(carPart.getID());
        if (old == null) {
            return false;
        }
        old.setName(carPart.getName());
        old.setMakeModel(carPart.getMake());
        old.setYear(carPart.getYear());
        return true;
    }

    public MakeOfCar getMakeOfCar(int id) {
        for (MakeOfCar makeOfCar : carMakeList) {
            if (makeOfCar.getCarMakeId()==(id)) {
                return makeOfCar;
            }
        }
        return null;
    }
}
