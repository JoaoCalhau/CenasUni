%{
#include <stdio.h>

int yylex(void);
void yyerror(const char *);	// see below
%}


%error-verbose
%expect 1

%union {
  char   *string;
  int    integer;
  double real;
}

%token FUN
%token INT REAL BOOL
%token EQSIGN COMMA SEMICOLON OPPAR CLPAR OPRPAR CLRPAR
%token VAR PROC RETURN
%token PRINT
%token IF ELSE WHILE
%token INT_LITERAL REAL_LITERAL BOOL_LITERAL
%token ID

%left OR
%left AND
%left EQ NE LT LE GT GE
%left PLUS MINUS
%left MULT DIV MOD
%nonassoc NOT

%token ERROR		// for signalling lexical errors

%%

program : global_declarations ;

global_declarations : fundef global_declarations
                    | fundef
                    | procdef global_declarations
                    | procdef
                    | decl global_declarations
                    | decl
                    ;

fundef : FUN type ID OPPAR formal_args CLPAR fun_body ;

procdef : PROC ID OPPAR formal_args CLPAR proc_body ;

type : INT
     | REAL
     | BOOL
     ;

formal_args : type ID more_formal_args
            | /* empty */
            ;

more_formal_args : COMMA type ID more_formal_args
                 | /* empty */
                 ;

proc_body : OPRPAR body CLRPAR ;

fun_body : EQSIGN expression SEMICOLON
         | OPRPAR body RETURN expression CLRPAR
         ;

body : decls statements ;

decls : decl decls
      | /* empty */
      ;

statements : statement statements
           | /* empty */
           ;

statement : afect
          | call
          | print
          | loop
          | conditional
          | compound
          ;

decl : VAR type ID EQSIGN expression SEMICOLON
     | VAR type ID SEMICOLON
     ;

afect : ID EQSIGN expression SEMICOLON ;

call : function_call SEMICOLON ;

print : PRINT expression SEMICOLON ;

loop : WHILE OPPAR expression CLPAR statement ;

conditional : IF OPPAR expression CLPAR statement
            | IF OPPAR expression CLPAR statement ELSE statement
            ;

compound : OPRPAR statements CLRPAR ;    

function_call : ID OPPAR actual_args CLPAR ;

actual_args : expression more_actual_args
            | /* empty */
            ;

more_actual_args : COMMA expression more_actual_args
                 | /* empty */
                 ;

expression : expression OR expression
           | expression AND expression
           | expression compare_op expression %prec EQ
           | expression PLUS expression
           | expression MINUS expression
           | expression MULT expression
           | expression DIV expression
           | expression MOD expression
           | NOT expression
           | MINUS expression %prec NOT
           | atomic_expression
           ;

atomic_expression : ID
                  | literal
                  | function_call
                  | OPPAR expression CLPAR
                  ;

compare_op : EQ | NE | LT | LE | GT | GE ;

literal : INT_LITERAL
        | BOOL_LITERAL
        | REAL_LITERAL
        ;

%%


/* called when there is a syntax error */

void yyerror(const char *msg)
{
  fprintf(stderr, "error: %s\n", msg);
}
/*
int main()
{
  int token;

  // Just echo all tokens returned by yylex() to the terminal

  printf("== Tokens ==\n");

  while ((token = yylex()) != 0)
    {
      switch (token)
	{
	  case FUN:   printf("FUN"); break;

	  case OPPAR: printf("OPPAR"); break;
	  case CLPAR: printf("CLPAR"); break;

	  case ID:    printf("ID(...)"); break;

	  case INT_LITERAL:
	    printf("INT_LITERAL(%d)", yylval.integer); break;

	  case ERROR:   printf("* lexical error"); break;

	  default:
	    printf("other token: %d", token);

	    break;
	}

      putchar('\n');
    }

  return 0;
}
*/

int main() {
  return yyparse();
}
