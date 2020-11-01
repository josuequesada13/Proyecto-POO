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
/*
Clase transaccion utilizada como clase padre para las clases egreso e ingreso
*/
public class Transaccion {
    private double monto;
    private String descripcion;
    private int semana;
    
    public Transaccion(double monto, String descripcion, int semana){
        this.monto = monto;
        this.descripcion = descripcion;
        this.semana = semana;
    }
    
    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getSemana() {
        return semana;
    }  
}
