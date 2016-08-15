#ifndef VENTANA_PRINCIPAL_H
#define VENTANA_PRINCIPAL_H

#include <QMainWindow>
#include <QDesktopWidget>
#include <QStyle>
#include <QString>
#include <QTextStream>
#include <QFileDialog>
#include <parser.h>
#include <parser2.h>
#include <QTextEdit>
#include <QFile>
#include <nodoast.h>
#include <arbolast.h>

extern int yyrestart( FILE* archivo);//METODO QUE PASA EL ARCHIVO A FLEX
extern int yyparse(); //METODO QUE INICIA EL ANALISIS SINTACTICO

extern int jjrestart( FILE* archivo);//METODO QUE PASA EL ARCHIVO A FLEX
extern int jjparse(); //METODO QUE INICIA EL ANALISIS SINTACTICO
extern void setFila();
extern void setColumna();

extern void jjsetFila();
extern void jjsetColumna();

extern ArbolAST* setArbol();//METODO PARA RETORNAR EL ARBOL AST


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


    void on_bt_reemplazarAll_clicked();

    void on_bt_reemplazar_clicked();

    void on_bt_buscar_3_clicked();

private:
    Ui::Ventana_Principal *ui;
    void OpenFile();
    void GuardarComo();
};

#endif // VENTANA_PRINCIPAL_H
