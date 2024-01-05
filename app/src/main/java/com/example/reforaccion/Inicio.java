package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Inicio extends AppCompatActivity {
    private Button inicio;
    EditText inpUsuario, inpPassword1;

    ArrayList<Usuario> usuarios = new ArrayList<>();
    private TextView tv_registrarse, tv_recuperar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        Toast.makeText(this, "Acaba de entrar a la interfaz de inicio de sesíon", Toast.LENGTH_SHORT).show();
        inicio = findViewById(R.id.btnIngresar);
        tv_registrarse = findViewById(R.id.registro);
        tv_recuperar = findViewById(R.id.forgot);
        inpUsuario = findViewById(R.id.inpNombreUsuario);
        inpPassword1 = findViewById(R.id.inpZona);
        Intent menu = new Intent(Inicio.this, Menu.class);

        usuarios = leerArchivo();

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Verificar si se han ingresado datos de usuario y contraseña
                if (!inpUsuario.getText().toString().isEmpty() && !inpPassword1.getText().toString().isEmpty()) {
                    String inputUsuario = inpUsuario.getText().toString();
                    String inputPassword = inpPassword1.getText().toString();

                    // Buscar el usuario coincidente en la lista de usuarios
                    for (Usuario usuario : usuarios) {
                        if (usuario.getPassword().equals(inputPassword)) {
                            if (usuario.getNickname().equals(inputUsuario) || usuario.getEmail().equals(inputUsuario) || usuario.getNombre().equals(inputUsuario)) {
                                // Si se encuentra una coincidencia, iniciar la actividad principal y salir del bucle
                                Toast.makeText(Inicio.this, "Acaba de entrar a la interfaz de menú", Toast.LENGTH_SHORT).show();
                                startActivity(menu);
                                return;
                            }
                        }
                    }
                    // Si no se encontró una coincidencia, mostrar un mensaje de error utilizando Toast
                    Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
        tv_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registra = new Intent(Inicio.this, registrar_usuario.class);
                Toast.makeText(Inicio.this, "Acaba de entrar a la interfaz de inicio de sesíon", Toast.LENGTH_SHORT).show();
                startActivity(registra);
            }
        });
        tv_recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recupera = new Intent(Inicio.this, forgot_password.class);
                Toast.makeText(Inicio.this, "Acaba de entrar a la interfaz de inicio de sesíon", Toast.LENGTH_SHORT).show();
                startActivity(recupera);
            }
        });
    }

    public ArrayList<Usuario> leerArchivo(){
        // Leer los datos del archivo
        File file = new File(getFilesDir(), "datos.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                // Dividir la línea en los datos del usuario separados por comas
                String[] userData = line.split(",");
                String nombre = userData[0];
                String nickname = userData[1];
                String correo = userData[2];
                String passwordData = userData[3];
                // Crear un objeto Usuario y añadirlo a la lista de usuarios
                Usuario nuevoUsuario = new Usuario(nombre, nickname, correo, passwordData);
                usuarios.add(nuevoUsuario);
            }
            reader.close();

            // Imprimir información de los usuarios leídos en el archivo
            for (Usuario usuario : usuarios) {
                Log.d("Usuarios",
                        "Nombre: " + usuario.getNombre()+", Nickname: "+ usuario.getNickname() + ", Correo: " + usuario.getEmail()
                                 + ", Password: " + usuario.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usuarios;
    }
}