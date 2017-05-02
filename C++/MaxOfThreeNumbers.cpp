// Code by Phil Fevry [10-19-2015]

#include <iostream>

using namespace std;

int greaterNum(int, int);
int lesserNum(int, int);

int main() {
    int a, b, c;
    int largestNumber, middleNumber, smallestNumber;
    int temp1, temp2;
    
    cout << "Enter three integers: ";
    cin >> a >> b >> c;
    
    temp1 = greaterNum(a, b);
    largestNumber = greaterNum(c, temp1);
    
    temp2 = lesserNum(a, lesserNum(a,b));
    smallestNumber = lesserNum(c, temp2);
    
    if (a != largestNumber && a != smallestNumber)
        middleNumber = a;
      else if (b != largestNumber && b != smallestNumber)
        middleNumber = b;
     else middleNumber = c;
    
    cout << "The largest number is: "
         << largestNumber << endl;
    cout << "The number in the middle is: "
         << middleNumber << endl;
    cout << "The samllest number is: "
         << smallestNumber << endl;

    return 0;
}

int greaterNum(int num1, int num2) {
    if (num1 > num2)
        return num1;
    else
        return num2;
}

int lesserNum(int num1, int num2) {
    if (num1 < num2)
        return num1;
    else
        return num2;
}
