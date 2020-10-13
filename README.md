# UAT Test cases


## Bug 1: Incorrect calculation of fines

When a book becomes overdue by one day, no fine is imposed

Complete the following steps to reproduce this bug

- Add a patron - option M
- Add a book - option B
- Take out a loan with the previously added book and patron - option L
- Increment date by 3 days - option T
- Return a loan - option R
- Overdue fine is shown as $0.00

## Bug 2: Incorrect fine amount levied.

When a fine is incurred, the amount of fine reported is half the amount intended.

Complete the following steps to reproduce this bug

- Add a patron - option M
- Add a book - option B
- Take out a loan with the previously added book and patron - option L
- Increment date by 4 days - option T
- Return a loan - option R
- Overdue fine is displayed as $1.0
- List patrons - option LM
- Patron shows fines owed as $2.00

