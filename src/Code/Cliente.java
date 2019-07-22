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
    private double calificacion;
    private int numcompras;

    public Cliente(String nombre, String cellphone, int id) {
        super(nombre, cellphone, id);
        this.calificacion=0;
        this.numcompras=0;
    }
    
    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
