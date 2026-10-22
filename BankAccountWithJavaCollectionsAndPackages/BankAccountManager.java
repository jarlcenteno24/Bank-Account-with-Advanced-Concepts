import java.util.Map;
import java.util.HashMap;

public interface BankAccountManager {
    Map<Integer, BankAccount> accounts;
    int id;
    BankAccountManager() {
        accounts = new HashMap<>();
        id = 0;
    }
    addAccount(BankAccount account) {
        accounts.put(id, account);
        
    }

}
