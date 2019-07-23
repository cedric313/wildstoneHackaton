package com.example.wildstone;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.example.wildstone.models.Heroes;

import java.util.ArrayList;
import java.util.Arrays;

public class BattleField extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_field_activity);

        ArrayList<Heroes> heroesArrayList = new ArrayList<>();

        UserSingleton user = UserSingleton.getUserInstance();

        for (Heroes hero: user.getHeroes()){

            heroesArrayList.add(hero);

        }
        ImageButton card1 = findViewById(R.id.imageButton);
        Glide.with(BattleField.this)
                .load(heroesArrayList.get(0).getImages())
                .into(card1);
    }
}
