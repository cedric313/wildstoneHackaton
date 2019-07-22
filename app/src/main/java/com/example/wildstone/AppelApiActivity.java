package com.example.wildstone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppelApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appel_api);
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "https://akabab.github.io/superhero-api/api/all.json";

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

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
                                JSONArray height = appearance.getJSONArray("appearance");
                            }

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
