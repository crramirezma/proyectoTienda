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
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author daniel
 */

//no olvidar siempre que creen una nueva vista quiten el "implements Initializable" y cambienlo por "extends Controlador"
public class VistaController extends Controlador {
    public Cliente cliente;
    private ArrayList<Venta>ventas=new ArrayList<>();
    private Label label;
    @FXML
    private TextField txCliente;
    @FXML
    private TextField txRef;
    @FXML
    private TextField txCantidad;
    //private ObservableList<Venta> obs;
    private int cont;
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
    @FXML
    private Label total;
    @FXML
    private Button btEscCliente;
    @FXML
    private Button btEscoger;
    @FXML
    private DatePicker date;
    @FXML
    private Button btGenerar;
    @FXML
    private Button btTotal;
    @FXML
    private Hyperlink hpReturn;

    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.lbEmpleado.setText(this.empleado.getNombre());
        this.tbProduct.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.tbCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        this.tbReferencia.setCellValueFactory(new PropertyValueFactory<>("referencia"));
        this.tbPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.tbPtotal.setCellValueFactory((new PropertyValueFactory<>("total")));

    }    


    @FXML
    private void accEscCliente(ActionEvent event) {
        
        int j=0;
        for(int i=0;i<getClientes().size();i++){
            if(this.txCliente.getText().equals(getClientes().get(i).getNombre())){
                cliente=getClientes().get(i);
                j=1;
                i=getClientes().size();
            }
        }
        if(j==0){
            JOptionPane.showMessageDialog(null,"Usuario desconocido","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void accEscoger(ActionEvent event) {
        
        Venta ventass;
        
        int cantidad=Integer.parseInt(this.txCantidad.getText());
        if(txRef==null||txCantidad==null){
            JOptionPane.showMessageDialog(null,"Faltan datos","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        int j=0;
        for (int i = 0; i <tienda.getProductos().size(); i++) {
            
            if(this.txRef.getText().equals(tienda.getProductos().get(i).getNombre())){
                System.out.println(cantidad);
                Producto producto;
                producto = tienda.getProductos().get(i);
                j=1;
                
                ventass=new Venta(producto,cantidad);
                ventas.add(ventass);
                table.getItems().add(ventass);
                
                
            }
        }if(j==0){
            JOptionPane.showMessageDialog(null,"Producto no hallado","ERROR",JOptionPane.ERROR_MESSAGE);
            
        }
        
        setVenta(ventas);
    }

    @FXML
    private void accGenerar(ActionEvent event) throws IOException {
        int id;
        int ref;
        int cantidad;
        
        if(this.cliente==null){
            for (int i = 0; i <this.getVenta().size(); i++) {
                cantidad=this.getVenta().get(i).getCantidad();
                ref=this.getVenta().get(i).getReferencia();
                tienda.venderProductoScliente(ref, cantidad);
            }
        }else{
            for (int i = 0; i <this.getVenta().size(); i++) {
                cantidad=this.getVenta().get(i).getCantidad();
                id=cliente.getId();
                ref=this.getVenta().get(i).getReferencia();
                tienda.venderProducto(id, ref, cantidad);
            }
        }
        Parent root= FXMLLoader.load(getClass().getResource("Factura.fxml"));
        
        //no se usa el singleton ya que la idea no es cerrar el programa anterior, si no crear una ventana nueva
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void accTotal(ActionEvent event) {
        
        //resultado total con descuento de 0 a 10 no habra descuento, de 10a 20 un 5%, y de 21 en adelante un 10%
        int sum=0;
        for(int i=0;i<ventas.size();i++){
            sum+=ventas.get(i).getTotal();
            System.out.println("hola");
        }
        if(cliente==null){
            this.total.setText(Integer.toString(sum));
        }else if(this.cliente.getCalificacion()<10){
            this.total.setText(Integer.toString(sum));
        }else if(this.cliente.getCalificacion()>=10&&this.cliente.getCalificacion()<20){
            total.setText(Integer.toString((int) (sum-sum*0.05)));
        }else{
            total.setText(Integer.toString((int) (sum-sum*0.1)));
        } 
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
