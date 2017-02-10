package wolfe.michael.HurtLocker;

/**
 * Created by michaelwolfe on 2/9/17.
 */
public class InvalidJerksonException extends Exception {

    public static int exceptionsThrownCount = 0;

    public InvalidJerksonException(){
        exceptionsThrownCount++;
    }
}
