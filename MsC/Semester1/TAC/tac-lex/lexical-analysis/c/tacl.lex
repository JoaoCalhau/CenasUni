%{
#include "tacl.tab.h"
%}

/* avoid `input' and `yyunput' not used warnings */
%option noinput
%option nounput

%%

fun		return FUN;

"int"	return INT;
"real"	return REAL;
"bool"	return BOOL;

"var" 	return VAR;
"proc"	return PROC;

","		return COMMA;
";"		return SEMICOLON;

"print"	return PRINT;

"if" 	return IF;
"else"	return ELSE;
"while"	return WHILE;

"^"		return RETURN;

"("		return OPPAR;
")"		return CLPAR;

"["		return OPRPAR;
"]"		return CLRPAR;

"||"	return OR;
"&&"	return AND;

"="		return EQSIGN;
"=="	return EQ;
"!="	return NE;
"<"		return LT;
"<="	return LE;
">"		return GT;
">="	return GE;

"!"		return NOT;

"+"		return PLUS;
"-"		return MINUS;

"*"		return MULT;
"/"		return DIV;
"%"		return MOD;

"true" {
	yylval.integer = 1;

	return BOOL_LITERAL;
}

"false" {
	yylval.integer = 0;

	return BOOL_LITERAL;
}

[_a-zA-Z][_a-zA-Z0-9]*	{
	yylval.string = strdup(yytext);

	return ID;
}

[0-9]+	{
	yylval.integer = atoi(yytext);

	return INT_LITERAL;
}

[0-9]+\.[0-9]+ {
	yylval.real = atof(yytext);

	return REAL_LITERAL;  
}	

#.*		; /* ignore comments */

[ \t\n]+	; /* and whitespace */

.	{
	fprintf(stderr, "unrecognised character: `%c'\n", *yytext);

	return ERROR;
}
