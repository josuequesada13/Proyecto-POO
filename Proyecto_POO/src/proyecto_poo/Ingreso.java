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

/*
Clase donde se guardan los datos de los ingresos que tendran las personas y las 
familias.
*/
public class Ingreso extends Transaccion{

    public Ingreso(double monto, String descripcion, int semana) {
        super(monto, descripcion, semana);
        
    }
}
