/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uabc.labs.pf.algoritmos;

/**
 *clase para modelar un nodo de un arbol binario
 * @author us
 */
public class nodo <T> {
    private nodo left;
    private nodo right;
    private T dato;
    
    //constructor
    public nodo(T dato) {
        this.left = null;
        this.right = null;
        this.dato = dato;
    }

    //getters y setters
    public nodo getLeft() {
        return left;
    }

    public void setLeft(nodo left) {
        this.left = left;
    }

    public nodo getRight() {
        return right;
    }

    public void setRight(nodo right) {
        this.right = right;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }
    
    
    public void imprimirDato() {
        System.out.println(this.getDato());
    }
}
