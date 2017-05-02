// Code by Phil Fevry [12-20-2015]

#include <iostream>

using namespace std;
void print_integers(float[], int);
int round(float);

int main() {
    int ARRAY_SIZE = 5;
    float array[5] = {0.6, 4.2, 9.5, 1.4, 6.6};
    
    print_integers(array, ARRAY_SIZE);
    
    return 0;
}

void print_integers(float a[], int size) {
    for (int i = 0; i < size; i++) {
        cout << a[i] << " | " << round(a[i]) << endl;
    }
}

int round(float x) {
    int result;
    
    result = x-1;
    
    return result;
}
