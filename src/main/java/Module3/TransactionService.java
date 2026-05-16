/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module3;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

import Module2.Account;

public class TransactionService {
    private ArrayList<Transaction> transactions =
            new ArrayList<>();

    public void cashDeposit(
            Account account,
            BigDecimal amount
    ) {

        account.deposit(amount);

        Transaction transaction =
                new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.DEPOSIT,
                        amount
                );

        transactions.add(transaction);

        System.out.println("Deposit Successful");
    }

    public void cashWithdrawal(
            Account account,
            BigDecimal amount
    ) throws LimitExceededException {

        if(amount.compareTo(
                BigDecimal.valueOf(50000)
        ) > 0) {

            throw new LimitExceededException(
                    "Daily Limit Exceeded"
            );
        }

        account.withdraw(amount);

        Transaction transaction =
                new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.WITHDRAW,
                        amount
                );

        transactions.add(transaction);

        System.out.println(
                "Withdrawal Successful"
        );
    }

    public void fundTransfer(
            Account sender,
            Account receiver,
            BigDecimal amount
    ) {

        sender.withdraw(amount);

        receiver.deposit(amount);

        Transaction transaction =
                new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.TRANSFER,
                        amount
                );

        transactions.add(transaction);

        System.out.println(
                "Transfer Successful"
        );
    }

    public void billPayment(
            Account account,
            BigDecimal amount,
            String billType
    ) {

        account.withdraw(amount);

        Transaction transaction =
                new Transaction(
                        UUID.randomUUID().toString(),
                        TransactionType.BILL_PAYMENT,
                        amount
                );

        transactions.add(transaction);

        System.out.println(
                billType +
                " Bill Paid Successfully"
        );
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

}
