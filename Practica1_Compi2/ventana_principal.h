#ifndef VENTANA_PRINCIPAL_H
#define VENTANA_PRINCIPAL_H

#include <QMainWindow>
#include <QDesktopWidget>
#include <QStyle>
#include <QString>
#include <QTextStream>
#include <QFileDialog>
#include <parser.h>
#include <QTextEdit>
#include <QFile>

extern int yyrestart( FILE* archivo);//METODO QUE PASA EL ARCHIVO A FLEX
extern int yyparse(); //METODO QUE INICIA EL ANALISIS SINTACTICO


namespace Ui {
class Ventana_Principal;
}

class Ventana_Principal : public QMainWindow
{
    Q_OBJECT

public:
    explicit Ventana_Principal(QWidget *parent = 0);
    ~Ventana_Principal();

private slots:

    void on_actionAbrir_triggered();

    void on_pushButton_clicked();

    void on_actionGenerar_HTML_triggered();

    void on_actionGuardar_triggered();

    void closeTab(const int& index);



    void on_bt_buscar_2_clicked();

    void on_tabWidget_tabCloseRequested(int index);

    void on_actionGuardar_Como_triggered();

    void on_bt_buscar_clicked();

private:
    Ui::Ventana_Principal *ui;
    void OpenFile();
};

#endif // VENTANA_PRINCIPAL_H
