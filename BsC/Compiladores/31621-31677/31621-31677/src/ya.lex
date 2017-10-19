%{
#include <stdlib.h> 
#include <stdbool.h>
#include "parser.h"
%}


INT	[0-9]+
FLOAT [0-9]*\.[0-9]+([eE][\+\-]?[0-9]+)?
ID	[a-zA-Z][a-zA-Z0-9_]*
STRING \".*\"
BOOL "true"|"false"

COMPLEX ([0-9]*\.?[0-9]+)?[\+\-]?([0-9]*\.?[0-9]+)[i]?





%%

"mod"	{ return MOD; }
"and"	{ return AND; }
"or"	{ return OR; }
"not"	{ return NOT; }

"int"		{ return INT;}
"float"		{ return FLOAT;}
"string"	{ return STRING;}
"bool"		{ return BOOL;}
"void"		{ return VOID;}

"define"	{ return DEFINE; }
"if"		{ return IF; }
"then"		{ return THEN; }
"else"		{ return ELSE; }
"while"		{ return WHILE; }
"do"		{ return DO; }


"return"	{ return RETURN; }
"next"		{ return NEXT; }
"break"		{ return BREAK; }



";"  	{return ENDOFSTM;}
"("	 	{ return LPAR; }
")"	 	{ return RPAR; }
"["  	{ return LPARR; }
"]"  	{ return RPARR; }
"{"  	{ return LCHAV; }
"}"  	{ return RCHAV; }
"."	 	{ return POINT; }
","  	{ return COMMA; }
":"  	{ return DOUBLEQUOTE;}
"="	 	{ return ASSIGN; }

"+"	 	{ return ADD; }
"-"	 	{ return SUB; }
"/"	 	{ return DIV; }
"*"	 	{ return MUL; }
"^"  	{ return EXPOENT; }

"==" 	{ return EQUAL; }
"!=" 	{ return DIFF; }
"<=" 	{ return LESSOREQUAL;}
"<" 	{ return LESS;}
">=" 	{ return GREATEROREQUAL;}
">" 	{ return GREATER;}


{BOOL}   { yylval.boleano = strdup(yytext); return BOOL_LIT;}

{INT}    { yylval.inteiro = atof(yytext); return INT_LIT; }
{FLOAT}  { yylval.floatt = atof(yytext); return FLOAT_LIT; }
{STRING} { yylval.string = strdup(yytext); return STRING_LIT;}
{ID}	 { yylval.string = strdup(yytext); return ID; }









[ \n\t]+	 /*ignorar*/

%%

int yywrap()  {return 1;}
