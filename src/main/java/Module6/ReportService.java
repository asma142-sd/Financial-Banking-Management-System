/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module6;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Module2.Account;
import Module3.Transaction;

public class ReportService {
    public void miniStatement(
            ArrayList<Transaction> transactions
    ) {

        System.out.println("\nMini Statement");

        int start = Math.max(
                0,
                transactions.size() - 5
        );

        for(int i=start;
            i<transactions.size();
            i++) {

            System.out.println(
                    transactions.get(i)
            );
        }
    }

    public void fullStatement(
            ArrayList<Transaction> transactions
    ) {

        System.out.println("\nFull Statement");

        for(Transaction transaction :
                transactions) {

            System.out.println(transaction);
        }
    }

    public void exportStatement(
            ArrayList<Transaction> transactions,
            String fileName
    ) {

        try {

            FileWriter writer =
                    new FileWriter(fileName);

            for(Transaction transaction :
                    transactions) {

                writer.write(
                        transaction.toString()
                        + "\n"
                );
            }

            writer.close();

            System.out.println(
                    "Statement Exported"
            );

        }
        catch(IOException e) {

            System.out.println(
                    "File Error"
            );
        }
    }

    public void adminDashboard(
            ArrayList<Account> accounts,
            double deposits,
            double loans,
            int flagged
    ) {

        System.out.println("\nADMIN DASHBOARD");

        System.out.println(
                "Total Accounts: " +
                accounts.size()
        );

        System.out.println(
                "Total Deposits: " +
                deposits
        );

        System.out.println(
                "Outstanding Loans: " +
                loans
        );

        System.out.println(
                "Flagged Transactions: " +
                flagged
        );
    }

}
