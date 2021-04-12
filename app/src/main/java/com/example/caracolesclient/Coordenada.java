package com.example.caracolesclient;

public class Coordenada {

    private String jugador,avanzar;

    public Coordenada(String avanzar, String jugador) {

        this.jugador = jugador;
        this.avanzar = avanzar;

    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getAvanzar() {
        return avanzar;
    }

    public void setAvanzar(String avanzar) {
        this.avanzar = avanzar;
    }
}
