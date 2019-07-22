package com.example.wildstone;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Heroes {

    private String name;
    private String durability;
    private String power;
    private String race;
    private String images;

    public Heroes() {
    }

    public Heroes(String name, String durability, String power,String images) {
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


    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
