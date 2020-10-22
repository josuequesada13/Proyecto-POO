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
public class Persona {
    private String nombre;
    private int id;
    private int edad;
    private String trabajo; // si tiene varios trabajos?
    private String genero;
    private String gradoEscolaridad;
    private double totalEgresos;
    private double totalIngresos;
    private ArrayList<Egreso> egresos;
    private ArrayList<Ingreso> ingresos;

    public Persona(String nombre, int id, int edad, String trabajo, String genero, String gradoEscolaridad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.trabajo = trabajo;
        this.genero = genero;
        this.gradoEscolaridad = gradoEscolaridad;
        this.totalEgresos = 0;
        this.totalIngresos = 0;
    }
    
    public void anadirEgreso(String clasificacion, double monto, String descripcion){
        Egreso nuevoEgreso = new Egreso(clasificacion, monto, descripcion);
        this.egresos.add(nuevoEgreso);
        this.totalEgresos += monto;    
    }
    
    public void anadirIngreso(String nombre, double monto, String descripcion){
        Ingreso nuevoIngreso = new Ingreso(nombre, monto, descripcion);
        this.ingresos.add(nuevoIngreso);
        this.totalIngresos += monto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public int getEdad() {
        return edad;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public String getGenero() {
        return genero;
    }

    public String getGradoEscolaridad() {
        return gradoEscolaridad;
    }
    
    
    
    
}
