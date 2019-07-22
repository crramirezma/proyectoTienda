/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.ArrayList;

/**
 *
 * @author Arriu
 */
public class Tienda {
    private String nombre;
    private double capital;
    private ArrayList <Persona> personas;
    private ArrayList <Producto> productos;
    private ArrayList <Venta> ventas;

    
    //los get y los set para los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }
    
    public Tienda(String nombre,double capital) {
        this.capital=capital;
        this.nombre=nombre;
        this.personas=new ArrayList<>();
        this.productos=new ArrayList<>();
        this.ventas=new ArrayList<>();
    }
    
    public void agregarProducto(int precioventa,int preciocompra,int referencia,int cantidad,String nombre){
        Producto p=new Producto(precioventa,preciocompra,referencia,cantidad,nombre);
        this.productos.add(p);     
    }
    //agregar producto que solo es para venta
    public void agregarProductoVenta(int precio,int referencia,String nombre){
        Producto p=new Producto(precio,referencia,nombre);
        this.productos.add(p);
    }
    public void agregarProovedor(String nombre,String cellphone,int id){
        Proovedor pr=new Proovedor(nombre,cellphone,id);
        this.personas.add(pr);
    }
    
    public void agregarProductoProovedor(int idProovedor,int referenciaProducto){
        
        Proovedor prr=null;
        Producto pd=null;
        for(Persona p: personas){
            if(p instanceof Proovedor&&((Proovedor)p).getId()==idProovedor){
                prr= (Proovedor) p;
                
            }
        }
        for(Producto producto:productos){
            if(producto.getReferencia()==referenciaProducto){
                pd=producto;
            }
        }
        
        prr.agregarProducto(pd);
       
        
        
    }
    
    public void agregarCliente(String nombre,String cellphone,int id){
        Cliente c=new Cliente(nombre,cellphone,id);
        this.personas.add(c);
    }
    
    public void agregarEmpleado(String nombre,String cellphone,int id,String cargo){
        Empleado e=new Empleado(nombre,cellphone,id,cargo);
        this.personas.add(e);
    }
    
    public void venderProducto(int id,int referencia,int cantidad){
        Cliente c=null;
        for(Persona cliente: personas){
            if(cliente instanceof Cliente&&cliente.getId()==id){
                c=(Cliente) cliente;
            }
        }
        for(Producto p:productos){
            if(p.getReferencia()==referencia){
                p.aumentarCantidad(-cantidad);
                this.capital=this.capital+(cantidad*p.getPrecioventa());
                Venta venta=new Venta(p,c,cantidad);
                this.ventas.add(venta);                              
            }
        }   
    }
    public void venderProductoScliente(int id,int referencia,int cantidad){
        for(Producto p:productos){
            if(p.getReferencia()==referencia){
                p.aumentarCantidad(-cantidad);
                this.capital=this.capital+(cantidad*p.getPrecioventa());
                Venta venta=new Venta(p,cantidad);
                this.ventas.add(venta);                              
            }
        }   
    }
    public void venderVarios(int numero){
        
        for(int i=0;i<numero;i++){
            
        }
        
        
        
    }
    
}
