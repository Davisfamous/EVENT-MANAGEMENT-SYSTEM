Event Management System – Java Console Application Project Description This project is a console-based Event Management System developed using Java. The application gives users the ability to create and manage events and attendees through a console menu interface.

Project Structure EventManagement/ *Attendee.java *Event.java *MainMenu.java events.ser

The primary objective of this project is to demonstrate core Java concepts, including object-oriented programming, collections, exception handling, and serialization.

All data is saved using serialization in events.ser file so that events and attendees are not lost and memory is saved.

Goals: This project demonstrates the following concepts:

Use of Array List Use of classes and objects Adding, editing, deleting, and viewing data

Providing solutions for situations when user inputs are invalid using exception handling. The code returns a custom error message

Saving and loading data using serialization and deserialization

Class Overview Attendee.java

This class represents an attendee who can go to an event.

Fields:id,name,sex,age

The class implements Serializable so attendee data is saved to a file named events.ser.

Event.java

This class represents an event.

Fields:eventId,eventName,list of attendees Each event can have multiple attendees.

MainMenu.java

This is the main class that runs the application. It contains:

The menu logic

Methods to edit, delete, list events, and add events

Serialization and deserialization

Menu Options

List All Events
List Individual Event
Edit Event
Delete Event
List Attendees Attending an Event
Add an Attendee to an Event
Delete an Attendee from an Event
Add New Event
Exit
Features list all events list individual events edit event delete event list attendees for an event Provides error message when wrong value is inputed

Invalid sex input

Use the menu options to interact with the system

Notes

The events.ser file is a binary file and should not be edited manually

Deleting the file will reset all saved data

No external libraries are used; the project is based only on Java

Conclusion

This project provides a complete example of a console menu Java application. It shows use of OOP concepts, input validation, exception handling, and serialization and deserialization,
