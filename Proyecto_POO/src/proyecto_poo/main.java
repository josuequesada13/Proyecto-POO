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
        
    }
}
