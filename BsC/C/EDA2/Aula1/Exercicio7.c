#include <stdio.h>

void fibonacciI(int n) {
	int first=0, second=1, next, c;
	for (c=0; c<n; c++) {
		if (c<=1) {
			next = c;
		}else {
			next = first + second;
			first = second;
			second = next;
		}
		printf("%d ", next);
	}
}

/*
int fibonacciR(int n) {
	if (n==0) {
		return 0;
	}else if (n==1) {
		return 1;
	}else {
		return (fibonacciR(n-1) + fibonacciR(n-2));
	}

}*/
/*
int main() {
	int n, i=0, c;

	scanf("%d", &n);

	printf("Primeiros %d termos da serie de Fibonacci s�o (Iterativa):\n", n);
	fibonacciI(n);

	printf("\n\n");

	printf("Primeiros %d termos da serie de Fibonacci s�o (Recursiva):\n", n);
	for (c=1; c<=n; c++) {
		printf("%d ", fibonacciR(i));
		i++;
	}

	return 0;
}
*/