import java.io.Serializable;

public class Attendee implements Serializable {
    private int id;
    private String name;
    private String sex;
    private int age;

    public Attendee(int id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Attendee ID: " + id +
                ", Name: " + name +
                ", Sex: " + sex +
                ", Age: " + age;
    }
}
