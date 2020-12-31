
/**
 * Runtime exception thrown when one tries to perform operation top or
 * pop on an empty stack.
 */

public class NonEmptyTreeException extends RuntimeException {  
  public NonEmptyTreeException(String err) {
    super(err);
  }
}
