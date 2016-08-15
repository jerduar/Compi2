#include "nodoast.h"

NodoAST::NodoAST()
{
    this->identificador = id++;
    this->Hijos = new QList<NodoAST*>;
}

NodoAST::NodoAST(QString etiqueta)
{
    this->identificador = id++;
    this->etiqueta = etiqueta;
    this->Hijos = new QList<NodoAST*>;
}

void NodoAST::addHijo(QString etiqueta)
{
    NodoAST *hijo =  new NodoAST(etiqueta);
    this->Hijos->append(hijo);
}

void NodoAST::addHijo(NodoAST *hijo)
{
    this->Hijos->append(hijo);
}
