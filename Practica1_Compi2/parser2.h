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
    para_cada = 268,
    variable = 269,
    valor = 270,
    paracada = 271,
    si = 272,
    encaso = 273,
    de = 274,
    cualquierotro = 275,
    seleccionar = 276,
    plantilla = 277,
    condicion = 278,
    igualigual = 279,
    diferente = 280,
    menor_que = 281,
    menor_igual = 282,
    mayor_que = 283,
    mayor_igual = 284,
    es_nulo = 285,
    oor = 286,
    aand = 287,
    nand = 288,
    nor = 289,
    xxor = 290,
    nnot = 291,
    mas = 292,
    menos = 293,
    division = 294,
    por = 295,
    modulo = 296,
    potencia = 297,
    incremento = 298,
    decremento = 299,
    suma_igual = 300,
    tipo_entero = 301,
    tipo_cadena = 302,
    tipo_doble = 303,
    tipo_bool = 304,
    tipo_char = 305,
    cora = 306,
    corc = 307,
    coma = 308,
    cadena = 309,
    identificador = 310,
    falso = 311,
    verdadero = 312,
    decimal = 313,
    caracter = 314,
    entero = 315,
    igual = 316,
    nombreobj = 317,
    plantilla_aplicar = 318,
    para = 319,
    parc = 320,
    valor_de = 321,
    tok_html = 322
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 70 "Sintactico_JSLT.y" /* yacc.c:1909  */

//se especifican los tipo de valores para los no terminales y lo terminales
char TEXT [256];
struct Operador * VAL;
struct NodoAST *NODE;

#line 129 "parser2.h" /* yacc.c:1909  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE jjlval;

int jjparse (void);

#endif /* !YY_JJ_PARSER2_H_INCLUDED  */
