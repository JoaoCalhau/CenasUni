#include <stdio.h>
#include <string.h>

int main() {
	/*
	char array[10];

	int i;
	for(i = 0; i < 10; i++)
		array[i] = '0';

	for(i = 0; i < 10; i++)
		printf("%d\n", array[i]);
	*/

	//SCANS OP CARALHO!
	char teste[2];
	short testinho;
	printf("%d\n", strlen(teste));
	scanf("%s", teste);
	printf("%s\n", teste);
	printf("%d\n", strlen(teste));
	scanf("%s", teste);
	printf("%s\n", teste);
	printf("%d\n", strlen(teste));
	scanf("%s", teste);
	printf("%s\n", teste);
	printf("%d\n", strlen(teste));
	scanf("%hd", &testinho);
	printf("%hd\n", testinho);
	//printf("%d\n", strlen(teste));

	return 0;
}