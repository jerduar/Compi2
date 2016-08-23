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
#include <ventanaerrores.h>
#include <QListWidget>
#include <arbolj.h>
#include <QTimer>
#include <QCompleter>
#include <QStringListModel>

extern int yyrestart( FILE* archivo);//METODO QUE PASA EL ARCHIVO A FLEX
extern int yyparse(); //METODO QUE INICIA EL ANALISIS SINTACTICO

extern int jjrestart( FILE* archivo);//METODO QUE PASA EL ARCHIVO A FLEX
extern int jjparse(); //METODO QUE INICIA EL ANALISIS SINTACTICO
extern void setFila();
extern void setColumna();
extern int correctojson();

extern void jjsetFila();
extern void jjsetColumna();

extern void SetVentana(QListWidget *vista);
extern void SetVentanita(QListWidget *vista);
extern void SetVentana_json(QListWidget *vista);
extern void SetVentanita_json(QListWidget *vista);
extern ArbolJ *setArbolito();

extern ArbolAST* setArbol();//METODO PARA RETORNAR EL ARBOL AST

extern void setEdit(QTextEdit *edi);
void setEdit_jslt(QTextEdit *edi);

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

    void on_actionVer_Reportes_triggered();

    void on_actionVer_Reporte_JSON_triggered();

    void Prueba();

    void Analisis();

private:
    Ui::Ventana_Principal *ui;

    //ADMINISTRACIÓN DE ARCHIVOS
    void OpenFile();
    void GuardarComo();

    //VENTANAS DE ERROR
    VentanaErrores *errores;
    VentanaErrores *errores_json;

    //MÉTODOS DE ANÁLISIS
    void AnalisisJSON();
    void AnalisisJSLT();

    //AUTOCOMPLETADO
    QCompleter *completer;

    QAbstractItemModel *modelFromFile(const QString& fileName);
};

#endif // VENTANA_PRINCIPAL_H
