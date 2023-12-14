package com.example.appseminariofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMenu extends AppCompatActivity {

    //Declaramos variables
    Button buttonE;
    Button buttonD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonE=(Button)findViewById(R.id.buttonE);
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityMenu.this, Activity2Estacionar.class);
                startActivity(i);
            }
        });
        buttonD=(Button)findViewById(R.id.buttonD);
        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActivityMenu.this, Activity4Donde.class);
                startActivity(i);
            }
        });
    }
}