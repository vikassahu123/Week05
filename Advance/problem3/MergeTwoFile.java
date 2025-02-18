package org.example.Advance.problem3;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Problem: Merge two CSV files based on ID and create a new file containing all details.

public class MergeTwoFile {

public static void main(String[] args) {
        String file1 = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\problem3\\first"; // Path to the first CSV file
        String file2 = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\problem3\\second"; // Path to the second CSV file
        String outputFile = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\problem3\\outputFile"; // Path to the output file

        Map<String, String[]> studentDataMap = new HashMap<>();

        // Read the first file (students1.csv) and store data in a map
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                String name = values[1];
                String age = values[2];
                studentDataMap.put(id, new String[]{name, age});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read the second file (students2.csv) and merge data based on ID
        try (BufferedReader br = new BufferedReader(new FileReader(file2));
             FileWriter writer = new FileWriter(outputFile)) {

            String line;
            writer.write("ID,Name,Age,Marks,Grade\n"); // Write header for merged file
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                String marks = values[1];
                String grade = values[2];

                // Get name and age from the first file using ID
                String[] studentInfo = studentDataMap.get(id);
                if (studentInfo != null) {
                    String name = studentInfo[0];
                    String age = studentInfo[1];

                    // Write the merged data into the new file
                    writer.write(id + "," + name + "," + age + "," + marks + "," + grade + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Files merged successfully into " + outputFile);
    }
}

