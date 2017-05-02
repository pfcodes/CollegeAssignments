/*                      READ READ READ
   Summary:  Java provides a clean and robust mechanism for handling
   abnormal conditions.  First, you try to execute a block of statements.
   If an abnormal condition occurs, an exception is thrown and you can
   catch the exception.  And, finally, there can be a code fragment you
   always want to execute, whether or not an exception happens and is
   handled.

   Exceptions are objects, and exception classes form their own class
   hierarchy.  The root of all error and exception classes is the
   Throwable class.  You can create your own exception classes as subclasses
   of the Exception class.  The whole exception-handling mechanism is then
   at your disposal.  You can even create a hierarchy of exception classes
   so that the handler has more flexibility in handling the exceptions.

   A method that may cause an exception to be thrown must catch that
   exception or have that exception defined in its throws clause,
   unless the exception is a subclass of either the Error or
   RunTimeException class.  Checking of this rule is done at compile time.

   It is always unpleasant for a user to encounter errors in your application.
   How you deal with these errors will make a difference to the user, and
   will be an important factor in your application's success.  The clean
   and robust exception-handling capability provided with Java makes
   writing a friendly program an easier task.
  */

 public class AgeExceptionTest {
     public static void RideRollerCoasterAtAge(int age) throws
               NegativeAgeException, OutOfAgeLimitException   {
        System.out.printf("Trying to ride a roller coaster at age %d...\n", age);

        if (age < 0) throw new NegativeAgeException(age);

        else if (age < 5)
           throw new TooYoungException(age, 5, "ride a roller coaster");

             else if (age > 45)
                 throw new TooOldException(age, 45, "ride a roller coaster");

        System.out.println("Riding the roller coaster.....");
     }

     public static void main (String args[]) {
        int ages[] = {-3, 2, 10, 35, 65};

        for (int i = 0; i < ages.length; i++) {
            try {
                RideRollerCoasterAtAge(ages[i]);
                System.out.println("Wow! What an experience!");
            }

            catch (OutOfAgeLimitException e) {
                System.out.println(e.getMessage() );
                if (e.age < e.ageLimit )
                   System.out.println((e.ageLimit - e.age) + " more years and you'll be able to try it.");

                else
                System.out.printf((e.age- e.ageLimit ) + " years ago riding it was like a piece of cake.");
            }

            catch (NegativeAgeException e) {
                System.out.println(e.getMessage() );
            }

            finally {
                System.out.println();
            }
        }
     }
}

