
#include <stdlib.h>
#include <stdio.h>
#include <memory.h>
#include <string.h>
#include <stdbool.h>







enum decls_kind {DECLS_, NONE_DECLS};
enum decl1_kind {DECL_1, DECL_2, DECL_3, DECL_4, DECL_5};
enum decl_kind {DECL_};

enum id_kind {ID_1};
enum ids_kind {IDS_1, IDS_2};
enum idstype_kind {IDSTYPE_1, IDSTYPE_2};

enum type_kind {INT_, FLOAT_, STRING_, BOOL_,ARRAY_,  VOID_ };

enum funcao_kind {FUNC_FUNC, FUNC_MIX, FUNC_IDSTYPE};
enum mix_kind {LITS_, IDS_};

enum lits_kind {LIT_, LIT_LITS};
enum lit_kind {INT_LITE, BOOL_LITE, FLOAT_LITE, STRING_LITE, ARRAY_LITE};



enum exp_kind {EXP_PAR, EXP_ASSIGN, EXP_FUNC, EXP_ADD, EXP_SUB,EXP_MUL,
        EXP_DIV, EXP_MOD, EXP_EXPOENT, EXP_NEG, EXP_EQUAL, EXP_DIFF,
        EXP_AND, EXP_OR, EXP_NOT, EXP_LESSOREQUAL, EXP_LESS,
        EXP_GREATEROREQUAL, EXP_GREATER,EXP_ID, EXP_BOOL_LIT, EXP_INT_LIT,
        EXP_FLOAT_LIT, EXP_STRING_LIT, EXP_ARRAY_LIT};



enum corpo_kind {CORPO};

enum stats_kind {NONE_STATS, STAT_STATS, STAT_};

enum stat_kind {STAT_DECL, STAT_EXP, STAT_RETURN, STAT_IF,
    STAT_IF_ELSE, STAT_WHILE, STAT_BREAK, STAT_NEXT};

enum nl_kind {NL_};





// ------------------------ STRUCTS DECLARATIONS AND FUNCTIONS ------------------------------

typedef struct Decls Decls;
typedef struct Decl Decl;
typedef struct Decl1 Decl1;

typedef struct Id Id;

typedef struct Ids Ids;
typedef struct Type Type;
typedef struct IdsType IdsType;

typedef struct Exp Exp;
typedef struct Corpo Corpo;
typedef struct Funcao Funcao;
typedef struct Mix Mix;

typedef struct Lits Lits;
typedef struct Lit Lit;




typedef struct Stats Stats;

typedef struct Stat Stat;

typedef struct Nl Nl;

struct Decls{
    enum decls_kind kind;
    
    Decl  *decl;
    Decls *decls;
    
};


struct Decl{
    enum decl_kind kind;

    Decl1  *decl1;
    
};



struct Decl1{
    enum decl1_kind kind;
    
    char *nome1;
    char *nome2;
    Ids *ids;
    IdsType *idstype;
    Type *type;
    Exp *exp;
    Corpo *corpo;
    
};


struct Id
{
    enum id_kind kind;
    char *nome;
};

struct Ids{
    enum ids_kind kind;
    char *nome;
    Ids *ids;
};

struct Type{
    
    enum type_kind kind;
    
    Type *type;
    Exp *exp;

    
};

struct IdsType{

    enum idstype_kind kind;

    char *nome;
    Type *type;
    IdsType *idstype;

};



struct Exp
{
    enum exp_kind kind;
    union{
        Exp *exp1;
        Funcao *funcao;
        int inteiro;
        bool boleano;
        float floatt;
        char *string;
    }u1;

    union{
        Exp *exp2;
        Id *id;
        Type *type;
    }u2;
    
};


struct Funcao
{
    enum funcao_kind kind;
    union{
        Funcao *funcao;
        Mix *mix;
        IdsType *idstype;
    }u;
    
    char *nome;
    
};


struct Mix
{
    enum mix_kind kind;
    union{
        Lits *lits;
        Ids *ids;
    }u;
      
};

struct Lits{
    enum lits_kind kind;
    Lit *lit;
    Lits *lits;
};

struct Lit
{
    enum lit_kind kind;
    union{
        Exp *exp;
        int inteiro;
        bool boleano;
        float floatt;
        char *string;
    }u;
    
    Type *type;  
};





struct Nl
{
    enum nl_kind kind;
    Nl *nl;
};


struct Corpo
{
    enum corpo_kind kind;
    Stats *stats;   
};



struct Stats{
    enum stats_kind kind;
    
    Stat *stat;
    Stats *stats;
    
};

struct Stat{
    enum stat_kind kind;

    Decl *decl;
    Exp *exp;
    Corpo *corpo1;
    Corpo *corpo2;

};





Decls *new_decls(Decl *decl, Decls *decls)
{
    
    Decls *n_decls = malloc(sizeof(Decls));
    
    if (decls == NULL) {
        n_decls->kind = NONE_DECLS;
    }
    else
    {
        n_decls->kind = DECLS_;
    }
    
    n_decls->decl = decl;
    n_decls->decls = decls;
    
    return  n_decls;
}



Decl *new_decl(Decl1 *decl1)
{
    
    Decl *n_decl = malloc(sizeof(Decl));
    
    n_decl->kind = DECL_;
    n_decl->decl1 = decl1;
    
    return  n_decl;
}





Decl1 *new_decl1(char *nome1, char *nome2,
    Ids *ids, IdsType *idstype, 
    Type *type, Exp *exp, Corpo *corpo, enum decl1_kind kind)
{
    Decl1 *n_decl1 =malloc(sizeof(Decl1));
    
    n_decl1->kind = kind;
    n_decl1->nome1 = nome1;
    n_decl1->nome2 = nome2;
    n_decl1->ids = ids;
    n_decl1->idstype = idstype;
    n_decl1->type = type;
    n_decl1->exp = exp;
    n_decl1->corpo = corpo;
    
    return n_decl1;
}



Id *new_id(char *nome)
{
    Id *new_id = malloc(sizeof(Id));
    
    new_id->nome = strdup(nome);
    new_id->kind = ID_1;
    
    return new_id;
}

Ids *new_ids(char *nome, Ids *ids, enum ids_kind kind)
{
    Ids *n_ids = malloc(sizeof(Ids));
    
    n_ids->kind = kind;
    n_ids->nome = nome;
    n_ids->ids = ids;
    
    return n_ids;
}


IdsType *new_idstype(char *nome, Type *type, IdsType *idstype, enum idstype_kind kind)
{
    IdsType *n_idstype = malloc(sizeof(IdsType));
    
    n_idstype->kind = kind;
    n_idstype->nome = nome;
    n_idstype->type = type;
    n_idstype->idstype = idstype;
    
    return n_idstype;
}





Type *new_type(Type *type, Exp *exp, enum type_kind kind)
{
    Type *n_type = malloc(sizeof(Type));

    n_type->kind = kind;
    switch (kind){
        case ARRAY_:
            n_type->type = type;
            n_type->exp = exp;
            break;
        default:
            break;
    }
    
    
    
    return n_type;
}




Exp *new_exp(Exp *exp1 ,Exp *exp2 , Id *id, Funcao *funcao, 
        Type *type, int inteiro, float floatt, bool boleano,
        char *string, enum exp_kind kind)
{
    Exp *n_exp = malloc(sizeof(Exp));
    
    n_exp->kind = kind;
    
    switch (kind) {
        case EXP_PAR :
            n_exp->u1.exp1 = exp1;
            break;
        case EXP_ASSIGN :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.id = id;
            break;
        case EXP_FUNC :
            n_exp->u1.funcao = funcao;
            break;
        case EXP_ADD :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_SUB :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_MUL :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_DIV :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_MOD :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_NEG :
            n_exp->u1.exp1 = exp1;
            break;
        case EXP_EQUAL :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_DIFF :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_AND :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_OR :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_NOT :
            n_exp->u1.exp1 = exp1;
            break;
        case EXP_LESSOREQUAL :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_LESS :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_GREATEROREQUAL :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_GREATER :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.exp2 = exp2;
            break;
        case EXP_ID :
            n_exp->u2.id = id;
            break;
        case EXP_BOOL_LIT :
            n_exp->u1.boleano = boleano;
            break;
        case EXP_INT_LIT :
            n_exp->u1.inteiro = inteiro;
            break;
        case EXP_FLOAT_LIT :
            n_exp->u1.floatt = floatt;
            break;
        case EXP_STRING_LIT :
            n_exp->u1.string = string;
            break;
        case EXP_ARRAY_LIT :
            n_exp->u1.exp1 = exp1;
            n_exp->u2.type = type;
            break;
        default:
            break;
    }

    
    return n_exp;
}




Funcao *new_funcao(char *nome,Funcao *funcao, Mix *mix, IdsType *idstype,enum funcao_kind kind)
{
    Funcao *n_funcao = malloc(sizeof(Funcao));
    
    n_funcao->kind = kind;
    n_funcao->nome = nome;
    
    switch (kind) {
        case FUNC_FUNC:
            n_funcao->u.funcao = funcao;
            break;
        case FUNC_MIX :
            n_funcao->u.mix = mix;
            break;
        case FUNC_IDSTYPE :
            n_funcao->u.idstype = idstype;
            break;
        default:
            break;
    }
    
    return n_funcao;
}








Mix *new_mix(Lits *lits, Ids *ids,  enum mix_kind kind)
{
    Mix *n_mix = malloc(sizeof(Mix));
    
    n_mix->kind = kind;
    
    switch (kind) {
        case LITS_:
            n_mix->u.lits = lits;
            break;
        case IDS_ :
            n_mix->u.ids = ids;
            break;
        default:
            break;
    }
    
    return n_mix;
}




Lits *new_lits(Lit *lit, Lits *lits, enum lits_kind kind)
{
    Lits *n_lits = malloc(sizeof(Lits));
    
    n_lits->kind = kind;
    n_lits->lit = lit;
    n_lits->lits = lits;
    
    return n_lits;
}



Lit *new_lit(Type *type, int inteiro, bool boleano, 
    float floatt, char *string, Exp *exp,enum lit_kind kind)
{
    Lit *n_lit = malloc(sizeof(Lit));

    n_lit->kind = kind;
    
    switch (kind) {
        case INT_LITE:
            n_lit->u.inteiro = inteiro;
            break;
        case BOOL_LITE :
            n_lit->u.boleano = boleano;
            break;
        case FLOAT_LITE:
            n_lit->u.floatt = floatt;
            break;
        case STRING_LITE:
            n_lit->u.string = strdup(string);
            break;
        case ARRAY_LITE:
            n_lit->u.exp = exp;
            n_lit->type = type;
            break;
        default:
            break;
    }
    
    return n_lit;
}















Corpo *new_corpo(Stats *stats)
{
    
    Corpo *n_corpo = malloc(sizeof(Corpo));
    
    n_corpo->kind = CORPO;
    n_corpo->stats = stats;
    
    return  n_corpo;
}





Stats *new_stats(Stat *stat, Stats *stats, enum stats_kind kind )
{
    
    Stats *n_stats = malloc(sizeof(Stats));
    
    if (stat == NULL) {
        n_stats->kind = NONE_STATS;
    }
    else
    {
        n_stats->kind = kind;
    }
    
    n_stats->stat = stat;
    n_stats->stats = stats;
    
    return  n_stats;
}


Stat *new_stat(Decl *decl, Exp *exp, 
    Corpo *corpo1, Corpo *corpo2 , enum stat_kind kind )
{
    
    Stat *n_stat = malloc(sizeof(Stat));
    
    n_stat->kind = kind;
    n_stat->decl = decl;
    n_stat->exp = exp;
    n_stat->corpo1 = corpo1;
    n_stat->corpo2 = corpo2;

    
    return  n_stat;
}



