package Module5;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Appointment {
    private final String id;
    private LocalDate date;
    private String description;

    public Appointment(String id, String date, String description) {
        // Validate input parameters and throw appropriate exceptions
        if (id.length() > 10) {
            throw new IllegalArgumentException("Id cannot be longer than 10 characters");
        }
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        if (LocalDate.parse(date).isBefore(LocalDate.now())) {
            throw new DateTimeException("Cannot enter a date earlier than today");
        }
        if (LocalDate.parse(date) == null) {
            throw new NullPointerException("Date cannot be null");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }
        if (description == null) {
            throw new NullPointerException("Description cannot be null");
        }

        this.id = id;
        this.date = LocalDate.parse(date);
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void updateDate(String newDate) {
        // Validate the new date and update the appointment
        if (LocalDate.parse(newDate).isBefore(LocalDate.now())) {
            throw new DateTimeException("Cannot enter a date earlier than today");
        }
        this.date = LocalDate.parse(newDate);
    }

    public String getDescription() {
        return description;
    }

    public void updateDescription(String newDescription) {
        // Validate the new description and update the appointment
        if (newDescription.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }
        this.description = newDescription;
    }
}
