%{
#include <stdio.h>
#include <stdlib.h>
#include "ir.h"

int yylex(void);
void yyerror(const char *);
%}

%error-verbose

%union {
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
}

%token <string> IDENTIFIER
%token <integer> VALUE_INT
%token <real> VALUE_REAL

%token FUN VAR
%token INT REAL BOOL
%token COLON OPPAR CLPAR OPRPAR CLRPAR
%token NIL
%token ID LOCAL
%token ARG
%token BODY
%token ASSIGN CALL PRINT IF WHILE
%token TRUE FALSE TOREAL INT_LITERAL REAL_LITERAL
%token OR AND EQ NE LT LE GT GE
%token PLUS MINUS TIMES DIV
%token MOD NOT INV

%type <declarations> 		declarations
%type <declaration> 		declaration;
%type <identifier>			identifier
%type <formal_args>			formal_args
%type <body>				body
%type <statements>			statements
%type <statement>			statement
%type <assign>				assign
%type <fun_call>			fun_call
%type <print>				print
%type <conditional>			conditional
%type <loop>				loop
%type <compound>			compound
%type <expressions>			expressions
%type <expression>			expression
%type <toreal>				toreal
%type <compare_op>			compare_op
%type <empty>				empty
%type <type>				type
%type <kind>				kind

%%

program : declarations 														{irGen($1);}
		;

declarations : declaration declarations 									{$$ = new_decls($1, $2);}
			 | /* empty */													{$$ = new_decls(NULL, NULL);}
			 ;

declaration : OPPAR VAR identifier expression CLPAR  						{$$ = new_decl_var(var_decl, $3, $4);}
			| OPPAR FUN IDENTIFIER OPRPAR formal_args CLRPAR body CLPAR 	{$$ = new_decl_fun(fun_decl, $3, $5, $7);}
			;

identifier : OPPAR ID IDENTIFIER kind type CLPAR 							{$$ = new_id($3, $4, $5);}
		   ;

formal_args : OPPAR ARG IDENTIFIER type CLPAR formal_args 					{$$ = new_formal_arg($3, $4, $6);}
			| /* empty */													
			;

body : OPPAR BODY OPRPAR declarations CLRPAR statement expression CLPAR 	{$$ = new_body($4, $6, $7);}
	 ;

statements : statement statements											{$$ = new_stmts($1, $2);}
		   | statement 														{$$ = new_stmts($1, NULL);}
		   ;

statement : assign 															{$$ = new_stmt_assign(assign_, $1);}
		  | fun_call 														{$$ = new_stmt_call(call_, $1);}
		  | print 															{$$ = new_stmt_print(print_, $1);}
		  | conditional 													{$$ = new_stmt_conditional(conditional_, $1);}
		  | loop 															{$$ = new_stmt_loop(loop_, $1);}
		  | compound 														{$$ = new_stmt_compound(compound_, $1);}
		  | empty 															{$$ = new_stmt_empty(empty_stmt, $1);}
		  ;

assign : OPPAR ASSIGN identifier expression CLPAR 	 						{$$ = new_assign($3, $4);}
	   ;

fun_call : OPPAR CALL IDENTIFIER OPRPAR expressions CLRPAR CLPAR 			{$$ = new_fun_call($3, $5);}
		 ;

print : OPPAR PRINT expression CLPAR  										{$$ = new_print($3);}
	  ;

conditional : OPPAR IF expression statement statement CLPAR 				{$$ = new_conditional($3, $4, $5);}
			;

loop : OPPAR WHILE expression statement CLPAR 								{$$ = new_loop($3, $4);}
	 ;

compound : OPRPAR statements CLRPAR 										{$$ = new_compound($2);}
	 	 | OPRPAR CLRPAR													{$$ = new_compound(NULL);}
	 	 ;

expressions : expression expressions										{$$ = new_exps($1, $2);}
			| expression 													{$$ = new_exps($1, NULL);}
			;

expression : OPPAR compare_op expression expression CLPAR COLON type 		{$$ = new_exp_compare(compare_, $7, $3, $4, $2);}
		   | OPPAR PLUS expression expression CLPAR COLON type 				{$$ = new_exp_two(plus_, $7, $3, $4);}
		   | OPPAR MINUS expression expression CLPAR COLON type 			{$$ = new_exp_two(minus_, $7, $3, $4);}
		   | OPPAR TIMES expression expression CLPAR COLON type 			{$$ = new_exp_two(times_, $7, $3, $4);}
		   | OPPAR DIV expression expression CLPAR COLON type 				{$$ = new_exp_two(div_, $7, $3, $4);}
		   | OPPAR MOD expression expression CLPAR COLON type 				{$$ = new_exp_two(mod_, $7, $3, $4);}
		   | OPPAR NOT expression CLPAR COLON type 							{$$ = new_exp_one(not_, $6, $3);}
		   | OPPAR INV expression CLPAR COLON type 							{$$ = new_exp_one(inv_, $6, $3);}
		   | identifier COLON type 										 	{$$ = new_exp_id(id_, $3, $1);}
		   | OPPAR INT_LITERAL VALUE_INT CLPAR COLON type 					{$$ = new_exp_int_lit(int_lit, $6, $3);}
		   | OPPAR REAL_LITERAL VALUE_REAL CLPAR COLON type 				{$$ = new_exp_real_lit(real_lit, $6, $3);}
		   | TRUE 															{$$ = new_exp_bool(bool_exp, new_type(bool_), 1);}
		   | FALSE 															{$$ = new_exp_bool(bool_exp, new_type(bool_), 0);}
		   | fun_call COLON type 											{$$ = new_exp_call(call_exp, $3, $1);}
		   | toreal COLON type 												{$$ = new_exp_toreal(toreal_, $3, $1);}
		   | empty 															{$$ = new_exp_empty(empty_exp, new_type(void_), $1);}
		   ;

toreal : OPPAR TOREAL expression CLPAR  									{$$ = new_toreal($3);}
	   ;

compare_op : OR  															{$$ = new_compare_op(or_);}
		   | AND 															{$$ = new_compare_op(and_);}
		   | EQ 															{$$ = new_compare_op(eq_);}
		   | NE 															{$$ = new_compare_op(ne_);}
		   | LT 															{$$ = new_compare_op(lt_);}
		   | LE 															{$$ = new_compare_op(le_);}
		   | GT 															{$$ = new_compare_op(gt_);}
		   | GE  															{$$ = new_compare_op(ge_);}
		   ;

empty : NIL  																{$$ = new_empty(nil_);}
	  ;

type : INT 																	{$$ = new_type(int_);}
	 | REAL 																{$$ = new_type(real_);}
	 | BOOL 																{$$ = new_type(bool_);}
	 ;

kind : VAR 																	{$$ = new_kind(var_);}
	 | LOCAL 																{$$ = new_kind(local_);}
	 | ARG 																	{$$ = new_kind(arg_);}
	 ;

%%

/* called when there is a syntax error */
void yyerror(const char *msg) {
	fprintf(stderr, "error: %s\n", msg);
}


int main() {
	return yyparse();
}
