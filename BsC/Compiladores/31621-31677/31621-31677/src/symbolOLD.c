#include <stdio.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>
#include "apt.h"
#define TAMANHO_TABELA 256



typedef struct NoHashtable *NoHashtable;
typedef struct Hashtable *Hashtable;

void insertId(char *id, Type *type);
void insertFunc(char *func, Type *type , Hashtable hash);
void insertIds(Ids *ids, Type *type);
enum type_kind look(char *id , Hashtable hash);
void new_scope(Hashtable hash);
void drop_scope(Hashtable hash);


struct NoHashtable{

    char *nomeId;
    enum type_kind tipo;

};

struct Hashtable{
    int curr;
    NoHashtable *tabela[TAMANHO_TABELA];
    Hashtable *new;
    Hashtable *old;
    Hashtable *original;
};


struct Hashtable SYMBOLTABLE;
int CURR=1;

NoHashtable no_create(){
    NoHashtable nohashtable = malloc(sizeof(NoHashtable)); 
    return nohashtable;
}


Hashtable ht_create() {

    Hashtable hashtable = malloc(sizeof(Hashtable)); 
    hashtable->curr=0;

    return hashtable;   
}





void insertFunc(char *func, Type *type , Hashtable hash){

    NoHashtable no = no_create();
    no->nomeId = strdup(func);
    no->tipo = type->kind;

    int now = hash->curr;
    *hash->tabela[now] = no;
    hash->curr++;

    new_scope(hash);
}


void insertId(char *id, Type *type){

    printf("win3\n");

    NoHashtable no = no_create();
    no->nomeId = strdup(id);
    no->tipo = type->kind;
    printf("win4\n");
    int now = CURR;
    printf("win5\n");
    printf("%d\n", now);
    *SYMBOLTABLE.tabela[CURR] = no;
    printf("win6\n");
    CURR++;
    printf("win7\n");

}



void insertIds(Ids *ids, Type *type){

    Ids *novo = ids;
    printf("%s\n", novo->nome);
    printf("%d\n", type->kind);
    printf("chegou!\n");
    while(novo!= NULL){
        printf("Win!!!\n");
        insertId(novo->nome, type);
        printf("Win2!!!\n");
        if(novo->ids != NULL){
            printf("chegou2 ahah");
            novo = novo->ids;
        }
        else{
            break;
        }
        
    }
}


enum type_kind look(char *id , Hashtable hash){

    Hashtable base = *hash->original;
    bool continuar=true;
    while(base!=hash && continuar){
        int i;
        int tamanho = base->curr;
        for(i = 0; i < tamanho; i++){
            
            NoHashtable *no1 = base->tabela[i];
            if(id == (*no1)->nomeId){
                return (*no1)->tipo;
                continuar = false;
                break;
            }
        }
        base = *base->new;
    }

    int i;
    int tamanho = base->curr;
    for(i = 0; i < tamanho; i++){
            
            NoHashtable *no1 = base->tabela[i];
            if(id == (*no1)->nomeId){
                return (*no1)->tipo;
                continuar = false;
                break;
            }
    }

    
}










void new_scope(Hashtable hash){
    Hashtable nova= ht_create();
    *nova->old = hash;
    *hash->new = nova;
    
}

void drop_scope(Hashtable hash){
    Hashtable *antigo = hash->old;
    (*antigo)->new = NULL;
    *hash->old = NULL;
    free(hash);
}







int main (void)
{
	return 0;

}
