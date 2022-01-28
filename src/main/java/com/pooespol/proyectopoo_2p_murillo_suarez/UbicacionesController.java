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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

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
        
        ArrayList<Locales> locales = Locales.leerArchivo();
        for(Locales local: locales){
            try {
                construirPane(local);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        
    }  
    
    public void crearThreadContador(Label l){
           Thread t = new Thread(new Runnable(){
               @Override
               public void run() {
                   int i = 0;
                   while(i<5) {
                       
                       String status = "Mostrando "+(i+1) + " segundos...";
                       Platform.runLater(new Runnable() {
                           @Override
                           public void run() {
                               l.setText(status);
                           }
                       });
                       i++;
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException ex) {
                           ex.printStackTrace();
                       }
                       
                   }
               }
           });
           
           t.setDaemon(true);
           t.start();
           
   
    }
    
    public void crearThreadCerrarVentana(Stage stag){
           Thread t = new Thread(new Runnable(){
               @Override
               public void run() {
                   int i = 0;
                   while(i<6) {
                       
                       if(i==5){
                          Platform.runLater(new Runnable() {
                           @Override
                           public void run() {
                               stag.close();
                           }
                       });
                       i++;
                       try {
                           Thread.sleep(1000);
                       } catch (InterruptedException ex) {
                           ex.printStackTrace();
                       } 
                       }
                       
                       
                   }
               }
           });
           
           t.setDaemon(true);
           t.start();
           
   
    }
    
    public void abrirVentanaAdicional(Locales local) throws InterruptedException{
        Stage stage = new Stage();
        stage.setTitle("Detalles");
        
        Label nombre = new Label("Vithas Labs " );
        nombre.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        nombre.setStyle("-fx-text-fill: white");
        Label direc = new Label(local.getDireccion() );
        Label horario = new Label("Horario:   "+local.getHorario() );
        
        Label tiempoT = new Label();
        
        Button btncerrar = new Button("Cerrar");
        btncerrar.setStyle("-fx-background-color: blue ; -fx-text-fill: white" );
        
        
        VBox root = new VBox(nombre, direc, horario,  tiempoT, btncerrar);
        
        
        btncerrar.setOnAction(e -> stage.close());
        
        
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setStyle("-fx-background-color: lightblue");
                
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setMaxHeight(300);
        stage.setMaxWidth(250);
        stage.setMinHeight(300);
        stage.setMinWidth(250);
        
        stage.show();
        crearThreadContador(tiempoT);
        crearThreadCerrarVentana(stage);
        
        
        
     
     }
    
    
     public void construirPane(Locales local) throws InterruptedException{
        /*andom rand = new Random();
        int segundos = rand.nextInt(11)*1000;
        wait(segundos);*/
        ImageView imgView = null;
        try(FileInputStream fis = new FileInputStream("src/main/resources/imagenes/indicador.jpg")) {
            Image img = new Image(fis, 30, 30, false, false);
            imgView = new ImageView(img);
            
        } catch(IOException e) {
            System.out.println("Imagen no encontrada...");
        }
         imgView.relocate(local.getCoordenadaX(), local.getCoordenadaY());
         root.getChildren().addAll(imgView);
         
         
         imgView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                System.out.println("Abriendo nueva ventana...");
                try {
                    abrirVentanaAdicional(local);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
             
         });
         
     }
    
}
