/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.pkg1.edd;

/**
 *
 * @author bettinacarnevali
 */
public class Proyecto1EDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaAdyacencia Lista1 = new ListaAdyacencia();
        Lista1.insertarPrincipio (2);
        Lista1.insertarFinal(3);
        Lista1.mostrarLista();
        Lista1.insertarPrincipio(4);
       
        Lista1.insertarFinal(7);
        Lista1.eliminarFinal();
        Lista1.mostrarLista();
        
        
       
    }
    
}
