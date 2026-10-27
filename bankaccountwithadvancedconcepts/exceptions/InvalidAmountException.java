package bankaccountwithadvancedconcepts.exceptions;

/** Thrown when an account operation receives an invalid monetary amount. */
public class InvalidAmountException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Creates an exception with the specified detail message.
   *
   * @param message the detail message
   */
  public InvalidAmountException(String message) {
    super(message);
  }
}
