#ifndef PESTANA_H
#define PESTANA_H

#include <QFrame>
#include <QTextEdit>
#include <QCompleter>
#include <QFocusEvent>
#include <QKeyEvent>

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

    void fintText(QString texto_buscado);

    void repleaceAll(QString texto_buscado, QString reemplazo);

    void repleace(QString reemplazo, QString texto_buscado);

    QTextEdit *textedit();

    //AUTOCOMPLETADO
    void setCompleter(QCompleter *completer);
    QCompleter *completer() const;

protected:
    void keyPressEvent(QKeyEvent *e) Q_DECL_OVERRIDE;
    void focusInEvent(QFocusEvent *e) Q_DECL_OVERRIDE;

private slots:
    void insertCompletion(const QString &completion);


private:
    Ui::Pestana *ui;
    //VARIABLES
    QString path;

    //AUTOCOMPLETADO
    QCompleter *c;
    QString textUnderCursor() const;
};

#endif // PESTANA_H
