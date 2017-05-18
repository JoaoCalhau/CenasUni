#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

typedef enum isEmpty {empty_, not_empty} isEmpty;

typedef enum decl_kind {gvar_, farg_, fun_} decl_kind;

typedef enum gvar_kind {not_init, init_} gvar_kind;

typedef enum body_kind {line_, label_, return_body} body_kind;

typedef enum line_kind {dinst_, sinst_, load_, value_, store_, jump_, cjump_, fcall_inst_, print_} line_kind;

typedef enum fcall_kind {call_, icall_} fcall_kind;

typedef enum dinst_kind {eq_, ne_, lt_, le_, gt_, ge_, add_, sub_, mul_, div_, mod_ } dinst_kind;
typedef enum sinst_kind {not_, inv_, copy_} sinst_kind;

typedef enum store_kind {gstore_, lstore_, astore_} store_kind;
typedef enum load_kind {gload_, lload_, aload_} load_kind;

typedef enum print_kind {iprint_, bprint_} print_kind;

typedef enum ret_kind {return_, ireturn_} ret_kind;

typedef enum ivalue_kind {int_value, bool_value} ivalue_kind;

typedef enum type_kind {int_, bool_, void_} type_kind;

typedef struct declarations decls;
typedef struct declaration decl;

typedef struct global_var gvar;
typedef struct fun_arg farg;
typedef struct fun fun;

typedef struct body body;
typedef struct line line;

typedef struct double_inst double_inst;
typedef struct single_inst single_inst;
typedef struct load_inst load_inst;
typedef struct value_inst value_inst;
typedef struct store_inst store_inst;
typedef struct jump_inst jump_inst;
typedef struct cjump_inst cjump_inst;
typedef struct fun_call_inst fcall_inst;
typedef struct print_inst print_inst;

typedef struct fun_args fargs;
typedef struct args args;
typedef struct more_args margs;


typedef struct dinst dinst;
typedef struct sinst sinst;

typedef struct store store;
typedef struct load load;

typedef struct print print;

typedef struct ret ret;

typedef struct temporary temp;
typedef struct label label;

typedef struct initial_value ivalue;

typedef struct type type;

struct declarations {
	isEmpty kind;
	decl *declaration;
	decls *declarations;
};

struct declaration {
	decl_kind kind;

	union {
		gvar *global_var;
		farg *fun_arg;
		fun *fun;
	} u1;
};

struct global_var {
	gvar_kind kind;
	char *identifier;
	type *type;
	ivalue *initial_value;
};

struct fun_arg {
	char *identifier;
	type *type;
	fargs *fun_args;
	fargs *fun_locals;
};

struct fun {
	char *identifier;
	body *body;
};

struct body {
	body_kind kind;
	body *body;

	union {
		line *line;
		label *label;
		ret *ret;
	} u1;
};

struct line {
	line_kind kind;

	union {
		double_inst *double_inst;
		single_inst *single_inst;
		load_inst *load_inst;
		value_inst *value_inst;
		store_inst *store_inst;
		jump_inst *jump_inst;
		cjump_inst *cjump_inst;
		fcall_inst *fun_call_inst;
		print_inst *print_inst;
	} u1;
};

struct double_inst {
	temp *temporary;
	dinst *dinst;
	temp *temporary1;
	temp *temporary2;
};

struct single_inst {
	temp *temporary;
	sinst *sinst;
	temp *temporary1;
};

struct load_inst {
	temp *temporary;
	load *load;
	char *identifier;
};

struct value_inst {
	temp *temporary;
	int literal;
};

struct store_inst {
	char *identifier;
	store *store;
	temp *temporary;
};

struct jump_inst {
	label *label;
};

struct cjump_inst {
	temp *temporary;
	label *label1;
	label *label2;
};

struct print_inst {
	print *print_kind;
	temp *temporary;
};

struct fun_args {
	isEmpty kind;
	type *type;
	char *identifier;
	fargs *fun_args;
};

struct args {
	isEmpty kind;
	temp *temporary;
	margs *more_args;
};

struct more_args {
	isEmpty kind;
	temp *temporary;
	margs *more_args;
};

struct fun_call_inst {
	fcall_kind kind;
	temp *temporary;
	char *identifier;
	args *args;
};

struct dinst {
	dinst_kind kind;
};

struct sinst {
	sinst_kind kind;
};

struct store {
	store_kind kind;
};

struct load {
	load_kind kind;
};

struct print {
	print_kind kind;
};

struct ret {
	ret_kind kind;
	temp *temporary;
};

struct temporary {
	int literal;
};

struct label {
	int literal;
};

struct initial_value {
	ivalue_kind kind;
	int literal;
};

struct type {
	type_kind kind;
};

decls *new_decls(isEmpty kind, decl *declaration, decls *declarations);

decl *new_decl_gvar(decl_kind kind, gvar *global_var);
decl *new_decl_farg(decl_kind kind, farg *fun_arg);
decl *new_decl_fun(decl_kind kind, fun *fun);

gvar *new_gvar(gvar_kind kind, char *identifier, type *type, ivalue *initial_value);

farg *new_farg(char *identifier, type *type, fargs *fun_args, fargs *fun_locals);

fun *new_fun(char *identifier, body *body);

body *new_body_line(body_kind kind, body *b, line *line);
body *new_body_label(body_kind kind, body *b, label *label);
body *new_body_ret(body_kind kind, ret *ret);

line *new_line_double(line_kind kind, double_inst *double_inst);
line *new_line_single(line_kind kind, single_inst *single_inst);
line *new_line_load(line_kind kind, load_inst *load_inst);
line *new_line_value(line_kind kind, value_inst *value_inst);
line *new_line_store(line_kind kind, store_inst *store_inst);
line *new_line_jump(line_kind kind, jump_inst *jump_inst);
line *new_line_cjump(line_kind kind,cjump_inst *cjump_inst);
line *new_line_fcall(line_kind kind, fcall_inst *fcall_inst);
line *new_line_print(line_kind kind, print_inst *print_inst);

double_inst *new_double_inst(temp *temporary, dinst *dinst, temp *temporary1, temp *temporary2);

single_inst *new_single_inst(temp *temporary, sinst *sinst, temp *temporary1);

load_inst *new_load_inst(temp *temporary, load *load, char *identifier);

value_inst *new_value_inst(temp *temporary, int literal);

store_inst *new_store_inst(char *identifier, store *store, temp *temporary);

jump_inst *new_jump_inst(label *label);

cjump_inst *new_cjump_inst(temp *temporary, label *label1, label *label2);

print_inst *new_print_inst(print *print_kind, temp *temporary);

fargs *new_fargs(isEmpty kind, type *type, char *identifier, fargs *fun_args);

args *new_args(isEmpty kind, temp *temporary, margs *more_args);

margs *new_margs(isEmpty kind, temp *temporary, margs *more_args);

fcall_inst *new_fcall_inst(fcall_kind kind, temp *temporary, char *identifier, args *args);

dinst *new_dinst(dinst_kind kind);

sinst *new_sinst(sinst_kind kind);

store *new_store(store_kind kind);

load *new_load(load_kind kind);

print *new_print(print_kind kind);

ret *new_iret(ret_kind kind, temp *temporary);

ret *new_ret(ret_kind kind);

temp *new_temp(int literal);

label *new_label(int literal);

ivalue *new_ivalue_int(ivalue_kind kind, int literal);

type *new_type(type_kind kind);