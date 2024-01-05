package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class registrar_usuario extends AppCompatActivity {
    private Button registrarUsua;

    private EditText inputNombre, inputPassword, inputPassword2, inputEmail, inpNick;
    CheckBox terminosCondi, traDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);
        registrarUsua = findViewById(R.id.btnRegistrar);
        inputNombre = findViewById(R.id.inpNombreUsuario);
        inpNick = findViewById(R.id.inpNickName);
        inputEmail = findViewById(R.id.inpCorreo);
        inputPassword = findViewById(R.id.inpZona);
        inputPassword2 = findViewById(R.id.inpPassword2);
        terminosCondi = findViewById(R.id.chbTerminos);
        traDatos = findViewById(R.id.chbTratamientoDatos);

        Intent inicio = new Intent(this, Inicio.class);

        registrarUsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (terminosCondi.isChecked() && traDatos.isChecked()) {
                    // El RadioButton está activado

                    // Revisar si los campos están diligenciados
                    if (!inputNombre.getText().toString().isEmpty() && !inpNick.getText().toString().isEmpty() && !inputEmail.getText().toString().isEmpty()
                            && !inputPassword.getText().toString().isEmpty() && !inputPassword2.getText().toString().isEmpty()) {
                        // Revisar si las contraseñas coinciden
                        if (inputPassword.getText().toString().equals(inputPassword2.getText().toString())) {
                            // Validar si los datos ya existen en el archivo
                            if (datosExisten(inputNombre.getText().toString(), inpNick.getText().toString(), inputEmail.getText().toString())) {
                                // Los datos ya existen
                                Toast.makeText(getApplicationContext(), "El correo, usuario o nickname ya existen", Toast.LENGTH_SHORT).show();
                            } else {
                                // Los datos no existen, realizar el registro
                                // Crear un nuevo objeto Usuario
                                Usuario nuevoUsuario = new Usuario(inputNombre.getText().toString(),
                                        inpNick.getText().toString(), inputEmail.getText().toString(),
                                        inputPassword.getText().toString());
                                // Guardar los datos en el archivo
                                guardarRegistro(nuevoUsuario);
                                // Ir al activity de inicio de sesión
                                Toast.makeText(getApplicationContext(), "Está de regreso a la interfaz de inicio de sesíon",Toast.LENGTH_SHORT).show();
                                startActivity(inicio);
                            }
                        } else {
                            // Las contraseñas no coinciden
                            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Los campos estan vacios
                        Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // El RadioButton no está activado
                    Toast.makeText(getApplicationContext(), "Debe aceptar los términos y condiciones, " +
                            "tratamiento de datos", Toast.LENGTH_SHORT).show();
                }



            }

            /*Intent inicio = new Intent(registrar_usuario.this, Inicio.class);*/

        });

    }

    private boolean datosExisten(String nombreUsuario, String nickname, String correo ) {
        File file = new File(getFilesDir(), "datos.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> existingNombresUsuarios = new ArrayList<>();
            List<String> existingNicknames = new ArrayList<>();
            List<String> existingEmails = new ArrayList<>();



            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                existingNombresUsuarios.add(data[0]);
                existingNicknames.add(data[1]);
                existingEmails.add(data[2]);
            }

            bufferedReader.close();

            return existingEmails.contains(correo) || existingNicknames.contains(nickname) || existingNombresUsuarios.contains(nombreUsuario);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    private void guardarRegistro(Usuario nuevoUsuario) {
        File file = new File(getFilesDir(), "datos.txt");

        try {
            FileWriter writer = new FileWriter(file, true); // El segundo parámetro "true" indica que se agregará al final del archivo existente
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String nuevoRegistro = nuevoUsuario.getNombre() + "," + nuevoUsuario.getNickname() + "," +
                    nuevoUsuario.getEmail() + "," + nuevoUsuario.getPassword() + "\n";
            bufferedWriter.write(nuevoRegistro);
            bufferedWriter.close();
            System.out.println(nuevoUsuario.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}