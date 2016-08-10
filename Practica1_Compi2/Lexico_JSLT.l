%option noyywrap
%{
#include "parser2.h"
#include <iostream>
#include <QTextStream>
#include <QString>
int columna_jslt=0;
int fila_jslt = 1;
%}
digito [0-9]
caracter "'"[^']"'"
decimal {digito}+"."{digito}+
entero {digito}+
comentario_linea "##"[^\n]*
comentario_multilinea "#*"[^"*#"]*"*#"
identificador [a-z][a-z0-9]*
letra ["][^\"]*["]
%%
":"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return dospuntos; }
"jsl"               { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return jslt; }
"transformacion"    { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return transformacion; }
"ruta"              { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return ruta; }
"version"           { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return version; }
"final"             { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return final; }
"<"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return break_a; }
">"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return break_c; }
"/"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return slash; }
"nombreObj"			{ columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return nombreobj; }
"asignar"           { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return asignar; }
"variable"          { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return variable; }
"valor"             { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return valor; }
"para-cada"         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return paracada; }
"if"                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return si; }
"en-caso"           { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return encaso; }
"de"                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return de; }
"cualquier-otro"    { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return cualquierotro; }
"seleccionar"       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return seleccionar; }
"plantilla"         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return plantilla; }
"plantilla-aplicar"	{ columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return plantilla_aplicar; }
"condicion"         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return condicion; }
"="                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return igual ; }
"=="                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return igualigual; }
"!="                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return diferente; }
"&lt"               { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return menor_que; }
"&lte"              { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return menor_igual; }
"&gt"               { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return mayor_que; }
"&gte"              { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return mayor_igual; }
"!¡"                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return es_nulo; }
"||"                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return oor; }
"&&"                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return aand; }
"!&&"               { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return nand; }
"!||"               { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return nor; }
"&|"                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return xxor; }
"!"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return nnot; }
"+"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return mas; }
"-"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return menos; }
"*"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return por; }
"div"               { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return division; }
"%"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return modulo; }
"^"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return potencia; }
"++"                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return incremento; }
"--"                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return decremento; }
"+="                { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return suma_igual; }
"entero"            { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_entero; }
"cadena"            { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_cadena; }
"doble"             { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_doble; }
"boolean"           { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_bool; }
"caracter"          { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return tipo_char; }
"("					{ columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return para; }
")"					{ columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return parc; }
{caracter}			{ columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return caracter; }
"["                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return cora; }
"]"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return corc; }
","                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return coma; }
{entero}            { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return entero; }
{decimal}           { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return decimal; }
{letra}             { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return cadena; }
{identificador}     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return identificador; }
{comentario_linea}  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); }
{comentario_multilinea} { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); }
"\n"                {columna_jslt = 0;fila_jslt = fila_jslt + 1;}
"\t"                {columna_jslt = columna_jslt + 1;}
"\r"                {columna_jslt = columna_jslt + 1;}
.                   {}
%%
