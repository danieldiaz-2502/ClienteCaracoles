package com.example.caracolesclient;

public class Coordenada {

    private int posx, posy, vel;

    public Coordenada(int posx, int posy, int vel) {
        this.posx = posx;
        this.posy = posy;
        this.vel = vel;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public int getVel() {
        return vel;
    }

    public void setVel(int vel) {
        this.vel = vel;
    }
}
