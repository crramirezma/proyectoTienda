/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.*;
import Code.Singleton;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author daniel
 */
public class JavaFXApplication4 extends Application {
    ArrayList<Cliente>clientes;
    ArrayList<Empleado>empleados;
    ArrayList<Producto>productos;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Application.launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        clientes=new ArrayList<>();
        empleados=new ArrayList<>();
        productos=new ArrayList<>();
        Tienda tienda=new Tienda("la tienda de doña juana",20000000);
        
        //ejemplo con empleados de prueba
        //"Empleado nivel 1", "Empleado nivel 2", "Administrador" son los tipos de empleados
        Empleado emp1=new Empleado("daniel","3123112027",1000832655,"Administrador");
        Empleado emp2=new Empleado("cristian","3212055883",1000832655,"Empleado nivel 1");
        
        //agregandolos a los arraylist 
        empleados.add(emp1);
        empleados.add(emp2);
        
        //ejemplo con productos de prueba
        Producto p1=new Producto(20,001, "mango");
        Producto p2=new Producto(20, 002, "mangoso");
        //agregandolos a los arraylist 
        productos.add(p1);
        productos.add(p2);
        tienda.agregarProductoVenta(20,001,"mango");
        tienda.agregarProductoVenta(20, 002, "mangoso");
        tienda.agregarEmpleado("Marcos", "3118814540", 1000832655, "Administrador");
        tienda.agregarCliente("carlos", "000", 12243648);
        
        Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Singleton singleton=Singleton.getSingleton();
        singleton.setStage(stage);
        Scene scene = new Scene(root);
        
        //cargar la tienda a los controladores
        Controlador primero=new InicioController();
        primero.setTienda(tienda);
        
        stage.setScene(scene);
        stage.show();
    }

    

    
    
}
