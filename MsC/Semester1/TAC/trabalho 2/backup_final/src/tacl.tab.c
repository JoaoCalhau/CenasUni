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
	#include "mips.c"

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
    INT_LITERAL = 259,
    BOOL_LITERAL = 260,
    OPPAR = 261,
    CLPAR = 262,
    OPRPAR = 263,
    CLRPAR = 264,
    COMMA = 265,
    ARROW = 266,
    COLON = 267,
    FUNCTION = 268,
    FUN = 269,
    VAR = 270,
    ID = 271,
    INT = 272,
    BOOL = 273,
    VOID = 274,
    JUMP = 275,
    CJUMP = 276,
    EQ = 277,
    NE = 278,
    LT = 279,
    LE = 280,
    ADD = 281,
    SUB = 282,
    MUL = 283,
    DIV = 284,
    MOD = 285,
    NOT = 286,
    INV = 287,
    GLOAD = 288,
    LLOAD = 289,
    ALOAD = 290,
    VALUE = 291,
    CALL = 292,
    ICALL = 293,
    IPRINT = 294,
    BPRINT = 295,
    GSTORE = 296,
    LSTORE = 297,
    ASTORE = 298,
    RETURN = 299,
    IRETURN = 300,
    COPY = 301,
    TEMP = 302,
    LABEL = 303
  };
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED

union YYSTYPE
{
#line 12 "tacl.y" /* yacc.c:355  */

	char *string;
	int integer;

	struct declarations *declarations;
	struct declaration *declaration;
	struct global_var *global_var;
	struct fun_arg *fun_arg;
	struct fun *fun;
	struct body *body;
	struct line *line;
	struct double_inst *double_inst;
	struct single_inst *single_inst;
	struct load_inst *load_inst;
	struct value_inst *value_inst;
	struct store_inst *store_inst;
	struct jump_inst *jump_inst;
	struct cjump_inst *cjump_inst;
	struct fun_call_inst *fun_call;
	struct print_inst *print_inst;
	struct fun_args *fun_args;
	struct args *args;
	struct more_args *more_args;
	struct dinst *dinst;
	struct sinst *sinst;
	struct store *store;
	struct load *load;
	struct print *print;
	struct ret *ret;
	struct temporary *temporary;
	struct label *label;
	struct initial_value *initial_value;
	struct type *type_t;

#line 199 "tacl.tab.c" /* yacc.c:355  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_TACL_TAB_H_INCLUDED  */

/* Copy the second part of user declarations.  */

#line 216 "tacl.tab.c" /* yacc.c:358  */

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
#define YYFINAL  11
/* YYLAST -- Last index in YYTABLE.  */
#define YYLAST   120

/* YYNTOKENS -- Number of terminals.  */
#define YYNTOKENS  49
/* YYNNTS -- Number of nonterminals.  */
#define YYNNTS  31
/* YYNRULES -- Number of rules.  */
#define YYNRULES  68
/* YYNSTATES -- Number of states.  */
#define YYNSTATES  124

/* YYTRANSLATE[YYX] -- Symbol number corresponding to YYX as returned
   by yylex, with out-of-bounds checking.  */
#define YYUNDEFTOK  2
#define YYMAXUTOK   303

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
      45,    46,    47,    48
};

#if YYDEBUG
  /* YYRLINE[YYN] -- Source line where rule number YYN was defined.  */
static const yytype_uint8 yyrline[] =
{
       0,   100,   100,   102,   103,   106,   107,   108,   111,   112,
     115,   117,   119,   120,   121,   124,   125,   126,   127,   128,
     129,   130,   131,   132,   135,   137,   139,   141,   143,   145,
     147,   149,   151,   152,   155,   156,   159,   160,   163,   164,
     167,   168,   169,   170,   171,   172,   173,   174,   175,   178,
     179,   180,   183,   184,   185,   188,   189,   190,   193,   194,
     198,   199,   202,   204,   206,   207,   210,   211,   212
};
#endif

#if YYDEBUG || YYERROR_VERBOSE || 1
/* YYTNAME[SYMBOL-NUM] -- String name of the symbol SYMBOL-NUM.
   First, the terminals, then, starting at YYNTOKENS, nonterminals.  */
static const char *const yytname[] =
{
  "$end", "error", "$undefined", "IDENTIFIER", "INT_LITERAL",
  "BOOL_LITERAL", "OPPAR", "CLPAR", "OPRPAR", "CLRPAR", "COMMA", "ARROW",
  "COLON", "FUNCTION", "FUN", "VAR", "ID", "INT", "BOOL", "VOID", "JUMP",
  "CJUMP", "EQ", "NE", "LT", "LE", "ADD", "SUB", "MUL", "DIV", "MOD",
  "NOT", "INV", "GLOAD", "LLOAD", "ALOAD", "VALUE", "CALL", "ICALL",
  "IPRINT", "BPRINT", "GSTORE", "LSTORE", "ASTORE", "RETURN", "IRETURN",
  "COPY", "TEMP", "LABEL", "$accept", "program", "declarations",
  "declaration", "global_var", "fun_arg", "fun", "body", "line",
  "double_inst", "single_inst", "load_inst", "value_inst", "store_inst",
  "jump_inst", "cjump_inst", "print_inst", "fun_args", "args", "more_args",
  "fun_call", "dinst", "sinst", "store", "load", "print", "ret", "temp",
  "label", "initial_value", "type", YY_NULLPTR
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
     295,   296,   297,   298,   299,   300,   301,   302,   303
};
# endif

#define YYPACT_NINF -106

#define yypact_value_is_default(Yystate) \
  (!!((Yystate) == (-106)))

#define YYTABLE_NINF -1

#define yytable_value_is_error(Yytable_value) \
  0

  /* YYPACT[STATE-NUM] -- Index in YYTABLE of the portion describing
     STATE-NUM.  */
static const yytype_int8 yypact[] =
{
       0,    -5,    14,    18,  -106,     0,  -106,  -106,  -106,    17,
       1,  -106,  -106,    12,    19,   -20,   -15,    28,  -106,  -106,
    -106,   -15,    29,    30,  -106,     1,  -106,  -106,  -106,  -106,
    -106,  -106,  -106,  -106,  -106,   -15,  -106,    24,    25,    -3,
      -3,   -18,  -106,    26,    32,  -106,  -106,  -106,  -106,  -106,
      74,     1,  -106,  -106,  -106,    31,     3,  -106,  -106,  -106,
     -15,   -20,    35,  -106,  -106,  -106,  -106,  -106,  -106,  -106,
    -106,  -106,  -106,  -106,  -106,  -106,  -106,    46,    48,  -106,
     -15,   -15,    49,  -106,    47,  -106,  -106,  -106,    50,  -106,
      44,   -15,  -106,    45,    51,  -106,  -106,    -3,    53,  -106,
     -20,    54,    56,    52,   -15,    55,    59,  -106,  -106,   -15,
    -106,   -15,  -106,    61,    47,    56,    60,    47,    62,  -106,
    -106,  -106,    63,  -106
};

  /* YYDEFACT[STATE-NUM] -- Default reduction number in state STATE-NUM.
     Performed when YYTABLE does not specify something else to do.  Zero
     means the default is an error.  */
static const yytype_uint8 yydefact[] =
{
       4,     0,     0,     0,     2,     4,     5,     6,     7,     0,
       0,     1,     3,     0,     0,     0,     0,     0,    58,    59,
      60,     0,     0,     0,    11,     0,    15,    16,    17,    18,
      19,    20,    21,    23,    22,     0,    14,     0,     0,     0,
       0,     0,    29,     0,     0,    61,    62,    63,    12,    31,
       0,     0,    66,    67,    68,     0,     0,    52,    53,    54,
       0,     0,     0,    40,    41,    42,    43,    44,    45,    46,
      47,    48,    49,    50,    55,    56,    57,     0,     0,    51,
       0,     0,     0,    13,    33,    64,    65,     8,     0,    28,
       0,    35,    27,     0,     0,    25,    26,     0,     0,     9,
       0,     0,    37,     0,     0,     0,     0,    30,    38,     0,
      34,    35,    24,     0,    33,    37,     0,    33,     0,    36,
      39,    32,     0,    10
};

  /* YYPGOTO[NTERM-NUM].  */
static const yytype_int8 yypgoto[] =
{
    -106,  -106,    67,  -106,  -106,  -106,  -106,   -22,  -106,  -106,
    -106,  -106,  -106,  -106,  -106,  -106,  -106,  -105,   -55,   -42,
    -106,  -106,  -106,  -106,  -106,  -106,  -106,   -16,   -14,  -106,
     -38
};

  /* YYDEFGOTO[NTERM-NUM].  */
static const yytype_int8 yydefgoto[] =
{
      -1,     3,     4,     5,     6,     7,     8,    24,    25,    26,
      27,    28,    29,    30,    31,    32,    33,    98,   101,   110,
      34,    80,    81,    60,    82,    35,    36,    37,    38,    88,
      55
};

  /* YYTABLE[YYPACT[STATE-NUM]] -- What to do in state STATE-NUM.  If
     positive, shift that token.  If negative, reduce the rule whose
     number is the opposite.  If YYTABLE_NINF, syntax error.  */
static const yytype_uint8 yytable[] =
{
      43,    42,    56,    48,    14,    45,     1,    85,    86,   118,
      87,     9,   121,     2,    52,    53,    54,    10,    11,    49,
      13,    15,    16,    57,    58,    59,    39,    40,    23,    83,
      41,    44,    22,    46,    47,    50,    61,    51,    17,    84,
      18,    19,    62,    91,    89,    20,    21,    90,    22,    23,
      92,    93,    96,    97,   100,   103,   116,    99,   113,   105,
     111,   104,   106,   108,    94,    95,   109,   114,   117,   120,
     123,   122,    12,   119,     0,   102,     0,     0,     0,     0,
       0,     0,     0,     0,     0,     0,   107,     0,   112,     0,
       0,     0,     0,   115,     0,   102,    63,    64,    65,    66,
      67,    68,    69,    70,    71,    72,    73,    74,    75,    76,
      77,     0,    78,     0,     0,     0,     0,     0,     0,     0,
      79
};

static const yytype_int8 yycheck[] =
{
      16,    15,    40,    25,     3,    21,     6,     4,     5,   114,
       7,    16,   117,    13,    17,    18,    19,     3,     0,    35,
       3,    20,    21,    41,    42,    43,    14,    15,    48,    51,
      11,     3,    47,     4,     4,    11,    10,    12,    37,     8,
      39,    40,    10,     8,    60,    44,    45,    61,    47,    48,
       4,     3,     3,     6,    10,    10,   111,     7,     3,    97,
       8,    10,     9,     9,    80,    81,    10,     8,     7,     9,
       7,     9,     5,   115,    -1,    91,    -1,    -1,    -1,    -1,
      -1,    -1,    -1,    -1,    -1,    -1,   100,    -1,   104,    -1,
      -1,    -1,    -1,   109,    -1,   111,    22,    23,    24,    25,
      26,    27,    28,    29,    30,    31,    32,    33,    34,    35,
      36,    -1,    38,    -1,    -1,    -1,    -1,    -1,    -1,    -1,
      46
};

  /* YYSTOS[STATE-NUM] -- The (internal number of the) accessing
     symbol of state STATE-NUM.  */
static const yytype_uint8 yystos[] =
{
       0,     6,    13,    50,    51,    52,    53,    54,    55,    16,
       3,     0,    51,     3,     3,    20,    21,    37,    39,    40,
      44,    45,    47,    48,    56,    57,    58,    59,    60,    61,
      62,    63,    64,    65,    69,    74,    75,    76,    77,    14,
      15,    11,    77,    76,     3,    76,     4,     4,    56,    76,
      11,    12,    17,    18,    19,    79,    79,    41,    42,    43,
      72,    10,    10,    22,    23,    24,    25,    26,    27,    28,
      29,    30,    31,    32,    33,    34,    35,    36,    38,    46,
      70,    71,    73,    56,     8,     4,     5,     7,    78,    76,
      77,     8,     4,     3,    76,    76,     3,     6,    66,     7,
      10,    67,    76,    10,    10,    79,     9,    77,     9,    10,
      68,     8,    76,     3,     8,    76,    67,     7,    66,    68,
       9,    66,     9,     7
};

  /* YYR1[YYN] -- Symbol number of symbol that rule YYN derives.  */
static const yytype_uint8 yyr1[] =
{
       0,    49,    50,    51,    51,    52,    52,    52,    53,    53,
      54,    55,    56,    56,    56,    57,    57,    57,    57,    57,
      57,    57,    57,    57,    58,    59,    60,    61,    62,    63,
      64,    65,    66,    66,    67,    67,    68,    68,    69,    69,
      70,    70,    70,    70,    70,    70,    70,    70,    70,    71,
      71,    71,    72,    72,    72,    73,    73,    73,    74,    74,
      75,    75,    76,    77,    78,    78,    79,    79,    79
};

  /* YYR2[YYN] -- Number of symbols on the right hand side of rule YYN.  */
static const yytype_uint8 yyr2[] =
{
       0,     2,     1,     2,     0,     1,     1,     1,     6,     7,
      12,     3,     2,     3,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     6,     4,     4,     4,     4,     2,
       6,     2,     5,     0,     2,     0,     3,     0,     6,     8,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     1,     1,     1,     1,     1,     1,     1,     1,     1,
       1,     2,     2,     2,     1,     1,     1,     1,     1
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
#line 100 "tacl.y" /* yacc.c:1646  */
    {mips_code_gen((yyvsp[0].declarations));}
#line 1384 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 3:
#line 102 "tacl.y" /* yacc.c:1646  */
    {(yyval.declarations) = new_decls(not_empty, (yyvsp[-1].declaration), (yyvsp[0].declarations));}
#line 1390 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 4:
#line 103 "tacl.y" /* yacc.c:1646  */
    {(yyval.declarations) = new_decls(empty_, NULL, NULL);}
#line 1396 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 5:
#line 106 "tacl.y" /* yacc.c:1646  */
    {(yyval.declaration) = new_decl_gvar(gvar_, (yyvsp[0].global_var));}
#line 1402 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 6:
#line 107 "tacl.y" /* yacc.c:1646  */
    {(yyval.declaration) = new_decl_farg(farg_, (yyvsp[0].fun_arg));}
#line 1408 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 7:
#line 108 "tacl.y" /* yacc.c:1646  */
    {(yyval.declaration) = new_decl_fun(fun_, (yyvsp[0].fun));}
#line 1414 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 8:
#line 111 "tacl.y" /* yacc.c:1646  */
    {(yyval.global_var) = new_gvar(not_init, (yyvsp[-3].string), (yyvsp[-1].type_t), NULL);}
#line 1420 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 9:
#line 112 "tacl.y" /* yacc.c:1646  */
    {(yyval.global_var) = new_gvar(init_, (yyvsp[-4].string), (yyvsp[-2].type_t), (yyvsp[-1].initial_value));}
#line 1426 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 10:
#line 115 "tacl.y" /* yacc.c:1646  */
    {(yyval.fun_arg) = new_farg((yyvsp[-9].string), (yyvsp[-7].type_t), (yyvsp[-5].fun_args), (yyvsp[-2].fun_args));}
#line 1432 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 11:
#line 117 "tacl.y" /* yacc.c:1646  */
    {(yyval.fun) = new_fun((yyvsp[-1].string), (yyvsp[0].body));}
#line 1438 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 12:
#line 119 "tacl.y" /* yacc.c:1646  */
    {(yyval.body) = new_body_line(line_, (yyvsp[0].body), (yyvsp[-1].line));}
#line 1444 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 13:
#line 120 "tacl.y" /* yacc.c:1646  */
    {(yyval.body) = new_body_label(label_, (yyvsp[0].body), (yyvsp[-2].label));}
#line 1450 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 14:
#line 121 "tacl.y" /* yacc.c:1646  */
    {(yyval.body) = new_body_ret(return_body, (yyvsp[0].ret));}
#line 1456 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 15:
#line 124 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_double(dinst_, (yyvsp[0].double_inst));}
#line 1462 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 16:
#line 125 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_single(sinst_, (yyvsp[0].single_inst));}
#line 1468 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 17:
#line 126 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_load(load_, (yyvsp[0].load_inst));}
#line 1474 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 18:
#line 127 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_value(value_, (yyvsp[0].value_inst));}
#line 1480 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 19:
#line 128 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_store(store_, (yyvsp[0].store_inst));}
#line 1486 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 20:
#line 129 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_jump(jump_, (yyvsp[0].jump_inst));}
#line 1492 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 21:
#line 130 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_cjump(cjump_, (yyvsp[0].cjump_inst));}
#line 1498 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 22:
#line 131 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_fcall(fcall_inst_, (yyvsp[0].fun_call));}
#line 1504 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 23:
#line 132 "tacl.y" /* yacc.c:1646  */
    {(yyval.line) = new_line_print(print_, (yyvsp[0].print_inst));}
#line 1510 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 24:
#line 135 "tacl.y" /* yacc.c:1646  */
    {(yyval.double_inst) = new_double_inst((yyvsp[-5].temporary), (yyvsp[-3].dinst), (yyvsp[-2].temporary), (yyvsp[0].temporary));}
#line 1516 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 25:
#line 137 "tacl.y" /* yacc.c:1646  */
    {(yyval.single_inst) = new_single_inst((yyvsp[-3].temporary), (yyvsp[-1].sinst), (yyvsp[0].temporary));}
#line 1522 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 26:
#line 139 "tacl.y" /* yacc.c:1646  */
    {(yyval.load_inst) = new_load_inst((yyvsp[-3].temporary), (yyvsp[-1].load), (yyvsp[0].string));}
#line 1528 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 27:
#line 141 "tacl.y" /* yacc.c:1646  */
    {(yyval.value_inst) = new_value_inst((yyvsp[-3].temporary), (yyvsp[0].integer));}
#line 1534 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 28:
#line 143 "tacl.y" /* yacc.c:1646  */
    {(yyval.store_inst) = new_store_inst((yyvsp[-3].string), (yyvsp[-1].store), (yyvsp[0].temporary));}
#line 1540 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 29:
#line 145 "tacl.y" /* yacc.c:1646  */
    {(yyval.jump_inst) = new_jump_inst((yyvsp[0].label));}
#line 1546 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 30:
#line 147 "tacl.y" /* yacc.c:1646  */
    {(yyval.cjump_inst) = new_cjump_inst((yyvsp[-4].temporary), (yyvsp[-2].label), (yyvsp[0].label));}
#line 1552 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 31:
#line 149 "tacl.y" /* yacc.c:1646  */
    {(yyval.print_inst) = new_print_inst((yyvsp[-1].print), (yyvsp[0].temporary));}
#line 1558 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 32:
#line 151 "tacl.y" /* yacc.c:1646  */
    {(yyval.fun_args) = new_fargs(not_empty, (yyvsp[-3].type_t), (yyvsp[-2].string), (yyvsp[0].fun_args));}
#line 1564 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 33:
#line 152 "tacl.y" /* yacc.c:1646  */
    {(yyval.fun_args) = NULL;}
#line 1570 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 34:
#line 155 "tacl.y" /* yacc.c:1646  */
    {(yyval.args) = new_args(not_empty, (yyvsp[-1].temporary), (yyvsp[0].more_args));}
#line 1576 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 35:
#line 156 "tacl.y" /* yacc.c:1646  */
    {(yyval.args) = new_args(empty_, NULL, NULL);}
#line 1582 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 36:
#line 159 "tacl.y" /* yacc.c:1646  */
    {(yyval.more_args) = new_margs(not_empty, (yyvsp[-1].temporary), (yyvsp[0].more_args));}
#line 1588 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 37:
#line 160 "tacl.y" /* yacc.c:1646  */
    {(yyval.more_args) = new_margs(empty_, NULL, NULL);}
#line 1594 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 38:
#line 163 "tacl.y" /* yacc.c:1646  */
    {(yyval.fun_call) = new_fcall_inst(call_, NULL, (yyvsp[-4].string), (yyvsp[-1].args));}
#line 1600 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 39:
#line 164 "tacl.y" /* yacc.c:1646  */
    {(yyval.fun_call) = new_fcall_inst(icall_, (yyvsp[-7].temporary), (yyvsp[-4].string), (yyvsp[-1].args));}
#line 1606 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 40:
#line 167 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(eq_);}
#line 1612 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 41:
#line 168 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(ne_);}
#line 1618 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 42:
#line 169 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(lt_);}
#line 1624 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 43:
#line 170 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(le_);}
#line 1630 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 44:
#line 171 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(add_);}
#line 1636 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 45:
#line 172 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(sub_);}
#line 1642 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 46:
#line 173 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(mul_);}
#line 1648 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 47:
#line 174 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(div_);}
#line 1654 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 48:
#line 175 "tacl.y" /* yacc.c:1646  */
    {(yyval.dinst) = new_dinst(mod_);}
#line 1660 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 49:
#line 178 "tacl.y" /* yacc.c:1646  */
    {(yyval.sinst) = new_sinst(not_);}
#line 1666 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 50:
#line 179 "tacl.y" /* yacc.c:1646  */
    {(yyval.sinst) = new_sinst(inv_);}
#line 1672 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 51:
#line 180 "tacl.y" /* yacc.c:1646  */
    {(yyval.sinst) = new_sinst(copy_);}
#line 1678 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 52:
#line 183 "tacl.y" /* yacc.c:1646  */
    {(yyval.store) = new_store(gstore_);}
#line 1684 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 53:
#line 184 "tacl.y" /* yacc.c:1646  */
    {(yyval.store) = new_store(lstore_);}
#line 1690 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 54:
#line 185 "tacl.y" /* yacc.c:1646  */
    {(yyval.store) = new_store(astore_);}
#line 1696 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 55:
#line 188 "tacl.y" /* yacc.c:1646  */
    {(yyval.load) = new_load(gload_);}
#line 1702 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 56:
#line 189 "tacl.y" /* yacc.c:1646  */
    {(yyval.load) = new_load(lload_);}
#line 1708 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 57:
#line 190 "tacl.y" /* yacc.c:1646  */
    {(yyval.load) = new_load(aload_);}
#line 1714 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 58:
#line 193 "tacl.y" /* yacc.c:1646  */
    {(yyval.print) = new_print(iprint_);}
#line 1720 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 59:
#line 194 "tacl.y" /* yacc.c:1646  */
    {(yyval.print) = new_print(bprint_);}
#line 1726 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 60:
#line 198 "tacl.y" /* yacc.c:1646  */
    {(yyval.ret) = new_ret(return_);}
#line 1732 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 61:
#line 199 "tacl.y" /* yacc.c:1646  */
    {(yyval.ret) = new_iret(ireturn_, (yyvsp[0].temporary));}
#line 1738 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 62:
#line 202 "tacl.y" /* yacc.c:1646  */
    {(yyval.temporary) = new_temp((yyvsp[0].integer));}
#line 1744 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 63:
#line 204 "tacl.y" /* yacc.c:1646  */
    {(yyval.label) = new_label((yyvsp[0].integer));}
#line 1750 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 64:
#line 206 "tacl.y" /* yacc.c:1646  */
    {(yyval.initial_value) = new_ivalue(int_value, (yyvsp[0].integer));}
#line 1756 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 65:
#line 207 "tacl.y" /* yacc.c:1646  */
    {(yyval.initial_value) = new_ivalue(bool_value, (yyvsp[0].integer));}
#line 1762 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 66:
#line 210 "tacl.y" /* yacc.c:1646  */
    {(yyval.type_t) = new_type(int_);}
#line 1768 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 67:
#line 211 "tacl.y" /* yacc.c:1646  */
    {(yyval.type_t) = new_type(bool_);}
#line 1774 "tacl.tab.c" /* yacc.c:1646  */
    break;

  case 68:
#line 212 "tacl.y" /* yacc.c:1646  */
    {(yyval.type_t) = new_type(void_);}
#line 1780 "tacl.tab.c" /* yacc.c:1646  */
    break;


#line 1784 "tacl.tab.c" /* yacc.c:1646  */
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
#line 215 "tacl.y" /* yacc.c:1906  */



void yyerror(const char *msg) {
	fprintf(stderr, "error: %s\n", msg);
}


int main() {
	return yyparse();
}
