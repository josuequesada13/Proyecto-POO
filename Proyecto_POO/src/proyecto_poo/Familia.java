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
public class Familia {

    private String apellidosFamilia;
    private String provincia ;
    private String canton;
    private String distrito;
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
    }
    
    public void anadeFamiliar(String nombre, int id, int edad, String trabajo, String genero, String gradoEscolaridad){
        Persona miembroFamilia = new Persona(nombre, id, edad, trabajo, genero, gradoEscolaridad);
        miembroFamilia.setFamilia(this);
        this.miembrosFamilia.add(miembroFamilia);
    }
    
    /*public void anadeEgresos(){
        for(Persona p: miembrosFamilia){
            if(!p.getEgresos().isEmpty()){
                for(Egreso e: p.getEgresos()){
                    listaGastos.add(e);
                    totalEgresos += e.getMonto();
                }
            }
        }
    }
    
    public void anadeIngresos(){
        for(Persona p: miembrosFamilia){
            if(!p.getIngresos().isEmpty()){
                for(Ingreso i: p.getIngresos()){
                    listaIngresos.add(i);
                    totalIngresos += i.getMonto();
                }
            }
        }
    }*/

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
    
    
}
