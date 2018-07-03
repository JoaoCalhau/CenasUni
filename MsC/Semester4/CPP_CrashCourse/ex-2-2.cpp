#include <iostream>

int main() {

	//pointer to char
	char *cp = new char;

	//constant pointer to a char
	char *const cpc = cp;

	//pointer to a constant char
	const char *ccp = cp;

	//constant pointer to a constant char
	const char *const cpcc = cp;

	//reference to a char
	char &rc = *cp;

	//reference to a constant char
	const char &rcc = *cp;

	std::cout << "DONE!\n";

	return 0;
}