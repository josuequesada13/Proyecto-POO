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

/*
Clase persona donde se almacenara toda la informacion de una persona creada, 
desde su nombre, hasta sus trabajos, egresos, ingresos, etc.
*/
public class Persona {
    private String nombre;
    private int id;
    private String edad;
    private ArrayList<String> trabajos;
    private String genero;
    private String gradoEscolaridad;
    private double totalEgresos;
    private double totalIngresos;
    private ArrayList<Egreso> egresos;
    private ArrayList<Ingreso> ingresos;
    private Familia familia;

    public Persona(String nombre, int id, String edad, String trabajo, String genero, String gradoEscolaridad) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.trabajos = new ArrayList<>();
        this.trabajos.add(trabajo);
        this.genero = genero;
        this.gradoEscolaridad = gradoEscolaridad;
        this.totalEgresos = 0;
        this.totalIngresos = 0;
        this.egresos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
    }
    
    
    //Constructor utilizado para cuando se necesita crear una persona auxiliar para algunos calculos
    public Persona(){
    }
    
    /*
    Anade un objeto egreso a la lista de egresos, tambien almacena el monto del mismo
    en el total de la persona como tambien de la familia
    */
    public void anadirEgreso(String clasificacion, double monto, String descripcion, int semana){
        Egreso nuevoEgreso = new Egreso(clasificacion, monto, descripcion, semana);
        this.egresos.add(nuevoEgreso);
        this.totalEgresos += monto;
        this.familia.anadeTotalEgresos(monto);
        this.familia.anadeEgresos(nuevoEgreso);
    }
    
    /*
    Anade un objeto ingreso a la lista de egresos, tambien almacena el monto del mismo
    en el total de la persona como tambien de la familia
    */
    public void anadirIngreso(double monto, String descripcion, int semana){
        Ingreso nuevoIngreso = new Ingreso(monto, descripcion, semana);
        this.ingresos.add(nuevoIngreso);
        this.totalIngresos += monto;
        this.familia.anadeTotalIngresos(monto);
        this.familia.anadeIngreso(nuevoIngreso);
        this.familia.calculaClase();
    }
    
    public ArrayList egresosPorSemana(int semana){
        ArrayList<Egreso> semanales = new ArrayList<>();
        for(Egreso e: egresos){
            if(e.getSemana() == semana){
                semanales.add(e);
            }
        }
        return semanales;
    }
    
    //Revisa el monto gastado en la semana dada
    public double egresosSemana(int semana){
        double total = 0;
        for(Egreso e: egresos){
            if(e.getSemana() == semana){
                total += e.getMonto();
            }
        }
        return total;
    }
    
    //Revisa los ingresos existentes en la semana dada
    public ArrayList ingresosPorSemana(int semana){
        ArrayList<Ingreso> semanales = new ArrayList<>();
        for(Ingreso i: ingresos){
            if(i.getSemana() == semana){
                semanales.add(i);
            }
        }
        return semanales;
    }
    
    //Revisa la semana con mas gastos del agno, no se utiliza por ineficiencia
    public int semanaMasgastos(){
        int semana = 0;
        int cont = 1;
        double gastos = 0;
        while(cont <= 53){
            if(egresosSemana(cont) >= gastos){
                gastos = egresosSemana(cont);
                semana = cont;
            }    
        }
        return semana;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public String getGradoEscolaridad() {
        return gradoEscolaridad;
    }

    public double getTotalEgresos() {
        return totalEgresos;
    }

    public double getTotalIngresos() {
        return totalIngresos;
    }
    
    public ArrayList<String> getTrabajos(){
        return trabajos;
    }

    public ArrayList<Egreso> getEgresos() {
        return egresos;
    }

    public ArrayList<Ingreso> getIngresos() {
        return ingresos;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
    
    public void anadeTrabajo(String trabajo){
        this.trabajos.add(trabajo);
    }
    
}
