#include "nodo.h"

Nodo::Nodo()
{
    this->Valor = "nulo";
    this->Tipo = "nulo";
    this->Hijos = new QList<Nodo*>;
    this->esPadre = false;
    this->Nombre = "null";
    this->identificador = index_nodo++;
}

void Nodo::Recorrido()
{
    QTextStream(stdout) << "recorrido" << endl;
    for(int i = 0; i < this->Hijos->size(); i++){
        this->Hijos->at(i)->Visitar();
        this->Hijos->at(i)->Recorrido();
    }
}

void Nodo::Visitar()
{
    QTextStream(stdout) << this->Nombre + ": " + this->Valor << endl;
}
