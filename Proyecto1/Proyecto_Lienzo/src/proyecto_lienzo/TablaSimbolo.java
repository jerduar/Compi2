/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_lienzo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

/**
 *
 * @author jerduar
 */
public class TablaSimbolo {

    Hashtable<String, Simbolo> tabla;
    TablaSimbolo tabla_superior, siguente;
    public static ArrayList<String> reporte = new ArrayList<>();

    public TablaSimbolo() {
        this.tabla = new Hashtable<>();
        this.tabla_superior = null;
        this.siguente = null;
    }

    Simbolo Buscar(String llave) {
        Simbolo s = null;

        /*if (s == null && this.tabla_superior != null) {
            return this.tabla_superior.Buscar(llave);
        } else {
            return s;
        }*/
        s = this.tabla.get(llave);
        if (s == null && this.tabla_superior != null) {
            s = this.tabla_superior.Buscar(llave);
        }

        if (s == null) {
            s = BuscarHerencia(llave);
            //System.out.println("buscado h");
        }

        return s;

    }

    Simbolo BuscarHerencia(String llave) {

        if (this.siguente != null) {
            Simbolo s = this.siguente.Buscar(llave);

            if (s != null) {
                if(s.visibilidad == 1 || s.visibilidad == 3)return s;
                return null;
            }else{
                return null;
            }
        } else {
            return null;
        }

    }

    Simbolo Insertar(String llave, Simbolo s) {
        Simbolo simb = this.tabla.put(llave, s);
        System.out.println("llave: "+llave);
        if (simb == null) {
            String tip = "";
            switch (s.tipo) {
                case 1:
                    tip = "funcion";
                    break;
                case 2:
                    tip = "metodo";
                    break;
                case 3:
                    tip = "variable";
                    break;
                case 4:
                    tip = "parametro";
                    break;
                case 5:
                    tip = "arreglo";
                    break;
                default:
                    break;
            }
            this.reporte.add(s.id + ":::" + s.tipo_dato + ":::" + tip + ":::" + s.ambito);
        }
        return simb;
    }

    public void Heredar(TablaSimbolo h) {
        if (this.siguente == null) {
            this.siguente = h;
        } else {
            this.siguente.Heredar(h);
        }
    }

    public static void GenerarReport() throws IOException {
        String table = "<tr><td>IDENTIFICADOR</td><td>TIPO</td><td>ROL</td><td>AMBITO</td></tr>";
        java.util.Date fecha = new Date();
        String d = "<p>generado: " + fecha + "</p>";

        table = reporte.stream().map((n) -> n.split(":::")).map((h) -> "<tr>" + "<td>" + h[0] + "</td><td>" + h[1] + "</td><td>" + h[2] + "</td><td>" + h[3] + "</td><tr>").reduce(table, String::concat);

        String html = "<html><body><h1>TABLA DE SIMBOLOS</h1>" + d + ""
                + "<table border = 3> " + table + "</table></body></html>";

        File file = new File("tabla_simbolo.html");

        if (file != null) {
            try (FileWriter archivo = new FileWriter(file)) {
                archivo.write(html);
            }
        }

    }

}
