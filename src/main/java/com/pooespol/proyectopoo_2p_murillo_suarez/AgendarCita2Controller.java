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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class AgendarCita2Controller implements Initializable {

    @FXML
    private ImageView mapa;
    
    @FXML
    private Button botonFinalizar;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        botonFinalizar.setStyle("-fx-background-color: #3066e3 ; -fx-font-weight: bold");
        botonFinalizar.setTextFill(Color.WHITE);
        
        try(FileInputStream input=new FileInputStream("src/main/resources/imagenes/mapa.jpg")){
            Image i=new Image(input,800, 1200, true, true);
            
            /*BackgroundImage pic = new BackgroundImage(i, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            
            Background pica = new Background(pic);*/
            mapa.setImage(i);
            mapa.setFitHeight(200);
            mapa.setFitWidth(1200);
            
            
        }catch(IOException f){
            System.out.println("No se encontro la imagen");
        }
    }    
    
}
