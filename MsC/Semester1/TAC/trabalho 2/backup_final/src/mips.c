#include "mips.h"
#include <stdbool.h>

#define MAX 50

bool isData = false;
bool first = true;
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

void mips_code_gen(decls *declarations) {
	deal_decls(declarations);
}

void deal_decls(decls *declarations) {
	if(declarations->kind == empty_) {
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
			deal_fun(declaration->u1.fun);
			break;
		}
		default:
			break;
	}
}

//Deals with global declaration of variables
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

//deals with the formal arguments of a function and also
//deals with the locals of a function
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

//helper function to deal with formal args
void deal_fargs(fargs *fun_args) {
	currentArgs++;
	if(fun_args->fun_args != NULL)
		deal_fargs(fun_args->fun_args);
}

//helper function to deal with locals
void deal_locals(fargs *fun_args) {
	currentLocals++;
	if(fun_args->fun_args != NULL)
		deal_locals(fun_args->fun_args);
}

// deals with the name of the function and the prologue
void deal_fun(fun *fun) {
	printf("\n");
	printf("\t.text\n");
	char *fun_name = substring(fun->identifier, 2, strlen(fun->identifier)-1);
	printf("%s:", fun_name);
	printf("\tsw $fp, -4($sp)\n");
	printf("\taddiu $fp, $sp, -4\n");
	printf("\tsw $ra, -4($fp)\n");
	printf("\taddiu $sp, $fp, -%d\n", (4 + numLocals[funNumber] * 4));
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

//deals with the various types of instructions
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

//prints labels
void deal_label(label *label) {
	printf("l$%d:", label->literal);
}

//prints the returns and the epilogue
void deal_ret(ret *ret) {
	if(ret->kind == return_) {
		printf("\tlw $ra, -4($fp)\n");
		printf("\taddiu $sp, $fp, %d\n", (4 + numArgs[funNumber]*4));
		printf("\tlw $fp, 0($fp)\n");
		printf("\tjr $ra\n");
	} else {
		printf("\tor $v0, $0, t%d\n", ret->temporary->literal);
		printf("\tlw $ra, -4($fp)\n");
		printf("\taddiu $sp, $fp, %d\n", (4 + numArgs[funNumber]*4));
		printf("\tlw $fp, 0($fp)\n");
		printf("\tjr $ra\n");
	}
}

//prints all the instructions that have 2 arguments
void deal_double_inst(double_inst *double_inst) {
	switch(double_inst->dinst->kind) {
		case eq_:
		{
			printf("\tsubu t%d, t%d, t%d\n", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\tsltiu t%d, t%d, 1\n", double_inst->temporary->literal, double_inst->temporary->literal);
			break;
		}
		case ne_:
		{
			printf("\tsubu t%d, t%d, t%d\n", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\tsltu t%d, $0, t%d\n", double_inst->temporary->literal, double_inst->temporary->literal);
			break;
		}
		case lt_:
		{
			printf("\tslt t%d, t%d, t%d\n", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			break;
		}
		case le_:
		{
			printf("\tslt t%d, t%d, t%d\n", double_inst->temporary->literal, double_inst->temporary2->literal, double_inst->temporary1->literal);
			printf("\txori t%d, t%d, 1\n", double_inst->temporary->literal, double_inst->temporary->literal);
			break;
		}
		case add_:
		{
			printf("\taddu t%d, t%d, t%d\n", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			break;
		}
		case sub_:
		{
			printf("\tsubu t%d, t%d, t%d\n", double_inst->temporary->literal, double_inst->temporary1->literal, double_inst->temporary2->literal);
			break;
		}
		case mul_:
		{
			printf("\tmult t%d, t%d\n", double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\tmflo t%d\n", double_inst->temporary->literal);
			break;
		}
		case div_:
		{
			printf("\tdiv t%d, t%d\n", double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\tmflo t%d\n", double_inst->temporary->literal);
			break;
		}
		case mod_:
		{
			printf("\tdiv t%d, t%d\n", double_inst->temporary1->literal, double_inst->temporary2->literal);
			printf("\tmfhi t%d\n", double_inst->temporary->literal);
			break;
		}
	}
}

//prints all the instructions that have 1 argument only
void deal_single_inst(single_inst *single_inst) {

	switch(single_inst->sinst->kind) {
		case not_:
		{
			printf("\txori t%d, t%d, 1\n", single_inst->temporary->literal, single_inst->temporary1->literal);
			break;
		}
		case inv_:
		{
			printf("\tsubu t%d, $0, t%d\n", single_inst->temporary->literal, single_inst->temporary1->literal);
			break;
		}
		case copy_:
		{
			printf("\tadd t%d, t%d, $0\n", single_inst->temporary->literal, single_inst->temporary1->literal);
			break;
		}
		default:
			break;
	}
}

//prints the load instructions
void deal_load_inst(load_inst *load_inst) {
	char *name = substring(load_inst->identifier, 2, strlen(load_inst->identifier)-1);
	switch(load_inst->load->kind) {
		case gload_:
		{
			printf("\tla t%d, %s\n", load_inst->temporary->literal, name);
			printf("\tlw t%d, 0(t%d)\n", load_inst->temporary->literal, load_inst->temporary->literal);
			break;
		}
		case lload_:
		{
			printf("\tlw t%d, -%d($fp)\n", load_inst->temporary->literal, (4 + numLocals[funNumber]*4));
			break;
		}
		case aload_:
		{
			printf("\tlw t%d, %d($fp)\n", load_inst->temporary->literal, (numArgs[funNumber]*4));
			break;
		}
		default:
			break;
	}
}

//prints the value instructions
void deal_value_inst(value_inst *value_inst) {
	int max = 2 << 15; //2 ^16
	if(value_inst->literal < max) { //if the number is smaller than 2 ^16
		printf("\tori t%d, $0, %d\n", value_inst->temporary->literal, value_inst->literal);
	} else { //otherwise
		int lui = value_inst->literal >> 16; 
		int ori = value_inst->literal - (lui * max);

		printf("\tlui t%d, %d\n", value_inst->temporary->literal, lui);
		printf("\tori t%d, t%d, %d\n", value_inst->temporary->literal, value_inst->temporary->literal, ori);
	}
}

//prints store instructions
void deal_store_inst(store_inst *store_inst) {
	char *name = substring(store_inst->identifier, 2, strlen(store_inst->identifier)-1);
	switch(store_inst->store->kind) {
		case gstore_:
		{
			printf("\tla $at, %s\n", name);
			printf("\tsw t%d, 0($at)\n", store_inst->temporary->literal);
			break;	
		}
		case lstore_:
		{
			printf("\tsw t%d, -%d($fp)\n", store_inst->temporary->literal, (4 + numLocals[funNumber]*4));
			break;	
		}
		case astore_:
		{
			printf("\tsw t%d, %d($fp)\n", store_inst->temporary->literal, (numArgs[funNumber]*4));
			break;	
		}
		default:
			break;
	}
}

//prints jump instructions
void deal_jump_inst(jump_inst *jump_inst) {
	printf("\tj l$%d\n", jump_inst->label->literal);
}

//prints cjump instructions
void deal_cjump_inst(cjump_inst *cjump_inst) {
	printf("\tbeq t%d, $0, l$%d\n", cjump_inst->temporary->literal, cjump_inst->label2->literal);
	printf("\tj l$%d\n", cjump_inst->label1->literal);
}

//prints function calls
void deal_fcall_inst(fcall_inst *fun_call_inst) {
	char *fun_name = substring(fun_call_inst->identifier, 2, strlen(fun_call_inst->identifier)-1);
	if(fun_call_inst->kind == icall_) {
		if(fun_call_inst->args->kind == not_empty)
			deal_args(fun_call_inst->args);

		printf("\tjal %s\n", fun_name);
		printf("\tor t%d, $0, $v0\n", fun_call_inst->temporary->literal);
	} else {
		if(fun_call_inst->args->kind == not_empty)
			deal_args(fun_call_inst->args);

		printf("\tjal %s\n", fun_name);
	}
}

//prints print instructions
void deal_print_inst(print_inst *print_inst) {
	if(print_inst->print_kind->kind == iprint_) {
		printf("\ti_print$ t%d\n", print_inst->temporary->literal);
	} else {
		printf("\tb_print$ t%d\n", print_inst->temporary->literal);
	}
}

//prints the stores we have to do before doing a function call
void deal_args(args *args) {
	printf("\taddiu $sp, $sp, -4\n");
	printf("\tsw t%d, 0($sp)\n", args->temporary->literal);
	

	if(args->more_args->kind == not_empty)
		deal_more_args(args->more_args);
}

//prints every store after the first one
void deal_more_args(margs *more_args) {
	printf("\taddiu $sp, $sp, -4\n");
	printf("\tsw t%d, 0($sp)\n", more_args->temporary->literal);
	

	if(more_args->more_args->kind == not_empty)
		deal_more_args(more_args->more_args);
}