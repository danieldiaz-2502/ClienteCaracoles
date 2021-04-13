package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Perdio extends AppCompatActivity {

    private Button ioBtn, exitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdio);

        ioBtn = findViewById(R.id.ioBtn);
        exitBtn = findViewById(R.id.exitBtn);

    }
}