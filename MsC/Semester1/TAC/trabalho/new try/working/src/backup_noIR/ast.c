#include "ast.h"

global_decl *new_global_decl(decl *declaration, global_decl *global_declaration) {
	global_decl *new_ = malloc(sizeof(global_decl));

	new_->declaration = declaration;
	new_->global_declaration = global_declaration;

	return new_;
}

decls *new_decls(decl *declaration, decls *declarations) {
	decls *new_ = malloc(sizeof(decls));

	new_->declaration = declaration;
	new_->declarations = declarations;

	return new_;
}

decl *new_decl_var(decl_kind kind, id *id, exp *expression) {
	decl *new_ = malloc(sizeof(decl));

	new_->kind = kind;
	new_->u1.id = id;
	new_->u2.expression = expression;

	return new_;
}

decl *new_decl_fun(decl_kind kind, char *identifier, formal_args *formal_args, body *body) {
	decl *new_ = malloc(sizeof(decl));

	new_->kind = kind;
	new_->u1.identifier = strdup(identifier);
	new_->u2.formal_args = formal_args;
	new_->u3.body = body;

	return new_;
}

id *new_id(char *identifier, kind *kind, type *type) {
 	id *new_ = malloc(sizeof(id));

 	new_->identifier = strdup(identifier);
 	new_->kind = kind;
 	new_->type = type;

 	return new_;
}

formal_args *new_formal_arg(char *identifier, type *type, formal_args *formal_args) {
 	struct ast_formal_args *new_ = malloc(sizeof(struct ast_formal_args));

 	new_->identifier = strdup(identifier);
 	new_->type = type;
 	new_->formal_args = formal_args;

 	return new_;
}

body *new_body(decls *declarations, stmt *statement, exp *expression) {
 	body *new_ = malloc(sizeof(body));

 	new_->declarations = declarations;
 	new_->statement = statement;
 	new_->expression = expression;

 	return new_;
}

stmts *new_stmts(stmt *statement, stmts* statements) {
 	stmts *new_ = malloc(sizeof(stmts));

 	new_->statement = statement;
 	new_->statements = statements;

	return new_;
}

stmt *new_stmt_assign(stmt_kind kind, assign *assign) {
	stmt *new_ = malloc(sizeof(stmt));

	new_->kind = kind;
	new_->u1.assign = assign;

	return new_;
}

stmt *new_stmt_call(stmt_kind kind, fun_call *fun_call) {
	stmt *new_ = malloc(sizeof(stmt));

	new_->kind = kind;
	new_->u1.fun_call = fun_call;

	return new_;
}

stmt *new_stmt_print(stmt_kind kind, print *print) {
	stmt *new_ = malloc(sizeof(stmt));

	new_->kind = kind;
	new_->u1.print = print;

	return new_;
}

stmt *new_stmt_conditional(stmt_kind kind, conditional *conditional) {
	stmt *new_ = malloc(sizeof(stmt));

	new_->kind = kind;
	new_->u1.conditional = conditional;

	return new_;
}

stmt *new_stmt_loop(stmt_kind kind, loop *loop) {
	stmt *new_ = malloc(sizeof(stmt));

	new_->kind = kind;
	new_->u1.loop = loop;

	return new_;
}

stmt *new_stmt_compound(stmt_kind kind, compound *compound) {
	stmt *new_ = malloc(sizeof(stmt));

	new_->kind = kind;
	new_->u1.compound = compound;

	return new_;
}

stmt *new_stmt_empty(stmt_kind kind, empty *empty) {
	stmt *new_ = malloc(sizeof(stmt));

	new_->kind = kind;
	new_->u1.empty = empty;

	return new_;
}


assign *new_assign(id *id, exp *expression) {
	assign *new_ = malloc(sizeof(assign));

	new_->id = id;
	new_->expression = expression;

	return new_;
}

fun_call *new_fun_call(char *identifier, exps *expressions) {
	fun_call *new_ = malloc(sizeof(fun_call));

	new_->identifier = strdup(identifier);
	new_->expressions = expressions;

	return new_;
}

print *new_print(exp *expression) {
	print *new_ = malloc(sizeof(print));

	new_->expression = expression;

	return new_;
}

conditional *new_conditional(exp *expression, stmt *statement1, stmt *statement2) {
	conditional *new_ = malloc(sizeof(conditional));

	new_->expression = expression;
	new_->statement1 = statement1;
	new_->statement2 = statement2;

	return new_;
}

loop *new_loop(exp *expression, stmt *statement) {
	loop *new_ = malloc(sizeof(loop));

	new_->expression = expression;
	new_->statement = statement;

	return new_;
}

compound *new_compound(stmts *statements) {
	compound *new_ = malloc(sizeof(compound));

	new_->statements = statements;

	return new_;
}


exps *new_exps(exp *expression, exps* expressions) {
	exps *new_ = malloc(sizeof(exps));

	new_->expression = expression;
	new_->expressions = expressions;

	return new_;
}


exp *new_exp_compare(exp_kind kind, type *type, exp *expression1, exp *expression2, compare_op *compare_op) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.expression1 = expression1;
	new_->u2.expression2 = expression2;
	new_->u3.compare_op = compare_op;

	return new_;
}

exp *new_exp_two(exp_kind kind, type *type, exp *expression1, exp *expression2) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.expression1 = expression1;
	new_->u2.expression2 = expression2;

	return new_;
}

exp *new_exp_one(exp_kind kind, type *type, exp *expression) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.expression1 = expression;

	return new_;
}

exp *new_exp_id(exp_kind kind, type *type, id *id) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.id = id;

	return new_;
}

exp *new_exp_int_lit(exp_kind kind, type *type, int integer) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.integer = integer;

	return new_;
}

exp *new_exp_real_lit(exp_kind kind, type *type, double real) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.real = real;

	return new_;
}

exp *new_exp_bool(exp_kind kind, type *type, int integer) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.integer = integer;

	return new_;
}

exp *new_exp_call(exp_kind kind, type *type, fun_call *fun_call) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.fun_call = fun_call;

	return new_;
}

exp *new_exp_toreal(exp_kind kind, type *type, toreal *toreal) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.toreal = toreal;

	return new_;
}

exp *new_exp_empty(exp_kind kind, type *type, empty *empty) {
	exp *new_ = malloc(sizeof(exp));

	new_->kind = kind;
	new_->type = type;
	new_->u1.empty = empty;

	return new_;
}


toreal *new_toreal(exp *expression) {
	toreal *new_ = malloc(sizeof(toreal));

	new_->expression = expression;

	return  new_;
}

compare_op *new_compare_op(op_kind kind) {
	compare_op *new_ = malloc(sizeof(compare_op));

	new_->kind = kind;

	return new_;
}


empty *new_empty(empty_kind kind) {
	empty *new_ = malloc(sizeof(empty));

	new_->kind = kind;

	return new_;
}


type *new_type(type_kind kind) {
	type *new_ = malloc(sizeof(type));

	new_->kind = kind;

	return new_;
}

kind *new_kind(kind_kind kind) {
	struct ast_kind *new_ = malloc(sizeof(struct ast_kind));

	new_->kind = kind;

	return new_;
}