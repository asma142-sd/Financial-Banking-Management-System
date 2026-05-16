/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module2;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class AccountService {
        private ArrayList<Account> accounts =
            new ArrayList<>();

    public Account openAccount(
            String ownerName,
            AccountType type
    ) {

        Random random = new Random();

        String accountNumber = "";

        for(int i=0; i<10; i++) {
            accountNumber += random.nextInt(10);
        }

        Account account =
                new Account(
                        accountNumber,
                        ownerName,
                        type
                );

        accounts.add(account);

        System.out.println(
                "Account Opened Successfully"
        );

        account.display();

        return account;
    }

    public void checkBalance(Account account) {

        System.out.println(
                "Current Balance: " +
                account.getBalance()
        );
    }

    public void calculateMonthlyInterest(
            Account account,
            double annualRate
    ) {

        BigDecimal monthlyInterest =
                account.getBalance()
                .multiply(
                        BigDecimal.valueOf(
                                annualRate / 12 / 100
                        )
                );

        System.out.println(
                "Monthly Interest: " +
                monthlyInterest
        );
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

}
