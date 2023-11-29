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


}
