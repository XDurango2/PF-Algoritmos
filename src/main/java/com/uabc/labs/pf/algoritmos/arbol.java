/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uabc.labs.pf.algoritmos;

import java.util.Stack;

/**
 *clase que modela un arbol binario completo.
 * @author us
 */
public class Arbol {
    private Nodo raiz;
    //constructor
    public Arbol() {
        
    }
    
    /**
     * metodo para insertar un dato al arbol
     * @param dato 
     */
    public int regresarRaiz()
    {
        return (int) raiz.getDato();
    }
    public void insertar(int dato){
        if(exists(dato)==false)//no puede haber  datos repetidos
        {
            if(raiz==null){
            raiz=new Nodo(dato);
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
    private void insertar(Nodo padre,int dato){
        if(dato>(int)padre.getDato()){
            if(padre.getRight()==null){
                padre.setRight(new Nodo(dato));
            }else{
                this.insertar(padre.getRight(), dato);
            }
        }else{
            if(padre.getLeft()==null){
                padre.setLeft(new Nodo(dato));
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
    private boolean exists(Nodo n,int find){
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
    
    private String RecorrerPreorden(Nodo n) {
        String valores="";
        if (n != null) {
            valores+=n.getDato()+" ";
            valores+=RecorrerPreorden(n.getLeft());
            valores+=RecorrerPreorden(n.getRight());
        }
        return valores;
    }

    private String RecorrerInorden(Nodo n) {
        String valores="";
        if (n != null) {
            valores+=RecorrerInorden(n.getLeft());
            valores+=n.getDato()+" ";
            valores+=RecorrerInorden(n.getRight());
        }
        return valores;
    }

    

    
    public String recorridoPorNivel()
    {
         StringBuilder valores = new StringBuilder(recorrido(raiz,1));
         if(valores.length()>1){
            //En caso que sea de tamano mas 1 significa que al menos se imprimio un numero, entonces debe eliminar la coma al final
        return valores.deleteCharAt(valores.length()-1).toString();
        }
        //Regresa si no hay nada , por lo que no tiene que eliminar la coma
        return valores.toString();
       
        
    }

    private String recorrido(Nodo n,int nivel)
    {
        //Se recorre por nivel
        String valoresPorNivel = recorrerParaMostrarPorNivel(1, n, nivel);
        String valores = "";
        if(valoresPorNivel.length()>1){
            //Se guarda en un string por niveles
        valores +=valoresPorNivel;
            valores +=recorrido(n, nivel+1);
        }
        return valores;
        
        //Este metodo se recorre la misma cantidad de veces que niveles tenga, es decir si tiene 3 niveles entonces se recorre 3 veces
    }
    
    //Este metodo muestra los datos de los nodos del nivel deseadp
    public String mostrarPorNivel(int nivel)
    {
        //Manada a llamar un metodo recursivo para recorrer el arbol
        StringBuilder cadena=new StringBuilder(recorrerParaMostrarPorNivel(1, raiz, nivel));
        //Su nivel inicia en 1, y su primer nodo es la raiz
        //Se guarda en una tipo StringBuilder para eliminar la ultima coma
        if(cadena.length()>1){
            //En caso que sea de tamano mas 1 significa que al menos se imprimio un numero, entonces debe eliminar la coma al final
        return cadena.deleteCharAt(cadena.length()-1).toString();
        }
        //Regresa si no hay nada , por lo que no tiene que eliminar la coma
        return cadena.toString();
        
    
    }

    private String recorrerParaMostrarPorNivel(int nivelActual, Nodo n,int nivelDeseado)
    {
        String valores = "";
        if(nivelActual == nivelDeseado){
            //Imprime si el nivel en el que se encuentra el nodo esta en el nivel deseado
            //System.out.print (n.getDato()+" ");
            valores = n.getDato()+",";
        }
        if(n.getLeft() !=null){
            //Si hay algo en la izquierda entonces se recorre
            valores = valores +recorrerParaMostrarPorNivel(nivelActual+1, n.getLeft(), nivelDeseado);
        //Aumenta el nivel en uno porque se bajara en el arbol
        }
        if(n.getRight()!=null){
             //Si hay algo en la derecha entonces se recorre
            valores = valores+recorrerParaMostrarPorNivel(nivelActual+1, n.getRight(), nivelDeseado);
        }
        return valores;
    }
    
    
    
    
    
        
    private String postorden(Nodo n) {
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
    private Nodo eliminar(Nodo nodo, int dato) {
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
            Nodo sucesor = buscarSucesor(nodo.getRight());
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
    private Nodo buscarSucesor(Nodo nodo) {
        // El sucesor es el nodo más a la izquierda del subárbol derecho
        while (nodo.getLeft()!= null) {
            nodo = nodo.getLeft();
        }
        // Se retorna el sucesor
        return nodo;
    }



    public String obtenerCodigo(int numero){
        Nodo n = raiz;
        String cadena = findCodigo(n,numero);
        Stack ayuda = new Stack();//invertir usando stack
        char[] cadenaArray = cadena.toCharArray();
        String nuevaCadena ="";
        for(char c :cadenaArray)
        {
        ayuda.push(c);
        }
        
         for(char c :cadenaArray)
        {
        nuevaCadena+=ayuda.pop();
        }
        return nuevaCadena;
    }
  
    private String findCodigo(Nodo n,int find){
        String valor="";
        if(n==null){
            return "no encontrado";
        }
        if((int)n.getDato()==find){
            return valor;
        }else if(find<(int)n.getDato()){
            valor+="0";
            valor+=findCodigo(n.getLeft(),find);
            return valor;
        }else{
            valor+="1";
            valor+=findCodigo(n.getRight(),find);
            return valor;
        }
    }
    

    
}
