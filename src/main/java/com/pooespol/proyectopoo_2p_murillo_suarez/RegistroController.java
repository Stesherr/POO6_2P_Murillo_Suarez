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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class RegistroController implements Initializable {

    @FXML
    private Button registro;
    @FXML
    private TextField ced;
    @FXML
    private TextField ciud;
    @FXML
    private TextField ape;
    @FXML
    private TextField mail;
    @FXML
    private TextField fono;
    @FXML
    private TextField usuar;
    @FXML
    private TextField nom;
    @FXML
    private TextField contra;
    @FXML
    private DatePicker fNac;
    @FXML
    private RadioButton femButton;
    @FXML
    private RadioButton masButton;
    @FXML
    private RadioButton otroButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        registro.setStyle("-fx-background-color: Blue");
        registro.setTextFill(Color.WHITE);
    }    

    @FXML
    private void registrar(ActionEvent event) {
    }

    @FXML
    private void femTocado(ActionEvent event) {
    }

    @FXML
    private void masTocado(ActionEvent event) {
    }

    @FXML
    private void otroTocado(ActionEvent event) {
    }
    
}
