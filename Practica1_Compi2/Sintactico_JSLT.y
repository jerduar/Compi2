%{
#include "scanner2.h"//se importa el header del analisis sintactico

#include <iostream> //libreria para imprimir en cosola de C
#include <QString> //libreria para manejo de STRINGS de QT
#include <QTextStream>
#include <arbolast.h>
#include <QStringList>
#include <QListWidget>
#include <nodoast.h>//NODO PARA LA CREACIÓN DE AST
#include <QHash> //Libreria para manejar HASH TABLES de QT, se usa para la tabla de simbolos
#include <QTextEdit> //libreria QTextEdit de QT para poder mostrar el resultado en pantalla

extern int fila_jslt; //linea actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern int columna_jslt; //columna actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern char *jjtext; //lexema actual donde esta el parser (analisis lexico) lo maneja BISON

QListWidget *ventanita;

int jjerror(const char* mens){
//metodo que se llama al haber un error sintactico
//SE IMPRIME EN CONSOLA EL ERROR
//std::cout << mens <<"Error Sintactico : "<< jjtext << " linea: " << fila_jslt << " columna: " << columna_jslt - strlen(jjtext) << std::endl;
ventanita->addItem("Error Sintactico : " + (QString)jjtext + " linea: " + QString::number(fila_jslt) + " columna: " + QString::number(columna_jslt - strlen(jjtext)));
return 0;
}

void SetVentanita(QListWidget *ven){
    ventanita = ven;
}

int correcto = 1;
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
%token<TEXT>  tok_h1
%token<TEXT>  tok_h2
%token<TEXT>  tok_h3
%token<TEXT>  tok_h4
%token<TEXT>  tok_h5
%token<TEXT>  tok_h6
%token<TEXT>  tok_title
%token<TEXT>  tok_body
%token<TEXT>  tok_head
%token<TEXT>  tok_table
%token<TEXT>  tok_th
%token<TEXT>  tok_tr
%token<TEXT>  tok_td
%token<TEXT>  tok_boder
%token<TEXT>  tok_bgcolor
%token<TEXT>  tok_width
%token<TEXT>  tok_p
%token<TEXT>  tok_b
%token<TEXT>  tok_i
%token<TEXT>  arroba
%token<TEXT>  arroba_doble


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
%type<NODE>  CUALQUIER
%type<NODE>  CASOS
%type<NODE>  MOD1
%type<NODE>  MOD2
%type<NODE>  LLAMADA_OBJETO
%type<NODE>  LLAMADA
%type<NODE>  LISTA_LLAMADAS

%left mas menos
%left division por modulo
%left potencia

%left oor nor xxor
%left aand nand
%left nnot


%%

S : INICIO{
        generado = new ArbolAST();
        if(correcto != 0){
            generado->raiz = $1;
        }else{
            generado = NULL;
        }
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

LLAMADA_OBJETO : LLAMADA_OBJETO arroba LLAMADA{}
    | LLAMADA_OBJETO arroba_doble LLAMADA{}
    | LLAMADA{};

LLAMADA : identificador{};


LISTA_SENTENCIAS : LISTA_SENTENCIAS SENTENCIA{
        $1->addHijo($2);
        $$ = $1;
    }
    | SENTENCIA{
        $$ = new NodoAST("LISTA_SENTENCIAS");
        $$->addHijo($1);
    };

SENTENCIA : ASIGNACION{
         $$ = new NodoAST("SENTENCIA");
         $$->addHijo($1);
    }
    | DECLARACION{
        $$ = new NodoAST("SENTENCIA");
        $$->addHijo($1);
    }
    | PLANTILLA{
            $$ = new NodoAST("SENTENCIA");
            $$-> addHijo($1);
        }
    | APLICAR_PLANTILLA{
            $$ = new NodoAST("SENTENCIA");
            $$-> addHijo($1);
        }
    | VALOR_DE{
        $$ = new NodoAST("SENTENCIA");
        $$-> addHijo($1);
    }
    | PARA_CADA{
            $$ = new NodoAST("SENTENCIA");
            $$-> addHijo($1);
        }
    | HTML{}
    | EN_CASO{
            $$ = new NodoAST("SENTENCIA");
            $$->addHijo($1);
        }
    | SI{
            $$ = new NodoAST("SENTENCIA");
            $$->addHijo($1);
        }
    | MOD1{
            $$ = new NodoAST("SENTENCIA");
            $$->addHijo($1);
        }
    | MOD2{
            $$ = new NodoAST("SENTENCIA");
            $$->addHijo($1);
        }
    | error{jjerror; correcto = 0;};

SI : break_a jslt dospuntos si condicion igual EXP_LOGICA break_c LISTA_SENTENCIAS break_a slash jslt dospuntos si break_c{
        $$ = new NodoAST("SI");
        $$->addHijo($1);
        $$->addHijo($2);
        $$->addHijo($3);
        $$->addHijo($4);
        $$->addHijo($5);
        $$->addHijo($6);
        $$->addHijo($7);
        $$->addHijo($8);
        $$->addHijo($9);
        $$->addHijo($10);
        $$->addHijo($11);
        $$->addHijo($12);
        $$->addHijo($13);
        $$->addHijo($14);
        $$->addHijo($15);
    };

HTML : break_a tok_html break_c SENTENCIAS_HTML break_a slash tok_html break_c{};

SENTENCIAS_HTML : identificador{};

EXP_LOGICA : EXP_LOGICA oor EXP_LOGICA{
            $$ = new NodoAST("EXP_LOGICA");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
    }
    | EXP_LOGICA aand EXP_LOGICA{
            $$ = new NodoAST("EXP_LOGICA");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_LOGICA nand EXP_LOGICA{
            $$ = new NodoAST("EXP_LOGICA");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_LOGICA nor EXP_LOGICA{
            $$ = new NodoAST("EXP_LOGICA");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_LOGICA xxor EXP_LOGICA{
            $$ = new NodoAST("EXP_LOGICA");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | nnot EXP_LOGICA{
            $$ = new NodoAST("EXP_LOGICA");
            $$->addHijo($1);
            $$->addHijo($2);
        }

    | EXP_REL{
            $$ = new NodoAST("EXP_LOGICA");
            $$->addHijo($1);
        };

EXP_REL : EXP_ARIT igualigual EXP_ARIT{
            $$ = new NodoAST("EXP_REL");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT diferente EXP_ARIT{
            $$ = new NodoAST("EXP_REL");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT menor_que EXP_ARIT{
            $$ = new NodoAST("EXP_REL");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | para EXP_REL parc{}

    | EXP_ARIT menor_igual EXP_ARIT{
            $$ = new NodoAST("EXP_REL");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT mayor_que EXP_ARIT{
            $$ = new NodoAST("EXP_REL");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT mayor_igual EXP_ARIT{
            $$ = new NodoAST("EXP_REL");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | es_nulo EXP_ARIT{
            $$ = new NodoAST("EXP_REL");
            $$->addHijo($1);
            $$->addHijo($2);
        };

EXP_ARIT : EXP_ARIT por EXP_ARIT{
            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT mas EXP_ARIT{
            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT menos EXP_ARIT{
            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT division EXP_ARIT{

            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT modulo EXP_ARIT{

            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | EXP_ARIT potencia EXP_ARIT{

            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | para EXP_ARIT parc{

            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
        }
    | identificador{
            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
        }
    | entero{

            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
    }
    | caracter{
            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
    }
    | cadena{
        $$ = new NodoAST("EXP_ARIT");
        $$->addHijo($1);
    }
    | decimal{
        $$ = new NodoAST("EXP_ARIT");
        $$->addHijo($1);
    }
    | MOD1{
            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
        }
    | MOD2{
            $$ = new NodoAST("EXP_ARIT");
            $$->addHijo($1);
        };

PLANTILLA : break_a jslt dospuntos plantilla nombreobj igual identificador break_c LISTA_SENTENCIAS break_a slash jslt dospuntos plantilla break_c{
            $$ = new NodoAST("PLANTILLA");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
            $$->addHijo($4);
            $$->addHijo($5);
            $$->addHijo($6);
            $$->addHijo($7);
            $$->addHijo($8);
            $$->addHijo($9);
            $$->addHijo($10);
            $$->addHijo($11);
            $$->addHijo($12);
            $$->addHijo($13);
            $$->addHijo($14);
            $$->addHijo($15);
        };

APLICAR_PLANTILLA : break_a jslt dospuntos plantilla_aplicar seleccionar igual identificador slash break_c{
            $$ = new NodoAST("APLICAR_PLANTILLA");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
            $$->addHijo($4);
            $$->addHijo($5);
            $$->addHijo($6);
            $$->addHijo($7);
            $$->addHijo($8);
            $$->addHijo($9);
        };

ASIGNACION : break_a jslt dospuntos variable igual identificador valor igual EXP_ARIT break_c{
            $$ = new NodoAST("ASIGNACION");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
            $$->addHijo($4);
            $$->addHijo($5);
            $$->addHijo($6);
            $$->addHijo($7);
            $$->addHijo($8);
            $$->addHijo($9);
            $$->addHijo($10);
        };

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

PARA_CADA : break_a jslt dospuntos paracada seleccionar igual identificador break_c LISTA_SENTENCIAS break_a slash jslt dospuntos paracada break_c{
            $$ = new NodoAST("PARA_CADA");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
            $$->addHijo($4);
            $$->addHijo($5);
            $$->addHijo($6);
            $$->addHijo($7);
            $$->addHijo($8);
            $$->addHijo($9);
            $$->addHijo($10);
            $$->addHijo($11);
            $$->addHijo($12);
            $$->addHijo($13);
            $$->addHijo($14);
            $$->addHijo($15);
        };

EN_CASO : break_a jslt dospuntos encaso break_c LISTA_CASOS break_a slash jslt dospuntos encaso break_c{
            $$ = new NodoAST("EN_CASO");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
            $$->addHijo($4);
            $$->addHijo($5);
            $$->addHijo($6);
            $$->addHijo($7);
            $$->addHijo($8);
            $$->addHijo($9);
            $$->addHijo($10);
            $$->addHijo($11);
            $$->addHijo($12);
        };

LISTA_CASOS : LISTA_CASOS CASOS{
            $1->addHijo($2);
            $$ = $1;
        }
    | CASOS{
            $$ = new NodoAST("LISTA_CASOS");
            $$->addHijo($1);
        };

CASOS : CASO{
            $$ = new NodoAST("CASOS");
            $$->addHijo($1);
        };
    | CUALQUIER{
            $$ = new NodoAST("CASOS");
            $$->addHijo($1);
        };

CASO : break_a jslt dospuntos de condicion igual EXP_LOGICA break_c LISTA_SENTENCIAS break_a slash jslt dospuntos de break_c{
            $$ = new NodoAST("CASO");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
            $$->addHijo($4);
            $$->addHijo($5);
            $$->addHijo($6);
            $$->addHijo($7);
            $$->addHijo($8);
            $$->addHijo($9);
            $$->addHijo($10);
            $$->addHijo($11);
            $$->addHijo($12);
            $$->addHijo($13);
            $$->addHijo($14);
            $$->addHijo($15);
        };

CUALQUIER : break_a jslt dospuntos cualquierotro break_c LISTA_SENTENCIAS  break_a slash jslt dospuntos cualquierotro break_c{
            $$ = new NodoAST("CUALQUIER");
            $$->addHijo($1);
            $$->addHijo($2);
            $$->addHijo($3);
            $$->addHijo($4);
            $$->addHijo($5);
            $$->addHijo($6);
            $$->addHijo($7);
            $$->addHijo($8);
            $$->addHijo($9);
            $$->addHijo($10);
            $$->addHijo($11);
            $$->addHijo($12);
        };

MOD1 : incremento identificador{
            $$ = new NodoAST("MOD1");
            $$->addHijo($1);
            $$->addHijo($2);
        }
        | decremento identificador{
            $$ = new NodoAST("MOD1");
            $$->addHijo($1);
            $$->addHijo($2);
        };

MOD2 : identificador incremento{
            $$ = new NodoAST("MOD2");
            $$->addHijo($1);
            $$->addHijo($2);
        }
        | identificador decremento{
            $$ = new NodoAST("MOD2");
            $$->addHijo($1);
            $$->addHijo($2);
        };

%%
