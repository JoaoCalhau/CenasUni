#include <stdio.h>

void programa(int processos) {
	int i, t[processos], c[processos], total=0;

	for (i = 0; i < processos; i++) {
		printf("Insere cenas\n");
		scanf("%d %d",&t[i], &c[i]);
		total+=c[i];
	}

	int lista[total], e, h;

	while(e < total) {
		for (h = 0; h < processos; h++) {
			if (t[h] <= j) {
				if (c[h] > 0) {
					lista[e] = h+1;
					c[h] = c[h]-1;
					e++;
				}
			}
		}
	}

	for (j =0; j < total; j++) {
		printf("%d %d\n", j, lista[j]);
	}

	return;
}

int main() {
	int i=3;

	programa(i);

	return 0;
}