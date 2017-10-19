#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define MAX_SIZE 120011
#define TAMANHO_IDEN 7
#define TAMANHO_ITEM 10
#define PRIME 119993

//Defenir itens
typedef struct items {
	float price; //4
	char code[TAMANHO_ITEM+1];  //11
	bool active; //1
	short quant; //2
	char fill[2]; //2
} item ; //20


//Defenir cestos de itens
typedef struct Cestos {
	int age; //4
	char ident[TAMANHO_IDEN+1]; //8
	item itens[TAMANHO_ITEM]; //200
	bool used; //1
	char fill[3]; //3
} cesto ; //216

typedef struct HashTable {
	cesto arr[MAX_SIZE]; //25 922 376
	int idade; //4
} ht ; // 25 922 380


void bubble_sort(cesto list[], int n) { //algoritmo dado nas aulas de EDA1
	int c, d;
	cesto t;

	for (c = 0; c < (n-1); c++) {
		for (d = 0; d < n - c - 1; d++) {
			if (list[d].age > list[d+1].age) {
				t = list[d];
				list[d] = list[d+1];
				list[d+1] = t;
			}
		}
	}
}
/*
void merge(cesto arr[], int l, int m, int r) {
	int i, j, k;
	int n1 = m - l + 1;
	int n2 = r - m;

	cesto L[n1], R[n2];

	for (i = 0; i < n1; i++)
		L[i] = arr[l + i];
	for (j = 0; j < n2; j++)
		R[j] = arr[m + l + j];

	i = 0;
	j = 0;
	k = l;

	while (i < n1 && j < n2) {
		if (L[i].age <= R[j].age) {
			arr[k] = L[i];
			i++;
		}
		else {
			arr[k] = R[j];
			j++;
		}
		k++;
	}

	while (i < n1) {
		arr[k] = L[i];
		i++;
		k++;
	}

	while (j < n2) {
		arr[k] = R[j];
		j++;
		k++;
	}
}

void mergeSort(int arr[], int l, int r) {
	if (l < r) {
		int m = l + (r-l) / 2;
		mergeSort(arr, l , m);
		mergeSort(arr, m+1, r);
		merge(arr, l, m, r);
	}
}
*/
void bubble_sort_string(item list[], short n) { //mesmo algoritmo mas adaptado para comparar strings
	short c, d;
	item t;

	for (c = 0; c < (n-1); c++) {
		for (d = 0; d < n - c - 1; d++) {
			if (strncmp(list[d].code, list[d+1].code, TAMANHO_ITEM) > 0) {
				t = list[d];
				list[d] = list[d+1];
				list[d+1] = t;
			}
		}
	}
}

void Insert_Item(ht *HashTable, int hash, char codigo[], short quantidade, float preco) {
	int livre;

	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == false)
			livre = i;
		else if (strcmp(HashTable->arr[hash].itens[i].code, codigo) == 0) {
			HashTable->arr[hash].itens[i].quant += quantidade;
			return;
		}
	}
	strncpy(HashTable->arr[hash].itens[livre].code, codigo, 11);
	HashTable->arr[hash].itens[livre].quant = quantidade;
	HashTable->arr[hash].itens[livre].price = preco;
	HashTable->arr[hash].itens[livre].active = true;
	return;
}

void Remove_Item(ht *HashTable, int hash, char identificador[], char codigo[], short quantidade) {
	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == true && strcmp(HashTable->arr[hash].itens[i].code, codigo) == 0) {
			if (HashTable->arr[hash].itens[i].quant > quantidade) {
				HashTable->arr[hash].itens[i].quant -= quantidade;
				printf("+ %hd unidade(s) de %s retirada(s) do cesto %s\n", quantidade, codigo, identificador);
				return;
			}else if (HashTable->arr[hash].itens[i].quant == quantidade) {
				HashTable->arr[hash].itens[i].active = false;
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
	short x = 0;
	float total = 0.0;
	item list[TAMANHO_ITEM];

	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == true) {
			list[x] = HashTable->arr[hash].itens[i];
			x++;
			if (x == 1)
				printf("VC %s\n", identificador);
		}
	}
	if (x == 0)
		printf("+ cesto %s vazio\n", identificador);
	else {
		bubble_sort_string(list, x);

		for (int i = 0; i < x; i++) {
			float temp =list[i].quant * list[i].price;
			printf("%s %3hd %8.2f %8.2f\n", list[i].code, list[i].quant, list[i].price, temp);
			total += temp;
		}
		printf("%.2f\n", total);
	}
}

bool isEmpty(ht *HashTable, int hash) {
	bool vazio = true;

	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == true) {
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
	/*int fd;

	fd = open(name, O_CREAT | O_RDWR, S_IRUSR | S_IWUSR);

	if (fd == -1) {
		perror("open");

		return NULL;
	}
*/
	ht *HashTable = malloc(sizeof(ht));
/*
	switch (read(fd, &HashTable, sizeof(ht))) {
		case -1:
			perror("read");

			close(fd);

			return NULL;

		case 0:*/
			//HashTable->fd = fd;
	HashTable->idade = 0;
			/*
			return HashTable;

		default:
			HashTable->fd = fd;

			return HashTable;

	}*/
	return HashTable;
}

void Free_HashTable(ht *HashTable) {
	free(HashTable);
}

unsigned long HashCode(char x[]) { //funcao de hash djb2
	unsigned long hash = 5831;
	int c;

	while ( (c = *x++) ){
		hash = ((hash << 5) + hash) + c;
	}

	return hash;
}

//Funcao de Hash usada nas aulas de EDA1
int Hash1(char x[]) {
	unsigned long hashcode = HashCode(x);
	hashcode %= MAX_SIZE;

	int hash = (int) hashcode;

	if (hash < 0)
		hash += MAX_SIZE;

	return hash;
}

int Hash2(ht *HashTable, char x[]) {
	unsigned long hashcode = HashCode(x);
	hashcode %= MAX_SIZE;

	int hash = (int) hashcode;

	if (hash < 0)
		hash += MAX_SIZE;

	return PRIME - hash % PRIME;
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

bool Put_Cesto(ht *HashTable, int idade, char key[]) {
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
		strncpy(HashTable->arr[hash1].ident, key, 8);
		HashTable->arr[hash1].age = idade;
		for (int i = 0; i < TAMANHO_ITEM; i++)
			HashTable->arr[hash1].itens[i].active = false;
	}
	return true;
}

bool Remove_Cesto(ht *HashTable, char key[]) {
	int hash1 = Hash1(key);
	int hash2 = Hash2(HashTable, key);

	while(HashTable->arr[hash1].used == true) {
		if (strcmp(key, HashTable->arr[hash1].ident) == 0){
			for (int i = 0; i < TAMANHO_ITEM; i++)
				HashTable->arr[hash1].itens[i].active = false;
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



void CC(ht *HashTable, int idade) {
	char id[TAMANHO_IDEN+1];

	scanf("%s", id);
	bool teste = Put_Cesto(HashTable, idade, id);
	if (teste)
		printf("+ cesto %s criado\n", id);
	else
		printf("+ cesto %s existente\n", id);

}

void IC(ht *HashTable, int idade) {
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

void RC(ht *HashTable, int idade) {
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

void VC(ht *HashTable, int idade) {
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

void EC(ht *HashTable, int idade) {
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

void LC(ht *HashTable, int idade) {
	int age;
	int index = 0;
	bool lc = true;
	cesto list[idade];

	scanf("%d", &age);

	int tempo = idade - age;
	for (int i = 0; i < MAX_SIZE; i++) {
		if (HashTable->arr[i].used == true && HashTable->arr[i].age < tempo) {
			if (lc){
				printf("LC %d\n", age);
				lc = false;
			}
			list[index] = HashTable->arr[i];
			index++;
			Remove_Cesto(HashTable, HashTable->arr[i].ident);
			
			
		}
	}
	if (lc)
		printf("+ sem cestos com idade superior a %d\n", age);
	else {
		bubble_sort(list, index);
		for (int i = 0; i < index; i++) {
			printf("%s\n", list[i].ident);
		}
	}

}

void XX(ht *HashTable, int idade) {
	return;
}

short Cestos_Virtuais(ht *HashTable, char in[], int idade) {
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
/*
	char in[2];


	short idade = HashTable->idade, teste;

	while(scanf("%s", in) == 1) {
		teste = Cestos_Virtuais(HashTable, in, idade);
		idade++;

		if (teste == -1)
			break;
	}

*/

	ht *HashTable = Create_HashTable();

	//Testinhos Terceiros (read/write)
	FILE *file = fopen("output", "r");
    if (file != NULL) {
        fread(HashTable, sizeof(ht), 1, file);
        fclose(file);
    }

    char in[2];

	int idade = HashTable->idade;
	int teste = 0;

	while(scanf("%s", in) == 1 && teste != -1) {
		teste = Cestos_Virtuais(HashTable, in, idade);
		idade++;
	}

	HashTable->idade = idade;

    file = fopen("output", "w");
	if (file != NULL) {
    	fwrite(HashTable, sizeof(ht), 1, file);
    	fclose(file);
	}
	//printf("%ld\n", sizeof(ht));

	Free_HashTable(HashTable);
	return 0;
}