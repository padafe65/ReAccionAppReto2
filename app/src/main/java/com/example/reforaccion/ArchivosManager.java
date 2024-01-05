package com.example.reforaccion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivosManager {
    public static File CrearArchivo(File ruta, String nombreArchivo){
        File file = new File(ruta, nombreArchivo);
        try {

            if (file.createNewFile()){
                    System.out.println("Se creó exitosamente el archivo");
                }
            else{
                System.out.println("No se creó exitosamente el archivo, porque ya existe");
            }

        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return file;

    }
    public static void EscrituraArchivo(File archivoEscribir, String msj){

        try {
            FileWriter fileWriter = new FileWriter(archivoEscribir);
            fileWriter.write(msj);
            fileWriter.close();

                System.out.println("Se escribió exitosamente el archivo");
        }catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static void lecturaArchivo(File archivoAleer){

        try {
            FileReader fileReader = new FileReader(archivoAleer);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
           String linea;
            while ((linea = bufferedReader.readLine())!=null){
                System.out.println(linea);
            }
            System.out.println("Lectura exitosa");

        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void editarArchivo(File archivoAEditar, String msj){

        try {
            FileWriter fileWriter = new FileWriter(archivoAEditar, true);
            fileWriter.write(msj);
            fileWriter.write("\n");
            fileWriter.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
