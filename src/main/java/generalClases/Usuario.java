/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generalClases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

    public Usuario(String usuario, String contraseña, String tipo) {
        this.usuario = usuario;
        this.tipo = tipo;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return usuario;
    }

    // Metodo para leer el archivo usuarios.txt y retornar una lista con objetos de tipo Usuario
    public static ArrayList<Usuario> leerUsuarios() {

        ArrayList<Usuario> usuarios = new ArrayList();
        try (BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/docs/usuarios.txt"))){

            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] line = linea.split(",");
                Usuario u = new Usuario(line[0], line[1], line[2]);
                usuarios.add(u);
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        return usuarios;
    }
    
    // Metodo para escribir en el archivo usuarios.txt los nuevos ingresados al sistema
    public void escribirArchivo() {

        ArrayList<Usuario> usuarios = Usuario.leerUsuarios();
        int h = 0;
        while (h < usuarios.size()) {
            if (usuarios.get(h).equals(this)) {
                System.out.println("este usuario ya se encuentra registrado");
                break;
            } else if (this.getUsuario().equals(usuarios.get(h).getUsuario())) {
                System.out.println("este nombre de usuario ya esta en uso");
                break;
            } else {
                h++;
            }
        }

        if (h == usuarios.size()) {

            try (FileWriter escribir = new FileWriter("src/main/resources/docs/usuarios.txt", true)) {
                escribir.write(this.usuario + "," + this.contraseña + "," + this.tipo + "\n");

            } catch (IOException e) {
                System.out.println("Error al escribir el archivo usuarios");
            }
        }
    }

}
