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
Clase para almacenar los datos de los egresos que tendran las personas y las
familias.
*/
public class Egreso extends Transaccion{
    private String clasificacion;

    public Egreso(String clasificacion, double monto, String descripcion, int semana) {
        super(monto, descripcion, semana);
        this.clasificacion = clasificacion;
    }
    
    public String getClasificacion(){
        return this.clasificacion;
    }
    
}
