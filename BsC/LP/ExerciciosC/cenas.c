#include <stdio.h>
#include <stdlib.h>

#define Row 10000
#define Column 10000

int *toAllocateInt() {
	int *arr = (int *)malloc(Row * Column * sizeof(int));

	return arr;
}


void toFree(int *arr) {
	free(arr);
}

int offset(int i, int j) {
	return (i * Row + j);
}

void porColuna(int *arr, int *arr2) {
	int i, j;

	for(j = 0; j < Column; j++) {
		for (i = 0; i < Row; i++) {
			arr2[offset(i ,j)] = arr[offset(i, j)];
		}
	}
}

void porLinha(int *arr, int *arr2) {
	int i, j;

	for(i = 0; i < Row; i++) {
		for (j = 0; j < Column; j++) {
			arr2[offset(i, j)] = arr[offset(i, j)];
		}
	}
}

void porRandom(int *arr, int *arr2) {
	

}


int main() {
	
	int *arr = toAllocate();
	int *arr2 = toAllocate();

	porLinha(arr, arr2);
	//porColuna(arr, arr2);

	toFree(arr);
	toFree(arr2);

	return 0;
}