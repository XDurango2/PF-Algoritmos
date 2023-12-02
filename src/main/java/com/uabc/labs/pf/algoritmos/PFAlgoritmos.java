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
        
    }
}
