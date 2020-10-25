/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class MetodoFamilia {
    private ArrayList<Familia> Familias;
    
    public void anadeFamilia(Familia familia){
        this.Familias.add(familia);
    }
    
    /*
    Reporte 1, separa las familias y las clasifica de acuerdo a sus ingresos
    */
    public String calculaClasificacion(){
        int cantidad = Familias.size();
        int claseAlta = 0;
        int claseMediaAlta = 0;
        int claseMedia = 0;
        int claseBajaSuperior = 0;
        int claseBaja = 0;
        for(Familia f: Familias){
            double total = f.getTotalIngresos();
            if(total <= 250000){ //clase baja
                claseBaja += 1;
            }if(total > 250000 && total < 350000){//clase baja superior
                claseBajaSuperior += 1;
            }if(total > 350000 && total < 500000){// clase media 
                claseMedia += 1;
            }if(total > 500000 && total < 1000000){// clase media alta 
                claseMediaAlta += 1;
            }if(total > 1000000){ // clase alta 
                claseAlta += 1;
            }
        }
        return "La cantidad de familias es: " + cantidad + "\nEl total de familias por clasificacion es de:\n"
                + "Clase Alta: " + claseAlta/cantidad * 100 + "\nClase Media Alta: " + claseMedia/cantidad * 100
                + "\nClase Media Baja: " + claseMedia/cantidad * 100 + "\nClase Baja Superior: " + claseBajaSuperior/cantidad * 100
                + "\nClase Baja: " + claseBaja/cantidad * 100;
    }
    
    /*
    Reporte 2, 
    */
    
    
    /*
    Reporte 3, calcula el porcentaje de familias que solo gastan en fisiologia y seguridad
    */
    public String reporteTres(){
        int cantidad = Familias.size();
        int porcentaje = 0;
        for(Familia f: Familias){
            for(Egreso e: f.getListaGastos()){
                if(e.getClasificacion() != "Fisiologia" || e.getClasificacion() != "Seguridad"){
                    break;
                }else{
                    porcentaje += 1;
                }
            }
        }
        return "El " + (porcentaje/cantidad) * 100 + "% de las familias solo gastan en los dos niveles basicos\n Fisiologia y seguridad";
    }
    
    /*
    Reporte 4 
    */
    public String reporteCuatro(){
        int cantidad = 0;
        for(Familia f: Familias){
            
        }
        return "";
    }
}
