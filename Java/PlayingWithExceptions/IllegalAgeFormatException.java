
/**
 * Exception class which represents an illegal age format.
 * 
 * @author Phil Fevry
 * @version 1
 */
public class IllegalAgeFormatException extends AgeException {
     public IllegalAgeFormatException() {
        super ("Illegal Age Format");
    }
    public IllegalAgeFormatException(String errorMessage) {
        super (errorMessage);
    }
}
