import java.time.DateTimeException;
import java.time.LocalDate;

public class Appointment {
    private final String id;
    private LocalDate date;
    private String description;

    // Constructor to initialize Appointment object
    public Appointment(String id, String date, String description) {
        // Validate input parameters and throw appropriate exceptions
        if (id == null) {
            throw new NullPointerException("Id cannot be null");
        }
        if (id.length() > 10) {
            throw new IllegalArgumentException("Id cannot be longer than 10 characters");
        }
        if (date == null) {
            throw new NullPointerException("Date cannot be null");
        }
        if (description == null) {
            throw new NullPointerException("Description cannot be null");
        }
        if (LocalDate.parse(date).isBefore(LocalDate.now())) {
            throw new DateTimeException("Cannot enter a date earlier than today");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
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

    public String getDescription() {
        return description;
    }

    // Update date with validation
    public void updateDate(String newDate) {
        if (newDate == null) {
            throw new NullPointerException("New date cannot be null");
        }
        if (LocalDate.parse(newDate).isBefore(LocalDate.now())) {
            throw new DateTimeException("Cannot enter a date earlier than today");
        }
        this.date = LocalDate.parse(newDate);
    }

    // Update description with validation
    public void updateDescription(String newDescription) {
        if (newDescription == null) {
            throw new NullPointerException("New description cannot be null");
        }
        if (newDescription.length() > 50) {
            throw new IllegalArgumentException("Description cannot be longer than 50 characters");
        }
        this.description = newDescription;
    }

    // Override toString for better representation
    @Override
    public String toString() {
        return "Appointment{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}
