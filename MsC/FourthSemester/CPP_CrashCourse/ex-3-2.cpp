#include <iostream>

using namespace std;

class Foo {
private:
	int _value;

public:
	Foo(int value = 0) : _value(value) {
		cout << "Foo default constructor called" << endl;
	}

	Foo(const Foo &other) {
		cout << "Foo copy constructor called" << endl;
	}

	Foo & operator= (const Foo &other) {
		cout << "Foo operator = called" << endl;

		if(this == &other)
			return *this;

		_value = other._value;
		return *this;
	}

	~Foo(void) {
		cout << "Foo destructor called" << endl;
	}
};

int main() {
	Foo foo_1(2);
	Foo foo_2(foo_1);
	Foo foo_3;
	foo_3 = foo_1;

	return 0;
}