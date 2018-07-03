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




/* Copy the first part of user declarations.  */
#line 1 "tacl.y" /* yacc.c:339  */

#include <stdio.h>
#include <stdlib.h>
#include "ir.h"

int yylex(void);
void yyerror(const char *);

#line 75 "tacl.tab.c" /* yacc.c:339  */

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
   by #include "tacl.tab.h".  */
#ifndef YY_YY_TACL_TAB_H_INCLUDED
# define YY_YY_TACL_TAB_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token type.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    IDENTIFIER = 258,
    VALUE_INT = 259,
    VALUE_REAL = 260,
    FUN = 261,
    VAR = 262,
    INT = 263,
    REAL = 264,
    BOOL = 265,
    COLON = 266,
    OPPAR = 267,
    CLPAR = 268,
    OPRPAR = 269,
    CLRPAR = 270,
    NIL = 271,
    ID = 272,
    LOCAL = 273,
    ARG = 274,
    BODY = 275,
    ASSIGN = 276,
    CALL = 277,
    PRINT = 278,
    IF = 279,
    WHILE = 280,
    TRUE = 281,
    FALSE = 282,
    TOREAL = 283,
    INT_LITERAL = 284,
    REAL_LITERAL = 285,
    OR = 286,
    AND = 287,
    EQ = 288,
    NE = 289,
    LT = 290,
    LE = 291,
    GT = 292,
    GE = 293,
    PLUS = 294,
    MINUS = 295,
    TIMES = 296,
    DIV = 297,
    MOD = 298,
    NOT = 299,
    INV = 300
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 12 "tacl.y" /* yacc.c:355  */

	char *string;
	int integer;
	double real;

	struct ast_decls *declarations;
	struct ast_decl *declaration;
	struct ast_id *identifier;
	struct ast_formal_args *formal_args;
	struct ast_body *body;
	struct ast_stmts *statements;
	struct ast_stmt *statement;
	struct ast_assign * assign;
	struct ast_fun_call *fun_call;
	struct ast_print *print;
	struct ast_conditional *conditional;
	struct ast_loop *loop;
	struct ast_compound *compound;
	struct ast_exps *expressions;
	struct ast_exp *expression;
	struct ast_toreal *toreal;
	struct ast_compare_op *compare_op;
	struct ast_empty *empty;
	struct ast_type *type;
	struct ast_kind *kind;

#line 188 "tacl.tab.c" /* yacc.c:355  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_TACL_TAB_H_INCLUDED  */

/* Copy the second part of user declarations.  */

#line 205 "tacl.tab.c" /* yacc.c:358  */

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
#define YYFINAL  7
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   157

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  46
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  22
/* YYNRULES -- Number of rules.  */
#define YYNRULES  60
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  163

/* YYTRANSLATE[YYX] -- Symbol number corresponding to YYX as returned
   by yylex, with out-of-bounds checking.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   300

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
      45
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint8 yyrline[] =
{
       0,    79,    79,    82,    83,    86,    87,    90,    93,    94,
      97,   100,   101,   104,   105,   106,   107,   108,   109,   110,
     113,   116,   119,   122,   125,   128,   129,   132,   133,   136,
     137,   138,   139,   140,   141,   142,   143,   144,   145,   146,
     147,   148,   149,   150,   151,   154,   157,   158,   159,   160,
     161,   162,   163,   164,   167,   170,   171,   172,   175,   176,
     177
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 1
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "IDENTIFIER", "VALUE_INT", "VALUE_REAL",
  "FUN", "VAR", "INT", "REAL", "BOOL", "COLON", "OPPAR", "CLPAR", "OPRPAR",
  "CLRPAR", "NIL", "ID", "LOCAL", "ARG", "BODY", "ASSIGN", "CALL", "PRINT",
  "IF", "WHILE", "TRUE", "FALSE", "TOREAL", "INT_LITERAL", "REAL_LITERAL",
  "OR", "AND", "EQ", "NE", "LT", "LE", "GT", "GE", "PLUS", "MINUS",
  "TIMES", "DIV", "MOD", "NOT", "INV", "$accept", "program",
  "declarations", "declaration", "identifier", "formal_args", "body",
  "statements", "statement", "assign", "fun_call", "print", "conditional",
  "loop", "compound", "expressions", "expression", "toreal", "compare_op",
  "empty", "type", "kind", YY_NULLPTR
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
     295,   296,   297,   298,   299,   300
};
# endif

#define YYPACT_NINF -112

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-112)))

#define YYTABLE_NINF -1

#define yytable_value_is_error(Yytable_value) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int8 yypact[] =
{
       7,     8,    10,  -112,     7,    18,    25,  -112,  -112,    24,
      38,    -4,    30,    54,   111,  -112,  -112,  -112,    49,    50,
      57,    52,  -112,    53,    58,     6,    65,    -4,    76,    83,
    -112,  -112,  -112,  -112,  -112,  -112,  -112,  -112,    -4,    -4,
      -4,    -4,    -4,    -4,    -4,    -4,    77,    77,  -112,    77,
      79,    80,  -112,  -112,  -112,    77,    75,    78,    81,    82,
      -4,    -4,    -4,    -4,    -4,    84,    85,    -4,  -112,  -112,
    -112,  -112,  -112,  -112,    77,    73,    86,    87,    -4,  -112,
      90,    91,    93,    94,    95,    96,    97,    92,   100,    99,
     101,   102,  -112,  -112,    89,    -4,    77,    77,   104,   106,
     107,   108,   109,    77,    77,   112,    30,     7,   113,  -112,
    -112,  -112,    77,    77,    77,    77,    77,  -112,  -112,    77,
    -112,    98,  -112,  -112,  -112,  -112,  -112,  -112,  -112,    55,
     -18,    29,    -4,  -112,  -112,  -112,  -112,  -112,  -112,  -112,
      25,    -4,    -4,    -4,  -112,   110,    55,   114,    -4,   116,
      55,    55,  -112,  -112,  -112,   121,  -112,    55,   123,  -112,
     125,  -112,  -112
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
       4,     0,     0,     2,     4,     0,     0,     1,     3,     0,
       0,     0,     9,     0,     0,    54,    40,    41,     0,     0,
       0,     0,    44,     0,     0,     0,     0,     0,     0,     0,
      46,    47,    48,    49,    50,    51,    52,    53,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,     5,     0,
       0,     0,    58,    59,    60,     0,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     0,     0,    55,    56,
      57,    37,    42,    43,     0,     0,     0,     0,     0,    45,
       0,     0,     0,     0,     0,     0,     0,     0,     0,     0,
       0,     0,     6,     7,     0,    28,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,     9,     4,     0,    27,
      38,    39,     0,     0,     0,     0,     0,    35,    36,     0,
       8,     0,    21,    30,    31,    32,    33,    34,    29,     0,
       0,     0,     0,    13,    14,    15,    16,    17,    18,    19,
       0,     0,     0,     0,    26,     0,    12,     0,     0,     0,
       0,     0,    25,    11,    10,     0,    22,     0,     0,    20,
       0,    24,    23
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int8 yypgoto[] =
{
    -112,  -112,    -2,  -112,    -5,   -10,  -112,   -24,  -103,  -112,
    -111,  -112,  -112,  -112,  -112,    62,   -11,  -112,  -112,   -67,
     -38,  -112
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int16 yydefgoto[] =
{
      -1,     2,     3,     4,    18,    24,    76,   145,   146,   133,
      19,   135,   136,   137,   138,    94,    95,    21,    45,    22,
      71,    55
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_uint8 yytable[] =
{
      20,    11,     8,   140,    26,   141,   142,   143,    14,    72,
       7,    73,    15,    52,     5,     6,    57,    77,   134,     1,
     134,     9,    16,    17,    53,    54,   132,    60,    61,    62,
      63,    64,    65,    66,    67,   134,    90,    10,    12,   134,
     134,   130,    23,   131,   144,    15,   134,   157,   158,    82,
      83,    84,    85,    86,   160,    13,    89,    25,   110,   111,
      46,    47,   139,    49,   139,   117,   118,   130,    56,   131,
      48,    15,    50,    51,   123,   124,   125,   126,   127,   139,
      58,   128,    74,   139,   139,    68,    69,    70,    59,    78,
     139,    79,    75,    91,    80,    81,   120,    87,    88,    92,
      93,    96,    97,   103,   108,   121,    98,    99,   100,   101,
     102,   104,   105,   129,   106,   112,   107,   113,   114,   115,
     116,   147,   153,   119,     0,   152,   122,   154,    13,   156,
     149,   150,   151,    26,   159,   148,   161,   155,   162,    27,
      28,    29,    30,    31,    32,    33,    34,    35,    36,    37,
      38,    39,    40,    41,    42,    43,    44,   109
};

static const yytype_int16 yycheck[] =
{
      11,     6,     4,    21,    22,    23,    24,    25,    12,    47,
       0,    49,    16,     7,     6,     7,    27,    55,   129,    12,
     131,     3,    26,    27,    18,    19,   129,    38,    39,    40,
      41,    42,    43,    44,    45,   146,    74,    12,    14,   150,
     151,    12,    12,    14,    15,    16,   157,   150,   151,    60,
      61,    62,    63,    64,   157,    17,    67,     3,    96,    97,
      11,    11,   129,    11,   131,   103,   104,    12,     3,    14,
      13,    16,    19,    15,   112,   113,   114,   115,   116,   146,
       4,   119,     3,   150,   151,     8,     9,    10,     5,    14,
     157,    13,    12,    20,    13,    13,   106,    13,    13,    13,
      13,    11,    11,    11,    15,   107,    13,    13,    13,    13,
      13,    11,    13,    15,    13,    11,    14,    11,    11,    11,
      11,   132,   146,    11,    -1,    15,    13,    13,    17,    13,
     141,   142,   143,    22,    13,   140,    13,   148,    13,    28,
      29,    30,    31,    32,    33,    34,    35,    36,    37,    38,
      39,    40,    41,    42,    43,    44,    45,    95
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,    12,    47,    48,    49,     6,     7,     0,    48,     3,
      12,    50,    14,    17,    12,    16,    26,    27,    50,    56,
      62,    63,    65,    12,    51,     3,    22,    28,    29,    30,
      31,    32,    33,    34,    35,    36,    37,    38,    39,    40,
      41,    42,    43,    44,    45,    64,    11,    11,    13,    11,
      19,    15,     7,    18,    19,    67,     3,    62,     4,     5,
      62,    62,    62,    62,    62,    62,    62,    62,     8,     9,
      10,    66,    66,    66,     3,    12,    52,    66,    14,    13,
      13,    13,    62,    62,    62,    62,    62,    13,    13,    62,
      66,    20,    13,    13,    61,    62,    11,    11,    13,    13,
      13,    13,    13,    11,    11,    13,    13,    14,    15,    61,
      66,    66,    11,    11,    11,    11,    11,    66,    66,    11,
      51,    48,    13,    66,    66,    66,    66,    66,    66,    15,
      12,    14,    54,    55,    56,    57,    58,    59,    60,    65,
      21,    23,    24,    25,    15,    53,    54,    62,    50,    62,
      62,    62,    15,    53,    13,    62,    13,    54,    54,    13,
      54,    13,    13
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    46,    47,    48,    48,    49,    49,    50,    51,    51,
      52,    53,    53,    54,    54,    54,    54,    54,    54,    54,
      55,    56,    57,    58,    59,    60,    60,    61,    61,    62,
      62,    62,    62,    62,    62,    62,    62,    62,    62,    62,
      62,    62,    62,    62,    62,    63,    64,    64,    64,    64,
      64,    64,    64,    64,    65,    66,    66,    66,    67,    67,
      67
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     1,     2,     0,     5,     8,     6,     6,     0,
       8,     2,     1,     1,     1,     1,     1,     1,     1,     1,
       5,     7,     4,     6,     5,     3,     2,     2,     1,     7,
       7,     7,     7,     7,     7,     6,     6,     3,     6,     6,
       1,     1,     3,     3,     1,     4,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1
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
#line 79 "tacl.y" /* yacc.c:1646  */
    {irGen((yyvsp[0].declarations));}
#line 1387 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 3:
#line 82 "tacl.y" /* yacc.c:1646  */
    {(yyval.declarations) = new_decls((yyvsp[-1].declaration), (yyvsp[0].declarations));}
#line 1393 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 4:
#line 83 "tacl.y" /* yacc.c:1646  */
    {(yyval.declarations) = new_decls(NULL, NULL);}
#line 1399 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 5:
#line 86 "tacl.y" /* yacc.c:1646  */
    {(yyval.declaration) = new_decl_var(var_decl, (yyvsp[-2].identifier), (yyvsp[-1].expression));}
#line 1405 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 6:
#line 87 "tacl.y" /* yacc.c:1646  */
    {(yyval.declaration) = new_decl_fun(fun_decl, (yyvsp[-5].string), (yyvsp[-3].formal_args), (yyvsp[-1].body));}
#line 1411 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 7:
#line 90 "tacl.y" /* yacc.c:1646  */
    {(yyval.identifier) = new_id((yyvsp[-3].string), (yyvsp[-2].kind), (yyvsp[-1].type));}
#line 1417 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 8:
#line 93 "tacl.y" /* yacc.c:1646  */
    {(yyval.formal_args) = new_formal_arg((yyvsp[-3].string), (yyvsp[-2].type), (yyvsp[0].formal_args));}
#line 1423 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 9:
#line 94 "tacl.y" /* yacc.c:1646  */
    {}
#line 1429 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 10:
#line 97 "tacl.y" /* yacc.c:1646  */
    {(yyval.body) = new_body((yyvsp[-4].declarations), (yyvsp[-2].statement), (yyvsp[-1].expression));}
#line 1435 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 11:
#line 100 "tacl.y" /* yacc.c:1646  */
    {(yyval.statements) = new_stmts((yyvsp[-1].statement), (yyvsp[0].statements));}
#line 1441 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 12:
#line 101 "tacl.y" /* yacc.c:1646  */
    {(yyval.statements) = new_stmts((yyvsp[0].statement), NULL);}
#line 1447 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 13:
#line 104 "tacl.y" /* yacc.c:1646  */
    {(yyval.statement) = new_stmt_assign(assign_, (yyvsp[0].assign));}
#line 1453 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 14:
#line 105 "tacl.y" /* yacc.c:1646  */
    {(yyval.statement) = new_stmt_call(call_, (yyvsp[0].fun_call));}
#line 1459 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 15:
#line 106 "tacl.y" /* yacc.c:1646  */
    {(yyval.statement) = new_stmt_print(print_, (yyvsp[0].print));}
#line 1465 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 16:
#line 107 "tacl.y" /* yacc.c:1646  */
    {(yyval.statement) = new_stmt_conditional(conditional_, (yyvsp[0].conditional));}
#line 1471 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 17:
#line 108 "tacl.y" /* yacc.c:1646  */
    {(yyval.statement) = new_stmt_loop(loop_, (yyvsp[0].loop));}
#line 1477 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 18:
#line 109 "tacl.y" /* yacc.c:1646  */
    {(yyval.statement) = new_stmt_compound(compound_, (yyvsp[0].compound));}
#line 1483 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 19:
#line 110 "tacl.y" /* yacc.c:1646  */
    {(yyval.statement) = new_stmt_empty(empty_stmt, (yyvsp[0].empty));}
#line 1489 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 20:
#line 113 "tacl.y" /* yacc.c:1646  */
    {(yyval.assign) = new_assign((yyvsp[-2].identifier), (yyvsp[-1].expression));}
#line 1495 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 21:
#line 116 "tacl.y" /* yacc.c:1646  */
    {(yyval.fun_call) = new_fun_call((yyvsp[-4].string), (yyvsp[-2].expressions));}
#line 1501 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 22:
#line 119 "tacl.y" /* yacc.c:1646  */
    {(yyval.print) = new_print((yyvsp[-1].expression));}
#line 1507 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 23:
#line 122 "tacl.y" /* yacc.c:1646  */
    {(yyval.conditional) = new_conditional((yyvsp[-3].expression), (yyvsp[-2].statement), (yyvsp[-1].statement));}
#line 1513 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 24:
#line 125 "tacl.y" /* yacc.c:1646  */
    {(yyval.loop) = new_loop((yyvsp[-2].expression), (yyvsp[-1].statement));}
#line 1519 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 25:
#line 128 "tacl.y" /* yacc.c:1646  */
    {(yyval.compound) = new_compound((yyvsp[-1].statements));}
#line 1525 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 26:
#line 129 "tacl.y" /* yacc.c:1646  */
    {(yyval.compound) = new_compound(NULL);}
#line 1531 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 27:
#line 132 "tacl.y" /* yacc.c:1646  */
    {(yyval.expressions) = new_exps((yyvsp[-1].expression), (yyvsp[0].expressions));}
#line 1537 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 28:
#line 133 "tacl.y" /* yacc.c:1646  */
    {(yyval.expressions) = new_exps((yyvsp[0].expression), NULL);}
#line 1543 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 29:
#line 136 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_compare(compare_, (yyvsp[0].type), (yyvsp[-4].expression), (yyvsp[-3].expression), (yyvsp[-5].compare_op));}
#line 1549 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 30:
#line 137 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_two(plus_, (yyvsp[0].type), (yyvsp[-4].expression), (yyvsp[-3].expression));}
#line 1555 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 31:
#line 138 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_two(minus_, (yyvsp[0].type), (yyvsp[-4].expression), (yyvsp[-3].expression));}
#line 1561 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 32:
#line 139 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_two(times_, (yyvsp[0].type), (yyvsp[-4].expression), (yyvsp[-3].expression));}
#line 1567 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 33:
#line 140 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_two(div_, (yyvsp[0].type), (yyvsp[-4].expression), (yyvsp[-3].expression));}
#line 1573 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 34:
#line 141 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_two(mod_, (yyvsp[0].type), (yyvsp[-4].expression), (yyvsp[-3].expression));}
#line 1579 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 35:
#line 142 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_one(not_, (yyvsp[0].type), (yyvsp[-3].expression));}
#line 1585 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 36:
#line 143 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_one(inv_, (yyvsp[0].type), (yyvsp[-3].expression));}
#line 1591 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 37:
#line 144 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_id(id_, (yyvsp[0].type), (yyvsp[-2].identifier));}
#line 1597 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 38:
#line 145 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_int_lit(int_lit, (yyvsp[0].type), (yyvsp[-3].integer));}
#line 1603 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 39:
#line 146 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_real_lit(real_lit, (yyvsp[0].type), (yyvsp[-3].real));}
#line 1609 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 40:
#line 147 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_bool(bool_exp, new_type(bool_), 1);}
#line 1615 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 41:
#line 148 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_bool(bool_exp, new_type(bool_), 0);}
#line 1621 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 42:
#line 149 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_call(call_exp, (yyvsp[0].type), (yyvsp[-2].fun_call));}
#line 1627 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 43:
#line 150 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_toreal(toreal_, (yyvsp[0].type), (yyvsp[-2].toreal));}
#line 1633 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 44:
#line 151 "tacl.y" /* yacc.c:1646  */
    {(yyval.expression) = new_exp_empty(empty_exp, new_type(void_), (yyvsp[0].empty));}
#line 1639 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 45:
#line 154 "tacl.y" /* yacc.c:1646  */
    {(yyval.toreal) = new_toreal((yyvsp[-1].expression));}
#line 1645 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 46:
#line 157 "tacl.y" /* yacc.c:1646  */
    {(yyval.compare_op) = new_compare_op(or_);}
#line 1651 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 47:
#line 158 "tacl.y" /* yacc.c:1646  */
    {(yyval.compare_op) = new_compare_op(and_);}
#line 1657 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 48:
#line 159 "tacl.y" /* yacc.c:1646  */
    {(yyval.compare_op) = new_compare_op(eq_);}
#line 1663 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 49:
#line 160 "tacl.y" /* yacc.c:1646  */
    {(yyval.compare_op) = new_compare_op(ne_);}
#line 1669 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 50:
#line 161 "tacl.y" /* yacc.c:1646  */
    {(yyval.compare_op) = new_compare_op(lt_);}
#line 1675 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 51:
#line 162 "tacl.y" /* yacc.c:1646  */
    {(yyval.compare_op) = new_compare_op(le_);}
#line 1681 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 52:
#line 163 "tacl.y" /* yacc.c:1646  */
    {(yyval.compare_op) = new_compare_op(gt_);}
#line 1687 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 53:
#line 164 "tacl.y" /* yacc.c:1646  */
    {(yyval.compare_op) = new_compare_op(ge_);}
#line 1693 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 54:
#line 167 "tacl.y" /* yacc.c:1646  */
    {(yyval.empty) = new_empty(nil_);}
#line 1699 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 55:
#line 170 "tacl.y" /* yacc.c:1646  */
    {(yyval.type) = new_type(int_);}
#line 1705 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 56:
#line 171 "tacl.y" /* yacc.c:1646  */
    {(yyval.type) = new_type(real_);}
#line 1711 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 57:
#line 172 "tacl.y" /* yacc.c:1646  */
    {(yyval.type) = new_type(bool_);}
#line 1717 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 58:
#line 175 "tacl.y" /* yacc.c:1646  */
    {(yyval.kind) = new_kind(var_);}
#line 1723 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 59:
#line 176 "tacl.y" /* yacc.c:1646  */
    {(yyval.kind) = new_kind(local_);}
#line 1729 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 60:
#line 177 "tacl.y" /* yacc.c:1646  */
    {(yyval.kind) = new_kind(arg_);}
#line 1735 "tacl.tab.c" /* yacc.c:1646  */
    break;


#line 1739 "tacl.tab.c" /* yacc.c:1646  */
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
#line 180 "tacl.y" /* yacc.c:1906  */


/* called when there is a syntax error */
void yyerror(const char *msg) {
	fprintf(stderr, "error: %s\n", msg);
}


int main() {
	return yyparse();
}
