%{
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include "apt.h"

int yylex(void);
void yyerror(char const *);

void set_value(char *id, double value);
double get_value(char *id);
%}

			
%union {
    
    double val;
    char *id;
}
			
/* Bison declarations.  */
%token	<val>		NUM
%token	<id>		ID
					
%token			NL /* newline */
%token          LOG SIN

%right			ASSIGN
%left			SUB ADD 
%left			MUL DIV
%right          EXP
%left			NEG     /* negation--unary minus */

%token			LPAR RPAR
			
%type	<val>		seq exp
%%


input:   /* empty */
	| 	seq
;

seq: exp NL {$$ = calc_seq_empty($1); }
	 | exp NL seq {$$ = calc_seq_list($1, $3); }
;




exp:      	NUM                { $$ = calc_exp_new_num($1); }
	| 	ID                 { $$ = calc_exp_new_id($1); }
	| 	exp ADD exp        { $$ = calc_Exp_new_binop('+', $1, $3); }
        | 	exp SUB exp        { $$ = calc_exp_new_binop('-', $1, $3); }
        | 	exp MUL exp        { $$ = calc_exp_new_binop('*', $1, $3); }
        | 	exp DIV exp        { $$ = calc_exp_new_binop('/', $1, $3); }
        | 	SUB exp  %prec NEG { $$ = calc_exp_new_binop('-', 0, $2); }
        | 	LPAR exp RPAR      { $$ = $2; }
        |   exp EXP exp        { $$ = calc_exp_new_binop('^' $1, $3); }
        |   LOG LPAR exp RPAR   { $$ = calc_exp_new_unop("log", $3); }
        |   SIN LPAR exp RPAR   { $$ = calc_exp_new_unop("sin", $3); }
	|	ID ASSIGN exp      { calc_exp_new_assign($1, $3); }
;
%%

/* Called by yyparse on error.  */
struct varval {
    char *id;
    double val;
};

struct varval TABLE[256];  /* 256 vars seems enough... */
int TBLPTR = 0;            /* current TABLE index */

void set_value(char *id, double value)
{
    TABLE[TBLPTR].id = id;
    TABLE[TBLPTR].val = value;

    TBLPTR++;
}

double get_value(char *id)
{
    int i;

    for (i = 0; i < TBLPTR; i++) {
	if (strcmp(id, TABLE[i].id) == 0) {
	    return TABLE[i].val;
        }
    }

    return 0;
}

void yyerror (char const *s)
{
  fprintf (stderr, "%s\n", s);
}

int main (void)
{
  return yyparse();
}