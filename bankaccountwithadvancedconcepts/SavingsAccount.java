package bankaccountwithadvancedconcepts;

/** A savings account that uses the shared bank-account behavior. */
public class SavingsAccount extends BankAccount {
  /**
   * Creates a savings account for the specified owner with a zero balance.
   *
   * @param ownerName the account owner's name
   */
  public SavingsAccount(String ownerName) {
    super(ownerName);
  }
}
