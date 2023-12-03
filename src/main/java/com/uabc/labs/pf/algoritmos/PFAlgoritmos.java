/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.uabc.labs.pf.algoritmos;

import java.util.ArrayList;

/**
 * clase principal del proyecto, lo usaremos para hacer pruebas.
 * @author us
 */
public class PFAlgoritmos {

    public static void main(String[] args) {
        numeros num = new numeros();
        ArrayList valores = new ArrayList<>();
        valores = num.generaNumeros(10, 5);
        System.out.println("valores: "+valores);
        
        num.insertaNumeros(valores);
        System.out.print("preorden: ");
        num.mostrarPreorden();
        System.out.print("inorden: ");
        num.mostrarInorden();
        System.out.print("postorden: ");
        num.mostrarPostorden();
        
        //-------------------Pruebas nivel-----------------
        arbol a = new arbol();
        a.insertar(9);
        a.insertar(1);
        a.insertar(12);
        a.insertar(4);
        a.insertar(0);
        a.insertar(14);
        a.insertar(6);
        a.insertar(10);
        a.insertar(-1);
        System.out.println(""+a.inorden());
        System.out.println("Nivel 1 "+a.mostrarPorNivel(1));
        System.out.println("Nivel 2 "+a.mostrarPorNivel(2));
        System.out.println("Nivel 3 "+a.mostrarPorNivel(3));
        System.out.println("Recorrido por nivel "+a.recorridoPorNiveles());
    }
}
