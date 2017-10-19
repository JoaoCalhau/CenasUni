#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define MAX_SIZE 200003 //Tamanho da HashTable
#define TAMANHO_IDEN 7  //Tamanho total nome de cestos (sem \0)
#define TAMANHO_ITEM 10 //Tamanho total nome dos itens (sem \0)
#define PRIME 199999    //Primo utilizado na funcao de hash2

//Definir itens
typedef struct items {
	float price;                //4 bytes
	char code[TAMANHO_ITEM+1];  //11 bytes
	bool active;                //1 bytes
	short quant;                //2 bytes
	char fill[2];               //2 bytes
} item ;                        //total 20 bytes


//Definir cestos de itens
typedef struct Cestos {
	int age;                    //4 bytes
	char ident[TAMANHO_IDEN+1]; //8 bytes
	item itens[TAMANHO_ITEM];   //200 bytes
	bool used;                  //1 bytes
	char fill[3];               //3 bytes
} cesto ;                       //total 216 bytes

//Definir HashTable
typedef struct HashTable {
	cesto arr[MAX_SIZE];        //25 922 376 bytes
	int idade;                  //4 bytes
} ht ;                          //total 25 922 380 bytes (25,9 MB)


void merge(cesto **Cesto, int n, int m) {
	int i, j, k;
	cesto **temp = malloc(n * sizeof(cesto));

	for (i = 0, j = m, k = 0; k < n; k++) {
		temp[k] = j == n                        ? Cesto[i++]
			 : i == m                           ? Cesto[j++]
			 : Cesto[j]->age < Cesto[i]->age    ? Cesto[j++]
			 :                                    Cesto[i++];
	}

	for (i = 0; i < n; i++) {
		Cesto[i] = temp[i];
	}
	free(temp);
}

//merge sort das aulas e EDA1
//Ordena um array dividindo-o em partes mais pequenas
//até essas partes terem 1 elemento
//depois faz "merge" das partes ordenadas
void merge_sort(cesto **Cesto, int n) {
	if (n < 2)
		return;
	int m = n / 2;
	merge_sort(Cesto, m);
	merge_sort(Cesto + m, n - m);
	merge(Cesto, n, m);
}

 //Bubble sort de EDA1 adaptado a strings
void bubble_sort_string(item *list[], short n) {
	short c, d;
	item *t;

	for (c = 0; c < (n-1); c++) {
		for (d = 0; d < n - c - 1; d++) {
			if (strncmp(list[d]->code, list[d+1]->code, TAMANHO_ITEM) > 0) {
				t = list[d];
				list[d] = list[d+1];
				list[d+1] = t;
			}
		}
	}
}

//Insere um item num cesto (ou incrementa esse item)
void Insert_Item(ht *HashTable, int hash, char codigo[], short quantidade, float preco) {
	int livre; //ultimo espaco livre a ser encontrado

	//Percorre todos os itens do cesto
	for (int i = 0; i < TAMANHO_ITEM; i++) {
		//caso o espaco esteja livre (active = false) mete a variavel livre nesse espaco
		if (HashTable->arr[hash].itens[i].active == false)
			livre = i;
		//caso o codigo seja igual, aumenta a quantidade desse item
		else if (strcmp(HashTable->arr[hash].itens[i].code, codigo) == 0) {
			HashTable->arr[hash].itens[i].quant += quantidade;
			return;
		}
	}
	//Caso seja um item novo, coloca-o na posicao referenciada pela variavel livre
	strncpy(HashTable->arr[hash].itens[livre].code, codigo, 11);
	HashTable->arr[hash].itens[livre].quant = quantidade;
	HashTable->arr[hash].itens[livre].price = preco;
	HashTable->arr[hash].itens[livre].active = true;
	return;
}

//Remove um item de um cesto
void Remove_Item(ht *HashTable, int hash, char identificador[], char codigo[], short quantidade) {
	//Percorre todos os itens do cesto
	for (int i = 0; i < TAMANHO_ITEM; i++) {
		//Caso o item seja activo e o codigo seja igual
		if (HashTable->arr[hash].itens[i].active == true && strcmp(HashTable->arr[hash].itens[i].code, codigo) == 0) {
			//Se a quantidade for maior á que queremos remover, diminui a quantidade
			if (HashTable->arr[hash].itens[i].quant > quantidade) {
				HashTable->arr[hash].itens[i].quant -= quantidade;
				printf("+ %hd unidade(s) de %s retirada(s) do cesto %s\n", quantidade, codigo, identificador);
				return;
			}
			//Se a quantidade for igual, muda o active para false (item ja nao existe neste cesto)
			else if (HashTable->arr[hash].itens[i].quant == quantidade) {
				HashTable->arr[hash].itens[i].active = false;
				printf("+ %hd unidade(s) de %s retirada(s) do cesto %s\n", quantidade, codigo, identificador);
				return;
			}
			//Se a quantidade for maior do que a existente, nao modifica o cesto
			else {
				printf("+ quantidade de %s no cesto %s menor que %hd\n", codigo, identificador, quantidade);
				return;
			}
		}
	}
	//Caso o item nao exista no cesto
	printf("+ produto %s ausente do cesto %s\n", codigo, identificador);
}

//Ve todos os items de um cesto
void Visualize_Item(ht *HashTable, int hash, char identificador[]) {
	short x = 0; //Variavel para saber se o printf de VC <identificador> já foi feito
	float total = 0.0; //preco total de todos os itens do cesto (itens * quant)
	item *list[TAMANHO_ITEM]; //lista de apontadores para os itens de um cesto

	//Percorre todos os itens do cesto
	for (int i = 0; i < TAMANHO_ITEM; i++) {
		//Se o item tiver activo, adiciona um apontador para esse item á lista
		if (HashTable->arr[hash].itens[i].active == true) {
			list[x] = &HashTable->arr[hash].itens[i];
			x++;
			//Se o x tiver a 1, entao faz print a VC <identificador> 
			//(so faz 1 vez, no primeiro item a ser adicionado)
			if (x == 1)
				printf("VC %s\n", identificador);
		}
	}
	//Se o x = 0, entao nao há nenhum item ativo
	if (x == 0)
		printf("+ cesto %s vazio\n", identificador);
	//Ordena os apontadores dos itens por ordem crescente do codigo
	else {
		bubble_sort_string(list, x);

		//percorre a lista, calcula o total e faz print dos itens por ordem
		for (int i = 0; i < x; i++) {
			float temp =list[i]->quant * list[i]->price;
			printf("%s %3hd %8.2f %8.2f\n", list[i]->code, list[i]->quant, list[i]->price, temp);
			total += temp;
		}
		//print do preco total
		printf("%.2f\n", total);
	}
}

//verifica se um cesto está vazio
bool isEmpty(ht *HashTable, int hash) {
	bool vazio = true;
	
	//percorre os itens de um cesto e verifica se esta vazio
	for (int i = 0; i < TAMANHO_ITEM; i++) {
		if (HashTable->arr[hash].itens[i].active == true) {
			vazio = false;
		}
	}
	return vazio;
}

//Malloc necessario para por a HashTable em memoria
ht *Create_HashTable() {

	ht *HashTable = malloc(sizeof(ht));

    //inicializar todos os elementos da tabela a false
	for (int i = 0; i < MAX_SIZE; i++)
		HashTable->arr[i].used = false;

	//Inicializa a idade da HashTable a 0
	HashTable->idade = 0;

	return HashTable;
}

//Free necessario para tirar a HashTable de memoria
void Free_HashTable(ht *HashTable) {
	free(HashTable);
}

//funcao de hash djb2
unsigned long HashCode(char x[]) {
	unsigned long hash = 5831;
	int c;

	while ( (c = *x++) ) {
		hash = ((hash << 5) + hash) + c;
	}

	return hash;
}

//primeira funcao de duplo hashing de EDA1
int Hash1(char x[]) {
	unsigned long hashcode = HashCode(x);
	hashcode %= MAX_SIZE;

	int hash = (int) hashcode;

	if (hash < 0)
		hash += MAX_SIZE;

	return hash;
}

//segunda funcao de duplo hashing de EDA1
int Hash2(ht *HashTable, char x[]) {
	unsigned long hashcode = HashCode(x);
	hashcode %= MAX_SIZE;

	int hash = (int) hashcode;

	if (hash < 0)
		hash += MAX_SIZE;

	return PRIME - hash % PRIME;
}

//retorna um cesto de id = key
int Get_Cesto(ht *HashTable, char key[]) {
	int hash1 = Hash1(key);
	int hash2 = Hash2(HashTable, key);

	//Procura o cesto enquanto o cesto estiver a ser usado
	while (HashTable->arr[hash1].used == true) {
		//Se o nome for igual retorna a posicao do cesto
		if (strcmp(key, HashTable->arr[hash1].ident) == 0)
			return hash1;
		//Se o nome nao e igual, faz duplo hashing
		else {
			hash1 += hash2;
			hash1 %= MAX_SIZE;
		}
	}
	//Caso chegue a um cesto que nao esta a ser usado
	//Logo o cesto nao existe no sistema
	//E retorna -1
	return -1;
}

//Insere um cesto na hashtable
bool Put_Cesto(ht *HashTable, int idade, char key[]) {
	int hash1 = Hash1(key);
	int hash2 = Hash2(HashTable, key);

	//Procura o cesto enquanto o cesto estiver a ser usado
	while(HashTable->arr[hash1].used == true) {
		//Se o nome for igual retorna false
		//(Cesto ja existe no sistema, logo nao inseriu)
		if (strcmp(key, HashTable->arr[hash1].ident) == 0){
			return false;
		}
		//Se o nome nao e igual, faz duplo hashing
		else {
			hash1 += hash2;
			hash1 %= MAX_SIZE;
		}	
	}
	
	//Caso tenha encontrado uma posicao a false
	//Insere um cesto (muda o used para true, muda a idade e o nome)
	if (HashTable->arr[hash1].used == false) {
		HashTable->arr[hash1].used = true;
		strncpy(HashTable->arr[hash1].ident, key, 8);
		HashTable->arr[hash1].age = idade;
		//percorre os itens e mete-os todos a false
		for (int i = 0; i < TAMANHO_ITEM; i++)
			HashTable->arr[hash1].itens[i].active = false;
	}
	//Inseriu o cesto e retorna true
	return true;
}

//Remove um cesto da tabela
bool Remove_Cesto(ht *HashTable, char key[]) {
	int hash1 = Hash1(key);
	int hash2 = Hash2(HashTable, key);

	//Procura o cesto enquanto o cesto estiver a ser usado
	while(HashTable->arr[hash1].used == true) {
		//Se o nome for igual
		if (strcmp(key, HashTable->arr[hash1].ident) == 0) {
			//Percorre todos os itens e mete-os a false
			for (int i = 0; i < TAMANHO_ITEM; i++)
				HashTable->arr[hash1].itens[i].active = false;
			//Muda o cesto para false e retorna true (cesto removido)
			HashTable->arr[hash1].used = false;
			return true;
		}
		//Se o nome for diferente, faz duplo hashing	
		else {
			hash1 += hash2;
			hash1 %= MAX_SIZE;
		}
	}
	//Encontrou um cesto que nao esta a ser usado (used = false)
	//Logo nao há mais cestos para a frente
	//Retorna false
	return false;
	
}

//Insere um cesto na tabela
void CC(ht *HashTable, int idade) {
	char id[TAMANHO_IDEN+1]; //Char com o nome do cesto

	//Scan para ver o nome do cesto
	scanf("%s", id);
	bool teste = Put_Cesto(HashTable, idade, id);
	//Se teste == true, entao inseriu
	if (teste)
		printf("+ cesto %s criado\n", id);
	//Caso contrario, o cesto ja existia
	else
		printf("+ cesto %s existente\n", id);
}

//Insere um item num cesto
void IC(ht *HashTable, int idade) {
	char id[TAMANHO_IDEN+1], cod[TAMANHO_ITEM+1]; //Chars com o nome do cesto e o codigo do item
	short quant; //Quantidade do item a ser inserido
	float preco; //Preco do item a ser inserido

	//Scan para ver o nome do cesto, codigo, quantidade e preco unitario do item
	scanf("%s %s %hd %f", id, cod, &quant, &preco);

	int teste = Get_Cesto(HashTable, id);
	//Se for <0 quer dizer que o cesto nao existe
	if (teste < 0)
		printf("+ cesto %s inexistente\n", id);
	//Caso contrario o cesto foi encontrado e é inserido um item na posicao teste
	else {
		Insert_Item(HashTable, teste, cod, quant, preco);
		HashTable->arr[teste].age = idade; //Idade atualizada
		printf("+ %hd unidade(s) de %s introduzida(s) no cesto %s\n", quant, cod, id);
	}
}

 //Remove um item de um cesto
void RC(ht *HashTable, int idade) {
	char id[TAMANHO_IDEN+1], cod[TAMANHO_ITEM+1]; //Chars com o nome do cesto e o codigo do item
	short quant; //Quantidade a ser removida do item

	//Scan para ver o nome do cesto, codigo e quantidade do item
	scanf("%s %s %hd", id, cod, &quant);

	int teste = Get_Cesto(HashTable, id);
	//Se for <0 quer dizer que o cesto nao existe
	if (teste < 0)
		printf("+ cesto %s inexistente\n", id);
	//Caso contrario o cesto foi encontrado e é removido (ou nao) o item
	else {
		Remove_Item(HashTable, teste, id, cod, quant); 
		HashTable->arr[teste].age = idade; //Idade atualizada
	}
}

//Ve todos os itens num cesto
void VC(ht *HashTable, int idade) {
	char id[TAMANHO_IDEN+1]; //Char com o nome do cesto

	//Scan para ver o nome do cesto
	scanf("%s", id);

	int teste = Get_Cesto(HashTable, id);
	//Se for <0 quer dizer que o cesto nao existe
	if (teste < 0)
		printf("+ cesto %s inexistente\n", id);
	//Caso contrario o cesto foi encontrado e é feito um print de todos os itens (caso existam)
	else {
		Visualize_Item(HashTable, teste, id);
		HashTable->arr[teste].age = idade; //Idade atualizada
	}
}

//Efectua a venda de um cesto (caso nao esteja vazio)
void EC(ht *HashTable, int idade) {
	char id[TAMANHO_IDEN+1]; //char com o nome do cesto

	//Scan para ver o nome do cesto
	scanf("%s", id);

	int teste = Get_Cesto(HashTable, id);
	//Se for <0 quer dizer que o cesto nao existe
	if (teste < 0 )
		printf("+ cesto %s inexistente\n", id);
	//Caso contrario
	else {
		//Se o cesto nao estiver vazio, efectua-se a venda do cesto
		if (isEmpty(HashTable, teste) == false) {
			Remove_Cesto(HashTable, id);
			printf("+ efectuada venda do cesto %s\n", id);	
		}
		//Se o cesto estiver vazio, atualiza-se a idade e nao se efectua a venda 
		else {
			printf("+ cesto %s vazio\n", id);
			HashTable->arr[teste].age = idade;
		}
	}
}

//cancela um cesto (caso exista)
void XC(ht *HashTable) {
	char id[TAMANHO_IDEN+1]; //Char com o nome do cesto

	//Scan para ver o nome do cesto
	scanf("%s", id);

	int teste = Get_Cesto(HashTable, id);
	//Se for <0 quer dizer que o cesto nao existe
	if (teste < 0)
		printf("+ cesto %s inexistente\n", id);
	//Caso contrario o cesto é removido do sistema
	else {
		Remove_Cesto(HashTable, id);
		printf("+ cesto %s cancelado\n", id);
	}
}

 //remove todos os cestos cuja idade é maior que a idade passada como argumento
void LC(ht *HashTable, int idade) {
	int age; //Idade minima para ser removida 
	int index = 0; //Tamanho da lista a ser ordenada
	bool lc = true; //Variavel para saber se o printf de LC <idade> ja foi realizado
	cesto *list[idade]; //Lista de apontadores para cestos a ser ordenada
	//A lista tem tamanho idade, porque o maior numero de cestos que se pode ter posto naquele momento
	//na hashtable seria igual á idade atual

	//Scan da idade minima para a remocao
	scanf("%d", &age);

	//Calculo do tempo ate que um cesto e removido
	int tempo = idade - age;
	//Percorre todos os cestos da hashtable
	for (int i = 0; i < MAX_SIZE; i++) {
		//Se estiver ativo e a idade de insercao for menor que o tempo (calculado anteriormente)
		//adiciona-se um apontador para o mesmo á lista e remove-se o cesto da hashtable
		//(Os valores de idade continuam acessiveis, visto que nao sao realmente removidos
		//apenas se muda o used para false)
		if (HashTable->arr[i].used == true && HashTable->arr[i].age < tempo) {
			//Se for o primeiro cesto, faz print a LC <idade> (so sera feito uma vez)
			if (lc) {
				printf("LC %d\n", age);
				lc = false;
			}
			list[index] = &HashTable->arr[i];
			index++;
			Remove_Cesto(HashTable, HashTable->arr[i].ident);
		}
	}
	//Se o lc for true (nao foi encontrado nenhum cesto com idade superior) faz print
	if (lc)
		printf("+ sem cestos com idade superior a %d\n", age);
	//Caso contrario, ordenam-se os cestos por idade decrescente
	else {
		merge_sort(list, index);
		//percorre a lista (agora ordenada) e faz print da mesma
		for (int i = 0; i < index; i++) {
			printf("%s\n", list[i]->ident);
		}
	}

}

//Sabendo-se as letras das operacoes (passadas por char in[]) chama-se a funcao adequada
short Cestos_Virtuais(ht *HashTable, char in[], int idade) {
	//switch simples para saber qual é o input certo
	//Faz return 1 se a operacao nao é a ultima do input
	//Caso contrario faz return -1 (se no in[] está um XX ou se chegou ao fim de ficheiro)
	switch (in[0]) {
		case 'C' :
			CC(HashTable, idade);
			return 1;
		case 'I' :
			IC(HashTable, idade);
			return 1;
		case 'R' :
			RC(HashTable, idade);
			return 1;
		case 'V' :
			VC(HashTable, idade);
			return 1;
		case 'E' :
			EC(HashTable, idade);
			return 1;
		case 'X' :
			if (in[1] == 'C') {
				XC(HashTable);
				return 1;
			} else {
				return -1;
			}
		case 'L' :
			LC(HashTable, idade);
			return 1;
		default :
			return -1;
	}
 }

int main() {
	ht *HashTable = Create_HashTable();

	FILE *file = fopen("ficheiro_tabela", "r"); //abrir ficheiro em modo read
    if (file != NULL) {
        fread(HashTable, sizeof(ht), 1, file);
        fclose(file); //fechar ficheiro enquanto nao é usado
    }

    char in[2]; //Char para input das operacoes

	int idade = HashTable->idade;
	int teste = 0;

    //Verificacao de fim de ficheiro
	while(scanf("%s", in) == 1 && teste != -1) {
		teste = Cestos_Virtuais(HashTable, in, idade);
		idade++;
	}

	HashTable->idade = idade; //actualiza a idade da HashTable

    file = fopen("ficheiro_tabela", "w"); //abrir ficheiro em modo write
	if (file != NULL) {
    	fwrite(HashTable, sizeof(ht), 1, file);
    	fclose(file); //fechar ficheiro já não é usado
	}

	Free_HashTable(HashTable);
	return 0;
}