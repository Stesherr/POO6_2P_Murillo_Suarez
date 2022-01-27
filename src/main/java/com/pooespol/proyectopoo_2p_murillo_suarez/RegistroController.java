/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import generalClases.Paciente;
import generalClases.Usuario;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class RegistroController implements Initializable {

    
    private String gener ="";
    
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
        
        try{
            String date = fNac.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Paciente pa = new Paciente(Integer.parseInt(ced.getText()), nom.getText(), ape.getText(), date, gener, ciud.getText(), mail.getText(), Integer.parseInt(fono.getText()), usuar.getText(), contra.getText());
            pa.escribirArchivo();
        }catch(NullPointerException e){
            System.out.println("algunos espacios no han sido llenados");//lanzar unaa ventana emergente de 5 segundos
        }
                
        
    }

    @FXML
    private void femTocado(ActionEvent event) {
        masButton.setSelected(false);
        otroButton.setSelected(false);
        gener = "Femenino";
    }

    @FXML
    private void masTocado(ActionEvent event) {
        femButton.setSelected(false);
        otroButton.setSelected(false);
        gener = "Masculino";
    }

    @FXML
    private void otroTocado(ActionEvent event) {
        masButton.setSelected(false);
        femButton.setSelected(false);
        gener = "Otro";
    }
    
}
