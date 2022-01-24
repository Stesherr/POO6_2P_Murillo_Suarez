/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author josem
 */
public class PaginaIController implements Initializable {

    @FXML
    private TextField user;
    @FXML
    private ImageView logo;
    @FXML
    private Button inicio;
    @FXML
    private Text cuentaCR;
    @FXML
    private PasswordField contra;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cuentaCR.setFill(Color.BLUE);
        
        inicio.setStyle("-fx-background-color: Blue");
        inicio.setTextFill(Color.WHITE);
        
        try(FileInputStream input=new FileInputStream("src/main/resources/imagenes/logo.jpg/")){
            Image i=new Image(input);
            logo.setImage(i);
        }catch(IOException f){
            System.out.println("No se encontro la imagen");
        }
    }    

    @FXML
    private void iniciarSesion(ActionEvent event) {
        
    }

    @FXML
    private void crearCuenta(MouseEvent event) {
       /* JDialog ventanaEmergente = new JDialog(<obj de ventanaPrincipal>, <true o false para que tenga le focus siempre>); //checa los parametros hace tiempo que no me meto con swing...
        ventanaEmergente.setSize(<las medidas>);
        ventanaEmergente.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        ventanaEmergente.setVisible(true);
    */
        
    }
    
}
