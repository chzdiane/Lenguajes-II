package com.example.parcialdianella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAdministrador, btnJugador;

    //En esta clase se envia segun el boton presionado al login de jugadores o al login del administrador con un intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        btnJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor=0;

                Intent intent = new Intent(getApplicationContext(),loginJugador.class);
                intent.putExtra("Clave",valor);
                startActivity(intent);
            }
        });

        btnAdministrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valor2=0;

                Intent intent = new Intent(getApplicationContext(),administrador.class);
                intent.putExtra("Clave2",valor2);
                startActivity(intent);
            }
        });

    }

    private void conectar() {
        btnAdministrador = findViewById(R.id.btnAdministrador);
        btnJugador = findViewById(R.id.btnJugador);
    }
}
