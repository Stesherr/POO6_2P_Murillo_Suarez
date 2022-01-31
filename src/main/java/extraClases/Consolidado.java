/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraClases;

import generalClases.Paciente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author Stefano
 */
public class Consolidado implements Serializable,Comparable<Consolidado>{
    
    private String nombrePac;
    private String apellidoPac;
    private String fecha;
    private int numSolic;
    
    public Consolidado(String nombrePac, String apellidoPac, String fecha, int numSolic){
        this.nombrePac = nombrePac;
        this.apellidoPac = apellidoPac;
        this.fecha = fecha;
        this.numSolic = numSolic;
    }
    
    public String getNombre(){
        return this.nombrePac;
    }
    
    public String getApellido(){
        return this.apellidoPac;
    }
    
    public String getFecha(){
        return this.fecha;
    }
    
    public int getNumSolicitud(){
        return this.numSolic;
    }
    
    public static ArrayList<Consolidado> leerContrataciones(){
        ArrayList<Consolidado> consolidado = new ArrayList<>();
        ArrayList<Paciente> pacientes = Paciente.leerPacientes();
        File file = new File("src/main/resources/docs/contratatacionesPruebas.txt");
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file),StandardCharsets.UTF_8))){
            String linea;
            while((linea = bf.readLine()) != null){
                String[] line = linea.split(",");
                for(Paciente paciente : pacientes){
                    if(paciente.getUsuario().equals(line[1])){
                        consolidado.add(new Consolidado(paciente.getNombres(),paciente.getApellidos(),line[3],Integer.parseInt(line[0])));
                    }
                }
            }
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return consolidado;
    }
    
    // Metodo para crear un archivo serializado
    public static void escribirConsolidado(ArrayList<Consolidado> consolidado){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/resources/docs/consolidado.dat"))){
            oos.writeObject(consolidado);
        }catch(IOException ex){
            System.out.println("No se ha podido escribir el archivo");
        }
    }
    
    // Metodo para leer un archivo serializado
    public static ArrayList<Consolidado> leerConsolidado(){
        ArrayList<Consolidado> consolidados = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/docs/consolidado.dat"))){
            while(true){
                consolidados = (ArrayList<Consolidado>) ois.readObject();
            }            
                  
        }catch (ClassNotFoundException e){
            System.out.println("No se ha podido leer el archivo serializado");
        }catch(IOException e){
            
        }
        return consolidados;

    }
    

    
    public static void main(String[] args){
        for(Consolidado con : leerConsolidado()){
            System.out.println(con.getNombre() + " " + con.getApellido());
        }
        
        
    }

    @Override
    public int compareTo(Consolidado o) {
        return this.getNombre().compareTo(o.getNombre());
    }
    
}
