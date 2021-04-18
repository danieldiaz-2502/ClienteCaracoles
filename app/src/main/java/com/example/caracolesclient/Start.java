package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedWriter;

public class Start extends AppCompatActivity {

    private Button upBtn,rightBtn, leftBtn;
    private BufferedWriter bwriter;
    private String username, jugador, avanzar;
    TCPSingleton tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        upBtn = findViewById(R.id.upBtn);
        rightBtn = findViewById(R.id.rightBtn);
        leftBtn = findViewById(R.id.leftBtn);

        tcp = TCPSingleton.getInstance();

        leftBtn.setOnClickListener(
                (v) -> {

                    Gson gson = new Gson();
                    jugador = "j1";
                    avanzar = "goLeft";
                    Coordenada coordenada = new Coordenada(avanzar, jugador);
                    String conexion = gson.toJson(coordenada);

                    sendMessage(conexion);

                }
        );

        rightBtn.setOnClickListener(
                (v) -> {

                    Gson gson = new Gson();
                    jugador = "j1";
                    avanzar = "goRight";
                    Coordenada coordenada = new Coordenada(avanzar, jugador);
                    String conexion = gson.toJson(coordenada);

                    sendMessage(conexion);

                }
        );

        upBtn.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    jugador = "j1";
                    avanzar = "goUP";
                    Coordenada coordenada = new Coordenada(avanzar, jugador);
                    String conexion = gson.toJson(coordenada);

                    sendMessage(conexion);
                }
        );



    }

    public void sendMessage(String msg) {
        tcp.enviarMensaje(msg);

    }

    

   /* public void ganador(Perder perder) {
        Log.e("message", perder.getGanar());
        switch (perder.getGanar()){
            case "Ganó J1":
                Intent s = new Intent(this, Perdiov.class);
                startActivity(s);
                Log.e("", "" + "funciono");
                break;
            case "Ganó J2":
                Intent a = new Intent(this, Perdioy.class);
                startActivity(a);
                break;
        }
    }*/
}