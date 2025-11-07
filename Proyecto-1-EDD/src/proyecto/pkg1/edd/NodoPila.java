/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.edd;

/*** Representa un nodo individual dentro de la pila.
 *  Cada nodo almacena un dato y mantiene una referencia al siguiente nodo
 * @author danie_xe5djpj
 */
public class NodoPila {
    int valor;
    NodoPila siguiente;
    
/**
     * Constructor para crear un nuevo nodo de la pila.
     *
     * @param valor El valor (int) que se almacenara en este nodo.
     */
    
    public NodoPila(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
    
    /**
     * Obtiene el valor (int) almacenado en el nodo.
     *
     * @return Valor (int) del nodo.
     */
    
    public int getValor() {
        return valor;
    }
    
    
    
    /**
     * Establece o actualiza el valor (int) almacenado en el nodo.
     *
     * @param valor El nuevo valor (int) a guardar.
     */
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    /**
     * Obtiene la referencia al siguiente nodo en la pila.
     *
     * @return getSiguiente NodoPila, o null si este es el último.
     */
    public NodoPila getSiguiente() {
        return siguiente;
    }
    
    
    /**
     * Establece la referencia al siguiente nodo en la pila.
     *
     * @param siguiente El NodoPila que será el siguiente.
     */
    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
    
}
