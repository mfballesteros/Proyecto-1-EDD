package proyecto.pkg1.edd;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bettinacarnevali
 */
public class Nodo <T> {
    // Atributos de la clase
    
    private T data;
    private Nodo <T> next;
    
    
    // Constructor de la clase
    
    public Nodo (T data) {
        this.data = data;
        this.next = null;  
     }
    
    // Metodo para obtener el usuario almacenado en el Nodo 
    public T getData(){
        return this.data;
        
    }
    
    // Metodo para modificar el usuario almacenado en el Nodo 
    
    public void setData(T data){
        this.data = data;
    }
    
    //Metodo para obtener el nodo siguiente de la fila
    
    public Nodo <T> getNextNodo(){
        return this.next;
        
    }
    
    //Metodo para modificar el nodo siguiente al actual
    public void setNextNodo(Nodo <T> next){
        this.next = next;
        
    }
    
}
