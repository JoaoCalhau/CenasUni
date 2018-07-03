#include <stdbool.h>
#include "ir.h"

#define SIZE 50

int tCounter = 0;
int fpCounter = 0;
int lCounter = 0;
bool first = true;
char *arguments;


int deal_compare(exp *expression, int nil) {
	switch(expression->u3.compare_op->kind) {
		case or_:
		{
			int t1 = deal_expression(expression->u1.expression1, nil);
			int l1 = lCounter++;
			int l2 = lCounter++;
			printf("\tcjump t%d, l%d, l%d\n", t1-1, l2, l1);
			printf("l%d:\n", l1);
			int t2 = deal_expression(expression->u2.expression2, nil);
			printf("\tt%d <- i_copy t%d\n", t1, t2);
			return t1;
		}
		case and_:
		{
			int t1 = deal_expression(expression->u1.expression1, nil);
			int l1 = lCounter++;
			int l2 = lCounter++;
			printf("\tcjump t%d, l%d, l%d\n", t1-1, l1, l2);
			printf("l%d:\n", l1);
			int t2 = deal_expression(expression->u2.expression2, nil);
			printf("\tt%d <- i_copy t%d\n", t1, t2);
			return t1;
		}
		case eq_:
		{
			if(expression->type->kind == real_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- r_eq fp%d, fp%d\n", tCounter++, t1, t2);
				return tCounter;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_eq t%d, t%d\n", tCounter++, t1, t2);
				return tCounter;
			}
		}
		case ne_:
		{
			if(expression->type->kind == real_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- r_ne fp%d, fp%d\n", tCounter++, t1, t2);
				return tCounter;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_ne t%d, t%d\n", tCounter++, t1, t2);
				return tCounter;
			}
		}
		case lt_:
		{
			if(expression->type->kind == real_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- r_lt fp%d, fp%d\n", tCounter++, t1, t2);
				return tCounter;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_lt t%d, t%d\n", tCounter++, t1, t2);
				return tCounter;
			}
		}
		case le_:
		{
			if(expression->type->kind == real_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- r_le fp%d, fp%d\n", tCounter++, t1, t2);
				return tCounter;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_le t%d, t%d\n", tCounter++, t1, t2);
				return tCounter;
			}
		}
		case gt_:
		{
			if(expression->type->kind == real_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- r_gt fp%d, fp%d\n", tCounter++, t1, t2);
				return tCounter;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_gt t%d, t%d\n", tCounter++, t1, t2);
				return tCounter;
			}
		}
		case ge_:
		{
			if(expression->type->kind == real_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- r_ge fp%d, fp%d\n", tCounter++, t1, t2);
				return tCounter;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_ge t%d, t%d\n", tCounter++, t1, t2);
				return tCounter;
			}
		}
		default:
			return -1;
	}
}

int deal_expression(exp *expression, int nil) {
	switch(expression->kind) {
		case compare_:
			return deal_compare(expression, nil);
			break;
		case plus_:
		{
			if(expression->u1.expression1->type->kind == int_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_add t%d, t%d\n", tCounter++, t1, t2);
				return tCounter-1;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tfp%d <- r_add fp%d, fp%d\n", fpCounter++, t1, t2);
				return fpCounter-1;
			}
		}
		case minus_:
		{
			if(expression->u1.expression1->type->kind == int_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_sub t%d, t%d\n", tCounter++, t1, t2);
				return tCounter-1;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tfp%d <- r_sub fp%d, fp%d\n", fpCounter++, t1, t2);
				return fpCounter-1;
			}
		}
		case times_:
		{
			if(expression->u1.expression1->type->kind == int_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_mul t%d, t%d\n", tCounter++, t1, t2);
				return tCounter-1;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tfp%d <- r_mul fp%d, fp%d\n", fpCounter++, t1, t2);
				return fpCounter-1;
			}
		}
		case div_:
		{
			if(expression->u1.expression1->type->kind == int_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tt%d <- i_div t%d, t%d\n", tCounter++, t1, t2);
				return tCounter-1;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				int t2 = deal_expression(expression->u2.expression2, nil);
				printf("\tfp%d <- r_div fp%d, fp%d\n", fpCounter++, t1, t2);
				return fpCounter-1;
			}
		}
		case mod_:
		{
			int t1 = deal_expression(expression->u1.expression1, nil);
			int t2 = deal_expression(expression->u2.expression2, nil);
			printf("\tt%d <- mod t%d, t%d\n", tCounter++, t1, t2);
			return tCounter-1;
		}
		case not_:
		{
			int t = deal_expression(expression->u1.expression1, nil);
			printf("\tt%d <- not %d\n", tCounter++, t);
			return tCounter-1;
		}
		case inv_:
		{
			if(expression->u1.expression1->type->kind == int_) {
				int t1 = deal_expression(expression->u1.expression1, nil);
				printf("\tt%d <- i_inv %d\n", tCounter++, t1);
				return tCounter-1;
			} else {
				int t1 = deal_expression(expression->u1.expression1, nil);
				printf("\tfp%d <- r_inv %d\n", fpCounter++, t1);
				return tCounter-1;
			}
		}
		case id_:
		{
			if(expression->type->kind == int_ || expression->type->kind == bool_ ) {
				if(expression->u1.id->kind->kind == var_) {
					printf("\tt%d <- i_gload @%s\n", tCounter, expression->u1.id->identifier);
					return tCounter++;
				} else if(expression->u1.id->kind->kind == local_) {
					printf("\tt%d <- i_lload @%s\n", tCounter, expression->u1.id->identifier);
					return tCounter++;
				} else {
					printf("\tt%d <- i_aload @%s\n", tCounter, expression->u1.id->identifier);
					return tCounter++;
				}
			} else {
				if(expression->u1.id->kind->kind == var_) {
					printf("\tfp%d <- i_gload @%s\n", fpCounter, expression->u1.id->identifier);
					return fpCounter++;
				} else if(expression->u1.id->kind->kind == local_) {
					printf("\tfp%d <- i_lload @%s\n", fpCounter, expression->u1.id->identifier);
					return fpCounter++;
				} else {
					printf("\tfp%d <- i_aload @%s\n", fpCounter, expression->u1.id->identifier);
					return fpCounter++;
				}
			}
		}
		case int_lit:
			printf("\tt%d <- i_value %d\n", tCounter++, expression->u1.integer);
			return tCounter-1;
		case real_lit:
			printf("\tfp%d <- r_value %f\n", fpCounter++, expression->u1.real);
			return fpCounter-1;
		case bool_exp:
		{
			printf("\tt%d <- i_value %d\n", tCounter++, expression->u1.integer);
			return tCounter-1;
		}
		case call_exp:
		{
			deal_fun_call(expression->u1.fun_call, nil);
			if(expression->type->kind == real_) {
				return fpCounter-1;
			} else {
				return tCounter-1;
			}
		}
		case toreal_:
		{
			int t = deal_expression(expression->u1.toreal->expression, nil);
			printf("\tfp%d <- itor t%d\n", fpCounter++, t);
			return fpCounter-1;
		}
		case empty_exp:
			break;

	}
	return 0;
}

void deal_expressions(exps *expressions, int nil) {
	if(expressions == NULL) {
		return;
	} else {
		if(first) {
			arguments = malloc(SIZE);
			char *itos = malloc(SIZE);
			if(expressions->expression->type->kind == real_) {
				sprintf(itos, "[fp%d", deal_expression(expressions->expression, nil));
				strcpy(arguments, itos);
				first = false;
				deal_expressions(expressions->expressions, nil);
			} else {
				sprintf(itos, "[t%d", deal_expression(expressions->expression, nil));
				strcpy(arguments, itos);
				first = false;
				deal_expressions(expressions->expressions, nil);
			}
		} else {
			if(expressions->expression->type->kind == real_) {
				char *itos = malloc(SIZE);
				sprintf(itos, ",fp%d", deal_expression(expressions->expression, nil));
				strcat(arguments, itos);
				deal_expressions(expressions->expressions, nil);
			} else {
				char *itos = malloc(SIZE);
				sprintf(itos, ",t%d", deal_expression(expressions->expression, nil));
				strcat(arguments, itos);
				deal_expressions(expressions->expressions, nil);
			}
		}
	}
}

//need to fix, only prints call, needs i_call and r_call
void deal_fun_call(fun_call *fun_call, int nil) {
	deal_expressions(fun_call->expressions, nil);
	if(nil == 0) {
		printf("\tcall @%s %s]\n", fun_call->identifier, arguments);
		first = true;
	} else if(nil == 1 || nil == 2) {
		printf("\tt%d <- i_call @%s %s]\n", tCounter++, fun_call->identifier, arguments);
		first = true;
	} else if(nil == 3) {
		printf("\tfp%d <- r_call @%s %s]\n", fpCounter++, fun_call->identifier, arguments);
	} else {
		return;
	}
}

void deal_statements(stmts *statements, int nil) {
	if(statements == NULL) {
		return;
	} else {
		deal_statement(statements->statement, nil);
		deal_statements(statements->statements, nil);
	}
}

void deal_compound(compound *compound, int nil) {
	deal_statements(compound->statements, nil);
}

void deal_loop(loop *loop, int nil) {
	int l1 = lCounter++;
	int l2 = lCounter++;
	int l3 = lCounter++;
	printf("l%d:\n", l1);
	int t = deal_expression(loop->expression, nil);
	printf("\tcjump t%d, l%d, l%d\n", t, l2, l3);
	printf("l%d:\n", l2);
	deal_statement(loop->statement, nil);
	printf("\tjump l%d\n", l1);
	printf("l%d:\n", l3);
}

void deal_conditional(conditional *cond, int nil) {
	int l1 = lCounter++;
	int l2 = lCounter++;
	int t1 = deal_expression(cond->expression, nil);
	printf("\tcjump t%d, l%d, l%d\n", t1, l1, l2);
	printf("l%d:\n", l1);
	deal_statement(cond->statement1, nil);
	if(cond->statement2->kind != empty_stmt) {
		int l3 = lCounter++;
		printf("\tjump l%d\n", l3);
		printf("l%d:\n", l2);
		deal_statement(cond->statement2, nil);
		printf("l%d:\n", l3);
	} else {
		return;
	}
}

void deal_print(print *print, int nil) {
	int t = deal_expression(print->expression, nil);
	if(print->expression->type->kind == int_) {
		printf("\ti_print t%d\n", t);
	} else if(print->expression->type->kind == bool_) {
		printf("\tb_print t%d\n", t);
	} else if(print->expression->type->kind == real_) {
		printf("\tr_print fp%d\n", t);
	} else {
		return;
	}
}



void deal_assign(assign *assign, int nil) {
	if(assign != NULL && assign->expression->kind != empty_exp) {
		int t = deal_expression(assign->expression, nil);
		if(assign->id->type->kind == int_ || assign->id->type->kind == bool_) {
			if(assign->id->kind->kind == var_) {
				printf("\t@%s <- i_gstore t%d\n", assign->id->identifier, t);
			} else if(assign->id->kind->kind == local_) {
				printf("\t@%s <- i_lstore t%d\n", assign->id->identifier, t);
			} else {
				printf("\t@%s <- i_astore t%d\n", assign->id->identifier, t);
			}
		} else {
			if(assign->id->kind->kind == var_) {
				printf("\t@%s <- r_gstore fp%d\n", assign->id->identifier, t);
			} else if(assign->id->kind->kind == local_) {
				printf("\t@%s <- r_lstore fp%d\n", assign->id->identifier, t);
			} else {
				printf("\t@%s <- r_astore fp%d\n", assign->id->identifier, t);
			}
		}
	} else {
		return;
	}
}

void deal_statement(stmt *statement, int nil) {
	switch(statement->kind) {
		case assign_:
			deal_assign(statement->u1.assign, nil);
			break;
		case call_:
			deal_fun_call(statement->u1.fun_call, nil);
			break;
		case print_:
			deal_print(statement->u1.print, nil);
			break;
		case conditional_:
			deal_conditional(statement->u1.conditional, nil);
			break;
		case loop_:
			deal_loop(statement->u1.loop, nil);
			break;
		case compound_:
			deal_compound(statement->u1.compound, nil);
			break;
		case empty_stmt:
			break;
	}
}

void deal_declaration(decl *declaration, int nil) {
	switch(declaration->kind) {
		case var_decl:
		{
			if(declaration->u2.expression->kind != empty_exp) {
				int t = deal_expression(declaration->u2.expression, nil);
				if(declaration->u2.expression->type->kind == real_) {
					switch(declaration->u1.id->kind->kind) {
						case var_:
							printf("\t@%s <- r_gstore fp%d\n", declaration->u1.id->identifier, t);
							break;
						case local_:
							printf("\t@%s <- r_lstore fp%d\n", declaration->u1.id->identifier, t);
							break;
						case arg_:
							printf("\t@%s <- r_astore fp%d\n", declaration->u1.id->identifier, t);
							break;
					}
				} else {
					switch(declaration->u1.id->kind->kind) {
						case var_:
							printf("\t@%s <- i_gstore t%d\n", declaration->u1.id->identifier, t);
							break;
						case local_:
							printf("\t@%s <- i_lstore t%d\n", declaration->u1.id->identifier, t);
							break;
						case arg_:
							printf("\t@%s <- i_astore t%d\n", declaration->u1.id->identifier, t);
							break;
					}
				}
			}
		}
		case fun_decl:
			return;
	}
}

void deal_declarations(decls *declarations, int nil) {
	if(declarations != NULL && declarations->declaration != NULL) {
		deal_declaration(declarations->declaration, nil);
		deal_declarations(declarations->declarations, nil);
	} else {
		return;
	}
}

void deal_body(body *body) {
	int nil;
	if(body->expression->kind == empty_exp) {
		nil = 0;
	} else if(body->expression->type->kind == int_) {
		nil = 1;
	} else if(body->expression->type->kind == bool_) {
		nil = 2;
	} else if(body->expression->type->kind == real_) {
		nil = 3;
	} else {
		nil = 4;
	}

	deal_declarations(body->declarations, nil);
	deal_statement(body->statement, nil);
	deal_expression(body->expression, nil);
	if(body->expression->type->kind == real_) {
		printf("\tr_return fp%d\n", --fpCounter);
	} else if(body->expression->type->kind == int_ || body->expression->type->kind == bool_) {
		printf("\ti_return t%d\n", --tCounter);
	} else {
		printf("\treturn\n");
	}
}

void deal_declaration_g(decl *declaration) {
	switch(declaration->kind) {
		case var_decl:
			break;
		case fun_decl:
		{
			tCounter = 0;
			fpCounter = 0;
			printf("\n");
			printf("function @%s:\n", declaration->u1.identifier);
			deal_body(declaration->u3.body);
			break;
		}
	}

}

void deal_declarations_g(decls *declarations) {
	if(declarations->declaration == NULL) {
		return;
	} else {
		deal_declaration_g(declarations->declaration);
		deal_declarations_g(declarations->declarations);
	}
}

void irGen(decls *declarations) {
	printf("Maybe, just maybe... Dont get your hopes up...\n");
	deal_declarations_g(declarations); 
}