package BankAccountWithOOP;

import java.util.HashMap;
import java.util.Map;

public class Bank {

  private static final int MAX_ACCOUNTS = 100; // the limit

  private final Map<Integer, BankAccount> accounts = new HashMap<>();
  private int nextId = 1;

  public void addAccount(BankAccount account) {
    // LIMIT CHECK: reject if the bank is already full
    if (accounts.size() >= MAX_ACCOUNTS) {
      System.out.println("Limit reached! Cannot add more than "
          + MAX_ACCOUNTS + " accounts.");
      return; // exits without calling accounts.put(...)
    }

    int id = nextId++;                  // auto-generate the id (1, 2, 3, ...)
    accounts.put(id, account);
    System.out.println("Added account with id " + id + " ("
        + accounts.size() + "/" + MAX_ACCOUNTS + " used)");
  }

  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }
}
