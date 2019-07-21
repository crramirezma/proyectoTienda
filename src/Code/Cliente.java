/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.util.*;


/**
 *
 * @author 57312
 */
public class Cliente extends Persona {
    private double calificacion=0;
    public Cliente(String Nombre,  String telefono){
        
        this.cellphone=telefono;
        this.nombre=Nombre;
    }
    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
