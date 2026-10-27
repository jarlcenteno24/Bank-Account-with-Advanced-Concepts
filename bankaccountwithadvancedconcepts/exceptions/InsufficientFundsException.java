package bankaccountwithadvancedconcepts.exceptions;

/** Thrown when an account does not have enough funds for a withdrawal. */
public class InsufficientFundsException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Creates an exception with the specified detail message.
   *
   * @param message the detail message
   */
  public InsufficientFundsException(String message) {
    super(message);
  }
}
