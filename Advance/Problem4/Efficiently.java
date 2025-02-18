package org.example.Advance.Problem4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class Efficiently {
        public static void main(String[] args) {
            String filePath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\Problem4\\LargeFile"; // Path to the large CSV file
            int chunkSize = 100; // Number of lines to process at a time
            int totalRecordsProcessed = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                int lineCount = 0;

                // Read the file in chunks of 100 lines
                while ((line = br.readLine()) != null) {
                    lineCount++;

                    // Process every 100 lines
                    if (lineCount % chunkSize == 0) {
                        totalRecordsProcessed += chunkSize;
                        System.out.println("Processed " + totalRecordsProcessed + " records.");
                    }
                }

                // If the total number of lines is not a multiple of 100, process the remaining lines
                if (lineCount % chunkSize != 0) {
                    totalRecordsProcessed += lineCount % chunkSize;
                    System.out.println("Processed " + totalRecordsProcessed + " records.");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }