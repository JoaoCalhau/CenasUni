%{
#include <stdio.h>
#include <string.h>
#include <math.h>
int yylex (void);
void yyerror (char const *);

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
			
%type	<val>		line exp
%%


input:   /* empty */
	| 	input line
;

line:   	NL      { $$ = 0; }
	| 	exp NL  { $$ = $1; printf ("%.2lf\n", $$); }
;

exp:      	NUM                { $$ = $1; }
	| 	ID                 { $$ = get_value($1); }
	| 	exp ADD exp        { $$ = $1 + $3; }
        | 	exp SUB exp        { $$ = $1 - $3; }
        | 	exp MUL exp        { $$ = $1 * $3; }
        | 	exp DIV exp        { $$ = $1 / $3; }
        | 	SUB exp  %prec NEG { $$ = (0 - $2); }
        | 	LPAR exp RPAR      { $$ = $2; }
        |   exp EXP exp        { $$ = pow($1, $3); }
        |   LOG LPAR exp RPAR   { $$ = log($3); }
        |   SIN LPAR exp RPAR   { $$ = sin($3); }
	|	ID ASSIGN exp      { set_value($1, $3); $$ = $3; }
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
