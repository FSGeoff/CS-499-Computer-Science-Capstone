import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    @Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment("id3456", "2023-04-07", "This is only a test");

        Appointment appointment = service.getAppointmentsById("id3456");
        assertNotNull(appointment);
        assertEquals("id3456", appointment.getId());
        assertEquals("2023-04-07", appointment.getDate().toString());
        assertEquals("This is only a test", appointment.getDescription());
    }

    @Test
    void testUpdateAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment("id3456", "2023-04-07", "This is only a test");

        assertTrue(service.updateAppointment("id3456", "2023-05-01", "Updated description"));
        Appointment updatedAppointment = service.getAppointmentsById("id3456");
        assertEquals("2023-05-01", updatedAppointment.getDate().toString());
        assertEquals("Updated description", updatedAppointment.getDescription());
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        service.addAppointment("id3456", "2023-04-07", "This is only a test");

        assertTrue(service.deleteAppointmentPerId("id3456"));
        assertNull(service.getAppointmentsById("id3456"));
    }
}
