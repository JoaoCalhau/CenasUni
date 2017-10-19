%{
#include "ya.tab.h"
%}

%option noinput
%option nounput


%%

print 	return PRINT;
input 	return INPUT;

int 	return INT;
float 	return FLOAT;
string 	return STRING;
bool 	return BOOL;
void 	return VOID;

define 	return DEFINE;

if 		return IF;
then 	return THEN;
else 	return ELSE;

while 	return WHILE;
do 		return DO;

return 	return RETURN;
break 	return BREAK;
next 	return NEXT;

"=" 	return EQSIGN;
":" 	return COLUMN;
"," 	return COMMA;

"(" 	return OPPAR;
")" 	return CLPAR;

"{" 	return OPCURLYPAR;
"}" 	return CLCURLYPAR;

"[" 	return OPRPAR;
"]" 	return CLRPAR;

"+" 	return PLUS;
"-" 	return MINUS;
"*" 	return MULT;
"/" 	return DIV;

"^" 	return EXP;

"==" 	return EQUALS;
"!=" 	return NE;

"<" 	return LT;
">" 	return GT;
"<=" 	return LE;
">=" 	return GE;

mod 	return MOD;
and 	return AND;
or 		return OR;
not 	return NOT;


true {
	yylval.integer = 1;

	return BOOL_LITERAL;
}

false {
	yylval.integer = 0;

	return BOOL_LITERAL;
}

[_a-zA-Z][_a-zAZ0-9]* {
	yylval.string = strdup(yytext);

	return STRING_LITERAL;
}

[0-9]+ {
	yylval.integer = atoi(yytext);

	return INT_LITERAL;
}

[0-9]+\.[0-9]+ {
	yylval.real = atof(yytext);

	return FLOAT_LITERAL;
}

[ \t\n]+  /*Ignore whitespace */;

%%