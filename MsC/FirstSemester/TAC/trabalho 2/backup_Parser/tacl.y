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
%token AT COMMA ARROW
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

program : global_declarations ;

global_declarations : global_var
					| global_var global_declarations
					| fun_arg
					| fun_arg global_declarations
					| fun
					| fun global_declarations
					;

global_var : OPPAR ID AT IDENTIFIER VAR type CLPAR
		   | OPPAR ID AT IDENTIFIER VAR type initial_value CLPAR
		   ;

fun_arg : OPPAR ID AT IDENTIFIER FUN type OPRPAR fun_args CLRPAR OPRPAR fun_args CLRPAR CLPAR ;

fun : FUNCTION AT IDENTIFIER body ;

body : line
	 | line body
	 ;

line : temp ARROW line_right
	 | AT IDENTIFIER ARROW line_right
     | JUMP temp
     | CJUMP temp COMMA label COMMA label
     | fun_call
     | RETURN
     | IRETURN temp
     ;

line_right : dinst temp temp
		   | sinst temp
		   | sinst AT IDENTIFIER
		   | sinst INT_LITERAL
		   ;

fun_args : OPPAR type AT IDENTIFIER CLPAR fun_args
		 | /* empty */
		 ;

args : temp more_args
     | /* empty */
     ;

more_args : COMMA temp more_args
		  | /* empty */
		  ;

fun_call : CALL AT IDENTIFIER COMMA OPRPAR args CLRPAR 
		 | temp ARROW ICALL AT IDENTIFIER COMMA OPRPAR args CLRPAR
		 ;

temp : TEMPORARY INT_LITERAL ;

label : LABEL INT_LITERAL ;

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
	  | GLOAD
	  | LLOAD
	  | ALOAD
	  | VALUE
	  | IPRINT
	  | BPRINT
	  | GSTORE
	  | LSTORE
	  | ASTORE
	  | COPY
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
