/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_lienzo;

import AnalizadorCC.nodo;

/**
 *
 * @author Jordy Gonzalez
 */
public class Ejecutar {
    String Recorrido(nodo raiz) {
            String retorno = "";
            switch (raiz.getEtiqueta()) {
            case "inicio":
                    retorno=Recorrido(raiz.getHijos().get(0));
                     break;
            case "-":
                    Integer res = Integer.parseInt(Recorrido(raiz.getHijos().get(0)))- Integer.parseInt(Recorrido(raiz.getHijos().get(1)));
                    retorno = res.toString();
                    break;
            case "+":
                    Integer res2 = Integer.parseInt(Recorrido(raiz.getHijos().get(0))) + Integer.parseInt(Recorrido(raiz.getHijos().get(1)));
                    retorno = res2.toString();
                    break;
            case "*":
                    Integer res3 = Integer.parseInt(Recorrido(raiz.getHijos().get(0))) * Integer.parseInt(Recorrido(raiz.getHijos().get(1)));
                    break;
            case "/":
                    Integer res4 = (Integer.parseInt(Recorrido(raiz.getHijos().get(0))) / Integer.parseInt(Recorrido(raiz.getHijos().get(1))));
                    retorno = res4.toString();
                    break;
            case "numero":
                retorno=raiz.getValor();
                break;
            default: 
                System.out.println("Error");
                retorno = "";
                break;
            }
            return retorno;         
    }   
}
