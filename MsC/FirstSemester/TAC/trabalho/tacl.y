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

%token ERROR

%%

program : global_declarations ;

global_declarations : fun_decl global_declarations
					| fun_decl
					| var_decl global_declarations
					| var_decl
					;

fun_decl : OPPAR FUN IDENTIFIER OPRPAR formal_args CLRPAR body CLPAR ;

var_decl : OPPAR VAR OPPAR identifier CLPAR expressions CLPAR ;

formal_args : OPPAR ARG IDENTIFIER type CLPAR formal_args
			| /* empty */
			;

body : OPPAR BODY OPRPAR declarations CLRPAR statements expressions CLPAR ;

identifier : ID IDENTIFIER kind type ;

kind : VAR
	 | LOCAL
	 | ARG
	 ;

type : INT
	 | REAL
	 | BOOL
	 ;

declarations : var_decl declarations 
			 | /* empty */
			 ;

statements : statement statements 
		   | statement
		   ;

expressions : expression expressions
			| expression
			;

statement : OPPAR assign CLPAR
		  | OPPAR fun_call CLPAR
		  | OPPAR print CLPAR 
		  | OPPAR conditional CLPAR
		  | OPPAR loop CLPAR
		  | compound
		  | NIL
		  ;

assign : ASSIGN OPPAR identifier CLPAR expression ;

fun_call : CALL IDENTIFIER OPRPAR expressions CLRPAR ;

print : PRINT expression ;

conditional : IF expression statement statement ;

loop : WHILE expression statement ;

compound : OPRPAR statements CLRPAR ;

expression : OPPAR annotated_expressions CLPAR COLON type 
		   | TRUE COLON type
		   | FALSE COLON type
		   | NIL
		   ;

annotated_expressions : OR expression expression
		   			  | AND expression expression
				   	  | EQ expression expression
				      | NE expression expression
				      | LT expression expression
				      | LE expression expression
				      | GT expression expression
				      | GE expression expression
				      | PLUS expression expression
			   	      | MINUS expression expression
				      | TIMES expression expression
				      | DIV expression expression
				      | MOD expression expression
				      | NOT expression expression
				      | INV expression expression
				      | identifier
				      | I_LITERAL INT_LITERAL
				      | R_LITERAL REAL_LITERAL
				      | fun_call
				      | toreal
				      ;

toreal : TOREAL annotated_expressions ;

%%

/* called when there is a syntax error */
void yyerror(const char *msg) {
	fprintf(stderr, "error: %s\n", msg);
}


int main() {
	return yyparse();
}
