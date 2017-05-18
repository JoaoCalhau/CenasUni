%{
#include "tacl.tab.h"	
%}

/* avoid 'input' and 'yyunput' not used warnings */
%option noinput
%option nounput

%%

"("				return OPPAR;
")"				return CLPAR;
"["				return OPRPAR;
"]"				return CLRPAR; 

":"				return COLON;

nil				return NIL;

id 				return ID;
local			return LOCAL;

var				return VAR;
fun				return FUN;

arg				return ARG;

body			return BODY;

assign			return ASSIGN;
call			return CALL;
print 			return PRINT;
if 				return IF;
while 			return WHILE;

or 				return OR;
and 			return AND;
eq				return EQ;
ne				return NE;
lt				return LT;
le				return LE;
gt				return GT;
ge				return GE;
plus			return PLUS;
minus			return MINUS;
times			return TIMES;
div				return DIV;
mod				return MOD;
not 			return NOT;
inv				return INV;
true		  	return TRUE;
false		 	return FALSE;
toreal		  	return TOREAL;
int_literal   	return I_LITERAL;
real_literal 	return R_LITERAL;

int 			return INT;
real 			return REAL;
bool 			return BOOL;

\"[_a-zA-Z][_a-zA-Z0-9]*\"	{
	yylval.string = strdup(yytext);

	return IDENTIFIER;
}

[0-9]+	{
	yylval.integer = atoi(yytext);

	return INT_LITERAL;
}

[0-9]+\.[0-9]+ {
	yylval.real = atof(yytext);

	return REAL_LITERAL;  
}

[ \t\n]+ ;
