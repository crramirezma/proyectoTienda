package javafxapplication4;
import Code.*;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Font;

/*
/ Declaramos los botones
    @FXML private Button aniadirBT;
    @FXML private Button modificarBT;
    @FXML private Button eliminarBT;
    @FXML private Button nuevoBT;
    
    // Declaramos los textfileds
    @FXML 
    private TextField nombreTF;
    @FXML 
    private TextField celularTF;
    @FXML
    private TextField idTF;
    @FXML
    private TextField calificacionTF;
    
    // Declaramos la tabla y las columnas
    
    
    private TableColumn apellidoCL;
    private TableColumn edadCL;
    private TableColumn telefonoCL;
    private TextField apellidoTF;
    private TextField edadTF;
    private TextField telefonoTF;
    
    
    
    private int posicionPersonaEnTabla;
    @FXML 
    private TableView<Cliente> tablaPersonas;
    @FXML 
    private TableColumn nombreCL;
    @FXML
    private TableColumn celularCL;
    @FXML
    private TableColumn idCL;
    @FXML
    private TableColumn calificacionCL;
    @FXML
    private Font x1;
    @FXML
    
    ObservableList<Cliente> personas;
    
    @FXML private void nuevo(ActionEvent event) {
        nombreTF.setText("");
        celularTF.setText("");
        idTF.setText("");
        calificacionTF.setText("");
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);
        aniadirBT.setDisable(false);
    }

    
    @FXML private void aniadir(ActionEvent event) {
        String nombre=nombreTF.getText();
        String celular=celularTF.getText();
        int id=Integer.parseInt(idTF.getText());
        
        
        Cliente persona = new Cliente(nombre,celular,id);
        personas.add(persona);
    }

    
    @FXML private void modificar(ActionEvent event) {
        String nombre=nombreTF.getText();
        String celular=celularTF.getText();
        int id=Integer.parseInt(idTF.getText());
        int calificacion=Integer.parseInt(calificacionTF.getText());
        Cliente cliente=new Cliente(nombre,celular,id);
        
        personas.set(posicionPersonaEnTabla, cliente);
    }

    
    @FXML private void eliminar(ActionEvent event) {
        personas.remove(posicionPersonaEnTabla);
    }
    
    private final ListChangeListener<Persona> selectorTablaPersonas =new ListChangeListener<Persona>() {
                                                                        @Override
                                                                        public void onChanged(ListChangeListener.Change<? extends Persona> c) {
                                                                            ponerPersonaSeleccionada();
                                                                        }
                                                                    };

    
    public Persona getTablaClienteSeleccionada() {
        if (tablaPersonas != null) {
            List<Cliente> tabla = tablaPersonas.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                final Cliente competicionSeleccionada = tabla.get(0);
                return competicionSeleccionada;
            }
        }
        return null;
    }

    
    private void ponerPersonaSeleccionada() {
        final Cliente cliente = (Cliente) getTablaClienteSeleccionada();
        posicionPersonaEnTabla = personas.indexOf(cliente);

        if (cliente != null) {

            // Pongo los textFields con los datos correspondientes
            nombreTF.setText(cliente.getNombre());
            celularTF.setText(cliente.getCellphone());
            idTF.setText(Integer.toString(cliente.getId()));
            calificacionTF.setText(Double.toString(cliente.getCalificacion()));

            // Pongo los botones en su estado correspondiente
            modificarBT.setDisable(false);
            eliminarBT.setDisable(false);
            aniadirBT.setDisable(true);

        }
    }

    
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

        // Inicializamos la tabla
        this.inicializarTablaPersonas();

        // Ponemos estos dos botones para que no se puedan seleccionar
        modificarBT.setDisable(true);
        eliminarBT.setDisable(true);

        // Seleccionar las tuplas de la tabla de las personas
        final ObservableList<Cliente> tablaPersonaSel = tablaPersonas.getSelectionModel().getSelectedItems();
        tablaPersonaSel.addListener(selectorTablaPersonas);

        // Inicializamos la tabla con algunos datos aleatorios
       
    }
*/
/**
 *
 * @author Richard
 */
public class ClienteController extends Controlador {

    @FXML
    private TableView<?> tablaPersonas;
    @FXML
    private TableColumn<?, ?> nombreCL;
    @FXML
    private TableColumn<?, ?> celularCL;
    @FXML
    private TableColumn<?, ?> idCL;
    @FXML
    private TableColumn<?, ?> calificacionCL;
    @FXML
    private Font x1;
    @FXML
    private TextField nombreTF;
    @FXML
    private TextField celularTF;
    @FXML
    private TextField idTF;
    @FXML
    private TextField calificacionTF;
    @FXML
    private Button aniadirBT;
    @FXML
    private Button modificarBT;
    @FXML
    private Button eliminarBT;
    @FXML
    private Button nuevoBT;
    @FXML
    private Button btGuardar;
    @FXML
    private Font x11;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("hola");
    }

    @FXML
    private void aniadir(ActionEvent event) {
    }

    @FXML
    private void modificar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }

    @FXML
    private void nuevo(ActionEvent event) {
    }

    @FXML
    private void btGuardar(ActionEvent event) {
    }

    
}

