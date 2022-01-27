/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class OpcionesPController implements Initializable {

    @FXML
    private Text bienvenida;
    @FXML
    private Button conocerButton;
    @FXML
    private Button solicitarButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // cambio de colores a los botones
        bienvenida.setFill(Color.WHITE);
        
        conocerButton.setStyle("-fx-background-color: Blue");
        conocerButton.setTextFill(Color.WHITE);
        
        solicitarButton.setStyle("-fx-background-color: Blue");
        solicitarButton.setTextFill(Color.WHITE);
    }    

    @FXML
    private void conocerUbicaciones(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "ubicaciones.fxml"));
        
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Ubicaciones");
       
        stage.show();
    }

    @FXML
    private void solicitarPruebas(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "agendarCita.fxml"));
        
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Agendar Prueba");
       
        stage.show();
    }
    
}
