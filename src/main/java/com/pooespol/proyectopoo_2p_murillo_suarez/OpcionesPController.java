/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import static com.pooespol.proyectopoo_2p_murillo_suarez.PaginaIController.cliente;
import generalClases.Paciente;
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
public class OpcionesPController implements Initializable {

    public static Paciente pac = Paciente.obtenerPaciente(cliente);
    public static Stage stage = new Stage();
    
    @FXML
    private Text bienvenida;
    @FXML
    private Button conocerButton;
    @FXML
    private Button solicitarButton;
    @FXML
    private GridPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // cambio de colores a los botones
        bienvenida.setFill(Color.WHITE);
        bienvenida.setText("Bienvenid@ "+PaginaIController.cliente.getUsuario());
        
        conocerButton.setStyle("-fx-background-color: Blue");
        conocerButton.setTextFill(Color.WHITE);
        
        solicitarButton.setStyle("-fx-background-color: Blue");
        solicitarButton.setTextFill(Color.WHITE);
        
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
    private void conocerUbicaciones(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "ubicaciones.fxml"));
        
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Ubicaciones");
        stage.setMaxHeight(400);
        stage.setMaxWidth(650);
        stage.setMinHeight(400);
        stage.setMinWidth(650);
        stage.show();
    }

    @FXML
    private void solicitarPruebas(ActionEvent event) throws IOException {
        
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "agendarCita.fxml"));
        
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Agendar Prueba");
       
        stage.show();
    }
    
}
