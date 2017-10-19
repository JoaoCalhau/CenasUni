#include <stdio.h>
#include <stdbool.h>
#include <math.h>

_Bool isPrime(int n) { //retirado do trabalho que fiz para PI (Java)
	int i;

	if (n == 2)
		return true;
	if (n%2 == 0 || n == 1)
		return false;
	long sqrtPrime = (long) sqrtl(n);
	for (i=3; i<sqrtPrime; i+=2) {
		if (n%i == 0)
			return false;
	}
	return true;
}
/*
int main() {
	int i;

	printf("Primos entre 555 e 777:\n");
	for (i=555; i<=777; i++) {
		if (isPrime(i)) {
			printf("%d ", i);
		}
	}

	return 0;
}
*/
