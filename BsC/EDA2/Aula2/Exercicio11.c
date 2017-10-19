#include <stdio.h>

int fibonacciR(int n) { //
	if (n==0)
		return 0;
	else if (n==1)
		return 1;
	else
		return (fibonacciR(n-1) + fibonacciR(n-2));
}

int arraySize(int array[]) {
	int i=0;

	while (array[i] != 0)
		i++;

	return i;
}

int main() {
	int sequence[] = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144};
	int in;

	scanf("%d", &in);
	if (arraySize(sequence) > in+1)
		printf("%d\n", sequence[in]);
	else
		printf("%d\n", fibonacciR(in+1));

	return 0;
}
