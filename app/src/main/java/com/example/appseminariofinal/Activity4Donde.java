package com.example.appseminariofinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Activity4Donde extends AppCompatActivity {

    private ImageView mapImageView;
    private ImageView pinImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_donde);

        // vinculamos a los elementos de la interfaz de usuario
        mapImageView = findViewById(R.id.mapImageView);
        pinImageView = findViewById(R.id.pinImageView);
        final ImageView pinImageView = findViewById(R.id.pinEstacionar);

        // recibimos el número ingresado en estacionar
        Bundle recibeDatos = getIntent().getExtras();
        if (recibeDatos != null) {
            String numeroIngresado = recibeDatos.getString("KeyDatos");

            // comprobamos si el número ingresado es 650
            if ("650".equals(numeroIngresado)) {
                // Cambia la imagen a azul
                pinImageView.setImageResource(R.drawable.azul);
            } else {
                // si no es 650, utiliza la imagen verde
                pinImageView.setImageResource(R.drawable.verde);
            }
        }
    }
}