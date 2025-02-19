package org.example.problem5;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

    public class ValidateJSONStructure {
        public static void main(String[] args) {
            // JSON string (valid JSON)
            String validJson = "{ \"name\": \"VIKAS\", \"age\": 25, \"email\": \"alice@example.com\" }";

            // JSON string (invalid JSON)
            String invalidJson = "{ \"name\": \"VIKAS\", \"age\": 25, \"email\": \"alice@example.com\" "; // Missing closing brace

            // Validate JSON
            System.out.println("Valid JSON: " + isValidJson(validJson));
            System.out.println("Invalid JSON: " + isValidJson(invalidJson));
        }

        public static boolean isValidJson(String json) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(json); // Parses JSON, throws exception if invalid
                return jsonNode != null;
            } catch (Exception e) {
                return false; // Invalid JSON
            }
        }
    }

