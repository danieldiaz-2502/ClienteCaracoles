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
    private String jugador, avanzar, username;
    TCPSingleton tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        upBtn = findViewById(R.id.upBtn);
        rightBtn = findViewById(R.id.rightBtn);
        leftBtn = findViewById(R.id.leftBtn);

        tcp = TCPSingleton.getInstance();
        username = getSharedPreferences("username", MODE_PRIVATE).getString("username", "NO USER");

        leftBtn.setOnClickListener(
                (v) -> {

                    Gson gson = new Gson();
                    jugador = username;
                    avanzar = "goLeft";
                    Coordenada coordenada = new Coordenada(avanzar, jugador);
                    String conexion = gson.toJson(coordenada);

                    sendMessage(conexion);

                }
        );

        rightBtn.setOnClickListener(
                (v) -> {

                    Gson gson = new Gson();
                    jugador = username;
                    avanzar = "goRight";
                    Coordenada coordenada = new Coordenada(avanzar, jugador);
                    String conexion = gson.toJson(coordenada);

                    sendMessage(conexion);

                }
        );

        upBtn.setOnClickListener(
                (v) -> {
                    Gson gson = new Gson();
                    jugador = username;
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


}