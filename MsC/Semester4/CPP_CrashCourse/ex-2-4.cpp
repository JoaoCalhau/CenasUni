#include <iostream>

using namespace std;

void swap_int(int &a, int &b) {
	int c = a;
	a = b;
	b = c;
}

void swap_ptr(int *pa, int *pb) {
	int c = *pa;
	*pa = *pb;
	*pb = c;
}

int main() {

	int a = 10;
	int b = 20;

	int *pa = &a;
	int *pb = &b;

	cout << "Original" << endl;
	cout << "a = " << a << ", b = " << b << endl << endl;

	swap_int(a, b);

	cout << "Swaped Ints" << endl;
	cout << "a = " << a << ", b = " << b << endl << endl;

	swap_ptr(pa, pb);

	cout << "Swaped Pointers" << endl;
	cout << "*pa = " << *pa << ", *pb = " << *pb << endl << endl; 

	return 0;
}