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
    private ListaAdyacencia [] listaAd; //aqui va la lista general CREAR ARRAY LIST, LISTA DE ARREGLOS
    private String [] nombres; //creando un arreglo de strings
   
            
   
//CONSTRUCTORES 

    public Grafo(boolean dirigido, int n) {
        this.dirigido = true;
        this.numVertices = 0; // cuando creas el grafo vacio
        this.maxNodos = n;
        this.listaAd = new ListaAdyacencia [n]; //el tamano del array sera la cantidad max de nodos
        //cada indice del array es un vertice
        this.nombres = new String[n]; // creando una lista paralela
    }

    public void insertarVertice (String nombre){
        if (accederIndice(nombre) != -1) {
            System.out.println("Error: el vértice '" + nombre + "' ya existe.");
            return;
    }
        if (numVertices >= maxNodos) { // comprobando max cantidad de nodos
            System.out.println("Error, se supera el numero de nodos maximo dentro del grafo");
            return; 
        }
        
        listaAd[numVertices] = new ListaAdyacencia();
        nombres[numVertices] = nombre;
        numVertices++;
    }
    
    
    
    public int accederIndice (String nombre){
        for (int i = 0; i < maxNodos; i++ ){
             if (nombres[i] != null && nombres[i].equals(nombre)) {
                 return i;
             }
        }
        return -1;
        
        
    }
    
    
    public int obtenerIdUsuario(String nombre) {
        return accederIndice(nombre);
    }
    
    
    public void insertarArista(String primero, String segundo) { // se toman dos elementos, i como el primero y j con el que se quiere relacionar
        int i = accederIndice(primero);
        int j = accederIndice(segundo);

        if (i<0 || j <0 || i >= maxNodos || j >= maxNodos) { // si estan fuera de los vertices que existen
            System.out.println("Error, vértice no válido");
            return;
        }
        if (listaAd[i] == null || listaAd[j] == null) {
            System.out.println("Error: Vértice " + i + " o " + j + " no existe (fue eliminado).");
        
        return;
        
        }
        
        
        listaAd[i].insertarFinal(j);
        if (!dirigido){
            listaAd[j].insertarFinal(i);
        } // si no es dirigido agregas tambien a j la relacion con i 
    
        }
    
    
    public void eliminarArista (String primero,String segundo){ //eliminando relaciones
        int i = accederIndice(primero);
        int j = accederIndice(segundo);
        
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
    
    
    
    public void eliminarVertice (String nom) { //eliminando usuarios
        int i = accederIndice(nom);
        if (i < 0 || i >= maxNodos || listaAd [i] == null) {
            return; }
        for (int x = 0; x < maxNodos; x++) {
            if (listaAd[x] != null) {
                listaAd[x].eliminarElem(i);
            }
        }
        listaAd[i] = null;  
        nombres [i] = null;
    }
 
    
    
    public void imprimirGrafo (){
        System.out.println("El grafo todavia tiene" + maxNodos + "nodos a utilizar");
        System.out.println("En el grafo existen" + numVertices + "usuarios registrados");
        for (int i = 0; i < numVertices; i++) {
            if (nombres[i] != null && listaAd[i] != null) {
                System.out.print("User " + nombres[i] + ": [ ");  
                boolean primeraRelacion = true;
                for (int j = 0; j < numVertices; j++) {
                    if (nombres[j] != null && listaAd[i].buscar(j) != null) { 
                        if (!primeraRelacion) {
                        System.out.print(" , ");
                    }
                    System.out.print("" + nombres[j]);
                    primeraRelacion = false;
                }
            }
            System.out.println(" ]");
        }
     }        


            for (int i = numVertices; i < maxNodos; i++) {
                System.out.println("Vértice " + i + " vacío");
                }
        }

    

    
     //no se requieren usar los sets para num vertice y maxnodos al ser una cantidad definida desde el inicio, y no modificable.
    
    /**
     * @return the 
     */
    public boolean isDirigido() {
        return dirigido;
    }

    /**
     * @param dirigido the to set
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

    /**
     * @return the 
     */
    public String[] getNombres() {
        return nombres;
    }

    
    
}

    