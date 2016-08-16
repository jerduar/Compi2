%{
#include "scanner.h"//se importa el header del analisis sintactico
#include <iostream> //libreria para imprimir en cosola de C
#include <QString> //libreria para manejo de STRINGS de QT
#include <QTextStream>
#include <QStringList>
#include <arbolj.h>
#include <nodo.h>//OBJETO PARA ALMECENAR LOS ATRIBUTOS DE LOS OBJETOS
#include <QHash> //Libreria para manejar HASH TABLES de QT, se usa para la tabla de simbolos
#include <QListWidget>
#include <QTextEdit> //libreria QTextEdit de QT para poder mostrar el resultado en pantalla

extern int fila; //linea actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern int columna; //columna actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern char *yytext; //lexema actual donde esta el parser (analisis lexico) lo maneja BISON

int correcto_json = 1;

extern int correctojson(){
    return correcto_json;
}

QListWidget *ventanita_json;

void SetVentanita_json(QListWidget *ven){
    ventanita_json = ven;
}

int yyerror(const char* mens){
//metodo que se llama al haber un error sintactico
//SE IMPRIME EN CONSOLA EL ERROR
std::cout <<mens<<" error: "<<yytext << " linea: " << fila << " columna: " << columna << std::endl;
QTextStream(stdout) << "INGRESANDO ERROR" << endl;
ventanita_json->addItem("Error Sintactico : " + (QString)yytext + " linea: " + fila + " columna: " + QString::number(columna - strlen(yytext)));
QTextStream(stdout) << "ERROR ingresado" << endl;
return 0;
}

ArbolJ *arbolito;
ArbolJ *setArbolito(){
    return arbolito;
}

QTextEdit* salida; //puntero al QTextEdit de salida
void setSalida(QTextEdit* sal) {
//metodo que asigna el valor al QTextEdit de salida
salida=sal;
}

void setFila(){
    fila = 1;
}

void setColumna(){
    columna = 1;
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
%type<NODE>  S
%type<NODE>  J
%type<NODE>  O
%type<NODE>  LA
%type<NODE>  A
%type<NODE>  AO
%type<NODE>  L
%type<NODE>  LV
%type<NODE> LO
%type<TEXT> VALOR

%left comilla
%%

S : J{
        if($1 != NULL){
        arbolito = new ArbolJ();
        arbolito->raiz = $1;
        }else{
        arbolito = NULL;
        }
     }
    | error{yyerror; correcto_json = 1; QTextStream(stdout) << "termino el error4 " << endl;arbolito = NULL;};

J : llavea LO llavec{$$ = $2;};

LO : LO coma O{$1->Hijos->append($3);$$ = $1;}
    | O{$$ = new Nodo();$$->Hijos->append($1);/*$$->Recorrido();*/};


O : cadena dospuntos llavea LA llavec {
                                        QTextStream(stdout) << "Produccion AO" << endl;
                                        $$ = $4;
                                        $$->Nombre = $1;
                                        //$$->Recorrido();
                                      }
    | cadena dospuntos cora AO corc{
                                    QTextStream(stdout) << "Produccion AO" << endl;
                                    $$ = $4;
                                    $$->Nombre = $1;
                                   }
    | cadena dospuntos cora LV corc{$$ = $4; $$->Nombre = $1;}

    | error{yyerror; correcto_json = 1;};

LA : LA coma A{$1->Hijos->append($3);$$ = $1;QTextStream(stdout) <<  "PRDUCCION LA COMA A" << endl;}
    | A{/*QTextStream(stdout) << $1->Valor << endl;*/ $$ = new Nodo(); $$->Hijos->append($1);};


LV : LV coma VALOR{Nodo *hijo = new Nodo(); hijo->Valor = $3; $$->Hijos->append(hijo);}
    | VALOR{$$ = new Nodo(); Nodo *hijo = new Nodo(); hijo->Valor = $1; $$->Hijos->append(hijo);};

A : cadena dospuntos VALOR{$$ = new Nodo(); $$->Valor = $3; $$->Nombre = $1;}
    | O {$$ = $1;};


AO : AO coma L{$1->Hijos->append($3); $$ = $1;QTextStream(stdout) << "PRODUCCION AO COM L" << endl;}
    | L{$$ = new Nodo(); $$->Hijos->append($1); };

L : llavea LA llavec{$$ = $2; QTextStream(stdout) << "PRODUCCION" << endl;};

VALOR : cadena {/*QTextStream(stdout) << "cadena" << endl;*/strcmp($$,$1);strcat($$,":cadena");}
    | decimal{/*QTextStream(stdout) << "decimal" << endl;*/strcmp($$,$1);strcat($$,":decimal");}
    | entero {/*QTextStream(stdout) << "entero" << endl;*/strcmp($$,$1);strcat($$,":entero");}
    | verdadero {/*QTextStream(stdout) << "verdadero" << endl;*/ strcmp($$,$1);strcat($$,":verdadero");}
    | falso{/*QTextStream(stdout) << "falso" << endl;*/ strcmp($$,$1);strcat($$,":falso");}
    | error{yyerror; correcto_json = 1;};
%%
