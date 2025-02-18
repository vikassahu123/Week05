package org.example.Intermediate.Problem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchForRecord {
    public static void main(String[] args) {

        String filePath = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Intermediate\\Problem2\\dataFile";

        try {
            String searchName = "vikas";
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            if ((line = br.readLine()) != null) {
                System.out.println(line); // Print header
            }

            boolean flag = false;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                String name = data[1].trim();

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.println("Department: " + data[2] + ", Salary: " + data[3]);

                    flag = true;
                    break;
                }

            }
            if (!flag) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid CSV format.");
        }

    }
}
