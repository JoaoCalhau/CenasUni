#include <stdio.h>

unsigned long factorialR(int n) { //Unsigned long por causa de erro de overflow (numeros negativos quando nao ha factoriais negativos)
	if (n==0) {
		return 1;
	}else {
		return n*factorialR(n-1);
	}
}

unsigned long factorialI(int n) { //O mesmo para este
	int f = 1, i;

	for (i = 1; i<=n; i++) {
		f *= i;
	}

	return f;
}

int main() {
	int i=10;
	int j=20;

	printf("Recursiva: \n");
	printf("10! -> %lu\n", factorialR(i));
	printf("20! -> %lu\n", factorialR(j));
	printf("\n");
	printf("Iterativa: \n");
	printf("10! -> %lu\n", factorialI(i));
	printf("20! -> %lu\n", factorialI(j));

	return 0;
}

