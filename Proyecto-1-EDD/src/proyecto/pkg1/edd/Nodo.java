package proyecto.pkg1.edd;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Representa un **nodo individual** en una lista enlazada
 *  <p> Cada nodo almacena un dato y mantiene una referencia al siguiente nodo en la secuencia
 *  @param <T> El tipo de dato que alamcenara el nodo
 * @author bettinacarnevali
 */

public class Nodo <T> {
    // Atributos de la clase
    
    private T data;
    private Nodo <T> next;
    
    
    /** Constructor de la clase para crear un nuevo nodo
     * 
     * @param data el dato de tipo <T> que se va a almacenar dentro del nodo
     */ 
    
    public Nodo (T data) {
        this.data = data;
        this.next = null;  
     }
    
    /** Metodo que devuelve el **dato** elemento de tipo T almacenado en el Nodo 
     * 
     * @return El dato contenido en el Nodo
     */
    public T getData(){
        return this.data;
        
    }
    
    /**
     * Metodo para modificar el usuario almacenado en el Nodo 
     * 
     * @param data El nuevo dato (de tipo T) que se va a almacenar 
     */
    
    public void setData(T data){
        this.data = data;
    }
    
    /**Metodo para obtener el nodo siguiente de la fila
     * 
     * @return El siguiente nodo ({@code Nodo <T>})
     * o {@code null} si este es el último nodo.
     */
    
    public Nodo <T> getNextNodo(){
        return this.next;
        
    }
    
    /**Establece la **referencia al siguiente nodo** en la lista.
     * 
     * @param next El nodo ({@code Nodo<T>}) que seguirá a este nodo.
     * Puede ser {@code null} si es el nuevo final
     */
    public void setNextNodo(Nodo <T> next){
        this.next = next;
        
    }
    
}
