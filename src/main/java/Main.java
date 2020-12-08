import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Петя", "Вася", "Коля", "Миша", "Саша", "Гоша"};
        String[] lastNames = {"Петров", "Попов", "Иванов", "Смирнов", "Сидоров"};

        int countOfPersons = 5;

        ArrayList<Student> students = new ArrayList<Student>();

        Course[] coursesTitle = {new Course("WebXML"),
                new Course("Методология и методы научных исследований"),
                new Course("Современные методы криптографии"),
                new Course("История и философия науки"),
                new Course("Дискретные математические модели")};

        for(int i = 0; i < countOfPersons; i++) {
            Student person = new Student(
                    i,
                    names[(int) (Math.random() * names.length)] + " " + lastNames[(int) Math.random() * lastNames.length],
                    25 - ((i % 2 == 0 ? 1 : 0) + i % 3 == 0 ? 2: 0),
                    coursesTitle
            );
            students.add(person);
        }

        JSONArray ja = new JSONArray();
        for(Student s: students) {
            JSONObject jo = new JSONObject();
            JSONArray jCourse = new JSONArray();
            for(Course c : s.courses)
                jCourse.put(c.getTitle());
            jo.put("id",s.id);
            jo.put("name",s.name);
            jo.put("age", s.age);
            jo.put("course", jCourse);
            ja.put(jo);
        }
        SaveToFile(ja.toString());
    }

    static void SaveToFile(String data) {
        try {
            FileWriter myWriter = new FileWriter("Students.json");
            myWriter.write(data);
            myWriter.close();
            System.out.println("JSON was wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
