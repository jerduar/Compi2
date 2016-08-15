%{
#include "scanner2.h"//se importa el header del analisis sintactico

#include <iostream> //libreria para imprimir en cosola de C

#include <QString> //libreria para manejo de STRINGS de QT

#include <QTextStream>

#include <arbolast.h>

#include <QStringList>

#include <nodoast.h>//NODO PARA LA CREACIÓN DE AST

#include <QHash> //Libreria para manejar HASH TABLES de QT, se usa para la tabla de simbolos

#include <QTextEdit> //libreria QTextEdit de QT para poder mostrar el resultado en pantalla

extern int fila_jslt; //linea actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern int columna_jslt; //columna actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern char *jjtext; //lexema actual donde esta el parser (analisis lexico) lo maneja BISON

int jjerror(const char* mens){
//metodo que se llama al haber un error sintactico
//SE IMPRIME EN CONSOLA EL ERROR
std::cout <<"Error Sintactico : "<< jjtext << " linea: " << fila_jslt << " columna: " << columna_jslt - strlen(jjtext) << std::endl;
return 0;
}

QTextEdit* salida_jslt; //puntero al QTextEdit de salida
void setSalidaJSLT(QTextEdit* exit) {
//metodo que asigna el valor al QTextEdit de salida
salida_jslt=exit;
}

ArbolAST *generado;
ArbolAST *setArbol(){
    return generado;
}

void jjsetFila(){
    fila_jslt = 1;
}

void jjsetColumna(){
    columna_jslt = 0;
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
struct NodoAST *NODE;
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
%token<TEXT>  para_cada
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
%token<TEXT>  valor_de
%token<TEXT>  tok_html

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
%type<NODE>  PARA_CADA
%type<NODE>  SI
%type<NODE>  EN_CASO
%type<NODE>  TIPO
%type<NODE>  EXP_REL
%type<NODE>  EXP_ARIT
%type<NODE>  EXP_LOGICA
%type<NODE>  LISTA_CASOS
%type<NODE>  CASO
%type<NODE>  HTML
%type<NODE>  SENTENCIAS_HTML

%left mas menos
%left division por modulo
%left potencia

%left oor nor xxor
%left aand nand
%left nnot


%%

S : INICIO{
        generado = new ArbolAST();
        generado->raiz = $1;
        };

INICIO : break_a jslt dospuntos transformacion ruta igual cadena version igual cadena break_c LISTA_SENTENCIAS break_a slash jslt dospuntos final break_c{
        $$ = new NodoAST("INICIO");
        $$->addHijo($1);
        $$->addHijo($2);
        $$->addHijo($3);
        $$->addHijo($4);
        $$->addHijo($5);
        $$->addHijo($6);
        $$->addHijo($7);
        $$->addHijo($8);
        $$->addHijo($9);

        QString temp;
        temp.sprintf($9);
        temp.remove(0,0);
        temp.remove(temp.size()-1,temp.size()-1);

        $$->addHijo($10);
        $$->addHijo($11);
        $$->addHijo($12);
        $$->addHijo($13);
        $$->addHijo($14);
        $$->addHijo($15);
        $$->addHijo($16);
        $$->addHijo($17);
        $$->addHijo($18);
    };

LISTA_SENTENCIAS : LISTA_SENTENCIAS SENTENCIA{
        $1->addHijo($2);
        $$ = $1;
    }
    | SENTENCIA{
        $$ = new NodoAST("LISTA_SENTENCIAS");
        $$->addHijo($1);
    };

SENTENCIA : ASIGNACION{}
    | DECLARACION{
        $$ = new NodoAST("SENTENCIA");
        $$->addHijo($1);
    }
    | PLANTILLA{}
    | APLICAR_PLANTILLA{}
    | VALOR_DE{
        $$ = new NodoAST("SENTENCIA");
        $$-> addHijo($1);
    }
    | PARA_CADA{}
    | HTML{}
    | EN_CASO{}
    | SI{}
    | error{jjerror;};

SI : break_a jslt dospuntos si condicion igual EXP_LOGICA break_c LISTA_SENTENCIAS break_a slash jslt dospuntos si break_c{};

HTML : break_a tok_html break_c SENTENCIAS_HTML break_a slash tok_html break_c{};

SENTENCIAS_HTML : identificador{};

EXP_LOGICA : EXP_LOGICA oor EXP_LOGICA{}
    | EXP_LOGICA aand EXP_LOGICA{}
    | EXP_LOGICA nand EXP_LOGICA{}
    | EXP_LOGICA nor EXP_LOGICA{}
    | EXP_LOGICA xxor EXP_LOGICA{}
    | nnot EXP_LOGICA{}
    | EXP_REL{};

EXP_REL : EXP_ARIT igualigual EXP_ARIT{}
    | EXP_ARIT diferente EXP_ARIT{}
    | EXP_ARIT menor_que EXP_ARIT{}
    | EXP_ARIT menor_igual EXP_ARIT{}
    | EXP_ARIT mayor_que EXP_ARIT{}
    | EXP_ARIT mayor_igual EXP_ARIT{}
    | es_nulo EXP_ARIT{};

EXP_ARIT : EXP_ARIT por EXP_ARIT{}
    | EXP_ARIT mas EXP_ARIT{}
    | EXP_ARIT menos EXP_ARIT{}
    | EXP_ARIT division EXP_ARIT{}
    | EXP_ARIT modulo EXP_ARIT{}
    | EXP_ARIT potencia EXP_ARIT{}
    | para EXP_ARIT parc{}
    | identificador{}
    | entero{}
    | caracter{}
    | cadena{}
    | decimal{
        $$ = new NodoAST("EXP_ARIT");
        $$->addHijo($1);
    };

PLANTILLA : break_a jslt dospuntos plantilla nombreobj igual identificador break_c LISTA_SENTENCIAS break_a slash jslt dospuntos plantilla break_c{};

APLICAR_PLANTILLA : break_a jslt plantilla_aplicar seleccionar igual identificador slash break_c{};

ASIGNACION : break_a jslt dospuntos variable igual identificador valor igual EXP_ARIT break_c{};

DECLARACION : break_a jslt dospuntos variable TIPO igual identificador break_c{
        $$ = new NodoAST("DECLARACION");
        $$->addHijo($1);
        $$->addHijo($2);
        $$->addHijo($3);
        $$->addHijo($4);
        $$->addHijo($5);
        $$->addHijo($6);
        $$->addHijo($7);
        $$->addHijo($8);
     };

TIPO : tipo_entero{
        $$ = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST($1);
        $$->Hijos->append(aux);
    }

    | tipo_cadena{
        $$ = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST($1);
        $$->Hijos->append(aux);
    }

    | tipo_doble{

        $$ = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST($1);
        $$->Hijos->append(aux);
    }

    | tipo_bool{

        $$ = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST($1);
        $$->Hijos->append(aux);
    }

    | tipo_char{

        $$ = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST($1);
        $$->Hijos->append(aux);
    };

VALOR_DE :  break_a jslt dospuntos valor_de seleccionar igual identificador break_c{
        $$ = new NodoAST("VALOR_DE");
        $$->addHijo($1);
        $$->addHijo($2);
        $$->addHijo($3);
        $$->addHijo($4);
        $$->addHijo($5);
        $$->addHijo($6);
        $$->addHijo($7);
        $$->addHijo($8);
    };

PARA_CADA : break_a jslt dospuntos para_cada seleccionar igual identificador break_c LISTA_SENTENCIAS break_a slash jslt dospuntos para_cada break_c{};

EN_CASO : break_a jslt dospuntos encaso break_c LISTA_CASOS break_a slash jslt dospuntos encaso break_c{};

LISTA_CASOS : LISTA_CASOS CASO{}
    | CASO{};

CASO : break_a jslt dospuntos de condicion igual EXP_LOGICA break_c LISTA_SENTENCIAS break_a slash jslt dospuntos de break_c{

        }
    | break_a jslt dospuntos cualquierotro break_c LISTA_SENTENCIAS  break_a slash jslt dospuntos cualquierotro break_c{};

%%
