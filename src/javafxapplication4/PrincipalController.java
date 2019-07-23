/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

//no olvidar siempre que creen una nueva vista quiten el "implements Initializable" y cambienlo por "extends Controlador"
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
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(tienda.getProductos().size()!=0){
            for(int i=0;i<tienda.getProductos().size();i++){
                if(tienda.getProductos().get(i).getCantidad()>5&&tienda.getProductos().get(i).getCantidad()>=0){
                    
                JOptionPane.showMessageDialog(null,"Tu producto "+tienda.getProductos().get(i).getNombre()+" se agota","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
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
        
        if(this.getEmpleado().getCargo().equals("Administrador")){
            
            
            Parent root= FXMLLoader.load(getClass().getResource("Empleados.fxml"));
            this.tienda.getVentas().clear();
            this.setCliente(null);
            Singleton singleton=Singleton.getSingleton();
            Stage stage=singleton.getStage();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else{
            //Los jOptionpane botan mensajes en la pantalla sin dañar el singleton
            JOptionPane.showMessageDialog(null,"No tienes permiso para esta accion","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void accClientes(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Cliente.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accInven(ActionEvent event) throws IOException {
        Parent root;
        root = FXMLLoader.load(getClass().getResource("Productos.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
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
