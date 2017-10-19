%{
#include <stdlib.h> 
#include "parser.h"

%}

INT	[0-9]+
FLOAT [0-9]*\.[0-9]+
ID	[a-zA-Z][a-zA-Z0-9_]*


%%

{INT}    { yylval.val = atof(yytext); return NUM; }
{FLOAT} 	{yylval.val = atof(yytext); return NUM; }
"+"	 { return ADD; }
"-"	 { return SUB; }
"/"	 { return DIV; }
"*"	 { return MUL; }
"("	 { return LPAR; }
")"	 { return RPAR; }
"="	 { return ASSIGN; }
"^"  { return EXP; }
"log"  { return LOG; }
"sin"  { return SIN; }
"quit"	 { exit(0); }
{ID}	 { yylval.id = strdup(yytext); return ID; }
\n	 { return NL; }
.	 {/*ignorar*/}

%%

int yywrap()  {return 1;}
