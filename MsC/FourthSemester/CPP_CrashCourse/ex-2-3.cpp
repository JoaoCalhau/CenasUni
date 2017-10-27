#include <iostream>
#include <iomanip>
#include <string>
#include <Boost>

using namespace std;

int main() {
	
	//size N (user defined)
	int n;
	cout << "Size of n? ";
	cin >> n;
	cout << endl;

	int m = n*n;

	string max = lexical_cast<string>(m);

	//array
	int **array = new int *[n];

	//initialize each dimension
	for(int i = 0; i < n; i++) {
		array[i] = new int[n];	
	}

	//fill the array
	for(int i = 0; i < n; i++) {
		for(int j = 0; j < n; j++) {
			array[i][j] = i*n+j;
		}
	}

	//print the contents of the array
	for(int i = 0; i < n; i++) {
		cout << "[";
		for(int j = 0; j < n; j++) {
			if(j == n-1) {
				cout << setw(len) << array[i][j];
			} else {
				cout << setw(len) << array[i][j] << ",";
			}
		}
		cout << "]" << endl;
	}

	//deleting "inner" arrays
	for(int i = 0; i < n; i++) {
		delete [] array[i];
	}

	//deleting what's left
	delete [] array;


	return 0;
}