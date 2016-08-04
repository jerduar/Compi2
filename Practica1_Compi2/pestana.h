#ifndef PESTANA_H
#define PESTANA_H

#include <QFrame>
#include <QTextEdit>

namespace Ui {
class Pestana;
}

class Pestana : public QFrame
{
    Q_OBJECT

public:

    //METODOS
    explicit Pestana(QWidget *parent = 0);
    ~Pestana();
    QString enviar_texto();
    void SetTexto(QString nuevo_texto);

    QString getPath() const;
    void setPath(const QString &value);

private:
    Ui::Pestana *ui;
    //VARIABLES
    QString path;
};

#endif // PESTANA_H
