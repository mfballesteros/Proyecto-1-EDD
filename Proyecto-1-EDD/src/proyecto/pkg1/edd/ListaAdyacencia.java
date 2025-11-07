/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.edd;

/**
 * Clase que define una lista simplemente enlazada, genérica, usara para implementar grafos
 * Mantiene los nodos vecinos de un vértice
 * @param <T> El tipo de dato de los elementos
 * @author bettinacarnevali
 */
public class ListaAdyacencia <T> {
    
    //Atributos de la Clase
    
   private Nodo <T> head;
   private Nodo <T> tail;
   private int tamaño;
   
    //Constructor de la clase
   
   public ListaAdyacencia (){
       this.head = null;
       this.tail = null;
       this.tamaño = 0;
      
   }
   
    /**
     * Metodo que evalua si la lista esta vacia
     * @return valor logico de si la lista esta vacia
     */
   
   public boolean esVacio() {
       return head == null;
      
     }
   
   /**Metodo insertar al principio de la lista
    * 
    * @param dato El elemento a añadir 
    */
   
   
   
   public void insertarPrincipio(T dato){
       Nodo <T> nuevo = new Nodo<> (dato);
       
       if (esVacio()){
           head = nuevo;
           tail = nuevo;
           
       } else{
           nuevo.setNextNodo(head);
           head = nuevo;
       }
       tamaño ++;
   }
   
   /**Metodo insertar al final de la lista
    * 
    * @param dato El elemento a añadir 
    */
   
   public void insertarFinal(T dato){
       Nodo <T> nuevo = new Nodo <> (dato);
       
       if (esVacio()){
           head = nuevo;
           tail = nuevo;
           
       }else{
           tail.setNextNodo(nuevo);
           tail = nuevo;
           
       }
       tamaño ++;
       
   }
   
   /**
    * Metodo que devuelve el numero actual de elementos en la lista
    * @return El tamaño de la lista (un entero)
    */
   
   public int getTamaño (){
       return this.tamaño;
   }
   
   /** 
    * Metodo que elimina el **primer nodo** de la lista
    * @return El dato (de tipo T) que estaba en el nodo eliminado
    * o {@code null} si la lista esta vacía
    */
   
   public T eliminarInicio(){
       if (esVacio()){
           return null;
       } 
       
       T datoEliminado = head.getData();
       
       if (head == tail){
           head = null;
           tail = null;
           
       }else {
           head = head.getNextNodo();
           
       }
       tamaño --;
       return datoEliminado;
        
    }   
   
   /**
    * Elimina en **ultimo nodo** de la lista
    * 
    * @return El dato (de tipo T) que estaba en el nodo eliminado, 
    * o {@code null} si la lista está vacía.
    */
       
    public T eliminarFinal(){
        if (esVacio()){
            return null;
            
        }
        T datoEliminado = tail.getData();
        
        if ( head == tail){
            head = null;
            tail = null;
            
        } else{
            Nodo <T> actual = head;
            while (actual.getNextNodo() != tail){
                actual = actual.getNextNodo();
                
            }
            
            tail = actual;
            tail.setNextNodo(null);
        }
        
        tamaño --;
        return datoEliminado;
        
    }
    
    /**
     * Muestra en la consola todos los elementos en la lista
     * si la lista es vacia, imprime un mensaje indicandolo
     */
    
    public void mostrarLista() {
        if (esVacio()) {
        System.out.println("La lista está vacía.");
        return;
        }

        Nodo<T> actual = head;
        System.out.print(" [ ");
    
        while (actual != null) {
            System.out.print(actual.getData());
        
            if (actual.getNextNodo() != null) {
                System.out.print(" , ");
            }
        
            actual = actual.getNextNodo();
        }
        System.out.println(" ]");
    }
    
    /**
     * Busca y elimina ** la primera ocurrrencia** del elemento dado
     * utiliza {@code equals()} para comparar el dato
     * @param dato El elemento (de tipo T) a buscar y eliminar de la lista
     */
    
    public void eliminarElem (T dato){
        if (esVacio()){
            return;
        }
        
        Nodo <T> actual = head;
        Nodo <T> anterior = null;
        
        if (actual.getData().equals(dato)){
            eliminarInicio();
            return;
        }
       
        while(actual != null && !actual.getData().equals(dato)){
            anterior = actual;
            actual = actual.getNextNodo();
        }
        
        if (actual == null){
            return; // dato no encontrado
        }
        
        if (actual == tail){
            eliminarFinal();
            return;
        }
        
        anterior.setNextNodo(actual.getNextNodo());
        tamaño--;
    }
    
    /**
     * Recorre la lista **desde la cabeza hasta la cola**
     * Esta implementacion itera a traves de todos los nodos sin realizar ninguna operacion
     */
    
    public void recorrer() {
        Nodo<T> actual = head;

        while (actual != null) {
            actual = actual.getNextNodo(); // avanzar
        }
    }
    
    /**
     * Busca la primera ocurrencia del elemento especifico en la lista
     * @param dato El elemento (de tipo T) a buscar
     * @return El **nodo** ({@code Nodo <T>}) que contiene el dato si es encontrado
     * o {@code null} si el dato no esta en la lista
     */
    
    public Nodo<T> buscar(T dato) {
        Nodo<T> actual = head;

        while (actual != null) {
            if (actual.getData().equals(dato)) {
                return actual; 
            }
            actual = actual.getNextNodo();
        }

        return null; // No encontrado
    }
    
    /**
     * @return the head
     */
    public Nodo <T> getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Nodo <T> head) {
        this.head = head;
    }

    /**
     * @return the tail
     */
    public Nodo <T> getTail() {
        return tail;
    }

    /**
     * @param tail the tail to set
     */
    public void setTail(Nodo <T> tail) {
        this.tail = tail;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }


   }
   

