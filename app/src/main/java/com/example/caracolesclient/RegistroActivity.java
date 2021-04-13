package com.example.caracolesclient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombreEdit;
    private Button registrarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreEdit = findViewById(R.id.nombreEdit);
        registrarBtn = findViewById(R.id.registrarBtn);

        registrarBtn.setOnClickListener(
                (v) -> {
                    String username = nombreEdit.getText().toString();
                    Intent i = new Intent(this, Start.class);
                    SharedPreferences preferences = getSharedPreferences("username", MODE_PRIVATE);

                    preferences.edit().putString("username",username).apply();

                    startActivity(i);
        }
        );

    }
}