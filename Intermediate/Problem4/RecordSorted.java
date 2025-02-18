package org.example.Intermediate.Problem4;

import java.util.*;
import java.io.*;

public class RecordSorted {
    public static void main(String[] args) {
        String inputFilePath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Intermediate\\Problem4\\dataFile";

                List<String[]> records = new ArrayList<>();
                List<String[]> data = new ArrayList<>(); // Stores actual data rows
                String[] header = null;

                try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
                    String line;

                    // Read header line
                    if ((line = br.readLine()) != null) {
                        header = line.split(",");
                    }

                    // Read and store records
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(",");
                        if (values.length >= 4) { // Ensure valid row
                            data.add(values);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + e.getMessage());
                    return;
                }

                // Sort records by salary in descending order
                data.sort((a, b) -> {
                    try {
                        return Double.compare(Double.parseDouble(b[3].trim()), Double.parseDouble(a[3].trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid salary format.");
                        return 0;
                    }
                });

                // Print top 5 highest-paid employees
                System.out.println("Top 5 highest-paid employees:");
                if (header != null) {
                    System.out.println(String.join(",", header)); // Print header
                }

                for (int i = 0; i < Math.min(5, data.size()); i++) {
                    System.out.println(String.join(",", data.get(i)));
                }
            }
        }
