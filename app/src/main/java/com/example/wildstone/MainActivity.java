package com.example.wildstone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView listHeroes = findViewById(R.id.rvCards);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listHeroes.setLayoutManager(layoutManager);

        final ArrayList<Heroes> heroesModels = new ArrayList<>();
        heroesModels.add(new Heroes("Paris", "Tokyo", "Eric Cartman", "","","",""));
        heroesModels.add(new Heroes("Paris", "Tokyo", "Stan Marsh", "","","",""));

        final CardAdapter adapter = new CardAdapter(heroesModels);
        listHeroes.setAdapter(adapter);
    }
}
