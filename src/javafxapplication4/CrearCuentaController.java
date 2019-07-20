/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.Cargo;
import Code.Empleado;
import Code.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author daniel
 */
public class CrearCuentaController extends Controlador {
    ;
    @FXML
    private Hyperlink hpReturn;
    @FXML
    private ChoiceBox<String> cBox;
    @FXML
    private PasswordField txAdmin;
    @FXML
    private TextField txNombre;
    @FXML
    private TextField txId;
    @FXML
    private Button btCrear;
    @FXML
    private TextField txTelefono;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        System.out.println("hola");
        
        cBox.getItems().addAll("Empleado nivel 1", "Empleado nivel 2", "Administrador");
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

    @FXML
    private void accCrear(ActionEvent event) {
        String nombre=this.txNombre.getText();
        String id=this.txId.getText();
        Cargo cargo=new Cargo(this.cBox.getSelectionModel().getSelectedItem());
        String telefono=this.txTelefono.getText();
        Empleado empleado=new Empleado(nombre,id,telefono,cargo);
        for(int i=0;i<this.empleados.size();i++){
            if(((this.empleados.get(i).getNombre().equals(nombre)&&this.empleados.get(i).getId().equals(id))||this.empleados.get(i).getId().equals(id))){
                txId.clear();
                JOptionPane.showMessageDialog(null,"Contraseña y/o correo repetido","ERROR",JOptionPane.ERROR_MESSAGE);
                i=this.empleados.size();
            }
        }
        if(txId.getText().equals("")||txId.getId().equals("")||this.cBox.getSelectionModel().getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,"Faltan datos","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        if(txAdmin.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Falta la contraseña de admin","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            int i;
            int j=0;
            for(i=0;i<this.empleados.size()&&j==0;i++){
                if(this.empleados.get(i).getId().equals(txAdmin.getText())){
                    empleados.add(empleado);
                    JOptionPane.showMessageDialog(null,"usuario agregado","ERROR",JOptionPane.PLAIN_MESSAGE);
                    System.out.println("creado");
                    j++;
                }
                    
            }
            if(i==this.empleados.size()){
                JOptionPane.showMessageDialog(null,"No existe Adinistrador con esa cuenta","ERROR",JOptionPane.ERROR_MESSAGE);
                i=this.empleados.size();
            }
            
        }
        
    }

    

    
    
}

    
