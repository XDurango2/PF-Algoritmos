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
public class Numeros {
    private Arbol arbol1;

    public Numeros() {
        this.arbol1 = new Arbol();
    }

    public Arbol getArbol1() {
        return arbol1;
    }
    
    public ArrayList generaNumeros(int k, int n){
        ArrayList<Integer> array = new ArrayList<>();
        Random rd = new Random();
        for(int m=0;m<n;m++){
            array.add(rd.nextInt(k+1));//rango de 
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
    
    public void eliminar(int numero){
        arbol1.eliminar(numero);
    }
    
    public void mostrarPreorden()
    {
        System.out.println(arbol1.preorden());
    }
    
    public void mostrarInorden()
    {
        System.out.println(arbol1.inorden());
    }
    
    public void mostrarPostorden()
    {
        System.out.println(arbol1.postorden());
    }
    public void obtenerCodigo(int numero){
        System.out.println(arbol1.obtenerCodigo(numero));
    }
/*
    public void mostrarNivel(int nivel){
        arbol1.mostrarPorNivel(nivel);

    public String mostrarNivel(int nivel){
         return arbol1.mostrarPorNivel(nivel);
*/
    }

