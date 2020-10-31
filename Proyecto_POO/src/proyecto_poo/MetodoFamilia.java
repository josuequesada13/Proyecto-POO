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
    
    public Familia buscarFamilia(String usuario){
        Familia aux = null;
        for(Familia f: Familias){
            if(f.getUsuario().equals(usuario)){
                aux = f;
            }
        }
        System.out.println(aux);
        return aux;
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
        final float cantidad = Familias.size();
        int claseAlta = 0;
        int claseMediaAlta = 0;
        int claseMedia = 0;
        int claseBajaSuperior = 0;
        int claseBaja = 0;
        for(Familia f: Familias){
            double total = f.getTotalIngresos();
            if(total <= 250000){ //clase baja
                claseBaja += 1;
                System.out.println(f.getApellidosFamilia() + " baja");
            }else if(total > 250000 && total <= 350000){//clase baja superior
                claseBajaSuperior += 1;
                System.out.println(f.getApellidosFamilia() + " baja sup");
            }else if(total > 350000 && total <= 500000){// clase media 
                claseMedia += 1;
                System.out.println(f.getApellidosFamilia() + " media");
            }else if(total > 500000 && total <= 1000000){// clase media alta 
                claseMediaAlta += 1;
                System.out.println(f.getApellidosFamilia() + " media alta");
            }else if(total > 1000000){ // clase alta 
                claseAlta += 1;
                System.out.println(f.getApellidosFamilia() + " alta");
            }
        }
        //System.out.println("alta " +claseAlta + " medialta " + claseMediaAlta+ " media "+ claseMedia +" bajasup "+
                //claseBajaSuperior + " baja "+ claseBaja + " cantidad " +cantidad);
        return "La cantidad de familias es: " + cantidad + "\nEl total de familias por clasificacion \nes de:\n"
                + "Clase Alta: " + ((claseAlta/cantidad) * 100) + "\nClase Media Alta: "+ ((claseMediaAlta/cantidad) * 100)
                + "\nClase Media Baja: " + ((claseMedia/cantidad) * 100) + "\nClase Baja Superior: " + ((claseBajaSuperior/cantidad) * 100)
                + "\nClase Baja: " + ((claseBaja/cantidad) * 100);
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
        return "La " + clase + " en promedio, \ntiene capacidad de ahorrar \nun " + mayorPorcentaje +
                "% de sus \ningresos.";
    }
       
    /*
    Reporte 3, calcula el porcentaje de familias que solo gastan en fisiologia y seguridad
    */
    public String egresosFisiologiaSeguridad(){
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
        return "El " + ((porcentaje/cantidad) * 100) + "% de las familias solo gastan en \nlos dos niveles basicos\n Fisiologia y seguridad";
    }
    
    /*
    Reporte 4 calcula cuantas familias de las registradas gastan igual o más de un 10% 
    de sus ingresos en actividades de autorrealización (ultimo nivel).
    */
    public String ingresosAutorrealizacion(){
        int cantidad = 0;
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
        return "En total " + cantidad + " familia(s) gastan mas de \nun 10 % de sus ingresos en Autorealizacion";
    }
    
    /*
    Reporte 5 grado de escolaridad (individual no familiar) que más ahorra
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
        String result = "";
        double i = mayorArray(array);
        if(i == ahorroPrimaria){
            result = "El nivel de escolaridad que mas puede \nahorrar es el de Primaria";
        }if(i == ahorroSecundaria){
            result = "El nivel de escolaridad que mas puede \nahorrar es el de Secundaria";
        }if(i == ahorroDiversificada){
            result = "El nivel de escolaridad que mas puede \nahorrar es el de Educacion Diversificada";
        }if(i == ahorroUniversitaria){
            result = "El nivel de escolaridad que mas puede \nahorrar es el de Educacion Universitaria";
        }
        return result;
    }
    
    /*
    Reporte 6, Listar en orden de mayor a menor las familias por cantidad de ingresos
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
    */
    public ArrayList ListarSinAhorros(){
        ArrayList<Familia> sinAhorros = new ArrayList<>();
        for(Familia f: Familias){
            if((f.getTotalIngresos() - f.getTotalEgresos()) == 0){
                sinAhorros.add(f);
            }
        }
        return sinAhorros;
    }
        
    /*
    Reporte 9, en que semana la persona x registra mas gastos
    
    
    Estos dos reportes se podrian hacer en la misma clase persona para no tener que estar 
    pariendo pidiendo datos por todo lado
    */
    public String personaMasGastos(String nombre){
        Persona aux = new Persona();
        for(Familia f: Familias){
            f.buscarPersona(nombre);
            
        }
        return "";
    }
    
    /*
    Reporte 10, en que semana la persona x registra mas ingresos
    */
}
