package com.example.appseminariofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2Estacionar extends AppCompatActivity {

    //Declaramos variables
    Button buttonComenzar;
    EditText TextNumberBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2_estacionar);

        //asignamos las variables

        TextNumberBox=(EditText) findViewById(R.id.TextNumberBox);
        buttonComenzar=(Button)findViewById(R.id.buttonComenzar);

        buttonComenzar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Bundle enviaDatos= new Bundle();
                enviaDatos.putString("KeyDatos", TextNumberBox.getText().toString());

                Intent i = new Intent(Activity2Estacionar.this, Activity3Facturar.class);
                i.putExtras(enviaDatos);
                startActivity(i);
            }
        });
    }
}