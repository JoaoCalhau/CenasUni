%{
#include <stdio.h>

int yylex(void);
void yyerror(const char *);
%}

%error-verbose

%union {
	char *string;
	int integer;
	double real;
}

%token FUN VAR
%token INT REAL BOOL
%token IDENTIFIER
%token COLON OPPAR CLPAR OPRPAR CLRPAR
%token NIL
%token ID LOCAL
%token ARG
%token BODY
%token ASSIGN CALL PRINT IF WHILE
%token TRUE FALSE TOREAL I_LITERAL R_LITERAL
%token INT_LITERAL REAL_LITERAL
%token OR AND EQ NE LT LE GT GE
%token PLUS MINUS TIMES DIV
%token MOD NOT INV

%%

program : global_decl ;

global_decl : declaration global_decl
			| declaration
			;

declarations : declaration declarations
			 | /* empty */
			 ;

declaration : OPPAR VAR identifier expression CLPAR
			| OPPAR FUN IDENTIFIER OPRPAR formal_args CLRPAR body CLPAR
			;

identifier : OPPAR ID IDENTIFIER kind type CLPAR ;

formal_args : OPPAR ARG IDENTIFIER type CLPAR formal_args
			| /* empty */
			;

body : OPPAR BODY OPRPAR declarations CLRPAR statement expression CLPAR ;

statements : statement statements
		   | statement
		   ;

statement : assign
		  | fun_call
		  | print
		  | conditional
		  | loop
		  | compound
		  | empty
		  ;

assign : OPPAR ASSIGN identifier expression CLPAR ;

fun_call : OPPAR CALL IDENTIFIER OPRPAR expressions CLRPAR CLPAR ;

print : OPPAR PRINT expression CLPAR ;

conditional : OPPAR IF expression statement statement CLPAR ;

loop : OPPAR WHILE expression statement CLPAR ;

compound : OPRPAR statements CLRPAR 
	 	 | OPRPAR CLRPAR
	 	 ;

expressions : expression expressions
			| expression
			;

expression : OPPAR compare_op expression expression CLPAR COLON type
		   | OPPAR PLUS expression expression CLPAR COLON type
		   | OPPAR MINUS expression expression CLPAR COLON type
		   | OPPAR TIMES expression expression CLPAR COLON type
		   | OPPAR DIV expression expression CLPAR COLON type
		   | OPPAR MOD expression expression CLPAR COLON type
		   | OPPAR NOT expression expression CLPAR COLON type
		   | OPPAR INV expression expression CLPAR COLON type
		   | identifier COLON type
		   | OPPAR I_LITERAL INT_LITERAL CLPAR COLON type
		   | OPPAR R_LITERAL REAL_LITERAL CLPAR COLON type
		   | TRUE
		   | FALSE
		   | fun_call COLON type
		   | toreal COLON type
		   | empty
		   ;

toreal : OPPAR TOREAL expression CLPAR ;

compare_op : OR | AND | EQ | NE | LT | LE | GT | GE ;

empty : NIL ;

type : INT
	 | REAL
	 | BOOL
	 ;

kind : VAR
	 | LOCAL
	 | ARG
	 ;

%%

/* called when there is a syntax error */
void yyerror(const char *msg) {
	fprintf(stderr, "error: %s\n", msg);
}


int main() {
	return yyparse();
}
