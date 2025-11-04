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

    public void insertarVertice (int n){
        if (n < 0 || n >= maxNodos) { // comprobando max cantidad de nodos
            System.out.println("Error, se supera el numero de nodos maximo dentro del grafo");
        }else {
            for (int i = numVertices; i < numVertices + n; i++) { // agregar el vertice
                listaAd[i] = new ListaAdyacencia();
            }
            numVertices += n;
        }   
    }
    
    public void insertarArista(int i, int j) { // se toman dos elementos, i como el primero y j con el que se quiere relacionar
        if (i<0 || j <0 || i >= maxNodos || j >= maxNodos) { // si estan fuera de los vertices que existen
            System.out.println("Error, vértice no válido");
            return;
        }
        listaAd[i].insertarFinal(j);
        if (!dirigido) listaAd[j].insertarFinal(i); // si no es dirigido agregas tambien a j la relacion con i 
    }
    
    public void eliminarArista (int i, int j){ //eliminando relaciones
        if (i<0 || j <0 || i >= maxNodos || j >= maxNodos){
            System.out.println("Error, vertice no valido");
            return;
        }
        
        if (listaAd[i] == null || listaAd[j] == null) { // esta validacion se hace para verificar si el elemento ya fue eliminado
        System.out.println("Error, el vértice " + i + " o " + j + " no existe (fue eliminado).");
        return;
        }

        listaAd[i].eliminarElem(j);
        if (!dirigido) listaAd[j].eliminarElem(i);
        }
    
    public void eliminarVertice (int i) { //eliminando usuarios
        if (i < 0 || i >= maxNodos || listaAd [i] == null) {
            return; }
        for (int x = 0; x < maxNodos; x++) {
            if (listaAd[x] != null) {
                listaAd[x].eliminarElem(i);
            }
        }
        listaAd[i] = null;  
        numVertices--;
    }
 
    
    public void imprimirGrafo (int numVertices, int maxNodos){
        System.out.println("El grafo todavia tiene" + maxNodos + "nodos a utilizar");
        System.out.println("En el grafo existen" + numVertices + "usuarios registrados");
        for (int i = 0; i < maxNodos; i++) {
            System.out.print("Vértice " + i + ": ");
            listaAd[i].mostrarLista();
        }
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
}

    