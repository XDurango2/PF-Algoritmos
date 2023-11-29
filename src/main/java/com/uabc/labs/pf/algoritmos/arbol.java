/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uabc.labs.pf.algoritmos;

/**
 *
 * @author us
 */
public class arbol {
    private nodo raiz;

    public arbol() {
        
    }
    public void insertar(int dato){
        if(raiz==null){
            raiz=new nodo(dato);
        }else{
            insertar(raiz,dato);
        }
    }
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
    
    public boolean exists(int find){
        return exists(raiz,find);
    }
    
    
    private boolean exists(nodo n,int find){
        if(n==null){
            return false;
        }
        if((int)n.getDato()==find){
            return true;
        }else if(find< (int)n.getDato()){
            return exists(n.getLeft(),find);
        }else{
            return exists(n.getRight(),find);
        }
    }
    
    private void preorden(nodo n) {
        if (n != null) {
            n.imprimirDato();
            preorden(n.getLeft());
            preorden(n.getRight());
        }
    }

    private void inorden(nodo n) {
        if (n != null) {
            inorden(n.getLeft());
            n.imprimirDato();
            inorden(n.getRight());
        }
    }

    private void postorden(nodo n) {
        if (n != null) {
            postorden(n.getLeft());
            postorden(n.getRight());
            n.imprimirDato();
        }
    }

    public void preorden() {
        this.preorden(this.raiz);
    }

    public void inorden() {
        this.inorden(this.raiz);
    }

    public void postorden() {
        this.postorden(this.raiz);
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


}
