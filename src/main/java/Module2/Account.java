/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module2;
import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private String ownerName;

    private AccountType type;
    private AccountStatus status;

    private BigDecimal balance;

    public Account(
            String accountNumber,
            String ownerName,
            AccountType type
    ) {

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.type = type;

        status = AccountStatus.ACTIVE;

        balance = BigDecimal.ZERO;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public AccountType getType() {
        return type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public void closeAccount() {
        status = AccountStatus.CLOSED;
    }

    public void display() {

        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Owner: " + ownerName);
        System.out.println("Type: " + type);
        System.out.println("Balance: " + balance);
        System.out.println("Status: " + status);
    }

}
