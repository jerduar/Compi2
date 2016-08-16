/********************************************************************************
** Form generated from reading UI file 'ventanaerrores.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_VENTANAERRORES_H
#define UI_VENTANAERRORES_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QFrame>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QLabel>
#include <QtWidgets/QListWidget>

QT_BEGIN_NAMESPACE

class Ui_VentanaErrores
{
public:
    QLabel *label;
    QListWidget *listWidget;

    void setupUi(QFrame *VentanaErrores)
    {
        if (VentanaErrores->objectName().isEmpty())
            VentanaErrores->setObjectName(QStringLiteral("VentanaErrores"));
        VentanaErrores->resize(638, 300);
        VentanaErrores->setFrameShape(QFrame::StyledPanel);
        VentanaErrores->setFrameShadow(QFrame::Raised);
        label = new QLabel(VentanaErrores);
        label->setObjectName(QStringLiteral("label"));
        label->setGeometry(QRect(20, 23, 321, 31));
        QFont font;
        font.setPointSize(16);
        label->setFont(font);
        listWidget = new QListWidget(VentanaErrores);
        listWidget->setObjectName(QStringLiteral("listWidget"));
        listWidget->setGeometry(QRect(20, 80, 591, 192));

        retranslateUi(VentanaErrores);

        QMetaObject::connectSlotsByName(VentanaErrores);
    } // setupUi

    void retranslateUi(QFrame *VentanaErrores)
    {
        VentanaErrores->setWindowTitle(QApplication::translate("VentanaErrores", "Frame", 0));
        label->setText(QApplication::translate("VentanaErrores", "ERRORES ENCONTRADOS", 0));
    } // retranslateUi

};

namespace Ui {
    class VentanaErrores: public Ui_VentanaErrores {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_VENTANAERRORES_H
