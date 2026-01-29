import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Event implements Serializable {
    private int eventId;
    private String eventName;
    private List<Attendee> attendees;

    public Event(int eventId, String eventName) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.attendees = new ArrayList<>();
    }

    public int getEventId() {
        return eventId;
    }

    public List<Attendee> getAttendees() {
        return attendees;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

    public void removeAttendee(int attendeeId) {
        attendees.removeIf(a -> a.getId() == attendeeId);
    }

    @Override
    public String toString() {
        return "Event ID: " + eventId + ", Event Name: " + eventName;
    }
}
