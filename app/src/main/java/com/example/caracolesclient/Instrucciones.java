package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Instrucciones extends AppCompatActivity {

    private Button ibackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);

        ibackBtn = findViewById(R.id.ibackBtn);
    }
}