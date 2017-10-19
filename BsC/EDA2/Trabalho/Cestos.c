#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Cestos.h"


#define TAMANHO_IDEN 7
#define TAMANHO_ITEM 10

//Defenir itens
struct item {
	char code[TAMANHO_ITEM+1];
	short quant;
	float price;
	bool active;
};

//Defenir cestos de itens
struct Cesto {
	char ident[TAMANHO_IDEN+1];
	struct item itens[TAMANHO_ITEM];
	short age;
	bool used;
};

struct Cesto *Cesto_new(char identificador[], short idade) {
	struct Cesto *cesto = malloc(sizeof(struct Cesto));

	strncpy(cesto->ident, identificador, TAMANHO_IDEN);

	int i;
	for(i = 0; i < TAMANHO_ITEM; i++) {
		cesto->itens[i].active = false;
	}

	cesto->age = idade;
	cesto->used = false;

	return cesto;
}

void Cesto_free(struct Cesto *cesto) {
	free(cesto);
}

/*
struct Cesto *Cesto_create(char iden[], short idade) {
	//Ver ao disco se já existe cesto com o nome
}
*/
void Cesto_insert(struct Cesto *cesto, char codigo[], short quantidade, float price, short age) {
	
}
/*
int main() {
	int i;
	char array[7] = "Cestoum";
	short idade = 100;

	struct Cesto *cesto = Cesto_new(array, idade);

	printf("%hd\n", cesto->age);
	for(i = 0; i < TAMANHO_IDEN; i++) {
		//printf("%d\n", cesto->itens[i].active);
		printf("%c ", array[i]);
	}

	printf("\n");
	printf("%s\n", cesto->ident);
	Cesto_free(cesto);
	return 0;
}*/