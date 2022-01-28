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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
    @FXML
    private GridPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // cambio de colores a los botones
        bienvenido.setFill(Color.WHITE);
        bienvenido.setText("Bienvenid@ "+PaginaIController.cliente.getUsuario());
        
        generaButton.setStyle("-fx-background-color: Blue");
        generaButton.setTextFill(Color.WHITE);
        
        consultarButton.setStyle("-fx-background-color: Blue");
        consultarButton.setTextFill(Color.WHITE);
        
        try(FileInputStream input=new FileInputStream("src/main/resources/imagenes/fondo.jpg")){
            Image i=new Image(input,2000, 2000, true, true);
            
            BackgroundImage pic = new BackgroundImage(i, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            
            Background pica = new Background(pic);
            root.setBackground(pica);
            
            
        }catch(IOException f){
            System.out.println("No se encontro la imagen");
        }
    }    

    @FXML
    private void generarConsolidado(ActionEvent event) {
        
    }

    @FXML
    private void consultarCitas(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "consultarCitas.fxml"));
        
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Consultar Citas");
       
        stage.show();
    }
    
}
