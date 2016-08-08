%option noyywrap
%{
#include "parser2.h"
#include <iostream>
#include <QTextStream>
#include <QString>
int columna=0;
int fila = 1;
%}
digito [0-9]
decimal [{digito}+"."{digito}+]
dec ["]{decimal}["]
entero \"{digito}+\"
identificador [a-z][a-z0-9]*
letra ["][^\"]*["]
%%
"}"             { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return llavec; }
"{"             { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return llavea; }
":"             { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return dospuntos; }
\""falso"\"         { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return falso; }
\""verdadero"\"     { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return verdadero; }
"["             { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return cora; }
"]"             { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return corc; }
","             { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return coma; }
["]            { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return comilla; }
{entero}        { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return entero; }
{dec}        { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return decimal; }
{letra}        { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return cadena; }
{identificador} { columna=columna+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext); return identificador; }
"\n"    {columna = 0;fila++;}
"\t"    {columna++;}
"\r"    {columna++;}
.               {}
%%
