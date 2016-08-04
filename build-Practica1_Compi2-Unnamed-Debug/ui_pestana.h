/********************************************************************************
** Form generated from reading UI file 'pestana.ui'
**
** Created by: Qt User Interface Compiler version 5.5.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_PESTANA_H
#define UI_PESTANA_H

#include <QtCore/QVariant>
#include <QtWidgets/QAction>
#include <QtWidgets/QApplication>
#include <QtWidgets/QButtonGroup>
#include <QtWidgets/QFrame>
#include <QtWidgets/QHeaderView>
#include <QtWidgets/QTextEdit>

QT_BEGIN_NAMESPACE

class Ui_Pestana
{
public:
    QTextEdit *textEdit;

    void setupUi(QFrame *Pestana)
    {
        if (Pestana->objectName().isEmpty())
            Pestana->setObjectName(QStringLiteral("Pestana"));
        Pestana->resize(860, 509);
        Pestana->setFrameShape(QFrame::StyledPanel);
        Pestana->setFrameShadow(QFrame::Raised);
        textEdit = new QTextEdit(Pestana);
        textEdit->setObjectName(QStringLiteral("textEdit"));
        textEdit->setEnabled(true);
        textEdit->setGeometry(QRect(10, 10, 841, 481));
        textEdit->setFocusPolicy(Qt::ClickFocus);

        retranslateUi(Pestana);

        QMetaObject::connectSlotsByName(Pestana);
    } // setupUi

    void retranslateUi(QFrame *Pestana)
    {
        Pestana->setWindowTitle(QApplication::translate("Pestana", "Frame", 0));
    } // retranslateUi

};

namespace Ui {
    class Pestana: public Ui_Pestana {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_PESTANA_H
