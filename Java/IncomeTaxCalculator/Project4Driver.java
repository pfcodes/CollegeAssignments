/**
 * Driver for the Person class which contains personal federal tax income calculation methods.
 * 
 * @author Phil Fevry
 * @version 1.0
 */
public class Project4Driver
{
    public static void main()
    {
        // Inputs test
        Person taxPayer = new Person ();
        taxPayer.getFederalTaxOwed(); 
        outputPerson(taxPayer);
        
        printDivider();
        
        // Constructur test
        output("Constructor test", true);
        Person taxPayer_2 = new Person ("Jane", "Miller", 'M', 2, 560500);
        outputPerson(taxPayer_2);
        
        printDivider();
        
        // Mutator tests
        output("Mutator tests for existing Person object", true);
        taxPayer.setFirstName("Agatha");
        taxPayer.setLastName("Blake");
        taxPayer.setMaritalStatus('M');
        taxPayer.setTaxableIncome(96700);
        taxPayer.setTaxFilingStatus(TaxStatus.MARRIED_FILING_SEPARATE);
        taxPayer.refresh(); // recalculates tax owed with new variables
        outputPerson(taxPayer);
        
        printDivider();
        
        // Accessor tests
        output("Acessor tests for new Person object (unformatted)", true);
        Person taxPayer_3 = new Person("Robert", "Austin", 'M', 3, 130560);
        output("\nName: " + taxPayer_3.getFirstName(), false);
        output(" " + taxPayer_3.getLastName(), true);
        output("Marital Status: " + taxPayer_3.getMaritalStatus(), true);
        output("Tax Filing Status: " + taxPayer_3.getTaxFilingStatus(), true);
        output("Taxable Income: " + taxPayer_3.getTaxableIncome(), true);
        
    }
    /**
     * Prints a divider line
     */
    public static void printDivider()
    {
        System.out.println("\n=================================\n");
    }
    /**
     * Prints a string to console
     * 
     * @param  string   the string to print
     * @param  newLine  start a new line after?
     */
    public static void output(String string, boolean newLine)
    {
        if (newLine)
            System.out.println(string);
        else
            System.out.print(string);
    }
    /**
     * Outputs to console the string representation of a person object
     * 
     * @param  person   person object
     */
    public static void outputPerson(Person person)
    {
        System.out.println(person.toString());
    }
}
