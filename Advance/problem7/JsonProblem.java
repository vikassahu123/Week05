package org.example.Advance.problem7;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.*;
        import java.util.Arrays;

// Problem: Convert JSON to CSV and vice versa.
// Read a JSON file containing a list of students, convert it into CSV, and save it.
// Then, read the CSV file and convert it back to JSON.

public class JsonProblem {
    public static void main(String[] args) {
        String jsonFile = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\problem7\\student.json";
        String csvFile = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\problem7\\csvFile.csv";
        String convertedJsonFile = "D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Advance\\problem7\\converted.json";

        // Convert JSON to CSV
        jsonToCsv(jsonFile, csvFile);

        // Convert CSV back to JSON
        csvToJson(csvFile, convertedJsonFile);
    }

    // Convert JSON to CSV
    public static void jsonToCsv(String jsonFile, String csvFile) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonArray = objectMapper.readTree(new File(jsonFile));

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
                writer.write("ID,Name,Age,Marks,Grade\n"); // Write CSV header

                for (JsonNode student : jsonArray) {
                    writer.write(student.get("ID").asText() + "," +
                            student.get("Name").asText() + "," +
                            student.get("Age").asText() + "," +
                            student.get("Marks").asText() + "," +
                            student.get("Grade").asText() + "\n");
                }
            }
            System.out.println("JSON converted to CSV successfully: " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Convert CSV to JSON
    public static void csvToJson(String csvFile, String jsonFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(jsonFile))) {

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode jsonArray = objectMapper.createArrayNode();

            String line;
            reader.readLine(); // Skip header line

            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                JsonNode student = objectMapper.createObjectNode()
                        .put("ID", values[0])
                        .put("Name", values[1])
                        .put("Age", values[2])
                        .put("Marks", values[3])
                        .put("Grade", values[4]);
                jsonArray.add(student);
            }

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(writer, jsonArray);
            System.out.println("CSV converted to JSON successfully: " + jsonFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
