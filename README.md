# Secure Financial Management System

A console-based banking and financial services simulator developed in Java. The project implements core Object-Oriented Programming (OOP) principles to model real-world fintech workflows discovered through domain research on modern banking platforms like HBL, Meezan Bank, and PayPal.

## 🚀 Key Features

### 1. User & Account Management
* **Multi-Role Access Control:** Separate workflows and dashboards for standard Users and Administrators.
* **Account Operations:** Supports user registration, profile creation, deposit, withdrawal, and fund transfers.
* **Daily Limits & Validations:** Enforces custom business logic such as daily withdrawal ceilings and dynamic calculations.

### 2. Fraud Detection & Security
* **Account Lockout Protection:** Automatically freezes and locks a user account after 5 consecutive failed login attempts.
* **Sensitive Data Masking:** Masks private credentials and financial attributes across user panels.
* **Password Security:** Implements custom utility routines utilizing Base64 string encoding/decryption for local credential verification.

### 3. Credit Scoring & Loans
* **Automated Eligibility Engine:** Evaluates user eligibility scores dynamically based on deposit patterns and active transaction frequencies.
* **Equated Monthly Installment (EMI) Tracker:** Calculates repayment rates and interest increments on outstanding credits.

### 4. Admin Tracking & Audits
* **Centralized Dashboard:** Gives administrators a bird's-eye view of total systemic accounts, cumulative global deposits, outstanding loan sums, and flagged anomalous transfers.
* **Data Persistence & Utilities:** Generates clean, formatted text files (`.txt`) containing localized transaction statements exported directly via custom Java I/O modules.

## 🛠️ OOP Principles Demonstrated

The architecture follows strict modular software engineering guidelines using:
* **Encapsulation:** Protecting operational records by restricting direct field mutations outside explicit getter/setter criteria.
* **Inheritance:** Utilizing hierarchical structural layouts to scale explicit behavior from base account models down to complex specialty variants.
* **Abstraction:** Hiding low-level algorithmic logic behind simplified interface abstractions and modular service providers.
* **Polymorphism:** Overriding transaction execution routines across distinct monetary operations.

