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
            return;
        }
        if (listaAd[n] != null) {
            System.out.println("Error: El vértice " + n + " ya existe.");
            return;
        }
       
        listaAd[n] = new ListaAdyacencia();
        numVertices ++;
    }
    
    
    public void insertarArista(int i, int j) { // se toman dos elementos, i como el primero y j con el que se quiere relacionar
        if (i<0 || j <0 || i >= maxNodos || j >= maxNodos) { // si estan fuera de los vertices que existen
            System.out.println("Error, vértice no válido");
            return;
        }
        if (listaAd[i] == null || listaAd[j] == null) {
            System.out.println("Error: Vértice " + i + " o " + j + " no existe (fue eliminado).");
        
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
 
    
    
    
    public void imprimirGrafo (){
        System.out.println("El grafo todavia tiene" + maxNodos + "nodos a utilizar");
        System.out.println("En el grafo existen" + numVertices + "usuarios registrados");
        for (int i = 0; i < maxNodos; i++) {
            if (listaAd[i] != null) {
                System.out.print("Vértice " + i + ": ");
                listaAd[i].mostrarLista(); 
        } else {
            System.out.println("Vértice " + i + "vacio");
        }
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
     * @return the maxNodos
     */
    public int getMaxNodos() {
        return maxNodos;
    }
    /**
     * @return the listaAd
     */
    public ListaAdyacencia[] getListaAd() {
        return listaAd;
    }

}

    