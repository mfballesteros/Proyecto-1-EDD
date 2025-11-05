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
    System.out.println("=== PRUEBA DEL SISTEMA ===");
    
    Grafo redSocial = new Grafo(true, 10);
    
    System.out.println("1. Insertando usuarios...");
    redSocial.insertarVertice("@ana");
    redSocial.insertarVertice("@carlos");
    redSocial.insertarVertice("@laura");
    redSocial.insertarVertice("@pedro");
    redSocial.insertarVertice("@marta");
    
    System.out.println("\n--- GRAFO ORIGINAL ---");
    redSocial.imprimirGrafo();
    
    System.out.println("2. Creando relaciones...");
    redSocial.insertarArista("@ana", "@carlos");
    redSocial.insertarArista("@carlos", "@laura");
    redSocial.insertarArista("@laura", "@pedro");
    redSocial.insertarArista("@pedro", "@marta");
    redSocial.insertarArista("@marta", "@ana");
    
    System.out.println("\n--- GRAFO ORIGINAL ---");
    redSocial.imprimirGrafo();
    
    System.out.println("\n--- ELIMINANDO ARISTA @pedro - @marta ---");
    redSocial.eliminarArista("@pedro", "@marta");
    redSocial.imprimirGrafo();

    System.out.println("\n--- ELIMINANDO VÉRTICE @ana ---");
    redSocial.eliminarVertice("@ana");
    redSocial.imprimirGrafo();
    
    redSocial.eliminarArista("@pedro", "@marta");
    redSocial.eliminarVertice("@ana");

    
  }
    

}