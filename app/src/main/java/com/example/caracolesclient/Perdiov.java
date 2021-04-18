package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Perdiov extends AppCompatActivity implements View.OnClickListener{

    private Button ioBtn, exitBtn;
    private TCPSingleton tcp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdio);

        ioBtn = findViewById(R.id.ioBtn);
        exitBtn = findViewById(R.id.exitBtn);
        tcp = TCPSingleton.getInstance();
        ioBtn.setOnClickListener(this);
        exitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ioBtn:
                Intent s = new Intent(this,Start.class);
                startActivity(s);
                break;
            case R.id.exitBtn:
                finish();

        }
    }
}