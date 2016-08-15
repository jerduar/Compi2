#ifndef ARBOLAST_H
#define ARBOLAST_H
#include <nodoast.h>
#include <QTextStream>
#include <QFile>


class ArbolAST
{
public:
    ArbolAST();
    NodoAST *raiz;

    QString grafo;

    void Dibujar();
    void RecorridoDibujo(NodoAST *raiz);

};

#endif // ARBOLAST_H
