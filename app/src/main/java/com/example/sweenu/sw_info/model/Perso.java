package com.example.sweenu.sw_info.model;

public class Perso {
    private String name;
    private int height;
    private int mass;
    private String haircolor;
    private String skincolor;
    private String birthyear;
    private String gender;


    public Perso(String name, int height, int mass, String haircolor, String skincolor, String birthyear, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.haircolor = haircolor;
        this.skincolor = skincolor;
        this.birthyear = birthyear;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getHaircolor() {
        return haircolor;
    }

    public void setHaircolor(String haircolor) {
        this.haircolor = haircolor;
    }

    public String getSkincolor() {
        return skincolor;
    }

    public void setSkincolor(String skincolor) {
        this.skincolor = skincolor;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

