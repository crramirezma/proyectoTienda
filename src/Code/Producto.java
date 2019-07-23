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
public class Producto {
    private int precioventa;
    private int preciocompra;
    private int referencia;
    private int noventas;
    //esta cantidad hace referencia al stock
    
    private int cantidad;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    private String nombre;

    public Producto(int precio,int precio1, int referencia,int cantidad, String nombre) {
        this.precioventa = precio;
        this.preciocompra=precio1;
        this.referencia = referencia;
        this.cantidad=cantidad;
        this.nombre = nombre;
        this.noventas=0;
    }
    //solo Venta
    public Producto(int precioVenta,  int referencia, String nombre) {
        this.precioventa=precioVenta;
        this.referencia = referencia;
        this.nombre = nombre;
    }
    //solo compra
    public Producto(int precioCompra,int referencia,int cantidad, String nombre) {
        this.preciocompra = precioCompra;
        this.referencia = referencia;
        this.cantidad=cantidad;
        this.nombre = nombre;
    }
    public void aumentarCantidad(int cantidad){
        this.cantidad+=cantidad;
    }

    public void aumentarVentas(int cantidad){
        this.noventas=this.noventas+cantidad;
    }
    
    public int getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(int precioventa) {
        this.precioventa = precioventa;
    }

    public int getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(int preciocompra) {
        this.preciocompra = preciocompra;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
   
    
}
