/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pooespol.proyectopoo_2p_murillo_suarez;

import static com.pooespol.proyectopoo_2p_murillo_suarez.AgendarCitaController.nombres;
import static com.pooespol.proyectopoo_2p_murillo_suarez.AgendarCitaController.subT;
import static com.pooespol.proyectopoo_2p_murillo_suarez.AgendarCitaController.tests;

import static com.pooespol.proyectopoo_2p_murillo_suarez.OpcionesPController.pac;

import extraClases.Prueba;
import extraClases.Solicitud;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author josem
 */
public class AgendarCita2Controller implements Initializable {

    public static Stage vFinal = new Stage();

    public Solicitud solicit;
    public Double x = 0.0;
    public Double y = 0.0;
    public int j = 0;

    @FXML
    private Button botonFinalizar;
    @FXML
    private TextField direccion;
    @FXML
    private ComboBox<String> hora;
    @FXML
    private DatePicker fecha;
    @FXML
    private Pane pane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hora.getItems().addAll("10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:0", "18:00", "19:00", "20:00");

        botonFinalizar.setStyle("-fx-background-color: #3066e3 ; -fx-font-weight: bold");
        botonFinalizar.setTextFill(Color.WHITE);

        try (FileInputStream input = new FileInputStream("src/main/resources/imagenes/mapa.jpg")) {
            Image i = new Image(input, 800, 1200, true, true);

            BackgroundImage pic = new BackgroundImage(i, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

            Background pica = new Background(pic);
            pane.setBackground(pica);

            try (FileInputStream fis = new FileInputStream("src/main/resources/imagenes/posicionador.jpg")) {
                Image img = new Image(fis, 30, 30, false, false);
                ImageView imgView = new ImageView(img);
                
                // Dise??o din??mico de la interfaz para mostrar un indicador donde cliquea el usuario
                pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        x = t.getX();
                        y = t.getY();
                        imgView.relocate(t.getX() - 15, t.getY() - 30);
                        if (j == 0) {
                            pane.getChildren().addAll(imgView);
                            j++;
                        }
                    }

                });

            } catch (IOException e) {
                System.out.println("Imagen no encontrada...");
            }

        } catch (IOException f) {
            System.out.println("No se encontro la imagen");
        }
    }

    @FXML
    private void finalizar(ActionEvent event) throws IOException {
        if (x == 0.0 || y == 0.0) {
            System.out.println("no se ha seleccionado la ubicacion");
        } else {
            try {
                String date = fecha.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Double total = subT + 5;
                solicit = new Solicitud(pac, direccion.getText(), date, hora.getValue(), x, y, total);
                solicit.escribirArchivo();
                for (Prueba pru : tests) {
                    solicit.detallarArchivo(pru);
                }
                String nombre = "";
                for (String str : nombres) {
                    nombre += "\n";
                    nombre += str;

                }
                solicit.enviarCorreo(pac, nombre);

                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mensaje.fxml"));

                vFinal.setScene(new Scene(fxmlLoader.load()));
                vFinal.setTitle("Informaci??n final");

                vFinal.show();

            } catch (NullPointerException e) {
                System.out.println("algunos espacios no han sido llenados");
            }

        }
    }

}
