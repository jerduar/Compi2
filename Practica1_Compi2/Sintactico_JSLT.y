%{
#include "scanner2.h"//se importa el header del analisis sintactico

#include <iostream> //libreria para imprimir en cosola de C

#include <QString> //libreria para manejo de STRINGS de QT

#include <QTextStream>

#include <QStringList>

#include <nodo.h>//OBJETO PARA ALMECENAR LOS ATRIBUTOS DE LOS OBJETOS

#include <QHash> //Libreria para manejar HASH TABLES de QT, se usa para la tabla de simbolos

#include <QTextEdit> //libreria QTextEdit de QT para poder mostrar el resultado en pantalla

extern int fila_jslt; //linea actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern int columna_jslt; //columna actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern char *jjtext; //lexema actual donde esta el parser (analisis lexico) lo maneja BISON

int jjerror(const char* mens){
//metodo que se llama al haber un error sintactico
//SE IMPRIME EN CONSOLA EL ERROR
std::cout <<mens<<" error: "<<jjtext << " linea: " << jjlineno << " columna: " << columna_jslt << std::endl;
return 0;
}

QTextEdit* salida_jslt; //puntero al QTextEdit de salida
void setSalidaJSLT(QTextEdit* exit) {
//metodo que asigna el valor al QTextEdit de salida
salida_jslt=exit;
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
struct Nodo *NODE;
}
//TERMINALES DE TIPO TEXT, SON STRINGS
%token<TEXT>  dospuntos
%token<TEXT>  jslt
%token<TEXT>  transformacion
%token<TEXT>  ruta
%token<TEXT>  version
%token<TEXT>  final
%token<TEXT>  break_a
%token<TEXT>  break_c
%token<TEXT>  slash
%token<TEXT>  asignar
%token<TEXT>  variable
%token<TEXT>  valor
%token<TEXT>  paracada
%token<TEXT>  si
%token<TEXT>  encaso
%token<TEXT>  de
%token<TEXT>  cualquierotro
%token<TEXT>  seleccionar
%token<TEXT>  plantilla
%token<TEXT>  condicion
%token<TEXT>  igualigual
%token<TEXT>  diferente
%token<TEXT>  menor_que
%token<TEXT>  menor_igual
%token<TEXT>  mayor_que
%token<TEXT>  mayor_igual
%token<TEXT>  es_nulo
%token<TEXT>  oor
%token<TEXT>  aand
%token<TEXT>  nand
%token<TEXT>  nor
%token<TEXT>  xxor
%token<TEXT>  nnot
%token<TEXT>  mas
%token<TEXT>  menos
%token<TEXT>  division
%token<TEXT>  por
%token<TEXT>  modulo
%token<TEXT>  potencia
%token<TEXT>  incremento
%token<TEXT>  decremento
%token<TEXT>  suma_igual
%token<TEXT>  tipo_entero
%token<TEXT>  tipo_cadena
%token<TEXT>  tipo_doble
%token<TEXT>  tipo_bool
%token<TEXT>  tipo_char
%token<TEXT>  cora
%token<TEXT>  corc
%token<TEXT>  coma
%token<TEXT>  cadena
%token<TEXT>  identificador
%token<TEXT>  falso
%token<TEXT>  verdadero
%token<TEXT>  decimal
%token<TEXT>  caracter
%token<TEXT>  entero
%token<TEXT>  igual
%token<TEXT>  nombreobj
%token<TEXT>  plantilla_aplicar
%token<TEXT>  para
%token<TEXT>  parc

//NO TERMINALES DE TIPO VAL, POSEEN ATRIBUTOS INT VALOR, Y QSTRING TEXTO
%type<NODE>  S
%type<NODE>  INICIO
%type<NODE>  LISTA_SENTENCIAS
%type<NODE>  SENTENCIA
%type<NODE>  ASIGNACION
%type<NODE>  DECLARACION
%type<NODE>  PLANTILLA
%type<NODE>  APLICAR_PLANTILLA
%type<NODE>  VALOR_DE
%type<TEXT>  PARA_CADA
%type<TEXT>  SI
%type<TEXT>  EN_CASO
%type<TEXT>  TIPO
%type<TEXT>  EXP_REL
%type<TEXT>  EXP_ARIT
%type<TEXT>  EXP_LOGICA
%type<TEXT>  VALOR

%left mas menos
%left division por modulo
%left potencia

%left oor nor xxor
%left aand nand
%left nnot


%%

S : INICIO{};

INICIO : break_a jslt dospuntos transformacion ruta igual cadena version igual cadena break_c LISTA_SENTENCIAS break_a slash jslt dospuntos final break_c{};

LISTA_SENTENCIAS : LISTA_SENTENCIAS SENTENCIA{}
    | SENTENCIA{};

SENTENCIA : ASIGNACION{}
    | DECLARACION{}
    | PLANTILLA{}
    | APLICAR_PLANTILLA{}
    | SI{};

SI : break_a jslt dospuntos si condicion igual EXP_LOGICA break_c LISTA_SENTENCIAS break_a slash jslt dospuntos si break_c{};

EXP_LOGICA : EXP_LOGICA oor EXP_LOGICA{}
    | EXP_LOGICA aand EXP_LOGICA{}
    | EXP_LOGICA nand EXP_LOGICA{}
    | EXP_LOGICA nor EXP_LOGICA{}
    | EXP_LOGICA xxor EXP_LOGICA{}
    | EXP_LOGICA nnot EXP_LOGICA{}
    | EXP_LOGICA oor EXP_LOGICA{}
    | para EXP_LOGICA parc{}
    | EXP_REL{};

EXP_REL : EXP_REL igualigual EXP_REL{}
    | EXP_REL diferente EXP_REL{}
    | EXP_REL menor_que EXP_REL{}
    | EXP_REL menor_igual EXP_REL{}
    | EXP_REL mayor_que EXP_REL{}
    | EXP_REL mayor_igual EXP_REL{}
    | es_nulo EXP_REL{}
    | EXP_ARIT{};

EXP_ARIT : EXP_ARIT por EXP_ARIT{}
    | EXP_ARIT mas EXP_ARIT{}
    | EXP_ARIT menos EXP_ARIT{}
    | EXP_ARIT division EXP_ARIT{}
    | EXP_ARIT modulo EXP_ARIT{}
    | EXP_ARIT potencia EXP_ARIT{}
    | para EXP_ARIT parc{}
    | identificador{}
    | entero{}
    | decimal{};

PLANTILLA : break_a jslt dospuntos plantilla nombreobj igual identificador break_c LISTA_SENTENCIAS break_a slash jslt dospuntos plantilla break_c{};

APLICAR_PLANTILLA : break_a jslt plantilla_aplicar seleccionar igual identificador{};

ASIGNACION : break_a jslt dospuntos variable igual identificador valor igual VALOR break_c{};

VALOR : entero{}
    | decimal{}
    | cadena{}
    | caracter{}
    | identificador{}
    | EXP_ARIT{};


DECLARACION : break_a jslt dospuntos variable TIPO igual identificador break_c{};

TIPO : tipo_entero{}
    | tipo_cadena{}
    | tipo_doble{}
    | tipo_bool{}
    | tipo_char{};

%%
