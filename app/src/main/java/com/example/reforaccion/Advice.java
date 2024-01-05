package com.example.reforaccion;

import com.example.reforaccion.enumeraciones.TipoArbol;

public class Advice {

    private TipoArbol nombre;
  private String tecnica_plantar;
  private String seleccion_especie;
  private String cuidado_arbol;

    public Advice(TipoArbol nombre, String tecnica_plantar, String seleccion_especie, String cuidado_arbol) {
        this.nombre = nombre;
        this.tecnica_plantar = tecnica_plantar;
        this.seleccion_especie = seleccion_especie;
        this.cuidado_arbol = cuidado_arbol;
    }

    public Advice() {
    }

    public TipoArbol getNombre() {
        return nombre;
    }

    public void setNombre(TipoArbol nombre) {
        this.nombre = nombre;
    }

    public String getTecnica_plantar() {
        return tecnica_plantar;
    }

    public void setTecnica_plantar(String tecnica_plantar) {
        this.tecnica_plantar = tecnica_plantar;
    }

    public String getSeleccion_especie() {
        return seleccion_especie;
    }

    public void setSeleccion_especie(String seleccion_especie) {
        this.seleccion_especie = seleccion_especie;
    }

    public String getCuidado_arbol() {
        return cuidado_arbol;
    }

    public void setCuidado_arbol(String cuidado_arbol) {
        this.cuidado_arbol = cuidado_arbol;
    }

    @Override
    public String toString() {
        return "Advice{" +
                "nombre=" + nombre +
                ", tecnica_plantar='" + tecnica_plantar + '\'' +
                ", seleccion_especie='" + seleccion_especie + '\'' +
                ", cuidado_arbol='" + cuidado_arbol + '\'' +
                '}';
    }
}
