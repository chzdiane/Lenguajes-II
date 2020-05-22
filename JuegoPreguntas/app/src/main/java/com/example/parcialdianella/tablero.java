package com.example.parcialdianella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class tablero extends AppCompatActivity {

    String envio, respuestaCorrecta;
    TextView lbPregunta, lbNombreJugador, lbTiempo, lbPuntaje;
    Button btnOpcion1, btnOpcion2, btnOpcion3, btnPregunta1, btnPregunta2, btnPregunta3, btnPregunta4,
            btnPregunta5, btnPregunta6, btnPregunta7, btnPregunta8, btnPregunta9, btnPregunta10, btnPregunta11,
            btnPregunta12, btnPregunta13, btnPregunta14, btnPregunta15, btnPregunta16, btnPregunta17, btnPregunta18,
            btnPregunta19, btnPregunta20, boton;
    archivosPlanos objArchivos;
    ArrayList<Preguntas> listaPreguntas;
    Random random = new Random();
    CountDownTimer countDownTimer;
    int aleatorio, numPreguntas=40, posicion, puntaje, acum=0, totalbotones=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);
        conectar();

        Bundle recuperar = getIntent().getExtras();
        envio = recuperar.getString("ClaveJugador");

        lbNombreJugador.setText(envio);

        btnPregunta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta1;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();

                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta2;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta3;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta4;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta5;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta6;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta7;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta8;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta9;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta10;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta11;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta12;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta13;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta14;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta15;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta16;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta17;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta18;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta19;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

        btnPregunta20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                objArchivos = new archivosPlanos(getApplicationContext(),"PreguntasJuego.txt");
                listaPreguntas = objArchivos.leerPreguntas();
                mostrarPreguntas(listaPreguntas);
                boton = btnPregunta20;
                totalbotones--;
                if(listaPreguntas.get(posicion).getValorPregunta() == 1){
                    countDownTimer = new CountDownTimer(10000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if(listaPreguntas.get(posicion).getValorPregunta() == 2){
                    countDownTimer = new CountDownTimer(8000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 3){
                    countDownTimer = new CountDownTimer(6000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                } else if (listaPreguntas.get(posicion).getValorPregunta() == 4){
                    countDownTimer = new CountDownTimer(4000, 1000) {
                        public void onTick(long millisUntilFinished) {
                            lbTiempo.setText(String.format(Locale.getDefault(), "%d sec.", millisUntilFinished / 1000L));
                        }

                        public void onFinish() {
                            boton.setBackgroundColor(Color.RED);
                            boton.setEnabled(false);
                            lbTiempo.setText("Done.");
                            listaPreguntas.remove(posicion);
                            tableroLleno();
                        }
                    }.start();
                }
                esCorrecta(listaPreguntas);
                tableroLleno();
            }
        });

    }

    public void esCorrecta(ArrayList<Preguntas> lista2){
        btnOpcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                if(btnOpcion1.getText().toString().equals(respuestaCorrecta)){
                    boton.setBackgroundColor(Color.GREEN);
                    if(puntaje == 1){
                        acum+=2;
                    } else if(puntaje == 2){
                        acum+=4;
                    } else if(puntaje == 3){
                        acum+=7;
                    } else {
                        acum+=10;
                    }
                    lbPuntaje.setText(acum+"");
                } else {
                    boton.setBackgroundColor(Color.RED);
                }
                boton.setEnabled(false);
                listaPreguntas.remove(posicion);
            }
        });

        btnOpcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                if(btnOpcion2.getText().toString().equals(respuestaCorrecta)){
                    boton.setBackgroundColor(Color.GREEN);
                    if(puntaje == 1){
                        acum+=2;
                    } else if(puntaje == 2){
                        acum+=4;
                    } else if(puntaje == 3){
                        acum+=7;
                    } else {
                        acum+=10;
                    }
                    lbPuntaje.setText(acum+"");
                } else {
                    boton.setBackgroundColor(Color.RED);
                }
                boton.setEnabled(false);
                listaPreguntas.remove(posicion);
            }
        });

        btnOpcion3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.cancel();
                if(btnOpcion3.getText().toString().equals(respuestaCorrecta)){
                    boton.setBackgroundColor(Color.GREEN);
                    if(puntaje == 1){
                        acum+=2;
                    } else if(puntaje == 2){
                        acum+=4;
                    } else if(puntaje == 3){
                        acum+=7;
                    } else {
                        acum+=10;
                    }
                    lbPuntaje.setText(acum+"");
                } else {
                    boton.setBackgroundColor(Color.RED);
                }
                boton.setEnabled(false);
                listaPreguntas.remove(posicion);
            }
        });
    }

    private void tableroLleno(){

        String nuevoPuntaje;
        objArchivos = new archivosPlanos(this,"puntajes.txt");

        if(totalbotones == 0){
            nuevoPuntaje = envio + "\n" + acum + "\n";
            try {
                objArchivos.escribir(nuevoPuntaje);
            } catch (IOException e){
                e.printStackTrace();
            }

            Intent intent = new Intent(getApplicationContext(),Resultados.class);
            intent.putExtra("Clave", envio);
            intent.putExtra("Clave2", acum);
            startActivity(intent);
        }
    }

    public void mostrarPreguntas(ArrayList<Preguntas> lista){

        aleatorio= random.nextInt(numPreguntas-1);
        posicion = aleatorio;

        lbPregunta.setText(lista.get(aleatorio).getPregunta());
        btnOpcion1.setText(lista.get(aleatorio).getOpcion1());
        btnOpcion2.setText(lista.get(aleatorio).getOpcion2());
        btnOpcion3.setText(lista.get(aleatorio).getOpcion3());
        respuestaCorrecta = lista.get(aleatorio).getOpcionCorrecta();
        puntaje = lista.get(aleatorio).getValorPregunta();

    }

    private void conectar() {
        lbPregunta= findViewById(R.id.lbPregunta);
        lbNombreJugador = findViewById(R.id.lbNombreJugador);
        lbTiempo = findViewById(R.id.lbTiempo);
        lbPuntaje = findViewById(R.id.lbPuntaje);
        btnOpcion1 = findViewById(R.id.btnOpcion1);
        btnOpcion2 = findViewById(R.id.btnOpcion2);
        btnOpcion3 = findViewById(R.id.btnOpcion3);
        btnPregunta1 = findViewById(R.id.btnPregunta1);
        btnPregunta2 = findViewById(R.id.btnPregunta2);
        btnPregunta3 = findViewById(R.id.btnPregunta3);
        btnPregunta4 = findViewById(R.id.btnPregunta4);
        btnPregunta5 = findViewById(R.id.btnPregunta5);
        btnPregunta6 = findViewById(R.id.btnPregunta6);
        btnPregunta7 = findViewById(R.id.btnPregunta7);
        btnPregunta8 = findViewById(R.id.btnPregunta8);
        btnPregunta9 = findViewById(R.id.btnPregunta9);
        btnPregunta10 = findViewById(R.id.btnPregunta10);
        btnPregunta11 = findViewById(R.id.btnPregunta11);
        btnPregunta12 = findViewById(R.id.btnPregunta12);
        btnPregunta13 = findViewById(R.id.btnPregunta13);
        btnPregunta14 = findViewById(R.id.btnPregunta14);
        btnPregunta15 = findViewById(R.id.btnPregunta15);
        btnPregunta16 = findViewById(R.id.btnPregunta16);
        btnPregunta17 = findViewById(R.id.btnPregunta17);
        btnPregunta18 = findViewById(R.id.btnPregunta18);
        btnPregunta19 = findViewById(R.id.btnPregunta19);
        btnPregunta20 = findViewById(R.id.btnPregunta20);
    }
}
