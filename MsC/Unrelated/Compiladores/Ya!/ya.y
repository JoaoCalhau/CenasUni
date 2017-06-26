%{
	#include <stdio.h>
	#include "lex.yy.c"

	int yylex(void);
	void yyerror(const char *);
%}

%error-verbose

%union {
	int integer;
	char *string;
	float real;
}

//tokens

%token EQUALS
%token PRINT INPUT
%token INT FLOAT STRING BOOL VOID
%token DEFINE
%token IF THEN ELSE
%token WHILE DO
%token RETURN BREAK NEXT
%token EQSIGN COLUMN COMMA ASP
%token OPPAR CLPAR
%token OPCURLYPAR CLCURLYPAR
%token OPRPAR CLRPAR
%token EXP
%token BOOL_LITERAL STRING_LITERAL INT_LITERAL FLOAT_LITERAL

%left OR 
%left AND
%left EQ NE LT LE GT GE
%left PLUS MINUS
%left MULT DIV MOD
%nonassoc NOT

%%

program : decls ;

decls : fun decls
	  | fun
	  | decl decls
	  | decl
	  ;

decl : STRING_LITERAL COLUMN type
	 | STRING_LITERAL COLUMN type EQSIGN literal
	 ;

fun :

var :

exp : exp OR exp
	| exp AND exp
	| exp compare_op exp %prec EQ
	| exp PLUS exp
	| exp MINUS exp
	| exp MULT exp
	| exp DIV exp
	| exp MOD exp
	| NOT exp
	| MINUS exp %prec NOT
	| atomic_expression
	;

atomic_expression : STRING_LITERAL
				  | literal
				  | fun_call
				  | 

compare_op : EQ | NE | LT | LE | GT GE ;

literal : INT_LITERAL
		 | FLOAT_LITERAL
		 | STRING_LITERAL
		 | BOOL_LITERAL
		 ;

type : INT
	 | FLOAT
	 | STRING
	 | BOOL
	 | VOID
	 ;




%%

void yyerror(const char *msg) {
	fprintf(stderr, "error: %s\n", msg);
}

int main() {
	return yyparse();
}
