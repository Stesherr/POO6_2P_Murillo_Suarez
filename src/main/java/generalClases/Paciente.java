/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalClases;

import extraClases.Locales;
import extraClases.Prueba;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author josem
 */
public class Paciente {
    public int cedula;
    public String nombres;
    public String apellidos;
    public Date fnacimiento;
    public String genero;
    public String ciudad;
    public String email;
    public int telefono;

    public Paciente(int cedula, String nombres, String apellidos, Date fnacimiento, String genero, String ciudad, String email, int telefono) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fnacimiento = fnacimiento;
        this.genero = genero;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
    }
    
    public ArrayList<Locales> conocerUbicaciones(){
        ArrayList<Locales> ubicaciones = new ArrayList<Locales>();
        //leer locales y agregar a ubicaciones
        return ubicaciones;
    }
    
    public ArrayList<Prueba> solicitarPruebas(){
        ArrayList<Prueba> pruebas = new ArrayList<Prueba>();
        //leer pruebas y agregar a pruebas
        return pruebas;
    }
    
    
}
