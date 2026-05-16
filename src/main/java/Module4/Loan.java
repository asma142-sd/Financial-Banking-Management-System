/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Module4;


public class Loan {
    private String customerName;
    private double principal;
    private double annualRate;
    private int months;

    private LoanStatus status;

    public Loan(
            String customerName,
            double principal,
            double annualRate,
            int months,
            LoanStatus status
    ) {

        this.customerName = customerName;
        this.principal = principal;
        this.annualRate = annualRate;
        this.months = months;
        this.status = status;
    }

    public double getPrincipal() {
        return principal;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public int getMonths() {
        return months;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public String toString() {

        return customerName +
                " | " +
                principal +
                " | " +
                status;
    }

}
