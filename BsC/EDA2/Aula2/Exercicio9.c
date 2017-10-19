#include <stdio.h>

#define MAX_SIZE 50000

int pesquisaL(int vector[], int number, int size) {
	int n = number, i;

	for (i=0; i<size; i++) {
		if (vector[i] == n)
			break;
	}

	if (i == size)
		return -1;
	else
		return i;
}

int pesquisaB(int vector[], int number, int size) {
	int n=number, min=0, max=size-1, p=0;
	int m = (min+max)/2;

	while (min < max) {
		if (n < vector[m])
			max = m-1;
		else if (n > vector[m])
			min = m+1;
		else {
			min = max;
			p=m;
		}
		m = (min+max)/2;
		p=m;
	}
	if (min == max)
		return p;
	else
		return -1;
}

int pesquisaBR(int vector[], int number, int min, int max) {
	int n=number;
	int m = (min+max)/2;

	if (max < min)
		return -1;
	if (n == vector[m])
		return m;
	else if (n < vector[m])
		return pesquisaBR(vector, n, min, m-1);
	else
		return pesquisaBR(vector, n, m+1, max);
}

int pesquisaR(int vector[], int number, int size) {
	return pesquisaBR(vector, number, 0, size-1);
}
/*
int main() {
	int v[MAX_SIZE], i, pL, pB, pR, a, b, c;

	for (i=0; i<MAX_SIZE; i++)
		v[i]=i+1;

	printf("Insira 3 valores para procurar: \n");
	printf("\n");
	scanf("%d", &a);
	scanf("%d", &b);
	scanf("%d", &c);

	pL=pesquisaL(v, a, MAX_SIZE);
	pB=pesquisaB(v, b, MAX_SIZE);
	pR=pesquisaR(v, c, MAX_SIZE);

	printf("\n");
	printf("--Pesquisa Linear--\n");
	if (pL == -1)
		printf("Elemento não encontrado\n");
	else
		printf("Elemento encotrado na posição: %d\n", pL);

	printf("\n");
	printf("--Pesquisa Binária--\n");
	if (pB == -1)
		printf("Elemento não encontrado\n");
	else
		printf("Elemento encontrado na posição: %d\n", pB);

	printf("\n");
	printf("--Pesquisa Recursiva--\n");
	if (pR == -1)
		printf("Elemento não encontrado\n");
	else
		printf("Elemento encontrado na posição: %d\n", pR);

	return 0;
}
*/