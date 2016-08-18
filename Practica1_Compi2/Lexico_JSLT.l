%option noyywrap
%{
#include "parser2.h"
#include <iostream>
#include <QTextStream>
#include <QString>
#include <QListWidget>

QListWidget *ventana;
void SetVentana(QListWidget *vista){
    ventana = vista;
}

int columna_jslt=0;
int fila_jslt = 1;
%}
digito [0-9]
caracter "'"[^']"'"
decimal {digito}+"."{digito}+
entero {digito}+
comentario_linea "##"[^\n]*
comentario_multilinea "#*"[^"*#"]*"*#"
identificador [a-zñA-ZÑ][a-zñA-ZÑ0-9]*
letra ["][^\"]*["]
%%
":"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return dospuntos; }
"html"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_html; }
"h1"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_h1; }
"h2"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_h2; }
"h3"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_h3; }
"h4"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_h4; }
"h5"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_h5; }
"h6"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_h6; }
"title"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_title; }
"body"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_body; }
"head"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_head; }
"table"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_table; }
"th"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_th; }
"tr"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_tr; }
"td"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_td; }
"boder"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_boder; }
"bgcolor"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_bgcolor; }
"width"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_width; }
"p"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_p; }
"b"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_b; }
"i"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tok_i; }
"jsl"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return jslt; }
"transformacion"            { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return transformacion; }
"ruta"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return ruta; }
"version"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return version; }
"final"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return final; }
"<"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return break_a; }
">"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return break_c; }
"/"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return slash; }
"nombreObj"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return nombreobj; }
"asignar"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return asignar; }
"variable"                  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return variable; }
"valor"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return valor; }
"valor-de"                  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return valor_de; }
"para-cada"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return paracada; }
"if"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return si; }
"en-caso"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return encaso; }
"de"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return de; }
"cualquier-otro"            { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return cualquierotro; }
"seleccionar"               { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return seleccionar; }
"plantilla"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return plantilla; }
"plantilla-aplicar"         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return plantilla_aplicar; }
"condicion"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return condicion; }
"="                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return igual ; }
"=="                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return igualigual; }
"!="                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return diferente; }
"&lt"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return menor_que; }
"&lte"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return menor_igual; }
"&gt"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return mayor_que; }
"&gte"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return mayor_igual; }
"!¡"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return es_nulo; }
"||"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return oor; }
"&&"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return aand; }
"!&&"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return nand; }
"!||"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return nor; }
"&|"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return xxor; }
"!"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return nnot; }
"+"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return mas; }
"-"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return menos; }
"*"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return por; }
"div"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return division; }
"%"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return modulo; }
"^"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return potencia; }
"++"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return incremento; }
"@"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return arroba; }
"@@"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return arroba_doble; }
"--"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return decremento; }
"+="                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return suma_igual; }
"entero"                    { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_entero; }
"cadena"                    { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_cadena; }
"doble"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_doble; }
"boolean"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_bool; }
"caracter"                  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_char; }
"("                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return para; }
")"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return parc; }
{caracter}                  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return caracter; }
"["                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return cora; }
"]"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return corc; }
","                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return coma; }
{entero}                    { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return entero; }
{decimal}                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return decimal; }
{letra}                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return cadena; }
{identificador}             { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return identificador; }
{comentario_linea}          { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); }
{comentario_multilinea}     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); }
\n                          { columna_jslt = 1;fila_jslt = fila_jslt + 1; }
[\t\r]                      { columna_jslt = columna_jslt + 1; }
" "                         {columna_jslt = columna_jslt + 1; }
"   "                       {columna_jslt = columna_jslt + 1; }
.                           {QString aux = "Error Lexico : " + (QString)jjtext + " fila : " + QString::number(fila_jslt) + " columna : " + QString::number(columna_jslt);
                             ventana->addItem(aux);}
%%
