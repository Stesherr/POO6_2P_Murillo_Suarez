/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalClases;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Laboratorista extends Usuario{
    
    

    public Laboratorista(String usuario, String contraseña) {
        super(usuario, contraseña);
        super.tipo = "L";
                
    }
    
    
    
    
    
    public ArrayList leerArchivo(String archivo){
        ArrayList lista = new ArrayList();
        //lectura de archivo
        return lista;
    }
    
    public void generarArchivo(){//revisar
        try
        {File archivo=new File("consolidado.txt");
        FileWriter escribir=new FileWriter(archivo,true);
        escribir.write("\n");
        
        escribir.close();
        }catch(Exception e)
        {
        System.out.println("Error al escribir el consolidado de citas");
        }
    }
    
    
    public ArrayList<Paciente>  consultarPacientes(){
        ArrayList<Paciente> lista = new ArrayList<Paciente> ();
        //lectura de pacientes
        return lista;
    }
}
