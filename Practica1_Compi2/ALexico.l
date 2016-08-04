%option noyywrap
%{
#include "parser.h"
#include <iostream>
#include <QString>
int columna=0;
%}
letra \"[^\"]+\"

digito [0-9]
palabra {letra}
decimal {digito}+["."{digito}+]?
entero {digito}+
identificador [a-z][a-z0-9]*
%%
"}"             { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return llavec; }
"{"             { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return llavea; }
":"             { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return dospuntos; }
"falso"         { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return falso; }
"verdadero"     { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return verdadero; }
"["             { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return cora; }
"]"             { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return corc; }
","             { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return coma; }
"\""            { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return comilla; }
{entero}        { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return entero; }
{letra}        { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return cadena; }
{identificador} { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return identificador; }
[[:blank:]]     { /* SE IGNORAN LOS ESPACIOS EN BLANCO */ }
.               {}
%%
