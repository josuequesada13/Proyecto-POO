/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class ClaseSocial { 
    private double ingresos;
    private double ahorros;
    private String nombre;

    public ClaseSocial(String nombre) {
        this.nombre = nombre;
    }

    public double getIngresos() {
        return ingresos;
    }

    public double getAhorros() {
        return ahorros;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void sumaIngresos(double ingresos) {
        this.ingresos += ingresos;
    }

    public void sumaAhorros(double ahorros) {
        this.ahorros += ahorros;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    
}
