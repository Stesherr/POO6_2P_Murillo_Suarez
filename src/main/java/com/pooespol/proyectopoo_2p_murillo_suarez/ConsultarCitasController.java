/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;


import static com.pooespol.proyectopoo_2p_murillo_suarez.OpcionesPController.stage;
import extraClases.Consolidado;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class ConsultarCitasController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button cerrar;
    
    @FXML
    private VBox nombreVb;
    
    @FXML
    private VBox apellidoVb;
    
    @FXML
    private VBox fechaVb;
    
    @FXML
    private VBox numSolicVb;
    
    @FXML
    private VBox root;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<Consolidado> consolidado = Consolidado.leerConsolidado();
        Label nombre;
        Label apellido;
        Label fecha;
        Label numSolic;
        for(Consolidado cons : consolidado){
            System.out.println(cons.getNombre());
            nombre = new Label(cons.getNombre());
            apellido = new Label(cons.getApellido());
            fecha = new Label (cons.getFecha());
            numSolic = new Label (String.valueOf(cons.getNumSolicitud()));
            nombreVb.getChildren().add(nombre);
            apellidoVb.getChildren().add(apellido);
            fechaVb.getChildren().add(fecha);
            numSolicVb.getChildren().add(numSolic);
        }
    }    
    
}
