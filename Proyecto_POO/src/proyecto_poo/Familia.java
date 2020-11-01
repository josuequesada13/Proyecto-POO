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
    private ClaseSocial claseSocial = new ClaseSocial("");
    private double totalEgresos = 0;
    private double totalIngresos = 0;
    private ArrayList<Persona> miembrosFamilia = new ArrayList<>(); 
    private ArrayList<Egreso> listaGastos = new ArrayList<>();
    private ArrayList<Ingreso> listaIngresos = new ArrayList<>();
    
    public Familia(String apellidosFamiliar, String provincia, String canton, String distrito, String usuario, String contra) {
        this.apellidosFamilia = apellidosFamiliar;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.nombreUsuario = usuario;
        this.contrasegna = contra;
    }
    
    public Familia(){
    }
    
    public void anadeFamiliar(String nombre, int id, String edad, String trabajo, String genero, String gradoEscolaridad){
        Persona miembroFamilia = new Persona(nombre, id, edad, trabajo, genero, gradoEscolaridad);
        miembroFamilia.setFamilia(this);
        this.miembrosFamilia.add(miembroFamilia);
    }
    
    public void anadeFamiliar(Persona p){
        p.setFamilia(this);
        miembrosFamilia.add(p);
    }
    
    public Persona buscarPersona(String nombre){
        Persona aux = new Persona();
        for(Persona p: miembrosFamilia){
            if(p.getNombre().equals(nombre)){
                aux = p;
                break;
            }
        }
        return aux;
    }
    
    public void calculaClase(){
        if(totalIngresos <= 250000){ //clase baja
            claseSocial.setNombre("Clase Baja");
        }else if(totalIngresos > 250000 && totalIngresos < 350000){//clase baja superior
            claseSocial.setNombre("Clase Baja Superior");
        }else if(totalIngresos > 350000 && totalIngresos < 500000){// clase media 
            claseSocial.setNombre("Clase Media");
        }else if(totalIngresos > 500000 && totalIngresos < 1000000){// clase media alta 
            claseSocial.setNombre("Clase Media Alta");
        }else if(totalIngresos > 1000000){ // clase alta 
            claseSocial.setNombre("Clase Alta");
        }
    }
    
    public boolean revisaEgresos(){
        boolean revisa = false;
        if(listaGastos.isEmpty()){
            revisa = false;
        }else{
            for(Egreso e: listaGastos){
                if(e.getClasificacion().equals("Fisiologia") || e.getClasificacion().equals("Seguridad")){
                    revisa = true;
                }else{
                    revisa = false;
                    break;
                }
            }
        }
        return revisa;
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
    
    public void setClaseS(ClaseSocial cs){
        this.claseSocial = cs;
    }
}
