%{
	#include <stdio.h>
	#include <stdlib.h>
	#include "mips.c"

	int yylex(void);
	void yyerror(const char *);
%}

%error-verbose

%union {
	char *string;
	int integer;

	struct declarations *declarations;
	struct declaration *declaration;
	struct global_var *global_var;
	struct fun_arg *fun_arg;
	struct fun *fun;
	struct body *body;
	struct line *line;
	struct double_inst *double_inst;
	struct single_inst *single_inst;
	struct load_inst *load_inst;
	struct value_inst *value_inst;
	struct store_inst *store_inst;
	struct jump_inst *jump_inst;
	struct cjump_inst *cjump_inst;
	struct fun_call_inst *fun_call;
	struct print_inst *print_inst;
	struct fun_args *fun_args;
	struct args *args;
	struct more_args *more_args;
	struct dinst *dinst;
	struct sinst *sinst;
	struct store *store;
	struct load *load;
	struct print *print;
	struct ret *ret;
	struct temporary *temporary;
	struct label *label;
	struct initial_value *initial_value;
	struct type *type_t;
}

%token <string> IDENTIFIER
%token <integer> INT_LITERAL
%token <integer> BOOL_LITERAL

%token OPPAR CLPAR OPRPAR CLRPAR
%token COMMA ARROW COLON
%token FUNCTION FUN VAR ID
%token INT BOOL VOID
%token JUMP CJUMP
%token EQ NE LT LE
%token ADD SUB MUL DIV
%token MOD NOT INV
%token GLOAD LLOAD ALOAD
%token VALUE
%token CALL ICALL
%token IPRINT BPRINT
%token GSTORE LSTORE ASTORE
%token RETURN IRETURN
%token COPY
%token TEMP LABEL

%type <declarations>		declarations
%type <declaration> 		declaration
%type <global_var> 			global_var
%type <fun_arg> 			fun_arg
%type <fun> 				fun
%type <body>				body
%type <line>				line
%type <double_inst>			double_inst
%type <single_inst> 		single_inst
%type <load_inst>			load_inst
%type <value_inst> 			value_inst
%type <store_inst> 			store_inst
%type <jump_inst> 			jump_inst
%type <cjump_inst> 			cjump_inst
%type <fun_call>			fun_call
%type <print_inst> 			print_inst
%type <fun_args>			fun_args
%type <args>				args
%type <more_args> 			more_args
%type <dinst> 				dinst
%type <sinst>				sinst
%type <store> 				store
%type <load>				load
%type <print>				print
%type <ret>					ret
%type <temporary> 			temp
%type <label>				label
%type <initial_value> 		initial_value
%type <type_t>				type

%%

program : declarations																		{mips_code_gen($1);} ;

declarations : declaration declarations 													{$$ = new_decls(not_empty, $1, $2);}
		     | /* empty */ 																	{$$ = NULL;}
		     ;

declaration : global_var 																	{$$ = new_decl_gvar(gvar_, $1);}
			| fun_arg 																		{$$ = new_decl_farg(farg_, $1);}
			| fun 																			{$$ = new_decl_fun(fun_, $1);}
			;

global_var : OPPAR ID IDENTIFIER VAR type CLPAR  											{$$ = new_gvar(not_init, $3, $5, NULL);}
		   | OPPAR ID IDENTIFIER VAR type initial_value CLPAR 								{$$ = new_gvar(init_, $3, $5, $6);}
		   ;

fun_arg : OPPAR ID IDENTIFIER FUN type OPRPAR fun_args CLRPAR OPRPAR fun_args CLRPAR CLPAR  {$$ = new_farg($3, $5, $7, $10);} ;

fun : FUNCTION IDENTIFIER body 																{$$ = new_fun($2, $3);} ;

body : line body 																			{$$ = new_body_line(line_, $2, $1);}
	 | label COLON body 																	{$$ = new_body_label(label_, $3, $1);}
	 | ret 																					{$$ = new_body_ret(return_body, $1);}
	 ;

line : double_inst 																			{$$ = new_line_double(dinst_, $1);}
	 | single_inst 																			{$$ = new_line_single(sinst_, $1);}
	 | load_inst 																			{$$ = new_line_load(load_, $1);}
	 | value_inst 																			{$$ = new_line_value(value_, $1);}
	 | store_inst 																			{$$ = new_line_store(store_, $1);}
     | jump_inst 																			{$$ = new_line_jump(jump_, $1);}
     | cjump_inst 																			{$$ = new_line_cjump(cjump_, $1);}
     | fun_call 																			{$$ = new_line_fcall(fcall_inst_, $1);}
     | print_inst 																			{$$ = new_line_print(print_, $1);}
     ;

double_inst : temp ARROW dinst temp COMMA temp 												{$$ = new_double_inst($1, $3, $4, $6);} ;

single_inst : temp ARROW sinst temp 														{$$ = new_single_inst($1, $3, $4);} ;

load_inst : temp ARROW load IDENTIFIER 														{$$ = new_load_inst($1, $3, $4);} ;

value_inst : temp ARROW VALUE INT_LITERAL 													{$$ = new_value_inst($1, $4);} ;

store_inst : IDENTIFIER ARROW store temp 													{$$ = new_store_inst($1, $3, $4);} ;

jump_inst : JUMP label 																		{$$ = new_jump_inst($2);} ;

cjump_inst : CJUMP temp COMMA label COMMA label												{$$ = new_cjump_inst($2, $4, $6);} ;

print_inst : print temp 																	{$$ = new_print_inst($1, $2);} ;

fun_args : OPPAR type IDENTIFIER CLPAR fun_args 											{$$ = new_fargs(not_empty, $2, $3, $5);}
		 | /* empty */ 																		{$$ = NULL;}
		 ;

args : temp more_args 																		{$$ = new_args(not_empty, $1, $2);}
     | /* empty */ 																			{$$ = new_args(empty_, NULL, NULL);}
     ;

more_args : COMMA temp more_args 															{$$ = new_margs(not_empty, $2, $3);}
		  | /* empty */ 																	{$$ = new_margs(empty_, NULL, NULL);}
		  ;

fun_call : CALL IDENTIFIER COMMA OPRPAR args CLRPAR  										{$$ = new_fcall_inst(call_, NULL, $2, $5);}
		 | temp ARROW ICALL IDENTIFIER COMMA OPRPAR args CLRPAR 							{$$ = new_fcall_inst(icall_, $1, $4, $7);}
		 ;

dinst : EQ 																					{$$ = new_dinst(eq_);}
	  | NE																					{$$ = new_dinst(ne_);}
	  | LT																					{$$ = new_dinst(lt_);}
	  | LE																					{$$ = new_dinst(le_);}
	  | ADD																					{$$ = new_dinst(add_);}
	  | SUB																					{$$ = new_dinst(sub_);}
	  | MUL																					{$$ = new_dinst(mul_);}
	  | DIV																					{$$ = new_dinst(div_);}
	  | MOD																					{$$ = new_dinst(mod_);}
	  ;

sinst : NOT																					{$$ = new_sinst(not_);}
	  | INV																					{$$ = new_sinst(inv_);}
	  | COPY																				{$$ = new_sinst(copy_);}
	  ;

store : GSTORE 																				{$$ = new_store(gstore_);}
	  | LSTORE																				{$$ = new_store(lstore_);}
	  | ASTORE																				{$$ = new_store(astore_);}
	  ;

load : GLOAD																				{$$ = new_load(gload_);}
	 | LLOAD																				{$$ = new_load(lload_);}
	 | ALOAD																				{$$ = new_load(aload_);}
	 ;

print : IPRINT																				{$$ = new_print(iprint_);}
	  | BPRINT																				{$$ = new_print(bprint_);}
	  ;


ret : RETURN 																				{$$ = new_ret(return_);}
	| IRETURN temp  																		{$$ = new_iret(ireturn_, $2);}
	;

temp : TEMP INT_LITERAL 																	{$$ = new_temp($2);} ;

label : LABEL INT_LITERAL 																	{$$ = new_label($2);} ;

initial_value : INT_LITERAL 																{$$ = new_ivalue(int_value, $1);}
			  | BOOL_LITERAL																{$$ = new_ivalue(bool_value, $1);}
			  ;

type : INT 																					{$$ = new_type(int_);}
	 | BOOL																					{$$ = new_type(bool_);}
	 | VOID																					{$$ = new_type(void_);}
	 ;

%%


void yyerror(const char *msg) {
	fprintf(stderr, "error: %s\n", msg);
}


int main() {
	return yyparse();
}
