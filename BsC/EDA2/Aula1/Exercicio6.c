#include <stdio.h>

int main() {
	int i, j;

	for (i = 1; i<=10; i++) {
		for (j = 1; j<=i; j++) {
			printf("%3d", i*j);
			if (i==j) {
				printf("\n");
			}
		}
	}

	return 0;
}

