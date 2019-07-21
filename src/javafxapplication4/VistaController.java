/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.*;
import Code.Singleton;
import Code.Venta;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */
public class VistaController extends Controlador {
    public Cliente cliente;
    private ArrayList<Venta>ventas=new ArrayList<>();
    private Label label;
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
    //private ObservableList<Venta> obs;
    private int cont;
    @FXML
    private DatePicker date;
    @FXML
    private TableView<Venta> table;
    @FXML
    private TableColumn<Venta,String> tbProduct;
    @FXML
    private TableColumn<Venta,Integer> tbCantidad;
    @FXML
    private TableColumn<Venta,String> tbReferencia;
    @FXML
    private TableColumn<Venta,Integer> tbPrecio;
    @FXML
    private TableColumn tbPtotal;
    @FXML
    private Label lbEmpleado;
    
    
    /**
     * Listener de la tabla 
     
    
        private final ListChangeListener<Venta> selectorTablaPersonas =
            new ListChangeListener<Venta>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends Venta> c) {
                    ponerVentaSeleccionada();
                }
            };*/

    /**
     * PARA SELECCIONAR UNA CELDA DE LA TABLA "table"
     * @return 
     
    public Venta getTablaVentasSeleccionada() {
        if (table != null) {
            List<Venta>tabla = table.getSelectionModel().getSelectedItems();
            
            if (tabla.size() == 1) {
                final Venta competicionSeleccionada;
                competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }*/

    /**
     * Método para poner en los textFields la tupla que selccionemos
     
    private void ponerVentaSeleccionada() {
        final Venta ventas = getTablaVentasSeleccionada();
        cont = obs.indexOf(ventas);

        if (ventas != null) {

            // Pongo los textFields con los datos correspondientes
            this..setText(persona.getNombre());
            apellidoTF.setText(persona.getApellido());
            edadTF.setText(persona.getEdad().toString());
            telefonoTF.setText(persona.getTelefono());

            // Pongo los botones en su estado correspondiente
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);

        }
    }*/

    /**
     * Método para inicializar la tabla
     
    private void inicializarTablaPersonas() {
        tbProduct.setCellValueFactory(new PropertyValueFactory<Venta, String>("Producto"));
        this.tbCantidad.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("Cantidad"));
        this.tbPrecio.setCellValueFactory(new PropertyValueFactory<Venta, Integer>("precio"));
        this..setCellValueFactory(new PropertyValueFactory<Persona, String>("telefono"));

        personas = FXCollections.observableArrayList();
        tablaPersonas.setItems(personas);
    }*/
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lbEmpleado.setText(this.empleado.getNombre());
        this.tbProduct.setCellValueFactory(new PropertyValueFactory<>("name"));
        this.tbCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        this.tbReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        this.tbPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.tbPtotal.setCellValueFactory((new PropertyValueFactory<>("total")));

    }    


    @FXML
    private void accEscCliente(ActionEvent event) {
        
        int j=0;
        for(int i=0;i<clientes.size();i++){
            if(this.txCliente.getText().equals(clientes.get(i).getId())){
                cliente=clientes.get(i);
                j=1;
                i=clientes.size();
            }
        }
        if(j==0){
            JOptionPane.showMessageDialog(null,"Usuario desconocido","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void accEscoger(ActionEvent event) {
        
        Venta venta;
        
        int cantidad=Integer.parseInt(this.txCantidad.getText());
        
        int j=0;
        for (int i = 0; i <productos.size(); i++) {
            
            if(this.txRef.getText().equals(productos.get(i).getNombre())){
                System.out.println(cantidad);
                Producto producto;
                producto = productos.get(i);
                j=1;
                venta=new Venta(producto,cantidad);
                ventas.add(new Venta(producto,cantidad));
                table.getItems().add(venta);
                //obs.add(venta);
                i=productos.size();
            }
        }if(j==0){
            JOptionPane.showMessageDialog(null,"Producto no hallado","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        
        
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
