/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author josue
 */
public class MetodoFamilia {
    private ArrayList<Familia> Familias;
    
    public MetodoFamilia(){
        this.Familias = new ArrayList<>();
    }
    
    public void anadeFamilia(Familia familia){
        this.Familias.add(familia);
    }
    
    public ArrayList<Familia> getFamilias(){
        return Familias;
    }
    
    public void setFamilias(ArrayList a){
        this.Familias = a;
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
                + "Clase Alta: " + claseAlta/cantidad * 100 + "\nClase Media Alta: " + claseMediaAlta/cantidad * 100
                + "\nClase Media Baja: " + claseMedia/cantidad * 100 + "\nClase Baja Superior: " + claseBajaSuperior/cantidad * 100
                + "\nClase Baja: " + claseBaja/cantidad * 100;
    }
    
    /*
    Reporte 2, 
    */
    
    
    /*
    Reporte 3, calcula el porcentaje de familias que solo gastan en fisiologia y seguridad
    */
   public String ingresosFisiologiaSeguridad(){
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
    Reporte 4 calcula cuantas familias de las registradas gastan igual o más de un 10% 
    de sus ingresos en actividades de autorrealización (ultimo nivel).
    */
    public String ingresosAutorrealizacion(){
        double cantidad = 0;
        for(Familia f: Familias){
            double ingreso = f.getTotalIngresos();
            double gasto = 0;
            for(Egreso e: f.getListaGastos()){
                if(e.getClasificacion() == "Autorrealizacion"){
                    gasto += e.getMonto();
                }
            }
            if(gasto >= ingreso*0.1){
                cantidad += 1;
            }
        }
        return "En total " + cantidad + " gastan mas de un 10 % de sus ingresos en Autorealizacion";
    }
    
    /*
    Reporte 5 grado de escolaridad (individual no familiar) que más ahorra
    */
    public String reporteCinco(){
        
        return "";
    }
    
    /*
    Reporte 6, Listar en orden de mayor a menor las familias
    */
    public ArrayList ordenIngresos(){
        Collections.sort(Familias, Familia.IngresosComparator);
        return Familias;
    }
    
    /*
    Reporte 7, Listar familias en orden por cantidad de ahorros
    */
    public ArrayList ordenAhorros(){
        Collections.sort(Familias, Familia.AhorrosComparator);
        return Familias;
    }
    
    
}
