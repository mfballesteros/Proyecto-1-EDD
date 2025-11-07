/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.edd;

/**
 *
 * @author a-utr
 */
public class NodoPila {
    int valor;
    NodoPila siguiente;

    public NodoPila(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
    
    public int getValor() {
        return valor;
    }
    
    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public NodoPila getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }
    
}
