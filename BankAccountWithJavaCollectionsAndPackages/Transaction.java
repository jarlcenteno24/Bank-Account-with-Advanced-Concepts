package BankAccountWithOOP;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        return "Transaction [type=" + type
                + ", amount=" + amount
                + ", time_stamp="
                + timestamp.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
                + "]";
    }

}
