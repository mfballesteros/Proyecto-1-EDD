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
    System.out.println("--- PRUEBA DE GRAFO ---");
    Grafo g = new Grafo(true, 5); // Grafo dirigido de 5 nodos

    System.out.println("\n--- 1. Insertar Vértices 0, 1, 3 ---");
    g.insertarVertice(0);
    g.insertarVertice(1);
    g.insertarVertice(3);
    g.imprimirGrafo();

    System.out.println("\n--- 2. Insertar Aristas 0->1, 1->3, 3->0 ---");
    g.insertarArista(0, 1);
    g.insertarArista(1, 3);
    g.insertarArista(3, 0);
    g.imprimirGrafo();

    System.out.println("\n--- 3. Eliminar Arista 1->3 ---");
    g.eliminarArista(1, 3);
    g.imprimirGrafo();

    System.out.println("\n--- 4. Eliminar Vértice 3 ---");
    // (Esto debe borrar el vértice 3 y la arista 3->0)
    g.eliminarVertice(3);
    g.imprimirGrafo();

    System.out.println("\n--- 5. Prueba de Error (Insertar en Vértice 3 eliminado) ---");
    // (Esto debe imprimir tu error "no existe")
    g.insertarArista(0, 3);
    
    System.out.println("\n--- PRUEBA FINALIZADA ---");
    }
    
}
