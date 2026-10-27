package bankaccountwithadvancedconcepts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/** Manages bank accounts and provides transaction filtering and sorting operations. */
public class BankAccountManager implements Bank {
  private static final int MAX_ACCOUNTS = 100;

  private final Map<Integer, BankAccount> accounts;
  private int id;

  /** Creates an empty account manager. */
  public BankAccountManager() {
    accounts = new HashMap<>();
    id = 0;
  }

  /**
   * Adds an account unless the manager already contains 100 accounts.
   *
   * @param account the account to add
   * @throws IllegalArgumentException if {@code account} is {@code null}
   */
  @Override
  public void addAccount(BankAccount account) {
    if (account == null) {
      throw new IllegalArgumentException("Account cannot be null.");
    }
    if (accounts.size() >= MAX_ACCOUNTS) {
      System.out.println("Limit reached! Cannot add more than "
          + MAX_ACCOUNTS + " accounts.");
      System.out.println();
      return;
    }
    accounts.put(id, account);
    System.out.println("Added account with id " + id + " ("
        + accounts.size() + "/" + MAX_ACCOUNTS + " used)");
    System.out.println();
    id++;
  }

  /**
   * Returns the account registered with the specified ID.
   *
   * @param id the account ID
   * @return the matching account, or {@code null} if no account has that ID
   */
  @Override
  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }

  /** Prints the registered accounts and their balances. */
  @Override
  public void listAccounts() {
    if (accounts.isEmpty()) {
      System.out.println("No accounts to display.");
      System.out.println();
      return;
    }
    for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
      System.out.printf(Locale.US, "ID %d -> %s | Balance: %.2f%n",
          entry.getKey(), entry.getValue().getOwnerName(),
          entry.getValue().getBalance());
      System.out.println();
    }
  }

  /**
   * Returns transactions whose amounts are at least the specified minimum.
   *
   * @param amount the finite, non-negative minimum amount
   * @param txList the transactions to filter
   * @return matching transactions in their original order
   * @throws IllegalArgumentException if the amount is invalid or {@code txList} is {@code null}
   */
  public List<Transaction> filterTransactionsAtOrAbove(
      double amount, List<Transaction> txList) {
    if (!Double.isFinite(amount) || amount < 0) {
      throw new IllegalArgumentException("Minimum amount must be finite and non-negative.");
    }
    if (txList == null) {
      throw new IllegalArgumentException("Transaction list cannot be null.");
    }
    System.out.println("Filtering transactions at or above "
        + BigDecimal.valueOf(amount).stripTrailingZeros().toPlainString() + "...");
    List<Transaction> filteredTransactions = new ArrayList<>();
    for (Transaction tx : txList) {
      if (tx.getAmount() >= amount) {
        filteredTransactions.add(tx);
      }
    }
    System.out.println(filteredTransactions);
    System.out.println();
    return filteredTransactions;
  }

  /**
   * Returns a copy of the transactions sorted by amount in ascending order.
   *
   * @param txList the transactions to sort
   * @return a sorted copy of {@code txList}
   * @throws IllegalArgumentException if {@code txList} is {@code null}
   */
  public List<Transaction> sortTransactionsByAmount(List<Transaction> txList) {
    if (txList == null) {
      throw new IllegalArgumentException("Transaction list cannot be null.");
    }
    System.out.println("Sorting transactions by amount...");
    List<Transaction> sortedTransactions = new ArrayList<>(txList);
    sortedTransactions.sort((tx1, tx2) -> Double.compare(tx1.getAmount(), tx2.getAmount()));
    System.out.println(sortedTransactions);
    System.out.println();
    return sortedTransactions;
  }
}
