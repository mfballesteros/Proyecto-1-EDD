/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.edd;

/**
 *
 * @author danie_xe5djpj
 */
public class Grafo {
    private boolean dirigido;
    private int numnodos;
    private int maxnodos;
    //aqui va la lista general CREAR ARRAY LIST, LISTA DE ARREGLOS
            
   
//CONSTRUCTORES 

    public Grafo(boolean dirigido, int numnodos, int maxnodos) {
        this.dirigido = dirigido;
        this.numnodos = 0;
        this.maxnodos = 100;
    }

    /**
     * @return the dirigido
     */
    public boolean isDirigido() {
        return dirigido;
    }

    /**
     * @param dirigido the dirigido to set
     */
    public void setDirigido(boolean dirigido) {
        this.dirigido = dirigido;
    }

    /**
     * @return the numnodos
     */
    public int getNumnodos() {
        return numnodos;
    }

    /**
     * @param numnodos the numnodos to set
     */
    public void setNumnodos(int numnodos) {
        this.numnodos = numnodos;
    }

    /**
     * @return the maxnodos
     */
    public int getMaxnodos() {
        return maxnodos;
    }

    /**
     * @param maxnodos the maxnodos to set
     */
    public void setMaxnodos(int maxnodos) {
        this.maxnodos = maxnodos;
     }
}   
    
  
