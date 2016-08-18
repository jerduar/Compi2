#include "ventanaerrores.h"
#include "ui_ventanaerrores.h"

VentanaErrores::VentanaErrores(QWidget *parent) :
    QFrame(parent),
    ui(new Ui::VentanaErrores)
{
    ui->setupUi(this);
}

VentanaErrores::~VentanaErrores()
{
    delete ui;
}

QListWidget *VentanaErrores::ven()
{
    return ui->listWidget;
}

void VentanaErrores::LimpiarVentana()
{
    ui->listWidget->clear();
}
