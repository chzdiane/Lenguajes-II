package com.example.practicasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sentencias extends AppCompatActivity {

    Button btnTotalUnidades, btnArrendadas, btnDisponibles, btnMejorCliente, btnPromedio, btnUnidadMasComun, btnDiaEspecifico;
    TextView lbResultados;
    EditText txtFechaConsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentencias);
        conectar();

        btnTotalUnidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uniRecibidas();
            }
        });

        btnArrendadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uniArrendadas();
            }
        });

        btnDisponibles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uniDisponibles();
            }
        });

        btnMejorCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clienteMayor();
            }
        });

        btnPromedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valorPromedio();
            }
        });

        btnUnidadMasComun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viviendaMasComun();
            }
        });

        btnDiaEspecifico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrendadasDiaEspecifico(txtFechaConsulta.getText().toString());
            }
        });
    }

    private void uniRecibidas(){

        String total="";
        DbHelper helper = new DbHelper(this, "DB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select count(*) from Arrendamiento";
        Cursor cursor = db.rawQuery(SQL,null);
        if(cursor.moveToFirst()){
            do{
                total = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        db.close();
        lbResultados.setText("La cantidad de unidades habitacionales recibidas por la empresa son: "+total);
    }

    private void uniArrendadas(){
        String total="";
        DbHelper helper = new DbHelper(this, "DB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select count(id) from Arrendamiento where arrendada = 'si' ";
        Cursor cursor = db.rawQuery(SQL,null);
        if(cursor.moveToFirst()){
            do{
                total = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        db.close();
        lbResultados.setText("La cantidad de unidades arrendadas es de: " + total);
    }

    private void uniDisponibles(){
        String total ="";
        DbHelper helper = new DbHelper(this, "DB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select count(id) from Arrendamiento where arrendada = 'no' ";
        Cursor cursor = db.rawQuery(SQL,null);
        if(cursor.moveToFirst()){
            do{
                total = cursor.getString(0);
            } while (cursor.moveToNext());
        }
        db.close();
        lbResultados.setText("La cantidad de unidades disponibles es de: " + total);
    }

    private void clienteMayor(){
        String total ="";
        DbHelper helper = new DbHelper(this, "DB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select Nombre, Telefono, COUNT(Nombre) as Total from Arrendamiento GROUP BY Nombre ORDER BY Total DESC limit 1";
        Cursor cursor = db.rawQuery(SQL,null);
        if(cursor.moveToFirst()){
            do{
                total = "Nombre propietario: " + cursor.getString(0) + " Telefono: " + cursor.getString(1) +
                        "Habitaciones arrendadas: " + cursor.getString(2);
            } while (cursor.moveToNext());
        }
        db.close();
        lbResultados.setText(total);
    }

    private void valorPromedio(){
        double total = 0;
        DbHelper helper = new DbHelper(this, "DB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select AVG(Precio) from Arrendamiento";
        Cursor cursor = db.rawQuery(SQL,null);
        if(cursor.moveToFirst()){
            do{
                total = cursor.getDouble(0);
            } while (cursor.moveToNext());
        }
        db.close();
        lbResultados.setText("El valor promedio de los arriendos es de: " + total);
    }

    private void arrendadasDiaEspecifico(String dia){
        String total="";
        DbHelper helper = new DbHelper(this, "DB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "Select * from Arrendamiento where Fecha = '"+ dia +"'";
        Cursor cursor = db.rawQuery(SQL,null);
        if(cursor.moveToFirst()){
            do{
                total = cursor.getInt(0) + " " + cursor.getString(1) + " " + cursor.getDouble(2) + " " +
                        cursor.getString(3) + " " + cursor.getString(4) + " " + cursor.getString(5) + " " +
                        cursor.getString(6) + " " + cursor.getString(7);
            } while (cursor.moveToNext());
        }
        db.close();
        lbResultados.setText(total);
    }

    private void viviendaMasComun(){
        String total="";
        DbHelper helper = new DbHelper(this, "DB",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String SQL = "SELECT Tipo, COUNT(Id) AS Total FROM Arrendamiento GROUP BY Tipo ORDER BY Total DESC limit 1";
        Cursor cursor = db.rawQuery(SQL,null);
        if(cursor.moveToFirst()){
            do{
                total = "Tipo: " + cursor.getString(0) + "Total: " + cursor.getString(1);
            } while(cursor.moveToNext());
        }
        db.close();
        lbResultados.setText(total);
    }

    private void conectar() {
        btnTotalUnidades = findViewById(R.id.btnTotalUnidades);
        btnArrendadas = findViewById(R.id.btnArrendadas);
        btnDisponibles = findViewById(R.id.btnDisponibles);
        btnMejorCliente = findViewById(R.id.btnMejorCliente);
        btnPromedio = findViewById(R.id.btnPromedio);
        btnUnidadMasComun = findViewById(R.id.btnUnidadMasComun);
        btnDiaEspecifico = findViewById(R.id.btnDiaEspecifico);
        lbResultados = findViewById(R.id.lbResultados);
        txtFechaConsulta = findViewById(R.id.txtFechaConsulta);
    }
}
