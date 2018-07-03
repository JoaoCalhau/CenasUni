#include "tree.h"

decls *new_decls(isEmpty kind, decl *declaration, decls *declarations) {
	decls *new_ = malloc(sizeof(decls));

	new_->kind = kind;
	new_->declaration = declaration;
	new_->declarations = declarations;

	return new_;
}

decl *new_decl_gvar(decl_kind kind, gvar *global_var) {
	decl *new_ = malloc(sizeof(decl));

	new_->kind = kind;
	new_->u1.global_var = global_var;

	return new_;
}

decl *new_decl_farg(decl_kind kind, farg *fun_arg) {
	decl *new_ = malloc(sizeof(decl));

	new_->kind = kind;
	new_->u1.fun_arg = fun_arg;

	return new_;
}

decl *new_decl_fun(decl_kind kind, fun *fun) {
	decl *new_ = malloc(sizeof(decl));

	new_->kind = kind;
	new_->u1.fun = fun;

	return new_;
}

gvar *new_gvar(gvar_kind kind, char *identifier, type *type, ivalue *initial_value) {
	gvar *new_ = malloc(sizeof(gvar));

	new_->kind = kind;
	new_->identifier = strdup(identifier);
	new_->type = type;
	new_->initial_value = initial_value;

	return new_;
}

farg *new_farg(char *identifier, type *type, fargs *fun_args, fargs *fun_locals) {
	farg *new_ = malloc(sizeof(farg));

	new_->identifier = strdup(identifier);
	new_->type = type;
	new_->fun_args = fun_args;
	new_->fun_locals = fun_locals;

	return new_;
}

fun *new_fun(char *identifier, body *body) {
	fun *new_ = malloc(sizeof(fun));

	new_->identifier = strdup(identifier);
	new_->body = body;

	return new_;
}

body *new_body_line(body_kind kind, body *b, line *line) {
	body *new_ = malloc(sizeof(body));

	new_->kind = kind;
	new_->body = b;
	new_->u1.line = line;

	return new_;
}

body *new_body_label(body_kind kind, body *b, label *label) {
	body *new_ = malloc(sizeof(body));

	new_->kind = kind;
	new_->body = b;
	new_->u1.label = label;

	return new_;
}

body *new_body_ret(body_kind kind, ret *ret) {
	body *new_ = malloc(sizeof(body));

	new_->kind = kind;
	new_->body = NULL;
	new_->u1.ret = ret;

	return new_;
}

line *new_line_double(line_kind kind, double_inst *double_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.double_inst = double_inst;

	return new_;
}

line *new_line_single(line_kind kind, single_inst *single_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.single_inst = single_inst;

	return new_;
}

line *new_line_load(line_kind kind, load_inst *load_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.load_inst = load_inst;

	return new_;
}

line *new_line_value(line_kind kind, value_inst *value_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.value_inst = value_inst;

	return new_;
}

line *new_line_store(line_kind kind, store_inst *store_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.store_inst = store_inst;

	return new_;
}

line *new_line_jump(line_kind kind, jump_inst *jump_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.jump_inst = jump_inst;

	return new_;
}

line *new_line_cjump(line_kind kind,cjump_inst *cjump_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.cjump_inst = cjump_inst;

	return new_;
}

line *new_line_fcall(line_kind kind, fcall_inst *fcall_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.fun_call_inst = fcall_inst;

	return new_;
}

line *new_line_print(line_kind kind, print_inst *print_inst) {
	line *new_ = malloc(sizeof(line));

	new_->kind = kind;
	new_->u1.print_inst = print_inst;

	return new_;
}

double_inst *new_double_inst(temp *temporary, dinst *dinst, temp *temporary1, temp *temporary2) {
	double_inst *new_ = malloc(sizeof(double_inst));

	new_->temporary = temporary;
	new_->dinst = dinst;
	new_->temporary1 = temporary1;
	new_->temporary2 = temporary2;

	return new_;
}

single_inst *new_single_inst(temp *temporary, sinst *sinst, temp *temporary1) {
	single_inst *new_ = malloc(sizeof(single_inst));

	new_->temporary = temporary;
	new_->sinst = sinst;
	new_->temporary1 = temporary1;

	return new_;
}

load_inst *new_load_inst(temp *temporary, load *load, char *identifier) {
	load_inst *new_ = malloc(sizeof(load_inst));

	new_->temporary = temporary;
	new_->load = load;
	new_->identifier = strdup(identifier);

	return new_;
}

value_inst *new_value_inst(temp *temporary, int literal) {
	value_inst *new_ = malloc(sizeof(value_inst));

	new_->temporary = temporary;
	new_->literal = literal;

	return new_;
}

store_inst *new_store_inst(char *identifier, store *store, temp *temporary) {
	store_inst *new_ = malloc(sizeof(store_inst));

	new_->identifier = strdup(identifier);
	new_->store = store;
	new_->temporary = temporary;

	return new_;
}

jump_inst *new_jump_inst(label *label) {
	jump_inst *new_ = malloc(sizeof(jump_inst));

	new_->label = label;

	return new_;
}

cjump_inst *new_cjump_inst(temp *temporary, label *label1, label *label2) {
	cjump_inst *new_ = malloc(sizeof(cjump_inst));

	new_->temporary = temporary;
	new_->label1 = label1;
	new_->label2 = label2;

	return new_;
}

print_inst *new_print_inst(print *print_kind, temp *temporary) {
	print_inst *new_ = malloc(sizeof(print_inst));

	new_->print_kind = print_kind;
	new_->temporary = temporary;

	return new_;
}

fargs *new_fargs(isEmpty kind, type *type, char *identifier, fargs *fun_args) {
	fargs *new_ = malloc(sizeof(fargs));

	new_->kind = kind;
	new_->type = type;
	new_->identifier = strdup(identifier);
	new_->fun_args = fun_args;

	return new_;
}

args *new_args(isEmpty kind, temp *temporary, margs *more_args) {
	args *new_ = malloc(sizeof(args));

	new_->kind = kind;
	new_->temporary = temporary;
	new_->more_args = more_args;

	return new_;
}

margs *new_margs(isEmpty kind, temp *temporary, margs *more_args) {
	margs *new_ = malloc(sizeof(margs));

	new_->kind = kind;
	new_->temporary = temporary;
	new_->more_args = more_args;

	return new_;
}

fcall_inst *new_fcall_inst(fcall_kind kind, temp *temporary, char *identifier, args *args) {
	fcall_inst *new_ = malloc(sizeof(fcall_inst));

	new_->kind = kind;
	new_->temporary = temporary;
	new_->identifier = strdup(identifier);
	new_->args = args;

	return new_;
}

dinst *new_dinst(dinst_kind kind) {
	dinst *new_ = malloc(sizeof(dinst));

	new_->kind = kind;

	return new_;
}

sinst *new_sinst(sinst_kind kind) {
	sinst *new_ = malloc(sizeof(sinst));

	new_->kind = kind;

	return new_;
}

store *new_store(store_kind kind) {
	store *new_ = malloc(sizeof(store));

	new_->kind = kind;

	return new_;
}

load *new_load(load_kind kind) {
	load *new_ = malloc(sizeof(load));

	new_->kind = kind;

	return new_;
}

print *new_print(print_kind kind) {
	print *new_ = malloc(sizeof(print));

	new_->kind = kind;

	return new_;
}

ret *new_ret(ret_kind kind, temp *temporary) {
	ret *new_ = malloc(sizeof(ret));

	new_->kind = kind;
	new_->temporary = temporary;

	return new_;
}

temp *new_temp(int literal) {
	temp *new_ = malloc(sizeof(temp));

	new_->literal = literal;

	return new_;
}

label *new_label(int literal) {
	label *new_ = malloc(sizeof(label));

	new_->literal = literal;

	return new_;
}

ivalue *new_ivalue_int(ivalue_kind kind, int literal) {
	ivalue *new_ = malloc(sizeof(ivalue));

	new_->kind = kind;
	new_->u1.iliteral = literal;

	return new_;
}

ivalue *new_ivalue_bool(ivalue_kind kind, bool literal) {
	ivalue *new_ = malloc(sizeof(ivalue));

	new_->kind = kind;
	new_->u1.bliteral = literal;

	return new_;
}

type *new_type(type_kind kind) {
	type *new_ = malloc(sizeof(type));

	new_->kind = kind;

	return new_;
}