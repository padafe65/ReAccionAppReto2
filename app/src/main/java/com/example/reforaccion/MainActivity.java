package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button comenzar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //icono en action bar
        //File archivo = ArchivosManager.CrearArchivo(getFilesDir(), "datos.txt");
        ArchivosManager.CrearArchivo(getFilesDir(), "datos.txt");
        ArchivosManager.CrearArchivo(getFilesDir(), "arbol.txt");
        //ArchivosManager.EscrituraArchivo(archivo, "Este es un archivo de prueba");
        //ArchivosManager.lecturaArchivo(archivo);
        //ArchivosManager.editarArchivo(archivo,"Nueva linea");
        //ArchivosManager.lecturaArchivo(archivo);

        comenzar = findViewById(R.id.btnComenzar);
        comenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sesion = new Intent(MainActivity.this, Inicio.class);
                Toast.makeText(MainActivity.this, "Acaba de entrar a la interfaz de inicio de sesíon", Toast.LENGTH_SHORT).show();
                startActivity(sesion);
            }
        });
    }
}