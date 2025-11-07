/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.pkg1.edd;

/**
 *
 * @author a-utr
 */
public class Pila {
    private NodoPila cima;
    private int tamano;

    public Pila() {
        this.cima = null;
        this.tamano = 0;
    }

    public boolean esVacia() {
        return cima == null;
    }

    public void apilar(int valor) {
        NodoPila nuevo = new NodoPila(valor);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamano++;
    }

    public int desapilar() {
        if (esVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        int valor = cima.getValor();
        cima = cima.getSiguiente();
        tamano--;
        return valor;
    }

    public int cima() {
        if (esVacia()) {
            throw new IllegalStateException("La pila esta vacia");
        }
        return cima.getValor();
    }

    public int tamano() {
        return tamano;
    }

    public void limpiar() {
        cima = null;
        tamano = 0;
    }
    
}
