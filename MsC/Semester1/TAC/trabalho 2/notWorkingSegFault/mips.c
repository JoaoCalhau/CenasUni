#include "mips.h"
#include <stdbool.h>

#define MAX 50

bool isData = false;
bool first = true;
bFP *bFPArgs[MAX];
bFP *bFPLocals[MAX];
int numArgs[MAX];
int numLocals[MAX];
int currentArgs;
int currentLocals;
int funNumber = 0;


char *substring(char *string, int position, int length) {
	char *sub;
	int i;

	sub = malloc(length + 1);

	for(i = 0; i < length; i++) {
		*(sub + i) = *(string + position - 1);
		string++;
	}

	*(sub + i) = '\0';

	return sub;
}

bFP *new_bFP(char *identifier, int pos) {
	bFP *new_ = malloc(sizeof(bFP));

	new_->identifier = strdup(identifier);
	new_->pos = pos;
	new_->next = NULL;
	
	return new_;
}

void mips_code_gen(decls *declarations) {
	deal_decls(declarations);
}

void deal_decls(decls *declarations) {
	if(declarations == NULL) {
		return;
	} else {
		deal_decl(declarations->declaration);
		deal_decls(declarations->declarations);
	}
}

void deal_decl(decl *declaration) {
	switch(declaration->kind) {
		case gvar_:
		{
			deal_gvar(declaration->u1.global_var);
			break;
		}
		case farg_:
		{
			deal_farg(declaration->u1.fun_arg);
			funNumber++;
			break;
		}
		case fun_:
		{
			if(first) {
				funNumber = 0;
				first = false;
			}
			printf("\nAQUII\n");
			deal_fun(declaration->u1.fun);
			break;
		}
		default:
			break;
	}
}

void deal_gvar(gvar *global_var) {
	char *var_name = substring(global_var->identifier, 2, strlen(global_var->identifier)-1);
	if(global_var->kind == not_init) {
		if(!isData) {
			printf("\t.data\n");
			isData = true;
		}
		printf("%s:\t.space 4\n", var_name);
	} else {
		if(!isData) {
			printf("\t.data\n");
			isData = true;
		}
		printf("%s:\t.word %d\n", var_name, global_var->initial_value->literal);
	}
}

void deal_farg(farg *fun_arg) {
	currentLocals = 0;
	currentArgs = 0;

	if(fun_arg->fun_args != NULL)
		deal_fargs(fun_arg->fun_args);

	numArgs[funNumber] = currentArgs;

	if(fun_arg->fun_locals != NULL)
		deal_locals(fun_arg->fun_locals);

	numLocals[funNumber] = currentLocals;
}

void deal_fargs(fargs *fun_args) {
	if(currentArgs == 0) {
		bFPArgs[funNumber] = new_bFP(fun_args->identifier, ++currentArgs);
	} else {
		bFP *temp = bFPArgs[funNumber];
		int i;
		for(i = 0; i < currentArgs+1; i++) {
			if(i == currentArgs)
				temp->next = new_bFP(fun_args->identifier, ++currentArgs);
			temp = temp->next;
		}
	}
	if(fun_args->fun_args != NULL)
		deal_fargs(fun_args->fun_args);
}

void deal_locals(fargs *fun_args) {
	if(currentLocals == 0) {
		bFPLocals[funNumber] = new_bFP(fun_args->identifier, ++currentLocals);
	} else {
		bFP *temp = bFPLocals[funNumber];
		int i;
		for(i = 0; i < currentLocals+1; i++) {
			if(i == currentLocals)
				temp->next = new_bFP(fun_args->identifier, ++currentLocals);
			temp = temp->next;
		}
	}
	if(fun_args->fun_args != NULL)
		deal_locals(fun_args->fun_args);
}

void deal_fun(fun *fun) {
	printf("\n");
	printf("\t.text\n");
	char *fun_name = substring(fun->identifier, 2, strlen(fun->identifier)-1);
	printf("%s:\n", fun_name);
	printf("\t%s $fp, -4($sp)\n", "sw");
	printf("\t%s $fp, $sp, -4\n", "addiu");
	printf("\t%s $ra, -4($fp)\n", "sw");
	printf("\t%s $sp, $fp, -8\n", "addiu");
	deal_body(fun->body);
	funNumber++;
}

void deal_body(body *body) {
	switch(body->kind) {
		case line_:
		{
			deal_line(body->u1.line);
			deal_body(body->body);
			break;
		}
		case label_:
		{
			deal_label(body->u1.label);
			deal_body(body->body);
			break;
		}
		case return_body:
		{
			deal_ret(body->u1.ret);
			break;
		}
		default:
			break;
	}
}

void deal_line(line *line) {
	switch(line->kind) {
		case dinst_:
		{
			deal_double_inst(line->u1.double_inst);
			break;
		}
		case sinst_:
		{
			deal_single_inst(line->u1.single_inst);
			break;
		}
		case load_:
		{
			deal_load_inst(line->u1.load_inst);
			break;
		}
		case value_:
		{
			deal_value_inst(line->u1.value_inst);
			break;
		}
		case store_:
		{
			deal_store_inst(line->u1.store_inst);
			break;
		}
		case jump_:
		{
			deal_jump_inst(line->u1.jump_inst);
			break;
		}
		case cjump_:
		{
			deal_cjump_inst(line->u1.cjump_inst);
			break;
		}
		case fcall_inst_:
		{
			deal_fcall_inst(line->u1.fun_call_inst);
			break;
		}
		case print_:
		{
			deal_print_inst(line->u1.print_inst);
			break;
		}
		default:
			break;
	}
}

void deal_label(label *label) {
	printf("l$%d:", label->literal);
}

void deal_ret(ret *ret) {
	if(ret->kind == return_) {
		printf("\t%s $ra, -4($fp)\n", "lw");
		printf("\t%s $sp, $fp, %d\n", "addiu", (4 + numArgs[funNumber]*4));
		printf("\t%s $fp, 0($fp)\n", "lw");
		printf("\t%s $ra\n", "j");
	} else {
		printf("\t%s $v0, $0, t%d\n", "or", ret->temporary->literal);
		printf("\t%s $ra, -4($fp)\n", "lw");
		printf("\t%s $sp, $fp, %d\n", "addiu", (4 + numArgs[funNumber]*4));
		printf("\t%s $fp, 0($fp)\n", "lw");
		printf("\t%s $ra\n", "j");
	}
}

void deal_double_inst(double_inst *double_inst) {
	switch(double_inst->dinst->kind) {
		case eq_:
		{
			printf("\t%s t%d, t%d, t%d\n", "subu", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\t%s t%d, t%d, 1\n", "sltiu", double_inst->temporary->literal, double_inst->temporary->literal);
			break;
		}
		case ne_:
		{
			printf("\t%s t%d, t%d, t%d\n", "subu", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\t%s t%d, $0, t%d\n", "sltu", double_inst->temporary->literal, double_inst->temporary->literal);
			break;
		}
		case lt_:
		{
			printf("\t%s t%d, t%d, t%d\n", "slt", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			break;
		}
		case le_:
		{
			printf("\t%s t%d, t%d, t%d\n", "slt", double_inst->temporary->literal, double_inst->temporary2->literal, double_inst->temporary1->literal);
			printf("\t%s t%d, t%d, 1\n", "xori", double_inst->temporary->literal, double_inst->temporary->literal);
			break;
		}
		case add_:
		{
			printf("\t%s t%d, t%d, t%d\n", "addu", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			break;
		}
		case sub_:
		{
			printf("\t%s t%d, t%d, t%d\n", "subu", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			break;
		}
		case mul_:
		{
			printf("\t%s t%d, t%d\n", "mult", double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\t%s t%d\n", "mflo", double_inst->temporary->literal);
			break;
		}
		case div_:
		{
			printf("\t%s t%d, t%d\n", "div", double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\t%s t%d\n", "mflo", double_inst->temporary->literal);
			break;
		}
		case mod_:
		{
			printf("\t%s t%d, t%d\n", "div", double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\t%s t%d\n", "mfhi", double_inst->temporary->literal);
			break;
		}
	}
}

void deal_single_inst(single_inst *single_inst) {

	switch(single_inst->sinst->kind) {
		case not_:
		{
			printf("\t%s t%d, t%d, 1\n", "xori", single_inst->temporary->literal, single_inst->temporary1->literal);
			break;
		}
		case inv_:
		{
			printf("\t%s t%d, $0, t%d\n", "subu", single_inst->temporary->literal, single_inst->temporary1->literal);
			break;
		}
		case copy_:
		{
			printf("\t%s t%d, t%d, $0\n", "add", single_inst->temporary->literal, single_inst->temporary1->literal);
			break;
		}
		default:
			break;
	}
}

void deal_load_inst(load_inst *load_inst) {
	char *name = substring(load_inst->identifier, 2, strlen(load_inst->identifier)-1);
	switch(load_inst->load->kind) {
		case gload_:
		{
			printf("\t%s $at, %s\n", "la", name);
			printf("\t%s t%d, 0(t%d)\n", "lw", load_inst->temporary->literal, load_inst->temporary->literal);
			break;
		}
		case lload_:
		{
			int i;
			bFP *temp = bFPLocals[funNumber];

			for(i = 0; i < currentLocals+1; i++) {
				if(strcmp(load_inst->identifier, temp->identifier) == 0) {
					printf("\t%s t%d, -%d($fp)\n", "lw", load_inst->temporary->literal, (4 + (temp->pos)*4));
					break;
				} else {
					temp = temp->next;
				}
			}
			
			break;
		}
		case aload_:
		{
			int i;
			bFP *temp = bFPArgs[funNumber];

			for(i = 0; i < currentArgs+1; i++) {
				if(strcmp(load_inst->identifier, temp->identifier) == 0) {
					printf("\t%s t%d, %d($fp)\n", "lw", load_inst->temporary->literal, ((temp->pos)*4));
					break;
				} else {
					temp = temp->next;
				}
			}
			
			break;
		}
		default:
			break;
	}
}

void deal_value_inst(value_inst *value_inst) {
	int max = 2 << 15;
	if(value_inst->literal < max) {
		printf("\t%s t%d, $0, %d\n", "ori", value_inst->temporary->literal, value_inst->literal);
	} else {
		int lui = value_inst->literal >> 16; 
		int ori = value_inst->literal - (lui * max);

		printf("\t%s t%d, %d\n", "lui", value_inst->temporary->literal, lui);
		printf("\t%s t%d, t%d, %d\n", "ori", value_inst->temporary->literal, value_inst->temporary->literal, ori);
	}
}

void deal_store_inst(store_inst *store_inst) {
	char *name = substring(store_inst->identifier, 2, strlen(store_inst->identifier)-1);
	switch(store_inst->store->kind) {
		case gstore_:
		{
			printf("\t%s $at, %s\n", "la", name);
			printf("\t%s t%d, 0($at)\n", "sw", store_inst->temporary->literal);
			break;	
		}
		case lstore_:
		{
			int i;
			bFP *temp = bFPLocals[funNumber];

			for(i = 0; i < currentLocals+1; i++) {
				if(strcmp(store_inst->identifier, temp->identifier) == 0) {
					printf("\t%s t%d, -%d($fp)\n", "sw", store_inst->temporary->literal, (4 + (temp->pos)*4));
					break;
				} else {
					temp = temp->next;
				}
			}
			
			break;	
		}
		case astore_:
		{
			int i;
			bFP *temp = bFPArgs[funNumber];

			for(i = 0; i < currentArgs+1; i++) {
				if(strcmp(store_inst->identifier, temp->identifier) == 0) {
					printf("\t%s t%d, %d($fp)\n", "sw", store_inst->temporary->literal, ((temp->pos)*4));
					break;
				} else {
					temp = temp->next;
				}
			}
			
			break;	
		}
		default:
			break;
	}
}

void deal_jump_inst(jump_inst *jump_inst) {
	printf("\t%s l$%d\n", "j", jump_inst->label->literal);
}

void deal_cjump_inst(cjump_inst *cjump_inst) {
	printf("\t%s t%d, $0, l$%d\n", "beq", cjump_inst->temporary->literal, cjump_inst->label2->literal);
	printf("\t%s l$%d\n", "j", cjump_inst->label1->literal);
}

void deal_fcall_inst(fcall_inst *fun_call_inst) {
	char *fun_name = substring(fun_call_inst->identifier, 2, strlen(fun_call_inst->identifier)-1);
	if(fun_call_inst->kind == icall_) {
		if(fun_call_inst->args->kind == not_empty)
			deal_args(fun_call_inst->args);

		printf("\t%s %s\n", "jal", fun_name);
		printf("\t%s t%d, $0, $v0\n", "or", fun_call_inst->temporary->literal);
	} else {
		if(fun_call_inst->args->kind == not_empty)
			deal_args(fun_call_inst->args);

		printf("\t%s %s\n", "jal", fun_name);
	}
}

void deal_print_inst(print_inst *print_inst) {
	if(print_inst->print_kind->kind == iprint_) {
		printf("\t%s t%d\n", "i_print$", print_inst->temporary->literal);
	} else {
		printf("\t%s t%d\n", "b_print$", print_inst->temporary->literal);
	}
}

void deal_args(args *args) {
	printf("\t%s $sp, $sp, -4\n", "addiu");
	printf("\t%s t%d, 0($sp)\n", "sw", args->temporary->literal);
	

	if(args->more_args->kind == not_empty)
		deal_more_args(args->more_args);
}

void deal_more_args(margs *more_args) {
	printf("\t%s $sp, $sp, -4\n", "addiu");
	printf("\t%s t%d, 0($sp)\n", "sw", more_args->temporary->literal);
	

	if(more_args->more_args->kind == not_empty)
		deal_more_args(more_args->more_args);
}