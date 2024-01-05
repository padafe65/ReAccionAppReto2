package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Registro extends AppCompatActivity {
    ImageView imgFecha;
    EditText editTextFecha, nombreArbol, cantidadArbol, costoArbol, zonaSiembra, areaSiembra;
    ImageButton inicio;
    Button guardarArbol;
    int d;
    int m;
    int y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreArbol=findViewById(R.id.inpArbol);
        cantidadArbol = findViewById(R.id.inptCantidadArbol);
        editTextFecha=findViewById(R.id.editTextDate);
        costoArbol=findViewById(R.id.inpCostoArbol);
        zonaSiembra=findViewById(R.id.inpZona);
        areaSiembra=findViewById(R.id.inpArea);
        imgFecha=findViewById(R.id.imgDate);

        inicio=findViewById(R.id.imgInicio);
        final Calendar c = Calendar.getInstance();
        guardarArbol = findViewById(R.id.btnGuardar_arbol);


        imgFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y = c.get(Calendar.YEAR);
                m = c.get(Calendar.MONTH);
                d = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog g= new DatePickerDialog(Registro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editTextFecha.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                },y,m,d);
                g.show();
            }
        });
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(Registro.this,Menu.class);
                startActivity(inicio);
            }
        });

        //_____________________________________________________
        guardarArbol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Revisar si los campos están diligenciados
                if (!nombreArbol.getText().toString().isEmpty() && !cantidadArbol.getText().toString().isEmpty() && !editTextFecha.getText().toString().isEmpty()
                            && !costoArbol.getText().toString().isEmpty() && !zonaSiembra.getText().toString().isEmpty()&& !areaSiembra.getText().toString().isEmpty()) {
                        // Revisar si el árbol existe

                    // Validar si los datos ya existen en el archivo
                    if (datosExisten(nombreArbol.getText().toString(), editTextFecha.getText().toString())){
                        // Los datos ya existen
                        Toast.makeText(getApplicationContext(), "El nombre del árbol y la fecha de siembra ya existen", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        // Los datos no existen, realizar el registro
                        // Crear un nuevo objeto Usuario
                        Arbol nuevoArbol = new Arbol(nombreArbol.getText().toString(), Integer.parseInt(cantidadArbol.getText().toString()),
                                editTextFecha.getText().toString(), Double.parseDouble(costoArbol.getText().toString()), zonaSiembra.getText().toString(),
                                Double.parseDouble(areaSiembra.getText().toString()));
                        // Guardar los datos en el archivo
                        guardarRegistro(nuevoArbol);
                        // Ir al activity de inicio de sesión
                        Toast.makeText(getApplicationContext(), "Está de regreso a la interfaz de inicio de sesíon",Toast.LENGTH_SHORT).show();
                        Intent menu = new Intent(Registro.this, Menu.class);
                        startActivity(menu);
                    }

                } else {
                    // Los campos estan vacios
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",Toast.LENGTH_SHORT).show();
                }
            }

            /*Intent inicio = new Intent(registrar_usuario.this, Inicio.class);*/

        });

    }

    private boolean datosExisten(String nombreArbol,  String fecha ) {
        File file = new File(getFilesDir(), "datos.txt");

        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> existingNombresArbol = new ArrayList<>();
            List<String> existingFecha = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                existingNombresArbol.add(data[0].toUpperCase());
                existingFecha.add(data[3]);
            }

            bufferedReader.close();

            return existingNombresArbol.contains(nombreArbol) || existingFecha.contains(fecha);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
    private void guardarRegistro(Arbol nuevoArbol) {
        File file = new File(getFilesDir(), "arbol.txt");

        try {
            FileWriter writer = new FileWriter(file, true); // El segundo parámetro "true" indica que se agregará al final del archivo existente
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String nuevoRegistro = nuevoArbol.getNombreArbol().toUpperCase(Locale.ROOT) + "," + nuevoArbol.getCantidadArbol() + "," + nuevoArbol.getFechaSiembra()
                    + "," + nuevoArbol.getCostoArbol() + "," + nuevoArbol.getZonaSiembra() + "," + nuevoArbol.getAreaSiembra() + "\n";
            bufferedWriter.write(nuevoRegistro);
            bufferedWriter.close();
            System.out.println(nuevoArbol.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}