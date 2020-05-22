package com.example.parcialdianella;

public class Admin {
    private String nombre;
    private String contraseña;

    //En esta clase se encapsulan e inicializan los datos del administrador

    public Admin(String nombre, String contraseña){
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
