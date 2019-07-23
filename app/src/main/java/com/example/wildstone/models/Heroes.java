package com.example.wildstone.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Heroes {

    private String name;
    private int durability;
    private int power;
    private String race;
    private String images;

    public Heroes() {
    }

    public Heroes(String name, int durability, int power,String images) {
        this.name = name;
        this.durability = durability;
        this.power = power;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }


    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void takeHit(int hit) {
        this.durability =  this.durability - hit;
        System.out.println(this.name + " has " + this.durability + " points remaining. ");
        System.out.println (this.isKo() ? this.name + " is KO ": this.name + " is still alive");

    }

    public boolean isKo() {
        return this.durability <= 0;
    }

}
