#include <stdio.h>
#include <stdbool.h>

#include "LinkedLists.h"

int main() {
	struct linkedList *l;
	l = list_new();
	int i;

	if (list_empty(l))
		printf("A lista esta vazia\n");
	else
		printf("A lista não esta vazia\n");

	for (i=0; i<=10;i++) {
		list_insert(l, i);
	}

	list_print(l);

	i = 3;
	list_remove(l, i);

	list_print(l);

	return 0;
}