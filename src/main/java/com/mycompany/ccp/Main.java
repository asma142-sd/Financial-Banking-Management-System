/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ccp;
import java.math.BigDecimal;
import java.util.Scanner;

import Module1.*;
import Module2.*;
import Module3.*;
import Module4.*;
import Module5.*;
import Module6.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        AuthenticationService authService =new AuthenticationService();

        AccountService accountService =new AccountService();

        TransactionService transactionService =new TransactionService();

        LoanService loanService =new LoanService();

        ReportService reportService =new ReportService();

        User currentUser = null;
        Account currentAccount = null;

        int choice;

        do {

            System.out.println("\n====================================");
            System.out.println(" SECURE FINANCIAL MANAGEMENT SYSTEM ");
            System.out.println("====================================");

            System.out.println("1. Register User");
            System.out.println("2. Login");
            System.out.println("3. Open Account");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Fund Transfer");
            System.out.println("7. Bill Payment");
            System.out.println("8. Balance Inquiry");
            System.out.println("9. Calculate Interest");
            System.out.println("10. Apply Loan");
            System.out.println("11. Mini Statement");
            System.out.println("12. Full Statement");
            System.out.println("13. Export Statement");
            System.out.println("14. Security Demo");
            System.out.println("15. Admin Dashboard");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch(choice) {

                case 1 -> {

                    System.out.print("Full Name: ");
                    String name = input.nextLine();

                    System.out.print("Email: ");
                    String email = input.nextLine();

                    System.out.print("Phone: ");
                    String phone = input.nextLine();

                    System.out.print("Date Of Birth: ");
                    String dob = input.nextLine();

                    System.out.print("National ID: ");
                    String nationalId = input.nextLine();

                    System.out.print("Password: ");
                    String password = input.nextLine();

                    authService.registerUser(
                        name,
                        email,
                        phone,
                        dob,
                        nationalId,
                        password,
                        UserRole.CUSTOMER
                    );
                }

                case 2 -> {

                    System.out.print("Email: ");
                    String email = input.nextLine();

                    System.out.print("Password: ");
                    String password = input.nextLine();

                    currentUser =authService.login(email, password);
                }

                case 3 -> {

                    if(currentUser == null) {
                        System.out.println("Login First");
                        break;
                    }

                    System.out.println("1. SAVINGS");
                    System.out.println("2. CURRENT");
                    System.out.println("3. FIXED_DEPOSIT");

                    int typeChoice = input.nextInt();

                    AccountType type;

                    if(typeChoice == 1) {
                        type = AccountType.SAVINGS;
                    }
                    else if(typeChoice == 2) {
                        type = AccountType.CURRENT;
                    }
                    else {
                        type = AccountType.FIXED_DEPOSIT;
                    }

                    currentAccount =
                            accountService.openAccount(
                                currentUser.getFullName(),
                                type
                            );
                }

                case 4 -> {

                    if(currentAccount == null) {
                        System.out.println("Open Account First");
                        break;
                    }

                    System.out.print("Enter Amount: ");
                    BigDecimal amount =input.nextBigDecimal();

                    transactionService.cashDeposit(
                        currentAccount,
                        amount
                    );
                }

                case 5 -> {

                    if(currentAccount == null) {
                        System.out.println("Open Account First");
                        break;
                    }

                    try {

                        System.out.print("Enter Amount: ");
                        BigDecimal amount =input.nextBigDecimal();

                        transactionService.cashWithdrawal(
                            currentAccount,
                            amount
                        );

                    }
                    catch(LimitExceededException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 6 -> {

                    if(currentAccount == null) {
                        System.out.println("Open Account First");
                        break;
                    }

                    Account receiver =accountService.openAccount("Receiver",AccountType.CURRENT);

                    System.out.print("Enter Amount: ");
                    BigDecimal amount =input.nextBigDecimal();

                    transactionService.fundTransfer(
                            currentAccount,
                            receiver,
                            amount
                    );
                }

                case 7 -> {

                    if(currentAccount == null) {
                        System.out.println("Open Account First");
                        break;
                    }

                    input.nextLine();

                    System.out.print("Bill Type: ");
                    String billType =
                            input.nextLine();

                    System.out.print("Bill Amount: ");
                    BigDecimal billAmount =input.nextBigDecimal();

                    transactionService.billPayment(
                            currentAccount,
                            billAmount,
                            billType
                    );
                }

                case 8 -> {

                    if(currentAccount == null) {
                        System.out.println("Open Account First");
                        break;
                    }

                    accountService.checkBalance(
                            currentAccount
                    );
                }

                case 9 -> {

                    if(currentAccount == null) {
                        System.out.println("Open Account First");
                        break;
                    }

                    System.out.print("Enter Interest Rate: ");
                    double rate = input.nextDouble();

                    accountService.calculateMonthlyInterest(
                            currentAccount,
                            rate
                    );
                }

                case 10 -> {

                    if(currentUser == null) {
                        System.out.println("Login First");
                        break;
                    }

                    System.out.print("Loan Amount: ");
                    double amount = input.nextDouble();

                    System.out.print("Interest Rate: ");
                    double rate = input.nextDouble();

                    System.out.print("Months: ");
                    int months = input.nextInt();

                    System.out.print("Credit Score: ");
                    int score = input.nextInt();

                    Loan loan =
                            loanService.applyLoan(
                                    currentUser.getFullName(),
                                    amount,
                                    rate,
                                    months,
                                    score
                            );

                    double emi =
                            loanService.calculateEMI(
                                    amount,
                                    rate,
                                    months
                            );

                    System.out.println("Monthly EMI: " + emi);

                    loanService.repaymentSchedule(loan);
                }

                case 11 -> {

                    reportService.miniStatement(
                            transactionService.getTransactions()
                    );
                }

                case 12 -> {

                    reportService.fullStatement(
                            transactionService.getTransactions()
                    );
                }

                case 13 -> {

                    reportService.exportStatement(
                            transactionService.getTransactions(),
                            "statement.txt"
                    );
                }

                case 14 -> {

                    try {

                        String encrypted =
                                SecurityUtil.encrypt("BANKING");

                        System.out.println(
                                "Encrypted: " + encrypted
                        );

                        String decrypted =
                                SecurityUtil.decrypt(encrypted);

                        System.out.println(
                                "Decrypted: " + decrypted
                        );

                        if(currentAccount != null) {

                            System.out.println(
                                    "Masked Account: " +
                                    SecurityUtil.maskAccountNumber(
                                            currentAccount.getAccountNumber()
                                    )
                            );
                        }

                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 15 -> {

                    reportService.adminDashboard(
                            accountService.getAccounts(),
                            500000,
                            200000,
                            3
                    );
                }

                case 0 -> {
                    System.out.println("Thank You");
                }

                default -> {
                    System.out.println("Invalid Choice");
                }
            }

        } while(choice != 0);

    }
}
