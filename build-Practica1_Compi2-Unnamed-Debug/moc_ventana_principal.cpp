/****************************************************************************
** Meta object code from reading C++ file 'ventana_principal.h'
**
** Created by: The Qt Meta Object Compiler version 67 (Qt 5.5.1)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../Practica1_Compi2/ventana_principal.h"
#include <QtCore/qbytearray.h>
#include <QtCore/qmetatype.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'ventana_principal.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 67
#error "This file was generated using the moc from 5.5.1. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

QT_BEGIN_MOC_NAMESPACE
struct qt_meta_stringdata_Ventana_Principal_t {
    QByteArrayData data[8];
    char stringdata0[140];
};
#define QT_MOC_LITERAL(idx, ofs, len) \
    Q_STATIC_BYTE_ARRAY_DATA_HEADER_INITIALIZER_WITH_OFFSET(len, \
    qptrdiff(offsetof(qt_meta_stringdata_Ventana_Principal_t, stringdata0) + ofs \
        - idx * sizeof(QByteArrayData)) \
    )
static const qt_meta_stringdata_Ventana_Principal_t qt_meta_stringdata_Ventana_Principal = {
    {
QT_MOC_LITERAL(0, 0, 17), // "Ventana_Principal"
QT_MOC_LITERAL(1, 18, 24), // "on_actionAbrir_triggered"
QT_MOC_LITERAL(2, 43, 0), // ""
QT_MOC_LITERAL(3, 44, 21), // "on_pushButton_clicked"
QT_MOC_LITERAL(4, 66, 31), // "on_actionGenerar_HTML_triggered"
QT_MOC_LITERAL(5, 98, 26), // "on_actionGuardar_triggered"
QT_MOC_LITERAL(6, 125, 8), // "closeTab"
QT_MOC_LITERAL(7, 134, 5) // "index"

    },
    "Ventana_Principal\0on_actionAbrir_triggered\0"
    "\0on_pushButton_clicked\0"
    "on_actionGenerar_HTML_triggered\0"
    "on_actionGuardar_triggered\0closeTab\0"
    "index"
};
#undef QT_MOC_LITERAL

static const uint qt_meta_data_Ventana_Principal[] = {

 // content:
       7,       // revision
       0,       // classname
       0,    0, // classinfo
       5,   14, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // slots: name, argc, parameters, tag, flags
       1,    0,   39,    2, 0x08 /* Private */,
       3,    0,   40,    2, 0x08 /* Private */,
       4,    0,   41,    2, 0x08 /* Private */,
       5,    0,   42,    2, 0x08 /* Private */,
       6,    1,   43,    2, 0x08 /* Private */,

 // slots: parameters
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void,
    QMetaType::Void, QMetaType::Int,    7,

       0        // eod
};

void Ventana_Principal::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        Ventana_Principal *_t = static_cast<Ventana_Principal *>(_o);
        Q_UNUSED(_t)
        switch (_id) {
        case 0: _t->on_actionAbrir_triggered(); break;
        case 1: _t->on_pushButton_clicked(); break;
        case 2: _t->on_actionGenerar_HTML_triggered(); break;
        case 3: _t->on_actionGuardar_triggered(); break;
        case 4: _t->closeTab((*reinterpret_cast< const int(*)>(_a[1]))); break;
        default: ;
        }
    }
}

const QMetaObject Ventana_Principal::staticMetaObject = {
    { &QMainWindow::staticMetaObject, qt_meta_stringdata_Ventana_Principal.data,
      qt_meta_data_Ventana_Principal,  qt_static_metacall, Q_NULLPTR, Q_NULLPTR}
};


const QMetaObject *Ventana_Principal::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *Ventana_Principal::qt_metacast(const char *_clname)
{
    if (!_clname) return Q_NULLPTR;
    if (!strcmp(_clname, qt_meta_stringdata_Ventana_Principal.stringdata0))
        return static_cast<void*>(const_cast< Ventana_Principal*>(this));
    return QMainWindow::qt_metacast(_clname);
}

int Ventana_Principal::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QMainWindow::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 5)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 5;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 5)
            *reinterpret_cast<int*>(_a[0]) = -1;
        _id -= 5;
    }
    return _id;
}
QT_END_MOC_NAMESPACE
