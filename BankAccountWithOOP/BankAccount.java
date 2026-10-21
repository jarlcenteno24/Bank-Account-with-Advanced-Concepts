package BankAccountWithOOP;

public class BankAccount {
  double balance;
  boolean isFrozen;

  BankAccount() {
    balance = 0;
    isFrozen = false;
  }

  void deposit(double amount) {
    double roundedAmount = Math.round(amount * 100.0) / 100.0;
    if (isFrozen) {
      System.out.println("Account is FROZEN. Unable to transact.");
      return;
    }
    System.out.println("Amount deposited: " + roundedAmount);
    if (roundedAmount <= 0) {
      System.out.println("Invalid amount. Must be greater than 0");
      return;
    }
    balance += roundedAmount;
    System.out.println("Current balance: " + balance);
  }

  void withdraw(double amount) {
    double roundedAmount = Math.round(amount * 100.0) / 100.0;
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
    balance -= roundedAmount;
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

  boolean isfrozen() {
    return isFrozen;
  }
}
