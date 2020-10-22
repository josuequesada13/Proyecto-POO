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
public class Egreso extends Transaccion{
    /*private int fisiologia;
    private int seguridad;
    private int afiliacion;
    private int reconocimiento;
    private int autorrelacion;
    private int total; */ // Revisar como manejar esto <------------------
    private String clasificacion;

    public Egreso(String clasificacion, double monto, String descripcion) {
        super(monto, descripcion);
        this.clasificacion = clasificacion;
    }
    
    public String getClasificacion(){
        return this.clasificacion;
    }
    
}
