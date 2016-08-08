#ifndef NODO_H
#define NODO_H
#include <QList>
#include <QString>
#include <QTextStream>
#include <QStringList>


struct Nodo
{
public:
    QList<Nodo*> *Hijos;
    QString Nombre;
    QString Valor;
    QString Tipo;
    bool esPadre;
    
    Nodo();
    void Recorrido();
    void Visitar();
};

#endif // NODO_H
