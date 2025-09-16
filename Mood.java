import java.time.LocalDate;
import java.time.LocalTime;

public class Mood {
    private String name;        // Mood name, e.g., Happy, Sad
    private LocalDate date;     // Date of the mood
    private LocalTime time;     // Time of the mood
    private String notes;       // Optional notes

    // Constructor
    public Mood(String name, LocalDate date, LocalTime time, String notes) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }

    // Getters
    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getNotes() {
        return notes;
    }

    // Setters
    public void setNotes(String notes) {
        this.notes = notes;
    }

    // toString method for displaying mood info
    @Override
    public String toString() {
        return "Mood{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", notes='" + notes + '\'' +
                '}';
    }

    // Equality check based on name, date, and time
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Mood)) return false;
        Mood other = (Mood) obj;
        return this.name.equalsIgnoreCase(other.name) &&
               this.date.equals(other.date) &&
               this.time.equals(other.time);
    }
}