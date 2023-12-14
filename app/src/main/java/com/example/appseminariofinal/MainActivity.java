package com.example.appseminariofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declaramos variables
    private Button buttonIngresar;
    private EditText TextEmail;
    private EditText TextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignamos las variables a la UI
        buttonIngresar = findViewById(R.id.buttonIngresar);
        TextEmail = findViewById(R.id.TextEmail);
        TextPassword = findViewById(R.id.TextPassword);

        buttonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Comparamos los valores de TextEmail y TextPassword para validarlos
                if (!TextEmail.getText().toString().isEmpty() && TextEmail.getText().toString().equals("admin")) {
                    if (!TextPassword.getText().toString().isEmpty() && TextPassword.getText().toString().equals("admin123")) {

                        // Si esta logeado va a la actividad principal
                        Intent i = new Intent(MainActivity.this, ActivityMenu.class);
                        startActivity(i);
                        // Si la contraseña es incorrecta lanza este mensaje
                    } else {
                        Toast.makeText(MainActivity.this, "La contraseña es incorrecta. Verifique sus datos e intente nuevamente.", Toast.LENGTH_SHORT).show();
                    }
                    // Si no esta logeado lanza este mensaje
                } else {
                    Toast.makeText(MainActivity.this, "El nombre de usuario es incorrecto. Verifique sus datos e intente nuevamente.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
