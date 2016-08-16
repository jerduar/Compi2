#include "ventana_principal.h"
#include "ui_ventana_principal.h"
#include <pestana.h>
#include <QMessageBox>

Ventana_Principal::Ventana_Principal(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::Ventana_Principal)
{

    ui->setupUi(this);
    ui->tabWidget->setTabsClosable(true);
    connect(ui->tabWidget, SIGNAL(tabCloseRequested(int)),this,SLOT(closeTab(int)));
    this->errores = new VentanaErrores();
    this->errores_json = new VentanaErrores();

}

Ventana_Principal::~Ventana_Principal()
{
    delete ui;
    this->setGeometry(
        QStyle::alignedRect(
            Qt::LeftToRight,
            Qt::AlignCenter,
            this->size(),
            qApp->desktop()->availableGeometry()
        ));

}

void Ventana_Principal::on_actionAbrir_triggered()
{
    OpenFile();
}

void Ventana_Principal::closeTab(const int& index)
{
    if(index == -1){
        return;
    }

    QWidget *widget = ui->tabWidget->widget(index);

    ui->tabWidget->removeTab(index);

    delete(widget);

    widget = NULL;
}


void Ventana_Principal::OpenFile()
{

    int index;
    QString path = QFileDialog::getOpenFileName(this,tr("ABRIR ARCHIVOS"), "/home/jerduar", tr("ARCHIVOS (*.json *.jslt)"));
    if(path != ""){
        QStringList lista = path.split("/");
        index = ui->tabWidget->addTab(new Pestana(),lista[ lista.length() - 1]);
        QFile archivo(path);
        archivo.open(QIODevice::ReadOnly);
        QTextStream buffer(&archivo);



        //AGREGA EL TEXTO DEL ARCHIVO EN LA TAB INGRESADA
        Pestana *nueva = (Pestana*)ui->tabWidget->widget(index);
        nueva->setPath(path);
        if(nueva != NULL){
            nueva->SetTexto((QString)buffer.readAll());
            buffer.seek(0);
        }
            archivo.close();
    }
}

void Ventana_Principal::GuardarComo()
{
    Pestana *actual = (Pestana*)ui->tabWidget->currentWidget();

    if(actual != NULL){
        QString path = QFileDialog::getSaveFileName(this,tr("ABRIR ARCHIVOS"), "/home/jerduar", tr("JSON (*.json);;JSLT(*.jslt)"));

        if(path != ""){
            QFile archivo(path);
            archivo.open(QIODevice::WriteOnly);

            QTextStream buffer(&archivo);
            QString texto = actual->enviar_texto();
            actual->setPath(path);

            buffer << texto;
            archivo.close();
        }


    }else{
        QMessageBox::information(this,"Guarda","No hay ninguna pestaña seleccionada");
    }
}

void Ventana_Principal::on_pushButton_clicked()
{

}

void Ventana_Principal::on_actionGenerar_HTML_triggered()
{
    Pestana *actual = (Pestana*)ui->tabWidget->currentWidget();

    if(actual != NULL){
        QFile file("temp.txt"); //SE CREA UN ARCHIVO TEMPORAL PARA COMPILARLO
        if ( file.open( file.WriteOnly ) ) { //BUFFER PARA EL TEXTO QUE SE DESEA COMPILAR
            QTextStream stream1( &file );
            stream1 << actual->enviar_texto();
        }

        const char* x = "temp.txt";
        FILE* input = fopen(x, "r" );

        errores_json->ven()->clear();
        SetVentanita_json(errores_json->ven());
        setFila();
        setColumna();
        yyrestart(input);//SE PASA LA CADENA DE ENTRADA A FLEX
        yyparse();//SE INICIA LA COMPILACION
        QTextStream(stdout) << "termino el json" << endl;


        ArbolJ *nuevo = setArbolito();
        if(nuevo != NULL && correctojson() != 1){
            nuevo->Dibujar();
        }
    }

}

void Ventana_Principal::on_actionGuardar_triggered()
{
    Pestana *pestana = (Pestana*)ui->tabWidget->currentWidget();

    if(pestana != NULL){
        if(pestana->getPath() != ""){

            QFile file(pestana->getPath());
            file.open(QIODevice::WriteOnly | QIODevice::Truncate);
            QString texto = pestana->enviar_texto();
            QTextStream buffer(&file);

            buffer << texto;
            file.close();
        }else{
            GuardarComo();
        }
    }

}

void Ventana_Principal::on_bt_buscar_2_clicked()
{
    ui->tabWidget->addTab(new Pestana(),"Nueva");
}

void Ventana_Principal::on_tabWidget_tabCloseRequested(int index)
{

}

void Ventana_Principal::on_actionGuardar_Como_triggered()
{
    this->GuardarComo();

}

void Ventana_Principal::on_bt_buscar_clicked()
{
    Pestana *actual = (Pestana*)ui->tabWidget->currentWidget();

    if(actual != NULL){
        actual->fintText(ui->lineEdit->text());
    }
}

void Ventana_Principal::on_bt_reemplazarAll_clicked()
{
    Pestana *actual = (Pestana*)ui->tabWidget->currentWidget();

    if(actual != NULL){
        actual->repleaceAll(ui->lineEdit->text(),ui->lineEdit_2->text());
    }
}

void Ventana_Principal::on_bt_reemplazar_clicked()
{
    Pestana *actual = (Pestana*)ui->tabWidget->currentWidget();

    if(actual != NULL){
        actual->repleace(ui->lineEdit_2->text(),ui->lineEdit->text());
    }
}

void Ventana_Principal::on_bt_buscar_3_clicked()
{
    Pestana *actual = (Pestana*)ui->tabWidget->currentWidget();

    if(actual != NULL){
        QFile file("temp2.txt"); //SE CREA UN ARCHIVO TEMPORAL PARA COMPILARLO
        if ( file.open( file.WriteOnly ) ) { //BUFFER PARA EL TEXTO QUE SE DESEA COMPILAR
            QTextStream stream1( &file );
            stream1 << actual->enviar_texto();
        }


        const char* x = "temp2.txt";
        FILE* input = fopen(x, "r" );
        this->errores->ven()->clear();
        SetVentana(this->errores->ven());
        SetVentanita(this->errores->ven());
        jjsetFila();
        jjsetColumna();
        jjrestart(input);//SE PASA LA CADENA DE ENTRADA A FLEX
        jjparse();//SE INICIA LA COMPILACION


        ArbolAST *nuevo;
        nuevo = setArbol();
        if(nuevo != NULL){
            QTextStream(stdout) << "Dibujando" << endl;
            nuevo->Dibujar();
        }else{
            QMessageBox::information(this,"ÁRBOL","El árbol es nulo");
        }
    }
}

void Ventana_Principal::on_actionVer_Reportes_triggered()
{
    this->errores->setVisible(true);
}

void Ventana_Principal::on_actionVer_Reporte_JSON_triggered()
{
    this->errores_json->setVisible(true);
}
