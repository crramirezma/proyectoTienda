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
public class Proovedor extends Persona{
    
    private String empresa;
    ArrayList <Producto> ofrece;
    
    
    public Proovedor(String nombre, String cellphone, int id) {
        super(nombre, cellphone, id);
        this.ofrece=new ArrayList<>();
    }
    
   

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public ArrayList<Producto> getOfrece() {
        return ofrece;
    }

    public void setOfrece(ArrayList<Producto> ofrece) {
        this.ofrece = ofrece;
    }

    public void agregarProducto(Producto p){
        this.ofrece.add(p); 
    }
    
    
    
}
