package org.example.problem10;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

    class User {
        public String name;
        public int age;
        public String email;
    }

public class FilterJSON { // Follow your naming pattern
        public static void main(String[] args) {
            try {
                // Read and parse JSON file
                ObjectMapper objectMapper = new ObjectMapper();
                List<User> users = objectMapper.readValue(new File("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\problem10\\data.json"), new TypeReference<List<User>>() {});

                // Filter users older than 25
                List<User> filteredUsers = users.stream()
                        .filter(user -> user.age > 25)
                        .collect(Collectors.toList());

                // Print filtered users
                filteredUsers.forEach(user ->
                        System.out.println(user.name + " - " + user.age + " - " + user.email)
                );

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

