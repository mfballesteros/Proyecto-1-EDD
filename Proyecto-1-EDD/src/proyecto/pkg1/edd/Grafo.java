/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.edd;

/**
 *
 * @author danie_xe5djpj
 */

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class Grafo {
    private boolean dirigido;
    private int numVertices;
    private int maxNodos;
    private ListaAdyacencia [] listaAd; //aqui va la lista general CREAR ARRAY LIST, LISTA DE ARREGLOS
    private String [] nombres; //creando un arreglo de strings
    private Graph visualGraph;
   
            
  
//CONSTRUCTORES 

    public Grafo(boolean dirigido, int n) {
        this.dirigido = true;
        this.numVertices = 0; // cuando creas el grafo vacio
        this.maxNodos = n;
        System.setProperty("org.graphstream.ui", "swing");
        this.visualGraph = new SingleGraph ("Red SocialGrafo");
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
        visualGraph.addNode(nombre);
        visualGraph.getNode(nombre).setAttribute ("ui.label", nombre); // Para que el nombre se vea
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
        String edgeId = primero + "->" + segundo; 
// Usamos los nombres como IDs de los nodos. Usamos 'dirigido' para la dirección
        visualGraph.addEdge (edgeId, primero, segundo, dirigido);
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
        if (this.visualGraph.getNode(nom) != null) {
        this.visualGraph.removeNode(nom);
        }
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

    // este metodo se basa en visitiar primero a todos los que conoce y apilar cuando ya no tienes más relaciones por visitar
    //(el primero que entra es el ultimo que sale)
    // se utiliza la pila para encontrar todos los elementos completos.
    private void primeraDFS(int nodo, boolean[] nodosVisitados, Pila pila) {
        nodosVisitados[nodo] = true; // para qye no lo visite otra vez
    
    if (listaAd[nodo] != null) {
        Nodo <Integer> nodoConectado = listaAd[nodo].getHead();
        

        while (nodoConectado != null) {
            // Obtiene el índice
            int vecino = nodoConectado.getData();
            
            if (!nodosVisitados[vecino]) {
                primeraDFS(vecino, nodosVisitados, pila);
            }
            nodoConectado = nodoConectado.getNextNodo();
        }
    }
    
// agrega a la pila
    pila.apilar(nodo);
}
   


// ahora transponer el DSF para hallar relaciones, se voltean las relaciones para encontrar sus visitas entre ellos.
    private ListaAdyacencia<Integer>[] grafoTranspuesto() {
        ListaAdyacencia<Integer>[] grafoVolteado = new ListaAdyacencia[maxNodos];    
        for (int i = 0; i < maxNodos; i++) {
            if (listaAd[i] != null) {
                Nodo<Integer> actual = listaAd[i].getHead();
                while (actual != null) {
                    int j = actual.getData();
                    if (grafoVolteado[j] == null) {
                        grafoVolteado[j] = new ListaAdyacencia<>();
                    }
                    grafoVolteado[j].insertarFinal(i);
                    actual = actual.getNextNodo();
                }
            }
        }

        return grafoVolteado;
    }

//recorremos grafo transpuesto y lo vamos imprimiendo si los usuarios estan relacionados
    private void printGrafoTranspuesto (int nodo, boolean[] visitado, ListaAdyacencia<Integer>[] grafoTranspuesto) {
        visitado[nodo] = true;
        System.out.print(nombres[nodo] + " ");

        if (grafoTranspuesto[nodo] != null) {
            Nodo<Integer> actual = grafoTranspuesto[nodo].getHead();
            while (actual != null) {
                int vecino = actual.getData();
                if (!visitado[vecino]) {
                    printGrafoTranspuesto(vecino, visitado, grafoTranspuesto);
                }
                actual = actual.getNextNodo();
            }
        }
    }
    
//ahora buscamos los componentes, usando los metodos anteriores
    public void componentesFuertementeConectados() {    
        if (numVertices == 0) return;

        boolean[] visitado = new boolean[maxNodos];
        Pila pila = new Pila();

        for (int i = 0; i < maxNodos; i++) {
            if (nombres[i] != null && !visitado[i]) {
                primeraDFS(i, visitado, pila);
            }
        }

        ListaAdyacencia<Integer>[] grafoTranspuesto = grafoTranspuesto();

        for (int i = 0; i < maxNodos; i++) {
            visitado[i] = false;
        }

        int numComponente = 1;

        while (!pila.esVacia()) {
            int nodo = pila.desapilar();

            if (nombres[nodo] != null && !visitado[nodo]) {
                printGrafoTranspuesto(nodo, visitado, grafoTranspuesto);
                numComponente++;
            }
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
    
    /**
 * Recibe listas de datos y construye el grafo llamando a insertarVertice e insertarArista.
 * Esto sincroniza automáticamente con GraphStream.
 */
    public void cargarDesdeArchivo(String[] usuarios, String[] relaciones) {
    
    for (String nombreUsuario : usuarios) {
        if (nombreUsuario != null) {
            this.insertarVertice(nombreUsuario); 
        }
    }
    
    for (String relacion : relaciones) {
        if (relacion != null) {
            String [] partes = relacion.split(","); 
            
            if (partes.length == 2){
                String origen = partes [0].trim();
                String destino = partes [1].trim();
                
                this.insertarArista(origen, destino);
            }
        }
    }
    
    System.out.println("Grafo construido y sincronizado. Nodos totales: " + usuarios.length);
}

   public void mostrarGrafo(){
    System.out.println("Generando representación visual del grafo con GraphStream...");
    
    // El estilo se corrige aquí, asegurando que todos los bloques estén cerrados correctamente.
    String styleSheet = 
        "graph { fill-color: #f0f0f0; padding: 50px; }" +
        "node {" +
        "   text-mode: normal;" + 
        "   text-size: 17px;" + 
        "   text-color: black;" + // Se añade para mejor contraste en texto grande
        "   fill-color: #C39EE4; size: 20px;" +
        "}" + 
        "edge {" + 
        "   fill-color: gray;" + 
        
        (this.dirigido ? " arrow-size: 8px, 4px;" : "") + 
        "}"; 
        
    this.visualGraph.setAttribute ("ui.stylesheet", styleSheet);
    this.visualGraph.setAttribute ("ui.quality");
    this.visualGraph.setAttribute ("ui.antialias");
    
    //Muestra la ventana y la lanza en un hilo separado
    Viewer viewer = this.visualGraph.display();
    
    // Aqui se mantiene la ventana oculta al cerrarse, pero sin detener
    // el programa principal
    viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    System.out.println("Ventana de grafo mostrada");
    }
   
}

    