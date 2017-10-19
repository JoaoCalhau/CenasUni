#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define MAX_SIZE 200000
#define TAMANHO_IDEN 7
#define TAMANHO_ITEM 10
#define PRIME 199999

//Defenir itens
typedef struct items {
	char code[TAMANHO_ITEM+1];
	short quant;
	float price;
	short active;
} item ;

//Defenir cestos de itens
typedef struct Cestos {
	char ident[TAMANHO_IDEN+1];
	item itens[TAMANHO_ITEM];
	short age;
	bool used;
} cesto ;

typedef struct HashTable {
	short idade;
	int occupied, primeSize;
	cesto arr[MAX_SIZE];
} ht ;




void Insert_Item(ht *HashTable, int hash, char codigo[], short quantidade, float preco) {
	int livre;

	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == 0)
			livre = i;
		else if (strcmp(HashTable->arr[hash].itens[i].code, codigo) == 0) {
			HashTable->arr[hash].itens[i].quant += quantidade;
			return;
		}
	}
	strcpy(HashTable->arr[hash].itens[livre].code, codigo);
	HashTable->arr[hash].itens[livre].quant = quantidade;
	HashTable->arr[hash].itens[livre].price = preco;
	HashTable->arr[hash].itens[livre].active = 1;
	return;
}

void Remove_Item(ht *HashTable, int hash, char identificador[], char codigo[], short quantidade) {
	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == 1 && strcmp(HashTable->arr[hash].itens[i].code, codigo) == 0) {
			if (HashTable->arr[hash].itens[i].quant > quantidade) {
				HashTable->arr[hash].itens[i].quant -= quantidade;
				printf("+ %hd unidade(s) de %s retirada(s) do cesto %s\n", quantidade, codigo, identificador);
				return;
			}else if (HashTable->arr[hash].itens[i].quant == quantidade) {
				HashTable->arr[hash].itens[i].active = 0;
				printf("+ %hd unidade(s) de %s retirada(s) do cesto %s\n", quantidade, codigo, identificador);
				return;
			}else {
				printf("+ quantidade de %s no cesto %s menor que %hd\n", codigo, identificador, quantidade);
				return;
			}
		}
	}
	printf("+ produto %s ausente do cesto %s\n", codigo, identificador);
}

void Visualize_Item(ht *HashTable, int hash, char identificador[]) {
	int x = 0;
	float total = 0.0;

	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == 1) {
			x++;
			if (x == 1)
				printf("VC %s\n", identificador);
			float temp = HashTable->arr[hash].itens[i].quant * HashTable->arr[hash].itens[i].price;
			printf("%s %3hd %8.2f %8.2f\n", HashTable->arr[hash].itens[i].code, 
				HashTable->arr[hash].itens[i].quant, 
				HashTable->arr[hash].itens[i].price, temp);
			total += temp;
		}
	}
	if (x == 0)
		printf("+ cesto %s vazio\n", identificador);
	else
		printf("%.2f\n", total);
}

bool isEmpty(ht *HashTable, int hash) {
	bool vazio = true;

	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == 1) {
			vazio = false;
		}
	}

	return vazio;
}
/*
int getPrime() {
	int i, j;
	for (i = MAX_SIZE-1; i >= 1; i--) {
		int fact = 0;
		for (j = 2; j <= (int) sqrt(i); j++) {
			if (i % j == 0)
				fact++;
		}
		if (fact == 0)
			return i;
	}
	return 3;
}

*/
ht *Create_HashTable() {
	ht *HashTable = malloc(sizeof(ht));

	HashTable->idade = 0;
	HashTable->occupied = 0;
	//HashTable->primeSize = getPrime();
	HashTable->primeSize = PRIME;

	return HashTable;
}

void Free_HashTable(ht *HashTable) {
	free(HashTable);
}

long HashCode(char x[]) {
	long hash = 0;
	short i;


	for (i = 0; i < TAMANHO_IDEN; i++) {
		if (x[i] >= 97 && x[i] <= 122)
			hash += (x[i] - 87)* (long) pow(36, i);
		else if (x[i] >= 48 && x[i] <= 57)
			hash += (x[i] -48)* (long) pow(36, i);
	}

	return hash;
}

//Funcao de Hash usada nas aulas de EDA1
int Hash1(char x[]) {
	long hashcode = HashCode(x);
	hashcode %= MAX_SIZE;

	int hash = (int) hashcode;

	if (hash < 0)
		hash += MAX_SIZE;

	return hash;
}

int Hash2(ht *HashTable, char x[]) {
	long hashcode = HashCode(x);
	hashcode %= MAX_SIZE;

	int hash = (int) hashcode;

	if (hash < 0)
		hash += MAX_SIZE;

	return HashTable->primeSize - hash % HashTable->primeSize;
}

int Get_Cesto(ht *HashTable, char key[]) {
	int hash1 = Hash1(key);
	int hash2 = Hash2(HashTable, key);

	while (HashTable->arr[hash1].used == true) {
		if (strcmp(key, HashTable->arr[hash1].ident) == 0)
			return hash1;
		else{
			hash1 += hash2;
			hash1 %= MAX_SIZE;
		}
	}
	return -1;
}

bool Put_Cesto(ht *HashTable, short idade, char key[]) {
	int hash1 = Hash1(key);
	int hash2 = Hash2(HashTable, key);

	while(HashTable->arr[hash1].used == true){
		if (strcmp(key, HashTable->arr[hash1].ident) == 0){
			return false;
		}
		else{
			hash1 += hash2;
			hash1 %= MAX_SIZE;
		}	
	}
	
	if (HashTable->arr[hash1].used == false) {
		HashTable->arr[hash1].used = true;
		strcpy(HashTable->arr[hash1].ident, key);
		HashTable->arr[hash1].age = idade;
		for (int i = 0; i < TAMANHO_ITEM; i++)
			HashTable->arr[hash1].itens[i].active = 0;
	}
	return true;
}

bool Remove_Cesto(ht *HashTable, char key[]) {
	int hash1 = Hash1(key);
	int hash2 = Hash2(HashTable, key);

	while(HashTable->arr[hash1].used == true) {
		if (strcmp(key, HashTable->arr[hash1].ident) == 0){
			for (int i = 0; i < TAMANHO_ITEM; i++)
				HashTable->arr[hash1].itens[i].active = 0;
			HashTable->arr[hash1].used = false;
			return true;
		}	
		else{
			hash1 += hash2;
			hash1 %= MAX_SIZE;
		}
	}

	return false;
	
}

void CC(ht *HashTable, short idade) {
	char id[TAMANHO_IDEN+1];

	scanf("%s", id);
	bool teste = Put_Cesto(HashTable, idade, id);
	if (teste)
		printf("+ cesto %s criado\n", id);
	else
		printf("+ cesto %s existente\n", id);
}

void IC(ht *HashTable, short idade) {
	char id[TAMANHO_IDEN+1], cod[TAMANHO_ITEM+1];
	short quant;
	float preco;

	scanf("%s %s %hd %f", id, cod, &quant, &preco);

	int teste = Get_Cesto(HashTable, id);
	if (teste < 0) //cesto nao existe
		printf("+ cesto %s inexistente\n", id);
	else { //cesto existe e introduz
		Insert_Item(HashTable, teste, cod, quant, preco);
		HashTable->arr[teste].age = idade;
		printf("+ %hd unidade(s) de %s introduzida(s) no cesto %s\n", quant, cod, id);
	}
}

void RC(ht *HashTable, short idade) {
	char id[TAMANHO_IDEN+1], cod[TAMANHO_ITEM+1];
	short quant;

	scanf("%s %s %hd", id, cod, &quant);

	int teste = Get_Cesto(HashTable, id);
	if (teste < 0) //Cesto nao existe
		printf("+ cesto %s inexistente\n", id);
	else {//produto esta no cesto
		Remove_Item(HashTable, teste, id, cod, quant); 
		HashTable->arr[teste].age = idade;
	}
}

void VC(ht *HashTable, short idade) {
	char id[TAMANHO_IDEN+1];

	scanf("%s", id);

	int teste = Get_Cesto(HashTable, id);
	if (teste < 0)
		printf("+ cesto %s inexistente\n", id);
	else {
		Visualize_Item(HashTable, teste, id);
		HashTable->arr[teste].age = idade;
	}
}

void EC(ht *HashTable, short idade) {
	char id[TAMANHO_IDEN+1];

	scanf("%s", id);

	int teste = Get_Cesto(HashTable, id);
	if (teste < 0 )
		printf("+ cesto %s inexistente\n", id);
	else {
		if (isEmpty(HashTable, teste) == false) {
			Remove_Cesto(HashTable, id);
			printf("+ efectuada venda do cesto %s\n", id);
		} else {
			printf("+ cesto %s vazio\n", id);
			HashTable->arr[teste].age = idade;
		}
	}
}

void XC(ht *HashTable) {
	char id[TAMANHO_IDEN+1];

	scanf("%s", id);

	int teste = Get_Cesto(HashTable, id);
	if (teste < 0)
		printf("+ cesto %s inexistente\n", id);
	else {
		Remove_Cesto(HashTable, id);
		printf("+ cesto %s cancelado\n", id);
	}
}

void LC(ht *HashTable, short idade) {
	short age;
	bool lc = true;

	scanf("%hd", &age);

	int tempo = idade - age;
	for (int i = 0; i < MAX_SIZE; i++) {
		if (HashTable->arr[i].used == true) {
			if (HashTable->arr[i].age < tempo ) {
				if (lc){
					printf("LC %hd\n", age);
					lc = false;
				}
				printf("%s\n", HashTable->arr[i].ident);
				Remove_Cesto(HashTable, HashTable->arr[i].ident);
				
			}
		}
	}
	if (lc)
		printf("+ sem cestos com idade superior a %hd\n", age);

}

void XX(ht *HashTable, short idade) {
	HashTable->idade = idade;
	return;
}

short Cestos_Virtuais(ht *HashTable, char in[], short idade) {
	char cc[2]="CC", ic[2]="IC", rc[2]="RC", vc[2]="VC", ec[2]="EC", xc[2]="XC", lc[2]="LC";

	if (strncmp(in, cc, 2) == 0) {
		CC(HashTable, idade);
		return 1;
	} else if (strncmp(in, ic, 2) == 0) {
		IC(HashTable, idade);
		return 1;
	} else if (strncmp(in, rc, 2) == 0) {
		RC(HashTable, idade);
		return 1;
	} else if (strncmp(in, vc, 2) == 0) {
		VC(HashTable, idade);
		return 1;
	} else if (strncmp(in, ec, 2) == 0) {
		EC(HashTable, idade);
		return 1;
	} else if (strncmp(in, xc, 2) == 0) {
		XC(HashTable);
		return 1;
	} else if (strncmp(in, lc, 2) == 0) {
		LC(HashTable, idade);
		return 1;
	} else {
		XX(HashTable, idade);
		return -1;
	}
 }

int main() {
	ht *HashTable = Create_HashTable();
/* Testinhos primeiros (HashCenas)
	char nome[] = "cestoum";
	char nome2[] = "cesto01";
	char nome3[] = "desto01";

	short idade = 100;

	Put_Cesto(HashTable, idade, nome);
	Put_Cesto(HashTable, idade, nome2);
	Put_Cesto(HashTable, idade, nome3);
	
	cesto *cesto = Get_Cesto(HashTable, nome);
	printf("Nome: %s, Idade: %d\n", cesto->ident, cesto->age);
	cesto = Get_Cesto(HashTable, nome2);
	printf("Nome: %s, Idade: %d\n", cesto->ident, cesto->age);
	cesto = Get_Cesto(HashTable, nome3);
	printf("Nome: %s, Idade: %d\n", cesto->ident, cesto->age);
*/

/*Testinhos segundos (Scanfs)
*/
	char in[2];


	short idade = HashTable->idade, teste;

	while(scanf("%s", in) == 1) {
		teste = Cestos_Virtuais(HashTable, in, idade);
		idade++;

		if (teste == -1)
			break;
	}


	Free_HashTable(HashTable);
	return 0;
}