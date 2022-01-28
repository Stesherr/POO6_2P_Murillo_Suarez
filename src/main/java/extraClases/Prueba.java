/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extraClases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author josem
 */
public class Prueba {
    public String codigoPrueba;
    public String tipoPrueba;
    public String nombrePrueba;
    public Double precio;

    
    
    public Prueba(String codigoPrueba, String tipoPrueba, String nombrePrueba, Double precio) {
        this.codigoPrueba = codigoPrueba;
        this.tipoPrueba = tipoPrueba;
        this.nombrePrueba = nombrePrueba;
        this.precio = precio;
    }

    public String getCodigoPrueba() {
        return codigoPrueba;
    }

    public void setCodigoPrueba(String codigoPrueba) {
        this.codigoPrueba = codigoPrueba;
    }

    public String getTipoPrueba() {
        return tipoPrueba;
    }

    public void setTipoPrueba(String tipoPrueba) {
        this.tipoPrueba = tipoPrueba;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombrePrueba ;
    }
    
    
    
    public static ArrayList<Prueba> leerArchivo(){
        ArrayList<Prueba> pruebas = new ArrayList<Prueba>();
        File file = new File("src/main/resources/docs/pruebas.txt");
        try ( 
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file),StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                String[] line = linea.split(",");
                pruebas.add(new Prueba(line[0], line[1], line[2], Double.parseDouble(line[3])));
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }
        
        return pruebas;
    }
    
    public static ArrayList cargarTipoP(){
        ArrayList tipos = new ArrayList();
        ArrayList<Prueba> pruebas = Prueba.leerArchivo();
        for (Prueba prueba : pruebas){
            if(tipos.equals(null)){
                tipos.add(prueba.getTipoPrueba());
            }else{
                int i = 0;
                while ( i < tipos.size()) {
                    if(prueba.getTipoPrueba().equals(tipos.get(i))){
                        break;
                    }else{
                        i++;
                    }
                }
                if(i==tipos.size()){
                    tipos.add(prueba.getTipoPrueba());
                }
            }
        }
        return tipos;
    }
}
