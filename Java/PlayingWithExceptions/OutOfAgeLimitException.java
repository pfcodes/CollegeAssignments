
/**
 * An exception class which represents an age not within the age limit.
 * 
 * @author Phil Fevry
 * @version 1
 */
public class OutOfAgeLimitException extends AgeException {
	protected int ageLimit;

	public OutOfAgeLimitException(String errorMessage){
		super(errorMessage);
	}

	public OutOfAgeLimitException (int ageLimit, String errorMessage) {
		super(errorMessage);
		this.ageLimit = ageLimit;
	}
	
	public int getAgeLimit() {
		return ageLimit;
	}
}