#include "tree.c"

void mips_code_gen(decls *declarations);
void deal_decls(decls *declarations);
void deal_decl(decl *declaration);
void deal_gvar(gvar *global_var);
void deal_farg(farg *fun_arg);
void deal_fargs(fargs *fun_args);
void deal_locals(fargs *fun_locals);
void deal_fun(fun *fun);
void deal_body(body *body);
void deal_line(line *line);
void deal_label(label *label);
void deal_ret(ret *ret);
void deal_double_inst(double_inst *double_inst);
void deal_single_inst(single_inst *single_inst);
void deal_load_inst(load_inst *load_inst);
void deal_value_inst(value_inst *value_inst);
void deal_store_inst(store_inst *store_inst);
void deal_jump_inst(jump_inst *jump_inst);
void deal_cjump_inst(cjump_inst *cjump_inst);
void deal_fcall_inst(fcall_inst *fun_call_inst);
void deal_print_inst(print_inst *print_inst);
void deal_args(args *args);
void deal_more_args(margs *more_args);