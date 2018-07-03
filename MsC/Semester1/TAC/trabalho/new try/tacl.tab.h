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
    FUN = 258,
    VAR = 259,
    INT = 260,
    REAL = 261,
    BOOL = 262,
    IDENTIFIER = 263,
    COLON = 264,
    OPPAR = 265,
    CLPAR = 266,
    OPRPAR = 267,
    CLRPAR = 268,
    NIL = 269,
    ID = 270,
    LOCAL = 271,
    ARG = 272,
    BODY = 273,
    ASSIGN = 274,
    CALL = 275,
    PRINT = 276,
    IF = 277,
    WHILE = 278,
    TRUE = 279,
    FALSE = 280,
    TOREAL = 281,
    I_LITERAL = 282,
    R_LITERAL = 283,
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
#line 10 "tacl.y" /* yacc.c:1909  */

	char *string;
	int integer;
	double real;

#line 106 "tacl.tab.h" /* yacc.c:1909  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_TACL_TAB_H_INCLUDED  */
