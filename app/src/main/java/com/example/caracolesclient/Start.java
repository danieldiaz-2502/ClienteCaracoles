package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Start extends AppCompatActivity {

    private Button upBtn,rightBtn, leftBtn;
    private BufferedWriter bwriter;
    private String username, jugador, avanzar;
    private TCPSingleton tcp;

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

}