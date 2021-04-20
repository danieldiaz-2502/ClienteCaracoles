package com.example.caracolesclient;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSingleton extends Thread{

    private Socket socket;
    private BufferedWriter bwriter;


    private static TCPSingleton unicainstancia;

    public static TCPSingleton getInstance(){
        if(unicainstancia == null){
            unicainstancia = new TCPSingleton();
            unicainstancia.start();
        }
        return unicainstancia;
    }

    @Override
    public void run(){

    }


    private TCPSingleton() {
        new Thread(
                () -> {
                    try {
                        socket = new Socket("192.168.0.7", 6000);


                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();


                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        bwriter = new BufferedWriter(osw);
                        Log.e("mensaje", " " + bwriter);



                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

    }

    public void enviarMensaje(String msg){
        new Thread(() -> {
            try {
                bwriter.write(msg + "\n");
                bwriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
