/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_lienzo;

import AnalizadorCC.Analizador_Lienzo;
import AnalizadorCC.ParseException;
import AnalizadorCC.TokenMgrError;
import AnalizadorCC.nodo;
import Lienzo.Dibujo;
import Lienzo.Lienzo;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import static proyecto_lienzo.TablaSimbolo.reporte;

/**
 *
 * @author Jerson Villatoro
 */
public class Ejecutar {

    Hashtable<String, Simbolo> contenedor = null;
    ArrayList<String> Lista_errores;
    Lienzo lienzo;
    int espera;

    public Ejecutar(int espera) {
        this.espera = espera;
    }

    nodo Ejecutar1(nodo raiz, TablaSimbolo tabla, String ambito) throws InterruptedException {
        nodo retorno = null;
        Thread.sleep(200);
        switch (raiz.getEtiqueta()) {
            case "EA1":
                if (raiz.hijos.size() == 1) {
                    retorno = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                } else {
                    nodo e1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                    nodo e2 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);

                    //OPERADOR +
                    if (raiz.hijos.get(1).getEtiqueta().equals("+")) {

                        //ENTERO + DOUBLE || DOUBLE + ENTERO
                        if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO") || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE")) {
                            Double res = Double.parseDouble(e1.getValor()) + Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE + CARACTER
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("CARACTER")) {
                            Double res = Double.parseDouble(e1.getValor()) + e2.getValor().charAt(1);
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //CARACTER + DOBLE
                        else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("DOBLE")) {
                            Double res = e1.getValor().charAt(1) + Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //BOOLEANO + DOBLE
                        else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("DOBLE")) {
                            Boolean b = Boolean.parseBoolean(e1.getValor());
                            Double res = Double.parseDouble(e2.getValor());
                            if (b) {
                                res++;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE + BOOLEANO
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("BOOLEANO")) {
                            Boolean b = Boolean.parseBoolean(e2.getValor());
                            Double res = Double.parseDouble(e1.getValor());
                            if (b) {
                                res++;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE + DOBLE
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE")) {
                            Double res = Double.parseDouble(e1.getValor()) + Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //ENTERO + CARACTER
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("CARACTER")) {
                            Integer res = Integer.parseInt(e1.getValor()) + (char) e2.getValor().charAt(1);
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //CARACTER + ENTERO
                        else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("ENTERO")) {
                            Integer res = (char) e1.getValor().charAt(1) + Integer.parseInt(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //BOOLEANO + ENTERO
                        else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("ENTERO")) {
                            Boolean b = Boolean.parseBoolean(e1.getValor());
                            Integer res = Integer.parseInt(e2.getValor());
                            if (b) {
                                res++;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //ENTERO + BOOLEANO
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("BOOLEANO")) {
                            Boolean b = Boolean.parseBoolean(e2.getValor());
                            Integer res = Integer.parseInt(e1.getValor());
                            if (b) {
                                res++;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //ENTERO + ENTERO
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")) {
                            Integer res = Integer.parseInt(e1.getValor()) + Integer.parseInt(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //CADENA + CADENA
                        else if (e1.getEtiqueta().equals("CADENA") && e2.getEtiqueta().equals("CADENA")) {
                            String res = e1.getValor() + e2.getValor();
                            retorno = new nodo();
                            retorno.setEtiqueta("CADENA");
                            retorno.setValor(res);
                        } //CADENA + ENTERO || ENTERO + CADENA
                        else if (e1.getEtiqueta().equals("CADENA") && e2.getEtiqueta().equals("ENTERO") || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("CADENA")) {
                            String res = e1.getValor() + e2.getValor();
                            retorno = new nodo();
                            retorno.setEtiqueta("CADENA");
                            retorno.setValor(res);
                        } //BOOLEANO + BOOLEANO
                        else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("BOOLEANO")) {
                            Boolean res = Boolean.parseBoolean(e1.getValor()) || Boolean.parseBoolean(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("BOOLEANO");
                            retorno.setValor(res.toString());
                        }

                        //OPERADOR -
                    } else if (raiz.hijos.get(1).getEtiqueta().equals("-")) {

                        //ENTERO - DOBLE || DOBLE - ENTERO || DOBLE - DOBLE
                        if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE") || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO") || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE")) {
                            Double res = Double.parseDouble(e1.getValor()) - Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //BOOLEANO - DOBLE
                        else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("DOBLE")) {
                            Boolean b = Boolean.parseBoolean(e1.getValor());
                            Double res = Double.parseDouble(e2.getValor());
                            if (b) {
                                res = 1 - res;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE - BOOLEANO
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("BOOLEANO")) {
                            Boolean b = Boolean.parseBoolean(e2.getValor());
                            Double res = Double.parseDouble(e1.getValor());
                            if (b) {
                                res--;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE - CARACTER
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("CARACTER")) {
                            Double res = Double.parseDouble(e1.getValor()) - e2.getValor().charAt(1);
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //CARACTER - DOBLE
                        else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("DOBLE")) {
                            Double res = e1.getValor().charAt(1) - Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //ENTERO - CARACTER
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("CARACTER")) {
                            Integer res = Integer.parseInt(e1.getValor()) - (char) e2.getValor().charAt(1);
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //CARACTER - ENTERO
                        else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("ENTERO")) {
                            Integer res = (char) e1.getValor().charAt(1) - Integer.parseInt(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //ENTERO - BOOLEANO
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("BOOLEANO")) {
                            Boolean b = Boolean.parseBoolean(e2.getValor());
                            Integer res = Integer.parseInt(e1.getValor());
                            if (b) {
                                res--;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //BOOLEANO - ENTERO
                        else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("ENTERO")) {
                            Boolean b = Boolean.parseBoolean(e1.getValor());
                            Integer res = Integer.parseInt(e2.getValor());
                            if (b) {
                                res = 1 - res;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //ENTERO - ENTERO
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")) {
                            Integer res = Integer.parseInt(e1.getValor()) - Integer.parseInt(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        }
                    }
                }
                break;

            case "EA2":
                if (raiz.hijos.size() == 1) {
                    retorno = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                } else {
                    nodo e1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                    nodo e2 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);

                    //OPERADOR *
                    if (raiz.hijos.get(1).getEtiqueta().equals("*")) {

                        //ENTERO * DOBLE || DOBLE * ENTERO || DOBLE * DOBLE
                        if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO") || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE") || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE")) {
                            Double res = Double.parseDouble(e1.getValor()) * Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE * CARACTER
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("CARACTER")) {
                            Double res = Double.parseDouble(e1.getValor()) * e2.getValor().charAt(1);
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //CARACTER * DOBLE
                        else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("DOBLE")) {
                            Double res = e1.getValor().charAt(1) * Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //BOOLEANO * DOBLE
                        else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("DOBLE")) {
                            Boolean b = Boolean.parseBoolean(e1.getValor());
                            Double res = Double.parseDouble(e2.getValor());
                            if (!b) {
                                res *= 0;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE * BOOLEANO
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("BOOLEANO")) {
                            Boolean b = Boolean.parseBoolean(e2.getValor());
                            Double res = Double.parseDouble(e1.getValor());
                            if (!b) {
                                res *= 0;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //ENTERO * CARACTER
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("CARACTER")) {
                            Integer res = Integer.parseInt(e1.getValor()) * (char) e2.getValor().charAt(1);
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //CARACTER * ENTERO
                        else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("ENTERO")) {
                            Integer res = (char) e1.getValor().charAt(1) * Integer.parseInt(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());
                        } //ENTERO * ENTERO
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")) {
                            Integer res = Integer.parseInt(e1.getValor()) * Integer.parseInt(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("ENTERO");
                            retorno.setValor(res.toString());

                        } //BOOLEANO * BOOLEANO
                        else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("BOOLEANO")) {
                            Boolean res = Boolean.parseBoolean(e1.getValor()) || Boolean.parseBoolean(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("BOOLEANO");
                            retorno.setValor(res.toString());
                        }

                    } //OPERADOR /
                    else if (raiz.hijos.get(1).getEtiqueta().equals("/")) {

                        //ENTERO / DOBLE || DOBLE / ENTERO || DOBLE / DOBLE || ENTERO / ENTERO
                        if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE") || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO") || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE") || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")) {
                            Double res = Double.parseDouble(e1.getValor()) / Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE / CARACTER
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("CARACTER")) {
                            Double res = Double.parseDouble(e1.getValor()) / e2.getValor().charAt(1);
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //CARACTER * DOBLE
                        else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("DOBLE")) {
                            Double res = e1.getValor().charAt(1) / Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //BOOLEANO / DOBLE || BOOLEANO / ENTERO
                        else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("DOBLE") || e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("ENTERO")) {
                            Boolean b = Boolean.parseBoolean(e1.getValor());
                            Double res = Double.parseDouble(e2.getValor());
                            if (!b) {
                                res = 0 / res;
                            } else {
                                res = 1 / res;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //DOBLE / BOOLEANO || ENTERO / BOOLEANO
                        else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("BOOLEANO") || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("BOOLEANO")) {
                            Boolean b = Boolean.parseBoolean(e2.getValor());
                            Double res = Double.parseDouble(e1.getValor());
                            if (!b) {
                                res /= 0;
                            }
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //ENTERO / CARACTER
                        else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("CARACTER")) {
                            Double res = Double.parseDouble(e1.getValor()) / (char) e2.getValor().charAt(1);
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        } //CARACTER / ENTERO
                        else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("ENTERO")) {
                            Double res = (char) e1.getValor().charAt(1) / Double.parseDouble(e2.getValor());
                            retorno = new nodo();
                            retorno.setEtiqueta("DOBLE");
                            retorno.setValor(res.toString());
                        }
                    }
                }
                break;

            case "F":

                if (raiz.hijos.get(0).getEtiqueta().equals("IDENTIFICADOR")) {
                    Simbolo s = tabla.Buscar(raiz.hijos.get(0).getValor() + 3);
                    if (s != null) {
                        if (s.valor != null) {
                            retorno = s.valor;
                        } else {
                            //variable no inicializada
                        }
                    } else {
                        //varible no existe
                    }
                }//LLAMADO FUNCION
                else if (raiz.hijos.get(0).getEtiqueta().equals("LLAMADO")) {
                    retorno = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                } else if (raiz.hijos.size() == 1) {
                    retorno = raiz.hijos.get(0);
                }
                break;

            case "EA3":
                if (raiz.hijos.size() == 1) {
                    retorno = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                } else {
                    nodo e1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                    nodo e2 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);

                    //ENTERO ^ DOBLE || DOBLE ^ ENTERO || DOBLE ^ DOBLE
                    if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE") || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO") || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE")) {
                        Double res = Math.pow(Double.parseDouble(e1.getValor()), Double.parseDouble(e2.getValor()));
                        retorno = new nodo();
                        retorno.setEtiqueta("DOBLE");
                        retorno.setValor(res.toString());
                    } //DOBLE ^ CARACTER
                    else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("CARACTER")) {
                        Double res = Math.pow(Double.parseDouble(e1.getValor()), e2.getValor().charAt(1));
                        retorno = new nodo();
                        retorno.setEtiqueta("DOBLE");
                        retorno.setValor(res.toString());
                    } //CARACTER ^ DOBLE
                    else if (e1.getEtiqueta().equals("CARACTER") && e2.getEtiqueta().equals("DOBLE")) {
                        Double res = Math.pow(e1.getValor().charAt(1), Double.parseDouble(e2.getValor()));
                        retorno = new nodo();
                        retorno.setEtiqueta("DOBLE");
                        retorno.setValor(res.toString());
                    } //BOOLEANO ^ DOBLE
                    else if (e1.getEtiqueta().equals("BOOLEANO") && e2.getEtiqueta().equals("DOBLE")) {
                        Boolean b = Boolean.parseBoolean(e1.getValor());
                        Double res = 1.0;
                        if (!b) {
                            res = 0.0;
                        }
                        retorno = new nodo();
                        retorno.setEtiqueta("DOBLE");
                        retorno.setValor(res.toString());
                    } //DOBLE ^ BOOLEANO
                    else if (e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("BOOLEANO")) {
                        Boolean b = Boolean.parseBoolean(e2.getValor());
                        Double res = Double.parseDouble(e1.getValor());
                        if (!b) {
                            res = 1.0;
                        }
                        retorno = new nodo();
                        retorno.setEtiqueta("DOBLE");
                        retorno.setValor(res.toString());
                    } //ENTERO ^ ENTERO
                    else if (e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")) {
                        Integer res = (int) Math.pow(Integer.parseInt(e1.getValor()), Integer.parseInt(e2.getValor()));
                        retorno = new nodo();
                        retorno.setEtiqueta("ENTERO");
                        retorno.setValor(res.toString());
                    }
                }
                break;

            case "ER1":
                nodo e1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo e2 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);

                // E1 == E2
                if (raiz.hijos.get(1).getEtiqueta().equals("==")) {
                    retorno = new nodo();
                    retorno.setEtiqueta("BOOLEANO");
                    if (e1.getValor().equals(e2.getValor()) && e1.getEtiqueta().equals(e2.getEtiqueta())) {
                        retorno.setValor("true");
                    } else {
                        retorno.setValor("false");
                    }
                } //E1 >= E2
                else if (raiz.hijos.get(1).getEtiqueta().equals(">=")) {
                    retorno = new nodo();
                    retorno.setEtiqueta("BOOLEANO");
                    if ((e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")
                            || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE")
                            || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE")
                            || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO"))) {

                        Boolean res = Double.parseDouble(e1.getValor()) >= Double.parseDouble(e2.getValor());
                        retorno.setValor(res.toString());

                    } else {
                        retorno.setValor("false");
                    }
                } //E1 > E2
                else if (raiz.hijos.get(1).getEtiqueta().equals(">")) {
                    retorno = new nodo();
                    retorno.setEtiqueta("BOOLEANO");
                    if ((e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")
                            || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE")
                            || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE")
                            || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO"))) {

                        Boolean res = Double.parseDouble(e1.getValor()) > Double.parseDouble(e2.getValor());
                        retorno.setValor(res.toString());

                    } else {
                        retorno.setValor("false");
                    }
                } //E1 < E2
                else if (raiz.hijos.get(1).getEtiqueta().equals("<")) {
                    retorno = new nodo();
                    retorno.setEtiqueta("BOOLEANO");
                    if ((e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")
                            || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE")
                            || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE")
                            || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO"))) {

                        Boolean res = Double.parseDouble(e1.getValor()) < Double.parseDouble(e2.getValor());
                        retorno.setValor(res.toString());

                    } else {
                        retorno.setValor("false");
                    }
                } //E1 <= E2
                else if (raiz.hijos.get(1).getEtiqueta().equals("<=")) {
                    retorno = new nodo();
                    retorno.setEtiqueta("BOOLEANO");
                    if ((e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("ENTERO")
                            || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("DOBLE")
                            || e1.getEtiqueta().equals("ENTERO") && e2.getEtiqueta().equals("DOBLE")
                            || e1.getEtiqueta().equals("DOBLE") && e2.getEtiqueta().equals("ENTERO"))) {

                        Boolean res = Double.parseDouble(e1.getValor()) <= Double.parseDouble(e2.getValor());
                        retorno.setValor(res.toString());

                    } else {
                        retorno.setValor("false");
                    }
                } // E1 != E2
                else if (raiz.hijos.get(1).getEtiqueta().equals("!=")) {
                    retorno = new nodo();
                    retorno.setEtiqueta("BOOLEANO");
                    if (!e1.getValor().equals(e2.getValor()) || !e1.getEtiqueta().equals(e2.getEtiqueta())) {
                        retorno.setValor("true");
                    } else {
                        retorno.setValor("false");
                    }
                }
                break;

            case "EL1":
                nodo n1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo n2 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);

                if (n1.getEtiqueta().equals("BOOLEANO") && n2.getEtiqueta().equals("BOOLEANO")) {
                    retorno = new nodo();
                    retorno.setEtiqueta("BOOLEANO");

                    //E1 || E2
                    if (raiz.hijos.get(1).getEtiqueta().equals("||")) {
                        Boolean res = Boolean.parseBoolean(n1.getValor()) || Boolean.parseBoolean(n2.getValor());
                        retorno.setValor(res.toString());
                    } // E1 !|| E2
                    else if (raiz.hijos.get(1).getEtiqueta().equals("!||")) {
                        Boolean res = !(Boolean.parseBoolean(n1.getValor()) || Boolean.parseBoolean(n2.getValor()));
                        retorno.setValor(res.toString());
                    } //E1 &| E2
                    else if (raiz.hijos.get(1).getEtiqueta().equals("!||")) {
                        Boolean res = Boolean.parseBoolean(n1.getValor()) ^ Boolean.parseBoolean(n2.getValor());
                        retorno.setValor(res.toString());
                    }
                }

                break;

            case "EL2":
                nodo n3 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo n4 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);

                if (n3.getEtiqueta().equals("BOOLEANO") && n4.getEtiqueta().equals("BOOLEANO")) {
                    retorno = new nodo();
                    retorno.setEtiqueta("BOOLEANO");

                    //E1 && E2
                    if (raiz.hijos.get(1).getEtiqueta().equals("&&")) {
                        Boolean res = Boolean.parseBoolean(n3.getValor()) && Boolean.parseBoolean(n4.getValor());
                        retorno.setValor(res.toString());
                    } //E1 !&& E2
                    else if (raiz.hijos.get(1).getEtiqueta().equals("!&&")) {
                        Boolean res = !(Boolean.parseBoolean(n3.getValor()) && Boolean.parseBoolean(n4.getValor()));
                        retorno.setValor(res.toString());
                    }
                }

                break;

            case "EL3":
                nodo n = Ejecutar1(raiz.hijos.get(1), tabla, ambito);
                if (n.getEtiqueta().equals("BOOLEANO")) {
                    Boolean res = !Boolean.parseBoolean(n.getValor());
                    n.setValor(res.toString());
                    retorno = (nodo) n;
                }

                break;

            case "DEC":
                if (raiz.hijos.size() == 4 && Buscar_nodo("AMBITO", raiz) == null) {
                    String tipo = raiz.hijos.get(2).getValor();
                    int index;
                    nodo aux2 = raiz.hijos.get(3);
                    for (index = 0; index < aux2.hijos.size(); index++) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux2.hijos.get(index);
                        nuevo.ambito = ambito;
                        nuevo.id = aux2.hijos.get(index).getValor();
                        nuevo.tipo = 3;
                        nuevo.tipo_dato = tipo;
                        nuevo.conservar = true;

                        if (tabla.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    }

                } else if (raiz.hijos.size() == 4 && Buscar_nodo("CONSERVAR", raiz) == null) {
                    String tipo = raiz.hijos.get(2).getValor();
                    int index;
                    nodo aux2 = raiz.hijos.get(3);
                    for (index = 0; index < aux2.hijos.size(); index++) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux2.hijos.get(index);
                        nuevo.ambito = ambito;
                        nuevo.id = aux2.hijos.get(index).getValor();
                        nuevo.tipo = 3;
                        nuevo.visibilidad = visibilidad(raiz.hijos.get(0).getValor());
                        nuevo.tipo_dato = tipo;

                        if (tabla.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    }

                } else if (raiz.hijos.size() == 5) {
                    String tipo = raiz.hijos.get(3).getValor();
                    int index;
                    nodo aux2 = raiz.hijos.get(4);
                    for (index = 0; index < aux2.hijos.size(); index++) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux2.hijos.get(index);
                        nuevo.ambito = ambito;
                        nuevo.id = aux2.hijos.get(index).getValor();
                        nuevo.tipo = 3;
                        nuevo.tipo_dato = tipo;
                        nuevo.conservar = true;

                        if (tabla.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                            System.out.println("ya existe");
                        }

                    }

                } else {
                    String tipo = raiz.hijos.get(1).getValor();
                    int index;
                    nodo aux2 = raiz.hijos.get(2);
                    for (index = 0; index < aux2.hijos.size(); index++) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux2.hijos.get(index);
                        nuevo.ambito = ambito;
                        nuevo.id = aux2.hijos.get(index).getValor();
                        nuevo.tipo = 3;//es una variable
                        nuevo.tipo_dato = tipo;
                        if (tabla.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                            System.out.println("ya existe");
                        }
                    }
                }
                break;

            case "DECASIG":
                if (raiz.hijos.size() == 5) {
                    String tipo = raiz.hijos.get(1).getValor();
                    int index;
                    nodo aux2 = raiz.hijos.get(2);
                    for (index = 0; index < aux2.hijos.size(); index++) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux2.hijos.get(index);
                        nuevo.ambito = ambito;
                        nodo v = Ejecutar1(raiz.hijos.get(4), tabla, ambito);;
                        if (v != null & v.getEtiqueta().equalsIgnoreCase(tipo)) {
                            nuevo.valor = v;
                        } else {
                            System.out.println("problema de tipo");//ERROR
                        }

                        if (nuevo.valor != null) {
                            System.out.println(nuevo.valor.getValor());
                        }
                        nuevo.id = aux2.hijos.get(index).getValor();
                        nuevo.tipo = 3;//es una variable
                        nuevo.tipo_dato = tipo;

                        if (tabla.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                            System.out.println("ya existe");
                        }
                    }

                } else if (raiz.hijos.size() == 7) {
                    String tipo = raiz.hijos.get(3).getValor();
                    int index;
                    nodo aux2 = raiz.hijos.get(4);
                    for (index = 0; index < aux2.hijos.size(); index++) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux2.hijos.get(index);
                        nuevo.ambito = ambito;
                        nodo v2 = Ejecutar1(raiz.hijos.get(4), tabla, ambito);
                        if (v2 != null & v2.getEtiqueta().equalsIgnoreCase(tipo)) {
                            nuevo.valor = v2;
                        } else {
                            System.out.println("problema de tipo");//ERROR
                        }
                        nuevo.id = aux2.hijos.get(index).getValor();
                        nuevo.tipo = 3;//es una variable
                        nuevo.tipo_dato = tipo;
                        nuevo.conservar = true;
                        nuevo.visibilidad = visibilidad(raiz.hijos.get(1).getValor());

                        if (tabla.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                        }
                    }

                } else if (raiz.hijos.size() == 6 && Buscar_nodo("AMBITO", raiz) == null) {
                    String tipo = raiz.hijos.get(2).getValor();
                    int index;
                    nodo aux2 = raiz.hijos.get(3);
                    for (index = 0; index < aux2.hijos.size(); index++) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux2.hijos.get(index);
                        nuevo.ambito = ambito;
                        nodo v3 = Ejecutar1(raiz.hijos.get(5), tabla, ambito);
                        if (v3 != null & v3.getEtiqueta().equalsIgnoreCase(tipo)) {
                            nuevo.valor = v3;
                        } else {
                            System.out.println("erro de tipo");//ERROR
                        }
                        nuevo.id = aux2.hijos.get(index).getValor();
                        nuevo.tipo = 3;//es una variable
                        nuevo.tipo_dato = tipo;
                        nuevo.conservar = true;

                        if (tabla.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                            System.out.println("ya existe");
                        }
                        System.out.println(nuevo.id + nuevo.tipo);
                    }
                } else if (raiz.hijos.size() == 6 && Buscar_nodo("CONSERVAR", raiz) == null) {
                    String tipo = raiz.hijos.get(2).getValor();
                    int index;
                    nodo aux2 = raiz.hijos.get(3);
                    for (index = 0; index < aux2.hijos.size(); index++) {
                        Simbolo nuevo = new Simbolo();
                        nuevo.Nodo = (nodo) aux2.hijos.get(index);
                        nuevo.ambito = ambito;
                        nodo v4 = Ejecutar1(raiz.hijos.get(5), tabla, ambito);
                        if (v4 != null & v4.getEtiqueta().equalsIgnoreCase(tipo)) {
                            nuevo.valor = v4;
                        } else {
                            System.out.println("error de tipo");//ERROR
                        }
                        nuevo.id = aux2.hijos.get(index).getValor();
                        nuevo.tipo = 3;//es una variable
                        nuevo.tipo_dato = tipo;
                        nuevo.visibilidad = visibilidad(raiz.hijos.get(0).getValor());

                        if (tabla.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                            System.out.println("ya existe");
                        }
                        System.out.println(nuevo.id + nuevo.tipo);
                    }
                }
                break;

            case "ASIG":
                Simbolo s = tabla.Buscar(raiz.hijos.get(0).getValor() + 3);
                nodo val = Ejecutar1(raiz.hijos.get(2), tabla, ambito);
                if (s != null) {
                    if (s.tipo_dato.equalsIgnoreCase(val.getEtiqueta())) {
                        s.valor = val;
                        if (s.valor != null) {
                            //System.out.println(s.valor.getValor());
                        }
                    } else {
                        System.out.println("problema de tipo");//ERROR
                    }
                } else {
                    System.out.println("no existe el simbolo : ");//ERROR
                }

                break;

            case "SI":

                if ((Ejecutar1(raiz.hijos.get(2), tabla, ambito)) != null) {
                    TablaSimbolo tab_si = new TablaSimbolo();
                    tab_si.tabla_superior = tabla;

                    nodo sentencias_si = raiz.hijos.get(5);

                    for (int i = 0; i < sentencias_si.hijos.size(); i++) {
                        retorno = Ejecutar1(sentencias_si.hijos.get(i), tab_si, ambito + "_si");
                    }
                }

                break;

            case "SINO":
                nodo sino = null;
                if ((sino = Ejecutar1(raiz.hijos.get(2), tabla, ambito)) != null) {

                    TablaSimbolo tab_si = new TablaSimbolo();
                    tab_si.tabla_superior = tabla;

                    if (sino.getValor().equals("true")) {
                        nodo sentencias_si = raiz.hijos.get(5);

                        for (int i = 0; i < sentencias_si.hijos.size(); i++) {
                            retorno = Ejecutar1(sentencias_si.hijos.get(i), tab_si, ambito + "_sino");
                        }

                    } else if (sino.getValor().equals("false")) {
                        nodo sentencias_si = raiz.hijos.get(7);
                        for (int i = 0; i < sentencias_si.hijos.size(); i++) {
                            retorno = Ejecutar1(sentencias_si.hijos.get(i), tab_si, ambito + "_sino");
                        }
                    }
                }
                break;

            case "MIENTRAS":

                nodo a = Ejecutar1(raiz.hijos.get(2), tabla, ambito);

                if (a != null) {
                    while (a.getEtiqueta().equals("BOOLEANO") && a.getValor().equals("true")) {
                        TablaSimbolo tb_while = new TablaSimbolo();
                        tb_while.tabla_superior = tabla;

                        nodo sentencias_while = raiz.hijos.get(5);
                        for (int i = 0; i < sentencias_while.hijos.size(); i++) {
                            retorno = Ejecutar1(sentencias_while.hijos.get(i), tb_while, ambito + "_while");
                        }
                        a = Ejecutar1(raiz.hijos.get(2), tabla, ambito);
                    }
                }

                break;

            case "HACER_MIENTRAS":
                nodo b = Ejecutar1(raiz.hijos.get(6), tabla, ambito);
                if (b != null & b.getEtiqueta().equals("BOOLEANO")) {
                    do {
                        TablaSimbolo mientras = new TablaSimbolo();
                        mientras.tabla_superior = tabla;

                        nodo sentencias_hacer = raiz.hijos.get(2);
                        for (int i = 0; i < sentencias_hacer.hijos.size(); i++) {
                            retorno = Ejecutar1(sentencias_hacer.hijos.get(i), mientras, ambito + "_hacermientras");
                        }
                        b = Ejecutar1(raiz.hijos.get(6), tabla, ambito);
                    } while (b.getValor().equals("true"));
                }
                break;

            case "PARA":
                TablaSimbolo tab_para1 = new TablaSimbolo();
                tab_para1.tabla_superior = tabla;

                Ejecutar1(raiz.hijos.get(0), tab_para1, ambito + "_para");
                nodo bool = Ejecutar1(raiz.hijos.get(1), tab_para1, ambito + "_para");
                Ejecutar1(raiz.hijos.get(2), tab_para1, ambito + "_para");

                if (bool != null) {
                    System.out.println("ejecutando para");
                    while (bool.getEtiqueta().equals("BOOLEANO") && bool.getValor().equals("true")) {
                        nodo sentencias_para = raiz.hijos.get(3);
                        TablaSimbolo tab_para = new TablaSimbolo();
                        tab_para.tabla_superior = tab_para1;

                        for (int i = 0; i < sentencias_para.hijos.size(); i++) {
                            retorno = Ejecutar1(sentencias_para.hijos.get(i), tab_para, ambito + "_para");
                        }

                        Ejecutar1(raiz.hijos.get(2), tab_para1, ambito + "_para");
                        bool = Ejecutar1(raiz.hijos.get(1), tab_para1, ambito + "_para");
                    }
                } else {
                    System.out.println("alguno es nulo");
                }

                break;

            case "DECR":
                nodo dec = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                if (dec != null) {
                    if (dec.getEtiqueta().equals("ENTERO")) {
                        Integer res = Integer.parseInt(dec.getValor()) - 1;
                        dec.setValor(res.toString());
                    } else if (dec.getEtiqueta().equals("DOBLE")) {
                        Double res = Double.parseDouble(dec.getValor()) - 1;
                        dec.setValor(res.toString());
                    } else if (dec.getEtiqueta().equals("CARACTER")) {
                        Character res = dec.getValor().charAt(1);
                        res--;
                        dec.setValor(res.toString());
                    }
                }
                break;

            case "INCR":
                nodo inc = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                if (inc != null) {
                    if (inc.getEtiqueta().equals("ENTERO")) {
                        Integer res = Integer.parseInt(inc.getValor()) + 1;
                        inc.setValor(res.toString());
                    } else if (inc.getEtiqueta().equals("DOBLE")) {
                        Double res = Double.parseDouble(inc.getValor()) + 1;
                        inc.setValor(res.toString());
                    } else if (inc.getEtiqueta().equals("CARACTER")) {
                        Character res = inc.getValor().charAt(1);
                        res++;
                        inc.setValor(res.toString());
                    }
                }
                break;

            case "MASIGUAL":
                nodo mas1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo mas2 = Ejecutar1(raiz.hijos.get(1), tabla, ambito);

                if (mas1 != null && mas2 != null) {
                    //ENTERO += ENTERO
                    if (mas1.getEtiqueta().equals("ENTERO") && mas2.getEtiqueta().equals("ENTERO")) {
                        Integer res = Integer.parseInt(mas1.getValor()) + Integer.parseInt(mas2.getValor());
                        System.out.println("res " + res);
                        mas1.setValor(res.toString());
                    }//ENTERO += DOBLE
                    else if (mas1.getEtiqueta().equals("ENTERO") && mas2.getEtiqueta().equals("DOBLE")) {
                        Integer res = Integer.parseInt(mas1.getValor()) + (int) Double.parseDouble(mas2.getValor());
                        mas1.setValor(res.toString());
                    }//ENTERO += CARACTER
                    else if (mas1.getEtiqueta().equals("ENTERO") && mas2.getEtiqueta().equals("CARACTER")) {
                        char c;
                        switch (mas2.getValor().charAt(2)) {
                            case 'n':
                                c = '\n';
                                break;
                            case 't':
                                c = '\t';
                                break;
                            case '^':
                                c = '^';
                                break;
                            default:
                                c = mas2.getValor().charAt(1);
                                break;
                        }

                        Integer res = Integer.parseInt(mas1.getValor()) + c;
                        mas1.setValor(res.toString());
                    }//DOBLE += DOBLE
                    else if (mas1.getEtiqueta().equals("DOBLE") && mas2.getEtiqueta().equals("DOBLE")) {
                        Double res = Double.parseDouble(mas1.getValor()) + Double.parseDouble(mas2.getValor());
                        mas1.setValor(res.toString());
                    }//DOBLE += ENTERO
                    else if (mas1.getEtiqueta().equals("DOBLE") && mas2.getEtiqueta().equals("ENTERO")) {
                        Double res = Double.parseDouble(mas1.getValor()) + Double.parseDouble(mas2.getValor());
                        mas1.setValor(res.toString());
                    }//DOBLE += CARACTER
                    else if (mas1.getEtiqueta().equals("DOBLE") && mas2.getEtiqueta().equals("CARACTER")) {
                        char c;
                        switch (mas2.getValor().charAt(2)) {
                            case 'n':
                                c = '\n';
                                break;
                            case 't':
                                c = '\t';
                                break;
                            case '^':
                                c = '^';
                                break;
                            default:
                                c = mas2.getValor().charAt(1);
                                break;
                        }

                        Double res = Double.parseDouble(mas1.getValor()) + c;
                        mas1.setValor(res.toString());
                    }//CADENA += ENTERO || CADENA += DOBLE || CADENA += CADENA
                    else if (mas1.getEtiqueta().equals("CADENA") && mas2.getEtiqueta().equals("ENTERO") || mas1.getEtiqueta().equals("CADENA") && mas2.getEtiqueta().equals("DOBLE") || mas1.getEtiqueta().equals("CADENA") && mas2.getEtiqueta().equals("CADENA")) {
                        mas1.setValor(mas1.getValor() + mas2.getValor());
                    } else if (mas1.getEtiqueta().equals("CADENA") && mas2.getEtiqueta().equals("CARACTER")) {
                        char c;
                        switch (mas2.getValor().charAt(2)) {
                            case 'n':
                                c = '\n';
                                break;
                            case 't':
                                c = '\t';
                                break;
                            case '^':
                                c = '^';
                                break;
                            default:
                                c = mas2.getValor().charAt(1);
                                break;
                        }

                        mas1.setValor(mas1.getValor() + c);
                    }
                }

                break;

            case "MENOSIGUAL":
                nodo men1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo men2 = Ejecutar1(raiz.hijos.get(1), tabla, ambito);

                if (men1 != null && men2 != null) {
                    //ENTERO -= ENTERO
                    if (men1.getEtiqueta().equals("ENTERO") && men2.getEtiqueta().equals("ENTERO")) {
                        Integer res = Integer.parseInt(men1.getValor()) - Integer.parseInt(men2.getValor());
                        men1.setValor(res.toString());
                    }//CADENA -= ENTERO
                    else if (men1.getEtiqueta().equals("CADENA") && men2.getEtiqueta().equals("ENTERO")) {
                        String sub = men1.getValor();
                        sub = men1.getValor().substring(0, sub.length() - 1 - Integer.parseInt(men2.getValor()));
                        men1.setValor(sub);
                    }//ENTERO -= DOBLE
                    else if (men1.getEtiqueta().equals("ENTERO") && men2.getEtiqueta().equals("DOBLE")) {
                        Integer res = Integer.parseInt(ambito) - (int) Double.parseDouble(men2.getValor());
                        men1.setValor(res.toString());
                    }
                }

                break;

            case "COMPROBAR":

                TablaSimbolo comp = new TablaSimbolo();
                comp.tabla_superior = tabla;

                nodo el = Ejecutar1(raiz.hijos.get(1), comp, ambito + "_comp");
                if (el != null) {
                    nodo lista_casos = raiz.hijos.get(3);
                    boolean defecto = false;
                    for (int i = 0; i < lista_casos.hijos.size(); i++) {
                        nodo caso = Ejecutar1(lista_casos.hijos.get(i).hijos.get(1), tabla, ambito);
                        if (caso != null) {
                            if (caso.getEtiqueta().equals(el.getEtiqueta()) && caso.getValor().equals(el.getValor())) {
                                nodo sentencias_caso = lista_casos.hijos.get(i).hijos.get(2);
                                defecto = true;
                                for (int y = 0; y < sentencias_caso.hijos.size(); y++) {
                                    retorno = Ejecutar1(sentencias_caso.hijos.get(y), comp, ambito + "_comp");
                                }

                                // EN CASO DE QUE VENGA LA PALABRA RESERVADA SALIR
                                if (lista_casos.hijos.get(i).hijos.size() == 3) {
                                    for (int k = i + 1; k < lista_casos.hijos.size(); k++) {
                                        nodo sentencias_otros = lista_casos.hijos.get(k).hijos.get(2);
                                        for (int jj = 0; jj < sentencias_otros.hijos.size(); jj++) {
                                            retorno = Ejecutar1(sentencias_otros.hijos.get(jj), comp, ambito + "_comp");
                                        }
                                        i++;
                                    }
                                }

                            }

                            //EN CASO DE QUE HAYA DEFAULT Y NO HAYA COINCIDENCIA
                            if (raiz.hijos.size() == 6 && defecto == false) {
                                nodo sentencias_default = raiz.hijos.get(4).hijos.get(0);
                                for (int h = 0; h < sentencias_default.hijos.size(); h++) {
                                    retorno = Ejecutar1(sentencias_default.hijos.get(h), comp, ambito + "_comp");
                                }
                            }
                        } else {
                            //ERROR ES NULO
                        }
                    }

                }

                break;

            case "RETORNO":
                retorno = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                System.out.println("retorno : " + retorno.getValor());
                break;

            case "LLAMADO":

                //LLAMADO SIN PARAMETROS
                if (raiz.hijos.size() == 1) {
                    String llave = raiz.hijos.get(0).getValor();
                    Simbolo f = tabla.Buscar(llave);
                    if (f != null) {

                        nodo sentencias_fm = f.Sentencias;
                        TablaSimbolo fm = new TablaSimbolo();
                        fm.tabla_superior = tabla;
                        for (int i = 0; i < sentencias_fm.hijos.size(); i++) {
                            retorno = Ejecutar1(sentencias_fm.hijos.get(i), fm, f.id);
                            if (retorno != null & f.tipo == 1) {
                                break;
                            } else {
                                retorno = null;
                            }
                        }

                    } else {
                        System.out.println("no se encontro funcion/metodo");//ERROR
                    }
                } //LLAMADO CON PARAMETROS
                else if (raiz.hijos.size() == 2) {
                    ArrayList<nodo> lp = new ArrayList<>();
                    nodo parametros = raiz.hijos.get(1);
                    String llave = raiz.hijos.get(0).getValor();

                    for (int i = 0; i < parametros.hijos.size(); i++) {
                        nodo param = Ejecutar1(parametros.hijos.get(i), tabla, ambito);
                        if (param != null) {
                            lp.add(param);
                            llave += param.getEtiqueta();
                        }
                    }

                    Simbolo funcion = tabla.Buscar(llave.toLowerCase());
                    if (funcion != null) {

                        TablaSimbolo tabla_fun = new TablaSimbolo();
                        tabla_fun.tabla_superior = tabla;
                        nodo lista_param = (nodo) funcion.Param;
                        System.out.println(funcion.Param.getEtiqueta());

                        for (int i = 0; i < lista_param.hijos.size(); i++) {
                            nodo hijo = (nodo) lista_param.hijos.get(i);
                            Simbolo parametro = new Simbolo();
                            parametro.Nodo = (nodo) hijo;
                            parametro.ambito = funcion.id;
                            parametro.id = hijo.hijos.get(1).getValor();
                            parametro.tipo_dato = hijo.hijos.get(0).getValor();
                            parametro.tipo = 4;
                            parametro.valor = (nodo) lp.get(i);
                            System.out.println("valor: " + parametro.valor.getValor());
                            tabla_fun.Insertar(parametro.id + 3, parametro);
                            System.out.println("imp");
                            ImprimirHash(tabla_fun);
                            System.out.println("fin imp");
                        }

                        nodo sentencias_fm = (nodo) funcion.Sentencias;
                        System.out.println(sentencias_fm.getEtiqueta());
                        for (int i = 0; i < sentencias_fm.hijos.size(); i++) {
                            System.out.println(sentencias_fm.hijos.get(i).getEtiqueta());
                            retorno = Ejecutar1(sentencias_fm.hijos.get(i), tabla_fun, funcion.id);
                            if (retorno != null & funcion.tipo == 1) {
                                break;
                            } else {
                                retorno = null;
                            }
                        }

                    } else {
                        System.out.println("no se hallo funcion/metodo:");//ERROR
                    }

                }

                break;

            case "DECARRAY"://DECLARACIÓN DE ARREGLOS
                String tipo = Buscar_nodo("TIPO", raiz).getValor();
                nodo dimen = Buscar_nodo("DIMENSIONES", raiz);
                int dimensiones = dimen.hijos.size();
                int lim[] = new int[dimensiones];
                int tamano = 1;
                for (int i = 0; i < dimensiones; i++) {
                    nodo node = Ejecutar1(dimen.hijos.get(i).hijos.get(1), tabla, ambito);
                    if (node.getEtiqueta().equals("ENTERO") || node.getEtiqueta().equals("DOBLE")) {
                        int h = (int) Double.parseDouble(node.getValor());
                        lim[i] = h;
                        tamano *= h;
                    }
                }

                int vis = -1;
                boolean con = (Buscar_nodo("CONSERVAR", raiz) != null);
                nodo v = Buscar_nodo("AMBITO", raiz);
                if (v != null) {
                    vis = visibilidad(v.getValor());
                }

                nodo lista_ids = Buscar_nodo("ListaIds", raiz);
                for (int y = 0; y < lista_ids.hijos.size(); y++) {
                    Simbolo array = new Simbolo();
                    array.ambito = ambito;
                    array.conservar = con;
                    array.id = lista_ids.hijos.get(y).getValor();
                    array.tipo = 5;
                    array.tipo_dato = tipo;
                    array.dimensiones = dimensiones;
                    array.lista = new nodo[tamano];
                    array.limites = lim;

                    for (int h = 0; h < array.lista.length; h++) {
                        array.lista[h] = new nodo();
                        array.lista[h].setEtiqueta(tipo.toUpperCase());
                    }

                    if (tabla.Insertar(array.id + 4, array) == null) {
                        System.out.println("array : " + array.id + " " + array.dimensiones + " " + array.lista.length);
                    } else {
                        System.out.println("ya existe arreglo");//ERROR
                    }

                }

                break;

            case "ASIGARRAY":

                nodo pos = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo valor = Ejecutar1(raiz.hijos.get(2), tabla, ambito);
//                System.out.println(pos.getEtiqueta());

                if (pos != null && valor != null) {
                    if (pos.getEtiqueta().equals(valor.getEtiqueta())) {
                        pos.setValor(valor.getValor());
                        System.out.println("valor : " + pos.getValor());
                    } else {
                        System.out.println("error de tipo");//ERROR DE TIPOS
                    }
                } else {
                    System.out.println("es nulo algun nodo");//ERROR
                }

                break;

            case "POSARRAY":
                String llave = raiz.hijos.get(1).getValor() + 4;
                System.out.println(llave);

                Simbolo arreglo = tabla.Buscar(llave);

                if (arreglo != null) {
                    nodo dimensiones_acceso = raiz.hijos.get(0);
                    int acceso[] = new int[dimensiones_acceso.hijos.size()];

                    if (arreglo.limites.length == acceso.length) {
                        for (int index = 0; index < acceso.length; index++) {
                            nodo d = Ejecutar1(dimensiones_acceso.hijos.get(index).hijos.get(1), tabla, ambito);
                            if (d != null & (d.getEtiqueta().equals("ENTERO") || d.getEtiqueta().equals("DOBLE"))) {
                                acceso[index] = (int) Double.parseDouble(d.getValor());
                                System.out.println("d:" + d.getValor());
                            }
                        }

                        int t = 0;
                        for (int x = 0; x < acceso.length; x++) {
                            int temp = acceso[x];
                            for (int y = x + 1; y < acceso.length; y++) {
                                temp *= arreglo.limites[y];
                            }
                            t += temp;
                        }

                        if (t < arreglo.lista.length) {
                            retorno = arreglo.lista[t];
                            System.out.println("t: " + t);
                        }

                    } else {
                        System.out.println("error de dimensiones");//ERROR
                    }

                } else {
                    System.out.println("no existe el arreglo");//ERROR
                }

                break;

            case "PP":
                nodo param1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo param2 = Ejecutar1(raiz.hijos.get(1), tabla, ambito);
                nodo param3 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);
                nodo param4 = Ejecutar1(raiz.hijos.get(3), tabla, ambito);

                if (param1 != null && param2 != null && param3 != null && param4 != null) {
                    System.out.println(param1.getEtiqueta());
                    System.out.println(param2.getEtiqueta());
                    System.out.println(param3.getValor());
                    System.out.println(param4.getEtiqueta());
                    System.out.println("pintando punto");
                    if (param1.getEtiqueta().equalsIgnoreCase("ENTERO") && param2.getEtiqueta().equalsIgnoreCase("ENTERO") && param3.getEtiqueta().equalsIgnoreCase("CADENA") && param4.getEtiqueta().equalsIgnoreCase("ENTERO")) {
                        Dibujo punto = new Dibujo();
                        punto.setTipo_dibujo(1);
                        punto.setX(Integer.parseInt(param1.getValor()));
                        punto.setY(Integer.parseInt(param2.getValor()));
                        punto.setColor(param3.getValor());
                        punto.setDiametro(Integer.parseInt(param4.getValor()));
                        Lienzo.lista_dib.add(punto);
                        Lienzo.jPanel2.repaint();
                    } else {
                        System.out.println("Error de tipo");//ERROR
                    }
                } else {
                    System.out.println("parametro nulo pp");//ERROR
                }

                break;

            case "PS":

                nodo paramS1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo paramS2 = Ejecutar1(raiz.hijos.get(1), tabla, ambito);
                nodo paramS3 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);
                nodo paramS4 = Ejecutar1(raiz.hijos.get(3), tabla, ambito);

                if (paramS1 != null && paramS2 != null && paramS3 != null && paramS4 != null) {

                    if (paramS1.getEtiqueta().equalsIgnoreCase("ENTERO") && paramS2.getEtiqueta().equalsIgnoreCase("ENTERO") && paramS3.getEtiqueta().equalsIgnoreCase("CADENA") && paramS4.getEtiqueta().equalsIgnoreCase("CADENA")) {
                        Dibujo Cadena = new Dibujo();
                        Cadena.setTipo_dibujo(2);
                        Cadena.setX(Integer.parseInt(paramS1.getValor()));
                        Cadena.setY(Integer.parseInt(paramS2.getValor()));
                        Cadena.setColor(paramS3.getValor());
                        Cadena.setCadena(paramS4.getValor());
                        Lienzo.lista_dib.add(Cadena);
                        Lienzo.jPanel2.repaint();
                    } else {
                        System.out.println("Error de tipo");//ERROR
                    }
                } else {
                    System.out.println("parametro nulo pp");//ERROR
                }

                break;

            case "POR":

                nodo paramO1 = Ejecutar1(raiz.hijos.get(0), tabla, ambito);
                nodo paramO2 = Ejecutar1(raiz.hijos.get(1), tabla, ambito);
                nodo paramO3 = Ejecutar1(raiz.hijos.get(2), tabla, ambito);
                nodo paramO4 = Ejecutar1(raiz.hijos.get(3), tabla, ambito);
                nodo paramO5 = Ejecutar1(raiz.hijos.get(4), tabla, ambito);
                nodo paramO6 = Ejecutar1(raiz.hijos.get(5), tabla, ambito);

                if (paramO1 != null && paramO2 != null && paramO3 != null && paramO4 != null && paramO5 != null && paramO6 != null) {
                    if (paramO1.getEtiqueta().equalsIgnoreCase("ENTERO") && paramO2.getEtiqueta().equalsIgnoreCase("ENTERO") && paramO3.getEtiqueta().equalsIgnoreCase("CADENA") && paramO4.getEtiqueta().equalsIgnoreCase("ENTERO") && paramO5.getEtiqueta().equalsIgnoreCase("ENTERO") && paramO6.getEtiqueta().equalsIgnoreCase("CARACTER")) {
                        Dibujo ovalo_rec = new Dibujo();
                        if (paramO6.getValor().equals("'o'")) {
                            ovalo_rec.setTipo_dibujo(3);
                        } else if (paramO6.getValor().equals("'r'")) {
                            ovalo_rec.setTipo_dibujo(4);
                        }
                        ovalo_rec.setX(Integer.parseInt(paramO1.getValor()));
                        ovalo_rec.setY(Integer.parseInt(paramO2.getValor()));
                        ovalo_rec.setColor(paramO3.getValor());
                        ovalo_rec.setAncho(Integer.parseInt(paramO5.getValor()));
                        ovalo_rec.setLargo(Integer.parseInt(paramO4.getValor()));
                        Lienzo.lista_dib.add(ovalo_rec);
                        Lienzo.jPanel2.repaint();

                    } else {
                        System.out.println("ERROR DE TIPO OR");//ERROR
                    }
                } else {
                    System.out.println("parametro nulo OR");//ERROR
                }

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
            //Recolectar_General(raiz);
            return envio;
        } else {
            return null;
        }

    }

    TablaSimbolo Recolectar_General(nodo raiz, String ambito) throws InterruptedException {
        nodo aux;
        TablaSimbolo tb = new TablaSimbolo();
        for (int x = 0; x < raiz.hijos.size(); x++) {
            aux = raiz.hijos.get(x);
            switch (aux.getEtiqueta()) {

                //FUNCION
                case "FUNCION":

                    Simbolo funcion = new Simbolo();
                    funcion.ambito = ambito;
                    funcion.Nodo = (nodo) aux;
                    funcion.id = Buscar_nodo("IDENTIFICADOR", aux).getValor();
                    funcion.tipo = 1;
                    funcion.conservar = Buscar_nodo("CONSERVAR", aux) != null;
                    funcion.Sentencias = Buscar_nodo("ListaSentencias2", aux);
                    funcion.tipo_dato = Buscar_nodo("TIPO", aux).getValor();

                    nodo bf = Buscar_nodo("AMBITO", aux);
                    if (bf != null) {
                        funcion.visibilidad = visibilidad(bf.getValor());
                    }

                    String tipo_paramf = "";
                    funcion.Param = Buscar_nodo("LISTAPARAM", aux);
                    if (funcion.Param != null) {
                        for (int y = 0; y < funcion.Param.hijos.size(); y++) {
                            tipo_paramf += funcion.Param.hijos.get(y).hijos.get(0).getValor();
                        }

                    }

                    if (tb.Insertar(funcion.id + tipo_paramf, funcion) != null) {
                        System.out.println("ya existe");
                    }
                    break;

                //METODOS
                case "PROCEDIMIENTO":

                    Simbolo proce = new Simbolo();
                    proce.ambito = ambito;
                    proce.Nodo = (nodo) aux;
                    proce.id = Buscar_nodo("IDENTIFICADOR", aux).getValor();
                    proce.tipo_dato = "void";
                    proce.tipo = 2;
                    proce.conservar = Buscar_nodo("CONSERVAR", aux) != null;
                    proce.Sentencias = Buscar_nodo("ListaSentencias2", aux);

                    nodo b = Buscar_nodo("AMBITO", aux);
                    if (b != null) {
                        proce.visibilidad = visibilidad(b.getValor());
                    }

                    String tipo_param = "";
                    proce.Param = Buscar_nodo("LISTAPARAM", aux);
                    if (proce.Param != null) {
                        for (int y = 0; y < proce.Param.hijos.size(); y++) {
                            tipo_param += proce.Param.hijos.get(y).hijos.get(0).getValor();
                        }

                    }

                    if (tb.Insertar(proce.id + tipo_param, proce) != null) {
                        System.out.println("ya existe");
                    }
                    break;

                //DECLARACION DE VARIABLES
                case "DEC":
                    if (aux.hijos.size() == 4 && Buscar_nodo("AMBITO", aux) == null) {
                        String tipo = aux.hijos.get(2).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(3);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = ambito;
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;
                            nuevo.tipo_dato = tipo;
                            nuevo.conservar = true;

                            if (tb.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                                System.out.println("ya existe");
                            }

                        }

                    } else if (aux.hijos.size() == 4 && Buscar_nodo("CONSERVAR", aux) == null) {
                        String tipo = aux.hijos.get(2).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(3);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = ambito;
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;
                            nuevo.visibilidad = visibilidad(aux.hijos.get(0).getValor());
                            nuevo.tipo_dato = tipo;

                            if (tb.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                                System.out.println("ya existe");
                            }

                        }

                    } else if (aux.hijos.size() == 5) {
                        String tipo = aux.hijos.get(3).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(4);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = ambito;
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;
                            nuevo.tipo_dato = tipo;
                            nuevo.conservar = true;

                            if (tb.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
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
                            nuevo.ambito = ambito;
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;//es una variable
                            nuevo.tipo_dato = tipo;
                            if (tb.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                                System.out.println("ya existe");
                            }
                        }
                    }
                    break;
                //CASO DE DECLARACION CON ASIGNACION
                case "DECASIG":
                    if (aux.hijos.size() == 5) {
                        String tipo = aux.hijos.get(1).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(2);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = ambito;
                            nuevo.valor = aux.hijos.get(4);
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;//es una variable
                            nuevo.tipo_dato = tipo;

                            if (tb.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                                System.out.println("ya existe");
                            }
                        }

                    } else if (aux.hijos.size() == 7) {
                        String tipo = aux.hijos.get(3).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(4);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = ambito;
                            nuevo.valor = aux.hijos.get(4);
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;//es una variable
                            nuevo.tipo_dato = tipo;
                            nuevo.conservar = true;
                            nuevo.visibilidad = visibilidad(aux.hijos.get(1).getValor());

                            if (tb.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                                System.out.println("ya existe");
                            }
                        }

                    } else if (aux.hijos.size() == 6 && Buscar_nodo("AMBITO", aux) == null) {
                        String tipo = aux.hijos.get(2).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(3);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = ambito;
                            nuevo.valor = aux.hijos.get(5);
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;//es una variable
                            nuevo.tipo_dato = tipo;
                            nuevo.conservar = true;

                            if (tb.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                                System.out.println("ya existe");
                            }
                        }
                    } else if (aux.hijos.size() == 6 && Buscar_nodo("CONSERVAR", aux) == null) {
                        String tipo = aux.hijos.get(2).getValor();
                        int index;
                        nodo aux2 = aux.hijos.get(3);
                        for (index = 0; index < aux2.hijos.size(); index++) {
                            Simbolo nuevo = new Simbolo();
                            nuevo.Nodo = (nodo) aux2.hijos.get(index);
                            nuevo.ambito = ambito;
                            nuevo.valor = aux.hijos.get(5);
                            nuevo.id = aux2.hijos.get(index).getValor();
                            nuevo.tipo = 3;//es una variable
                            nuevo.tipo_dato = tipo;
                            nuevo.visibilidad = visibilidad(aux.hijos.get(0).getValor());

                            if (tb.Insertar(nuevo.id + nuevo.tipo, nuevo) != null) {
                                System.out.println("ya existe");
                            }
                        }
                    }
                    break;

                case "ASIG":
                    Simbolo s = tb.Buscar(aux.hijos.get(0).getValor() + 3);
                    if (s != null) {
                        s.valor = aux.hijos.get(2);
                    } else {
                        System.out.println("no existe la variable");
                    }
                    break;
            }
        }

        //System.out.println("imprimiendo: ");
        //ImprimirHash(tb);
        Inicializacion(raiz, tb, ambito);
        return tb;
    }

    void Inicializacion(nodo raiz, TablaSimbolo hash, String ambito) throws InterruptedException {
        nodo aux;
        for (int i = 0; i < raiz.hijos.size(); i++) {
            aux = raiz.hijos.get(i);
            switch (aux.getEtiqueta()) {
                case "DECASIG":
                    if (aux.hijos.size() == 5) {
                        for (int index = 0; index < aux.hijos.get(2).hijos.size(); index++) {
                            Simbolo s = hash.Buscar(aux.hijos.get(2).hijos.get(0).getValor() + 3);
                            if (s != null) {
                                nodo valor = Ejecutar1(aux.hijos.get(4), hash, ambito);
                                if (valor != null) {
                                    if (valor.getEtiqueta().equalsIgnoreCase(s.tipo_dato)) {
                                        s.valor = valor;
                                        //System.out.println(s.valor.getValor());
                                    }
                                }
                            } else {
                                System.out.println("simolo no encontrado: " + aux.hijos.get(2));
                            }
                        }
                    } else {
                        for (int index = 0; index < aux.hijos.get(3).hijos.size(); index++) {
                            Simbolo s = hash.Buscar(aux.hijos.get(3).hijos.get(0).getValor() + 3);
                            if (s != null) {
                                nodo valor = Ejecutar1(aux.hijos.get(5), hash, ambito);
                                if (valor != null) {
                                    if (valor.getEtiqueta().equalsIgnoreCase(s.tipo_dato)) {
                                        s.valor = valor;
                                        //System.out.println(s.valor.getValor());
                                    } else {
                                        System.out.println("no coincide el tipo");//ERROR
                                    }
                                } else {
                                    System.out.println("no se ha inicilazado la variable");//ERROR
                                }
                            } else {
                                System.out.println("simbolo nulo " + aux.hijos.get(3).hijos.get(0).getValor() + 3);//ERROR
                            }
                        }
                    }
                    break;

                case "ASIG":
                    Simbolo s = hash.Buscar(aux.hijos.get(0).getValor() + 3);
                    if (s != null) {
                        s.valor = Ejecutar1(aux.hijos.get(2), hash, ambito);
                        if (s.valor != null) {
                            //System.out.println(s.valor.getValor());
                        }
                    } else {
                        System.out.println("no existe el simbolo : ");//ERROR
                    }

                    break;
            }
        }
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

    void ImprimirHash(TablaSimbolo tb) {
        Enumeration e = tb.tabla.elements();
        Simbolo clave;
        while (e.hasMoreElements()) {
            clave = (Simbolo) e.nextElement();
            System.out.println("Clave : " + clave.id);
        }
    }

    public int visibilidad(String ambito) {
        if (ambito.equals("publico")) {
            return 1;
        } else if (ambito.equals("privado")) {
            return 2;
        } else {
            return 3;
        }
    }

    void Compilar(String texto, Lienzo lienzo) throws IOException, InterruptedException {
        try {
            this.Lista_errores = new ArrayList<>();
            TablaSimbolo.reporte.clear();
            Lienzo.jPanel2.removeAll();
            Lienzo.jPanel2.repaint();
            Lienzo.lista_dib.clear();
            Lienzo.jPanel2.setForeground(Color.WHITE);
            nodo raiz = generar_arbol(texto);
            if (raiz != null) {
                this.lienzo = lienzo;
                nodo aux2 = raiz.hijos.get(0).hijos.get(raiz.hijos.get(0).hijos.size() - 1);
                nodo n = null;
                TablaSimbolo tb = null;
                String ambito = Buscar_nodo("IDENTIFICADOR", raiz.hijos.get(0)).getValor();
                if (aux2.hijos.size() == 3) {
                    n = Busqueda_main(aux2.hijos.get(1));
                    tb = Recolectar_General(aux2.hijos.get(1), ambito);
                }//EN CASO DE QUE HAYA HERENCIA
                else {

                    tb = Recolectar_General(aux2.hijos.get(3), ambito);
                    n = Busqueda_main(aux2.hijos.get(3));

                    //INCIA LA COMPILACION DE LAS OTRAS CLASES
                    nodo lista_clases = raiz.hijos.get(0).hijos.get(2).hijos.get(1);
                    for (int k = 0; k < lista_clases.hijos.size(); k++) {
                        //System.out.println(lista_clases.hijos.get(k).getValor());
                        File f = new File("Clases/" + lista_clases.hijos.get(k).getValor() + ".lz");
                        FileReader file = new FileReader(f);
                        String txt = "";
                        try (BufferedReader buffer = new BufferedReader(file)) {
                            String aux;
                            while ((aux = buffer.readLine()) != null) {
                                txt += aux + "\n";
                            }

                            nodo herencia = generar_arbol(txt);
                            nodo aux3 = herencia.hijos.get(0).hijos.get(raiz.hijos.get(0).hijos.size() - 1);
                            aux3 = Buscar_nodo("ListaSentencias", aux3);
                            String ambitoH = Buscar_nodo("IDENTIFICADOR", herencia.hijos.get(0)).getValor();
                            TablaSimbolo h = Recolectar_General(aux3, ambitoH);
                            tb.Heredar(h);

                        }
                    }
                }

                if (tb != null && n != null) {
                    Simbolo s = new Simbolo();
                    s.id = "Principal";
                    s.Sentencias = n.hijos.get(0);
                    s.ambito = ambito;
                    s.tabla_interna = new TablaSimbolo();
                    s.tabla_interna.tabla_superior = tb;

                    for (int i = 0; i < s.Sentencias.hijos.size(); i++) {
                        nodo n2 = Ejecutar1(s.Sentencias.hijos.get(i), s.tabla_interna, s.ambito);
                        //System.out.println(s.Sentencias.hijos.get(i).getEtiqueta());
                    }
                }
            }

            TablaSimbolo.GenerarReport();

        } catch (ParseException | TokenMgrError ex) {
            Lista_errores.add(ex.toString());
            ReporteErrores();
        }
    }

    nodo generar_arbol(String texto) throws ParseException {

        nodo raiz = null;
        Analizador_Lienzo analizador = new Analizador_Lienzo(new StringReader(texto));
        raiz = analizador.INICIO();
        //Graficar(recorrido(raiz, 0), "MiAST"); //Es necesario tener instalado graphviz para llamar al metodo
        return raiz;
    }

    int aux = 1;//se usa en la gráfica del árbol

    int incremento() {
        return aux++;
    }

    String recorrido(nodo raiz, int id) {//recorrido para graficar el arbol
        int var;
        String cuerpo = "";

        for (nodo hijos : raiz.hijos) {
            var = incremento();
            if (hijos.getEtiqueta().equals("numero")) {
                cuerpo += "\"" + id + "_" + raiz.getEtiqueta() + "\"->\"" + var + "_" + hijos.getEtiqueta() + "=" + hijos.getValor() + "\"";
            } else {
                cuerpo += "\"" + id + "_" + raiz.getEtiqueta() + "_" + raiz.getValor() + "\"->\"" + var + "_" + hijos.getEtiqueta() + "_" + hijos.getValor() + "\"";
            }
            cuerpo += recorrido(hijos, var);
        }
        return cuerpo;
    }

    public void Graficar(String cadena, String cad) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        String nombre = cad;
        String archivo = nombre + ".dot";
        try {
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            pw.println("digraph G {node[shape=box, style=filled, color=Gray95]; edge[color=blue];rankdir=UD \n");
            pw.println(cadena);
            pw.println("\n}");
            fichero.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            String cmd = "dot -Tpng " + nombre + ".dot -o AST.png"; //Comando de apagado en linux
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void ReporteErrores() throws IOException {
        String table = "<tr><td>MENSAJE</td><td>TIPO</td><td>FILA</td><td>COLUMNA</td></tr>";
        java.util.Date fecha = new Date();
        String d = "<p>generado: " + fecha + "</p>";

        for (String n : Lista_errores) {
            String h[] = n.split(";;;;");
            String tipo = "";

            if ("1".equals(h[1])) {
                tipo = "Error Sintactico";
            } else if ("2".equals(h[1])) {
                tipo = "Error Lexico";
            } else if ("3".equals(h[1])) {
                tipo = "Error Semantico";
            }

            table += "<tr>" + "<td>" + h[0] + "</td><td>" + tipo + "</td><td>" + h[2] + "</td><td>" + h[3] + "</td><tr>";
        }

        String html = "<html><body><h1>ERRORES ENCONTRADO</h1>" + d + ""
                + "<table border = 3> " + table + "</table></body></html>";

        File file = new File("Reporte_errores.html");

        if (file != null) {
            try (FileWriter archivo = new FileWriter(file)) {
                archivo.write(html);
            }
        }
    }
}
