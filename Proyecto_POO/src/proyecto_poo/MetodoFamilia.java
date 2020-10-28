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
    
    public double mayorArray(double[] a){
        double i = 0;
        for(int x = 0; x < a.length; x++){
            if(a[x] >= i){
                i = a[x];
            }
        }
        return i;
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
    Reporte 2, calcula cual clase social tiene mayor capacidad de ahorro de acuerdo a sus
    ingresos
    */
    public String capacidadAhorro(){
        int mayorPorcentaje = 0;
        String clase = "";
        ClaseSocial baja = new ClaseSocial("Clase Baja");
        ClaseSocial bajaSup = new ClaseSocial("Clase Baja Superior");
        ClaseSocial media = new ClaseSocial("Clase Media");
        ClaseSocial mediaAlta = new ClaseSocial("Clase Media Alta");
        ClaseSocial alta = new ClaseSocial("Clase Alta");
        for(Familia f: Familias){
            switch(f.getClaseSocial()){
                case "Clase Baja":
                    baja.sumaIngresos(f.getTotalIngresos());
                    baja.sumaAhorros(f.getTotalIngresos()-f.getTotalEgresos());
                    break;
                case "Clase Baja Superior":
                    bajaSup.sumaIngresos(f.getTotalIngresos());
                    bajaSup.sumaAhorros(f.getTotalIngresos()-f.getTotalEgresos());
                    break;
                case "Clase Media":
                    media.sumaIngresos(f.getTotalIngresos());
                    media.sumaAhorros(f.getTotalIngresos()-f.getTotalEgresos());
                    break;
                case "Clase Media Alta":
                    mediaAlta.sumaIngresos(f.getTotalIngresos());
                    mediaAlta.sumaAhorros(f.getTotalIngresos()-f.getTotalEgresos());
                    break;
                case "Clase Alta":
                    alta.sumaIngresos(f.getTotalIngresos());
                    alta.sumaAhorros(f.getTotalIngresos()-f.getTotalEgresos());
                    break;
            }   
        }
        ClaseSocial[] array = {baja, bajaSup, media, mediaAlta, alta};
        for(ClaseSocial cs: array){
            if((int)(cs.getAhorros() - cs.getIngresos() * 100) > mayorPorcentaje){
                mayorPorcentaje = (int)(cs.getAhorros()-cs.getIngresos()*100);
                clase = cs.getNombre();
            }
        }
        return "La " + clase + " en promedio, tiene capacidad de ahorrar un " + mayorPorcentaje +
                "% de sus ingresos.";
    }
        /*
        for(Familia f: Familias){
            double ingresos = f.getTotalIngresos();
            double ahorro = f.getTotalIngresos() - f.getTotalEgresos();
            switch(f.getClaseSocial()){
                case "Clase Baja":
                    if((ahorro/ingresos*100) > mayorPorcentaje)
                        mayorPorcentaje = ahorro/ingresos*100;
                        clase = "Clase Baja";
                    break;
                case "Clase Baja Superior":
                    if((ahorro/ingresos*100) > mayorPorcentaje)
                        mayorPorcentaje = ahorro/ingresos*100;
                        clase = "Clase Baja Superior";
                    break;
                case "Clase Media":
                    if((ahorro/ingresos*100) > mayorPorcentaje)
                        mayorPorcentaje = ahorro/ingresos*100;
                        clase = "Clase Media";
                    break;
                case "Clase Media Alta":
                    if((ahorro/ingresos*100) > mayorPorcentaje)
                        mayorPorcentaje = ahorro/ingresos*100;
                        clase = "Clase Media Alta";
                    break;
                case "Clase Alta":
                    if((ahorro/ingresos*100) > mayorPorcentaje)
                        mayorPorcentaje = ahorro/ingresos*100;
                        clase = "Clase Alta";
                    break;
            }   
        }
        
        return "La " + clase + " es la que ";
        
        
        double ahorroBaja = 0, ahorroBajaSuperior = 0, ahorroMedia = 0, ahorroMediaAlta = 0,
                ahorroAlta = 0;
        double ingTotalBaja = 0, ingTotalBajaSup = 0, ingTotalMedia = 0, ingTotalMediaAlta = 0,
                ingTotalAlta = 0;
        for(Familia f: Familias){
            switch(f.getClaseSocial()){
                case "Clase Baja": 
                    ahorroBaja += (f.getTotalIngresos() - f.getTotalEgresos());
                    ingTotalBaja += f.getTotalIngresos();
                    break;
                case "Clase Baja Superior":
                    ahorroBajaSuperior += (f.getTotalIngresos() - f.getTotalEgresos());
                    ingTotalBajaSup += f.getTotalIngresos();
                    break;
                case "Clase Media":
                    ahorroMedia += (f.getTotalIngresos() - f.getTotalEgresos());
                    ingTotalMedia += f.getTotalIngresos();
                    break;
                case "Clase Media Alta":
                    ahorroMediaAlta += (f.getTotalIngresos() - f.getTotalEgresos());
                    ingTotalMediaAlta += f.getTotalIngresos();
                    break;
                case "Clase Alta":
                    ahorroAlta += (f.getTotalIngresos() - f.getTotalEgresos());
                    ingTotalAlta += f.getTotalIngresos();
                    break;
            }
        }
        double[] ahorros = {ahorroBaja, ahorroBajaSuperior, ahorroMedia, ahorroMediaAlta, ahorroAlta};
        double mayorAhorro = mayorArray(ahorros);
        double[] totalesIngresos = {ingTotalBaja, ingTotalBajaSup, ingTotalMedia, ingTotalMediaAlta, ingTotalAlta};
        double mayorTotal = mayorArray(totalesIngresos);*/
       
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
        return "El " + ((porcentaje/cantidad) * 100) + "% de las familias solo gastan en los dos niveles basicos\n Fisiologia y seguridad";
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
    
    Si. Suma todos los ahorros de todas las personas de primaria. Y así para todos los niveles de escolaridad.
    Para determinar ahorra más nominalmente
    */
    public String reporteCinco(){
        double ahorroPrimaria = 0, ahorroSecundaria = 0, ahorroDiversificada = 0, ahorroUniversitaria = 0;
        for(Familia f: Familias){
            if(!f.getMiembrosFamilia().isEmpty()){
                for(Persona p: f.getMiembrosFamilia()){
                    if(p.getGradoEscolaridad() == "Primaria"){
                        ahorroPrimaria += (p.getTotalIngresos() - p.getTotalEgresos());
                    }if(p.getGradoEscolaridad() == "Secundaria"){
                        ahorroSecundaria += (p.getTotalIngresos() - p.getTotalEgresos());
                    }if(p.getGradoEscolaridad() == "Diversificada"){
                        ahorroDiversificada += (p.getTotalIngresos() - p.getTotalEgresos());
                    }if(p.getGradoEscolaridad() == "Universitaria"){
                        ahorroUniversitaria += (p.getTotalIngresos() - p.getTotalEgresos());
                    }
                }
            }
            
        }
        double[] array = {ahorroPrimaria, ahorroSecundaria, ahorroDiversificada, ahorroUniversitaria};
        double i = 0;
        String result = "";
        for(int x = 0; x < 4; x++){
            if(array[x] >= i){
                i = array[x];
            }
        }
        if(i == ahorroPrimaria){
            result = "El nivel de escolaridad que mas puede ahorrar es el de Primaria";
        }if(i == ahorroSecundaria){
            result = "El nivel de escolaridad que mas puede ahorrar es el de Secundaria";
        }if(i == ahorroDiversificada){
            result = "El nivel de escolaridad que mas puede ahorrar es el de Educacion Diversificada";
        }if(i == ahorroUniversitaria){
            result = "El nivel de escolaridad que mas puede ahorrar es el de Educacion Universitaria";
        }
        return result;
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
    
    /*
    Reporte 8, listar las familias que a final de agno quedaron sin ahorros
    
    public ArrayList ListarSinAhorros(){
        int cantidad = Familias.size();
        for(Familia f: Familias){
        double Comparator<Familia> = f.AhorrosComparator;
            if (Comparator<Familia> != 0){ //poseen ahorros
                Familias.remove(Familias f)
            }
            return Familias;
        }*/
    
}
