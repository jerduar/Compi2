/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_lienzo;

import AnalizadorCC.nodo;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Jerson Villatoro
 */
public class Ejecutar {

    Hashtable<String, Simbolo> contenedor = null;

    String Recorrido(nodo raiz) {
        String retorno = "";
        switch (raiz.getEtiqueta()) {
            case "inicio":
                retorno = Recorrido(raiz.getHijos().get(0));
                break;
            case "-":
                Integer res = Integer.parseInt(Recorrido(raiz.getHijos().get(0))) - Integer.parseInt(Recorrido(raiz.getHijos().get(1)));
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
                retorno = raiz.getValor();
                break;
            default:
                System.out.println("Error");
                retorno = "";
                break;
        }
        return retorno;
    }

    nodo Busqueda_main(nodo raiz) {
        int contador = 0;
        nodo envio = null;

        for (int i = 0; i < raiz.hijos.size(); i++) {
            if ("PRINCIPAL".equals(raiz.hijos.get(i).getEtiqueta())) {
                envio = raiz.hijos.get(i);
                contador++;
            }
        }

        if (contador == 1 && envio != null) {
            contenedor = new Hashtable<>();
            Recolectar_General(raiz);
            return envio;
        } else {
            return null;
        }
    }

    void Iniciar_Reco(nodo raiz) {

    }

    Hashtable Recolectar_General(nodo raiz) {
        nodo aux;
        for (int i = 0; i < raiz.hijos.size(); i++) {
            aux = raiz.hijos.get(i);
            switch (aux.getEtiqueta()) {

                //FUNCION
                case "FUNCION":
                    if (aux.hijos.size() == 9) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.ambito = "Global";
                        nuevo.tipo = 1;
                        nuevo.id = aux.hijos.get(2).getValor();
                        nuevo.Param = aux.hijos.get(4);

                        String tipo_param = "";

                        for (int y = 0; y < nuevo.Param.hijos.size(); y++) {
                            tipo_param += nuevo.Param.hijos.get(y).hijos.get(0).getValor();
                        }
                        nuevo.Nodo = (nodo) aux;
                        nuevo.tipo_dato = aux.hijos.get(1).getValor();

                        if (contenedor.put(nuevo.id + tipo_param + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    } else if (aux.hijos.size() == 5) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.ambito = "Global";
                        nuevo.tipo = 1;
                        nuevo.id = aux.hijos.get(1).getValor();
                        nuevo.Param = null;
                        nuevo.Nodo = (nodo) aux;
                        nuevo.tipo_dato = aux.hijos.get(0).getValor();

                        if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    } else if (aux.hijos.size() == 8 && Buscar_nodo("LISTAPARAM", aux) != null) {

                        Simbolo nuevo = new Simbolo();
                        nuevo.ambito = "Global";
                        nuevo.tipo = 1;
                        nuevo.id = aux.hijos.get(1).getValor();
                        nuevo.Param = aux.hijos.get(3);
                        nuevo.Nodo = (nodo) aux;
                        nuevo.tipo_dato = aux.hijos.get(0).getValor();

                        String tipo_param = "";
                        for (int y = 0; y < nuevo.Param.hijos.size(); y++) {
                            tipo_param += nuevo.Param.hijos.get(y).hijos.get(0).getValor();
                        }

                        if (contenedor.put(nuevo.id + tipo_param + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    } else {
                        Simbolo nuevo = new Simbolo();
                        nuevo.ambito = "Global";
                        nuevo.tipo = 1;
                        nuevo.id = aux.hijos.get(2).getValor();
                        nuevo.Param = null;
                        nuevo.Nodo = (nodo) aux;
                        nuevo.tipo_dato = aux.hijos.get(1).getValor();

                        if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    }
                    System.out.println("Encontre un funcion");
                    break;

                //METODOS
                case "PROCEDIMIENTO":

                    if (aux.hijos.size() == 4) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.ambito = "Global";
                        nuevo.Nodo = (nodo) aux;
                        nuevo.id = aux.hijos.get(0).getValor();
                        nuevo.tipo = 2;
                        nuevo.Param = null;
                        nuevo.Sentencias = aux.hijos.get(2);

                        if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    } else if (aux.hijos.size() == 9) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux;
                        nuevo.ambito = "Global";
                        nuevo.id = aux.hijos.get(2).getValor();
                        nuevo.tipo = 2;
                        nuevo.Param = aux.hijos.get(4);
                        nuevo.Sentencias = aux.hijos.get(7);
                        nuevo.conservar = true;

                        String tipo_param = "";
                        for (int y = 0; y < nuevo.Param.hijos.size(); y++) {
                            tipo_param += nuevo.Param.hijos.get(y).hijos.get(0).getValor();
                        }

                        if (contenedor.put(nuevo.id + tipo_param + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    } else if ("CONSERVAR".equals(aux.hijos.get(0).getEtiqueta()) && "void".equals(aux.hijos.get(1).getEtiqueta()) && Buscar_nodo("LISTAPARAM", aux) == null) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux;
                        nuevo.ambito = "Global";
                        nuevo.id = aux.hijos.get(2).getValor();
                        nuevo.tipo = 2;
                        nuevo.Param = null;
                        nuevo.Sentencias = aux.hijos.get(4);
                        nuevo.conservar = true;

                        if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    } else if ("void".equals(aux.hijos.get(0).getEtiqueta()) && Buscar_nodo("LISTAPARAM", aux) == null) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux;
                        nuevo.ambito = "Global";
                        nuevo.id = aux.hijos.get(1).getValor();
                        nuevo.tipo = 2;
                        nuevo.Param = null;
                        nuevo.Sentencias = aux.hijos.get(4);

                        if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    } else if ("IDENTIFICADOR".equals(aux.hijos.get(0).getEtiqueta()) && Buscar_nodo("LISTAPARAM", aux) != null) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux;
                        nuevo.ambito = "Global";
                        nuevo.id = aux.hijos.get(0).getValor();
                        nuevo.tipo = 2;
                        nuevo.Param = aux.hijos.get(2);
                        nuevo.Sentencias = aux.hijos.get(5);

                        String tipo_param = "";
                        for (int y = 0; y < nuevo.Param.hijos.size(); y++) {
                            tipo_param += nuevo.Param.hijos.get(y).hijos.get(0).getValor();
                        }

                        if (contenedor.put(nuevo.id + tipo_param + nuevo.ambito, nuevo) != null) {
                            System.out.println("Ya existe");
                        }

                    } else if ("CONSERVAR".equals(aux.hijos.get(0).getEtiqueta()) && "IDENTIFICADOR".equals(aux.hijos.get(1).getEtiqueta()) && Buscar_nodo("LISTAPARAM", aux) == null) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux;
                        nuevo.ambito = "Global";
                        nuevo.id = aux.hijos.get(1).getValor();
                        nuevo.tipo = 2;
                        nuevo.Param = null;
                        nuevo.Sentencias = aux.hijos.get(3);

                        if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                            System.out.println("ya existe");
                        }
                    } else {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux;
                        nuevo.ambito = "Global";
                        nuevo.id = aux.hijos.get(1).getValor();
                        nuevo.tipo = 2;
                        nuevo.Param = aux.hijos.get(3);
                        nuevo.Sentencias = aux.hijos.get(6);

                        String tipo_param = "";
                        for (int y = 0; y < nuevo.Param.hijos.size(); y++) {
                            tipo_param += nuevo.Param.hijos.get(y).hijos.get(0).getValor();
                        }

                        if (contenedor.put(nuevo.id + tipo_param + nuevo.ambito, nuevo) != null) {
                            System.out.println("Ya existe");
                        }
                    }

                //DECLARACION DE VARIABLES
                case "DEC":
                    if (aux.hijos.size() == 4) {
                        String tipo = aux.hijos.get(2).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(3);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = "Global";
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;
                            nuevo.tipo_dato = tipo;
                            nuevo.conservar = true;

                            if (contenedor.put(nuevo.id, nuevo) != null) {
                                System.out.println("ya existe");
                            }

                        }
                    } else {
                        String tipo = aux.hijos.get(1).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(2);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = "Global";
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;//es una variable
                            nuevo.tipo_dato = tipo;

                            if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                                System.out.println("ya existe");
                            }
                        }
                    }
                //CASO DE DECLARACION CON ASIGNACION
                case "DECASIG":
                    if (aux.hijos.size() == 5) {
                        String tipo = aux.hijos.get(1).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(2);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = "Global";
                            nuevo.valor = aux.hijos.get(4);
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;//es una variable
                            nuevo.tipo_dato = tipo;

                            if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                                System.out.println("ya existe");
                            }
                        }

                    } else {
                        String tipo = aux.hijos.get(1).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(2);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = "Global";
                            nuevo.valor = aux.hijos.get(4);
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;//es una variable
                            nuevo.tipo_dato = tipo;
                            nuevo.conservar = true;

                            if (contenedor.put(nuevo.id + nuevo.ambito, nuevo) != null) {
                                System.out.println("ya existe");
                            }
                        }
                    }
            }
        }

        ImprimirHash();
        return contenedor;
    }

    nodo Buscar_nodo(String Etiqueta, nodo raiz) {
        int i;
        for (i = 0; i < raiz.hijos.size(); i++) {
            if (Etiqueta.equals(raiz.hijos.get(i).getEtiqueta())) {
                return raiz.hijos.get(i);
            }
        }
        return null;
    }

    void ImprimirHash() {
        Enumeration e = contenedor.elements();
        Simbolo clave;
        while (e.hasMoreElements()) {
            clave = (Simbolo) e.nextElement();
            System.out.println("Clave : " + clave.id);
        }
    }

    boolean verficar_variable(String id, String ambito) {
        Simbolo s = contenedor.get(id);
        if (s == null) {
            return false;
        } else {
            return s.ambito.equals(ambito);
        }
    }
    

    boolean verificar_funcion(String id, nodo param, String ambito) {
        Simbolo s = contenedor.get(id);
        if (s == null) {
            return false;
        } else if (s.id.equals(id)) {
            if (s.Param == null && param == null) {
                System.out.println("ambos son nulos");
                return true;
            } else if ((s.Param == null && param != null) || (s.Param != null && param == null)) {
                System.out.println("alguno es nulo");
                return false;
            } else if (s.Param.hijos.size() != param.hijos.size()) {
                System.out.println("tamaño diferente");
                return false;
            } else {
                int i;
                for (i = 0; i < s.Param.hijos.size(); i++) {
                    if (s.Param.hijos.get(i).hijos.get(0).getValor().equals(param.hijos.get(i).hijos.get(0).getValor())) {
                        System.out.println(s.Param.hijos.get(i).hijos.get(0).getValor() + " " + param.hijos.get(i).hijos.get(0).getValor());
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }
}
