package bankaccountwithadvancedconcepts;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/** Demonstrates invalid and frozen account operations and transaction utilities. */
public class Exception {
  /**
   * Runs the account and transaction examples.
   *
   * @param args command-line arguments (unused)
   */
  public static void main(String[] args) {
    BankAccount invalidDeposit = new BankAccount("Invalid deposit");
    invalidDeposit.deposit(-500);

    BankAccount frozenDeposit = new BankAccount("Frozen deposit");
    frozenDeposit.freezeAccount();
    frozenDeposit.deposit(11500);

    BankAccount invalidWithdrawal = new BankAccount("Invalid withdrawal");
    invalidWithdrawal.withdraw(-100);

    BankAccount insufficientFunds = new BankAccount("Insufficient funds", 500.13);
    insufficientFunds.withdraw(1500);

    BankAccount frozenWithdrawal = new BankAccount("Frozen withdrawal");
    frozenWithdrawal.freezeAccount();
    frozenWithdrawal.withdraw(500);

    LocalDateTime referenceTime = LocalDateTime.of(2026, 6, 11, 10, 43);
    List<Transaction> transactions = Arrays.asList(
        new Transaction("Deposit", 1000.125, referenceTime),
        new Transaction("Withdraw", 500.0, referenceTime),
        new Transaction("Withdraw", 100.0, referenceTime));
    BankAccountManager manager = new BankAccountManager();
    manager.filterTransactionsAtOrAbove(200, transactions);
    manager.sortTransactionsByAmount(transactions);
  }
}
