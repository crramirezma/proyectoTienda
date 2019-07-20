/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author daniel
 */
public class ProductosController extends Controlador {

    @FXML
    private TextField txReferencia;
    @FXML
    private TextField txProducto;
    @FXML
    private TextField txCantidad;
    @FXML
    private TextField txesVenta;
    @FXML
    private TextField txPrecio;
    @FXML
    private Button btMod;
    @FXML
    private Button btProveedores;
    @FXML
    private Button btAdd;
    @FXML
    private Button btEliminar;
    @FXML
    private Hyperlink hlReturn;

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
    private void accProv(ActionEvent event) {
        if(this.getEmpleado().getCargo().getNombre().equals("Empleado nivel 1")){
            JOptionPane.showMessageDialog(null,"Esta accion no esta permitida para ti","ERROR",JOptionPane.ERROR_MESSAGE);
        }else{
            System.out.println("permiso");
        }
        
        
        
    }

    @FXML
    private void accAdd(ActionEvent event) {
    }

    @FXML
    private void accEliminar(ActionEvent event) {
    }

    @FXML
    private void accReturn(ActionEvent event) {
    }
    
}
