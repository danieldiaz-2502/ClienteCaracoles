package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Gano extends AppCompatActivity {

    private Button vjBtn, exBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gano);

        vjBtn = findViewById(R.id.vjBtn);
        exBtn = findViewById(R.id.exBtn);
    }
}