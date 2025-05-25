/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poiupv;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
//import model.Acount;
//import static model.Acount.getInstance;
//import model.AcountDAOException;
//import model.User;

/**
 *
 * @author Diego Molina
 */
public class Login {

    @FXML
    private BorderPane borderpane;
    @FXML
    private Label titulo;
    @FXML
    private Label labelRegistro;
    @FXML
    private GridPane gridpane2;
    @FXML
    private TextField nickText;
    @FXML
    private PasswordField contraText;
    @FXML
    private Button botonLogin;
    @FXML
    private Label labelNick;
    @FXML
    private Label labelEstado;
    
    

    /*@FXML
    private void iniciarSesion(ActionEvent event) throws AcountDAOException, IOException {
        String usuario = nickText.getText();
        String contraseña = contraText.getText();
        
        Acount acount = getInstance();
        
        if (usuario.isEmpty() && contraseña.isEmpty()){
            labelEstado.setText("Porfavor, introduzca su contraseña");
            labelNick.setText("Porfavor, introduzca su nickname");
            nickText.setStyle("-fx-border-color: red;");
            contraText.setStyle("-fx-border-color: red;");
        } 
            else if(usuario.isEmpty() && !contraseña.isEmpty()){
            labelNick.setText("Porfavor, introduzca su nickname");
            labelEstado.setText("");
            nickText.setStyle("-fx-border-color: red;");            
            contraText.setStyle("");
        }
            else if(!usuario.isEmpty() && contraseña.isEmpty()){
            labelEstado.setText("Porfavor, introduzca su contraseña");
            labelNick.setText("");
            nickText.setStyle("");
            contraText.setStyle("-fx-border-color: red;");
        }
            else if(usuario.isEmpty()){
            labelEstado.setText("Porfavor, introduzca su nickname");
            labelNick.setText("");
            nickText.setStyle("-fx-border-color: red;");
            contraText.setStyle("");

        }
            else if (acount.existsLogin(usuario)== true){
                  if(acount.logInUserByCredentials(usuario, contraseña)== false){
                      labelEstado.setText("Contraseña incorrecta, vuelva a intentarlo");
                      labelNick.setText("");
                  } else{
                      acount.logInUserByCredentials(usuario, contraseña);
                      FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/poiupv/MenuPrincipal.fxml"));
                      Parent root = miCargador.load();
                      
                      // Obtenemos el tamaño de la pantalla principal
                      Screen screen = Screen.getPrimary();
                      Rectangle2D bounds = screen.getVisualBounds();
                      
                      Scene scene = new Scene(root,1000,1000);
                      Stage stage = new Stage();
                      stage.setScene(scene);
                      stage.setTitle("Menú");
                      stage.setResizable(true);
                      stage.setMinHeight(600);
                      stage.setMinWidth(700);
                      stage.show();
                      Stage myStage = (Stage) labelEstado.getScene().getWindow();
                      myStage.close();
                      
                    }
            }
                else if (acount.existsLogin(usuario)== false){
                    labelEstado.setText("Usuario o contraseña incorrectos");
                    labelNick.setText("Este nickname no está registrado");
                    nickText.setStyle("-fx-border-color: red;");
                    contraText.setStyle("-fx-border-color: red;");
                }
    
    } */

    @FXML
    private void registrarse(MouseEvent event) throws IOException {
        FXMLLoader miCargador = new FXMLLoader(getClass().getResource("/poiupv/Registrarse.fxml"));
        Parent root = miCargador.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Registrarse");
        stage.setResizable(true);
        stage.setMinHeight(510);
        stage.setMinWidth(400);
        stage.setMaxHeight(720);
        stage.setMaxWidth(600);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    @FXML
    private void handleLabelSalida(MouseEvent event) {
        labelRegistro.setStyle("-fx-text-fill: #FFFFFF;");
    }

    @FXML
    private void handleLabelRegistro(MouseEvent event) {
        labelRegistro.setStyle("-fx-text-fill: #000000;");
    }
}
