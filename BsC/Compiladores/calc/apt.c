#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct calc_exp *calc_t_exp;

struct calc_exp {
  enum {EXP_NUM, EXP_ID, EXP_BINOP, EXP_UNOP, EXP_PAR, EXP_ASSIGN} kind;
  
  union {
    int num;
    char *id;
    struct {
      char op[3];
      calc_t_exp arg1;
      calc_t_exp arg2;
    } binop;

    struct {
      char op[4];
      calc_t_exp arg;
    } unop;

    struct {
      calc_t_exp rvalue;
    } assign;
  } u;
};

struct calc_t_seq_ {
  enum{SEQ_EMPTY, SEQ_EXP} kind;

  union {
    struct {
      calc_t_exp e;
      calc_t_seq s;
    } exp;
  } u;
};


void calc_exp_print(calc_t_exp exp) {
  switch(exp->kind) {
    case EXP_NUM:
      printf("[.exp [.num $%d$ ] ]\n", exp->u.num);
      break;
    case EXP_ID:
      printf("[.exp [.id $%s$ ] ]\n", exp->u.id);
      break;
    default:
      printf("Cenas");
      break;
  }
}

struct calc_exp *calc_exp_new_num(int num)
{
  calc_t_exp ret = (calc_t_exp) malloc (sizeof (*ret));

  ret->kind = EXP_NUM;
  ret->u.num = num;

  return ret;
}

struct calc_exp *calc_exp_new_binop(char op[], calc_t_exp arg1, calc_t_exp arg2)
{
  calc_t_exp ret = (calc_t_exp) malloc (sizeof (*ret));

  ret->kind = EXP_BINOP;
  strncpy(ret->u.binop.op, op, 2);
  ret->u.binop.arg1 = arg1;
  ret->u.binop.arg2 = arg2;
  
  return ret;
}

struct calc_exp *calc_exp_new_unop(char op[], calc_t_exp arg) {
  calc_t_exp ret = (calc_t_exp) malloc(sizeof(*ret));

  ret->kind = EXP_UNOP;
  strncpy(ret->u.unop.op, op, 3);
  ret->u.binop.arg = arg;

  return ret;
}

struct calc_exp *calc_exp_new_id(char *id) {
  calc_t_exp ret = (calc_t_exp) malloc(sizeof(*ret));

  ret->kind = EXP_ID;
  ret->u.id = id;

  return ret;
}

struct calc_exp *calc_exp_new_assign(char *id, calc_t_exp arg2) {
  calc_t_exp ret = (calc_t_exp)malloc(sizeof(*ret));

  ret->kind = EXP_ASSIGN;
  ret->u.assign.id = id;
  ret->u.assign.rvalue = rvalue;

  return ret;
}

struct calc_t_seq *calc_seq_empty(calc_t_exp e) {
  calc_t_seq ret = (calt_t_seq) malloc(sizeof(*ret));

  ret->kind = SEQ_EMPTY;
  ret->u.exp.e = e;

  return ret;
}

struct calc_t_seq *calc_seq_list(calc_t_exp e, calc_t_seq s) {
  calc_t_seq ret = (calc_t_seq) malloc(sizeof(*ret));

  ret->kind = SEQ_EXP;
  ret->u.exp.e = e;
  ret->u.exp.s = s;

  return ret;
}

int main() {
  return 0;
}