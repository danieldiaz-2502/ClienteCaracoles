package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button inicioBtn, insBtn, upBtn, leftBtn;
    private int posy, posx, vel;
    private String username, jugador, avanzar;
    TCPSingleton tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicioBtn = findViewById(R.id.inicioBtn);
        insBtn = findViewById(R.id.insBtn);
        upBtn = findViewById(R.id.upBtn);
        leftBtn = findViewById(R.id.leftBtn);


        inicioBtn.setOnClickListener(this);
        insBtn.setOnClickListener(this);

        tcp = TCPSingleton.getInstance();


        username = getSharedPreferences("username", MODE_PRIVATE).getString("username", "NO USER");

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.inicioBtn:

                Intent a = new Intent(this, RegistroActivity.class);
                startActivity(a);
                break;

            case R.id.insBtn:

                Intent r = new Intent(this,Instrucciones.class);
                startActivity(r);
                break;
        }
    }

    public void sendMessage(String msg) {
        tcp.enviarMensaje(msg);

    }


}