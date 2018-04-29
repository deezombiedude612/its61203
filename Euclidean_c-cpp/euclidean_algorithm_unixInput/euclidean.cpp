#include <iostream>
#include <sstream>
#include <string>
using namespace std;

void euclidean(int num1, int num2) {
	int a = num1, b = num2, temp;
	cout << endl << a << " = " << (a / b) << "(" << b << ") + " << (a % b) << endl;

	while(a % b != 0) {
        temp = a % b;
        a = b;
        b = temp;
        cout << a << " = " << (a / b) << "(" << b << ") + " << (a % b) << endl;
    }

    cout << "\ngcd(" << num1 << ", " << num2 << ") = " << b;
    cout << "\nlcm(" << num1 << ", " << num2 << ") = " << (num1 * num2) / b;
    cout << "\n\n";
}

int main(int argc, char **argv) {
	cout << "\n*** C++ EUCLIDEAN ALGORITHM CALCULATOR ***\n";
	if(argc != 3) {
		cout << "Usage: " << argv[0] << " num1 num2\n";
		return -1;
	}
	
	int num1, num2;
	stringstream ss1(argv[1]);
	if(!(ss1 >> num1)) {
		cerr << "\nInvalid number " << argv[1] << endl << endl;
		return 1;
	}
	stringstream ss2(argv[2]);
	if(!(ss2 >> num2)) {
		cerr << "\nInvalid number " << argv[2] << endl << endl;
		return 1;
	}

	if(num1 >= num2)
		euclidean(num1, num2);
	else
		euclidean(num2, num1);

	return 0;
}