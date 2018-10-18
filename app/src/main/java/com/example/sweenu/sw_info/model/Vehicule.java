package com.example.sweenu.sw_info.model;

public class Vehicule {
    String name;
    String model;
    int price;
    long length;
    int speed;
    int crew;
    int capacity;
    String Vclass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getVclass() {
        return Vclass;
    }

    public void setVclass(String vclass) {
        Vclass = vclass;
    }

    public Vehicule(String name, String model, int price, long length, int speed, int crew, int capacity, String vclass) {

        this.name = name;
        this.model = model;
        this.price = price;
        this.length = length;
        this.speed = speed;
        this.crew = crew;
        this.capacity = capacity;
        Vclass = vclass;
    }
}
