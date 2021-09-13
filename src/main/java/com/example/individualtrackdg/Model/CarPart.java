package com.example.individualtrackdg.Model;

import java.util.Objects;

public class CarPart {
    private int id;
    private MakeOfCar makeModel;
    private String name;
    private int year;
    public CarPart(int id, MakeOfCar makeModel, String name, int year) {
        this.id = id;
        this.makeModel=makeModel;
        this.name = name;
        this.year=year;
    }
    public CarPart() {
    }

    public int getID() {return id;}
    public void setId(int id) {this.id = id;}

    public MakeOfCar getMake() {
        return makeModel;
    }
    public void setMakeModel(MakeOfCar makeModel) {
        this.makeModel = makeModel;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPart carPart = (CarPart) o;
        return Objects.equals(id, carPart.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CarPart{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", make and model='"+makeModel+'\''+
                ", year='"+year+'\''+
                '}';
    }
}
