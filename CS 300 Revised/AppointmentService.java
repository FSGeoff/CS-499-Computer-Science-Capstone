import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> allAppointments = new ArrayList<>();

    // Add new appointment
    public void addAppointment(String id, String date, String description) {
        Appointment myAppointment = new Appointment(id, date, description);
        allAppointments.add(myAppointment);
    }

    // Update existing appointment by ID
    public boolean updateAppointment(String id, String newDate, String newDescription) {
        Appointment appointment = getAppointmentsById(id);
        if (appointment != null) {
            appointment.updateDate(newDate);
            appointment.updateDescription(newDescription);
            return true;
        }
        return false;
    }

    // Search appointment by ID
    public Appointment getAppointmentsById(String id) {
        for (Appointment appointment : allAppointments) {
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        return null; // Return null if not found
    }

    // Get all appointments
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(allAppointments);
    }

    // Delete appointment by ID
    public boolean deleteAppointmentPerId(String id) {
        Appointment appointment = getAppointmentsById(id);
        if (appointment != null) {
            allAppointments.remove(appointment);
            return true;
        }
        return false;
    }
}
