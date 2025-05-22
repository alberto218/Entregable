package poiupv;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ListaControlador implements Initializable {

    @FXML
    private ListView<ejercicios> listaProblema;
    @FXML
    private Button botonRealizarProblema;
    
    private ObservableList<ejercicios> listaEjercicios = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarBaseDeDatos();
        listaProblema.setItems(listaEjercicios);
    }

    @FXML
    private void irAProblema(ActionEvent evento) {
        ejercicios ejercicioSeleccionado = listaProblema.getSelectionModel().getSelectedItem();
        if (ejercicioSeleccionado != null) {
            System.out.println("Ejercicio seleccionado: " + ejercicioSeleccionado.getTexto());
        }
    }

    private void cargarBaseDeDatos() {
        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:data.db");
             Statement smt = conexion.createStatement()) {
            
            String sql = "SELECT p.text, a.text as respuesta, a.validity " +
                         "FROM problem p JOIN answer a ON p.id = a.problem_id " +
                         "ORDER BY p.id, a.id";
            
            ResultSet resultado = smt.executeQuery(sql);
            
            String textoEjercicio = null;
            List<String> respuestas = new ArrayList<>();
            int respuestaCorrecta = -1;
            int idEjercicioActual = -1;
            
            while (resultado.next()) {
                int idEjercicio = resultado.getInt("p.id");
                String texto = resultado.getString("p.text");
                String respuesta = resultado.getString("a.text");
                boolean esCorrecta = resultado.getBoolean("a.validity");
                
                if (idEjercicio != idEjercicioActual) {
                    if (textoEjercicio != null) {
                        listaEjercicios.add(new ejercicios(textoEjercicio, respuestas, respuestaCorrecta));
                    }
                    
                    textoEjercicio = texto;
                    respuestas = new ArrayList<>();
                    respuestaCorrecta = -1;
                    idEjercicioActual = idEjercicio;
                }
                
                respuestas.add(respuesta);
                if (esCorrecta) {
                    respuestaCorrecta = respuestas.size() - 1;
                }
            }
            
            if (textoEjercicio != null) {
                listaEjercicios.add(new ejercicios(textoEjercicio, respuestas, respuestaCorrecta));
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
    
