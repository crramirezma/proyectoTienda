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
    static ArrayList<Cliente>clientes;
    static ArrayList<Empleado>empleados;
    static ArrayList<Producto>productos;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clientes=new ArrayList<>();
        empleados=new ArrayList<>();
        productos=new ArrayList<>();
        Cargo cargo=new Cargo("Administrador");
        Empleado emp1=new Empleado("daniel","1000832655","3123112027",null);
        Empleado emp2=new Empleado("cristian","1000832655","3212055883",null);
        Empleado emp3=new Empleado("felipe","1000832655","48596712",null);
        empleados.add(emp1);
        empleados.add(emp2);
        empleados.add(emp3);
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Inicio.fxml"));
        Singleton singleton=Singleton.getSingleton();
        singleton.setStage(stage);
        Scene scene = new Scene(root);
        Controlador hola=new InicioController();
        hola.setClientes(clientes);
        hola.setEmpleados(empleados);
        hola.setProductos(productos);
        stage.setScene(scene);
        stage.show();
    }

    
    
}
