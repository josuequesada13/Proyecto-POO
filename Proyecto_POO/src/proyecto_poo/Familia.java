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
    private ClaseSocial claseSocial;
     
    
    /**
     * @param apellidosFamiliar
     * @param provincia
     * @param canton
     * @param distrito 
     */
    public Familia(String apellidosFamiliar, String provincia, String canton, String distrito) {
        this.apellidosFamilia = apellidosFamiliar;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
    }
    
    /**
     * @param nombre
     * @param id
     * @param edad
     * @param trabajo
     * @param genero
     * @param gradoEscolaridad 
     * 
     */
    public void anadeFamiliar(String nombre, int id, int edad, String trabajo, String genero, String gradoEscolaridad){
        Persona miembroFamilia = new Persona(nombre, id, edad, trabajo, genero, gradoEscolaridad);
        this.miembrosFamilia.add(miembroFamilia);
    }
    
    /**
     @param gasto
     */
    public void anadeEgreso(double gasto){
        this.totalEgresos += gasto;
    }
    
    /**
     * @param ingreso 
     */
    public void anadeIngreso(double ingreso){
        this.totalIngresos += ingreso;
    }
    
    /** Este metodo es solo un ejemplo de como funcionara en el futuro
    public void calcularClaseSocial(){
        if(totalIngresos - totalEgresos >= 1000){
            this.claseSocial = new ClaseSocial("Media", 5000);
            
        }
    }*/

    /**
     * @return String
     */
    public String getApellidosFamilia() {
        return apellidosFamilia;
    }

    /**
     * @return String
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @return String
     */
    public String getCanton() {
        return canton;
    }

    /**
     * @return String
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * @return int
     */
    public double getTotalEgresos() {
        return totalEgresos;
    }

    /**
     * @return int
     */
    public double getTotalIngresos() {
        return totalIngresos;
    }

    /**
     * @return ArrayList
     */
    public ArrayList<Persona> getMiembrosFamilia() {
        return miembrosFamilia;
    }
    
    /**
     * @return ClaseSocial
     */
    public ClaseSocial getClaseSocial(){
        return this.claseSocial;
    }
    
    
    
}
