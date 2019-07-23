package com.example.wildstone;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wildstone.models.Heroes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class BattleField extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_field_activity);


        final ImageView playR = findViewById(R.id.imageView3);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://akabab.github.io/superhero-api/api/all.json";

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        final ArrayList<Heroes> heroBot = new ArrayList<>();

                        try {
                            JSONArray listHero = response;
                            for (int i = 0; i < listHero.length(); i++) {
                                JSONObject hero = (JSONObject) listHero.get(i);
                                String name = hero.getString("name");
                                JSONObject position = (JSONObject) hero.get("powerstats");
                                int power = (int) position.getInt("power");
                                int durability = (int) position.getInt("durability");
                                JSONObject appearance = (JSONObject) hero.get("appearance");
                                String race = (String) appearance.getString("race");
                                JSONArray height = appearance.getJSONArray("height");
                                String cm = "";
                                if (height.get(0) != null) {
                                    cm = (String) height.get(0);
                                }
                                JSONObject image = (JSONObject) hero.get("images");
                                String StringimageHero = "";
                                if (image.getString("sm") != null) {
                                    StringimageHero = image.getString("sm");
                                }

                                heroBot.add(new Heroes(name, String.valueOf(durability), String.valueOf(power), StringimageHero));

                            }

                            Random r = new Random();
                            final int index = r.nextInt((500 - 1) + 1) + 0;
                            final ImageButton card8 = findViewById(R.id.imageButton8);
                            Glide.with(BattleField.this)
                                    .load(heroBot.get(index).getImages())
                                    .into(card8);


                            Random r1 = new Random();
                            final int index1 = r1.nextInt((500 - 1) + 1) + 0;
                            ImageButton card9 = findViewById(R.id.imageButton9);
                            Glide.with(BattleField.this)
                                    .load(heroBot.get(index1).getImages())
                                    .into(card9);

                            Random r2 = new Random();
                            final int index2 = r2.nextInt((500 - 1) + 1) + 0;
                            ImageButton card10 = findViewById(R.id.imageButton10);
                            Glide.with(BattleField.this)
                                    .load(heroBot.get(index2).getImages())
                                    .into(card10);

                            Random r3 = new Random();
                            final int index3 = r3.nextInt((500 - 1) + 1) + 0;
                            ImageButton card11 = findViewById(R.id.imageButton11);
                            Glide.with(BattleField.this)
                                    .load(heroBot.get(index3).getImages())
                                    .into(card11);

                            Random r4 = new Random();
                            final int index4 = r4.nextInt((500 - 1) + 1) + 0;
                            ImageButton card7 = findViewById(R.id.imageButton7);
                            Glide.with(BattleField.this)
                                    .load(heroBot.get(index4).getImages())
                                    .into(card7);

                            final ArrayList<Heroes> heroesArrayList = new ArrayList<>();

                            UserSingleton user = UserSingleton.getUserInstance();

                            for (Heroes hero : user.getHeroes()) {

                                heroesArrayList.add(hero);

                            }
                            ImageButton card1 = findViewById(R.id.imageButton);
                            Glide.with(BattleField.this)
                                    .load(heroesArrayList.get(0).getImages())
                                    .into(card1);
                            card1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ImageView playerUs = findViewById(R.id.imageView2);
                                    Glide.with(BattleField.this)
                                            .load(heroesArrayList.get(0).getImages())
                                            .into(playerUs);
                                    Glide.with(BattleField.this)
                                            .load(heroBot.get(index).getImages())
                                            .into(playR);


                                }
                            });
                            ImageButton card2 = findViewById(R.id.imageButton2);
                            Glide.with(BattleField.this)
                                    .load(heroesArrayList.get(1).getImages())
                                    .into(card2);
                            card2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ImageView playerUs = findViewById(R.id.imageView2);
                                    Glide.with(BattleField.this)
                                            .load(heroesArrayList.get(1).getImages())
                                            .into(playerUs);
                                    Glide.with(BattleField.this)
                                            .load(heroBot.get(index2).getImages())
                                            .into(playR);
                                }
                            });
                            ImageButton card4 = findViewById(R.id.imageButton4);
                            Glide.with(BattleField.this)
                                    .load(heroesArrayList.get(2).getImages())
                                    .into(card4);
                            card4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ImageView playerUs = findViewById(R.id.imageView2);
                                    Glide.with(BattleField.this)
                                            .load(heroesArrayList.get(2).getImages())
                                            .into(playerUs);
                                    Glide.with(BattleField.this)
                                            .load(heroBot.get(index3).getImages())
                                            .into(playR);
                                }
                            });
                            ImageButton card6 = findViewById(R.id.imageButton6);
                            Glide.with(BattleField.this)
                                    .load(heroesArrayList.get(3).getImages())
                                    .into(card6);
                            card6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ImageView playerUs = findViewById(R.id.imageView2);
                                    Glide.with(BattleField.this)
                                            .load(heroesArrayList.get(3).getImages())
                                            .into(playerUs);
                                    Glide.with(BattleField.this)
                                            .load(heroBot.get(index1).getImages())
                                            .into(playR);
                                }
                            });
                            ImageButton card3 = findViewById(R.id.imageButton3);
                            Glide.with(BattleField.this)
                                    .load(heroesArrayList.get(4).getImages())
                                    .into(card3);
                            card3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ImageView playerUs = findViewById(R.id.imageView2);
                                    Glide.with(BattleField.this)
                                            .load(heroesArrayList.get(4).getImages())
                                            .into(playerUs);
                                    Glide.with(BattleField.this)
                                            .load(heroBot.get(index4).getImages())
                                            .into(playR);
                                }
                            }
                            );


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("VOLLEY_ERROR", "onErrorResponse: " + error.getMessage());
                    }
                }
        );

        requestQueue.add(jsonObjectRequest);


    }
}
