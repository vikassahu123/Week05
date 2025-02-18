package org.example.Advance.Problem6;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Problem: Fetch employee records from a database and write them into a CSV file.
// Include headers: Employee ID, Name, Department, Salary.

public class ReportFromDataBase {
    public static void main(String[] args) {
        String jdbcURL = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\Problem6\\sqlFile"; // Change DB name
        String username = "root"; // Change username if needed
        String password = "password"; // Change password
        String csvFile = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\Problem6\\employee";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             FileWriter writer = new FileWriter(csvFile)) {

            String query = "SELECT employee_id, name, department, salary FROM employees";
            ResultSet resultSet = stmt.executeQuery(query);

            // Write CSV headers
            writer.write("Employee ID,Name,Department,Salary\n");

            // Write each row to CSV
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                writer.write(id + "," + name + "," + department + "," + salary + "\n");
            }

            System.out.println("CSV report generated: " + csvFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
