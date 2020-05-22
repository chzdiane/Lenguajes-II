package com.example.practicasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Insertar extends AppCompatActivity {

    EditText txtTipo, txtPrecio, txtDireccion, txtNombre, txtTelefono, txtFecha, txtArrendada;
    Button btnInsertar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        conectar();

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validacion() == true){
                    Guardar(txtTipo.getText().toString(), Double.parseDouble(txtPrecio.getText().toString()) , txtDireccion.getText().toString(), txtNombre.getText().toString(),
                            txtTelefono.getText().toString(), txtFecha.getText().toString(), txtArrendada.getText().toString());
                }
            }
        });
    }

    private boolean validacion(){
        if(txtTipo.getText().toString().isEmpty() || txtPrecio.getText().toString().isEmpty() || txtDireccion.getText().toString().isEmpty() || txtNombre.getText().toString().isEmpty()||
                txtTelefono.getText().toString().isEmpty() || txtFecha.getText().toString().isEmpty()|| txtArrendada.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe llenar todos los campos para ingresar", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }


    private void Guardar(String Tipo, double Precio, String Direccion, String Nombre, String Telefono, String Fecha, String Arrendada){

        DbHelper helper =new DbHelper(this, "DB", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues cv = new ContentValues();
            cv.put("Tipo", Tipo);
            cv.put("Precio", Precio);
            cv.put("Direccion", Direccion);
            cv.put("Nombre", Nombre);
            cv.put("Telefono", Telefono);
            cv.put("Fecha", Fecha);
            cv.put("Arrendada", Arrendada);
            db.insert("Arrendamiento", null, cv);
            db.close();
            Toast.makeText(this,"Registro Insertado" , Toast.LENGTH_LONG).show();

        } catch (Exception ex){
            Toast.makeText(this,"Error" + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void conectar() {
        txtTipo = findViewById(R.id.txtTipo);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtDireccion = findViewById(R.id.txtDireccion);
        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtFecha = findViewById(R.id.txtFecha);
        txtArrendada = findViewById(R.id.txtArrendada);
        btnInsertar = findViewById(R.id.btnInsertar);
    }
}
