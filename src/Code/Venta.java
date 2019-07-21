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
    private int cantidad;
    public String getName(){
        return this.producto.getNombre();
    }
    public int getCantidad() {
        return cantidad;
    }
    
    public Venta(Producto producto, int cantidad){
        this.producto=producto;
        this.cantidad=cantidad;
        
    }
    
    public int getTotal(){
        return this.producto.getPrecio()*this.cantidad;
    }
    public int getPrecio() {
        return this.producto.getPrecio();
    }

    public String getReferencia() {
        return this.producto.getReferencia();
    }

    public String getNombre() {
        return this.producto.getNombre();
    }
}
