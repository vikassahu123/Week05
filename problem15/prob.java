package org.example.problem15;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

public class prob {  // Follow your naming pattern
        public static void main(String[] args) {
            String jdbcUrl = "jdbc:mysql://localhost:3306/your_database"; // Replace with your DB name
            String username = "root";
            String password = "your_password";  // Change accordingly

            String jsonFilePath = "src/main/java/org/example/Problem15/report.json"; // Output file

            try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

                List<Map<String, Object>> records = new ArrayList<>();

                // Read database records into a list
                while (rs.next()) {
                    Map<String, Object> row = new HashMap<>();
                    row.put("id", rs.getInt("id"));
                    row.put("name", rs.getString("name"));
                    row.put("age", rs.getInt("age"));
                    row.put("email", rs.getString("email"));
                    records.add(row);
                }

                // Convert list to JSON
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(records);

                // Write JSON to a file
                objectMapper.writeValue(new File(jsonFilePath), records);

                System.out.println("✅ JSON report generated successfully: " + jsonFilePath);
                System.out.println(json);

            } catch (SQLException | IOException e) {
                System.err.println("❌ Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

