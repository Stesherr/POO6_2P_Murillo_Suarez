/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalClases;

import extraClases.Locales;
import extraClases.Prueba;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author josem
 */
public class Paciente extends Usuario{
    public int cedula;
    public String nombres;
    public String apellidos;
    public Date fnacimiento;
    public String genero;
    public String ciudad;
    public String email;
    public int telefono;
    public static String tipo = "P";
    //usuario
    //contraseña

    public Paciente(int cedula, String nombres, String apellidos, Date fnacimiento, String genero, String ciudad, String email, int telefono, String usuario, String contraseña) {
        super(usuario, contraseña);
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fnacimiento = fnacimiento;
        this.genero = genero;
        this.ciudad = ciudad;
        this.email = email;
        this.telefono = telefono;
        
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Date fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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
    
    public void escribirArchivo (){
        try
        {File archivo=new File("pacientes.txt");
        FileWriter escribir=new FileWriter(archivo,true);
        escribir.write(this.usuario+","+this.cedula+","+this.nombres+","+this.apellidos+","+this.fnacimiento+","+this.genero+","+this.ciudad+","+this.email+","+this.telefono+"\n");
        
        escribir.close();
        }catch(Exception e)
        {
        System.out.println("Error al escribir el archivo pacientes");
        }
    }
    
}
