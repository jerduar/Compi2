%{
#include "scanner.h"//se importa el header del analisis sintactico

#include <iostream> //libreria para imprimir en cosola de C

#include <QString> //libreria para manejo de STRINGS de QT

#include <QTextStream>

#include <QHash> //Libreria para manejar HASH TABLES de QT, se usa para la tabla de simbolos


#include <QTextEdit> //libreria QTextEdit de QT para poder mostrar el resultado en pantalla

extern int yylineno; //linea actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern int columna; //columna actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern char *yytext; //lexema actual donde esta el parser (analisis lexico) lo maneja BISON

int yyerror(const char* mens){
//metodo que se llama al haber un error sintactico
//SE IMPRIME EN CONSOLA EL ERROR
std::cout <<mens<<" error: "<<yytext << " linea: " << yylineno << " columna: " << columna << std::endl;
return 0;
}

QTextEdit* salida; //puntero al QTextEdit de salida
void setSalida(QTextEdit* sal) {
//metodo que asigna el valor al QTextEdit de salida
salida=sal;
}

struct Operador{
//ESTRUCTURA LA CUAL CONTENDRA LOS TIPOS DE LOS NO TERMINALES PARA HEREDAR VALORES
QString  texto;
float valor;
};

%}
//error-verbose si se especifica la opcion los errores sintacticos son especificados por BISON
%error-verbose

%union{
//se especifican los tipo de valores para los no terminales y lo terminales
char TEXT [256];
struct Operador * VAL;
}
//TERMINALES DE TIPO TEXT, SON STRINGS
%token<TEXT>  llavea
%token<TEXT>  llavec
%token<TEXT>  dospuntos
%token<TEXT>  cora
%token<TEXT>  corc
%token<TEXT>  coma
%token<TEXT>  cadena
%token<TEXT>  identificador
%token<TEXT>  comilla
%token<TEXT>  falso
%token<TEXT>  verdadero
%token<TEXT>  decimal
%token<TEXT>  entero

//NO TERMINALES DE TIPO VAL, POSEEN ATRIBUTOS INT VALOR, Y QSTRING TEXTO
%type<VAL>  S
%type<VAL>  J
%type<VAL>  O
%type<VAL>  LA
%type<VAL>  A
%type<VAL>  D
%type<VAL>  COL
%type<VAL>  LO
%type<VAL> VALOR
%%

S : J{};

J : llavea D llavec {};

D : D coma O {}
    | O {}
    | COL {}
    | A{};


O : cadena dospuntos llavea LA llavec {}

COL : cadena dospuntos cora LO corc {};

LA : LA coma A {}
    | A {}
    | O{}
    | COL{};

A : cadena dospuntos VALOR {};


LO : LO coma llavea LA llavec {}
    | llavea LA llavec{};

VALOR : O{}
    | COL{}
    | cadena{};
%%
