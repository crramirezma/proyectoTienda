/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.Singleton;
import Code.Venta;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author daniel
 */
public class FacturaController extends Controlador {

    @FXML
    private AnchorPane root;
    @FXML
    private Label nombre;
    @FXML
    private Label Cedula;
    @FXML
    private TableColumn<Venta,String> tableDescrip;
    @FXML
    private TableColumn<Venta,Integer> tableCant;
    @FXML
    private TableColumn<Venta,Integer> tablePrecio;
    @FXML
    private TableColumn<Venta,Integer> tableTotal;
    @FXML
    private Label total;
    @FXML
    private Hyperlink hlRegresar;
    @FXML
    private TableView<Venta> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*las siguientes lineas de codigo muestran como programar a las columnas en la tabla, el string encerrado en el contructor hace referencia a que el programa buscara en la clase asignada como un
        get
        ejemplo:
        
        @FXML
        private TableColumn<Venta,String> tableDescrip;....linea 40
        
        
        this.tableDescrip.setCellValueFactory(new PropertyValueFactory<>("name"));linea 73
            
        el programa buscara dentro de la clase Venta un metodo llamado getName, si no lo encuentra simplementa no guardara los datos en la tabla

*/

        this.tableDescrip.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.tableCant.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        this.tablePrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.tableTotal.setCellValueFactory((new PropertyValueFactory<>("total")));
        
        
        /*
        ahora para agregar los datos deseados en las columnas antes inicializadas, existen dos foras, una es crear cada objeto por separado, o la otra es usar una coleccion de objetos e ir agregandolo
        restricciones y errores comunes:
        el TableViewer debe especificar la clase de los objetos que se le van a cargar, por defecto scene builder no define que clase usara, por lo que es cuestion de el programador modificar ello
        ejemplo:
        private TableView<?> table; el scene builder generara por defecto el objeto de esta forma
        
        private TableView<Venta> table; dentro de los mayores y menores se especifica la clase
        
        */
        
        
        
        //evaluar los datos del cliente y cargarlos a sus respectivos Labels
        if(this.cliente==null){
            this.nombre.setText("");
            this.Cedula.setText("");
        }else{
            this.nombre.setText(this.cliente.getNombre());
            this.Cedula.setText(Integer.toString(this.cliente.getId()));
        }
        
        //resultado total con descuento de 0 a 10 no habra descuento, de 10a 20 un 5%, y de 21 en adelante un 10%
        
        int sum=0;
        System.out.println("aqui");
        for(int i=0;i<FacturaController.venta.size();i++){
            sum+=venta.get(i).getTotal();
            table.getItems().add(venta.get(i));
        }
        if(FacturaController.cliente==null){
            this.total.setText(Integer.toString(sum));
        }else if(FacturaController.cliente.getCalificacion()<10){
            total.setText(Integer.toString(sum));
        }else if(FacturaController.cliente.getCalificacion()>=10&&FacturaController.cliente.getCalificacion()<20){
            total.setText(Integer.toString((int) (sum-sum*0.05)));
        }else{
            total.setText(Integer.toString((int) (sum-sum*0.1)));
        }        
        
        
    }    

    @FXML
    private void accRegresar(ActionEvent event) throws IOException {
        
        Parent root= FXMLLoader.load(getClass().getResource("Principal.fxml"));
        Singleton singleton=Singleton.getSingleton();
        Stage stage=singleton.getStage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
