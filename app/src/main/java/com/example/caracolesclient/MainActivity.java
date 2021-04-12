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

    private Button upBtn,rightBtn, leftBtn;
    private BufferedWriter bwriter;
    private int posy, posx, vel;
    private String username, jugador, avanzar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        upBtn = findViewById(R.id.upBtn);
        rightBtn = findViewById(R.id.rightBtn);
        leftBtn = findViewById(R.id.leftBtn);

        username = getSharedPreferences("username",MODE_PRIVATE).getString("username", "NO USER");

        new Thread(
                ()-> {
                    try {
                        Socket socket = new Socket("192.168.0.10", 5000);
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

        leftBtn.setOnClickListener(
                (v) -> {

                    Gson gson = new Gson();
                    jugador = "j1";
                    avanzar = "si";
                    Coordenada coordenada = new Coordenada(avanzar, jugador);
                    String conexion = gson.toJson(coordenada);
                    
                    sendMessage(conexion);

                }
        );
        upBtn.setOnClickListener(
                (v) -> {
                }
        );

    }

    public void sendMessage(String msg) {

        new Thread(()-> {
            try {
                bwriter.write(msg +"\n");
                bwriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}