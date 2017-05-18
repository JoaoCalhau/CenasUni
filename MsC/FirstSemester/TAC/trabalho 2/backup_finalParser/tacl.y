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
%token TEMP LABEL

%%

program : declarations ;

declarations : declaration declarations
		     | /* empty */
		     ;

declaration : global_var
			| fun_arg
			| fun
			;

global_var : OPPAR ID IDENTIFIER VAR type CLPAR 
		   | OPPAR ID IDENTIFIER VAR type initial_value CLPAR 
		   ;

fun_arg : OPPAR ID IDENTIFIER FUN type OPRPAR fun_args CLRPAR OPRPAR fun_args CLRPAR CLPAR ;

fun : FUNCTION IDENTIFIER body ;

body : line body
	 | label COLON body
	 | ret
	 ;

line : double_inst
	 | single_inst
	 | load_inst
	 | value_inst
	 | store_inst
     | jump_inst
     | cjump_inst
     | fun_call
     | print_inst
     ;

double_inst : temp ARROW dinst temp COMMA temp ;

single_inst : temp ARROW sinst temp ;

load_inst : temp ARROW load IDENTIFIER ;

value_inst : temp ARROW VALUE INT_LITERAL ;

store_inst : IDENTIFIER ARROW store temp ;

jump_inst : JUMP label ;

cjump_inst : CJUMP temp COMMA label COMMA label ;

print_inst : print temp ;

fun_args : OPPAR type IDENTIFIER CLPAR fun_args
		 | /* empty */
		 ;

args : temp more_args
     | /* empty */
     ;

more_args : COMMA temp more_args
		  | /* empty */
		  ;

fun_call : CALL IDENTIFIER COMMA OPRPAR args CLRPAR 
		 | temp ARROW ICALL IDENTIFIER COMMA OPRPAR args CLRPAR
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


ret : RETURN
	| IRETURN temp
	;

temp : TEMP INT_LITERAL ;

label : LABEL INT_LITERAL ;

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
