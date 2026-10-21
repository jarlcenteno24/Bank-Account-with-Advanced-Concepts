package BankAccountWithOOP;

public class SavingsAccount extends BankAccount {

  String ownerName;
  SavingsAccount(String ownerName) {
    this.ownerName = ownerName;
  }
  String getOwnerName() {
    return ownerName;
  }



}
