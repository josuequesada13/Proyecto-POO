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
public class main {
    //Esta clase es solo para probar los metodos y demas
    public static void main(String[] args) {
        Familia familia = new Familia("Quesada Solano", "San", "hueco", "del infierno");
        familia.anadeIngreso(80000000);
        familia.anadeEgreso(5000);
        //familia.calcularClaseSocial();
        //System.out.println(familia.getClaseSocial().getTipo());
        
    }
    
}
