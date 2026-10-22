package BankAccountWithOOP;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankAccount {
  private double balance;
  private boolean isFrozen;

  BankAccount() {
    balance = 0;
    isFrozen = false;
  }

  // Round to 2 decimal places using BigDecimal to avoid the binary floating-point
  // errors that Math.round(amount * 100.0) / 100.0 suffers from (e.g. 1.005 -> 1.00,
  // 2.675 -> 2.67, 0.565 -> 0.56). BigDecimal.valueOf uses the decimal string form of
  // the amount, so HALF_UP rounding matches real-world monetary expectations
  // (e.g. 1.005 -> 1.01, 1000.125 -> 1000.13).
  private static double roundToTwoDecimals(double amount) {
    return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

  void deposit(double amount) {
    double roundedAmount = roundToTwoDecimals(amount);
    if (isFrozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }
    System.out.println("Amount deposited: " + roundedAmount);
    if (roundedAmount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    balance = roundToTwoDecimals(balance + roundedAmount);
    System.out.println("Current balance: " + balance);
  }

  void withdraw(double amount) {
    double roundedAmount = roundToTwoDecimals(amount);
    if (isFrozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }
    System.out.println("Amount withdrawn: " + roundedAmount);
    if (roundedAmount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    if (balance < roundedAmount) {
      System.out.println("Insufficient balance. Current balance: " + balance);
      return;
    }
    balance = roundToTwoDecimals(balance - roundedAmount);
    System.out.println("Current balance: " + balance);
  }

  double getBalance() {
    return balance;
  }

  void freezeAccount() {
    isFrozen = true;
  }

  void unfreezeAccount() {
    isFrozen = false;
  }

  boolean isFrozen() {
    return isFrozen;
  }
}
