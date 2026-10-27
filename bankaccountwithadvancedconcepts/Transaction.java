package bankaccountwithadvancedconcepts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** An immutable record of a deposit or withdrawal. */
public class Transaction {
  private static final DateTimeFormatter TIMESTAMP_FORMAT =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  private final String type;
  private final double amount;
  private final LocalDateTime timestamp;

  /**
   * Creates a transaction with the current time.
   *
   * @param type the transaction type
   * @param amount the positive, finite transaction amount
   * @throws IllegalArgumentException if the type is blank or the amount is invalid
   */
  public Transaction(String type, double amount) {
    this(type, amount, LocalDateTime.now());
  }

  /**
   * Creates a transaction with the specified time.
   *
   * @param type the transaction type
   * @param amount the positive, finite transaction amount
   * @param timestamp the transaction time
   * @throws IllegalArgumentException if an argument is invalid
   */
  public Transaction(String type, double amount, LocalDateTime timestamp) {
    if (type == null || type.isBlank()) {
      throw new IllegalArgumentException("Transaction type cannot be blank.");
    }
    if (!Double.isFinite(amount) || amount <= 0) {
      throw new IllegalArgumentException(
          "Transaction amount must be finite and greater than 0.");
    }
    if (timestamp == null) {
      throw new IllegalArgumentException("Transaction timestamp cannot be null.");
    }
    this.type = type;
    this.amount = amount;
    this.timestamp = timestamp;
  }

  /**
   * Returns the transaction type.
   *
   * @return the transaction type
   */
  public String getType() {
    return type;
  }

  /**
   * Returns the transaction amount.
   *
   * @return the positive transaction amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Returns the transaction timestamp.
   *
   * @return the transaction timestamp
   */
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  /** Returns a string representation with the timestamp formatted to minutes. */
  @Override
  public String toString() {
    return "Transaction [type=" + type
        + ", amount=" + amount
        + ", time_stamp=" + timestamp.format(TIMESTAMP_FORMAT)
        + "]";
  }
}
