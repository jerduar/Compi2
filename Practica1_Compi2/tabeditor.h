#ifndef TABEDITOR_H
#define TABEDITOR_H

#include <QTabWidget>

namespace Ui {
class TabEditor;
}

class TabEditor : public QTabWidget
{
    Q_OBJECT

public:
    explicit TabEditor(QWidget *parent = 0);
    ~TabEditor();

private:
    Ui::TabEditor *ui;
};

#endif // TABEDITOR_H
