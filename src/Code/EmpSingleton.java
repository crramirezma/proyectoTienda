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
public class EmpSingleton {
    private static EmpSingleton empSingleton;
    private Empleado empleado;
    public static EmpSingleton getSingleton(){
        if(empSingleton==null)empSingleton=new EmpSingleton();
        return empSingleton;
    }
    public Empleado getEmpleado(){
        return empleado;
    }
    public void setEmpleado(Empleado empleado){
        this.empleado=empleado;
    }
}
