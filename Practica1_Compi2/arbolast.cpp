#include "arbolast.h"

ArbolAST::ArbolAST()
{
    this->raiz = NULL;
}

void ArbolAST::Dibujar()
{
    this->grafo = "graph g{\n ";
    this->RecorridoDibujo(raiz);
    this->grafo += "}";
    //QTextStream(stdout) << grafo << endl;

    QFile archivo("grafo.dot");
    archivo.open(QIODevice::WriteOnly);

    QTextStream buffer(&archivo);

    buffer << grafo;
    archivo.close();
    system("dot -Tpng grafo.dot -o grafo.png");
    system("run-mailcap grafo.png");
}

void ArbolAST::RecorridoDibujo(NodoAST *raiz)
{
    if(raiz != NULL){

        grafo += "nodo" + QString::number(raiz->identificador) + "[label=\"" + raiz->etiqueta + "\"];\n";
        int index;
        for(index = 0; index < raiz->Hijos->length(); index++){
            RecorridoDibujo(raiz->Hijos->at(index));
            grafo += "nodo" + QString::number(raiz->identificador) + "--nodo" + QString::number(raiz->Hijos->at(index)->identificador) + ";\n";
        }
    }
}
