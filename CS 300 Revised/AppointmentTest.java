import static org.junit.jupiter.api.Assertions.*;
import java.time.DateTimeException;
import org.junit.jupiter.api.Test;

class AppointmentTest {
    @Test
    void testIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("abcdefghijk", "2023-04-07", "Just a test"));
    }

    @Test
    void testIdNull() {
        assertThrows(NullPointerException.class, () -> new Appointment(null, "2023-04-07", "Just a test"));
    }

    @Test
    void testDateInThePast() {
        assertThrows(DateTimeException.class, () -> new Appointment("id123", "2022-03-27", "This is a test"));
    }

    @Test
    void testDateNull() {
        assertThrows(NullPointerException.class, () -> new Appointment("id123", null, "This is a test"));
    }

    @Test
    void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("id123", "2023-04-29", "This description is way too long and should throw an exception."));
    }

    @Test
    void testDescriptionNull() {
        assertThrows(NullPointerException.class, () -> new Appointment("id123", "2023-04-27", null));
    }

    @Test
    void testUpdateDate() {
        Appointment appointment = new Appointment("id123", "2023-04-27", "This is a test");
        appointment.updateDate("2023-05-01");
        assertEquals(LocalDate.parse("2023-05-01"), appointment.getDate());
    }

    @Test
    void testUpdateDescription() {
        Appointment appointment = new Appointment("id123", "2023-04-27", "This is a test");
        appointment.updateDescription("Updated description");
        assertEquals("Updated description", appointment.getDescription());
    }
}
