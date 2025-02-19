package org.example.Problem4;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MergeJSONObjects {
  // Follow your naming pattern
    public static void main(String[] args) {
        // Define two JSON objects as Strings
        String json1 = "{ \"name\": \"Alice\", \"age\": 25 }";
        String json2 = "{ \"email\": \"alice@example.com\", \"city\": \"New York\" }";

        // Parse them into JsonObjects
        JsonObject obj1 = JsonParser.parseString(json1).getAsJsonObject();
        JsonObject obj2 = JsonParser.parseString(json2).getAsJsonObject();

        // Merge obj2 into obj1
        obj2.entrySet().forEach(entry -> obj1.add(entry.getKey(), entry.getValue()));

        // Print merged JSON object
        System.out.println(obj1);
    }
}
