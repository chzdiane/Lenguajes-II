package com.example.parcialdianella;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class accionAdmin extends AppCompatActivity {

    EditText txtPregunta, txtNuevaPregunta, txtOpcion1, txtOpcion2, txtOpcion3, txtValorPregunta, txtOpcionCorrecta;
    Button btnEditar;
    archivosPlanos objArchivos;
    String envio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accion_admin);
        conectar();

        Bundle recuperar = getIntent().getExtras();
        envio = recuperar.getString("ClaveAdmin");

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nuevaPregunta;
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                ArrayList<Preguntas> lista = objArchivos.leerPreguntas();

                for(Preguntas pregunta : lista){
                    if(pregunta.getPregunta().equals(txtPregunta.getText().toString().trim())){
                        lista.remove(pregunta);
                    }
                }
                if(txtPregunta.getText().toString() !=null && txtNuevaPregunta.toString() !=null && txtOpcion1.toString() !=null &&
                        txtOpcion2.toString() !=null && txtOpcion3.toString() !=null && txtValorPregunta.toString() !=null && txtOpcionCorrecta.toString() !=null){
                    nuevaPregunta = txtNuevaPregunta.getText().toString() + "\n" + txtOpcion1.getText().toString() + "\n" +
                            txtOpcion2.getText().toString() + "\n" + txtOpcionCorrecta.getText().toString() + "\n" +txtValorPregunta.getText().toString() + "\n";
                    try {
                        objArchivos.escribir(nuevaPregunta);
                        Toast.makeText(accionAdmin.this, "Pregunta actualizada", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    txtPregunta.setText("");
                    txtNuevaPregunta.setText("");
                    txtOpcion1.setText("");
                    txtOpcion2.setText("");
                    txtOpcion3.setText("");
                    txtOpcionCorrecta.setText("");
                    txtValorPregunta.setText("");
                }
            }
        });
    }

    private void conectar() {
        txtPregunta = findViewById(R.id.txtPregunta);
        txtNuevaPregunta = findViewById(R.id.txtNuevaPregunta);
        txtOpcion1 = findViewById(R.id.txtOpcion1);
        txtOpcion2 = findViewById(R.id.txtOpcion2);
        txtOpcion3 = findViewById(R.id.txtOpcion3);
        txtOpcionCorrecta = findViewById(R.id.txtOpcionCorrecta);
        txtValorPregunta = findViewById(R.id.txtvalorPregunta);
        btnEditar = findViewById(R.id.btnEditar);
    }
}
