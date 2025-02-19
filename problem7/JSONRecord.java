package org.example.problem7;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

    class Person {
        String name;
        int age;
        String email;
    }

    public class JSONRecord {  // Follow your naming pattern
        public static void main(String[] args) {
            try {
                // Read and parse JSON file
                Gson gson = new Gson();
                FileReader reader = new FileReader("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\problem7\\data.JSON");

                // Convert JSON array to List of Person objects
                List<Person> people = gson.fromJson(reader, new TypeToken<List<Person>>() {}.getType());

                // Filter records where age > 25
                List<Person> filteredPeople = people.stream()
                        .filter(person -> person.age > 25)
                        .collect(Collectors.toList());

                // Print filtered results
                filteredPeople.forEach(person ->
                        System.out.println(person.name + " - " + person.age + " - " + person.email)
                );

                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

