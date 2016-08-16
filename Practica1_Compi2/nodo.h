#ifndef NODO_H
#define NODO_H
#include <QList>
#include <QString>
#include <QTextStream>
#include <QStringList>

static int index_nodo = 0;//id para identificar los nodos, se usará en la graficación del árbol

struct Nodo
{
public:
    QList<Nodo*> *Hijos;
    QString Nombre;
    QString Valor;
    QString Tipo;
    int identificador;
    bool esPadre;
    
    Nodo();
    void Recorrido();
    void Visitar();
};

#endif // NODO_H
