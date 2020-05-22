package com.example.parcialdianella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class administrador extends AppCompatActivity {

    String envio;
    EditText txtNombreAdministrador, txtContraseñaAdministrador;
    Button btnRegistrarAdmin;
    archivosPlanos objArchivos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrador);

        objArchivos = new archivosPlanos(this,"Jugadores.txt");
        conectar();

        Bundle recuperar = getIntent().getExtras();
        envio = recuperar.getString("Clave");

        /*En esta clase se valida que exista el administrador ingresado usando un ArrayList que
        almacena los datos de todos los administradores, esto se hace con un ciclo for que recorre
        administrador por administrador validando que la informacion sea correcta para darle ingreso*/

        btnRegistrarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Admin> lista = objArchivos.leerAdministradores();
                String nombreAdmin;

                for (Admin administrador : lista) {
                    if(administrador.getNombre().equals(txtNombreAdministrador.getText().toString().trim()) && administrador.getContraseña().equals(txtContraseñaAdministrador.getText().toString().trim())){
                        nombreAdmin = administrador.getNombre();
                        Intent intent = new Intent(getApplicationContext(),accionAdmin.class);
                        intent.putExtra("ClaveAdmin", nombreAdmin);
                        startActivity(intent);
                        txtNombreAdministrador.setText("");
                        txtContraseñaAdministrador.setText("");
                    } else {
                        Toast.makeText(administrador.this, "Administrador incorrecto", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    private void conectar() {
        txtNombreAdministrador = findViewById(R.id.txtNombreAdministrador);
        txtContraseñaAdministrador = findViewById(R.id.txtContraseñaAdministrador);
        btnRegistrarAdmin = findViewById(R.id.btnRegistrarAdmin);
    }
}
