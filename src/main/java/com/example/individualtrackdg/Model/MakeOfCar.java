package com.example.individualtrackdg.Model;

import java.util.Objects;

public class MakeOfCar {
    private int id;
    private String name;
    public MakeOfCar(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public MakeOfCar() {
    }



    public int getCarMakeId() {
        return id;
    }

    public void setCarMakeId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MakeOfCar makeOfCar = (MakeOfCar) o;
        return id == makeOfCar.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MakeOfCar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
