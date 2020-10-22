/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author josue
 */
public class Ingreso extends Transaccion{
    private String nombre;

    public Ingreso(String nombre, double monto, String descripcion) {
        super(monto, descripcion);
        this.nombre = nombre;
        
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
}
