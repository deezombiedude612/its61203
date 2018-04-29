#include <iostream>
#include <string>
using namespace std;

void euclideanAlgorithm(int num1, int num2) {
    int a = num1, b = num2;
    int temp;

    cout << a << " = " << (a / b) << "(" << b << ") + " << (a % b) << endl;
    while(a % b != 0) {
        temp = a % b;
        a = b;
        b = temp;
        cout << a << " = " << (a / b) << "(" << b << ") + " << (a % b) << endl;
    }

    cout << "\ngcd(" << num1 << ", " << num2 << ") = " << b;
    cout << "\nlcm(" << num1 << ", " << num2 << ") = " << (num1 * num2) / b;
}

void process() {
    /* initialize numbers */
    int num1 = NULL;
    int num2 = NULL;

    cout << endl;
    while (num1 == NULL) {
        cout << "Enter first number >> ";
        cin >> num1;

        if (cin.fail()) {
            cout << "Invalid number detected.\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }
    }
    while (num2 == NULL) {
        cout << "Enter second number >> ";
        cin >> num2;

        if (cin.fail()) {
            cout << "Invalid number detected.\n";
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
        }
    }

    cout << "\nPROCESS:\n";
    if(num1 >= num2)
        euclideanAlgorithm(num1, num2);
    else
        euclideanAlgorithm(num2, num1);
}

int main() {
    cout << "\n*** C++ EUCLIDEAN ALGORITHM CALCULATOR (IDE-FRIENDLY) ***\n";
    string response = "";

    while(true) {
        process();

        cin.get();
        cout << endl << endl;
        do {
            cout << "Would you like to continue? (Y/N) >> ";
            getline(cin, response);

            if ((response != "Y" && response != "y") && (response != "N" && response != "n")) {
                response.clear();
                cout << "Invalid response detected.\n\n";
            }
        } while ((response != "Y" && response != "y") && (response != "N" && response != "n"));
        if(response == "N" || response == "n")
            break;
    }

    cout << "Goodbye\n";

    return 0;
}