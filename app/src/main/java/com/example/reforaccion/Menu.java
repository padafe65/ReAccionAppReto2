package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {
    ImageButton salida;
    Button categorias, consejos, estadisticas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        salida = findViewById(R.id.imgbSalida);
        categorias = findViewById(R.id.btnCategorias);
        consejos = findViewById(R.id.btnConsejos);
        estadisticas = findViewById(R.id.btnEstadistica);

        consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Menu.this, Consejos1.class);
                startActivity(i);
            }
        });

        salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salir = new Intent(Menu.this,Inicio.class);
                startActivity(salir);
            }
        });
        categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent categoria = new Intent(Menu.this,Registro.class);
                startActivity(categoria);
            }
        });
        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent estadistica = new Intent(Menu.this,Estadistica.class);
                startActivity(estadistica);
            }
        });


    }
}