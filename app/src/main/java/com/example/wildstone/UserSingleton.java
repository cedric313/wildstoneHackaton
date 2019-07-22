package com.example.wildstone;

import com.example.wildstone.models.Heroes;

import java.util.ArrayList;

public class UserSingleton {

    private static UserSingleton instance;
    private ArrayList<Heroes> heroes = new ArrayList<>();

    private UserSingleton() {
    }

    public static UserSingleton getUserInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    public ArrayList<Heroes> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Heroes> heroes) {
        this.heroes = heroes;
    }
}

