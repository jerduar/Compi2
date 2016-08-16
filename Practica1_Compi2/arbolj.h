#ifndef ARBOLJ_H
#define ARBOLJ_H
#include <nodo.h>
#include <QFile>


class ArbolJ
{
public:
    ArbolJ();
    Nodo *raiz;
    QString grafo;
    void Recorrer(Nodo *raiz);
    void Dibujar();


};

#endif // ARBOLJ_H
