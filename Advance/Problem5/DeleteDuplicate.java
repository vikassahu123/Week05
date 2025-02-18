package org.example.Advance.Problem5;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Problem: Read a CSV file and detect duplicate entries based on the ID column.
// Print all duplicate records.

public class DeleteDuplicate {
    public static void main(String[] args) {
        String filePath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\Problem5\\student"; // Path to the CSV file
        Map<String, String> recordMap = new HashMap<>(); // Store unique records by ID
        Set<String> duplicateIds = new HashSet<>(); // Store duplicate IDs

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];

                // Check if the ID is already present
                if (recordMap.containsKey(id)) {
                    duplicateIds.add(id); // Mark ID as duplicate
                } else {
                    recordMap.put(id, line); // Store unique records
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print duplicate records
        if (!duplicateIds.isEmpty()) {
            System.out.println("Duplicate records found:");
            for (String id : duplicateIds) {
                System.out.println(recordMap.get(id));
            }
        } else {
            System.out.println("No duplicate records found.");
        }
    }
}