package org.example.Basic.Problem2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;

public class WriteDataCSV {
    public static void main(String[] args) {
        String filePath="D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Basic\\Problem2\\writeData";

        try{
            BufferedWriter Bw=new BufferedWriter(new FileWriter(filePath));

           Bw.write("Id,name, department,salary\n");
           Bw.write("101,vikas,HR,90000\n");
           Bw.write("102,NAYAN,TR,45000\n");
           Bw.write("103,BHANU,IT,50000\n");
           Bw.write("104,RUPESH,SALES\n");
            System.out.println("Write data succesfully");

Bw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }



    }
}
