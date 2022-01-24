/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalClases;

import extraClases.Solicitud;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Usuario {
    protected String usuario;
    protected String tipo;
    protected String contraseña;
    
    public Usuario(String usuario, String contraseña){
        this.usuario = usuario;
        this.contraseña = contraseña;
       
    }

    public Usuario(String usuario, String contraseña, String tipo) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.contraseña = contraseña;
    }
    
    
    
    public static ArrayList<Usuario> leerArchivo(){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try ( BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/imagenes/usuarios.txt/"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] line = linea.split(",");
                usuarios.add(new Usuario(line[0],line[1],line[2]));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        return usuarios;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    }
    
}
