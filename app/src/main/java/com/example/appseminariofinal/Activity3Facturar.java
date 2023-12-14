package com.example.appseminariofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3Facturar extends AppCompatActivity {

    //Declaramos variables
    TextView textViewDatos;
    private TextView timerTextView;
    private TextView textView5000;
    private Button startButton;
    private Button stopButton;
    private Handler handler;
    private Runnable runnable;
    private long startTiempoEnMillis;
    private int textView5000Value = 5000;
    private Button buttonMapa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_facturar);

        //asignamos las variables

        textViewDatos=(TextView)findViewById(R.id.textViewDatos);
        timerTextView = findViewById(R.id.timerTextView);
        textView5000 = findViewById(R.id.textView5000);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        //creamos el handles que va a ejecutar tareas
        handler = new Handler();

        startButton.setOnClickListener(new View.OnClickListener() { //al hacer click
            @Override
            public void onClick(View view) {
                startTimer();
            } // llamamos al metodo startime
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopTimer();
            }
        });

        Bundle recibeDatos= getIntent().getExtras();  //traemos los datos guardados a traves del intent
        if (recibeDatos != null) {
            String datos = recibeDatos.getString("KeyDatos");

            // Realizar acciones con los datos recibidos, por ejemplo, mostrar en un TextView
            String info = recibeDatos.getString("KeyDatos");
            textViewDatos.setText(info); // se guarda el dato del numero

        }

        buttonMapa=(Button)findViewById(R.id.buttonMapa);
        buttonMapa.setOnClickListener(new View.OnClickListener() { //creamos el boton que lleva al mapa
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Activity3Facturar.this, Activity4Donde.class);
                startActivity(i);
            }
        });

    }
    private void startTimer() {
        // obtenemos el tiempo actual en milisegundos
        startTiempoEnMillis = System.currentTimeMillis();

        // creamos el objeto Runnable para ejecutar tareas periódicas
        runnable = new Runnable() {
            @Override
            public void run() {
                // obtenemos el tiempo actual en milisegundos
                long currentTiempoEnMillis = System.currentTimeMillis();
                // calculamos el tiempo transcurrido desde el inicio del temporizador
                long elapsedTiempoEnMillis = currentTiempoEnMillis - startTiempoEnMillis;
                //aca se actualiza la view del temporizador en la ui
                updateTimer(elapsedTiempoEnMillis);

                // calculamos los minutos transcurridos
                int elapsedMinutos = (int) (elapsedTiempoEnMillis / (60 * 1000));

                // Solo se va a aplicar el descuento en textView5000Value si paso 1 minuto
                if (elapsedMinutos > 0 && elapsedTiempoEnMillis % (60 * 1000) < 1000) {
                    subtractFromTextView5000();
                }

                // se ejecuta el Runnable después de 1 segundo
                handler.postDelayed(this, 1000);
            }
        };
        //se ejecuta el runable despues de 1 seg
        handler.postDelayed(runnable, 1000);
        // deshabilitamos el botón de iniciar y habilitamos el botón de detener
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    private void stopTimer() {
        // si existe runnable detenemos la ejecución
        if (runnable != null) {
            handler.removeCallbacks(runnable);
            // habilitamos el botón de iniciar y deshabilitamos el botón de detener
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }

    private void updateTimer(long elapsedTiempoEnMillis) {
        // convertimos el tiempo transcurrido a horas, minutos y segundos

        //dividimos el tiempo transcurrido en milis por el num de milis en una hora
        int hours = (int) (elapsedTiempoEnMillis / 3600000);

        //utilizaos el operador % para obtener el residuo después del calculo anterior y lo dividimos
        // por la cantidad de milis en un minuto.
        int minutes = (int) ((elapsedTiempoEnMillis % 3600000) / 60000);

        //utilizamos el operador % para obtener el residuo después del calculo anterior y lo dividimos
        // por la cantidad de milis en un segundo.
        int seconds = (int) ((elapsedTiempoEnMillis % 60000) / 1000);

        // aca hacemos q el tiempo transcurrido se vea en formato de  HH:mm:ss

        String timeElapsedFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        // lo guardamos en el TextView del temporizador
        timerTextView.setText(timeElapsedFormatted);
    }

    private void subtractFromTextView5000() {
        // se reduce el valor de textView5000Value en 20
        textView5000Value -= 20;
        if (textView5000Value < 0) {
            textView5000Value = 0;
        }
        // y establecemos el nuevo valor en el TextView
        textView5000.setText(String.valueOf(textView5000Value));
    }
}