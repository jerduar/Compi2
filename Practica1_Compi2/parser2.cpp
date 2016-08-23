/* A Bison parser, made by GNU Bison 3.0.4.  */

/* Bison implementation for Yacc-like parsers in C

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

/* C LALR(1) parser skeleton written by Richard Stallman, by
   simplifying the original so-called "semantic" parser.  */

/* All symbols defined below should begin with yy or YY, to avoid
   infringing on user name space.  This should be done even for local
   variables, as they might otherwise be expanded by user macros.
   There are some unavoidable exceptions within include files to
   define necessary library symbols; they are noted "INFRINGES ON
   USER NAME SPACE" below.  */

/* Identify Bison output.  */
#define YYBISON 1

/* Bison version.  */
#define YYBISON_VERSION "3.0.4"

/* Skeleton name.  */
#define YYSKELETON_NAME "yacc.c"

/* Pure parsers.  */
#define YYPURE 0

/* Push parsers.  */
#define YYPUSH 0

/* Pull parsers.  */
#define YYPULL 1


/* Substitute the variable and function names.  */
#define yyparse         jjparse
#define yylex           jjlex
#define yyerror         jjerror
#define yydebug         jjdebug
#define yynerrs         jjnerrs

#define yylval          jjlval
#define yychar          jjchar

/* Copy the first part of user declarations.  */
#line 1 "Sintactico_JSLT.y" /* yacc.c:339  */

#include "scanner2.h"//se importa el header del analisis sintactico

#include <iostream> //libreria para imprimir en cosola de C
#include <QString> //libreria para manejo de STRINGS de QT
#include <QTextStream>
#include <arbolast.h>
#include <QStringList>
#include <QListWidget>
#include <nodoast.h>//NODO PARA LA CREACIÓN DE AST
#include <QHash> //Libreria para manejar HASH TABLES de QT, se usa para la tabla de simbolos
#include <QTextEdit> //libreria QTextEdit de QT para poder mostrar el resultado en pantalla

extern int fila_jslt; //linea actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern int columna_jslt; //columna actual donde se encuentra el parser (analisis lexico) lo maneja BISON
extern char *jjtext; //lexema actual donde esta el parser (analisis lexico) lo maneja BISON

QListWidget *ventanita;

int jjerror(const char* mens){
//metodo que se llama al haber un error sintactico
//SE IMPRIME EN CONSOLA EL ERROR
//std::cout << mens <<"Error Sintactico : "<< jjtext << " linea: " << fila_jslt << " columna: " << columna_jslt - strlen(jjtext) << std::endl;
ventanita->addItem("Error Sintactico : " + (QString)jjtext + " linea: " + QString::number(fila_jslt) + " columna: " + QString::number(columna_jslt - strlen(jjtext)));
return 0;
}

void SetVentanita(QListWidget *ven){
    ventanita = ven;
}

int correcto = 1;
QTextEdit* salida_jslt; //puntero al QTextEdit de salida
void setSalidaJSLT(QTextEdit* exit) {
//metodo que asigna el valor al QTextEdit de salida
salida_jslt=exit;
}

ArbolAST *generado;
ArbolAST *setArbol(){
    return generado;
}

void jjsetFila(){
    fila_jslt = 1;
}

void jjsetColumna(){
    columna_jslt = 0;
}

struct Operador{
//ESTRUCTURA LA CUAL CONTENDRA LOS TIPOS DE LOS NO TERMINALES PARA HEREDAR VALORES
QString  texto;
float valor;
};


#line 133 "parser2.cpp" /* yacc.c:339  */

# ifndef YY_NULLPTR
#  if defined __cplusplus && 201103L <= __cplusplus
#   define YY_NULLPTR nullptr
#  else
#   define YY_NULLPTR 0
#  endif
# endif

/* Enabling verbose error messages.  */
#ifdef YYERROR_VERBOSE
# undef YYERROR_VERBOSE
# define YYERROR_VERBOSE 1
#else
# define YYERROR_VERBOSE 1
#endif

/* In a future release of Bison, this section will be replaced
   by #include "parser2.h".  */
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
    tok_html = 322,
    tok_h1 = 323,
    tok_h2 = 324,
    tok_h3 = 325,
    tok_h4 = 326,
    tok_h5 = 327,
    tok_h6 = 328,
    tok_title = 329,
    tok_body = 330,
    tok_head = 331,
    tok_table = 332,
    tok_th = 333,
    tok_tr = 334,
    tok_td = 335,
    tok_boder = 336,
    tok_bgcolor = 337,
    tok_width = 338,
    tok_p = 339,
    tok_b = 340,
    tok_i = 341,
    arroba = 342,
    arroba_doble = 343
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 62 "Sintactico_JSLT.y" /* yacc.c:355  */

//se especifican los tipo de valores para los no terminales y lo terminales
char TEXT [256];
struct Operador * VAL;
struct NodoAST *NODE;

#line 269 "parser2.cpp" /* yacc.c:355  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE jjlval;

int jjparse (void);

#endif /* !YY_JJ_PARSER2_H_INCLUDED  */

/* Copy the second part of user declarations.  */

#line 286 "parser2.cpp" /* yacc.c:358  */

#ifdef short
# undef short
#endif

#ifdef YYTYPE_UINT8
typedef YYTYPE_UINT8 yytype_uint8;
#else
typedef unsigned char yytype_uint8;
#endif

#ifdef YYTYPE_INT8
typedef YYTYPE_INT8 yytype_int8;
#else
typedef signed char yytype_int8;
#endif

#ifdef YYTYPE_UINT16
typedef YYTYPE_UINT16 yytype_uint16;
#else
typedef unsigned short int yytype_uint16;
#endif

#ifdef YYTYPE_INT16
typedef YYTYPE_INT16 yytype_int16;
#else
typedef short int yytype_int16;
#endif

#ifndef YYSIZE_T
# ifdef __SIZE_TYPE__
#  define YYSIZE_T __SIZE_TYPE__
# elif defined size_t
#  define YYSIZE_T size_t
# elif ! defined YYSIZE_T
#  include <stddef.h> /* INFRINGES ON USER NAME SPACE */
#  define YYSIZE_T size_t
# else
#  define YYSIZE_T unsigned int
# endif
#endif

#define YYSIZE_MAXIMUM ((YYSIZE_T) -1)

#ifndef YY_
# if defined YYENABLE_NLS && YYENABLE_NLS
#  if ENABLE_NLS
#   include <libintl.h> /* INFRINGES ON USER NAME SPACE */
#   define YY_(Msgid) dgettext ("bison-runtime", Msgid)
#  endif
# endif
# ifndef YY_
#  define YY_(Msgid) Msgid
# endif
#endif

#ifndef YY_ATTRIBUTE
# if (defined __GNUC__                                               \
      && (2 < __GNUC__ || (__GNUC__ == 2 && 96 <= __GNUC_MINOR__)))  \
     || defined __SUNPRO_C && 0x5110 <= __SUNPRO_C
#  define YY_ATTRIBUTE(Spec) __attribute__(Spec)
# else
#  define YY_ATTRIBUTE(Spec) /* empty */
# endif
#endif

#ifndef YY_ATTRIBUTE_PURE
# define YY_ATTRIBUTE_PURE   YY_ATTRIBUTE ((__pure__))
#endif

#ifndef YY_ATTRIBUTE_UNUSED
# define YY_ATTRIBUTE_UNUSED YY_ATTRIBUTE ((__unused__))
#endif

#if !defined _Noreturn \
     && (!defined __STDC_VERSION__ || __STDC_VERSION__ < 201112)
# if defined _MSC_VER && 1200 <= _MSC_VER
#  define _Noreturn __declspec (noreturn)
# else
#  define _Noreturn YY_ATTRIBUTE ((__noreturn__))
# endif
#endif

/* Suppress unused-variable warnings by "using" E.  */
#if ! defined lint || defined __GNUC__
# define YYUSE(E) ((void) (E))
#else
# define YYUSE(E) /* empty */
#endif

#if defined __GNUC__ && 407 <= __GNUC__ * 100 + __GNUC_MINOR__
/* Suppress an incorrect diagnostic about yylval being uninitialized.  */
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN \
    _Pragma ("GCC diagnostic push") \
    _Pragma ("GCC diagnostic ignored \"-Wuninitialized\"")\
    _Pragma ("GCC diagnostic ignored \"-Wmaybe-uninitialized\"")
# define YY_IGNORE_MAYBE_UNINITIALIZED_END \
    _Pragma ("GCC diagnostic pop")
#else
# define YY_INITIAL_VALUE(Value) Value
#endif
#ifndef YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
# define YY_IGNORE_MAYBE_UNINITIALIZED_END
#endif
#ifndef YY_INITIAL_VALUE
# define YY_INITIAL_VALUE(Value) /* Nothing. */
#endif


#if ! defined yyoverflow || YYERROR_VERBOSE

/* The parser invokes alloca or malloc; define the necessary symbols.  */

# ifdef YYSTACK_USE_ALLOCA
#  if YYSTACK_USE_ALLOCA
#   ifdef __GNUC__
#    define YYSTACK_ALLOC __builtin_alloca
#   elif defined __BUILTIN_VA_ARG_INCR
#    include <alloca.h> /* INFRINGES ON USER NAME SPACE */
#   elif defined _AIX
#    define YYSTACK_ALLOC __alloca
#   elif defined _MSC_VER
#    include <malloc.h> /* INFRINGES ON USER NAME SPACE */
#    define alloca _alloca
#   else
#    define YYSTACK_ALLOC alloca
#    if ! defined _ALLOCA_H && ! defined EXIT_SUCCESS
#     include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
      /* Use EXIT_SUCCESS as a witness for stdlib.h.  */
#     ifndef EXIT_SUCCESS
#      define EXIT_SUCCESS 0
#     endif
#    endif
#   endif
#  endif
# endif

# ifdef YYSTACK_ALLOC
   /* Pacify GCC's 'empty if-body' warning.  */
#  define YYSTACK_FREE(Ptr) do { /* empty */; } while (0)
#  ifndef YYSTACK_ALLOC_MAXIMUM
    /* The OS might guarantee only one guard page at the bottom of the stack,
       and a page size can be as small as 4096 bytes.  So we cannot safely
       invoke alloca (N) if N exceeds 4096.  Use a slightly smaller number
       to allow for a few compiler-allocated temporary stack slots.  */
#   define YYSTACK_ALLOC_MAXIMUM 4032 /* reasonable circa 2006 */
#  endif
# else
#  define YYSTACK_ALLOC YYMALLOC
#  define YYSTACK_FREE YYFREE
#  ifndef YYSTACK_ALLOC_MAXIMUM
#   define YYSTACK_ALLOC_MAXIMUM YYSIZE_MAXIMUM
#  endif
#  if (defined __cplusplus && ! defined EXIT_SUCCESS \
       && ! ((defined YYMALLOC || defined malloc) \
             && (defined YYFREE || defined free)))
#   include <stdlib.h> /* INFRINGES ON USER NAME SPACE */
#   ifndef EXIT_SUCCESS
#    define EXIT_SUCCESS 0
#   endif
#  endif
#  ifndef YYMALLOC
#   define YYMALLOC malloc
#   if ! defined malloc && ! defined EXIT_SUCCESS
void *malloc (YYSIZE_T); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
#  ifndef YYFREE
#   define YYFREE free
#   if ! defined free && ! defined EXIT_SUCCESS
void free (void *); /* INFRINGES ON USER NAME SPACE */
#   endif
#  endif
# endif
#endif /* ! defined yyoverflow || YYERROR_VERBOSE */


#if (! defined yyoverflow \
     && (! defined __cplusplus \
         || (defined YYSTYPE_IS_TRIVIAL && YYSTYPE_IS_TRIVIAL)))

/* A type that is properly aligned for any stack member.  */
union yyalloc
{
  yytype_int16 yyss_alloc;
  YYSTYPE yyvs_alloc;
};

/* The size of the maximum gap between one aligned stack and the next.  */
# define YYSTACK_GAP_MAXIMUM (sizeof (union yyalloc) - 1)

/* The size of an array large to enough to hold all stacks, each with
   N elements.  */
# define YYSTACK_BYTES(N) \
     ((N) * (sizeof (yytype_int16) + sizeof (YYSTYPE)) \
      + YYSTACK_GAP_MAXIMUM)

# define YYCOPY_NEEDED 1

/* Relocate STACK from its old location to the new one.  The
   local variables YYSIZE and YYSTACKSIZE give the old and new number of
   elements in the stack, and YYPTR gives the new location of the
   stack.  Advance YYPTR to a properly aligned location for the next
   stack.  */
# define YYSTACK_RELOCATE(Stack_alloc, Stack)                           \
    do                                                                  \
      {                                                                 \
        YYSIZE_T yynewbytes;                                            \
        YYCOPY (&yyptr->Stack_alloc, Stack, yysize);                    \
        Stack = &yyptr->Stack_alloc;                                    \
        yynewbytes = yystacksize * sizeof (*Stack) + YYSTACK_GAP_MAXIMUM; \
        yyptr += yynewbytes / sizeof (*yyptr);                          \
      }                                                                 \
    while (0)

#endif

#if defined YYCOPY_NEEDED && YYCOPY_NEEDED
/* Copy COUNT objects from SRC to DST.  The source and destination do
   not overlap.  */
# ifndef YYCOPY
#  if defined __GNUC__ && 1 < __GNUC__
#   define YYCOPY(Dst, Src, Count) \
      __builtin_memcpy (Dst, Src, (Count) * sizeof (*(Src)))
#  else
#   define YYCOPY(Dst, Src, Count)              \
      do                                        \
        {                                       \
          YYSIZE_T yyi;                         \
          for (yyi = 0; yyi < (Count); yyi++)   \
            (Dst)[yyi] = (Src)[yyi];            \
        }                                       \
      while (0)
#  endif
# endif
#endif /* !YYCOPY_NEEDED */

/* YYFINAL -- State number of the termination state.  */
#define YYFINAL  5
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   307

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  89
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  25
/* YYNRULES -- Number of rules.  */
#define YYNRULES  71
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  208

/* YYTRANSLATE[YYX] -- Symbol number corresponding to YYX as returned
   by yylex, with out-of-bounds checking.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   343

#define YYTRANSLATE(YYX)                                                \
  ((unsigned int) (YYX) <= YYMAXUTOK ? yytranslate[YYX] : YYUNDEFTOK)

/* YYTRANSLATE[TOKEN-NUM] -- Symbol number corresponding to TOKEN-NUM
   as returned by yylex, without out-of-bounds checking.  */
static const yytype_uint8 yytranslate[] =
{
       0,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     2,     2,     2,     2,
       2,     2,     2,     2,     2,     2,     1,     2,     3,     4,
       5,     6,     7,     8,     9,    10,    11,    12,    13,    14,
      15,    16,    17,    18,    19,    20,    21,    22,    23,    24,
      25,    26,    27,    28,    29,    30,    31,    32,    33,    34,
      35,    36,    37,    38,    39,    40,    41,    42,    43,    44,
      45,    46,    47,    48,    49,    50,    51,    52,    53,    54,
      55,    56,    57,    58,    59,    60,    61,    62,    63,    64,
      65,    66,    67,    68,    69,    70,    71,    72,    73,    74,
      75,    76,    77,    78,    79,    80,    81,    82,    83,    84,
      85,    86,    87,    88
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint16 yyrline[] =
{
       0,   197,   197,   206,   241,   245,   250,   254,   258,   262,
     266,   270,   274,   275,   279,   283,   287,   291,   293,   312,
     314,   316,   322,   328,   334,   340,   346,   352,   357,   363,
     369,   375,   377,   383,   389,   395,   401,   407,   413,   419,
     426,   433,   440,   447,   451,   456,   460,   464,   468,   472,
     477,   496,   509,   523,   535,   542,   549,   557,   565,   573,
     585,   604,   620,   624,   629,   633,   638,   657,   673,   678,
     684,   689
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 1
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "dospuntos", "jslt", "transformacion",
  "ruta", "version", "final", "break_a", "break_c", "slash", "asignar",
  "para_cada", "variable", "valor", "paracada", "si", "encaso", "de",
  "cualquierotro", "seleccionar", "plantilla", "condicion", "igualigual",
  "diferente", "menor_que", "menor_igual", "mayor_que", "mayor_igual",
  "es_nulo", "oor", "aand", "nand", "nor", "xxor", "nnot", "mas", "menos",
  "division", "por", "modulo", "potencia", "incremento", "decremento",
  "suma_igual", "tipo_entero", "tipo_cadena", "tipo_doble", "tipo_bool",
  "tipo_char", "cora", "corc", "coma", "cadena", "identificador", "falso",
  "verdadero", "decimal", "caracter", "entero", "igual", "nombreobj",
  "plantilla_aplicar", "para", "parc", "valor_de", "tok_html", "tok_h1",
  "tok_h2", "tok_h3", "tok_h4", "tok_h5", "tok_h6", "tok_title",
  "tok_body", "tok_head", "tok_table", "tok_th", "tok_tr", "tok_td",
  "tok_boder", "tok_bgcolor", "tok_width", "tok_p", "tok_b", "tok_i",
  "arroba", "arroba_doble", "$accept", "S", "INICIO", "LISTA_SENTENCIAS",
  "SENTENCIA", "SI", "HTML", "SENTENCIAS_HTML", "EXP_LOGICA", "EXP_REL",
  "EXP_ARIT", "PLANTILLA", "APLICAR_PLANTILLA", "ASIGNACION",
  "DECLARACION", "TIPO", "VALOR_DE", "PARA_CADA", "EN_CASO", "LISTA_CASOS",
  "CASOS", "CASO", "CUALQUIER", "MOD1", "MOD2", YY_NULLPTR
};
#endif

# ifdef YYPRINT
/* YYTOKNUM[NUM] -- (External) token number corresponding to the
   (internal) symbol number NUM (which must be that of a token).  */
static const yytype_uint16 yytoknum[] =
{
       0,   256,   257,   258,   259,   260,   261,   262,   263,   264,
     265,   266,   267,   268,   269,   270,   271,   272,   273,   274,
     275,   276,   277,   278,   279,   280,   281,   282,   283,   284,
     285,   286,   287,   288,   289,   290,   291,   292,   293,   294,
     295,   296,   297,   298,   299,   300,   301,   302,   303,   304,
     305,   306,   307,   308,   309,   310,   311,   312,   313,   314,
     315,   316,   317,   318,   319,   320,   321,   322,   323,   324,
     325,   326,   327,   328,   329,   330,   331,   332,   333,   334,
     335,   336,   337,   338,   339,   340,   341,   342,   343
};
# endif

#define YYPACT_NINF -107

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-107)))

#define YYTABLE_NINF -1

#define yytable_value_is_error(Yytable_value) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int16 yypact[] =
{
      19,    15,    39,  -107,    27,  -107,    31,    38,   -11,    13,
      45,    -1,    16,    56,    37,  -107,    12,    20,    23,    -2,
      42,  -107,  -107,  -107,  -107,  -107,  -107,  -107,  -107,  -107,
    -107,  -107,  -107,    80,    83,  -107,  -107,  -107,  -107,     1,
    -107,   123,    50,    90,   -24,    88,    61,   106,    55,    98,
     102,  -107,   111,   122,  -107,  -107,  -107,  -107,  -107,    81,
      68,    73,    77,   126,    85,    87,    92,   139,   147,   141,
     104,   107,   196,   161,   157,  -107,  -107,  -107,   118,   121,
     127,   116,   168,   124,   177,   178,   221,   196,  -107,    -2,
    -107,  -107,  -107,   203,    79,  -107,   262,  -107,  -107,   191,
      36,  -107,   209,   216,   218,   219,  -107,   221,  -107,    37,
     221,   231,  -107,   165,   183,    37,   196,   196,   196,   196,
     196,   221,   221,   221,   221,   221,   221,   221,   221,   221,
     221,   221,   221,    29,   227,    37,   224,  -107,  -107,    17,
      44,   176,  -107,  -107,    60,    30,  -107,  -107,    30,    30,
     231,   231,   231,   231,   231,   231,   151,   151,   193,   193,
     193,  -107,   213,   228,   234,    63,  -107,  -107,     4,     6,
     181,    37,   225,     7,   240,   241,   196,    89,   239,   248,
     250,   256,   137,     9,  -107,   263,   258,   260,    37,   274,
     261,   272,   282,    99,   281,   283,  -107,  -107,    10,   275,
    -107,   290,   286,   294,  -107,   279,   295,  -107
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
       0,     0,     0,     2,     0,     1,     0,     0,     0,     0,
       0,     0,     0,     0,     0,    17,     0,     0,     0,     0,
       0,     5,    14,    12,     8,     9,     6,     7,    10,    11,
      13,    15,    16,     0,     0,    68,    69,    70,    71,     0,
       4,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,    20,     0,     0,    54,    55,    56,    57,    58,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,    63,    64,    65,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,    46,    43,
      47,    45,    44,     0,     0,    27,     0,    48,    49,     0,
       0,    62,     0,     0,     0,     0,     3,     0,    53,     0,
       0,    35,    26,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,    59,    19,     0,
       0,     0,    31,    42,     0,    21,    22,    23,    24,    25,
      28,    29,    30,    32,    33,    34,    37,    38,    39,    36,
      40,    41,     0,     0,     0,     0,    51,    52,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     0,     0,    61,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,    60,    18,     0,     0,
      50,     0,     0,     0,    67,     0,     0,    66
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int16 yypgoto[] =
{
    -107,  -107,  -107,  -106,   -16,  -107,  -107,  -107,   -85,   214,
      74,  -107,  -107,  -107,  -107,  -107,  -107,  -107,  -107,  -107,
     232,  -107,  -107,   -14,   -13
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int8 yydefgoto[] =
{
      -1,     2,     3,    20,    21,    22,    23,    52,    94,    95,
      96,    24,    25,    26,    27,    60,    28,    29,    30,    74,
      75,    76,    77,    97,    98
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_uint8 yytable[] =
{
      31,    32,   112,   140,    40,    33,    31,    32,    33,   144,
      33,    33,    43,    33,    33,   174,    33,   175,   179,     4,
     189,   201,    54,    55,    56,    57,    58,   167,     1,   165,
       6,   145,   146,   147,   148,   149,     7,    59,    15,     5,
      99,    37,    38,    15,     8,    15,    16,   134,   162,   163,
       9,    39,    11,   168,   127,   128,   129,   130,   131,   132,
      12,    15,   117,   118,    15,   177,    14,    10,    34,   169,
      13,    34,   173,    34,    34,    35,    34,    34,    36,    34,
      17,    18,   193,    41,    62,    17,    18,    17,    18,   115,
      15,   182,    19,    42,    53,    31,    32,    19,   183,    19,
      15,    31,    32,    17,    18,    51,    17,    18,   198,    61,
     116,   117,   118,   119,   120,    19,    63,    64,    19,    65,
      67,    31,    32,    66,    40,    68,    31,    32,    40,    70,
      31,    32,    17,    18,    71,    73,    69,    44,    72,    45,
      46,    47,    17,    18,    19,    48,    78,   188,    79,    40,
      81,    31,    32,    80,    19,    82,    83,    31,    32,    84,
     111,    40,    85,    31,    32,    99,   100,   114,   116,   117,
     118,   119,   120,   102,    31,    32,   103,    40,   106,    31,
      32,   139,   104,   105,   141,   107,    49,   108,   109,    50,
     129,   130,   131,   132,   133,   150,   151,   152,   153,   154,
     155,   156,   157,   158,   159,   160,   161,   121,   122,   123,
     124,   125,   126,   127,   128,   129,   130,   131,   132,   135,
     127,   128,   129,   130,   131,   132,    86,   136,   137,   138,
     142,   164,    87,    86,   166,   132,   170,   172,   171,    17,
      18,   143,   176,   178,   180,   181,    17,    18,   143,   184,
      88,    89,   185,   186,    90,    91,    92,    88,    89,   187,
      93,    90,    91,    92,    17,    18,   190,    93,   127,   128,
     129,   130,   131,   132,   191,    88,    89,   192,   194,    90,
      91,    92,   196,   195,   199,   110,   121,   122,   123,   124,
     125,   126,   197,   200,   203,   202,   204,   205,   206,   127,
     128,   129,   130,   131,   132,   207,   101,   113
};

static const yytype_uint8 yycheck[] =
{
      14,    14,    87,   109,    20,     4,    20,    20,     4,   115,
       4,     4,    11,     4,     4,    11,     4,    11,    11,     4,
      11,    11,    46,    47,    48,    49,    50,    10,     9,   135,
       3,   116,   117,   118,   119,   120,     5,    61,     1,     0,
       4,    43,    44,     1,     6,     1,     9,    11,    19,    20,
      61,     9,     7,     9,    37,    38,    39,    40,    41,    42,
      61,     1,    32,    33,     1,   171,    10,    54,    67,     9,
      54,    67,     9,    67,    67,    55,    67,    67,    55,    67,
      43,    44,   188,     3,    23,    43,    44,    43,    44,    10,
       1,   176,    55,    10,     4,   109,   109,    55,     9,    55,
       1,   115,   115,    43,    44,    55,    43,    44,     9,    21,
      31,    32,    33,    34,    35,    55,    10,    62,    55,    21,
       9,   135,   135,    21,   140,     3,   140,   140,   144,    61,
     144,   144,    43,    44,    61,     9,    55,    14,    61,    16,
      17,    18,    43,    44,    55,    22,    61,    10,    61,   165,
      11,   165,   165,    61,    55,     8,    15,   171,   171,    55,
      86,   177,    55,   177,   177,     4,     9,    93,    31,    32,
      33,    34,    35,    55,   188,   188,    55,   193,    10,   193,
     193,   107,    55,    67,   110,    61,    63,    10,    10,    66,
      39,    40,    41,    42,     3,   121,   122,   123,   124,   125,
     126,   127,   128,   129,   130,   131,   132,    24,    25,    26,
      27,    28,    29,    37,    38,    39,    40,    41,    42,    10,
      37,    38,    39,    40,    41,    42,    30,    11,    10,    10,
      65,     4,    36,    30,    10,    42,    23,     3,    10,    43,
      44,    65,    61,    18,     4,     4,    43,    44,    65,    10,
      54,    55,     4,     3,    58,    59,    60,    54,    55,     3,
      64,    58,    59,    60,    43,    44,     3,    64,    37,    38,
      39,    40,    41,    42,    16,    54,    55,    17,     4,    58,
      59,    60,    10,    22,     3,    64,    24,    25,    26,    27,
      28,    29,    10,    10,     4,    20,    10,     3,    19,    37,
      38,    39,    40,    41,    42,    10,    74,    93
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,     9,    90,    91,     4,     0,     3,     5,     6,    61,
      54,     7,    61,    54,    10,     1,     9,    43,    44,    55,
      92,    93,    94,    95,   100,   101,   102,   103,   105,   106,
     107,   112,   113,     4,    67,    55,    55,    43,    44,     9,
      93,     3,    10,    11,    14,    16,    17,    18,    22,    63,
      66,    55,    96,     4,    46,    47,    48,    49,    50,    61,
     104,    21,    23,    10,    62,    21,    21,     9,     3,    55,
      61,    61,    61,     9,   108,   109,   110,   111,    61,    61,
      61,    11,     8,    15,    55,    55,    30,    36,    54,    55,
      58,    59,    60,    64,    97,    98,    99,   112,   113,     4,
       9,   109,    55,    55,    55,    67,    10,    61,    10,    10,
      64,    99,    97,    98,    99,    10,    31,    32,    33,    34,
      35,    24,    25,    26,    27,    28,    29,    37,    38,    39,
      40,    41,    42,     3,    11,    10,    11,    10,    10,    99,
      92,    99,    65,    65,    92,    97,    97,    97,    97,    97,
      99,    99,    99,    99,    99,    99,    99,    99,    99,    99,
      99,    99,    19,    20,     4,    92,    10,    10,     9,     9,
      23,    10,     3,     9,    11,    11,    61,    92,    18,    11,
       4,     4,    97,     9,    10,     4,     3,     3,    10,    11,
       3,    16,    17,    92,     4,    22,    10,    10,     9,     3,
      10,    11,    20,     4,    10,     3,    19,    10
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    89,    90,    91,    92,    92,    93,    93,    93,    93,
      93,    93,    93,    93,    93,    93,    93,    93,    94,    95,
      96,    97,    97,    97,    97,    97,    97,    97,    98,    98,
      98,    98,    98,    98,    98,    98,    99,    99,    99,    99,
      99,    99,    99,    99,    99,    99,    99,    99,    99,    99,
     100,   101,   102,   103,   104,   104,   104,   104,   104,   105,
     106,   107,   108,   108,   109,   109,   110,   111,   112,   112,
     113,   113
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     1,    18,     2,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,    15,     8,
       1,     3,     3,     3,     3,     3,     2,     1,     3,     3,
       3,     3,     3,     3,     3,     2,     3,     3,     3,     3,
       3,     3,     3,     1,     1,     1,     1,     1,     1,     1,
      15,     9,    10,     8,     1,     1,     1,     1,     1,     8,
      15,    12,     2,     1,     1,     1,    15,    12,     2,     2,
       2,     2
};


#define yyerrok         (yyerrstatus = 0)
#define yyclearin       (yychar = YYEMPTY)
#define YYEMPTY         (-2)
#define YYEOF           0

#define YYACCEPT        goto yyacceptlab
#define YYABORT         goto yyabortlab
#define YYERROR         goto yyerrorlab


#define YYRECOVERING()  (!!yyerrstatus)

#define YYBACKUP(Token, Value)                                  \
do                                                              \
  if (yychar == YYEMPTY)                                        \
    {                                                           \
      yychar = (Token);                                         \
      yylval = (Value);                                         \
      YYPOPSTACK (yylen);                                       \
      yystate = *yyssp;                                         \
      goto yybackup;                                            \
    }                                                           \
  else                                                          \
    {                                                           \
      yyerror (YY_("syntax error: cannot back up")); \
      YYERROR;                                                  \
    }                                                           \
while (0)

/* Error token number */
#define YYTERROR        1
#define YYERRCODE       256



/* Enable debugging if requested.  */
#if YYDEBUG

# ifndef YYFPRINTF
#  include <stdio.h> /* INFRINGES ON USER NAME SPACE */
#  define YYFPRINTF fprintf
# endif

# define YYDPRINTF(Args)                        \
do {                                            \
  if (yydebug)                                  \
    YYFPRINTF Args;                             \
} while (0)

/* This macro is provided for backward compatibility. */
#ifndef YY_LOCATION_PRINT
# define YY_LOCATION_PRINT(File, Loc) ((void) 0)
#endif


# define YY_SYMBOL_PRINT(Title, Type, Value, Location)                    \
do {                                                                      \
  if (yydebug)                                                            \
    {                                                                     \
      YYFPRINTF (stderr, "%s ", Title);                                   \
      yy_symbol_print (stderr,                                            \
                  Type, Value); \
      YYFPRINTF (stderr, "\n");                                           \
    }                                                                     \
} while (0)


/*----------------------------------------.
| Print this symbol's value on YYOUTPUT.  |
`----------------------------------------*/

static void
yy_symbol_value_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep)
{
  FILE *yyo = yyoutput;
  YYUSE (yyo);
  if (!yyvaluep)
    return;
# ifdef YYPRINT
  if (yytype < YYNTOKENS)
    YYPRINT (yyoutput, yytoknum[yytype], *yyvaluep);
# endif
  YYUSE (yytype);
}


/*--------------------------------.
| Print this symbol on YYOUTPUT.  |
`--------------------------------*/

static void
yy_symbol_print (FILE *yyoutput, int yytype, YYSTYPE const * const yyvaluep)
{
  YYFPRINTF (yyoutput, "%s %s (",
             yytype < YYNTOKENS ? "token" : "nterm", yytname[yytype]);

  yy_symbol_value_print (yyoutput, yytype, yyvaluep);
  YYFPRINTF (yyoutput, ")");
}

/*------------------------------------------------------------------.
| yy_stack_print -- Print the state stack from its BOTTOM up to its |
| TOP (included).                                                   |
`------------------------------------------------------------------*/

static void
yy_stack_print (yytype_int16 *yybottom, yytype_int16 *yytop)
{
  YYFPRINTF (stderr, "Stack now");
  for (; yybottom <= yytop; yybottom++)
    {
      int yybot = *yybottom;
      YYFPRINTF (stderr, " %d", yybot);
    }
  YYFPRINTF (stderr, "\n");
}

# define YY_STACK_PRINT(Bottom, Top)                            \
do {                                                            \
  if (yydebug)                                                  \
    yy_stack_print ((Bottom), (Top));                           \
} while (0)


/*------------------------------------------------.
| Report that the YYRULE is going to be reduced.  |
`------------------------------------------------*/

static void
yy_reduce_print (yytype_int16 *yyssp, YYSTYPE *yyvsp, int yyrule)
{
  unsigned long int yylno = yyrline[yyrule];
  int yynrhs = yyr2[yyrule];
  int yyi;
  YYFPRINTF (stderr, "Reducing stack by rule %d (line %lu):\n",
             yyrule - 1, yylno);
  /* The symbols being reduced.  */
  for (yyi = 0; yyi < yynrhs; yyi++)
    {
      YYFPRINTF (stderr, "   $%d = ", yyi + 1);
      yy_symbol_print (stderr,
                       yystos[yyssp[yyi + 1 - yynrhs]],
                       &(yyvsp[(yyi + 1) - (yynrhs)])
                                              );
      YYFPRINTF (stderr, "\n");
    }
}

# define YY_REDUCE_PRINT(Rule)          \
do {                                    \
  if (yydebug)                          \
    yy_reduce_print (yyssp, yyvsp, Rule); \
} while (0)

/* Nonzero means print parse trace.  It is left uninitialized so that
   multiple parsers can coexist.  */
int yydebug;
#else /* !YYDEBUG */
# define YYDPRINTF(Args)
# define YY_SYMBOL_PRINT(Title, Type, Value, Location)
# define YY_STACK_PRINT(Bottom, Top)
# define YY_REDUCE_PRINT(Rule)
#endif /* !YYDEBUG */


/* YYINITDEPTH -- initial size of the parser's stacks.  */
#ifndef YYINITDEPTH
# define YYINITDEPTH 200
#endif

/* YYMAXDEPTH -- maximum size the stacks can grow to (effective only
   if the built-in stack extension method is used).

   Do not make this value too large; the results are undefined if
   YYSTACK_ALLOC_MAXIMUM < YYSTACK_BYTES (YYMAXDEPTH)
   evaluated with infinite-precision integer arithmetic.  */

#ifndef YYMAXDEPTH
# define YYMAXDEPTH 10000
#endif


#if YYERROR_VERBOSE

# ifndef yystrlen
#  if defined __GLIBC__ && defined _STRING_H
#   define yystrlen strlen
#  else
/* Return the length of YYSTR.  */
static YYSIZE_T
yystrlen (const char *yystr)
{
  YYSIZE_T yylen;
  for (yylen = 0; yystr[yylen]; yylen++)
    continue;
  return yylen;
}
#  endif
# endif

# ifndef yystpcpy
#  if defined __GLIBC__ && defined _STRING_H && defined _GNU_SOURCE
#   define yystpcpy stpcpy
#  else
/* Copy YYSRC to YYDEST, returning the address of the terminating '\0' in
   YYDEST.  */
static char *
yystpcpy (char *yydest, const char *yysrc)
{
  char *yyd = yydest;
  const char *yys = yysrc;

  while ((*yyd++ = *yys++) != '\0')
    continue;

  return yyd - 1;
}
#  endif
# endif

# ifndef yytnamerr
/* Copy to YYRES the contents of YYSTR after stripping away unnecessary
   quotes and backslashes, so that it's suitable for yyerror.  The
   heuristic is that double-quoting is unnecessary unless the string
   contains an apostrophe, a comma, or backslash (other than
   backslash-backslash).  YYSTR is taken from yytname.  If YYRES is
   null, do not copy; instead, return the length of what the result
   would have been.  */
static YYSIZE_T
yytnamerr (char *yyres, const char *yystr)
{
  if (*yystr == '"')
    {
      YYSIZE_T yyn = 0;
      char const *yyp = yystr;

      for (;;)
        switch (*++yyp)
          {
          case '\'':
          case ',':
            goto do_not_strip_quotes;

          case '\\':
            if (*++yyp != '\\')
              goto do_not_strip_quotes;
            /* Fall through.  */
          default:
            if (yyres)
              yyres[yyn] = *yyp;
            yyn++;
            break;

          case '"':
            if (yyres)
              yyres[yyn] = '\0';
            return yyn;
          }
    do_not_strip_quotes: ;
    }

  if (! yyres)
    return yystrlen (yystr);

  return yystpcpy (yyres, yystr) - yyres;
}
# endif

/* Copy into *YYMSG, which is of size *YYMSG_ALLOC, an error message
   about the unexpected token YYTOKEN for the state stack whose top is
   YYSSP.

   Return 0 if *YYMSG was successfully written.  Return 1 if *YYMSG is
   not large enough to hold the message.  In that case, also set
   *YYMSG_ALLOC to the required number of bytes.  Return 2 if the
   required number of bytes is too large to store.  */
static int
yysyntax_error (YYSIZE_T *yymsg_alloc, char **yymsg,
                yytype_int16 *yyssp, int yytoken)
{
  YYSIZE_T yysize0 = yytnamerr (YY_NULLPTR, yytname[yytoken]);
  YYSIZE_T yysize = yysize0;
  enum { YYERROR_VERBOSE_ARGS_MAXIMUM = 5 };
  /* Internationalized format string. */
  const char *yyformat = YY_NULLPTR;
  /* Arguments of yyformat. */
  char const *yyarg[YYERROR_VERBOSE_ARGS_MAXIMUM];
  /* Number of reported tokens (one for the "unexpected", one per
     "expected"). */
  int yycount = 0;

  /* There are many possibilities here to consider:
     - If this state is a consistent state with a default action, then
       the only way this function was invoked is if the default action
       is an error action.  In that case, don't check for expected
       tokens because there are none.
     - The only way there can be no lookahead present (in yychar) is if
       this state is a consistent state with a default action.  Thus,
       detecting the absence of a lookahead is sufficient to determine
       that there is no unexpected or expected token to report.  In that
       case, just report a simple "syntax error".
     - Don't assume there isn't a lookahead just because this state is a
       consistent state with a default action.  There might have been a
       previous inconsistent state, consistent state with a non-default
       action, or user semantic action that manipulated yychar.
     - Of course, the expected token list depends on states to have
       correct lookahead information, and it depends on the parser not
       to perform extra reductions after fetching a lookahead from the
       scanner and before detecting a syntax error.  Thus, state merging
       (from LALR or IELR) and default reductions corrupt the expected
       token list.  However, the list is correct for canonical LR with
       one exception: it will still contain any token that will not be
       accepted due to an error action in a later state.
  */
  if (yytoken != YYEMPTY)
    {
      int yyn = yypact[*yyssp];
      yyarg[yycount++] = yytname[yytoken];
      if (!yypact_value_is_default (yyn))
        {
          /* Start YYX at -YYN if negative to avoid negative indexes in
             YYCHECK.  In other words, skip the first -YYN actions for
             this state because they are default actions.  */
          int yyxbegin = yyn < 0 ? -yyn : 0;
          /* Stay within bounds of both yycheck and yytname.  */
          int yychecklim = YYLAST - yyn + 1;
          int yyxend = yychecklim < YYNTOKENS ? yychecklim : YYNTOKENS;
          int yyx;

          for (yyx = yyxbegin; yyx < yyxend; ++yyx)
            if (yycheck[yyx + yyn] == yyx && yyx != YYTERROR
                && !yytable_value_is_error (yytable[yyx + yyn]))
              {
                if (yycount == YYERROR_VERBOSE_ARGS_MAXIMUM)
                  {
                    yycount = 1;
                    yysize = yysize0;
                    break;
                  }
                yyarg[yycount++] = yytname[yyx];
                {
                  YYSIZE_T yysize1 = yysize + yytnamerr (YY_NULLPTR, yytname[yyx]);
                  if (! (yysize <= yysize1
                         && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
                    return 2;
                  yysize = yysize1;
                }
              }
        }
    }

  switch (yycount)
    {
# define YYCASE_(N, S)                      \
      case N:                               \
        yyformat = S;                       \
      break
      YYCASE_(0, YY_("syntax error"));
      YYCASE_(1, YY_("syntax error, unexpected %s"));
      YYCASE_(2, YY_("syntax error, unexpected %s, expecting %s"));
      YYCASE_(3, YY_("syntax error, unexpected %s, expecting %s or %s"));
      YYCASE_(4, YY_("syntax error, unexpected %s, expecting %s or %s or %s"));
      YYCASE_(5, YY_("syntax error, unexpected %s, expecting %s or %s or %s or %s"));
# undef YYCASE_
    }

  {
    YYSIZE_T yysize1 = yysize + yystrlen (yyformat);
    if (! (yysize <= yysize1 && yysize1 <= YYSTACK_ALLOC_MAXIMUM))
      return 2;
    yysize = yysize1;
  }

  if (*yymsg_alloc < yysize)
    {
      *yymsg_alloc = 2 * yysize;
      if (! (yysize <= *yymsg_alloc
             && *yymsg_alloc <= YYSTACK_ALLOC_MAXIMUM))
        *yymsg_alloc = YYSTACK_ALLOC_MAXIMUM;
      return 1;
    }

  /* Avoid sprintf, as that infringes on the user's name space.
     Don't have undefined behavior even if the translation
     produced a string with the wrong number of "%s"s.  */
  {
    char *yyp = *yymsg;
    int yyi = 0;
    while ((*yyp = *yyformat) != '\0')
      if (*yyp == '%' && yyformat[1] == 's' && yyi < yycount)
        {
          yyp += yytnamerr (yyp, yyarg[yyi++]);
          yyformat += 2;
        }
      else
        {
          yyp++;
          yyformat++;
        }
  }
  return 0;
}
#endif /* YYERROR_VERBOSE */

/*-----------------------------------------------.
| Release the memory associated to this symbol.  |
`-----------------------------------------------*/

static void
yydestruct (const char *yymsg, int yytype, YYSTYPE *yyvaluep)
{
  YYUSE (yyvaluep);
  if (!yymsg)
    yymsg = "Deleting";
  YY_SYMBOL_PRINT (yymsg, yytype, yyvaluep, yylocationp);

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  YYUSE (yytype);
  YY_IGNORE_MAYBE_UNINITIALIZED_END
}




/* The lookahead symbol.  */
int yychar;

/* The semantic value of the lookahead symbol.  */
YYSTYPE yylval;
/* Number of syntax errors so far.  */
int yynerrs;


/*----------.
| yyparse.  |
`----------*/

int
yyparse (void)
{
    int yystate;
    /* Number of tokens to shift before error messages enabled.  */
    int yyerrstatus;

    /* The stacks and their tools:
       'yyss': related to states.
       'yyvs': related to semantic values.

       Refer to the stacks through separate pointers, to allow yyoverflow
       to reallocate them elsewhere.  */

    /* The state stack.  */
    yytype_int16 yyssa[YYINITDEPTH];
    yytype_int16 *yyss;
    yytype_int16 *yyssp;

    /* The semantic value stack.  */
    YYSTYPE yyvsa[YYINITDEPTH];
    YYSTYPE *yyvs;
    YYSTYPE *yyvsp;

    YYSIZE_T yystacksize;

  int yyn;
  int yyresult;
  /* Lookahead token as an internal (translated) token number.  */
  int yytoken = 0;
  /* The variables used to return semantic value and location from the
     action routines.  */
  YYSTYPE yyval;

#if YYERROR_VERBOSE
  /* Buffer for error messages, and its allocated size.  */
  char yymsgbuf[128];
  char *yymsg = yymsgbuf;
  YYSIZE_T yymsg_alloc = sizeof yymsgbuf;
#endif

#define YYPOPSTACK(N)   (yyvsp -= (N), yyssp -= (N))

  /* The number of symbols on the RHS of the reduced rule.
     Keep to zero when no symbol should be popped.  */
  int yylen = 0;

  yyssp = yyss = yyssa;
  yyvsp = yyvs = yyvsa;
  yystacksize = YYINITDEPTH;

  YYDPRINTF ((stderr, "Starting parse\n"));

  yystate = 0;
  yyerrstatus = 0;
  yynerrs = 0;
  yychar = YYEMPTY; /* Cause a token to be read.  */
  goto yysetstate;

/*------------------------------------------------------------.
| yynewstate -- Push a new state, which is found in yystate.  |
`------------------------------------------------------------*/
 yynewstate:
  /* In all cases, when you get here, the value and location stacks
     have just been pushed.  So pushing a state here evens the stacks.  */
  yyssp++;

 yysetstate:
  *yyssp = yystate;

  if (yyss + yystacksize - 1 <= yyssp)
    {
      /* Get the current used size of the three stacks, in elements.  */
      YYSIZE_T yysize = yyssp - yyss + 1;

#ifdef yyoverflow
      {
        /* Give user a chance to reallocate the stack.  Use copies of
           these so that the &'s don't force the real ones into
           memory.  */
        YYSTYPE *yyvs1 = yyvs;
        yytype_int16 *yyss1 = yyss;

        /* Each stack pointer address is followed by the size of the
           data in use in that stack, in bytes.  This used to be a
           conditional around just the two extra args, but that might
           be undefined if yyoverflow is a macro.  */
        yyoverflow (YY_("memory exhausted"),
                    &yyss1, yysize * sizeof (*yyssp),
                    &yyvs1, yysize * sizeof (*yyvsp),
                    &yystacksize);

        yyss = yyss1;
        yyvs = yyvs1;
      }
#else /* no yyoverflow */
# ifndef YYSTACK_RELOCATE
      goto yyexhaustedlab;
# else
      /* Extend the stack our own way.  */
      if (YYMAXDEPTH <= yystacksize)
        goto yyexhaustedlab;
      yystacksize *= 2;
      if (YYMAXDEPTH < yystacksize)
        yystacksize = YYMAXDEPTH;

      {
        yytype_int16 *yyss1 = yyss;
        union yyalloc *yyptr =
          (union yyalloc *) YYSTACK_ALLOC (YYSTACK_BYTES (yystacksize));
        if (! yyptr)
          goto yyexhaustedlab;
        YYSTACK_RELOCATE (yyss_alloc, yyss);
        YYSTACK_RELOCATE (yyvs_alloc, yyvs);
#  undef YYSTACK_RELOCATE
        if (yyss1 != yyssa)
          YYSTACK_FREE (yyss1);
      }
# endif
#endif /* no yyoverflow */

      yyssp = yyss + yysize - 1;
      yyvsp = yyvs + yysize - 1;

      YYDPRINTF ((stderr, "Stack size increased to %lu\n",
                  (unsigned long int) yystacksize));

      if (yyss + yystacksize - 1 <= yyssp)
        YYABORT;
    }

  YYDPRINTF ((stderr, "Entering state %d\n", yystate));

  if (yystate == YYFINAL)
    YYACCEPT;

  goto yybackup;

/*-----------.
| yybackup.  |
`-----------*/
yybackup:

  /* Do appropriate processing given the current state.  Read a
     lookahead token if we need one and don't already have one.  */

  /* First try to decide what to do without reference to lookahead token.  */
  yyn = yypact[yystate];
  if (yypact_value_is_default (yyn))
    goto yydefault;

  /* Not known => get a lookahead token if don't already have one.  */

  /* YYCHAR is either YYEMPTY or YYEOF or a valid lookahead symbol.  */
  if (yychar == YYEMPTY)
    {
      YYDPRINTF ((stderr, "Reading a token: "));
      yychar = yylex ();
    }

  if (yychar <= YYEOF)
    {
      yychar = yytoken = YYEOF;
      YYDPRINTF ((stderr, "Now at end of input.\n"));
    }
  else
    {
      yytoken = YYTRANSLATE (yychar);
      YY_SYMBOL_PRINT ("Next token is", yytoken, &yylval, &yylloc);
    }

  /* If the proper action on seeing token YYTOKEN is to reduce or to
     detect an error, take that action.  */
  yyn += yytoken;
  if (yyn < 0 || YYLAST < yyn || yycheck[yyn] != yytoken)
    goto yydefault;
  yyn = yytable[yyn];
  if (yyn <= 0)
    {
      if (yytable_value_is_error (yyn))
        goto yyerrlab;
      yyn = -yyn;
      goto yyreduce;
    }

  /* Count tokens shifted since error; after three, turn off error
     status.  */
  if (yyerrstatus)
    yyerrstatus--;

  /* Shift the lookahead token.  */
  YY_SYMBOL_PRINT ("Shifting", yytoken, &yylval, &yylloc);

  /* Discard the shifted token.  */
  yychar = YYEMPTY;

  yystate = yyn;
  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END

  goto yynewstate;


/*-----------------------------------------------------------.
| yydefault -- do the default action for the current state.  |
`-----------------------------------------------------------*/
yydefault:
  yyn = yydefact[yystate];
  if (yyn == 0)
    goto yyerrlab;
  goto yyreduce;


/*-----------------------------.
| yyreduce -- Do a reduction.  |
`-----------------------------*/
yyreduce:
  /* yyn is the number of a rule to reduce with.  */
  yylen = yyr2[yyn];

  /* If YYLEN is nonzero, implement the default value of the action:
     '$$ = $1'.

     Otherwise, the following line sets YYVAL to garbage.
     This behavior is undocumented and Bison
     users should not rely upon it.  Assigning to YYVAL
     unconditionally makes the parser a bit smaller, and it avoids a
     GCC warning that YYVAL may be used uninitialized.  */
  yyval = yyvsp[1-yylen];


  YY_REDUCE_PRINT (yyn);
  switch (yyn)
    {
        case 2:
#line 197 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        generado = new ArbolAST();
        if(correcto != 0){
            generado->raiz = (yyvsp[0].NODE);
        }else{
            generado = NULL;
        }
    }
#line 1537 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 3:
#line 206 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("INICIO");
        (yyval.NODE)->addHijo((yyvsp[-17].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-16].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-15].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-14].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-13].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-12].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-11].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-10].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-9].TEXT));

        QString temp;
        temp.sprintf((yyvsp[-9].TEXT));
        temp.remove(0,0);
        temp.remove(temp.size()-1,temp.size()-1);

        (yyval.NODE)->addHijo((yyvsp[-8].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-6].NODE));
        (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
        (yyval.NODE)->addHijo((yyvsp[0].TEXT));
    }
#line 1569 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 4:
#line 241 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyvsp[-1].NODE)->addHijo((yyvsp[0].NODE));
        (yyval.NODE) = (yyvsp[-1].NODE);
    }
#line 1578 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 5:
#line 245 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("LISTA_SENTENCIAS");
        (yyval.NODE)->addHijo((yyvsp[0].NODE));
    }
#line 1587 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 6:
#line 250 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
         (yyval.NODE) = new NodoAST("SENTENCIA");
         (yyval.NODE)->addHijo((yyvsp[0].NODE));
    }
#line 1596 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 7:
#line 254 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("SENTENCIA");
        (yyval.NODE)->addHijo((yyvsp[0].NODE));
    }
#line 1605 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 8:
#line 258 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("SENTENCIA");
            (yyval.NODE)-> addHijo((yyvsp[0].NODE));
        }
#line 1614 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 9:
#line 262 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("SENTENCIA");
            (yyval.NODE)-> addHijo((yyvsp[0].NODE));
        }
#line 1623 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 10:
#line 266 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("SENTENCIA");
        (yyval.NODE)-> addHijo((yyvsp[0].NODE));
    }
#line 1632 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 11:
#line 270 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("SENTENCIA");
            (yyval.NODE)-> addHijo((yyvsp[0].NODE));
        }
#line 1641 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 12:
#line 274 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {}
#line 1647 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 13:
#line 275 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("SENTENCIA");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1656 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 14:
#line 279 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("SENTENCIA");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1665 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 15:
#line 283 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("SENTENCIA");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1674 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 16:
#line 287 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("SENTENCIA");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1683 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 17:
#line 291 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {jjerror; correcto = 0;}
#line 1689 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 18:
#line 293 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("SI");
        (yyval.NODE)->addHijo((yyvsp[-14].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-13].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-12].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-11].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-10].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-9].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-8].NODE));
        (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-6].NODE));
        (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
        (yyval.NODE)->addHijo((yyvsp[0].TEXT));
    }
#line 1712 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 19:
#line 312 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {}
#line 1718 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 20:
#line 314 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {}
#line 1724 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 21:
#line 316 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_LOGICA");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
    }
#line 1735 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 22:
#line 322 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_LOGICA");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1746 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 23:
#line 328 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_LOGICA");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1757 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 24:
#line 334 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_LOGICA");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1768 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 25:
#line 340 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_LOGICA");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1779 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 26:
#line 346 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_LOGICA");
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1789 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 27:
#line 352 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_LOGICA");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1798 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 28:
#line 357 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_REL");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1809 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 29:
#line 363 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_REL");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1820 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 30:
#line 369 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_REL");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1831 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 31:
#line 375 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {}
#line 1837 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 32:
#line 377 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_REL");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1848 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 33:
#line 383 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_REL");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1859 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 34:
#line 389 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_REL");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1870 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 35:
#line 395 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_REL");
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1880 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 36:
#line 401 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1891 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 37:
#line 407 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1902 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 38:
#line 413 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1913 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 39:
#line 419 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {

            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1925 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 40:
#line 426 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {

            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1937 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 41:
#line 433 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {

            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[-2].NODE));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 1949 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 42:
#line 440 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {

            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-1].NODE));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 1961 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 43:
#line 447 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 1970 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 44:
#line 451 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {

            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
    }
#line 1980 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 45:
#line 456 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
    }
#line 1989 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 46:
#line 460 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("EXP_ARIT");
        (yyval.NODE)->addHijo((yyvsp[0].TEXT));
    }
#line 1998 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 47:
#line 464 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("EXP_ARIT");
        (yyval.NODE)->addHijo((yyvsp[0].TEXT));
    }
#line 2007 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 48:
#line 468 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 2016 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 49:
#line 472 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EXP_ARIT");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 2025 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 50:
#line 477 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("PLANTILLA");
            (yyval.NODE)->addHijo((yyvsp[-14].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-13].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-12].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-11].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-10].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-9].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-8].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-6].NODE));
            (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2048 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 51:
#line 496 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("APLICAR_PLANTILLA");
            (yyval.NODE)->addHijo((yyvsp[-8].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-6].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2065 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 52:
#line 509 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("ASIGNACION");
            (yyval.NODE)->addHijo((yyvsp[-9].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-8].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-6].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-1].NODE));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2083 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 53:
#line 523 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("DECLARACION");
        (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-6].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-3].NODE));
        (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
        (yyval.NODE)->addHijo((yyvsp[0].TEXT));
     }
#line 2099 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 54:
#line 535 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST((yyvsp[0].TEXT));
        (yyval.NODE)->Hijos->append(aux);
    }
#line 2110 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 55:
#line 542 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST((yyvsp[0].TEXT));
        (yyval.NODE)->Hijos->append(aux);
    }
#line 2121 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 56:
#line 549 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {

        (yyval.NODE) = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST((yyvsp[0].TEXT));
        (yyval.NODE)->Hijos->append(aux);
    }
#line 2133 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 57:
#line 557 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {

        (yyval.NODE) = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST((yyvsp[0].TEXT));
        (yyval.NODE)->Hijos->append(aux);
    }
#line 2145 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 58:
#line 565 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {

        (yyval.NODE) = new NodoAST("TIPO");
        NodoAST *aux = new NodoAST();
        aux = new NodoAST((yyvsp[0].TEXT));
        (yyval.NODE)->Hijos->append(aux);
    }
#line 2157 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 59:
#line 573 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
        (yyval.NODE) = new NodoAST("VALOR_DE");
        (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-6].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
        (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
        (yyval.NODE)->addHijo((yyvsp[0].TEXT));
    }
#line 2173 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 60:
#line 585 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("PARA_CADA");
            (yyval.NODE)->addHijo((yyvsp[-14].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-13].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-12].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-11].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-10].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-9].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-8].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-6].NODE));
            (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2196 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 61:
#line 604 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("EN_CASO");
            (yyval.NODE)->addHijo((yyvsp[-11].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-10].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-9].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-8].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-6].NODE));
            (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2216 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 62:
#line 620 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyvsp[-1].NODE)->addHijo((yyvsp[0].NODE));
            (yyval.NODE) = (yyvsp[-1].NODE);
        }
#line 2225 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 63:
#line 624 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("LISTA_CASOS");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 2234 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 64:
#line 629 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("CASOS");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 2243 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 65:
#line 633 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("CASOS");
            (yyval.NODE)->addHijo((yyvsp[0].NODE));
        }
#line 2252 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 66:
#line 638 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("CASO");
            (yyval.NODE)->addHijo((yyvsp[-14].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-13].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-12].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-11].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-10].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-9].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-8].NODE));
            (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-6].NODE));
            (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2275 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 67:
#line 657 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("CUALQUIER");
            (yyval.NODE)->addHijo((yyvsp[-11].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-10].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-9].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-8].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-7].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-6].NODE));
            (yyval.NODE)->addHijo((yyvsp[-5].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-4].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-3].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-2].TEXT));
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2295 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 68:
#line 673 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("MOD1");
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2305 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 69:
#line 678 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("MOD1");
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2315 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 70:
#line 684 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("MOD2");
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2325 "parser2.cpp" /* yacc.c:1646  */
    break;

  case 71:
#line 689 "Sintactico_JSLT.y" /* yacc.c:1646  */
    {
            (yyval.NODE) = new NodoAST("MOD2");
            (yyval.NODE)->addHijo((yyvsp[-1].TEXT));
            (yyval.NODE)->addHijo((yyvsp[0].TEXT));
        }
#line 2335 "parser2.cpp" /* yacc.c:1646  */
    break;


#line 2339 "parser2.cpp" /* yacc.c:1646  */
      default: break;
    }
  /* User semantic actions sometimes alter yychar, and that requires
     that yytoken be updated with the new translation.  We take the
     approach of translating immediately before every use of yytoken.
     One alternative is translating here after every semantic action,
     but that translation would be missed if the semantic action invokes
     YYABORT, YYACCEPT, or YYERROR immediately after altering yychar or
     if it invokes YYBACKUP.  In the case of YYABORT or YYACCEPT, an
     incorrect destructor might then be invoked immediately.  In the
     case of YYERROR or YYBACKUP, subsequent parser actions might lead
     to an incorrect destructor call or verbose syntax error message
     before the lookahead is translated.  */
  YY_SYMBOL_PRINT ("-> $$ =", yyr1[yyn], &yyval, &yyloc);

  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);

  *++yyvsp = yyval;

  /* Now 'shift' the result of the reduction.  Determine what state
     that goes to, based on the state we popped back to and the rule
     number reduced by.  */

  yyn = yyr1[yyn];

  yystate = yypgoto[yyn - YYNTOKENS] + *yyssp;
  if (0 <= yystate && yystate <= YYLAST && yycheck[yystate] == *yyssp)
    yystate = yytable[yystate];
  else
    yystate = yydefgoto[yyn - YYNTOKENS];

  goto yynewstate;


/*--------------------------------------.
| yyerrlab -- here on detecting error.  |
`--------------------------------------*/
yyerrlab:
  /* Make sure we have latest lookahead translation.  See comments at
     user semantic actions for why this is necessary.  */
  yytoken = yychar == YYEMPTY ? YYEMPTY : YYTRANSLATE (yychar);

  /* If not already recovering from an error, report this error.  */
  if (!yyerrstatus)
    {
      ++yynerrs;
#if ! YYERROR_VERBOSE
      yyerror (YY_("syntax error"));
#else
# define YYSYNTAX_ERROR yysyntax_error (&yymsg_alloc, &yymsg, \
                                        yyssp, yytoken)
      {
        char const *yymsgp = YY_("syntax error");
        int yysyntax_error_status;
        yysyntax_error_status = YYSYNTAX_ERROR;
        if (yysyntax_error_status == 0)
          yymsgp = yymsg;
        else if (yysyntax_error_status == 1)
          {
            if (yymsg != yymsgbuf)
              YYSTACK_FREE (yymsg);
            yymsg = (char *) YYSTACK_ALLOC (yymsg_alloc);
            if (!yymsg)
              {
                yymsg = yymsgbuf;
                yymsg_alloc = sizeof yymsgbuf;
                yysyntax_error_status = 2;
              }
            else
              {
                yysyntax_error_status = YYSYNTAX_ERROR;
                yymsgp = yymsg;
              }
          }
        yyerror (yymsgp);
        if (yysyntax_error_status == 2)
          goto yyexhaustedlab;
      }
# undef YYSYNTAX_ERROR
#endif
    }



  if (yyerrstatus == 3)
    {
      /* If just tried and failed to reuse lookahead token after an
         error, discard it.  */

      if (yychar <= YYEOF)
        {
          /* Return failure if at end of input.  */
          if (yychar == YYEOF)
            YYABORT;
        }
      else
        {
          yydestruct ("Error: discarding",
                      yytoken, &yylval);
          yychar = YYEMPTY;
        }
    }

  /* Else will try to reuse lookahead token after shifting the error
     token.  */
  goto yyerrlab1;


/*---------------------------------------------------.
| yyerrorlab -- error raised explicitly by YYERROR.  |
`---------------------------------------------------*/
yyerrorlab:

  /* Pacify compilers like GCC when the user code never invokes
     YYERROR and the label yyerrorlab therefore never appears in user
     code.  */
  if (/*CONSTCOND*/ 0)
     goto yyerrorlab;

  /* Do not reclaim the symbols of the rule whose action triggered
     this YYERROR.  */
  YYPOPSTACK (yylen);
  yylen = 0;
  YY_STACK_PRINT (yyss, yyssp);
  yystate = *yyssp;
  goto yyerrlab1;


/*-------------------------------------------------------------.
| yyerrlab1 -- common code for both syntax error and YYERROR.  |
`-------------------------------------------------------------*/
yyerrlab1:
  yyerrstatus = 3;      /* Each real token shifted decrements this.  */

  for (;;)
    {
      yyn = yypact[yystate];
      if (!yypact_value_is_default (yyn))
        {
          yyn += YYTERROR;
          if (0 <= yyn && yyn <= YYLAST && yycheck[yyn] == YYTERROR)
            {
              yyn = yytable[yyn];
              if (0 < yyn)
                break;
            }
        }

      /* Pop the current state because it cannot handle the error token.  */
      if (yyssp == yyss)
        YYABORT;


      yydestruct ("Error: popping",
                  yystos[yystate], yyvsp);
      YYPOPSTACK (1);
      yystate = *yyssp;
      YY_STACK_PRINT (yyss, yyssp);
    }

  YY_IGNORE_MAYBE_UNINITIALIZED_BEGIN
  *++yyvsp = yylval;
  YY_IGNORE_MAYBE_UNINITIALIZED_END


  /* Shift the error token.  */
  YY_SYMBOL_PRINT ("Shifting", yystos[yyn], yyvsp, yylsp);

  yystate = yyn;
  goto yynewstate;


/*-------------------------------------.
| yyacceptlab -- YYACCEPT comes here.  |
`-------------------------------------*/
yyacceptlab:
  yyresult = 0;
  goto yyreturn;

/*-----------------------------------.
| yyabortlab -- YYABORT comes here.  |
`-----------------------------------*/
yyabortlab:
  yyresult = 1;
  goto yyreturn;

#if !defined yyoverflow || YYERROR_VERBOSE
/*-------------------------------------------------.
| yyexhaustedlab -- memory exhaustion comes here.  |
`-------------------------------------------------*/
yyexhaustedlab:
  yyerror (YY_("memory exhausted"));
  yyresult = 2;
  /* Fall through.  */
#endif

yyreturn:
  if (yychar != YYEMPTY)
    {
      /* Make sure we have latest lookahead translation.  See comments at
         user semantic actions for why this is necessary.  */
      yytoken = YYTRANSLATE (yychar);
      yydestruct ("Cleanup: discarding lookahead",
                  yytoken, &yylval);
    }
  /* Do not reclaim the symbols of the rule whose action triggered
     this YYABORT or YYACCEPT.  */
  YYPOPSTACK (yylen);
  YY_STACK_PRINT (yyss, yyssp);
  while (yyssp != yyss)
    {
      yydestruct ("Cleanup: popping",
                  yystos[*yyssp], yyvsp);
      YYPOPSTACK (1);
    }
#ifndef yyoverflow
  if (yyss != yyssa)
    YYSTACK_FREE (yyss);
#endif
#if YYERROR_VERBOSE
  if (yymsg != yymsgbuf)
    YYSTACK_FREE (yymsg);
#endif
  return yyresult;
}
#line 695 "Sintactico_JSLT.y" /* yacc.c:1906  */

