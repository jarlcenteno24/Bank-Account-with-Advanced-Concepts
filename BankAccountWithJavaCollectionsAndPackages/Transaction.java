package BankAccountWithOOP;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private String type;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
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
