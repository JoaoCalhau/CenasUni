/* A Bison parser, made by GNU Bison 3.0.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2013 Free Software Foundation, Inc.

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

#ifndef YY_YY_PARSER_H_INCLUDED
# define YY_YY_PARSER_H_INCLUDED
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
    ID = 258,
    INT_LIT = 259,
    BOOL_LIT = 260,
    FLOAT_LIT = 261,
    STRING_LIT = 262,
    INT = 263,
    FLOAT = 264,
    BOOL = 265,
    VOID = 266,
    STRING = 267,
    LPAR = 268,
    RPAR = 269,
    LPARR = 270,
    RPARR = 271,
    LCHAV = 272,
    RCHAV = 273,
    EQUAL = 274,
    LESSOREQUAL = 275,
    LESS = 276,
    DIFF = 277,
    GREATER = 278,
    GREATEROREQUAL = 279,
    POINT = 280,
    BREAK = 281,
    WHILE = 282,
    DO = 283,
    NEXT = 284,
    SUB = 285,
    ADD = 286,
    MUL = 287,
    DIV = 288,
    MOD = 289,
    AND = 290,
    OR = 291,
    NOT = 292,
    EXPOENT = 293,
    IF = 294,
    THEN = 295,
    ELSE = 296,
    DEFINE = 297,
    RETURN = 298,
    ENDOFSTM = 299,
    DOUBLEQUOTE = 300,
    COMMA = 301,
    ASSIGN = 302
  };
#endif
/* Tokens.  */
#define ID 258
#define INT_LIT 259
#define BOOL_LIT 260
#define FLOAT_LIT 261
#define STRING_LIT 262
#define INT 263
#define FLOAT 264
#define BOOL 265
#define VOID 266
#define STRING 267
#define LPAR 268
#define RPAR 269
#define LPARR 270
#define RPARR 271
#define LCHAV 272
#define RCHAV 273
#define EQUAL 274
#define LESSOREQUAL 275
#define LESS 276
#define DIFF 277
#define GREATER 278
#define GREATEROREQUAL 279
#define POINT 280
#define BREAK 281
#define WHILE 282
#define DO 283
#define NEXT 284
#define SUB 285
#define ADD 286
#define MUL 287
#define DIV 288
#define MOD 289
#define AND 290
#define OR 291
#define NOT 292
#define EXPOENT 293
#define IF 294
#define THEN 295
#define ELSE 296
#define DEFINE 297
#define RETURN 298
#define ENDOFSTM 299
#define DOUBLEQUOTE 300
#define COMMA 301
#define ASSIGN 302

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef union YYSTYPE YYSTYPE;
union YYSTYPE
{
#line 27 "ya.y" /* yacc.c:1909  */


    char *string;
    int inteiro;
    float floatt;
    bool boleano;
    

    struct Ids *ids;
    struct IdsType *idstype;
    struct Exp *exp;
    struct Type *type;
    struct Decl *decl;
    struct Decl1 *decl1;
    struct Decls *decls;
    struct Corpo *corpo;
    struct Funcao *funcao;
    struct Mix *mix;
    struct Lits *lits;
    struct Lit *lit;
    struct Stats *stats;
    struct Stat *stat;
    struct Id *id;




#line 176 "parser.h" /* yacc.c:1909  */
};
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_PARSER_H_INCLUDED  */
