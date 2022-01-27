/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraClases;

import generalClases.Usuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    
    
    public static ArrayList<Locales> leerArchivo(){//horario guarda como vacio
        ArrayList<Locales> lista = new ArrayList<Locales>();
        try ( BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/docs/sucursales.txt"))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] line = linea.split("-");
                lista.add(new Locales("Vithas Labs",line[2],"",Double.parseDouble(line[0]),Double.parseDouble(line[1])));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        
        return lista;
    }
}
