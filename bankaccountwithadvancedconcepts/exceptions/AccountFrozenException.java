package bankaccountwithadvancedconcepts.exceptions;

/** Thrown when an operation cannot be performed because an account is frozen. */
public class AccountFrozenException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  /**
   * Creates an exception with the specified detail message.
   *
   * @param message the detail message
   */
  public AccountFrozenException(String message) {
    super(message);
  }
}
