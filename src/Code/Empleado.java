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
public class Empleado extends Persona{
    private String cargo;
    private double horastrabajadas;

    public Empleado(String nombre, String cellphone, int id,String cargo) {
        super(nombre, cellphone, id);
        this.cargo=cargo;
        this.horastrabajadas=0;
    }
    
    public void aumentarHorasTrabajo(double cantidad){
        this.horastrabajadas+=cantidad;
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getHorastrabajadas() {
        return horastrabajadas;
    }

    public void setHorastrabajadas(double horastrabajadas) {
        this.horastrabajadas = horastrabajadas;
    }
    
    
    

    
   

   
    
    

    
    
    
}
