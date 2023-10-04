package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // region Variables
    Button botonPuntosKiki, botonSetsKiki, botonJuegosKiki;
    Button botonPuntosOtro,botonSetsOtro,botonJuegosOtro;
    Button botonRESET;

    int puntosKiki = 0;
    int setsKiki = 0;
    int juegosKiki = 0;

    int puntosOtro = 0;
    int setsOtro = 0;
    int juegosOtro = 0;
    //endregion


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region Asignación de botones
        botonPuntosKiki = findViewById(R.id.bPuntosKiki);
        botonSetsKiki = findViewById(R.id.bSetKiki);
        botonJuegosKiki = findViewById(R.id.bJuegoKiki);

        botonPuntosOtro = findViewById(R.id.bPuntosOtro);
        botonSetsOtro = findViewById(R.id.bSetOtro);
        botonJuegosOtro = findViewById(R.id.bJuegoOtro);

        botonRESET = findViewById(R.id.bReset);
        //endregion

        // region Botones kiki

        botonRESET.setOnClickListener(v -> {
            puntosKiki = 0;
            juegosKiki = 0;
            setsKiki = 0;

            puntosOtro = 0;
            juegosOtro = 0;
            setsOtro = 0;

            actualizarMarcador(1);
            actualizarMarcador(2);
            actualizarMarcador(3);
        });

        botonPuntosKiki.setOnClickListener(v -> {

            puntosKiki += 15;

            if (puntosKiki >= 60){
                puntosKiki = 0;
                puntosOtro = 0;
            }




            actualizarMarcador(1);
        });

        botonJuegosKiki.setOnClickListener(v -> {
            // Incrementa el marcador del botón 2
            juegosKiki++;
            if (juegosKiki >= 6){
                juegosKiki = 0;
                juegosOtro = 0;
            }
            actualizarMarcador(2);
        });

        // Configuración de OnClickListener para el botón 3
        botonSetsKiki.setOnClickListener(v -> {
            // Incrementa el marcador del botón 3
            setsKiki++;
            if (setsKiki >= 4){
                setsKiki = 0;
                setsOtro = 0;
            }
            actualizarMarcador(3);
        });
        //endregion

        // region Botones otro


        botonPuntosOtro.setOnClickListener(v -> {
            puntosOtro += 15;

            if (puntosOtro >= 60){
                puntosOtro = 0;
                puntosKiki = 0;
            }
            actualizarMarcador(1);
        });

        botonJuegosOtro.setOnClickListener(v -> {
            juegosOtro++;
            if (juegosOtro >= 6){
                juegosOtro = 0;
                juegosKiki = 0;
            }
            actualizarMarcador(2);
        });

        botonSetsOtro.setOnClickListener(v -> {
            setsOtro++;
            if (setsOtro >= 4){
                setsOtro = 0;
                setsKiki = 0;
            }
            actualizarMarcador(3);
        });



        //endregion


    }

    //region actualizarMarcador

    @SuppressLint("SetTextI18n")
    private void actualizarMarcador(int boton) {
        TextView textViewMarcador;

        switch (boton) {
            case 1:
                textViewMarcador = findViewById(R.id.MarcadorPkiki);
                textViewMarcador.setText("" + puntosKiki );

                textViewMarcador= findViewById(R.id.MarcadorPOtro);
                textViewMarcador.setText("" + puntosOtro);

                break;
            case 2:
                textViewMarcador = findViewById(R.id.MarcadorJkiki);
                textViewMarcador.setText("" + juegosKiki);

                textViewMarcador = findViewById(R.id.MarcadorJOtro);
                textViewMarcador.setText("" + juegosOtro);
                break;
            case 3:
                textViewMarcador = findViewById(R.id.MarcadorSkiki);
                textViewMarcador.setText("" + setsKiki);

                textViewMarcador = findViewById(R.id.MarcadorSOtro);
                textViewMarcador.setText("" + setsOtro);
                break;
            default:
        }

    }
    //endregion

}




