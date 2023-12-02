/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uabc.labs.pf.algoritmos;

/**
 *clase que modela un arbol binario completo.
 * @author us
 */
public class arbol {
    private nodo raiz;
    //constructor
    public arbol() {
        
    }
    
    /**
     * metodo para insertar un dato al arbol
     * @param dato 
     */
    public void insertar(int dato){
        if(exists(dato)==false)//no puede haber  datos repetidos
        {
            if(raiz==null){
            raiz=new nodo(dato);
            }else{
            insertar(raiz,dato);
            }
        }
    }    
    /**
     * metodo para insertar un dato como hijo de un nodo padre,
     * busca un lugar para el dato, usando recursividad.
     * @param padre
     * @param dato 
     */
    private void insertar(nodo padre,int dato){
        if(dato>(int)padre.getDato()){
            if(padre.getRight()==null){
                padre.setRight(new nodo(dato));
            }else{
                this.insertar(padre.getRight(), dato);
            }
        }else{
            if(padre.getLeft()==null){
                padre.setLeft(new nodo(dato));
            }else{
                this.insertar(padre.getLeft(), dato);
            }
        }
    }
    
    /**
     * metodo para encontrar un dato en el arbol
     * @param find
     * @return 
     */
    public boolean exists(int find){
        return exists(raiz,find);
    }
    
    /**
     * metodo para determinar si el dato que se busca es el nodo raiz, 
     * sino los compara con sus hijos considerando su valor.
     * @param n
     * @param find
     * @return 
     */
    private boolean exists(nodo n,int find){
        if(n==null){
            return false;
        }
        if((int)n.getDato()==find){
            return true;
        }else if(find<(int)n.getDato()){
            return exists(n.getLeft(),find);
        }else{
            return exists(n.getRight(),find);
        }
    }
    
    private String RecorrerPreorden(nodo n) {
        String valores="";
        if (n != null) {
            valores+=n.getDato()+" ";
            valores+=RecorrerPreorden(n.getLeft());
            valores+=RecorrerPreorden(n.getRight());
        }
        return valores;
    }

    private String RecorrerInorden(nodo n) {
        String valores="";
        if (n != null) {
            valores+=RecorrerInorden(n.getLeft());
            valores+=n.getDato()+" ";
            valores+=RecorrerInorden(n.getRight());
        }
        return valores;
    }

    private String postorden(nodo n) {
        String valores="";
        if (n != null) {
            valores+=postorden(n.getLeft());
            valores+=postorden(n.getRight());
            valores+=n.getDato()+" ";
        }
        return valores;
    }

    public String preorden() {
        return this.RecorrerPreorden(this.raiz);
    }

    public String inorden() {
        return this.RecorrerInorden(this.raiz);
    }

    public String postorden() {
        return this.postorden(this.raiz);
    }
    
    // Método para eliminar un dato en el árbol
    public void eliminar(int dato) {
    // Se llama al método privado que elimina el dato de forma recursiva
    raiz = eliminar(raiz, dato);
}

    // Método privado que elimina un dato en el árbol de forma recursiva
    private nodo eliminar(nodo nodo, int dato) {
    // Si el nodo es nulo, se retorna nulo
    if (nodo == null) {
        return null;
    }
    // Si el dato es menor que el dato del nodo actual, se elimina en el subárbol izquierdo
    if (dato < (int)nodo.getDato()) {
        nodo.setLeft(eliminar(nodo.getLeft(), dato));
    } else if (dato > (int)nodo.getDato()) {
        // Si el dato es mayor que el dato del nodo actual, se elimina en el subárbol derecho
        nodo.setRight(eliminar(nodo.getRight(), dato));
    } else {
        // Si el dato es igual que el dato del nodo actual, se tienen tres casos
        if (nodo.getLeft()== null && nodo.getRight()== null) {
            // Si el nodo no tiene hijos, se elimina el nodo y se retorna nulo
            nodo = null;
        } else if (nodo.getLeft()!= null && nodo.getRight()== null) {
            // Si el nodo tiene un solo hijo izquierdo, se reemplaza el nodo por su hijo y se retorna el hijo
            nodo = nodo.getLeft();
        } else if (nodo.getLeft() == null && nodo.getRight() != null) {
            // Si el nodo tiene un solo hijo derecho, se reemplaza el nodo por su hijo y se retorna el hijo
            nodo = nodo.getRight();
        } else {
            // Si el nodo tiene dos hijos, se busca el sucesor del nodo en el subárbol derecho
            nodo sucesor = buscarSucesor(nodo.getRight());
            // Se copia el dato del sucesor al nodo
            nodo.setDato(sucesor.getDato());
            // Se elimina el sucesor en el subárbol derecho
            nodo.setRight(eliminar(nodo.getRight(), (int)sucesor.getDato()));
        }
    }
    // Se retorna el nodo modificado
    return nodo;
}

    // Método para buscar el sucesor de un nodo en el árbol
    private nodo buscarSucesor(nodo nodo) {
        // El sucesor es el nodo más a la izquierda del subárbol derecho
        while (nodo.getLeft()!= null) {
            nodo = nodo.getLeft();
        }
        // Se retorna el sucesor
        return nodo;
    }

    public void recorridoNiveles(){
        nodo n = raiz;
        
    }
    
}
