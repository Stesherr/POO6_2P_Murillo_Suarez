/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import generalClases.Usuario;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Window;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private void iniciarSesion(ActionEvent event) throws IOException {
        ArrayList<Usuario> usuarios = Usuario.leerUsuarios();
        ArrayList<Usuario> posiblesUsers = new ArrayList<Usuario>();
        int i = 0;
        while(i<usuarios.size()){
            if (user.getText()!=null && contra.getText()!=null){
                
                if (user.getText() == usuarios.get(i).getUsuario()){
                posiblesUsers.add(usuarios.get(i));
                i++;
            }
            }
            
        }
        if(posiblesUsers.size()==0){
            System.out.println("este usuario no se encuentra registrado en el sistema");
        }else{
            int existe = 0;
            for (int j = 0; j < posiblesUsers.size(); j++) {
                if(contra.getText().equals(posiblesUsers.get(i).getContraseña())){
                    if(posiblesUsers.get(i).getTipo()=="L"){
                        App.setRoot("OpcionesL");
                        existe=1;
                        break;
                    }else{
                        App.setRoot("OpcionesP");
                        existe=1;
                        break;
                    }
                }
            }
            if(existe==0){
                System.out.println("contraseña incorrecta");
            }
        }
        
        
        
       
        
    }

    @FXML
    public void crearCuenta(MouseEvent event) throws IOException {
        
        Stage stage = new Stage();
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "registro.fxml"));
        
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Crear Cuenta");
       
        stage.show();
        
    
}
}
