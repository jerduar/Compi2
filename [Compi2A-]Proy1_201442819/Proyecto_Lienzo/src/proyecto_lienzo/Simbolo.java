/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_lienzo;

import AnalizadorCC.nodo;

/**
 * id de Tipo funcion = 1 metodo = 2 variable = 3
 */
/**
 *
 * @author jerduar
 */
public class Simbolo {

    int rol = -1;
    String ambito = null;
    int tipo = -1;
    String id = null;
    nodo Nodo = null;
    nodo Param = null;
    nodo Sentencias = null;
    String tipo_dato = "";
    boolean conservar = false;
    nodo valor = null;
    int visibilidad = 1;
    nodo retorno = null;
    TablaSimbolo tabla_interna;
    nodo lista[] = null;
    int dimensiones = -1;
    int limites[];

    public Simbolo() {
        this.tabla_interna = null;
    }

    /**
     * @return the rol
     */
    public int getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

    /**
     * @return the ambito
     */
    public String getAmbito() {
        return ambito;
    }

    /**
     * @param ambito the ambito to set
     */
    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
