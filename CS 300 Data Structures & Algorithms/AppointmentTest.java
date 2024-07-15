
import static org.junit.jupiter.api.Assertions.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppointmentTest {
    @Test
    void testIdTooLong() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Appointment appointment = new Appointment(
                            "abcdefghijk",
                            "10-23-2022",
                            "Just a test"
                    );
                }
        );
    }

    @Test
    void testIdNull() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> {
                    Appointment appointment = new Appointment(
                            null,
                            "10-23-2022",
                            "Just a test"
                    );
                }
        );
    }

    @Test
    void testDateInThePast() {
        Assertions.assertThrows(
                DateTimeException.class,
                () -> {
                    Appointment appointment = new Appointment(
                            "gey6gf",
                            "2023-03-27",
                            "This is a test"
                    );
                }
        );
    }

    @Test
    void testDateNull() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> {
                    Appointment appointment = new Appointment(
                            "gey6gf",
                            null,
                            "This is a test"
                    );
                }
        );
    }

    @Test
    void testDescriptionTooLong() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Appointment appointment = new Appointment(
                            "geyoigf",
                            "2023-04-29",
                            "Now is the time for all men to come together as one"
                    );
                }
        );
    }

    @Test
    void testDescriptionNull() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> {
                    Appointment appointment = new Appointment("gey6gf", "2023-04-27", null);
                }
        );
    }

    @Test
    void testUpdateDate() {
        Appointment appointment = new Appointment("gey6gf", "2023-04-27", "This is a test");
        appointment.updateDate("2023-05-01");
        assertEquals(LocalDate.parse("2023-05-01"), appointment.getDate());
    }

    @Test
    void testUpdateDescription() {
        Appointment appointment = new Appointment("gey6gf", "2023-04-27", "This is a test");
        appointment.updateDescription("Updated description");
        assertEquals("Updated description", appointment.getDescription());
    }
}
