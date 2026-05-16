/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module3;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private TransactionType type;
    private BigDecimal amount;
    private LocalDateTime time;

    public Transaction(
            String transactionId,
            TransactionType type,
            BigDecimal amount
    ) {

        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;

        time = LocalDateTime.now();
    }

    public String toString() {

        return transactionId +
                " | " +
                type +
                " | " +
                amount +
                " | " +
                time;
    }

}
