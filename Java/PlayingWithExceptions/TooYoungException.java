
/**
 * An exception that represents and age under the age limit.
 * 
 * @author Phil Fevry
 * @version 1
 */
public class TooYoungException extends OutOfAgeLimitException {
	public TooYoungException() {
		super("too young");
	}
	public TooYoungException(int age, int ageLimit, String errorMessage) {
		super(ageLimit, "You are too young to " + errorMessage + ".");
		this.age = age;
	}
}