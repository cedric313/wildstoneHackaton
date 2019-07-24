package com.example.wildstone;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private int knock = 0;
    private int[] userPoint = new int[5];
    private int[] botPoint = new int[5];

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

                                heroBot.add(new Heroes(name,durability, power, StringimageHero));

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

                                    while (!heroesArrayList.get(0).isKo() && !heroBot.get(index).isKo()) {
                                        heroBot.get(index).takeHit(heroesArrayList.get(0).getPower());
                                        if (heroBot.get(index).getDurability() > 0) {
                                            heroesArrayList.get(0).takeHit(heroBot.get(index).getPower());
                                        }
                                        if(heroBot.get(index).getDurability() < 0){
                                            userPoint[0] = 1;
                                            knock += 1;
                                            MediaPlayer mp = MediaPlayer.create(getApplicationContext(),R.raw.attack);

                                            mp.start();
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("player bot is ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                        }
                                        else{
                                            botPoint[0] = 1;
                                            MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(),R.raw.punch);
                                            mp1.start();
                                            knock += 1;
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("You are Ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                        }
                                    }
                                    checkFinish();

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
                                    while (!heroesArrayList.get(1).isKo() && !heroBot.get(index2).isKo()) {
                                        heroBot.get(index2).takeHit(heroesArrayList.get(1).getPower());
                                        if (heroBot.get(index2).getDurability() > 0) {
                                            heroesArrayList.get(1).takeHit(heroBot.get(index2).getPower());
                                        }
                                        if(heroBot.get(index2).getDurability() < 0){
                                            userPoint[1] = 1;
                                            knock += 1;
                                            MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(),R.raw.attack);

                                            mp2.start();
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("player bot is ko");
                                            tvIsKo.setVisibility(View.VISIBLE);


                                        }
                                        else{
                                            botPoint[1] = 1;
                                            MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(),R.raw.punch);
                                            mp3.start();
                                            knock += 1;
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("You are Ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                            }
                                    }
                                    checkFinish();
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
                                    while (!heroesArrayList.get(2).isKo() && !heroBot.get(index3).isKo()) {
                                        heroBot.get(index3).takeHit(heroesArrayList.get(2).getPower());
                                        if (heroBot.get(index3).getDurability() > 0) {
                                            heroesArrayList.get(2).takeHit(heroBot.get(index3).getPower());
                                        }
                                        if(heroBot.get(index3).getDurability() < 0){
                                            userPoint[2] = 1;
                                            knock += 1;
                                            MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(),R.raw.attack);

                                            mp4.start();
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("player bot is ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                        }
                                        else{
                                            botPoint[2] = 1;
                                            MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(),R.raw.punch);

                                            mp5.start();
                                            knock += 1;
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("You are Ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                           }

                                    }
                                    checkFinish();
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
                                    while (!heroesArrayList.get(3).isKo() && !heroBot.get(index1).isKo()) {
                                        heroBot.get(index1).takeHit(heroesArrayList.get(3).getPower());
                                        if (heroBot.get(index1).getDurability() > 0) {
                                            heroesArrayList.get(3).takeHit(heroBot.get(index1).getPower());
                                        }
                                        if(heroBot.get(index1).getDurability() < 0){
                                            userPoint[3] = 1;
                                            knock += 1;
                                            MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(),R.raw.attack);

                                            mp6.start();
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("player bot is ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                        }
                                        else{
                                            botPoint[3] = 1;
                                            MediaPlayer mp7 = MediaPlayer.create(getApplicationContext(),R.raw.punch);

                                            mp7.start();
                                            knock += 1;
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("You are Ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                             }

                                    }
                                    checkFinish();
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
                                    while (!heroesArrayList.get(4).isKo() && !heroBot.get(index4).isKo()) {
                                        heroBot.get(index4).takeHit(heroesArrayList.get(4).getPower());
                                        if (heroBot.get(index4).getDurability() > 0) {
                                            heroesArrayList.get(4).takeHit(heroBot.get(index4).getPower());
                                        }
                                        if(heroBot.get(index4).getDurability() < 0){
                                            userPoint[4] = 1;
                                            knock += 1;
                                            MediaPlayer mp8 = MediaPlayer.create(getApplicationContext(),R.raw.attack);
                                            mp8.start();
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("player bot is ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                        }
                                        else{
                                            botPoint[4] = 1;
                                            MediaPlayer mp9 = MediaPlayer.create(getApplicationContext(),R.raw.punch);
                                            mp9.start();
                                            knock += 1;
                                            TextView tvIsKo = findViewById(R.id.tvIsKo);
                                            tvIsKo.setText("You are Ko");
                                            tvIsKo.setVisibility(View.VISIBLE);

                                        }


                                    }
                                    checkFinish();
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
    public void checkFinish(){

        if (knock == 5 && count(userPoint) >= 3) {
            Intent intent = new Intent(BattleField.this, RewardActivity.class);
            startActivity(intent);
        }
        if (knock == 5 && count(botPoint) >= 3) {
            startActivity(new Intent(BattleField.this, RewardLoseActivity.class));
        }
    }
    public int count(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++ ) {
            sum += array[i];
        }
        return sum;
    }

}
