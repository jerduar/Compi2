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
