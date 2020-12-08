import java.util.ArrayList;

public class Student {
    Integer id;
    String name;
    Integer age;
    Course[] courses;

    public Student(Integer id, String name, Integer age, Course[] courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }
}
