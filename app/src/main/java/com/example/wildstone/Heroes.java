package com.example.wildstone;

public class Heroes {

    private String name;
    private String durability;
    private String power;
    private String race;
    private String height;
    private String weight;

    public Heroes() {
    }

    public Heroes(String name, String durability, String power, String race, String height, String weight) {
        this.name = name;
        this.durability = durability;
        this.power = power;
        this.race = race;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
