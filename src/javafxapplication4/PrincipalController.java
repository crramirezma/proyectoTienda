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
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author daniel
 */
public class PrincipalController extends Controlador {

    @FXML
    private Button btTienda;
    @FXML
    private Button btEmpleados;
    @FXML
    private Button btClientes;
    @FXML
    private Button btInven;
    @FXML
    private Hyperlink btReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accTienda(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Vista.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accEmp(ActionEvent event) throws IOException {
        System.out.println("poderrrr");
        System.out.println(this.getEmpleado().getCargo().getNombre());
        if(this.getEmpleado().getCargo().getNombre().equals("Administrador")){
            Parent root= FXMLLoader.load(getClass().getResource("Empleados.fxml"));
            Singleton singleton=Singleton.getSingleton();
            Stage stage=singleton.getStage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            
            JOptionPane.showMessageDialog(null,"No tienes permiso para esta accion","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void accClientes(ActionEvent event) {
    }

    @FXML
    private void accInven(ActionEvent event) {
    }

    @FXML
    private void accReturn(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
