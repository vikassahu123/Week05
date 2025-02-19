package org.example.problem12;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

    public class MergeJSON2 {  // Follow your naming pattern
        public static void main(String[] args) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();

                // Read JSON files
                JsonNode json1 = objectMapper.readTree(new File("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\problem12\\FIRST.JSON"));
                JsonNode json2 = objectMapper.readTree(new File("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\problem12\\SECOND.JSON"));

                // Merge JSON objects
                JsonNode mergedJson = mergeJson(json1, json2);

                // Print merged JSON
                System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static JsonNode mergeJson(JsonNode json1, JsonNode json2) {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode merged = objectMapper.createObjectNode();

            // Copy fields from json1
            ((com.fasterxml.jackson.databind.node.ObjectNode) merged).setAll((com.fasterxml.jackson.databind.node.ObjectNode) json1);

            // Copy fields from json2 (overwrites duplicate keys)
            ((com.fasterxml.jackson.databind.node.ObjectNode) merged).setAll((com.fasterxml.jackson.databind.node.ObjectNode) json2);

            return merged;
        }
    }
