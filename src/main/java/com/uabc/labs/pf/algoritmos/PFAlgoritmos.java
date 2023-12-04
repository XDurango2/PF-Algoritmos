/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.uabc.labs.pf.algoritmos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * clase principal del proyecto, lo usaremos para hacer pruebas.
 * @author us
 */
public class PFAlgoritmos {

    public static void main(String[] args) {

        Numeros num = new Numeros();
        Scanner sc = new Scanner(System.in);
        //ArrayList valores = num.generaNumeros(10, 10);
        ArrayList valores = new ArrayList();
        valores.add(50);
        valores.add(17);
        valores.add(72);
        valores.add(12);
        valores.add(23);
        valores.add(54);
        valores.add(76);
        valores.add(9);
        valores.add(14);
        valores.add(19);
        valores.add(67);
        System.out.println("valores: "+valores);
        
        num.insertaNumeros(valores);
        System.out.print("preorden: ");
        num.mostrarPreorden();
        System.out.print("inorden: ");
        num.mostrarInorden();
        System.out.print("postorden: ");
        num.mostrarPostorden();

        //-------------------Pruebas nivel-----------------
      
        System.out.println("");
        
        System.out.println("Nivel 1 "+num.mostrarNivel(1));
        System.out.println("Nivel 2 "+num.mostrarNivel(2));
        System.out.println("Nivel 3 "+num.mostrarNivel(3));
        System.out.println("Nivel 4 "+num.mostrarNivel(4));
        System.out.println("ingrese el numero a buscar para obtener su codigo:");
        int numero=sc.nextInt();
        System.out.println("codigo: ");
        num.obtenerCodigo(numero);
        System.out.println("ingrese el nivel a mostrar:");
        int nivel = sc.nextInt();
        System.out.println("nivel "+nivel+": "+num.mostrarNivel(nivel));

    }
}
