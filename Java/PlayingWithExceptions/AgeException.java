
/**
 * An exception class which represents an issue related with age.
 * 
 * @author Phil Fevry
 * @version 1
 */
public class AgeException extends Exception
{   
    protected int age;

    public AgeException () {
        super();
    }

    public AgeException(String errorMessage) {
        super(errorMessage);
    }

    public int getAge() {
       return age;
    }
}
