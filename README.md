# Bank (Java) 🏦

A small bank system with two account types: **savings accounts** that earn interest and **current accounts** with an overdraft limit.
Exercise from my Computer Science studies at **TU Braunschweig**.

## Features

- **Open** a savings account or a current account (the bank has space for 30 accounts)
- **Deposit** and **withdraw** money
- **Savings account**: earns 3 % interest on each update, but only if the balance is at least 100 €
- **Current account**: can go below 0, down to an overdraft limit of −1000 €. Withdrawals beyond the limit are refused
- **Update**: adds interest to all savings accounts and checks the current accounts
- **Close** an account

## Class structure

```
           Account
       (number, balance,
     deposit(), withdraw())
          /         \
SavingsAccount    CurrentAccount
 + interestRate    + limit
 + interest()      overrides withdraw()

Bank: manages an array of Account objects
```

| Class | Purpose |
|---|---|
| `Account` | Base class with account number, balance, deposit and withdraw |
| `SavingsAccount` | Extends `Account` with an interest rate |
| `CurrentAccount` | Extends `Account` with an overdraft limit; overrides `withdraw()` |
| `Bank` | Opens, closes and updates accounts; uses `instanceof` to treat each account type differently |
| `main` | Opens one account of each type and runs three rounds of deposits, withdrawals and updates |

## Example output (shortened)

The deposit amounts are random, so the numbers change on every run.

```
wir haben den Betrag: 639.03 zum Konto Nummer 22 eingezahlen, also das neue Balance ist: 639.03
Wir haben 1050.0 aus Girokonto nummer 22 ausgezahlen , also das neue Balance ist : -410.96
...
wir koennen nicht dieser Betrag:1050.0 aus Girokonto nummer 22 auszahlen , da das Limit ist -1000 !!!
...
Account nummer : 22 ist geschlossen
```

## Concepts

Inheritance · method overriding · `super` · `protected` fields · polymorphism with `instanceof` and casting · arrays of objects · packages

## How to run

```bash
javac -d out $(find . -name "*.java")
java -cp out main
```

The comments and console output are in German.
