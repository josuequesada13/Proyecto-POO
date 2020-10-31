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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MetodoFamilia Familias = new MetodoFamilia();
        Login login = new Login();
        login.metodoFamilia = Familias;
        login.setVisible(true);
        /*
        int i = 9;
        double j = 3;
        double h = 9;
        int f = 3;
        System.out.println(i/j + "int/double");
        System.out.println(i/f + "int/int");
        System.out.println(h/f+ "double/int");
        System.out.println(h/j+ "double/double");
        double cantidad = 5;
        int p = 2;
        int cant = 5;
        System.out.println((p/cantidad) * 100);
        System.out.println((p/cant) * 100);
        */
    }
    
}
