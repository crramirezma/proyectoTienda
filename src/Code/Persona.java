/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 57312
 */
public  class Persona {
    
    protected String nombre;
    protected String cellphone;   
    protected int id;

    public Persona(String nombre, String cellphone, int id) {
        this.nombre = nombre;
        this.cellphone = cellphone;
        this.id = id;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    
    
    
}
