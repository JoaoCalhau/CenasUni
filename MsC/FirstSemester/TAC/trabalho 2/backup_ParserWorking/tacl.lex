%{
	#include "tacl.tab.h"
%}

%option noinput
%option nounput

%%

"("			return OPPAR;
")"			return CLPAR;
"["			return OPRPAR;
"]"			return CLRPAR;

","			return COMMA;
":" 		return COLON;
"<-"		return ARROW;

function 	return FUNCTION;
fun 		return FUN;
var			return VAR;
id 			return ID;
int 		return INT;
void 		return VOID;
bool 		return BOOL;

jump 		return JUMP;
cjump 		return CJUMP;

i_eq		return EQ;
i_ne 		return NE;
i_lt 		return LT;
i_le 		return LE;
i_gt 		return GT;
i_ge 		return GE;

i_add 		return ADD;
i_sub 		return SUB;
i_mul 		return MUL;
i_div 		return DIV;

mod 		return MOD;
not 		return NOT;
i_inv 		return INV;

i_gload 	return GLOAD;
i_lload 	return LLOAD;
i_aload 	return ALOAD;

i_value 	return VALUE;

call 		return CALL;
i_call 		return ICALL;

i_print 	return IPRINT;
b_print 	return BPRINT;

i_gstore 	return GSTORE;
i_lstore 	return LSTORE;
i_astore 	return ASTORE;


return 		return RETURN;
i_return 	return IRETURN;

i_copy 		return COPY;


"true" {
	yylval.integer = 1;

	return BOOL_LITERAL;
}

"false" {
	yylval.integer = 0;

	return BOOL_LITERAL;
}

"@"[_a-zA-Z][_a-zA-Z0-9]*	{
	yylval.string = strdup(yytext);

	return IDENTIFIER;
}

"t"[0-9]+	{
	yylval.integer = atoi(yytext);

	return TEMPORARY;
}

"l"[0-9]+	{
	yylval.integer = atoi(yytext);

	return LABEL;
}

[0-9]+	{
	yylval.integer = atoi(yytext);

	return INT_LITERAL;
}

[ \t\n]+ ;
