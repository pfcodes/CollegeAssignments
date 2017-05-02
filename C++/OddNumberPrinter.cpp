// Code by Phil Fevry [12-4-2015]

#include <iostream>

using namespace std;

bool isOdd(int);
void printSum();
int sum = 0;

int main() {
    int inputNumber;
    
    cout << "> This program will add positive odd numbers to a sum." << endl
         << "> Enter a negative number or zero to terminate the program." << endl << endl;;

    do {
        cout << "Enter a number: ";
        cin >> inputNumber;
        
        if (inputNumber > 0)
        {
            if (isOdd(inputNumber))
            {
                sum = sum + inputNumber;
                printSum();
            } else {
                printSum();
                continue;
            }
        } else {
            cout << "Bye!" << endl;
            break;
        }
    } while (cin);
    
    return 0;
}

bool isOdd(int n) {
    if (n % 2)
        return true;
    else
        return false;
}

void printSum() {
    cout << "sum = " << sum << endl;
}
