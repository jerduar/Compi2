#include "arbolj.h"

ArbolJ::ArbolJ()
{
    this->raiz = NULL;
}

void ArbolJ::Recorrer(Nodo *raiz)
{
    if(raiz != NULL){
        //DECLARACIÓN DEL NODO
        grafo += "nodo" + QString::number(raiz->identificador) + "[label=" + raiz->Nombre + "];\n";

        int i;
        for(i = 0; i < raiz->Hijos->length(); i++){
            raiz->Hijos->at(i)->Visitar();
            Recorrer(raiz->Hijos->at(i));
            grafo += "nodo" + QString::number(raiz->identificador) + "--nodo" + QString::number(raiz->Hijos->at(i)->identificador) + ";\n";
        }
    }
}

void ArbolJ::Dibujar()
{
    this->grafo = "graph g{\n";
    Recorrer(this->raiz);
    grafo += "}";
    QTextStream(stdout) << grafo << endl;

    QFile archivo("grafo_json.dot");
    archivo.open(QIODevice::WriteOnly);

    QTextStream buffer(&archivo);

    buffer << grafo;
    archivo.close();
    system("dot -Tpng grafo_json.dot -o grafo_json.png");
    //system("run-mailcap grafo_json.png");
}
