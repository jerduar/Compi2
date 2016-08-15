#ifndef NODOAST_H
#define NODOAST_H

#include <QList>
#include <QString>

static int id = 0;

struct NodoAST
{
public:
    NodoAST();
    QList<NodoAST*> *Hijos;
    QString etiqueta;
    int identificador;
    NodoAST(QString etiqueta);
    void addHijo(QString etiqueta);
    void addHijo(NodoAST *hijo);

};

#endif // NODOAST_H
