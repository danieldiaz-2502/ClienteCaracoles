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

public class MainActivity extends AppCompatActivity {

    private Button avanzarBtn,habilidadBtn;
    private BufferedWriter bwriter;
    private int posy, posx, vel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        avanzarBtn = findViewById(R.id.avanzarBtn);
        habilidadBtn = findViewById(R.id.habilidadBtn);

        new Thread(
                ()-> {
                    try {
                        Socket socket = new Socket("192.168.1.1", 5000);
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bwriter = new BufferedWriter(osw);
                        Log.e("mensaje"," "+ bwriter);
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

        avanzarBtn.setOnClickListener(
                (v) -> {
                }
        );
        habilidadBtn.setOnClickListener(
                (v) -> {
                }
        );

    }

    public void initClient() {
        //se envia el recordatorio en un json
        Gson gson = new Gson();
        Coordenada coordenada = new Coordenada(posx, posy, vel);
        String conexion = gson.toJson(coordenada);

        new Thread(()-> {
            try {
                //se hace el envio como tal
                bwriter.write(conexion+"\n");
                bwriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}