
/**
 * An exception that represents and age above the age limit.
 * 
 * @author Phil Fevry
 * @version 1
 */
public class TooOldException extends OutOfAgeLimitException {
	public TooOldException(){
		super("too old");
	}
	public TooOldException(int age, int ageLimit, String errorMessage) {
		super(ageLimit, "You are too old to " + errorMessage + ".");
		this.age = age;
	}

}