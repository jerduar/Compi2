#-------------------------------------------------
#
# Project created by QtCreator 2016-07-27T01:37:25
#
#-------------------------------------------------

QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = Practica1_Compi2
TEMPLATE = app


SOURCES += main.cpp\
        ventana_principal.cpp \
        pestana.cpp\
        scanner.cpp\
        parser.cpp \
        nodo.cpp\
        parser2.cpp\
        scanner2.cpp


HEADERS  += ventana_principal.h \
    pestana.h\
    scanner.h\
    parser.h \
    nodo.h\
    parser2.h\
    scanner2.h


FORMS    += ventana_principal.ui \
    pestana.ui

OTHER_FILES += ALexico.l\
               ASintactico.y\
               Lexico_JSLT.l\
               Sintactico_JSLT.y
