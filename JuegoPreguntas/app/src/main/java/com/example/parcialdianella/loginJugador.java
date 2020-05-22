package com.example.parcialdianella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class loginJugador extends AppCompatActivity {

    String envio;
    EditText txtNombre, txtContraseña;
    Button btnRegistrar, btnJugar;
    archivosPlanos objArchivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_jugador);
        objArchivos = new archivosPlanos(this,"Jugadores.txt");
        conectar();

        Bundle recuperar = getIntent().getExtras();
        envio = recuperar.getString("Clave");

        final ArrayList<Jugador> lista = objArchivos.leerJugadores();

        /*En esta clase cuando se presiona el boton jugar se empieza a rrecorrer una lista que contiene los jugadores
        * que se leyeron del archivo plano donde se encuentran, para cada uno de los jugadores registrados se verifica
        * si su nombre y contraseña son validos para asi poder iniciar con el tablero de preguntas. No se permiten ingresar
        * usuarios no registrados*/


        btnJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreJugador;
                ArrayList<Jugador> lista = objArchivos.leerJugadores();

                for (Jugador jugador : lista) {
                    if(jugador.getNombre().equals(txtNombre.getText().toString().trim()) && jugador.getContraseña().equals(txtContraseña.getText().toString().trim())){
                        nombreJugador = jugador.getNombre();
                        Intent intent = new Intent(getApplicationContext(),tablero.class);
                        intent.putExtra("ClaveJugador", nombreJugador);
                        startActivity(intent);
                        txtNombre.setText("");
                        txtContraseña.setText("");
                        break;
                    }
                }
                Toast.makeText(loginJugador.this, "El jugador no se encuentra registrado", Toast.LENGTH_SHORT).show();
            }
        });

        /*Cuando se presiona el boton registrar se empieza a rrecorrer una lista que contiene los jugadores
         * que se leyeron del archivo plano donde se encuentran, para cada uno de los jugadores registrados se verifica
         * si su nombre y contraseña no estan almacenados para asi poder guardarlos*/


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nuevoJugador;

                    for(Jugador jugador : lista){
                        if(!jugador.getNombre().equals(txtNombre.getText().toString().trim()) && !jugador.getContraseña().equals(txtContraseña.getText().toString().trim())){
                            nuevoJugador = txtNombre.getText().toString() + "\n" + txtContraseña.getText().toString() + "\n";
                            try {
                                objArchivos.escribir(nuevoJugador);
                                Toast.makeText(loginJugador.this, "Jugador registrado, inicie el juego", Toast.LENGTH_SHORT).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            txtNombre.setText("");
                            txtContraseña.setText("");
                            break;
                        } else {
                            Toast.makeText(loginJugador.this, "El jugador ya se encuentra registrado, inicie el juego", Toast.LENGTH_SHORT).show();
                        }
                    }
            }
        });

    }

    private void conectar() {
        txtNombre = findViewById(R.id.txtNombre);
        txtContraseña = findViewById(R.id.txtContraseña);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnJugar = findViewById(R.id.btnJugar);
    }
}
