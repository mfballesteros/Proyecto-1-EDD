/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.edd;

/**
 *
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
   
   //Metodo que evalua si la lista está vacía
   
   public boolean esVacio() {
       return head == null;
      
     }
   
   // Metodo insertar al principio de la lista
   
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
   
   //Metodo insertar al final de la lista
   
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
   
   public int getTamaño (){
       return this.tamaño;
   }
   
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
    
    // Metodo para recorrer e imprimir todos los elementos de la lista
    
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
    
    // Metodo para borrar un elemento x de la lista
    
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
    
    // Metodo recorrer la lista
    public void recorrer() {
        Nodo<T> actual = head;

        while (actual != null) {
            actual = actual.getNextNodo(); // avanzar
        }
    }
    
    // Metodo buscar un dato de la lista
    
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


   }
   

