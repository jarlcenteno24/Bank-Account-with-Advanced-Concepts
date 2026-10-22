package BankAccountWithJavaCollectionsAndPackages;

import java.util.Map;
import java.util.HashMap;

import BankAccountWithOOP.BankAccount;

public class BankAccountManager {
    private final Map<Integer, BankAccount> accounts;
    private int id;

    public BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
    }

    public void addAccount(BankAccount account) {
        accounts.put(id, account);
        System.out.println("Added account with id " + id + " (" + accounts.size() + " total)");
        id++;
    }

    public BankAccount getAccount(int id) {
        return accounts.get(id);
    }

    public void listAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            System.out.println("ID " + entry.getKey() + " -> " + entry.getValue().getOwnerName());
        }
    }
}
