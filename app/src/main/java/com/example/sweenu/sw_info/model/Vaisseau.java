package com.example.sweenu.sw_info.model;

public class Vaisseau {
    String name;
    String model;
    String manufacturer;
    int price;
    int length;
    int nbplaces;
    int nbplacesCargo;

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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getlength() {
        return length;
    }

    public void setlength(int length) {
        this.length = length;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public int getNbplacesCargo() {
        return nbplacesCargo;
    }

    public void setNbplacesCargo(int nbplacesCargo) {
        this.nbplacesCargo = nbplacesCargo;
    }

    public Vaisseau(String name, String model, String manufacturer, int price, int length, int nbplaces, int nbplacesCargo) {

        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.length = length;
        this.nbplaces = nbplaces;
        this.nbplacesCargo = nbplacesCargo;
    }


}
