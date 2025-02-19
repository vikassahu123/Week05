package org.example.Problem8;



import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.util.Map;

    public class ReadJSONFile { // Follow your naming pattern
        public static void main(String[] args) {
            try {
                // Read JSON file
                FileReader reader = new FileReader("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\Problem8\\data.json");

                // Parse JSON
                JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();

                // Print all keys and values
                printJson(jsonObject, "");

                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Recursive method to print JSON keys and values
        public static void printJson(JsonObject jsonObject, String parentKey) {
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                String key = parentKey.isEmpty() ? entry.getKey() : parentKey + "." + entry.getKey();
                JsonElement value = entry.getValue();

                if (value.isJsonObject()) {
                    // If value is an object, recursively print nested keys
                    printJson(value.getAsJsonObject(), key);
                } else {
                    // Print key-value pair
                    System.out.println(key + " : " + value);
                }
            }
        }
    }

