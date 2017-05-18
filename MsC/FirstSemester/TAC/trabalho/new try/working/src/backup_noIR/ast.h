#include <stdio.h>
#include <string.h>
#include <stdlib.h>


typedef enum empty_kind {nil_} empty_kind;

typedef enum decl_kind {var_decl, fun_decl} decl_kind;

typedef enum stmt_kind {assign_, call_, print_, conditional_, loop_, compound_, empty_stmt} stmt_kind;

typedef enum exp_kind {compare_, plus_, minus_, times_, div_, mod_, not_, inv_, id_, int_lit, real_lit, bool_exp, call_exp, toreal_, empty_exp} exp_kind;

typedef enum op_kind {or_, and_, eq_, ne_, lt_, le_, gt_, ge_} op_kind;

typedef enum type_kind {int_, real_, bool_, void_} type_kind;
typedef enum kind_kind {var_, local_, arg_} kind_kind;

typedef struct ast_global_decl global_decl;

typedef struct ast_decls decls;
typedef struct ast_decl decl;

typedef struct ast_id id;

typedef struct ast_formal_args formal_args;

typedef struct ast_body body;

typedef struct ast_stmts stmts;
typedef struct ast_stmt stmt;

typedef struct ast_assign assign;
typedef struct ast_fun_call fun_call;
typedef struct ast_print print;
typedef struct ast_conditional conditional;
typedef struct ast_loop loop;
typedef struct ast_compound compound;

typedef struct ast_exps exps;
typedef struct ast_exp exp;

typedef struct ast_toreal toreal;
typedef struct ast_compare_op compare_op;

typedef struct ast_empty empty;

typedef struct ast_type type;
typedef struct ast_kind kind;


struct ast_global_decl {
	decl *declaration;
	global_decl *global_declaration;
};

struct ast_decls {
	decl *declaration;
	decls *declarations;
};

struct ast_decl {
	decl_kind kind;

	union {
		id *id;
		char *identifier;
	} u1;

	union {
		exp *expression;
		formal_args *formal_args;
	} u2;

	union {
		body *body;
	} u3;
};

struct ast_id {
	char *identifier;
	kind *kind;
	type *type;
};

struct ast_formal_args {
	char *identifier;
	type *type;
	formal_args *formal_args;
};

struct ast_body {
	decls *declarations;
	stmt *statement;
	exp *expression;
};

struct ast_stmts {
	stmt *statement;
	stmts *statements;
};

struct ast_stmt {
	stmt_kind kind;

	union {
		assign *assign;
		fun_call * fun_call;
		print *print;
		conditional *conditional;
		loop *loop;
		compound *compound;
		empty *empty;
	} u1;
};

struct ast_assign {
	id *id;
	exp *expression;
};

struct ast_fun_call {
	char *identifier;
	exps *expressions;
};

struct ast_print {
	exp *expression;
};

struct ast_conditional {
	exp *expression;
	stmt *statement1;
	stmt *statement2;
};

struct ast_loop {
	exp *expression;
	stmt *statement;
};

struct ast_compound {
	stmts *statements;
};

struct ast_exps {
	exp *expression;
	exps *expressions;
};

struct ast_exp {
	exp_kind kind;
	type *type;

	union {
		exp *expression1;
		int integer;
		double real;
		id *id;
		fun_call *fun_call;
		toreal *toreal;
		empty *empty;
	} u1;

	union {
		exp *expression2;
	} u2;

	union {
		compare_op *compare_op;
	} u3;
};

struct ast_toreal {
	exp *expression;
};

struct ast_compare_op {
	op_kind kind;
};

struct ast_empty {
	empty_kind kind;
};

struct ast_type {
	type_kind kind;
};

struct ast_kind {
	kind_kind kind;
};

global_decl *new_global_decl(decl *declaration, global_decl *global_declaration);

decls *new_decls(decl *declaration, decls *declarations);

decl *new_decl_var(decl_kind kind, id *id, exp *expression);
decl *new_decl_fun(decl_kind kind, char *identifier, formal_args *formal_args, body *body);

id *new_id(char *identifier, kind *kind, type *type);

formal_args *new_formal_arg(char *identifier, type *type, formal_args *formal_args);

body *new_body(decls *declarations, stmt *statement, exp *expression);

stmts *new_stmts(stmt *statement, stmts* statements);

stmt *new_stmt_assign(stmt_kind kind, assign *assign);
stmt *new_stmt_call(stmt_kind kind, fun_call *fun_call);
stmt *new_stmt_print(stmt_kind kind, print *print);
stmt *new_stmt_conditional(stmt_kind kind, conditional *conditional);
stmt *new_stmt_loop(stmt_kind kind, loop *loop);
stmt *new_stmt_compound(stmt_kind kind, compound *compound);
stmt *new_stmt_empty(stmt_kind kind, empty *empty);

assign *new_assign(id *id, exp *expression);
fun_call *new_fun_call(char *identifier, exps *expressions);
print *new_print(exp *expression);
conditional *new_conditional(exp *expression, stmt *statement1, stmt *statement2);
loop *new_loop(exp *expression, stmt *statement);
compound *new_compound(stmts *statements);

exps *new_exps(exp *expression, exps* expressions);

exp *new_exp_compare(exp_kind kind, type *type, exp *expression1, exp *expression2, compare_op *compare_op);
exp *new_exp_two(exp_kind kind, type *type, exp *expression1, exp *expression2);
exp *new_exp_one(exp_kind kind, type *type, exp *expression);
exp *new_exp_id(exp_kind kind, type *type, id *id);
exp *new_exp_int_lit(exp_kind kind, type *type, int integer);
exp *new_exp_real_lit(exp_kind kind, type *type, double real);
exp *new_exp_bool(exp_kind kind, type *type, int integer);
exp *new_exp_call(exp_kind kind, type *type, fun_call *fun_call);
exp *new_exp_toreal(exp_kind kind, type *type, toreal *toreal);
exp *new_exp_empty(exp_kind kind, type *type, empty *empty);

toreal *new_toreal(exp *expression);
compare_op *new_compare_op(op_kind kind);

empty *new_empty(empty_kind kind);

type *new_type(type_kind kind);
kind *new_kind(kind_kind kind);