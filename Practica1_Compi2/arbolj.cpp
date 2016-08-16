#include "arbolj.h"

ArbolJ::ArbolJ()
{
    this->raiz = NULL;
}

void ArbolJ::Recorrer(Nodo *raiz)
{
    if(raiz != NULL){
        int i;
        for(i = 0; i < raiz->Hijos->length(); i++){
            raiz->Hijos->at(i)->Visitar();
            Recorrer(raiz->Hijos->at(i));
        }
    }
}

void ArbolJ::Dibujar()
{
    Recorrer(this->raiz);
}
