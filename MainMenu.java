import java.io.*;
import java.util.*;

public class MainMenu {
    private static final String FILE_NAME = "events.ser";
    private static List<Event> events = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadData();
        int choice;

        do {
            printMenu();
            choice = getIntInput("Enter  choice: ");

            switch (choice) {
                case 1 -> listAllEvents();
                case 2 -> listIndividualEvent();
                case 3 -> editEvent();
                case 4 -> deleteEvent();
                case 5 -> listAttendees();
                case 6 -> addAttendee();
                case 7 -> deleteAttendee();
                case 8 -> addEvent();
                case 0 -> {
                    saveData();
                    System.out.println("Exiting application Goodbye...");
                }
                default -> System.out.println("Invalid choice! Please choose a valid choice");
            }
        } while (choice != 0);
    }

    // ================= MENU =================
    private static void printMenu() {
        System.out.println("\n********** MENU **************");
        System.out.println("1. List All Events");
        System.out.println("2. List Individual Event");
        System.out.println("3. Edit Event");
        System.out.println("4. Delete Event");
        System.out.println("5. List Attendees Attending an Event");
        System.out.println("6. Add an Attendee to an Event");
        System.out.println("7. Delete an Attendee from an Event");
        System.out.println("8. Add New Event");
        System.out.println("0. Exit");
    }

    // ================= FEATURES =================
    private static void addEvent() {
        int id = getIntInput("Enter Event ID Please: ");
        System.out.print("Enter Event Name Please: ");
        String name = sc.nextLine();
        events.add(new Event(id, name));
        saveData();
    }

    private static void listAllEvents() {
        events.forEach(System.out::println);
    }

    private static void listIndividualEvent() {
        int id = getIntInput("Enter Event ID Please: ");
        events.stream()
                .filter(e -> e.getEventId() == id)
                .findFirst()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Event not Available"));
    }

    private static void editEvent() {
        int id = getIntInput("Enter Event ID Please: ");
        for (Event e : events) {
            if (e.getEventId() == id) {
                System.out.print("Enter new Event Name Please: ");
                e.setEventName(sc.nextLine());
                saveData();
                return;
            }
        }
        System.out.println("Event not found");
    }

    private static void deleteEvent() {
        int id = getIntInput("Enter Event ID Please: ");
        events.removeIf(e -> e.getEventId() == id);
        saveData();
    }

    private static void listAttendees() {
        int id = getIntInput("Enter Event ID Please: ");
        events.stream()
                .filter(e -> e.getEventId() == id)
                .findFirst()
                .ifPresent(e -> e.getAttendees().forEach(System.out::println));
    }

    private static void addAttendee() {
        int eventId = getIntInput("Enter Event ID: ");
        for (Event e : events) {+
            if (e.getEventId() == eventId) {
                int id = getIntInput("Enter Attendee ID: ");
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Sex: ");
                String sex = sc.nextLine();
                int age = getIntInput("Enter Age: ");

                e.addAttendee(new Attendee(id, name, sex, age));
                saveData();
                return;
            }
        }
        System.out.println("Event not found");
    }

    private static void deleteAttendee() {
        int eventId = getIntInput("Enter Event ID: ");
        int attendeeId = getIntInput("Enter Attendee ID: ");

        for (Event e : events) {
            if (e.getEventId() == eventId) {
                e.removeAttendee(attendeeId);
                saveData();
                return;
            }
        }
        System.out.println("Event not Avalable");
    }

    // ================= EXCEPTION HANDLING =================
    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number!!!! Please Try again.");
            }
        }
    }

    // ================= SERIALIZATION =================
    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(events);
        } catch (IOException e) {
            System.out.println("Error saving data");
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadData() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            events = (List<Event>) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading data");
        }
    }
}
