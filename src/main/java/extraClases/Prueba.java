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
public class Prueba {
    public int codigoPrueba;
    public String tipoPrueba;
    public String nombrePrueba;
    public Double precio;

    public Prueba(int codigoPrueba, String tipoPrueba, String nombrePrueba, Double precio) {
        this.codigoPrueba = codigoPrueba;
        this.tipoPrueba = tipoPrueba;
        this.nombrePrueba = nombrePrueba;
        this.precio = precio;
    }
    
    public static ArrayList<Prueba> leerArchivo(){
        ArrayList<Prueba> pruebas = new ArrayList<Prueba>();
        //leer el archivo de pruebas
        return pruebas;
    }
}
