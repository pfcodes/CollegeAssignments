// Code by Phil Fevry [9-29-2015]

#include <iostream>
#include <array>

using namespace std;

void dumpValues(int[], int[], int[]);
int gatherKnownValuesFromUser(int[], int[], int[]);
int solveEquation(int, int[], int[], int[]);

enum {
    SALESREVENUE,
    OPERATINGINCOME,
    UNITSSOLD,
    VARIABLECOSTS = 0,
    FIXEDCOSTS = 1,
    CONTRIBUTIONMARGIN = 0,
    CONTRIBUTIONMARGINPERUNIT = 1,
    CONTRIBUTIONMARGINRATIO = 2
};

int main() {
    // Intialize variables
    const int variableCount = 8;
    
    int salesRevenue, operatingIncome, unitsSold, variableCosts, fixedCosts;
    int contributionMargin, contributionMarginPerUnit;
    float contributionMarginRatio;
    
    int *profitVariables[3], *costVariables[2], *marginVariables[3];
    
    profitVariables[SALESREVENUE] = &salesRevenue;
    profitVariables[OPERATINGINCOME] = &operatingIncome;
    profitVariables[UNITSSOLD] = &unitsSold;
    
    costVariables[VARIABLECOSTS] = &variableCosts;
    costVariables[FIXEDCOSTS] = &fixedCosts;
    
    marginVariables[CONTRIBUTIONMARGIN] = &contributionMargin;
    marginVariables[CONTRIBUTIONMARGINPERUNIT] = &contributionMarginPerUnit;
    marginVariables[CONTRIBUTIONMARGINRATIO] = (int*)&contributionMarginRatio;
    
    // Get known values
    gatherKnownValuesFromUser(*profitVariables, *costVariables, *marginVariables);
    
    // Debug, dump values
    dumpValues(*profitVariables, *costVariables, *marginVariables);
    
    // Solve the equation
    solveEquation(variableCount, *profitVariables, *costVariables, *marginVariables);
    
    
    return 0;
}

int gatherKnownValuesFromUser(int profitVariable[], int costVariable[], int marginVariable[]) {
    cout << "Please enter in the variables" << endl;
    
    cout << "[Sales Revenue]: ";
    cin >> profitVariable[SALESREVENUE];
    
    cout << "[Operating Income]: ";
    cin >> profitVariable[OPERATINGINCOME];
    
    cout << "[Units Sold]: ";
    cin >> profitVariable[UNITSSOLD];
    
    cout << "[Variable Costs]: ";
    cin >> costVariable[VARIABLECOSTS];
    
    cout << "[Fixed Costs]: ";
    cin >> costVariable[FIXEDCOSTS];
    
    cout << "[Contribution Margin]: ";
    cin >> marginVariable[CONTRIBUTIONMARGIN];
    
    cout << "[Contribution Margin per Unit]: ";
    cin >> marginVariable[CONTRIBUTIONMARGINPERUNIT];
    
    cout << "[Contribution Margin Ratio]: ";
    cin >> marginVariable[CONTRIBUTIONMARGINRATIO];
    
    return 0;
}

void dumpValues(int profitVariable[], int costVariable[], int marginVariable[]){  
    cout << "Values of variables: " << endl;

    cout << "Sales Revenue: ";
    cout << profitVariable[SALESREVENUE] << endl;
    
    cout << "Operating Income: ";
    cout << profitVariable[OPERATINGINCOME] << endl;
    
    cout << "Units Sold: ";
    cout << profitVariable[UNITSSOLD] << endl;
    
    cout << "Variable Costs: ";
    cout << costVariable[VARIABLECOSTS] << endl;
    
    cout << "Fixed Costs: ";
    cout << costVariable[FIXEDCOSTS] << endl;
    
    cout << "Contribution Margin: ";
    cout << marginVariable[CONTRIBUTIONMARGIN] << endl;
    
    cout << "Contribution Margin per Unit: ";
    cout << marginVariable[CONTRIBUTIONMARGINPERUNIT] << endl;
    
    cout << "Contribution Margin Ratio: ";
    cout << marginVariable[CONTRIBUTIONMARGINRATIO] << endl;
}

int solveEquation(int variableCount, int profitVariable[], int costVariable[], int marginVariable[]) {
    for (int i = 0; i < variableCount; ++i) {
        cout << i << endl;
    }
    
    cout << sizeof(*profitVariable);
    cout << sizeof(*costVariable);
    cout << sizeof(*marginVariable);
    
    return 0;
}
