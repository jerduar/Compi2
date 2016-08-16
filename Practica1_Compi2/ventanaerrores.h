#ifndef VENTANAERRORES_H
#define VENTANAERRORES_H
#include <QListWidget>

#include <QFrame>

namespace Ui {
class VentanaErrores;
}

class VentanaErrores : public QFrame
{
    Q_OBJECT

public:
    explicit VentanaErrores(QWidget *parent = 0);
    ~VentanaErrores();
    QListWidget *ven();
    void LimpiarVentana();

private:
    Ui::VentanaErrores *ui;
};

#endif // VENTANAERRORES_H
