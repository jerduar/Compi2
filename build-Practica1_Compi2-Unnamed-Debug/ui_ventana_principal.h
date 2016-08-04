/********************************************************************************
** Form generated from reading UI file 'ventana_principal.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_VENTANA_PRINCIPAL_H
#define UI_VENTANA_PRINCIPAL_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QMainWindow>
#include <QtWidgets/QMenu>
#include <QtWidgets/QMenuBar>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QStatusBar>
#include <QtWidgets/QTabWidget>
#include <QtWidgets/QWidget>

QT_BEGIN_NAMESPACE

class Ui_Ventana_Principal
{
public:
    QAction *actionNuevo_Archivo_JSON;
    QAction *actionNuevo_Archivo_JSLT;
    QAction *actionGuardar_Como;
    QAction *actionGuardar;
    QAction *actionAbrir;
    QAction *actionVer_Reportes;
    QAction *actionGenerar_HTML;
    QWidget *centralWidget;
    QTabWidget *tabWidget;
    QLineEdit *lineEdit;
    QLineEdit *lineEdit_2;
    QPushButton *bt_buscar;
    QPushButton *bt_reemplazar;
    QPushButton *bt_reemplazarAll;
    QPushButton *bt_buscar_2;
    QMenuBar *menuBar;
    QMenu *menuArchivo;
    QMenu *menuGenerar;
    QMenu *menuErrores;
    QStatusBar *statusBar;

    void setupUi(QMainWindow *Ventana_Principal)
    {
        if (Ventana_Principal->objectName().isEmpty())
            Ventana_Principal->setObjectName(QStringLiteral("Ventana_Principal"));
        Ventana_Principal->setWindowModality(Qt::NonModal);
        Ventana_Principal->resize(1061, 586);
        Ventana_Principal->setMinimumSize(QSize(1061, 586));
        Ventana_Principal->setMaximumSize(QSize(1061, 586));
        Ventana_Principal->setUnifiedTitleAndToolBarOnMac(false);
        actionNuevo_Archivo_JSON = new QAction(Ventana_Principal);
        actionNuevo_Archivo_JSON->setObjectName(QStringLiteral("actionNuevo_Archivo_JSON"));
        actionNuevo_Archivo_JSLT = new QAction(Ventana_Principal);
        actionNuevo_Archivo_JSLT->setObjectName(QStringLiteral("actionNuevo_Archivo_JSLT"));
        actionGuardar_Como = new QAction(Ventana_Principal);
        actionGuardar_Como->setObjectName(QStringLiteral("actionGuardar_Como"));
        actionGuardar = new QAction(Ventana_Principal);
        actionGuardar->setObjectName(QStringLiteral("actionGuardar"));
        actionAbrir = new QAction(Ventana_Principal);
        actionAbrir->setObjectName(QStringLiteral("actionAbrir"));
        actionVer_Reportes = new QAction(Ventana_Principal);
        actionVer_Reportes->setObjectName(QStringLiteral("actionVer_Reportes"));
        actionGenerar_HTML = new QAction(Ventana_Principal);
        actionGenerar_HTML->setObjectName(QStringLiteral("actionGenerar_HTML"));
        centralWidget = new QWidget(Ventana_Principal);
        centralWidget->setObjectName(QStringLiteral("centralWidget"));
        tabWidget = new QTabWidget(centralWidget);
        tabWidget->setObjectName(QStringLiteral("tabWidget"));
        tabWidget->setGeometry(QRect(10, 10, 861, 531));
        tabWidget->setTabsClosable(false);
        tabWidget->setMovable(true);
        lineEdit = new QLineEdit(centralWidget);
        lineEdit->setObjectName(QStringLiteral("lineEdit"));
        lineEdit->setGeometry(QRect(890, 130, 161, 31));
        lineEdit_2 = new QLineEdit(centralWidget);
        lineEdit_2->setObjectName(QStringLiteral("lineEdit_2"));
        lineEdit_2->setGeometry(QRect(890, 170, 161, 31));
        bt_buscar = new QPushButton(centralWidget);
        bt_buscar->setObjectName(QStringLiteral("bt_buscar"));
        bt_buscar->setGeometry(QRect(890, 210, 161, 31));
        bt_reemplazar = new QPushButton(centralWidget);
        bt_reemplazar->setObjectName(QStringLiteral("bt_reemplazar"));
        bt_reemplazar->setGeometry(QRect(890, 250, 161, 31));
        bt_reemplazarAll = new QPushButton(centralWidget);
        bt_reemplazarAll->setObjectName(QStringLiteral("bt_reemplazarAll"));
        bt_reemplazarAll->setGeometry(QRect(890, 290, 161, 31));
        bt_buscar_2 = new QPushButton(centralWidget);
        bt_buscar_2->setObjectName(QStringLiteral("bt_buscar_2"));
        bt_buscar_2->setGeometry(QRect(890, 90, 161, 31));
        Ventana_Principal->setCentralWidget(centralWidget);
        menuBar = new QMenuBar(Ventana_Principal);
        menuBar->setObjectName(QStringLiteral("menuBar"));
        menuBar->setGeometry(QRect(0, 0, 1061, 19));
        menuArchivo = new QMenu(menuBar);
        menuArchivo->setObjectName(QStringLiteral("menuArchivo"));
        menuGenerar = new QMenu(menuBar);
        menuGenerar->setObjectName(QStringLiteral("menuGenerar"));
        menuErrores = new QMenu(menuBar);
        menuErrores->setObjectName(QStringLiteral("menuErrores"));
        Ventana_Principal->setMenuBar(menuBar);
        statusBar = new QStatusBar(Ventana_Principal);
        statusBar->setObjectName(QStringLiteral("statusBar"));
        Ventana_Principal->setStatusBar(statusBar);

        menuBar->addAction(menuArchivo->menuAction());
        menuBar->addAction(menuGenerar->menuAction());
        menuBar->addAction(menuErrores->menuAction());
        menuArchivo->addAction(actionNuevo_Archivo_JSON);
        menuArchivo->addAction(actionNuevo_Archivo_JSLT);
        menuArchivo->addAction(actionGuardar_Como);
        menuArchivo->addAction(actionGuardar);
        menuArchivo->addAction(actionAbrir);
        menuGenerar->addAction(actionGenerar_HTML);
        menuErrores->addAction(actionVer_Reportes);

        retranslateUi(Ventana_Principal);

        tabWidget->setCurrentIndex(-1);


        QMetaObject::connectSlotsByName(Ventana_Principal);
    } // setupUi

    void retranslateUi(QMainWindow *Ventana_Principal)
    {
        Ventana_Principal->setWindowTitle(QApplication::translate("Ventana_Principal", "Editor J2H", 0));
        actionNuevo_Archivo_JSON->setText(QApplication::translate("Ventana_Principal", "Nuevo Archivo JSON", 0));
        actionNuevo_Archivo_JSLT->setText(QApplication::translate("Ventana_Principal", "Nuevo Archivo JSLT", 0));
        actionGuardar_Como->setText(QApplication::translate("Ventana_Principal", "Guardar Como", 0));
        actionGuardar->setText(QApplication::translate("Ventana_Principal", "Guardar", 0));
        actionAbrir->setText(QApplication::translate("Ventana_Principal", "Abrir", 0));
        actionVer_Reportes->setText(QApplication::translate("Ventana_Principal", "Ver Reportes", 0));
        actionGenerar_HTML->setText(QApplication::translate("Ventana_Principal", "Generar HTML", 0));
        bt_buscar->setText(QApplication::translate("Ventana_Principal", "BUSCAR", 0));
        bt_reemplazar->setText(QApplication::translate("Ventana_Principal", "REEMPLAZAR", 0));
        bt_reemplazarAll->setText(QApplication::translate("Ventana_Principal", "REEMPLAZAR TODO", 0));
        bt_buscar_2->setText(QApplication::translate("Ventana_Principal", "NUEVA PESTA\303\221A", 0));
        menuArchivo->setTitle(QApplication::translate("Ventana_Principal", "Archivo", 0));
        menuGenerar->setTitle(QApplication::translate("Ventana_Principal", "Generar", 0));
        menuErrores->setTitle(QApplication::translate("Ventana_Principal", "Errores", 0));
    } // retranslateUi

};

namespace Ui {
    class Ventana_Principal: public Ui_Ventana_Principal {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_VENTANA_PRINCIPAL_H
