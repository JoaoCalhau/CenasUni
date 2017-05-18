%{
	#include <stdio.h>

	int yylex(void);
	void yyerror(const char *);
%}

%error-verbose

%union {
	char *string;
	int integer;
}

%token OPPAR CLPAR OPRPAR CLRPAR
%token COMMA ARROW COLON
%token FUNCTION FUN VAR ID
%token INT BOOL VOID
%token JUMP CJUMP
%token EQ NE LT LE GT GE
%token ADD SUB MUL DIV
%token MOD NOT INV
%token GLOAD LLOAD ALOAD
%token VALUE
%token CALL ICALL
%token IPRINT BPRINT
%token GSTORE LSTORE ASTORE
%token RETURN IRETURN
%token COPY
%token INT_LITERAL BOOL_LITERAL
%token IDENTIFIER
%token TEMPORARY LABEL

%%

program : declarations ;

declarations : declaration declarations
		     | /* empty */
		     ;

declaration : global_var
			| fun_arg
			| fun
			| proc
			;

global_var : OPPAR ID IDENTIFIER VAR type CLPAR 
		   | OPPAR ID IDENTIFIER VAR type initial_value CLPAR 
		   ;

fun_arg : OPPAR ID IDENTIFIER FUN type OPRPAR fun_args CLRPAR OPRPAR fun_args CLRPAR CLPAR ;

fun : FUNCTION IDENTIFIER body IRETURN TEMPORARY ;

proc : FUNCTION IDENTIFIER body RETURN ;

body : line
	 | line body
	 | LABEL COLON line
	 | LABEL COLON line body
	 ;

line : TEMPORARY ARROW dinst TEMPORARY COMMA TEMPORARY
	 | TEMPORARY ARROW sinst TEMPORARY
	 | TEMPORARY ARROW load IDENTIFIER
	 | TEMPORARY ARROW VALUE INT_LITERAL
	 | IDENTIFIER ARROW store TEMPORARY
     | JUMP LABEL
     | CJUMP TEMPORARY COMMA LABEL COMMA LABEL
     | fun_call
     | print TEMPORARY
     ;

fun_args : OPPAR type IDENTIFIER CLPAR fun_args
		 | /* empty */
		 ;

args : TEMPORARY more_args
     | /* empty */
     ;

more_args : COMMA TEMPORARY more_args
		  | /* empty */
		  ;

fun_call : CALL IDENTIFIER COMMA OPRPAR args CLRPAR 
		 | TEMPORARY ARROW ICALL IDENTIFIER COMMA OPRPAR args CLRPAR
		 ;

dinst : EQ
	  | NE
	  | LT
	  | LE
	  | GT
	  | GE
	  | ADD
	  | SUB
	  | MUL
	  | DIV
	  | MOD
	  ;

sinst : NOT
	  | INV
	  | COPY
	  ;

store : GSTORE
	  | LSTORE
	  | ASTORE
	  ;

load : GLOAD
	 | LLOAD
	 | ALOAD
	 ;

print : IPRINT
	  | BPRINT
	  ;

initial_value : INT_LITERAL
			  | BOOL_LITERAL
			  ;

type : INT
	 | BOOL
	 | VOID
	 ;

%%

/* called when there is a syntax error */
void yyerror(const char *msg) {
	fprintf(stderr, "error: %s\n", msg);
}


int main() {
	return yyparse();
}
