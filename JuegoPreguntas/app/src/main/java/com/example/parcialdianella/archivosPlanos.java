package com.example.parcialdianella;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class archivosPlanos {

    /*En esta clase hay dos tipos de metodos diferentes, el metodo "escribir" el cual escribe en el archivo plano
    * cualquier dato que se le mande con el fos o FileOutputStream y los metodos leer los cuales recorren el archivo plano
    * y almacenan los datos de este en un ArrayList de forma ordenada, es decir, linea por lineal del archivo, esto se hace
    * con el metodo fis o FileInputStream*/

    String Archivo;
    Context ctx;
    FileOutputStream fos;
    FileInputStream fis;

    public archivosPlanos(Context ctx, String archivo){
        this.ctx = ctx;
        this.Archivo =archivo;
    }

    public void escribir(String textoArchivo) throws IOException{
        try{
            fos =ctx.openFileOutput(Archivo, Context.MODE_APPEND);
            fos.write(textoArchivo.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            Log.e("",e.getMessage());
        }catch (IOException ex) {
            Log.e("", ex.getMessage());
        }
    }

    public ArrayList<Jugador> leerJugadores(){
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        String nombre ="", contraseña ="", lectura="";
        int contador=0, i=1;
        char caracter;

        try{
            fis =ctx.openFileInput("Jugadores.txt");
            while (i > 0){
                i = fis.read();
                caracter = (char)i;
                lectura += caracter;
                if(i=='\n'){
                    switch (contador){
                        case 0:
                            nombre =lectura.trim();
                            break;
                        case 1:
                            contraseña = lectura.trim();
                            contador=-1;
                            listaJugadores.add(new Jugador(nombre,contraseña));
                            break;
                    }
                    lectura="";
                    contador++;
                }
            }

        } catch (Exception e){
            Log.e("",e.getMessage());
        }
        return listaJugadores;
    }

    public ArrayList<Admin> leerAdministradores(){
        ArrayList<Admin> listaAdministradores = new ArrayList<>();
        String nombre ="", contraseña ="", lectura="";
        int contador=0, i=1;
        char caracter;

        try{
            fis =ctx.openFileInput("administrador.txt");
            while (i > 0){
                i = fis.read();
                caracter = (char)i;
                lectura += caracter;
                if(i=='\n'){
                    switch (contador){
                        case 0:
                            nombre =lectura.trim();
                            break;
                        case 1:
                            contraseña = lectura.trim();
                            contador=-1;
                            listaAdministradores.add(new Admin(nombre,contraseña));
                            break;
                    }
                    lectura="";
                    contador++;
                }
            }

        } catch (Exception e){
            Log.e("",e.getMessage());
        }
        return listaAdministradores;
    }

    public ArrayList<Puntaje> leerPuntajes(){
        ArrayList<Puntaje> listaPuntajes = new ArrayList<>();
        String nombre ="", puntaje ="", lectura="";
        int contador=0, i=1;
        char caracter;

        try{
            fis =ctx.openFileInput("puntajes.txt");
            while (i > 0){
                i = fis.read();
                caracter = (char)i;
                lectura += caracter;
                if(i=='\n'){
                    switch (contador){
                        case 0:
                            nombre =lectura.trim();
                            break;
                        case 1:
                            puntaje = lectura.trim();
                            contador=-1;
                            listaPuntajes.add(new Puntaje(nombre,puntaje));
                            break;
                    }
                    lectura="";
                    contador++;
                }
            }

        } catch (Exception e){
            Log.e("",e.getMessage());
        }
        return listaPuntajes;
    }

    public ArrayList<Preguntas> leerPreguntas(){
        ArrayList<Preguntas> listaPreguntas = new ArrayList<>();
        String pregunta="", opcion1="", opcion2="", opcion3="", opcionCorrecta="";
        int valorPregunta, contador=0;
        String lectura="";
        int i=1;
        char caracter;

        try{
            fis =ctx.openFileInput("PreguntasJuego.txt");
            while(i > 0){
                i= fis.read();
                caracter=(char)i;
                lectura +=caracter;
                if(i=='\n'){
                    switch (contador){
                        case 0:
                            pregunta = lectura.trim();
                            break;
                        case 1:
                            opcion1 = lectura.trim();
                            break;
                        case 2:
                            opcion2 = lectura.trim();
                            break;
                        case 3:
                            opcion3 = lectura.trim();
                            break;
                        case 4:
                            opcionCorrecta = lectura.trim();
                            break;
                        case 5:
                            valorPregunta = Integer.parseInt(lectura.trim());
                            contador=-1;
                            listaPreguntas.add(new Preguntas(pregunta, opcion1, opcion2, opcion3, opcionCorrecta, valorPregunta));
                            break;
                    }
                    lectura="";
                    contador++;
                }
            }
        } catch (Exception e){
            Log.e("", e.getMessage());
        }
        return listaPreguntas;
    }

}
