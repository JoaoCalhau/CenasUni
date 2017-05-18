#include "mips.h"
#include <stdbool.h>

bool isData = false;

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
			break;
		}
		case fun_:
		{
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
	//nothing for now
}

void deal_fun(fun *fun) {
	printf("\n");
	printf("\t.text\n");
	char *fun_name = substring(fun->identifier, 2, strlen(fun->identifier)-1);
	printf("%s:", fun_name);
	deal_body(fun->body);
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
		/* epilogue missing */
		printf("\tj $ra\n");
	} else {
		printf("\tor $v0, $0, t%d\n", ret->temporary->literal);
		/* epilogue missing */
		printf("\tj $ra\n");
	}
}

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

void deal_load_inst(load_inst *load_inst) {
	char *name = substring(load_inst->identifier, 2, strlen(load_inst->identifier)-1);
	switch(load_inst->load->kind) {
		case gload_:
		{
			printf("\tlw t%d, %s\n", load_inst->temporary->literal, name);
			break;
		}
		case lload_:
		case aload_:
		default:
			break;
	}
}

void deal_value_inst(value_inst *value_inst) {
	int max = 2 << 15;
	if(value_inst->literal < max) {
		printf("\tori t%d, $0, %d\n", value_inst->temporary->literal, value_inst->literal);
	} else {
		int lui = value_inst->literal >> 16; 
		int ori = value_inst->literal - (lui * max);

		printf("\tlui t%d, %d\n", value_inst->temporary->literal, lui);
		printf("\tori t%d, t%d, %d\n", value_inst->temporary->literal, value_inst->temporary->literal, ori);
	}
}

void deal_store_inst(store_inst *store_inst) {
	char *name = substring(store_inst->identifier, 2, strlen(store_inst->identifier)-1);
	switch(store_inst->store->kind) {
		case gstore_:
		{
			printf("\tsw t%d, %s\n", store_inst->temporary->literal, name);
			break;	
		}
		case lstore_:
		case astore_:
		default:
			break;
	}
}

void deal_jump_inst(jump_inst *jump_inst) {
	printf("\tj l%d\n", jump_inst->label->literal);
}

void deal_cjump_inst(cjump_inst *cjump_inst) {
	printf("\tbne t%d, $0, l$%d\n", cjump_inst->temporary->literal, cjump_inst->label1->literal);
	printf("\tj l$%d\n", cjump_inst->label2->literal);
}

void deal_fcall_inst(fcall_inst *fun_call_inst) {

}

void deal_print_inst(print_inst *print_inst) {

}