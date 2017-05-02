// Code by Phil Fevry [11-08-2015]

#include <iostream>

using namespace std;

void if_grade(int);
void switch_grade(int);

int main() {
    int inputGrade;
    
    cout << "Input a number [1-10] to get the letter grade: " << endl;
    
    cin >> inputGrade;
    if_grade(inputGrade);

    return 0;
}

void if_grade(int n) {
    char grade;
    
    if (n >= 9 && n <= 10)
        grade = 'A';
    else if (n == 8)
        grade = 'B';
    else if (n == 7)
        grade = 'C';
    else if (n == 6)
        grade = 'D';
    else if (n >= 0 && n <= 5)
        grade = 'F';
    else
        grade = (char)NULL;
    
    if (grade) {
        cout << "Grade (using if): " << grade << endl;
        // call with switch statement
        switch_grade(n);
    } else {
        cout << "Please enter a number from 0-10" << endl;
    } 
}

void switch_grade(int n) {
    char grade;
    
    switch (n) {
        case 10:
        case 9: grade = 'A';
            break;
        case 8: grade = 'B';
            break;
        case 7: grade = 'C';
            break;
        case 6: grade = 'D';
            break;
        case 5:
        case 4:
        case 3:
        case 2:
        case 1:
        case 0: grade = 'F';
            break;
        default: grade = (char)NULL;
    }
    
    if (grade) {
        cout << "Grade (using switch): " << grade << endl;
    }
}
