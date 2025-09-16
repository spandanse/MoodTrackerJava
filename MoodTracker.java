import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class MoodTracker {

    private static ArrayList<Mood> moods = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("       Welcome to Mood Tracker      ");
        System.out.println("====================================");

        while (true) {
            displayMenu();
            String choice = sc.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a": addMood(); break;
                case "d": deleteMoodByDate(); break;
                case "x": deleteMoodByAllDetails(); break;
                case "e": editMoodNotes(); break;
                case "s": searchMoodByDate(); break;
                case "f": searchMoodByAllDetails(); break;
                case "v": viewAllMoods(); break;
                case "w": writeMoodsToFile(); break;
                case "exit": System.out.println("Exiting... Goodbye!"); return;
                default: System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Display user menu
    private static void displayMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("a - Add Mood");
        System.out.println("d - Delete Mood by Date");
        System.out.println("x - Delete Mood by All Details");
        System.out.println("e - Edit Mood Notes");
        System.out.println("s - Search Mood by Date");
        System.out.println("f - Search Mood by All Details");
        System.out.println("v - View All Moods");
        System.out.println("w - Write Moods to File");
        System.out.println("Type 'Exit' to quit.");
        System.out.print("Your choice: ");
    }

    // Add mood with validation
    private static void addMood() {
        try {
            System.out.print("Enter mood name: ");
            String name = sc.nextLine();

            System.out.print("Enter date (yyyy-MM-dd): ");
            LocalDate date = LocalDate.parse(sc.nextLine());

            System.out.print("Enter time (HH:mm): ");
            LocalTime time = LocalTime.parse(sc.nextLine());

            System.out.print("Enter notes: ");
            String notes = sc.nextLine();

            Mood newMood = new Mood(name, date, time, notes);

            // Check if mood already exists
            if (moods.contains(newMood)) {
                throw new Exception("Mood at this date and time already exists!");
            }

            moods.add(newMood);
            System.out.println("✅ Mood added successfully.");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Edit mood notes
    private static void editMoodNotes() {
        try {
            Mood mood = findMoodByDetails();
            if (mood != null) {
                System.out.print("Enter new notes: ");
                String notes = sc.nextLine();
                mood.setNotes(notes);
                System.out.println("✅ Notes updated successfully.");
            } else {
                System.out.println("❌ Mood not found.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // Delete mood by date
    private static void deleteMoodByDate() {
        System.out.print("Enter date (yyyy-MM-dd) to delete moods: ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        moods.removeIf(m -> m.getDate().equals(date));
        System.out.println("✅ All moods on " + date + " deleted.");
    }

    // Delete mood by all details
    private static void deleteMoodByAllDetails() {
        Mood mood = findMoodByDetails();
        if (mood != null && moods.remove(mood)) {
            System.out.println("✅ Mood deleted successfully.");
        } else {
            System.out.println("❌ Mood not found.");
        }
    }

    // Search mood by date
    private static void searchMoodByDate() {
        System.out.print("Enter date (yyyy-MM-dd) to search: ");
        LocalDate date = LocalDate.parse(sc.nextLine());

        System.out.println("\nMoods on " + date + ":");
        moods.stream().filter(m -> m.getDate().equals(date))
                     .forEach(System.out::println);
    }

    // Search mood by all details
    private static void searchMoodByAllDetails() {
        Mood mood = findMoodByDetails();
        if (mood != null) {
            System.out.println("✅ Mood found: " + mood);
        } else {
            System.out.println("❌ Mood not found.");
        }
    }

    // View all moods
    private static void viewAllMoods() {
        System.out.println("\nAll tracked moods:");
        if (moods.isEmpty()) {
            System.out.println("No moods recorded yet.");
        } else {
            moods.forEach(System.out::println);
        }
    }

    // Write moods to file
    private static void writeMoodsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("moodtracker.txt"))) {
            for (Mood m : moods) {
                writer.println(m);
            }
            System.out.println("✅ Moods saved to moodtracker.txt successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Helper method to find mood by name, date, and time
    private static Mood findMoodByDetails() {
        try {
            System.out.print("Enter mood name: ");
            String name = sc.nextLine();

            System.out.print("Enter date (yyyy-MM-dd): ");
            LocalDate date = LocalDate.parse(sc.nextLine());

            System.out.print("Enter time (HH:mm): ");
            LocalTime time = LocalTime.parse(sc.nextLine());

            Mood temp = new Mood(name, date, time, "");
            for (Mood m : moods) {
                if (m.equals(temp)) {
                    return m;
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input format.");
        }
        return null;
    }
}