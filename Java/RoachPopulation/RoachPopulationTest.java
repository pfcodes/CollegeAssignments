import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RoachPopulationTest for the problem
 * from the text book P3.10 Chapter 3
 * Java Concepts - Early Objects by
 * Cay Horstmann
 *
 * @author  CS 140 Instructors
 * @version 2/4/2017
 */
public class RoachPopulationTest
{

    RoachPopulation population;  // instance variable

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    
    @Before
    public void setUp()
    {
        population = new RoachPopulation(200);
    }
    

    
	@Test
	public void test_getRoaches() {
	    assertEquals(200, population.getRoaches() );
	}
    

    
    @Test
    public void test_breed() {
        int currentRoaches = population.getRoaches();
        population.breed();
        assertEquals(currentRoaches * 2, population.getRoaches() );
    }
    

    
    @Test
    public void test_spray() {
        int currentRoaches = population.getRoaches();
        population.spray(20);     // reduce the population by 20%
        assertEquals((int)(currentRoaches * 0.80), population.getRoaches() );
    }
    

    
    @Test
    public void test_breedAndspray() {
        int currentRoaches = population.getRoaches();
        population.breed();     // double the population
        assertEquals(currentRoaches * 2, population.getRoaches() );

        currentRoaches = population.getRoaches();
        population.spray(40);  // reduce the population by 40%
        assertEquals((int)(currentRoaches * 0.60), population.getRoaches() );

        currentRoaches = population.getRoaches();
        population.breed();     // double the population
        assertEquals(currentRoaches * 2, population.getRoaches() );

        currentRoaches = population.getRoaches();
        population.spray(30);  // reduce the population by 30%
        assertEquals((int)(currentRoaches * 0.70), population.getRoaches() );

        currentRoaches = population.getRoaches();
        population.breed();     // double the population
        assertEquals(currentRoaches * 2, population.getRoaches() );

        currentRoaches = population.getRoaches();
        population.spray(50);  // reduce the population by 50%
        assertEquals((int)(currentRoaches * 0.50), population.getRoaches() );

        currentRoaches = population.getRoaches();
        assertEquals(336, population.getRoaches());
    }
    

    
    @Test
    public void test_toString() {
        assertEquals("Number of roaches in the population: " + population.getRoaches(), population.toString());
    }
    
}
