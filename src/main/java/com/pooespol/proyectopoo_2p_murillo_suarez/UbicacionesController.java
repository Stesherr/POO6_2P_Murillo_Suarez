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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class UbicacionesController implements Initializable {

    private ImageView mapa;
    @FXML
    private Pane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try(FileInputStream input=new FileInputStream("src/main/resources/imagenes/mapa.jpg/")){
            Image i=new Image(input);
            BackgroundImage pic = new BackgroundImage(i, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background pica = new Background(pic);
            root.setBackground(pica);
            mapa.setImage(i);
        }catch(IOException f){
            System.out.println("No se encontro la imagen");
        }
    }    
    
}
