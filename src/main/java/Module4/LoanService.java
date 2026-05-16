/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module4;


public class LoanService {
        public Loan applyLoan(
            String customerName,
            double principal,
            double annualRate,
            int months,
            int creditScore
    ) {

        LoanStatus status;

        if(creditScore >= 650) {
            status = LoanStatus.APPROVED;
        }
        else {
            status = LoanStatus.PENDING;
        }

        Loan loan =
                new Loan(
                        customerName,
                        principal,
                        annualRate,
                        months,
                        status
                );

        System.out.println(
                "Loan Status: " +
                status
        );

        return loan;
    }

    public double calculateEMI(
            double principal,
            double annualRate,
            int months
    ) {

        double monthlyRate =
                annualRate / 12 / 100;

        double emi =
                (
                        principal *
                        monthlyRate *
                        Math.pow(
                                1 + monthlyRate,
                                months
                        )
                )
                /
                (
                        Math.pow(
                                1 + monthlyRate,
                                months
                        ) - 1
                );

        return emi;
    }

    public void repaymentSchedule(
            Loan loan
    ) {

        double emi =
                calculateEMI(
                        loan.getPrincipal(),
                        loan.getAnnualRate(),
                        loan.getMonths()
                );

        System.out.println("\nRepayment Schedule");

        for(int i=1; i<=loan.getMonths(); i++) {

            System.out.println(
                    "Month " +
                    i +
                    " EMI: " +
                    emi
            );
        }
    }

}
