/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalClases;

import extraClases.Locales;
import extraClases.Prueba;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    public String fnacimiento;
    public String genero;
    public String ciudad;
    public String email;
    public int telefono;
    

    public Paciente(int cedula, String nombres, String apellidos, String fnacimiento, String genero, String ciudad, String email, int telefono, String usuario, String contraseña) {
        super(usuario, contraseña,"P");
        
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

    public String getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(String fnacimiento) {
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
    
    public static ArrayList<Paciente> leerPacientes(){
        ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
        try ( BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/docs/pacientes.txt/"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] line = linea.split(",");
                pacientes.add(new Paciente(Integer.parseInt(line[1]),line[2],line[3],line[4],line[5],line[6],line[7],Integer.parseInt(line[8]),line[0],""));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        ArrayList<Usuario> usuarios = Usuario.leerUsuarios();
        for (int i = 0; i < pacientes.size(); i++) {
            int j = 0;
            while(!pacientes.get(i).getUsuario().equals(usuarios.get(j).getUsuario())){
                j++;
            }
            pacientes.get(i).setContraseña(usuarios.get(j).getContraseña());
            
        }
        return pacientes;
    }
    
    
    public void escribirArchivo (){
        ArrayList<Paciente> pacientes = Paciente.leerPacientes();
        int h = 0;
        while(h<pacientes.size()){
            if((pacientes.get(h).equals(this))||(pacientes.get(h).getCedula()==this.getCedula())){
                System.out.println("este usuario ya se encuentra registrado");
                break;
            }else if(this.usuario==pacientes.get(h).usuario){
                System.out.println("este nombre de usuario ya esta en uso");
                break;
            }else{
                h++;
            }
        }
        if(h==pacientes.size()){
            try
                {
                FileWriter escribir=new FileWriter("src/main/resources/docs/pacientes.txt/",true);
                escribir.write(this.usuario+","+this.cedula+","+this.nombres+","+this.apellidos+","+this.fnacimiento+","+this.genero+","+this.ciudad+","+this.email+","+this.telefono+"\n");
        
                escribir.close();
            }catch(Exception e)
            {
                System.out.println("Error al escribir el archivo pacientes");
            }
            super.escribirArchivo();
        }
        
        
        
        
    }
    
    
    
}
