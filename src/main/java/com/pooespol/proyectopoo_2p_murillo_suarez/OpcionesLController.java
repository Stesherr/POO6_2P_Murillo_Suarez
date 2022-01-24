/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class OpcionesLController implements Initializable {

    @FXML
    private Text bienvenido;
    @FXML
    private Button generaButton;
    @FXML
    private Button consultarButton;
    @FXML
    private Text mensage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // cambio de colores a los botones
        bienvenido.setFill(Color.WHITE);
        
        generaButton.setStyle("-fx-background-color: Blue");
        generaButton.setTextFill(Color.WHITE);
        
        consultarButton.setStyle("-fx-background-color: Blue");
        consultarButton.setTextFill(Color.WHITE);
    }    

    @FXML
    private void generarConsolidado(ActionEvent event) {
    }

    @FXML
    private void consultarCitas(ActionEvent event) {
    }
    
}
