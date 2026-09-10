# Banking Application

Week 1, Task 2 — WeIntern Pvt Ltd Java Development Internship.

## Objective
Build a console-based Banking Application that simulates basic account
operations, strengthening class design, method implementation, validation
logic, and exception handling.

## Features Implemented

**Deposit**
- Accepts a valid positive amount
- Adds it to the current balance and displays the updated balance
- Rejects invalid numeric input or negative values

**Withdraw**
- Accepts a positive amount
- Checks available balance before withdrawing
- Rejects overdraft attempts with a clear insufficient-funds message

**Balance Inquiry**
- Displays the current balance in a user-friendly format, e.g.
  `Current Balance: 12500.00`

**Exit**
- Closes the application cleanly

**Exception Handling**
- Invalid numeric input (menu choices and amounts)
- Negative deposit or withdrawal values
- Withdrawal amounts greater than the current balance
- Menu input mismatch, caught via `InputMismatchException`

## Technologies Used
- Java (JDK 8+)
- `java.util.Scanner` for console I/O
- `java.util.InputMismatchException` for input validation

## Recommended Class Structure
| Class | Responsibility |
|---|---|
| `BankAccount` | Stores the balance privately; exposes `deposit()`, `withdraw()`, `getBalance()` |
| `BankingApp` | Runs the menu loop and handles user interaction |
| `Main` | Starts the application |

## File Structure
```
banking_application/
├── src/
│   ├── Main.java
│   ├── BankingApp.java
│   └── BankAccount.java
└── README.md
```

## Steps to Compile and Run
From inside the `src/` folder:
```
javac *.java
java Main
```

## Sample Input and Output
```
===== Banking Application =====
1. Deposit
2. Withdraw
3. Balance Inquiry
4. Exit
Enter your choice: 1
Enter deposit amount: 5000
Deposit successful.
Current Balance: 15000.00

Enter your choice: 2
Enter withdrawal amount: 3000
Withdrawal successful.
Current Balance: 12000.00

Enter your choice: 3
Current Balance: 12000.00

Enter your choice: 4
Exiting Banking Application. Goodbye!
```

## Future Enhancements
- Transaction history
- Minimum balance rule
- Multiple account holders
- PIN-based verification

## Author
Deepak Singh Tomar
