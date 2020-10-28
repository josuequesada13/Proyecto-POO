/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

/**
 *
 * @author josue
 */
public class Proyecto_POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {/*
        // TODO code application logic here
        MetodoFamilia aa = new MetodoFamilia();
        aa.anadeFamilia(new Familia("aa","cc","ss","sa",546540,545225));
        aa.anadeFamilia(new Familia("b","cc","ss","sa", 78, 1));
        aa.anadeFamilia(new Familia("x","cc","ss","sa", 4545, 1000));
        aa.anadeFamilia(new Familia("a","cc","ss","sa", 455, 300));
        
        //CrearFamilia2 aaa = new CrearFamilia2();
        //aaa.setVisible(true);
        
        
        //Collections.sort(aa.getFamilias());
        aa.ordenIngresos();
        
        for(Familia f: aa.getFamilias()){
            System.out.println(f.getTotalIngresos());
        }
        
        aa.ordenAhorros();
        for(Familia f: aa.getFamilias()){
            System.out.println(f.getTotalIngresos()-f.getTotalEgresos());
        }*/
        String a = "hola";
        System.out.println(a);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String text = in.readLine();
        if(text != ""){
            a = "worked";
            }
        System.out.println(a);
    }
    
}
