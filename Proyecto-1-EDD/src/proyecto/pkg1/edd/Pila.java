/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.edd;

/** Clase que define una pila, se usara para implementar los componentes fuertemente enlazados.
 * La Pila se usa para implementar el algoritmo Kosaraju
 * Solo almacena valores enteros
 * @author danie_xe5djpj
 */
public class Pila {
    private NodoPila cima;
    private int tamano;

    //Constructor de la clase, se crea pila vacía
    public Pila() {
        this.cima = null;
        this.tamano = 0;
    }
    
    
    /**
     * Verifica si la pila está vacía.
     *
     * @return true si la pila no tiene elementos, false si tiene.
     */
    public boolean esVacia() {
        return cima == null;
    }
    
    
    /**
     * Agrega un nuevo elemento a la cima de la pila.
     * @param valor 
     */

    public void apilar(int valor) {
        NodoPila nuevo = new NodoPila(valor);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamano++;
    }
    
    
    /**
     * Elimina y devuelve el elemento que está en la cima de la pila.
     * @return El valor (int) que estaba en la cima.
     * Se hace un IllegalStateException si se intenta desapilar de una pila vacia
     */

    public int desapilar() {
        if (esVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        int valor = cima.getValor();
        cima = cima.getSiguiente();
        tamano--;
        return valor;
    }

    /**
     * Devuelve el elemento que está en la cima de la pila
     * @return El valor (int) de la cima
     * Se hace un IlegalStateException si no hay cima
     */
    
    public int cima() {
        if (esVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        return cima.getValor();
    }
    

    /**
     * Devuelve el número de elementos actualmente en la pila.
     * @return El tamano (int) de la pila.
     */
    public int tamano() {
        return tamano;
    }
    
    /**
     * Vacía la pila.
     * Vuelve la cima a null y el tamaño a 0.
     */

    public void limpiar() {
        cima = null;
        tamano = 0;
    }
    
}
