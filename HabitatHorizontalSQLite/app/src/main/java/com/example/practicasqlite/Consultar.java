package com.example.practicasqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Consultar extends AppCompatActivity {

    ListView lvArrendamiento;
    ArrayList<String> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        lvArrendamiento = findViewById(R.id.lvArrendamiento);
        Cargar();

        lvArrendamiento.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                String item =lvArrendamiento.getItemAtPosition(position).toString();
                int id =Integer.valueOf(item.split("\n ")[0]);
                String tipo = item.split("\n ")[1];
                double precio = Double.valueOf(item.split("\n ")[2]);
                String direccion = item.split("\n ")[3];
                String nombre = item.split("\n ")[4];
                String telefono = item.split("\n ")[5];
                String fecha = item.split("\n ")[6];
                String arrendada = item.split("\n ")[7];
                Intent intent = new Intent(getApplicationContext(), EliminarActualizar.class);
                intent.putExtra("Id", id);
                intent.putExtra("Tipo", tipo);
                intent.putExtra("Precio", precio);
                intent.putExtra("Direccion", direccion);
                intent.putExtra("Nombre", nombre);
                intent.putExtra("Telefono", telefono);
                intent.putExtra("Fecha", fecha);
                intent.putExtra("Arrendada", arrendada);
                startActivity(intent);
            }
        });

    }

    private ArrayList<String> ListaArrendamientos(){

        ArrayList<String> datos = new ArrayList<>();
        DbHelper helper = new DbHelper(this, "DB", null,1);
        SQLiteDatabase db =helper.getWritableDatabase();
        String SQL ="Select id, tipo, precio, direccion, nombre, telefono, fecha, arrendada from Arrendamiento";
        Cursor cursor = db.rawQuery(SQL, null);
        if(cursor.moveToFirst()){
            do{
                String linea = cursor.getInt(0) + "\n " + cursor.getString(1) + "\n " + cursor.getDouble(2) + "\n " +
                        cursor.getString(3) + "\n " + cursor.getString(4) + "\n " + cursor.getString(5) + "\n " +
                        cursor.getString(6) + "\n " + cursor.getString(7);
                datos.add(linea);
            } while (cursor.moveToNext());
        }
        db.close();
        return datos;
    }

    private void Cargar() {
        listado = ListaArrendamientos();
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, listado);
        lvArrendamiento.setAdapter(adapter);
    }
}
