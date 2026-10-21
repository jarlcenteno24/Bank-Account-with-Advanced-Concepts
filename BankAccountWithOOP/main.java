package BankAccountWithOOP;

public class main {
  public static void main(String[] args) {
    // Create a savings account
    System.out.println("Create a savings account");
    System.out.println("BankAccount acc1 = new SavingsAccount(\"Test0\")");
    BankAccount acc1 = new SavingsAccount("Test0");
    System.out.println("Account Owner: " + ((SavingsAccount) acc1).getOwnerName() + ".");

    // Deposit with valid amount
    System.out.println();
    System.out.println("Deposit with valid amount");
    System.out.println("Call deposit(1000.125).");
    acc1.deposit(1000.125);

    // Deposit with zero amount
    System.out.println();
    System.out.println("Deposit with zero amount");
    System.out.println("Call deposit(0).");
    acc1.deposit(0);

    // Deposit with negative amount
    System.out.println();
    System.out.println("Deposit with negative amount");
    System.out.println("Call deposit(-500).");
    acc1.deposit(-500);

    // Withdraw with sufficient funds
    System.out.println();
    System.out.println("Withdraw with sufficient funds");
    System.out.println("Call withdraw(500)");
    acc1.withdraw(500);

    // Withdraw with insufficient funds
    System.out.println();
    System.out.println("Withdraw with insufficient funds");
    System.out.println("Call withdraw(1500).");
    acc1.withdraw(1500);

    // Withdraw with negative amount
    System.out.println();
    System.out.println("Withdraw with negative amount");
    System.out.println("Call withdraw(-100).");
    acc1.withdraw(-100);

    // Deposit when account is frozen
    System.out.println();
    System.out.println("Deposit when account is frozen");
    System.out.println("1. Call freezeAccount().");
    acc1.freezeAccount();
    System.out.println("2. Call deposit(11500).");
    acc1.deposit(11500);

    // Withdraw when account is frozen
    System.out.println();
    System.out.println("Withdraw when account is frozen");
    System.out.println("Call withdraw(500).");
    acc1.withdraw(500);

    // Unfreeze account and withdraw
    System.out.println();
    System.out.println("Unfreeze account and withdraw");
    System.out.println("1. Call unfreezeAccount().");
    acc1.unfreezeAccount();
    System.out.println("2. Call withdraw(100).");
    acc1.withdraw(100);
  }
}
