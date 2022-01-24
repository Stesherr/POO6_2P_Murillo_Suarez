/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraClases;

import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Locales {
    public String nombre;
    public String direccion;
    public String horario;
    public Double coordenadaX;
    public Double coordenadaY;

    public Locales(String nombre, String direccion, String horario, Double coordenadaX, Double coordenadaY) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horario = horario;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    
    
    
    public static ArrayList<Locales> leerArchivo(){
        ArrayList<Locales> lista = new ArrayList<Locales>();
        //leer archivo de locales
        return lista;
    }
}
