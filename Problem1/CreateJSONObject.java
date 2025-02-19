//Create a JSON object for a Student with fields: name, age, and subjects (array).


package org.example.Problem1;

import com.google.gson.Gson;

import java.sql.SQLOutput;
import java.util.List;

class Student
{
    private String name;
    private int age;
    private List<String> subject;

    public Student(String name,int age,List<String> subject)
    {
        this.name=name;
        this.age=age;
        this.subject=subject;

    }
}

public class CreateJSONObject {
    public static void main(String[] args) {

        Student student = new Student("Vikas Sahu", 22, List.of("Mathematics", "Science", "History"));

        Gson gson=new Gson();
        String json=gson.toJson(student);
        System.out.println(json);

    }
}
