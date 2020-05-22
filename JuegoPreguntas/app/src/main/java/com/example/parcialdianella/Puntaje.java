package com.example.parcialdianella;

public class Puntaje {

    private String nombre;
    private String puntaje;

    //En esta clase se encapsulan e inicializan los datos de los puntajes

    public Puntaje(String nombre, String puntaje){
        this.setNombre(nombre);
        this.setPuntaje(puntaje);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }
}
