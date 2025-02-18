package org.example.Advance.Problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

        class Student {
            private String name;
            private int age;
            private String grade;

            // Constructor
            public Student(String name, int age, String grade) {
                this.name = name;
                this.age = age;
                this.grade = grade;
            }

            // Getter methods
            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public String getGrade() {
                return grade;
            }

            @Override
            public String toString() {
                return "Student{name='" + name + "', age=" + age + ", grade='" + grade + "'}";
            }
        }

public class ConvertIntoJavaObject {
    public static void main(String[] args) {
                String csvFile = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\Problem2\\data"; // Path to the CSV file
                String line;
                String delimiter = ",";
                List<Student> students = new ArrayList<>();

                try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
                    // Read header line if present
                    br.readLine();

                    // Read each line of the CSV
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(delimiter);

                        // Create a new Student object and add to the list
                        String name = values[0];
                        int age = Integer.parseInt(values[1]);
                        String grade = values[2];

                        students.add(new Student(name, age, grade));
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Print the Student objects
                for (Student student : students) {
                    System.out.println(student);
                }
            }
        }