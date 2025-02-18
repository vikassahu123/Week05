package org.example.Advance.Problem1;

import com.sun.jdi.PathSearchingVirtualMachine;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {

        String inputFilePath = " D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\Problem1\\employeeData";

        List<String[]> validRecords = new ArrayList<>();
        List<String[]> invalidRecords = new ArrayList<>();

        // Email and Phone validation regex
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;

            // Read header line
            String[] header = br.readLine().split(",");
            validRecords.add(header); // Store header

            // Read and validate records
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length == 5) { // Ensure row has all required columns
                    String email = values[3].trim();
                    String phone = values[4].trim();

                    if (emailPattern.matcher(email).matches() && phonePattern.matcher(phone).matches()) {
                        validRecords.add(values);
                    } else {
                        invalidRecords.add(values);
                    }
                } else {
                    invalidRecords.add(values);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Print invalid records
        if (!invalidRecords.isEmpty()) {
            System.out.println("Invalid records:");
            for (String[] record : invalidRecords) {
                System.out.println(String.join(",", record) + " - Error: Invalid email or phone number");
            }
        }

        // Sort valid records by salary in descending order
        validRecords.sort((a, b) -> Double.compare(Double.parseDouble(b[2].trim()), Double.parseDouble(a[2].trim())));

        // Print top 5 highest-paid employees
        System.out.println("Top 5 highest-paid employees:");
        for (int i = 0; i < Math.min(6, validRecords.size()); i++) { // Include header + top 5 records
            System.out.println(String.join(",", validRecords.get(i)));
        }
    }
}
