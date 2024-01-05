package com.example.reforaccion;

import com.example.reforaccion.enumeraciones.TipoArbol;

import java.util.Date;

public class Arbol {
    private String nombreArbol;

    private int cantidadArbol;

    private String fechaSiembra;

    private double costoArbol;

    private String zonaSiembra;

    private double areaSiembra;

   /* private String tecnica_plantar;
    private String seleccion_especie;
    private String cuidado_arbol;*/

    public Arbol(String nombreArbol, int cantidadArbol, String fechaSiembra, double costoArbol, String zonaSiembra, double areaSiembra) {
        this.nombreArbol = nombreArbol;
        this.cantidadArbol = cantidadArbol;
        this.fechaSiembra = fechaSiembra;
        this.costoArbol = costoArbol;
        this.zonaSiembra = zonaSiembra;
        this.areaSiembra = areaSiembra;
    }

    public Arbol() {
    }

    public Arbol(TipoArbol alamo, String s, String s1, String s2) {
    }

    public String getNombreArbol() {
        return nombreArbol;
    }

    public void setNombreArbol(String nombreArbol) {
        this.nombreArbol = nombreArbol;
    }

    public int getCantidadArbol() {
        return cantidadArbol;
    }

    public void setCantidadArbol(int cantidadArbol) {
        this.cantidadArbol = cantidadArbol;
    }

    public String getFechaSiembra() {
        return fechaSiembra;
    }

    public void setFechaSiembra(String fechaSiembra) {
        this.fechaSiembra = fechaSiembra;
    }

    public double getCostoArbol() {
        return costoArbol;
    }

    public void setCostoArbol(double costoArbol) {
        this.costoArbol = costoArbol;
    }

    public String getZonaSiembra() {
        return zonaSiembra;
    }

    public void setZonaSiembra(String zonaSiembra) {
        this.zonaSiembra = zonaSiembra;
    }

    public double getAreaSiembra() {
        return areaSiembra;
    }

    public void setAreaSiembra(double areaSiembra) {
        this.areaSiembra = areaSiembra;
    }

    @Override
    public String toString() {
        return "Arbol{" +
                "nombreArbol=" + nombreArbol +
                ", cantidadArbol=" + cantidadArbol +
                ", fechaSiembra=" + fechaSiembra +
                ", costoArbol=" + costoArbol +
                ", zonaSiembra='" + zonaSiembra + '\'' +
                ", areaSiembra=" + areaSiembra +
                '}';
    }
}
