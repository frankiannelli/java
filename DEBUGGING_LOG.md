
# Debugging Log

## Bug 1: Incorrect calculation of fines

- Go to main file and find the method that gets run when we return book
- the method is `returnBook();`
- `returnBook();` calls `ReturnBookControl` and the method is `bookScanned`
- `bookScanned` calls `library.calculateOverDueFine(currentLoan);`
- `library.calculateOverDueFine(currentLoan);` calls `Calendar.getInstance().getDaysDifference(dueDate);`
- `Calendar.getInstance().getDaysDifference(dueDate);` uses constant `MILLIS_PER_DAY`
- the value is wrong it should be `86400000L` rather than `172800000L;`

## Bug 2: Incorrect fine amount levied

- Go to main file and find the UI that handles returning a book
- Go to ReturnBookUI and find logic is handled by ReturnBookControl
- go to ReturnBookControl find logic when a book is scanned. Note that at this point the fine for overdue books is calculated and added to the patron
- go to ReturnBookControl find logic when we discharge a loan. Note that there is duplication of logic which calculate the overdue fine for a patron
- remove duplicate code in Library.discharge loan method