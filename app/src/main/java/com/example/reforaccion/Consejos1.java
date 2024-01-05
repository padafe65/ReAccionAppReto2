package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reforaccion.enumeraciones.TipoArbol;

import java.util.ArrayList;
import java.util.List;

public class Consejos1 extends AppCompatActivity {
    private Spinner spinner1;
    Button consejos1;
    ImageButton inicioConsejos;
    TextView tecnica, especie, cuidados;
    String[] opciones;
    String seleccion;
    ArrayAdapter<String> adapter;
    int posicion = 0, temp = 0, opc = 0;
    ImageView iv;
    private List<Advice> catalogoArboles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos1);

        spinner1 = findViewById(R.id.spinnerPlanta);
        iv = findViewById(R.id.imageView3);
        tecnica = findViewById(R.id.tecnicaPlantar);
        especie = findViewById(R.id.seleccionEspecies);
        cuidados = findViewById(R.id.cuidadoArboles);
        consejos1 = findViewById(R.id.btnConsejos);
        inicioConsejos = findViewById(R.id.imgInicioConsejo);
        Crear_Arbol();
        opciones = new String[]{TipoArbol.ROBLE.toString(), TipoArbol.ARCE.toString(), TipoArbol.NOGAL.toString(),
                TipoArbol.FRESNO.toString(), TipoArbol.PALMERA.toString(), TipoArbol.OLMO.toString(), TipoArbol.CIPRES.toString(),
                TipoArbol.ALAMO.toString(), TipoArbol.PINO.toString(), TipoArbol.SAUCE_LLORON.toString(), TipoArbol.FLOTANTES.toString()};


        adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_fuentes, opciones);
        spinner1.setAdapter(adapter);
        //Seleccion();

        consejos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccion = spinner1.getSelectedItem().toString();

                for (Advice a : catalogoArboles) {
                    Log.d("Hola", "Crear_Arbol1: " + a.getNombre());
                    Toast.makeText(Consejos1.this, "Probar spinner:" + a.getNombre(), Toast.LENGTH_SHORT).show();
                    String nombre_a = String.valueOf(a.getNombre());
                    if (seleccion.equals(nombre_a)) {

                        Log.d("Seleccion: ", "onClick: " + nombre_a);
                        tecnica.setText("Técnica de plantación: " + a.getTecnica_plantar());
                        especie.setText("Selección de especies adecuadas: " + a.getSeleccion_especie());
                        cuidados.setText("Cuidado de los árboles plantados: " + a.getCuidado_arbol());
                        break;
                    } else {
                        tecnica.setText("Técnica de plantación");
                        especie.setText("Selección de especies adecuadas");
                        cuidados.setText("Cuidado de los árboles plantados");
                    }
    /*else {
        Toast.makeText(this,"No Ha seleccionado Arbol",Toast.LENGTH_SHORT).show();

       }*/

                }
            }
        });
        inicioConsejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ini = new Intent(Consejos1.this, Menu.class);
                startActivity(ini);
            }
        });
    }

    public void Crear_Arbol() {
        // Crear algunas plantas de ejemplo
        catalogoArboles = new ArrayList<>();
        Advice arbol1 = new Advice(TipoArbol.ALAMO, "poner suficiente mantillo cuando las plante en el suelo",
                "El peciolo, largo y glanduloso", "Aplique un fertilizante con un alto contenido de nitrógeno y orgánico dos veces al año");
        Advice arbol2 = new Advice(TipoArbol.NOGAL, "El nogal necesita riego regular, especialmente durante períodos sin lluvia",
                "Nuez de Castilla ", "Para un crecimiento sano, asegúrese de que Nogal recibe al menos entre 3 y 6 horas de sol al día");
        Advice arbol3 = new Advice(TipoArbol.PINO, "Debes consultar el proceso ya que son 8 pasos para una siembra correcta",
                "pino silvestre", "rinde mejor con una exposición a pleno sol o a sol parcial. Funcionan mejor con luz directa por la mañana, pero en verano necesitan protegerse del fuerte sol de la tarde");
        Advice arbol4 = new Advice(TipoArbol.ROBLE, "poner suficiente mantillo cuando las plante en el suelo",
                "roble rojo americano", "refiere los suelos arcillosos a los ácidos");
        Advice arbol5 = new Advice(TipoArbol.SAUCE_LLORON, " la sistematización del terreno para realizar el riego, buena iluminación y se llevará a cabo cuando las plantas hayan perdido las hojas",
                "El peciolo, largo y glanduloso", "riego profundo y poco frecuente. Conviene empaparlas en un galón de agua cada vez, sobre todo cuando se plantan en macetas");
        Advice arbol6 = new Advice(TipoArbol.PALMERA, "Plantar en primavera fuera de periodos de helada, Sanear las raíces muertas o desgarradas y atar entre sí la totalidad de las hojas hasta comprobar que la palmera esté establecida",
                "Cocos nucifera: El Cocotero, palmera que alcanza los 12-24 m de altura, su tallo más o menos encorvado. Sólo vive en  climas tropicales (delicada); Phoenix canariensis: Alcanza los 15-18 m de altura, diámetro tallo de 1 m. Crece unos 30-40 cm por año", "1. Buena iluminación - 2. Riego controlado y agua especifica - 3. Abonado regular en epoca de crecimiento - 4. Ambiente húmedo y limpio, vital");
        Advice arbol7 = new Advice(TipoArbol.FRESNO, "Colocar al fondo del hueco la tierra más fértil, para que la raíz tenga los mejores nutrientes. Retira con mucho cuidado la planta de la bolsa. Toma con los dedos la planta por la parte más baja del tallo y ponla en el centro del hueco sin tocar la raíz.",
                "\n" +
                        "Fraxinus americana - Fresno blanco\n" +
                        "Fraxinus caroliniana\n" +
                        "Fraxinus nigra - Fresno negro\n" +
                        "Fraxinus pennsylvanica - Fresno verde\n" +
                        "Fraxinus profunda\n" +
                        "Fraxinus quadrangulata - Fresno azul", "Destaca, principalmente, necesita riegos regulares, pues no resiste la sequía. Lo ideal es regarlo 3 o 4 veces a la semana en estaciones más cálidas. en el invierno debido solo es necesario regarlo una vez por semana.");

        // Agregar las arboles al catálogo de plantas
        catalogoArboles.add(arbol1);
        catalogoArboles.add(arbol2);
        catalogoArboles.add(arbol3);
        catalogoArboles.add(arbol4);
        catalogoArboles.add(arbol5);
        catalogoArboles.add(arbol6);
        catalogoArboles.add(arbol7);
        for (Advice a : catalogoArboles) {
            Log.d("Hola", "Crear_Arbol: " + a.getNombre());
        }
    }

    public void Seleccion() {
        seleccion = spinner1.getSelectedItem().toString();
        for (Advice a : catalogoArboles) {
            Log.d("Hola", "Crear_Arbol: " + a.getNombre());
            Toast.makeText(this, "Nombre árbol: " + a.getNombre(), Toast.LENGTH_SHORT).show();

            if (seleccion.equals(a.getNombre())) {

                Toast.makeText(this, "Ha seleccionado Alamo", Toast.LENGTH_SHORT).show();

            }
    /*else {
        Toast.makeText(this,"No Ha seleccionado Arbol",Toast.LENGTH_SHORT).show();

       }*/

        }


    }
}