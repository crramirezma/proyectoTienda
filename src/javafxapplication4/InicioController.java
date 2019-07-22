/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.*;
import Code.Empleado;
import Code.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author daniel
 */




//no olvidar siempre que creen una nueva vista quiten el "implements Initializable" y cambienlo por "extends Controlador"
public class InicioController extends Controlador{

    @FXML
    private TextField usuario;
    @FXML
    private TextField cont;
    @FXML
    private Button iniciarSesion;
    @FXML
    private Hyperlink crear;
    
    @FXML
    private AnchorPane rootPane;
    @FXML
    private HBox root;
    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accIniciar(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        //validacion de datos de inicio, solo creara la nueva escena si se cumplen los parametros del if
        int j=0;
        for(int i=0;i<this.getEmpleados().size();i++){
                if(getEmpleados().get(i).getId()==Integer.parseInt(this.cont.getText())&&getEmpleados().get(i).getNombre().equals(this.usuario.getText())){
                    
                    this.setEmpleado(this.getEmpleados().get(i));
                    j=1;
                    Scene scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
            if(j==0){
                JOptionPane.showMessageDialog(null,"Contraseña y/o correo incorrecto","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        
    }

    @FXML
    private void accCrear(ActionEvent event)throws Exception{
        Parent root= FXMLLoader.load(getClass().getResource("CrearCuenta.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
