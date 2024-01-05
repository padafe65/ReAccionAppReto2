package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgot_password extends AppCompatActivity {
    private Button recuperarUsua;
    private EditText inputEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        recuperarUsua = findViewById(R.id.btnRecuperar);
        inputEmail = findViewById(R.id.inpEmailUsuario);
        recuperarUsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(forgot_password.this, Inicio.class);
                Toast.makeText(forgot_password.this, "Está de regreso a la interfaz de inicio de sesíon", Toast.LENGTH_SHORT).show();
                startActivity(inicio);
            }
        });
    }
}