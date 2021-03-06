/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import static com.pooespol.proyectopoo_2p_murillo_suarez.OpcionesPController.stage;

import extraClases.Prueba;
import generalClases.Paciente;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class AgendarCitaController implements Initializable {

    public static ArrayList<Prueba> pruebas = Prueba.leerArchivo();
    public static Double subT = 0.0;
    public static ArrayList<String> nombres ;
    public static ArrayList<Prueba> tests ;

   
    
    

    @FXML
    private TextField cantidad;
    @FXML
    private ComboBox<String> tipoPVBox;
    @FXML
    private ComboBox<Prueba> pruebaVBox;
    @FXML
    private Text valorU;
    @FXML
    private Button botonAgregar;
    @FXML
    private VBox nombreVb;
    @FXML
    private VBox cantidadVb;
    @FXML
    private VBox precioVb;
    @FXML
    private GridPane gridTotal;
    @FXML
    private Text subTotal;
    @FXML
    private Text serDomicilio;
    @FXML
    private Text total;
    @FXML
    private Button botonContinuar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nombres = new ArrayList<>();
        tests = new ArrayList<Prueba>();
        subT = 0.0;
        ArrayList tipos = Prueba.cargarTipoP();
        tipoPVBox.getItems().setAll(tipos);

        botonAgregar.setStyle("-fx-background-color: #3066e3 ; -fx-font-weight: bold");
        botonAgregar.setTextFill(Color.WHITE);

        botonContinuar.setStyle("-fx-background-color: #3066e3 ; -fx-font-weight: bold");
        botonContinuar.setTextFill(Color.WHITE);
        
    }

    @FXML
    private void desplegarTipoP(ActionEvent event) {

        valorU.setText(null);

        String opcion = tipoPVBox.getValue();
        ArrayList<Prueba> pTipo = new ArrayList<>();
        for (Prueba prueba : pruebas) {
            if (prueba.getTipoPrueba().equals(opcion)) {
                pTipo.add(prueba);
            }
        }
        pruebaVBox.getItems().setAll(pTipo);
    }

    @FXML
    private void desplegarPrueba(ActionEvent event) {
        valorU.setText(null);
        valorU.setText(null);
        Prueba opcion = pruebaVBox.getValue();
        valorU.setText(opcion.getPrecio().toString());

    }
    
    // EventController para agregar los datos ingresados en el detalle de cita y el total a pagar 
    @FXML
    private void agregarP(ActionEvent event) {
        String cant = cantidad.getText();
        Prueba opcion;
        Double precio;
        
        
        try {            
            opcion = pruebaVBox.getValue();            
            precio = (Double.parseDouble(valorU.getText())) * (Integer.parseInt(cant));
            tests.add(opcion);
            nombres.add(opcion.getNombrePrueba());
            System.out.println(opcion.getNombrePrueba());
            subT = subT + precio;
            Double tota = 5.0 + subT;
            subTotal.setText(subT.toString());
            serDomicilio.setText("5.00");
            total.setText(tota.toString());
            
            Label nombre = new Label(pruebaVBox.getValue().toString());
            Label cantidad = new Label(cant);
            Label precioL = new Label(precio.toString());
            nombreVb.getChildren().add(nombre);
            cantidadVb.getChildren().add(cantidad);
            precioVb.getChildren().add(precioL);
            
        } catch (Exception e) {
            
            System.out.println(" Campos incompletos, no se puede agregar");
        }

    }
    
    // EventController para cambiar de ventana a la de AgendarCita2
    @FXML
    private void continuar(ActionEvent event) throws IOException {
        if (tests.size() != 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("agendarCita2.fxml"));

            stage.setScene(new Scene(fxmlLoader.load()));
            stage.setTitle("Agendar Prueba");

            stage.show();
        } else {
            System.out.println("no se ha agregado ninguna prueba ");
        }
    }

}
