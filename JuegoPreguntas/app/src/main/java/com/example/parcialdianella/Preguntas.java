package com.example.parcialdianella;

public class Preguntas {

    /*En esta clase se inicializan y encapsulan todos los atributos de las preguntas*/

    private String pregunta;
    private String opcion1;
    private String opcion2;
    private String opcion3;
    private String opcionCorrecta;
    private int valorPregunta;

    public Preguntas(String pregunta, String opcion1, String opcion2, String opcion3, String opcionCorrecta, int valorPregunta){
        this.setPregunta(pregunta);
        this.setOpcion1(opcion1);
        this.setOpcion2(opcion2);
        this.setOpcion3(opcion3);
        this.setOpcionCorrecta(opcionCorrecta);
        this.setValorPregunta(valorPregunta);
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(String opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public int getValorPregunta() {
        return valorPregunta;
    }

    public void setValorPregunta(int valorPregunta) {
        this.valorPregunta = valorPregunta;
    }
}
