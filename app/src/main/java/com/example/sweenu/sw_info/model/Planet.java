package com.example.sweenu.sw_info.model;

public class Planet {
    String name;
    int rotation;
    int orbital;
    int diameter;
    String climate;
    int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getOrbital() {
        return orbital;
    }

    public void setOrbital(int orbital) {
        this.orbital = orbital;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Planet(String name, int rotation, int orbital, int diameter, String climate, int population) {

        this.name = name;
        this.rotation = rotation;
        this.orbital = orbital;
        this.diameter = diameter;
        this.climate = climate;
        this.population = population;
    }
}