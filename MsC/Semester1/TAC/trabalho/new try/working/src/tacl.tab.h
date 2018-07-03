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
#line 12 "tacl.y" /* yacc.c:1909  */

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

#line 127 "tacl.tab.h" /* yacc.c:1909  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_TACL_TAB_H_INCLUDED  */
