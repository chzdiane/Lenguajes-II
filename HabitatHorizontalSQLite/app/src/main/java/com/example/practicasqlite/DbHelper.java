package com.example.practicasqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    String Tabla ="Create Table Arrendamiento (Id Integer primary key, Tipo Text, Precio Real, Direccion Text, Nombre Text, Telefono Text, Fecha Text, Arrendada Text)";

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table Arrendamiento");
        db.execSQL(Tabla);
    }
}
