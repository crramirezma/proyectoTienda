/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author daniel
 */
public class EmpleadosController extends Controlador {

    @FXML
    private Button btMod;
    @FXML
    private Button btEliminar;
    @FXML
    private TextField txNombre;
    @FXML
    private TextField txApellido;
    @FXML
    private TextField txId;
    @FXML
    private TextField txTelefono;
    @FXML
    private Button btGuardar;
    @FXML
    private Font x11;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accMod(ActionEvent event) {
    }

    @FXML
    private void accEliminar(ActionEvent event) {
    }

    @FXML
    private void accReturn(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void btGuardar(ActionEvent event) {
    }

    
}
