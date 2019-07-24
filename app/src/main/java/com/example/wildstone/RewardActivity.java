package com.example.wildstone;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RewardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);

        MediaPlayer mp = MediaPlayer.create(RewardActivity.this , R.raw.wow);
        mp.start();

        Button btBack = findViewById(R.id.buttonback1);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RewardActivity.this , ListHeroesActivity.class));
            }
        });


    }
}
