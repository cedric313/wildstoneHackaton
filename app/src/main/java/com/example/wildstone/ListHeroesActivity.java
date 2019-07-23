package com.example.wildstone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

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

public class ListHeroesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_heroes_activity);

        final RecyclerView listHeroes = findViewById(R.id.rvCards);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getParent(), LinearLayoutManager.HORIZONTAL, false);
        listHeroes.setLayoutManager(layoutManager);


        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://akabab.github.io/superhero-api/api/all.json";

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        final ArrayList<Heroes> heroesModels = new ArrayList<>();

                        try {
                            JSONArray listHero = response;
                            for(int i = 0 ; i < listHero.length() ; i++) {
                                JSONObject hero = (JSONObject) listHero.get(i);
                                String name = hero.getString("name");
                                JSONObject position = (JSONObject) hero.get("powerstats");
                                int power = (int) position.getInt("power");
                                int durability = (int) position.getInt("durability");
                                JSONObject appearance = (JSONObject) hero.get("appearance");
                                String race = (String) appearance.getString("race");
                                JSONArray height = appearance.getJSONArray("height");
                                String cm = "";
                                if(height.get(0) != null){
                                    cm = (String) height.get(0);
                                }
                                JSONObject image = (JSONObject) hero.get("images");
                                String StringimageHero = "";
                                if(image.getString("sm") != null){
                                    StringimageHero = image.getString("sm");
                                }

                                heroesModels.add(new Heroes(name,String.valueOf(durability), String.valueOf(power),StringimageHero));

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        final CardAdapter adapter = new CardAdapter(heroesModels);
                        listHeroes.setAdapter(adapter);
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
