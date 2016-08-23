%option noyywrap
%{
#include "parser2.h"
#include <iostream>
#include <QTextStream>
#include <QString>
#include <QListWidget>
#include <QTextEdit>

QListWidget *ventana;
void SetVentana(QListWidget *vista){
    ventana = vista;
}

QTextEdit *editor_jslt;
void setEdit_jslt(QTextEdit *edi){
    editor_jslt = edi;
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

"jsl"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return jslt; }

"transformacion"            { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return transformacion; }

"ruta"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return ruta; }

"version"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return version; }

"final"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return final; }

"<"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return break_a; }

">"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return break_c; }

"/"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return slash; }

"nombreObj"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return nombreobj; }


"asignar"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return asignar; }

"variable"                  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return variable; }

"valor"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return valor; }

"valor-de"                  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return valor_de; }

"para-cada"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return paracada; }

"if"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return si; }

"en-caso"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return encaso; }

"de"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return de; }

"cualquier-otro"            { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return cualquierotro; }

"seleccionar"               { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return seleccionar; }

"plantilla"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return plantilla; }

"plantilla-aplicar"         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return plantilla_aplicar; }

"condicion"                 { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return condicion; }

"="                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return igual ; }

"=="                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return igualigual; }

"!="                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return diferente; }

"&lt"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return menor_que; }

"&lte"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return menor_igual; }

"&gt"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return mayor_que; }

"&gte"                      { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return mayor_igual; }


"!¡"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return es_nulo; }

"||"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return oor; }

"&&"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return aand; }

"!&&"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return nand; }

"!||"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return nor; }

"&|"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return xxor; }

"!"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return nnot; }

"+"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return mas; }

"-"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);
if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return menos; }


"*"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return por; }

"div"                       { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return division; }

"%"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return modulo; }

"^"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return potencia; }

"++"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return incremento; }

"@"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}
return arroba; }

"@@"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return arroba_doble; }

"--"                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return decremento; }

"+="                        { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return suma_igual; }

"entero"                    { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return tipo_entero; }

"cadena"                    { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return tipo_cadena; }

"doble"                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);
if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return tipo_doble; }

"boolean"                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return tipo_bool; }

"caracter"                  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(255,128,0,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return tipo_char; }

"("                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return para; }

")"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return parc; }

{caracter}                  { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::yellow);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return caracter; }

"["                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return cora; }

"]"                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return corc; }

","                         { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::black).lighter(130);

    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return coma; }

{entero}                    { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(153,0,153,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return entero; }

{decimal}                   { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(153,0,153,255);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return decimal; }
{letra}                     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::yellow);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return cadena; }

{identificador}             { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::green);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

return identificador; }

{comentario_linea}          { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::gray);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}

}

{comentario_multilinea}     { columna_jslt=columna_jslt+strlen(jjlval.TEXT); strcpy(jjlval.TEXT, jjtext);

if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
{
    QColor color = QColor(Qt::gray);
    if(editor_jslt->find(yytext)){
        editor_jslt->setTextColor(color);
        editor_jslt->insertPlainText((QString)yytext);
    }
}


}
\n                          { columna_jslt = 1;fila_jslt = fila_jslt + 1; }
[\t\r]                      { columna_jslt = columna_jslt + 1; }
" "                         {columna_jslt = columna_jslt + 1; }
"   "                       {columna_jslt = columna_jslt + 1; }

 .                           {QString aux = "Error Lexico : " + (QString)jjtext + " fila : " + QString::number(fila_jslt) + " columna : " + QString::number(columna_jslt);
                             ventana->addItem(aux);

                             if(!editor_jslt->isReadOnly() && !editor_jslt->hasFocus())
                             {
                                 QColor color = QColor(Qt::red);
                                 if(editor_jslt->find(yytext)){
                                     editor_jslt->setTextColor(color);
                                     editor_jslt->insertPlainText((QString)yytext);
                                 }
                             }
                             }
%%
