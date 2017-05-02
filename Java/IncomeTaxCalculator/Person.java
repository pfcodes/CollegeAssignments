import java.util.Scanner;
import java.text.NumberFormat;

/**
 * A personal federal income tax calculator.
 * 
 * @author Phil Fevry
 * @version 1.0
 */

public class Person
{ 
    // instance variables
    private static String firstName, lastName;
    private static TaxStatus taxFilingStatus;
    private static char maritalStatus;
    private static double taxableIncome;
    private static double federalTaxOwed;
    
    // for human reading
    private String formatted_taxFilingStatus [] = {"Single", "Married Filing Jointly", "Head of Household",
                                                   "Married Filing Separately"};
           
    /**
     * Empty constructor for objects of class Person
     */
    public Person()
    {
            // Get information if none is given?
            // getFederalTaxOwed();
    }
    /**
     * Constructor for objects of class Person with given information
     */
    public Person(String firstName, String lastName, char maritalStatus, int taxFilingStatus, 
                  double taxableIncome)
    {
        // initialise instance variables
        this.firstName = firstName;
        this.lastName = lastName;
        this.maritalStatus = maritalStatus;
        this.taxableIncome = taxableIncome;
        
        // Set tax filing status
        switch (taxFilingStatus)
        {
          case 2:   
                    this.taxFilingStatus = TaxStatus.MARRIED_FILING_JOINT;
          break;
          case 3:   
                    this.taxFilingStatus = TaxStatus.HEAD_OF_HOUSEHOLD;
          break;
          case 4:   
                    this.taxFilingStatus = TaxStatus.MARRIED_FILING_SEPARATE;
          default:  
                    this.taxFilingStatus = TaxStatus.SINGLE;
        }
        
        federalTaxOwed = computeFederalTax();
    }
    /**
     * Prompts user to input Person information then calculates the tax owed based on values given
     * 
     */
    public static void getFederalTaxOwed()
    {
        // Create scanner instance to capture user inputs
        Scanner in = new Scanner(System.in);
        
        // Get first and last name
        System.out.print("Please enter your first name: ");
        firstName = in.next();
        System.out.print("Please enter your last name: ");
        lastName = in.next();
        
        // Get marital status
        System.out.print("Please enter your marital status: S for Single, M for married: ");
        switch (in.next())
        {
            case "M": maritalStatus = 'M'; 
            break;
            default: maritalStatus = 'S';
        }
        
        // Get taxable income
        System.out.print("Please enter your taxable income: ");
        taxableIncome = in.nextInt();

        // Take more inputs and format relevant variables for human reading
        if (maritalStatus == 'M')
        {
            System.out.println("\tEnter 2 for Married Filing Jointly");
            System.out.println("\tEnter 3 for Head of Household");
            System.out.print("\tEnter 4 for Married Filing Separately");
            System.out.print("\nPlease enter your tax status: ");
            
            switch (in.nextInt())
            {
                case 2: taxFilingStatus = TaxStatus.MARRIED_FILING_JOINT; break;
                case 3: taxFilingStatus = TaxStatus.HEAD_OF_HOUSEHOLD; break;
                case 4: taxFilingStatus = TaxStatus.MARRIED_FILING_SEPARATE; break;
            }
        } else {
            taxFilingStatus = TaxStatus.SINGLE;
        }
        
        // Perform calculations for requested tax filing status
        federalTaxOwed = computeFederalTax();     
    }
    /**
     * Recomputes federal tax owed; to be used after changing instance variables
     * 
     */
    public static void refresh()
    {
        // Refresh federal tax owed after mutating 
        if (taxFilingStatus != null && taxableIncome >=0)
            federalTaxOwed = computeFederalTax();
    }
    
    /**
     * Returns federal tax owed by the person based on taxable income and filing status
     * 
     * @return     federal tax owed
     */
    public static double computeFederalTax()
    {
        // Declare and initialize variables
        int [] taxBracketUpperLimit = new int [6];
        double [] taxBracketBases = new double [7];
        
        // Tax bracket rates (in percentages)
        double taxBracketRates [] = {0.10, 0.15, 0.25,0.28,0.33,0.35,0.396};

        // Set bracket upper limits and bases according to tax status
        switch (taxFilingStatus)
        {
            case SINGLE:
                        taxBracketUpperLimit[0] = 9275;
                        taxBracketUpperLimit[1] = 37650;
                        taxBracketUpperLimit[2] = 91150;
                        taxBracketUpperLimit[3] = 190150;
                        taxBracketUpperLimit[4] = 413350;
                        taxBracketUpperLimit[5] = 415050;
                        
                        taxBracketBases[0] = 928;
                        taxBracketBases[1] = 5184; 
                        taxBracketBases[2] = 18558;
                        taxBracketBases[3] = 46279;
                        taxBracketBases[4] = 119935;
                        taxBracketBases[5] = 120530;
            break;
            case HEAD_OF_HOUSEHOLD:
                        taxBracketUpperLimit[0] = 13250;
                        taxBracketUpperLimit[1] = 50400;
                        taxBracketUpperLimit[2] = 130150;
                        taxBracketUpperLimit[3] = 210800;
                        taxBracketUpperLimit[4] = 413350;
                        taxBracketUpperLimit[5] = 441000;
                        
                        taxBracketBases[0] = 1325;
                        taxBracketBases[1] = 6898; 
                        taxBracketBases[2] = 26835;
                        taxBracketBases[3] = 49417;
                        taxBracketBases[4] = 116259;
                        taxBracketBases[5] = 125936;
            break;
             case MARRIED_FILING_JOINT:
                        taxBracketUpperLimit[0] = 18550;
                        taxBracketUpperLimit[1] = 75300;
                        taxBracketUpperLimit[2] = 151900;
                        taxBracketUpperLimit[3] = 231450;
                        taxBracketUpperLimit[4] = 413350;
                        taxBracketUpperLimit[5] = 466950;
                        
                        taxBracketBases[0] = 1855;
                        taxBracketBases[1] = 10368; 
                        taxBracketBases[2] = 29518;
                        taxBracketBases[3] = 51792;
                        taxBracketBases[4] = 111819;
                        taxBracketBases[5] = 130579;
            break;
            case MARRIED_FILING_SEPARATE:
                        taxBracketUpperLimit[0] = 9275;
                        taxBracketUpperLimit[1] = 37650;
                        taxBracketUpperLimit[2] = 75950;
                        taxBracketUpperLimit[3] = 115725;
                        taxBracketUpperLimit[4] = 206675;
                        taxBracketUpperLimit[5] = 233475;

                        taxBracketBases[0] = 928;
                        taxBracketBases[1] = 5184; 
                        taxBracketBases[2] = 14759;
                        taxBracketBases[3] = 25896;
                        taxBracketBases[4] = 55909;
                        taxBracketBases[5] = 65289;
            break;
        }
        
        // Calculate federal taxes based on tax status information
        if (taxableIncome < taxBracketUpperLimit[0])
        {
            federalTaxOwed = taxableIncome * taxBracketRates[0];
        }
        if (taxableIncome >= taxBracketUpperLimit[0] && taxableIncome < taxBracketUpperLimit[1])
        {
            federalTaxOwed = taxBracketBases[0] + (taxableIncome - taxBracketUpperLimit[0])*taxBracketRates[1];
        }
        if (taxableIncome >= taxBracketUpperLimit[1] && taxableIncome < taxBracketUpperLimit[2])
        {
            federalTaxOwed = taxBracketBases[1] + (taxableIncome - taxBracketUpperLimit[1])*taxBracketRates[2];
        }
        if (taxableIncome >= taxBracketUpperLimit[2] && taxableIncome < taxBracketUpperLimit[3])
        {
            federalTaxOwed = taxBracketBases[2] + (taxableIncome - taxBracketUpperLimit[2])*taxBracketRates[3];
        }
        if (taxableIncome >= taxBracketUpperLimit[3] && taxableIncome < taxBracketUpperLimit[4])
        {
            federalTaxOwed = taxBracketBases[3] + (taxableIncome - taxBracketUpperLimit[3])*taxBracketRates[4];
        }
        if (taxableIncome >= taxBracketUpperLimit[4] && taxableIncome < taxBracketUpperLimit[5])
        {
            federalTaxOwed = taxBracketBases[4] + (taxableIncome - taxBracketUpperLimit[4])*taxBracketRates[5];
        }
        if (taxableIncome >= taxBracketUpperLimit[5])
        {
            federalTaxOwed = taxBracketBases[5] + (taxableIncome - taxBracketUpperLimit[5])*taxBracketRates[6];
        }
        
        return federalTaxOwed;
    }
    
    // Mutators
    /**
     * Modifies the person's first name
     * 
     * @param  firstName   the new first name
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    /**
     * Modifies the person's last name
     * 
     * @param  lastName   the new last name
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    /**
     * Modifies the person's first name
     * 
     * @param  maritalStatus   the new marital status
     */
    public void setMaritalStatus(char maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }
    /**
     * Modifies the person's tax filing status
     * 
     * @param  taxFilingStatus   the new tax filing status
     */
    public void setTaxFilingStatus(TaxStatus taxFilingStatus)
    {
        this.taxFilingStatus = taxFilingStatus;
    }
    /**
     * Modifies the person's taxableIncome
     * 
     * @param  taxableIncome   the new taxableIncome
     */
    public void setTaxableIncome(double taxableIncome)
    {
        this.taxableIncome = taxableIncome;
    }
    
    // Accessors
    /**
    * Retrieves the person's first name
    * 
    * @return     first name
    */
    public String getFirstName()
    {
        return this.firstName;
    }
    /**
    * Retrieves the person's last name
    * 
    * @return     last name
    */
    public String getLastName()
    {
        return this.lastName;
    }
    /**
    * Retrieves the person's marital status
    * 
    * @return     marital status
    */
    public char getMaritalStatus()
    {
        return this.maritalStatus;
    }
    /**
    * Retrieves the person's tax filing status
    * 
    * @return     tax filing status
    */
    public TaxStatus getTaxFilingStatus()
    {
        return this.taxFilingStatus;
    }
    /**
    * Retrieves the person's taxable income
    * 
    * @return     taxable income
    */
    public double getTaxableIncome()
    {
        return this.taxableIncome;
    }
    /**
    * Returns a string representation of the instance
    * 
    * @return     formatted output of name, marital status, tax filing status, and federal tax amount
    */
    // Returns string of instance variables
    public String toString()
    {
        // Format text for human reading
        int taxFilingIndex;
        String formatted_federalTaxOwed = "";
        String formatted_maritalStatus = "";
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        formatted_federalTaxOwed = currencyFormatter.format(this.federalTaxOwed);
        
        if (maritalStatus == 'S')
            formatted_maritalStatus = "Single";
        else
            formatted_maritalStatus = "Married";
            
        switch (taxFilingStatus)
        {
            case MARRIED_FILING_JOINT: taxFilingIndex = 1; break;
            case HEAD_OF_HOUSEHOLD: taxFilingIndex = 2; break;
            case MARRIED_FILING_SEPARATE: taxFilingIndex = 3; break;
            default: taxFilingIndex = 0;
        }
      
        // Organize and return output
        String output = String.format(
        "\nName: \t\t%1s %2s" +
        "\nMarital Status: %3s" +
        "\nTax Filing Status: %4s" +
        "\nYour federal tax amount: %5s",
        firstName, lastName, formatted_maritalStatus, 
        formatted_taxFilingStatus[taxFilingIndex], formatted_federalTaxOwed);
        
        return output;   
    }
}
