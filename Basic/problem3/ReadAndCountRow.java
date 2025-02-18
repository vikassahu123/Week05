package org.example.Basic.problem3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadAndCountRow {
    public static void main(String[] args) {
        String filePath="D:\\Week05\\Day01\\src\\main\\java\\org\\example\\Basic\\Problem1\\empdata.csv";

        try {
            int countRow=0;
            FileReader fr = new FileReader(filePath);
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line= br.readLine())!=null)
            {


                String[] data=line.split(",");
                for(String it:data){
                    System.out.print(it+" ");

                }
                countRow++;
                System.out.println();

            }
            System.out.println("Total rows present in a CSV file: "+countRow);

        }
        catch(IOException e1)
        {
            System.out.println(e1.getMessage());
        }



    }
}
