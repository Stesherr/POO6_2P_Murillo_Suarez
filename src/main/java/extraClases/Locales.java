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
    
    public static ArrayList<Locales> leerArchivo(){
        ArrayList<Locales> lista = new ArrayList<Locales>();
        //leer archivo de locales
        return lista;
    }
}
