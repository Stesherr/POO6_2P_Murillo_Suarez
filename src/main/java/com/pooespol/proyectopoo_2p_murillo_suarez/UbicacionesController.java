/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import extraClases.Locales;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

    
    @FXML
    private Pane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try(FileInputStream input=new FileInputStream("src/main/resources/imagenes/mapa.jpg")){
            Image i=new Image(input,800, 1200, true, true);
            
            BackgroundImage pic = new BackgroundImage(i, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            
            Background pica = new Background(pic);
            root.setBackground(pica);
            
            
        }catch(IOException f){
            System.out.println("No se encontro la imagen");
        }
        /*
        ArrayList<Locales> localess = Locales.leerArchivo();
        for(Locales local : localess){
            Random ran = new Random();
            int i = ran.nextInt(11);
            String seg = (i+"000");
            int segun = Integer.parseInt(seg);
            try(FileInputStream input=new FileInputStream("src/main/resources/imagenes/indicador.jpg")){
            Image im=new Image(input,40, 40, true, true);
            BackgroundImage pic = new BackgroundImage(im, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background ind = new Background(pic);
            
            Pane panelI = new Pane();
            panelI.setBackground(ind);
            panelI.setMaxSize(40, 40);
            panelI.setLayoutX(local.getCoordenadaX());
            panelI.setLayoutY(local.getCoordenadaY());
                try {
                    panelI.wait(segun);
                    panelI.setVisible(true);
                } catch (InterruptedException ex) {
                }
               
            }catch(IOException f){
            System.out.println("No se encontro la imagen");
        }
        }*/
    }    
    
}
