package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.text.LineBreaker;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estadistica extends AppCompatActivity {
    ImageButton imgretornar_estadistica;
    Button cargarEstadistica;

    int count=0;
    private TableLayout tableLayout;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadistica);

        imgretornar_estadistica = findViewById(R.id.imgInicioEstadistica);
        cargarEstadistica = findViewById(R.id.btnCargasEstad);

        //Elementos de la interfaz
        Button botonRegresar = findViewById(R.id.btnCargasEstad);
        tableLayout = findViewById(R.id.Table1);


        //Carga de los archivos árbol
        File arbolFile = new File(getFilesDir(), "arbol.txt");
        /*File aguaFile = new File(getFilesDir(), "agua.txt");
        File electricidadFile = new File(getFilesDir(), "electricidad.txt");*/

        //Listas arboles
        List<Arbol> listaArbol = leerArchivoArbol(arbolFile);
        //List<Electricidad> listaElectricidad = leerArchivoElectricidad(electricidadFile);

        //Crear la Tabla
        cargarEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count+= 1;
                if (count==1){
                addElementArbol(listaArbol);
                addPromedioArbol(listaArbol);}
            }
        });

        /*addElementElectricidad(listaElectricidad);
        addPromedioAgua(listaAgua);
        addPromedioElectricidad(listaElectricidad);*/
        //Boton Regresar



        imgretornar_estadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_est = new Intent(Estadistica.this, Menu.class);
                startActivity(i_est);
            }
        });
    }

    private void addPromedioArbol(List<Arbol> arboList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        float promedioCostoArbol = calcularPromedioCostoArbol(arboList);
        float promedioArea = calcularPromedioArea(arboList);

        TableRow row = new TableRow(this);
        //AÑADE LA INFORMACIÓN A LA CELDA 1
        TextView cell1 = new TextView(this);
        cell1.setText("Promedio");
        cell1.setGravity(1);
        cell1.setPadding(10, 10, 10, 10);
        cell1.setBackgroundResource(R.color.byzantium); // Cambia R.color.tableCellBackground por el
        cell1.setTextColor(getResources().getColor(R.color.white));
        // color deseado

        //AÑADE LA INFORMACIÓN A LA CELDA 2
        TextView cell2 = new TextView(this);
        cell2.setText("Arbol");
        cell2.setGravity(1);
        cell2.setPadding(10, 10, 10, 10);
        cell2.setBackgroundResource(R.color.byzantium); // Cambia R.color.tableCellBackground por el color
        cell2.setTextColor(getResources().getColor(R.color.white));


        //AÑADE LA INFORMACIÓN A LA CELDA 3
        TextView cell3 = new TextView(this);
        cell3.setText(String.valueOf(promedioArea));
        cell3.setGravity(1);
        cell3.setPadding(10, 10, 10, 10);
        cell3.setBackgroundResource(R.color.byzantium); // Cambia R.color.tableCellBackground por
        cell3.setTextColor(getResources().getColor(R.color.white));
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 4
        TextView cell4 = new TextView(this);
        cell4.setText(String.valueOf(promedioCostoArbol));
        cell4.setGravity(1);
        cell4.setPadding(10, 10, 10, 10);
        cell4.setBackgroundResource(R.color.byzantium); // Cambia R.color.tableCellBackground por
        cell4.setTextColor(getResources().getColor(R.color.white));
        // el color

        //AÑADE LA INFORMACIÓN A LA CELDA 5
        TextView cell5 = new TextView(this);
        cell5.setText("Colombia");
        cell5.setGravity(1);
        cell5.setPadding(10, 10, 10, 10);
        cell5.setBackgroundResource(R.color.byzantium); // Cambia R.color.tableCellBackground por
        cell5.setTextColor(getResources().getColor(R.color.white));
        // el color


        // Agrega las celdas a la fila
        row.addView(cell1);
        row.addView(cell2);
        row.addView(cell3);
        row.addView(cell4);
        row.addView(cell5);
        // Agrega la fila al TableLayout
        tableLayout.addView(row);
    }



    private void addElementArbol(List<Arbol> arbolList){
        // Obtén una referencia al TableLayout en tu actividad o fragmento

        for (Arbol item: arbolList) {
            // Crea una nueva fila y agrega las celdas
            TableRow row = new TableRow(this);
            //AÑADE LA INFORMACIÓN A LA CELDA 1
            TextView cell1 = new TextView(this);
            cell1.setText(item.getNombreArbol());
            cell1.setGravity(1);
            cell1.setTextColor(getResources().getColor(R.color.black));
            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el
            // color deseado

            //AÑADE LA INFORMACIÓN A LA CELDA 2
            TextView cell2 = new TextView(this);
            cell2.setText(item.getFechaSiembra());
            cell2.setGravity(1);
            cell2.setTextColor(getResources().getColor(R.color.black));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por el color


            //AÑADE LA INFORMACIÓN A LA CELDA 3
            TextView cell3 = new TextView(this);
            cell3.setText(String.valueOf((item.getCantidadArbol())));
            cell3.setGravity(1);
            cell3.setTextColor(getResources().getColor(R.color.black));
            cell3.setPadding(10, 10, 10, 10);
            cell3.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 4
            TextView cell4 = new TextView(this);
            cell4.setText(String.valueOf((item.getCostoArbol())));
            cell4.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            cell4.setTextColor(getResources().getColor(R.color.black));
            cell4.setPadding(10, 10, 10, 10);
            cell4.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            //AÑADE LA INFORMACIÓN A LA CELDA 5
            TextView cell5 = new TextView(this);
            cell5.setText(String.valueOf((item.getZonaSiembra())));
            cell5.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
            cell5.setTextColor(getResources().getColor(R.color.black));
            cell5.setPadding(10, 10, 10, 10);
            cell5.setBackgroundResource(R.color.white); // Cambia R.color.tableCellBackground por
            // el color

            // Agrega las celdas a la fila
            row.addView(cell1);
            row.addView(cell2);
            row.addView(cell3);
            row.addView(cell4);
            row.addView(cell5);
            // Agrega la fila al TableLayout
            tableLayout.addView(row);
        }
    }


    private static List<Arbol> leerArchivoArbol(File archivo) {
        List<Arbol> listaArbol = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                int cantidad = Integer.parseInt(datos[1]);
                String fecha = datos[2];
                double costo = Float.parseFloat(datos[3]);
                String zona = datos[4];
                double area = Float.parseFloat(datos[5]);

                Arbol arbol = new Arbol(nombre, cantidad, fecha, costo, zona, area);
                listaArbol.add(arbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaArbol;
    }

    private float calcularPromedioCostoArbol(List<Arbol> arbolList) {
        float sum = 0;
        for (Arbol item : arbolList) {
            sum += item.getCostoArbol();
        }
        return sum / arbolList.size();
    }
    private float calcularPromedioArea(List<Arbol> arboList) {
        float sum = 0;
        for (Arbol item : arboList) {
            sum += item.getAreaSiembra();
        }
        return sum / arboList.size();
    }
}