/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uabc.labs.pf.algoritmos;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author us
 */
public class numeros {
    private arbol arbol1;

    public numeros() {
        this.arbol1 = new arbol();
    }
    
    public ArrayList generaNumeros(int k, int n){
        ArrayList<Integer> array = new ArrayList<>();
        Random rd = new Random();
        for(int m=0;m<n;m++){
            array.add(rd.nextInt(k));
        }
        return array;
    }
    public void insertaNumeros(ArrayList<Integer> numeros){
        for(int k =0;k<numeros.size();k++){
            arbol1.insertar(numeros.get(k));
            
        }
    }
    public void insertaNumero(int dato){
        arbol1.insertar(dato);
    }
    
    public boolean eliminar(int numero){
        
    }
}
