package com.example.practicasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EliminarActualizar extends AppCompatActivity {

    EditText txtTipoEA, txtPrecioEA, txtDireccionEA, txtNombreEA, txtTelefonoEA, txtfechaEA, txtArrendadaEA;
    Button btnEliminar, btnActualizar, btnVerCambios;
    int id;
    String tipo, direccion, nombre, telefono, fecha, arrendada;
    double precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_actualizar);
        conectar();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            id =bundle.getInt("Id");
            tipo = bundle.getString("Tipo");
            precio = bundle.getDouble("Precio");
            direccion = bundle.getString("Direccion");
            nombre = bundle.getString("Nombre");
            telefono = bundle.getString("Telefono");
            fecha = bundle.getString("Fecha");
            arrendada = bundle.getString("Arrendada");

            txtTipoEA.setText(tipo);
            txtPrecioEA.setText(String.valueOf(precio));
            txtDireccionEA.setText(direccion);
            txtNombreEA.setText(nombre);
            txtTelefonoEA.setText(telefono);
            txtfechaEA.setText(fecha);
            txtArrendadaEA.setText(arrendada);
        }

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validacion()==true){
                    Actualizar(id, txtTipoEA.getText().toString(), Double.parseDouble(txtPrecioEA.getText().toString()) , txtDireccionEA.getText().toString(), txtNombreEA.getText().toString(),
                            txtTelefonoEA.getText().toString(), txtfechaEA.getText().toString(), txtArrendadaEA.getText().toString());
                }
            }
        });

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Eliminar(id);
            }
        });

        btnVerCambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(), Consultar.class);
                startActivity(intent);
            }
        });

    }

    private boolean validacion(){
        if(txtTipoEA.getText().toString().isEmpty() || txtPrecioEA.getText().toString().isEmpty() || txtDireccionEA.getText().toString().isEmpty() || txtNombreEA.getText().toString().isEmpty()||
                txtTelefonoEA.getText().toString().isEmpty() || txtfechaEA.getText().toString().isEmpty()|| txtArrendadaEA.getText().toString().isEmpty()){
            Toast.makeText(this, "Debe llenar todos los campos para ingresar", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    private void Eliminar(int Id){

        DbHelper helper = new DbHelper(this, "DB", null, 1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "delete from Arrendamiento where Id = " + Id;
        Toast.makeText(getApplicationContext(), "Cambios realizados con exito", Toast.LENGTH_LONG).show();
        db.execSQL(SQL);
        db.close();
    }

    private void Actualizar(int Id, String Tipo, double Precio, String Direccion, String Nombre, String Telefono, String Fecha, String Arrendada){

        DbHelper helper = new DbHelper(this,"DB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Update Arrendamiento set Tipo = '" + Tipo +"', Precio = '" + Precio + "',Direccion = '" + Direccion + "', Nombre = '" + Nombre +"', " +
                "Telefono = '" + Telefono + "', Fecha = '" + Fecha + "', Arrendada = '" + Arrendada +"' Where Id = " +Id;
        Toast.makeText(getApplicationContext(), "Cambios realizados con exito", Toast.LENGTH_LONG).show();
        db.execSQL(SQL);
        db.close();
    }

    private void conectar() {
        txtTipoEA = findViewById(R.id.txtTipoEA);
        txtPrecioEA = findViewById(R.id.txtPrecioEA);
        txtDireccionEA = findViewById(R.id.txtDireccionEA);
        txtNombreEA = findViewById(R.id.txtNombreEA);
        txtTelefonoEA = findViewById(R.id.txtTelefonoEA);
        txtfechaEA = findViewById(R.id.txtFechaEA);
        txtArrendadaEA = findViewById(R.id.txtArrendadaEA);
        btnEliminar = findViewById(R.id.btnEliminar);
        btnActualizar = findViewById(R.id.btnActualizar);
        btnVerCambios = findViewById(R.id.btnVerCambios);
    }
}
