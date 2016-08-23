#include "pestana.h"
#include "ui_pestana.h"

Pestana::Pestana(QWidget *parent) :
    QFrame(parent),
    ui(new Ui::Pestana)
{
    ui->setupUi(this);
    this->path = "";

    ui->textEdit->setPlainText(tr("This TextEdit provides autocompletions for words that have more than"
                        " 3 characters. You can trigger autocompletion using ") +
                        QKeySequence("Ctrl+E").toString(QKeySequence::NativeText));


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

void Pestana::setCompleter(QCompleter *completer)
{
    if(c)
        QObject::disconnect(c,0,this,0);

    c = completer;

    if(!c)
        return;

    c->setWidget(this);
    c->setCompletionMode(QCompleter::PopupCompletion);
    c->setCaseSensitivity(Qt::CaseInsensitive);
    QObject::connect(c,SIGNAL(activated(QString)),this,SLOT(insertCompletion(QString)));
}

QCompleter *Pestana::completer() const
{
    return c;
}

void Pestana::keyPressEvent(QKeyEvent *e)
{
    if(c && c->popup()->isVisible()){
        switch(e->key()){
        case Qt::Key_Enter:
        case Qt::Key_Return:
        case Qt::Key_Escape:
        case Qt::Key_Tab:
        case Qt::Key_Backtab:
            e->ignore();
            return;
        default:
            break;
        }
    }

    bool isShortcut = ((e->modifiers() & Qt::ControlModifier) && e->key() == Qt::Key_E);
    if(!c || !isShortcut)
        QFrame::keyPressEvent(e);
}

void Pestana::focusInEvent(QFocusEvent *e)
{
    if(c)
        c->setWidget(this);
    QFrame::focusInEvent(e);
}

void Pestana::insertCompletion(const QString &completion)
{
    if(c->widget() != this)
        return;

    QTextCursor tc = textedit()->textCursor();
    int extra = completion.length() - c->completionPrefix().length();
    tc.movePosition(QTextCursor::Left);
    tc.insertText(completion.right(extra));
    textedit()->setTextCursor(tc);
}

QString Pestana::textUnderCursor() const
{
    QTextCursor tc = ui->textEdit->textCursor();
    tc.select(QTextCursor::WordUnderCursor);
    return tc.selectedText();
}
