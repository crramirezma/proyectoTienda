/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.EmpSingleton;
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
    
    
    
    
    
        private final ListChangeListener<Persona> selectorTablaPersonas =
            new ListChangeListener<Persona>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                    ponerPersonaSeleccionada();
                }
            };

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "tablaPersonas"
     */
    public Persona getTablaPersonasSeleccionada() {
        if (tablaPersonas != null) {
            List<Persona> tabla = tablaPersonas.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Persona competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    /**
     * Método para poner en los textFields la tupla que selccionemos
     */
    private void ponerPersonaSeleccionada() {
        final Persona persona = getTablaPersonasSeleccionada();
        posicionPersonaEnTabla = personas.indexOf(persona);

        if (persona != null) {

            // Pongo los textFields con los datos correspondientes
            nombreTF.setText(persona.getNombre());
            apellidoTF.setText(persona.getApellido());
            edadTF.setText(persona.getEdad().toString());
            telefonoTF.setText(persona.getTelefono());

            // Pongo los botones en su estado correspondiente
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);

        }
    }

    /**
     * Método para inicializar la tabla
     */
    private void inicializarTablaPersonas() {
        nombreCL.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
        apellidoCL.setCellValueFactory(new PropertyValueFactory<Persona, String>("apellido"));
        edadCL.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
        telefonoCL.setCellValueFactory(new PropertyValueFactory<Persona, String>("telefono"));

        personas = FXCollections.observableArrayList();
        tablaPersonas.setItems(personas);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void accIniciar(ActionEvent event) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        
        int j=0;
        for(int i=0;i<this.getEmpleados().size();i++){
                if(this.getEmpleados().get(i).getId().equals(this.cont.getText())&&this.getEmpleados().get(i).getNombre().equals(this.usuario.getText())){
                    
                    this.setEmpleado(this.getEmpleados().get(i));
                    System.out.println(this.getEmpleado().getCargo().getNombre());
                    Scene scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }else{
                    j++;
                }
            }
            if(j==this.getEmpleados().size()){
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
