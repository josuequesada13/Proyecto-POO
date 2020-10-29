/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_poo;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author josue
 */
public class Familia{

    private String apellidosFamilia;
    private String provincia ;
    private String canton;
    private String distrito;
    private String nombreUsuario;
    private String contrasegna;
    private ClaseSocial claseSocial;
    private double totalEgresos;
    private double totalIngresos;
    private ArrayList<Persona> miembrosFamilia; 
    private ArrayList<Egreso> listaGastos;
    private ArrayList<Ingreso> listaIngresos;
     
    public Familia(String apellidosFamiliar, String provincia, String canton, String distrito) {
        this.apellidosFamilia = apellidosFamiliar;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.listaGastos = new ArrayList<>();
        this.listaIngresos = new ArrayList<>();
    }
    
    public Familia(String apellidosFamiliar, String provincia, String canton, String distrito, String usuario, String contra) {
        this.apellidosFamilia = apellidosFamiliar;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.nombreUsuario = usuario;
        this.contrasegna = contra;
        this.listaGastos = new ArrayList<>();
        this.listaIngresos = new ArrayList<>();
    }
    
    public Familia(){
        
    }
    
    public void anadeFamiliar(String nombre, int id, int edad, String trabajo, String genero, String gradoEscolaridad){
        Persona miembroFamilia = new Persona(nombre, id, edad, trabajo, genero, gradoEscolaridad);
        miembroFamilia.setFamilia(this);
        this.miembrosFamilia.add(miembroFamilia);
    }
    
    public Persona buscarPersona(String nombre){
        Persona aux = new Persona();
        for(Persona p: miembrosFamilia){
            if(p.getNombre() == nombre){
                aux = p;
                break;
            }
        }
        return aux;
    }
    
    public void calculaClase(){
        String nombreClase = "";
        if(totalIngresos <= 250000){ //clase baja
            nombreClase = "Clase Baja";
        }if(totalIngresos > 250000 && totalIngresos < 350000){//clase baja superior
            nombreClase = "Clase Baja Superior";
        }if(totalIngresos > 350000 && totalIngresos < 500000){// clase media 
            nombreClase = "Clase Media";
        }if(totalIngresos > 500000 && totalIngresos < 1000000){// clase media alta 
            nombreClase = "Clase Media Alta";
        }if(totalIngresos > 1000000){ // clase alta 
            nombreClase = "Clase Alta";
        }
        claseSocial = new ClaseSocial(nombreClase);
    }
    
    public static Comparator<Familia> IngresosComparator = new Comparator<Familia>() {
        @Override
        public int compare(Familia t, Familia t1) {
           int f1 = (int)t.getTotalIngresos();
	   int f2 = (int)t1.getTotalIngresos();
	   return f2-f1;
        }
    };
    
    public static Comparator<Familia> AhorrosComparator = new Comparator<Familia>() {
        @Override
        public int compare(Familia t, Familia t1) {
           int f1 = (int)(t.getTotalIngresos()-t.getTotalEgresos());
	   int f2 = (int)(t1.getTotalIngresos()-t1.getTotalEgresos());
	   return f2-f1;
        }
    };

    public String getApellidosFamilia() {
        return apellidosFamilia;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCanton() {
        return canton;
    }

    public String getDistrito() {
        return distrito;
    }
    
    public String getUsuario(){
        return nombreUsuario;
    }
    
    public String getContra(){
        return contrasegna;
    }
    
    public String getClaseSocial(){
        return claseSocial.getNombre();
    }

    public double getTotalEgresos() {
        return totalEgresos;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }

    public ArrayList<Persona> getMiembrosFamilia() {
        return miembrosFamilia;
    }

    public ArrayList<Egreso> getListaGastos() {
        return listaGastos;
    }

    public ArrayList<Ingreso> getListaIngresos() {
        return listaIngresos;
    }

    public void anadeTotalEgresos(double totalEgresos) {
        this.totalEgresos += totalEgresos;
    }

    public void anadeTotalIngresos(double totalIngresos) {
        this.totalIngresos += totalIngresos;
    }
    
    public void anadeEgresos(Egreso e){
        this.listaGastos.add(e);
    }
    
    public void anadeIngreso(Ingreso i){
        this.listaIngresos.add(i);
    }
    
    /*public void setClaseSocial(String clase){
        this.claseSocial = clase;
    }*/
}
