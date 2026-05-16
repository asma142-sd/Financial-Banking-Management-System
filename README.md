# Secure Financial Management System

A console-based banking simulator developed in Java using Object-Oriented Programming (OOP) principles. The system models modern fintech workflows inspired by platforms like HBL, Meezan Bank, and PayPal.

##  Key Features

* **User & Account Management:** Supports multi-role access (User/Admin), account registration, profile creation, deposits, withdrawals, and fund transfers with daily limit validations.
* **Security & Fraud Detection:** Implements account lockout protection after 5 failed login attempts, sensitive data masking across user panels, and Base64 password encryption routines.
* **Credit Scoring & Loans:** Features an automated eligibility engine that dynamically calculates risk and sets Equated Monthly Installment (EMI) rates based on transaction patterns.
* **Admin Dashboard & Utilities:** Gives administrators tracking metrics (total accounts, cumulative global deposits, outstanding loan sums, and flagged actions) and exports local transaction statements to `.txt` files using Java I/O.

##  OOP Principles Demonstrated

* **Encapsulation:** Protecting user data and account records by restricting direct field mutations outside explicit getter and setter criteria.
* **Inheritance:** Creating modular, hierarchical account structures that inherit core financial behaviors while allowing specialized modifications.
* **Abstraction:** Hiding complex back-end algorithmic and validation logic behind simplified interface structures and managers.
* **Polymorphism:** Overriding core transaction execution routines across distinct monetary operations like transfers, deposits, and withdrawals
