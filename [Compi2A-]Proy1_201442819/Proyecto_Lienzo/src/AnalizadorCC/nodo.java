/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorCC;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
 
public class nodo {
    String Etiqueta;
    public ArrayList<nodo> hijos = new ArrayList<nodo>();
    String valor;
    int Linea;
    int Columna;

    public void AddHijos(nodo hijo){
        hijos.add(hijo);
    }
    
    public void AddHijos(String Etiqueta){
        nodo nuevo = new nodo();
        nuevo.setEtiqueta(Etiqueta);
        this.AddHijos(nuevo);
    }
    
    public void AddHijos(String Etiqueta, String valor){
        nodo nuevo = new nodo();
        nuevo.setEtiqueta(Etiqueta);
        nuevo.setValor(valor);
        this.AddHijos(nuevo);
    }
    
    public void AddHijos(String Etiqueta, String valor, int fila, int columna){
        nodo nuevo = new nodo();
        nuevo.setEtiqueta(Etiqueta);
        nuevo.setValor(valor);
        nuevo.setLinea(fila);
        nuevo.setColumna(columna);
        this.AddHijos(nuevo);
    }

    public void setEtiqueta(String Etiqueta) {
        this.Etiqueta = Etiqueta;
    }

    public String getEtiqueta() {
        return Etiqueta;
    }

    public ArrayList<nodo> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<nodo> hijos) {
        this.hijos = hijos;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public void setLinea(int valor) {
        this.Linea = valor;
    }

    public int getLinea() {
        return Linea;
    }

    public void setColumna(int valor) {
        this.Columna = valor;
    }

    public int getColumna() {
        return Columna;
    }


}
