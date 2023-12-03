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
        numeros num = new numeros();
        Scanner sc = new Scanner(System.in);
        ArrayList valores = num.generaNumeros(10, 10);
        System.out.println("valores: "+valores);
        
        num.insertaNumeros(valores);
        System.out.print("preorden: ");
        num.mostrarPreorden();
        System.out.print("inorden: ");
        num.mostrarInorden();
        System.out.print("postorden: ");
        num.mostrarPostorden();
        System.out.println("ingrese el numero a buscar para obtener su codigo:");
        int numero=sc.nextInt();
        System.out.println("codigo: ");
        num.obtenerCodigo(numero);
        System.out.println("ingrese el nivel a mostrar:");
        int nivel = sc.nextInt();
        num.mostrarNivel(nivel);
    }
}
