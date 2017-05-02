
/**
 * An exception that represents an age with a negative number.
 * 
 * @author Phil Fevry
 * @version 1
 */
public class NegativeAgeException extends IllegalAgeFormatException {
	public NegativeAgeException(int age) {
		super("Age must be nonnegative");
		this.age = age;
	}
	public NegativeAgeException(String errorMessage) {
		super (errorMessage);
	}
}