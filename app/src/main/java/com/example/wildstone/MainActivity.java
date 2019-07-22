package com.example.wildstone;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.btPlay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btPlay:
                        alertDialog();
                        break;
                }
            }

            private void alertDialog() {
                AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
                dialog.setMessage("Salut les tocard!! Dans ce jeu vous allez devoir choisir 5 cartes" +
                        " et affronter un bot qui va tout faire pour vous détruire...SOIS FORT.. ");
                dialog.setTitle("Lis ca petite merde !!");
                dialog.setNegativeButton("J'ai la trouille je m'en vais!!", null);
                dialog.setPositiveButton("C'est parti mon kiki !!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(getApplicationContext(),"T'aurais jamais du accepter morveux... SEE U IN HELL",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(MainActivity.this, PickCard.class);
                                startActivity(intent);
                            }
                        });

                AlertDialog alertDialog=dialog.create();
                alertDialog.show();
            }
        });


    }
}
