// Code by Phil Fevry [10-16-2015]

#include <iostream>

using namespace std;

int area(int, int);
int perimeter(int, int);

int main() {
    int length, width;
    int objectArea, objectPerimeter;
    
    cout << "Enter length as an integer";
    cout << endl;
    
    cout << "Length: ";
    cin >> length;
    
    if (length < 0 || !cin) {
        cout << "You entered in an invalid value.";
        cout << endl;
        return 0;
    } 
    
    cout << "Enter width as an integer ";
    cout << endl;
    
    cout << "Width: ";
    cin >> width;
    
    if (width < 0 || !cin) {
        cout << "You entered in an invalid value.";
        cout << endl;
        return 0;
    }
    
    objectArea = area(length, width);
    objectPerimeter = perimeter(length, width);

    cout << "[Area]: The area of the object is "
         << objectArea << " units.";
    cout << endl;
    cout << "[Perimeter]: The perimeter of the object is "
         << objectPerimeter << " units.";
    cout << endl;
    
    return 0;
}

int area(int length, int width) {
    return length * width;
}

int perimeter(int length, int width) {
    return (length * 2) + (width * 2);
}

