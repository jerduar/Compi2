#include "pestana.h"
#include "ui_pestana.h"

Pestana::Pestana(QWidget *parent) :
    QFrame(parent),
    ui(new Ui::Pestana)
{
    ui->setupUi(this);
    this->path = "";


}

Pestana::~Pestana()
{
    delete ui;
}

QString Pestana::enviar_texto()
{
    return ui->textEdit->toPlainText();
}

void Pestana::SetTexto(QString nuevo_texto)
{
    ui->textEdit->setText(nuevo_texto);
}

QString Pestana::getPath() const
{
    return path;
}

void Pestana::setPath(const QString &value)
{
    path = value;
}

void Pestana::fintText(QString texto_buscado)
{
    QList<QTextEdit::ExtraSelection> extraSelections;

        if(!ui->textEdit->isReadOnly())
        {
            QColor color = QColor(Qt::yellow).lighter(130);
            QTextEdit::ExtraSelection extra;

            ui->textEdit->find(texto_buscado);

                extra.format.setBackground(color);
                extra.cursor = ui->textEdit->textCursor();
                extraSelections.append(extra);
        }
        ui->textEdit->setExtraSelections(extraSelections);


}

void Pestana::repleaceAll(QString texto_buscado, QString reemplazo)
{
    QList<QTextEdit::ExtraSelection> extraSelections;

        if(!ui->textEdit->isReadOnly())
        {
            ui->textEdit->moveCursor(QTextCursor::Start);
            QColor color = QColor(Qt::yellow).lighter(130);
            QTextEdit::ExtraSelection extra;

            while(ui->textEdit->find(texto_buscado))
            {

                ui->textEdit->insertPlainText(reemplazo);
                extra.cursor = ui->textEdit->textCursor();
                extraSelections.append(extra);
            }
        }

        ui->textEdit->setExtraSelections(extraSelections);

}

void Pestana::repleace(QString reemplazo, QString texto_buscado)
{
    QList<QTextEdit::ExtraSelection> extraSelections;

        if(!ui->textEdit->isReadOnly())
        {
            QColor color = QColor(Qt::yellow).lighter(130);
            QTextEdit::ExtraSelection extra;

            if(ui->textEdit->find(texto_buscado)){
                extra.format.setBackground(color);
                ui->textEdit->insertPlainText(reemplazo);
                extra.cursor = ui->textEdit->textCursor();
                extraSelections.append(extra);
            }
        }
        ui->textEdit->setExtraSelections(extraSelections);
}

QTextEdit *Pestana::textedit()
{
    return ui->textEdit;
}
