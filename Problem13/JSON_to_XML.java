package org.example.Problem13;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public static void main(String[] args) {
        String jsonFilePath = "D:\\Week05\\Day02\\src\\main\\java\\org\\example\\problem15\\data.sql"; // Use relative path

        try {
            File jsonFile = new File(jsonFilePath);

            // Check if file exists
            if (!jsonFile.exists()) {
                System.err.println(" Error: JSON file not found at " + jsonFilePath);
                return;
            }

            // Create ObjectMapper for JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Read JSON file into JsonNode
            JsonNode jsonNode = objectMapper.readTree(jsonFile);

            // Convert JSON to XML
            XmlMapper xmlMapper = new XmlMapper();
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            // Print XML output
            System.out.println("Successfully converted JSON to XML:\n" + xml);

        } catch (IOException e) {
            System.err.println(" Error processing JSON file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
