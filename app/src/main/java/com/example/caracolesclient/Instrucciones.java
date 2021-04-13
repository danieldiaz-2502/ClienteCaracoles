package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instrucciones extends AppCompatActivity implements View.OnClickListener {

    private Button ibackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucciones);

        ibackBtn = findViewById(R.id.ibackBtn);

        ibackBtn.setOnClickListener(this);
    }
    public void onClick(View v) {
        finish();
    }

}