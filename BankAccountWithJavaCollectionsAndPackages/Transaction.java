package BankAccountWithJavaCollectionsAndPackages;
import java.time.LocalDateTime;

public class Transaction {
    String type;
    double amount;
    LocalDateTime timestamp;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }

}
