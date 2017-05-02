/**
 * A class which spawns, breeds, kills, and returns information on roaches.
 * 
 * @author Phil Fevry
 * @version 1.0
 */
public class RoachPopulation
{
    // instance variable
    private int roachPopulation;
    /**
     * Constructs a population of roaches (Yuck!)
     * 
     * @param   initialRoachPopulation    the amount of roaches to create
     */
    public RoachPopulation(int initialRoachPopulation)
    {
        // initialise instance variable
        roachPopulation = initialRoachPopulation;
    }
    /**
     * Doubles the roach population
     * 
     */    
    public void breed()
    {
        roachPopulation *= 2;
    }
    /**
     * Sprays pesticide which kills a certain amount of roaches
     * 
     * @param   percentage       the percentage of roaches to kill with the spray
     */    
    public void spray(double percentage)
    {
        roachPopulation = roachPopulation - (int)(roachPopulation * percentage)/100;
    }
    /**
     * Gets the current amount of living roaches
     * 
     * @return  the current roach population
     */    
    public int getRoaches()
    {
        return roachPopulation;
    }
    /**
     * Returns a string which specifies the number of the roach population
     * 
     * @return  string   "Number of roaches in the population: <number of roaches>"
     */    
    public String toString()
    {
        return "Number of roaches in the population: " + roachPopulation;
    }
}
