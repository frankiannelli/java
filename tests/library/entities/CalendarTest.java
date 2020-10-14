package library.entities;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalendarTest {

    @Test
    void getDaysDifferenceTest() throws ParseException {
        ICalendar calendar = Calendar.getInstance();
        Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse("2008-01-02");
        calendar.setDate(sdf);
        Date dueDate = new SimpleDateFormat("yyyy-MM-dd").parse("2008-01-01");
        long daysOverDue = calendar.getDaysDifference(dueDate);
        assertEquals(1, daysOverDue);
    }
}