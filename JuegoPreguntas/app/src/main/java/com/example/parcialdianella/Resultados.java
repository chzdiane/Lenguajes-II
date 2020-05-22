package com.example.parcialdianella;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Comparator;

public class Resultados extends AppCompatActivity {

    //En esta clase se muestra el nombre del jugador con su respectivo puntaje y asi mismo los puntajes de todos los jugadores

    String jugador;
    int puntaje;
    TextView lbNombreJugadorFinal, lbPuntajeFinal;
    ArrayAdapter adapter;
    ListView lvPuntajes;
    archivosPlanos objArchivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        conectar();
        objArchivos = new archivosPlanos(getApplication(), "puntajes.txt");

        Bundle recuperar = getIntent().getExtras();
        jugador= recuperar.getString("Clave");
        puntaje = recuperar.getInt("Clave2");

        lbNombreJugadorFinal.setText(jugador);
        lbPuntajeFinal.setText(puntaje+"");

        ArrayList<Puntaje> lista = objArchivos.leerPuntajes();
        ArrayList<String> lista2 = new ArrayList<>();

        for(Puntaje score : lista){
            String nombre = score.getNombre();
            String punt = score.getPuntaje()+"";
            lista2.add(nombre + ":" + punt);
        }

        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, lista2);
        lvPuntajes.setAdapter(adapter);

        /*ArrayList<String> lista = new ArrayList<>();
        lista.add(jugador);
        lista.add(puntaje+"");
        adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, lista);
        lvPuntajes.setAdapter(adapter);*/
    }

    private void conectar() {
        lbNombreJugadorFinal = findViewById(R.id.lbNombreJugadorFinal);
        lbPuntajeFinal = findViewById(R.id.lbPuntajeFinal);
        lvPuntajes = findViewById(R.id.lvPuntajes);
    }
}
