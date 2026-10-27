package bankaccountwithadvancedconcepts;

/** Defines account-management operations supported by a bank. */
public interface Bank {
  /**
   * Adds an account unless the bank has reached its account limit.
   *
   * @param account the account to add
   * @throws IllegalArgumentException if {@code account} is {@code null}
   */
  void addAccount(BankAccount account);

  /**
   * Returns the account registered with the specified ID.
   *
   * @param id the account ID
   * @return the matching account, or {@code null} if no account has that ID
   */
  BankAccount getAccount(int id);

  /** Prints the registered accounts and their balances. */
  void listAccounts();
}
