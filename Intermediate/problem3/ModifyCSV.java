package org.example.Intermediate.problem3;

import java.io.*;
import java.util.*;

public class ModifyCSV {
    public static void main(String[] args) {
        String inputFilePath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Intermediate\\problem3\\employees";
        String outputFilePath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Intermediate\\problem3\\updateData";

        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            // Read header line
            if ((line = br.readLine()) != null) {
                records.add(line.split(",")); // Store header
            }

            // Read and update records
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values[2].trim().equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(values[3].trim());
                    salary *= 1.10; // Increase salary by 10%
                    values[3] = String.format("%.2f", salary);
                }
                records.add(values);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV file.");
            return;
        }

        // Write updated records to a new file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String[] record : records) {
                bw.write(String.join(",", record));
                bw.newLine();
            }
            System.out.println("Updated records saved to " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
