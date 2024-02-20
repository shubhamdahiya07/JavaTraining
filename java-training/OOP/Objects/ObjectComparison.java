package OOP.Objects;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Student {
    final int uid;
    String name;
    double scorePercent;

    Student(int uid, String name, double scorePercent) {
        this.uid = uid;
        this.name = name;
        this.scorePercent = scorePercent;
    }

    @Override
    public boolean equals(Object obj) {
        // checking references of objects
        if (this == obj)
            return true;

        if (obj == null || this.getClass() != obj.getClass())
            return false;

        // type cast before comparing attributes
        Student student = (Student) obj;
        return (student.uid == this.uid);
    }

    @Override
    public int hashCode() {
        /*
        hashCode() method returns an integer value
        that is used in hashing based collections like HashMap, HashSet
        etc.

        Must be overridden by any class which overrides equals() method
        */
        return uid;
    }
}

class ClassRoom {
    final int standard;
    final char section;
    Set<Student> studentSet;

    ClassRoom(int standard, char section) {
        this.standard = standard;
        this.section = section;
        studentSet = new HashSet<>();
    }

    void printClassRoom() {
        System.out.println("Class: " + standard + "\tSection: " + section);
        System.out.println("________________________________________");
        for (Student s : studentSet) {
            System.out.println(s.uid + "\t" + s.name + "\t" + s.scorePercent);
        }
        System.out.println("________________________________________");
    }

}
public class ObjectComparison {
    public static void main(String[] args) {
        ClassRoom classRoom = new ClassRoom(12, 'A');
        classRoom.studentSet.addAll(Arrays.asList(
                new Student(101, "Akash", 93.2),
                new Student(102, "Aditya", 92.9),
                new Student(103, "Shivam", 98.0),
                new Student(104, "Kartik", 81.8),
                new Student(105, "Priya", 89.5),
                new Student(106, "Ritika", 98.9)
        ));

        classRoom.printClassRoom();
        classRoom.studentSet.remove(new Student(101, "", 0.0));
        classRoom.studentSet.add(new Student(101, "Vansh", 90.0));
        classRoom.printClassRoom();
    }
}
