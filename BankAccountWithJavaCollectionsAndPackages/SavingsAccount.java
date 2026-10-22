package BankAccountWithJavaCollectionsAndPackages;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SavingsAccount {

  private String ownerName;
  private double balance;
  private final List<Transaction> transactionHistory = new ArrayList<>();

  public SavingsAccount(String ownerName) {
    this.ownerName = ownerName;
    this.balance = 0;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void deposit(double d) {
    double roundedAmount = roundToTwoDecimals(d);
    transactionHistory.add(new Transaction("Deposit", d));

    if (roundedAmount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    balance = roundToTwoDecimals(balance + roundedAmount);
    System.out.println("Amount deposited: " + roundedAmount);
    System.out.println("Current balance: " + balance);
  }

  public void withdraw(double d) {
    double roundedAmount = roundToTwoDecimals(d);
    transactionHistory.add(new Transaction("Withdraw", d));

    if (roundedAmount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    if (balance < roundedAmount) {
      System.out.println("Insufficient balance. Current balance: " + balance);
      return;
    }
    balance = roundToTwoDecimals(balance - roundedAmount);
    System.out.println("Amount withdrawn: " + roundedAmount);
    System.out.println("Current balance: " + balance);
  }

  public char[] getTransactionHistory() {
    StringBuilder sb = new StringBuilder();
    for (Transaction t : transactionHistory) {
      sb.append(t)
        .append(System.lineSeparator());
    }
    return sb.toString().toCharArray();
  }

  private static double roundToTwoDecimals(double amount) {
    return BigDecimal.valueOf(amount).setScale(2, RoundingMode.HALF_UP).doubleValue();
  }

}
