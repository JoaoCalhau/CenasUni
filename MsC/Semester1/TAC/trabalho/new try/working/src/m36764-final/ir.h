#include "ast.h"

char *substring(char *string, int position, int length);

int deal_compare(exp *expression, int nil);
int deal_expression(exp *expression, int nil);
void deal_expressions(exps *expressions, int nil);
void deal_fun_call(fun_call *fun_call, int nil);
void deal_statements(stmts *statements, int nil);
void deal_compound(compound *compound, int nil);
void deal_loop(loop *loop, int nil);
void deal_conditional(conditional *cond, int nil);
void deal_print(print *print, int nil);
void deal_assign(assign *assign, int nil);
void deal_statement(stmt *statement, int nil);
void deal_declaration(decl *declaration, int nil);
void deal_declarations(decls *declarations, int nil);
void deal_body(body *body);
void deal_declaration_g(decl *declaration);
void deal_declarations_g(decls *declarations);
void irGen(decls *declarations);