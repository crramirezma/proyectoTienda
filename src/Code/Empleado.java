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
    private Cargo cargo;
   

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    

    
    public Empleado(String name, String id,String cellphone,Cargo cargo){
        this.nombre=name;
        this.id=id;
        
        this.cargo=cargo;
        this.cellphone=cellphone;
        
    }
    
    

    
    
    
}
