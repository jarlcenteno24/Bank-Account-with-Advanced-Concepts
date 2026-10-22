package BankAccountWithOOP;

import java.util.HashMap;
import java.util.Map;

public class Bank {

  private static final int MAX_ACCOUNTS = 100; // the limit

  private final Map<Integer, BankAccount> accounts = new HashMap<>();
  private int nextId = 1;

  public void addAccount(BankAccount account) {

    if (accounts.size() >= MAX_ACCOUNTS) {
      System.out.println("Limit reached! Cannot add more than "
          + MAX_ACCOUNTS + " accounts.");
      return; 
    }

    int id = nextId++;   
    accounts.put(id, account);
    System.out.println("Added account with id " + id + " ("
        + accounts.size() + "/" + MAX_ACCOUNTS + " used)");
  }

  public BankAccount getAccount(int id) {
    return accounts.get(id);
  }
}
