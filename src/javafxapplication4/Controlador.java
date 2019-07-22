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
    
    //correccion nueva
    protected static Tienda tienda;
    protected static Cliente cliente;
    protected static Empleado empleado;
    protected static ArrayList<Venta>venta;
    //todo este codigo esta programado con estaticos dado que se pueden pasar entre los hijos sin ninguna modificacion aparente

    public static ArrayList<Venta> getVenta() {
        return venta;
    }

    public static void setVenta(ArrayList<Venta> venta) {
        
        Controlador.venta = venta;
    }
    
    public static Empleado getEmpleado() {
        return empleado;
    }

    public static Tienda getTienda() {
        return tienda;
    }

    public static void setTienda(Tienda tienda) {
        Controlador.tienda = tienda;
    }
    
    

    public static Cliente getCliente() {
        return cliente;
    }
    public static void setCliente(Cliente cliente) {
        Controlador.cliente = cliente;
    }
    
    
    public static void setEmpleado(Empleado empleado) {
        Controlador.empleado = empleado;
    }
    public ArrayList<Empleado> getEmpleados() {
        ArrayList<Empleado>empleados=new ArrayList<>();
        Persona persona;
        for(int i=0;i<tienda.getPersonas().size();i++){
            persona=this.tienda.getPersonas().get(i);
            if(persona instanceof Empleado) {
                empleados.add((Empleado) persona);
            }
        }
        return empleados;
    }

    public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente>clientes=new ArrayList<>();
        Persona persona;
        for(int i=0;i<tienda.getPersonas().size();i++){
            persona=this.tienda.getPersonas().get(i);
            if(persona instanceof Cliente) {
                clientes.add((Cliente) persona);
            }
        }
        return clientes;
    }

    
    
    
}
