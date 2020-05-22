package com.example.parcialdianella;

public class Jugador {

    //En esta clase se encapsulan e inicializan los datos del Jugador

    private String nombre;
    private String contraseña;

    public Jugador(String nombre, String contraseña){
        this.nombre=nombre;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
