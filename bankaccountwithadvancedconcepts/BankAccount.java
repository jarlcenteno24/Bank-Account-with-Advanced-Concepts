package bankaccountwithadvancedconcepts;

import bankaccountwithadvancedconcepts.exceptions.AccountFrozenException;
import bankaccountwithadvancedconcepts.exceptions.InsufficientFundsException;
import bankaccountwithadvancedconcepts.exceptions.InvalidAmountException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/** A bank account with a balance, freeze state, and transaction history. */
public class BankAccount {
  private double balance;
  private boolean isFrozen;
  private final String ownerName;
  private final List<Transaction> transactionHistory;

  /** Creates an account for an unknown owner with a zero balance. */
  public BankAccount() {
    this("Unknown");
  }

  /**
   * Creates an account for the specified owner with a zero balance.
   *
   * @param ownerName the account owner's name
   */
  public BankAccount(String ownerName) {
    this(ownerName, 0);
  }

  /**
   * Creates an account with the specified owner and opening balance.
   *
   * @param ownerName the account owner's name
   * @param openingBalance the initial balance, which must be finite and non-negative
   * @throws InvalidAmountException if the opening balance is not finite or is negative
   */
  public BankAccount(String ownerName, double openingBalance) {
    if (!Double.isFinite(openingBalance) || openingBalance < 0) {
      throw new InvalidAmountException("Opening balance must be finite and non-negative.");
    }
    this.ownerName = ownerName;
    balance = roundToTwoDecimals(openingBalance);
    isFrozen = false;
    transactionHistory = new ArrayList<>();
  }

  /**
   * Returns the account owner's name.
   *
   * @return the account owner's name
   */
  public String getOwnerName() {
    return ownerName;
  }

  private static double roundToTwoDecimals(double amount) {
    if (!Double.isFinite(amount)) {
      throw new InvalidAmountException("Amount must be a finite number.");
    }
    return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  /**
   * Deposits a positive amount when the account is not frozen.
   *
   * @param amount the amount to deposit
   */
  public void deposit(double amount) {
    try {
      if (isFrozen) {
        throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
      }
      System.out.printf(Locale.US, "Amount deposited: %.2f%n", amount);
      double roundedAmount = roundToTwoDecimals(amount);
      if (roundedAmount <= 0) {
        throw new InvalidAmountException("Invalid amount. Must be greater than 0");
      }
      balance = roundToTwoDecimals(balance + roundedAmount);
      transactionHistory.add(new Transaction("Deposit", amount));
      System.out.printf(Locale.US, "Current balance: %.2f%n", balance);
      System.out.println();
    } catch (AccountFrozenException e) {
      System.out.println(e.getMessage());
      System.out.println();
    } catch (InvalidAmountException e) {
      System.out.println("Invalid amount. Must be greater than 0");
      System.out.println();
    }
  }

  /**
   * Withdraws a positive amount when the account is not frozen and has sufficient funds.
   *
   * @param amount the amount to withdraw
   */
  public void withdraw(double amount) {
    try {
      if (isFrozen) {
        throw new AccountFrozenException("Account is FROZEN. Unable to transact.");
      }
      System.out.printf(Locale.US, "Amount withdrawn: %.2f%n", amount);
      double roundedAmount = roundToTwoDecimals(amount);
      if (roundedAmount <= 0) {
        throw new InvalidAmountException("Invalid amount. Must be greater than 0");
      }
      if (balance < roundedAmount) {
        throw new InsufficientFundsException("Insufficient balance.");
      }
      balance = roundToTwoDecimals(balance - roundedAmount);
      transactionHistory.add(new Transaction("Withdraw", amount));
      System.out.printf(Locale.US, "Current balance: %.2f%n", balance);
      System.out.println();
    } catch (AccountFrozenException e) {
      System.out.println(e.getMessage());
      System.out.println();
    } catch (InvalidAmountException e) {
      System.out.println("Invalid amount. Must be greater than 0");
      System.out.println();
    } catch (InsufficientFundsException e) {
      System.out.println(e.getMessage());
      System.out.printf(Locale.US, "Current balance: %.2f%n", balance);
      System.out.println();
    }
  }

  /**
   * Returns the current balance.
   *
   * @return the account balance
   */
  public double getBalance() {
    return balance;
  }

  /** Freezes the account and prevents deposits and withdrawals. */
  public void freezeAccount() {
    isFrozen = true;
  }

  /** Unfreezes the account and allows deposits and withdrawals. */
  public void unfreezeAccount() {
    isFrozen = false;
  }

  /**
   * Indicates whether the account is frozen.
   *
   * @return {@code true} if the account is frozen
   */
  public boolean isFrozen() {
    return isFrozen;
  }

  /**
   * Returns an unmodifiable snapshot of this account's transaction history.
   *
   * @return the account's transactions in insertion order
   */
  public List<Transaction> getTransactionHistory() {
    return Collections.unmodifiableList(new ArrayList<>(transactionHistory));
  }
}
