#include "ventana_principal.h"
#include <QApplication>

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    Ventana_Principal w;
    w.show();

    return a.exec();
}
