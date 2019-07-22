/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

/**
 *
 * @author daniel
 */
public class Venta {
    private Producto producto;
    private Cliente cliente;
    
    //este hace referencia a la cantidad de productos que se piensan vender
    private int cantidad;
    public Venta(Producto producto, Cliente cliente,int cantidad) {
        this.producto = producto;
        this.cliente = cliente;
        this.cantidad=cantidad;
    }
    public Venta(Producto producto, int cantidad){
        this.producto=producto;
        this.cantidad=cantidad;
    }
   

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    //metodos redundantes pero necesarios parael funcionamiento
    
    public int getTotal(){
        return this.producto.getPrecioventa()*this.cantidad;
    }
    public int getPrecio() {
        return this.producto.getPrecioventa();
    }

    public int getReferencia() {
        return this.producto.getReferencia();
    }

    public String getNombre() {
        return this.producto.getNombre();
    }
    
   
    
}
