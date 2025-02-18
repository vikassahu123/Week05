package org.example.Basic.Problem1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSVFile {
    public static void main(String[] args)  {
       String filePath="D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Basic\\Problem1\\empdata.csv";

       try {
           FileReader fr = new FileReader(filePath);
           BufferedReader br=new BufferedReader(fr);
           String line;
           while((line= br.readLine())!=null)
           {

              String[] data=line.split(",");
               for(String it:data){
                   System.out.print(it+" ");
               }
               System.out.println();

           }

       }
        catch(IOException e1)
           {
               System.out.println(e1.getMessage());
           }


    }
}
