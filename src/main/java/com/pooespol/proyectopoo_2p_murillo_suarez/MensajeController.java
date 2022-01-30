/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;


//import com.google.inject.Stage;
import static com.pooespol.proyectopoo_2p_murillo_suarez.AgendarCita2Controller.vFinal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.text.Text;
import javafx.stage.Window;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class MensajeController implements Initializable {

    @FXML
    private Text textConteo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Thread para mostrar el contador de segundos y llegado a los 5 segundos cerrar el programa
        Thread thread = new Thread(new Runnable(){
                @Override
                public void run(){
                    for(int i=0; i<=5; i++){
                        textConteo.setText("Se cierra en  " + (5-i)+" segundos...");
                        if(i==5){
                            Platform.exit();
                                    
                        }
                        try{
                            Thread.sleep(1000);                      
                        }catch(InterruptedException ex){
                            System.out.println("Se ha interrupindo el hilo");
                        }
                    }
                }
            });
            thread.start();
        }

    
        
    
}
