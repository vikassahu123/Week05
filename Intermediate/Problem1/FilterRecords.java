package org.example.Intermediate.Problem1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterRecords {
    public static void main(String[] args) {
        String filePath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Intermediate\\Problem1\\dataFile";

        try {

            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            if ((line = br.readLine()) != null) {
                System.out.println(line); // Print header
            }


            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                int marks = Integer.parseInt(data[3]);
                if (marks > 80) {
                    System.out.print(line);
                }
                System.out.println();
            }


        } catch (IOException e1) {
            System.out.println(e1.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in CSV file.");


        }
    }
}

