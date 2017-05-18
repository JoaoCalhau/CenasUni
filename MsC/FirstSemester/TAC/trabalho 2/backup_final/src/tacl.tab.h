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
#line 12 "tacl.y" /* yacc.c:1909  */

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

#line 138 "tacl.tab.h" /* yacc.c:1909  */
};

typedef union YYSTYPE YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;

int yyparse (void);

#endif /* !YY_YY_TACL_TAB_H_INCLUDED  */
