/* A Bison parser, made by GNU Bison 3.0.4.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015 Free Software Foundation, Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

#ifndef YY_JJ_PARSER2_H_INCLUDED
# define YY_JJ_PARSER2_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int jjdebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    dospuntos = 258,
    jslt = 259,
    transformacion = 260,
    ruta = 261,
    version = 262,
    final = 263,
    break_a = 264,
    break_c = 265,
    slash = 266,
    asignar = 267,
    variable = 268,
    valor = 269,
    paracada = 270,
    si = 271,
    encaso = 272,
    de = 273,
    cualquierotro = 274,
    seleccionar = 275,
    plantilla = 276,
    condicion = 277,
    igualigual = 278,
    diferente = 279,
    menor_que = 280,
    menor_igual = 281,
    mayor_que = 282,
    mayor_igual = 283,
    es_nulo = 284,
    oor = 285,
    aand = 286,
    nand = 287,
    nor = 288,
    xxor = 289,
    nnot = 290,
    mas = 291,
    menos = 292,
    division = 293,
    por = 294,
    modulo = 295,
    potencia = 296,
    incremento = 297,
    decremento = 298,
    suma_igual = 299,
    tipo_entero = 300,
    tipo_cadena = 301,
    tipo_doble = 302,
    tipo_bool = 303,
    tipo_char = 304,
    cora = 305,
    corc = 306,
    coma = 307,
    cadena = 308,
    identificador = 309,
    falso = 310,
    verdadero = 311,
    decimal = 312,
    caracter = 313,
    entero = 314,
    igual = 315,
    nombreobj = 316,
    plantilla_aplicar = 317,
    para = 318,
    parc = 319
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 45 "Sintactico_JSLT.y" /* yacc.c:1909  */

//se especifican los tipo de valores para los no terminales y lo terminales
char TEXT [256];
struct Operador * VAL;
struct Nodo *NODE;

#line 126 "parser2.h" /* yacc.c:1909  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE jjlval;

int jjparse (void);

#endif /* !YY_JJ_PARSER2_H_INCLUDED  */
