package org.example.problem3;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;


public class ReadJSONFile {
    public static void main(String[] args) {

        try {
            FileReader fileReader=new FileReader("D:\\Week05\\Day02\\src\\main\\java\\org\\example\\problem3\\data.JSON");

            JsonObject jsonObject=JsonParser.parseReader(fileReader).getAsJsonObject();

            String name=jsonObject.get("name").getAsString();
            String email=jsonObject.get("email").getAsString();

            System.out.println("name : "+name);
            System.out.println("email: "+email);

            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
