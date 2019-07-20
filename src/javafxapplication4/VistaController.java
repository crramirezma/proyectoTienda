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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author daniel
 */
public class VistaController extends Controlador {
    
    private Label label;
    @FXML
    private TextField txVendedor;
    @FXML
    private Button btEscVen;
    @FXML
    private TextField txCliente;
    @FXML
    private Button btEscCliente;
    @FXML
    private TextField txRef;
    @FXML
    private TextField txCantidad;
    @FXML
    private Button btEscoger;
    @FXML
    private Button btGenerar;
    @FXML
    private Button btTotal;
    @FXML
    private Hyperlink hpReturn;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accEscVendedor(ActionEvent event) {
    }

    @FXML
    private void accEscCliente(ActionEvent event) {
    }

    @FXML
    private void accEscoger(ActionEvent event) {
    }

    @FXML
    private void accGenerar(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Factura.fxml"));
        
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accTotal(ActionEvent event) {
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
    
}
