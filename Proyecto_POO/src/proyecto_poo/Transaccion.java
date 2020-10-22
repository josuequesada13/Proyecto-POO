/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

/**
 *
 * @author josue
 */
public class Transaccion {
    private double monto;
    private String descripcion;
    
    public Transaccion(double monto, String descripcion){
        this.monto = monto;
        this.descripcion = descripcion;
    }
    
    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
        
}
