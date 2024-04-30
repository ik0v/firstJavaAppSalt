package se.salt.precourse.firstjavaapp;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class StartDateHandlerTest {

    @Test
    void returns2ForDateTwoDaysInTheFuture() {
        LocalDate twoDaysInTheFuture = LocalDate.now().plusDays(2);
        long two = new StartDateHandler().daysToCourseStart(twoDaysInTheFuture.toString());

        assertEquals(2, two);
    }

    @Test
    void dateHasOnlyNumbersTest() {
        String dateString = "2024-05-06";
        boolean onlyNumbers = new StartDateHandler().dateHasOnlyNumbers(dateString);

        assertTrue(onlyNumbers);
    }
}