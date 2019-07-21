/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import Code.*;
import java.util.ArrayList;
import javafx.fxml.Initializable;

/**
 *
 * @author daniel
 */
public abstract class Controlador implements Initializable {
    
    //todo este codigo esta programado con estaticos dado que se pueden pasar entre los hijos sin ninguna modificacion aparente
    protected static ArrayList<Empleado>empleados;
    protected static ArrayList<Producto>productos;
    protected static ArrayList<Cliente>clientes;
    protected static Empleado empleado;
    protected static ArrayList<Venta>venta;
    protected static Cliente cliente;

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        Controlador.cliente = cliente;
    }
    public static ArrayList<Venta> getVenta() {
        return venta;
    }

    public static void setVenta(ArrayList<Venta> venta) {
        Controlador.venta = venta;
    }
    public static Empleado getEmpleado() {
        return empleado;
    }

    public static void setEmpleado(Empleado empleado) {
        Controlador.empleado = empleado;
    }
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
}
