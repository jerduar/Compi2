%option noyywrap
%{
#include "parser.h"
#include <iostream>
#include <QTextStream>
#include <QString>
int columna=0;
int fila = 1;
%}
digito [0-9]
dec ["]([0-9])+"."([0-9])+["]
entero \"{digito}+\"
identificador [a-z][a-z0-9]*
letra ["][^\"]*["]
%%
"}"                     { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return llavec; }
"{"                     { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return llavea; }
":"                     { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return dospuntos; }
\""falso"\"             { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return falso; }
\""verdadero"\"         { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return verdadero; }
"["                     { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return cora; }
"]"                     { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return corc; }
","                     { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return coma; }
["]                     { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return comilla; }
{entero}                { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return entero; }
{dec}                   { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return decimal; }
{letra}                 { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return cadena; }
{identificador}         { columna=columna+strlen(yylval.TEXT); strcpy(yylval.TEXT, yytext); return identificador; }
\n                      {columna = 1;fila = fila + 1;}
[[:blank:]]             {/*Se ingnora*/}
[\t\r]                  {columna = columna + 1;}
.                       {QTextStream(stdout) << "Error Lexico :" << yytext << " fila : " + QString::number(fila) << " columna : " << QString::number(columna) << endl;}
%%
