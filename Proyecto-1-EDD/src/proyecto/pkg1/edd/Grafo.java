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
    private int numVertices;
    private int maxNodos;
    private ListaAdyacencia [] listaAd;
    //aqui va la lista general CREAR ARRAY LIST, LISTA DE ARREGLOS
            
   
//CONSTRUCTORES 

    public Grafo(boolean dirigido, int n) {
        this.dirigido = dirigido;
        this.numVertices = 0; // cuando creas el grafo vacio
        this.maxNodos = n;
        this.listaAd = new ListaAdyacencia [n]; //el tamano del array sera la cantidad max de nodos
        //cada indice del array es un vertice
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
     * @return the numVertices
     */
    public int getNumVertices() {
        return numVertices;
    }

    /**
     * @param numVertices the numVertices to set
     */
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    /**
     * @return the maxNodos
     */
    public int getMaxNodos() {
        return maxNodos;
    }

    /**
     * @param maxNodos the maxNodos to set
     */
    public void setMaxNodos(int maxNodos) {
        this.maxNodos = maxNodos;
    }

    /**
     * @return the listaAd
     */
    public ListaAdyacencia[] getListaAd() {
        return listaAd;
    }

    /**
     * @param listaAd the listaAd to set
     */
    public void setListaAd(ListaAdyacencia[] listaAd) {
        this.listaAd = listaAd;
    }

    