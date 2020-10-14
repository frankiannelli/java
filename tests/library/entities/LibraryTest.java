package library.entities;

import library.entities.helpers.BookHelper;
import library.entities.helpers.LibraryFileHelper;
import library.entities.helpers.LoanHelper;
import library.entities.helpers.PatronHelper;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LibraryTest {

    @Test
    void dischargeLoanTest() throws ParseException {
        LibraryFileHelper libraryHelper = new LibraryFileHelper(new BookHelper(), new PatronHelper(), new LoanHelper());
        ILibrary library = libraryHelper.loadLibrary();
        String lastName = "Frank";
        String firstName = "Frank";
        String email = "frank@frank.com";
        String phoneString = "04123123";
        int phoneInt = Integer.valueOf(phoneString).intValue();
        IPatron patron = library.addPatron(lastName, firstName, email, phoneInt);
        String author = "frank";
        String title = "frank";
        String callNumber = "frank";
        IBook book = library.addBook(author, title, callNumber);
        ILoan pendingLoan = library.issueLoan(book, patron);
        List<ILoan>  pendingLoans = new ArrayList<>();
        pendingLoans.add(pendingLoan);
        for (ILoan loan : pendingLoans) {
            library.commitLoan(loan);
        }
        int bookId = book.getId();
        ILoan currentLoan = library.getCurrentLoanByBookId(bookId);
        Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-02");
        currentLoan.updateOverDueStatus(sdf);
        ICalendar calendar = Calendar.getInstance();
        calendar.incrementDate(3);
        library.dischargeLoan(currentLoan, false);
        double fines = patron.getFinesPayable();
        assertEquals(0, fines);
    }
}