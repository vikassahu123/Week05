package org.example.problem11;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;

import java.util.Set;

    public class ValidEmail2 {  // Follow your naming pattern
        public static void main(String[] args) {
            try {
                // Define JSON Schema
                String schemaJson = "{"
                        + "\"$schema\": \"https://json-schema.org/draft/2020-12/schema\","
                        + "\"type\": \"object\","
                        + "\"properties\": {"
                        + "\"email\": { \"type\": \"string\", \"format\": \"email\" }"
                        + "},"
                        + "\"required\": [\"email\"]"
                        + "}";

                // Sample JSON Data (Modify for testing)
                String validJson = "{ \"email\": \"test@example.com\" }";
                String invalidJson = "{ \"email\": \"invalid-email\" }"; // Invalid email

                // Validate JSON
                validateJson(schemaJson, validJson);
                validateJson(schemaJson, invalidJson);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void validateJson(String schemaJson, String jsonData) throws Exception {
            ObjectMapper objectMapper = new ObjectMapper();

            // Parse Schema and JSON Data
            JsonSchemaFactory schemaFactory = JsonSchemaFactory.getInstance();
            JsonSchema schema = schemaFactory.getSchema(objectMapper.readTree(schemaJson));
            JsonNode jsonNode = objectMapper.readTree(jsonData);

            // Perform Validation
            Set<ValidationMessage> errors = schema.validate(jsonNode);

            if (errors.isEmpty()) {
                System.out.println("Valid JSON: " + jsonData);
            } else {
                System.out.println(" Invalid JSON: " + jsonData);
                errors.forEach(error -> System.out.println("Error: " + error.getMessage()));
            }
        }
    }

