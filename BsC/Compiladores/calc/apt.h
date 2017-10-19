struct calc_exp *calc_exp_new_num(int num);

struct calc_exp *calc_exp_new_binop(char op[], calc_t_exp arg1, calc_t_exp arg2);

struct calc_exp *calc_exp_new_unop(char op[], calc_t_exp arg);

struct calc_exp *calc_exp_new_id(calc_t_exp arg);

struct calc_exp *calc_exp_new_assign(char *id, calc_t_exp arg2);

struct calc_t_seq *calc_seq_list(calc_t_exp e, calc_t_seq s);

struct calc_t_seq *calc_seq_empty(calc_t_exp e);