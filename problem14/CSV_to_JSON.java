package org.example.problem14;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

    public class CSV_to_JSON {  // Follow your naming pattern
        public static void main(String[] args) {
            String csvFilePath = "src/main/java/org/example/Problem14/data.csv"; // Use relative path

            try {
                // Create CsvMapper and define schema (first row as headers)
                CsvMapper csvMapper = new CsvMapper();
                CsvSchema schema = CsvSchema.emptySchema().withHeader();

                // Read CSV into List of Maps
                MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class)
                        .with(schema)
                        .readValues(new File(csvFilePath));

                List<Map<String, String>> dataList = iterator.readAll();

                // Convert List to JSON
                ObjectMapper jsonMapper = new ObjectMapper();
                String json = jsonMapper.writerWithDefaultPrettyPrinter().writeValueAsString(dataList);

                // Print JSON output
                System.out.println(" Successfully converted CSV to JSON:\n" + json);

            } catch (IOException e) {
                System.err.println(" Error processing CSV file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

