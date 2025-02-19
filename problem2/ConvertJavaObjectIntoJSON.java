//Convert a Java object (Car) into JSON format.

package org.example.problem2;

import com.google.gson.Gson;

class Car {
    private String name;
    private String model;
    private int price;

    public Car(String name,String model,int price)
    {
        this.name=name;
        this.model=model;
        this.price=price;

    }
}
public class ConvertJavaObjectIntoJSON {
    public static void main(String[] args) {

        Car car=new Car("MG","299b",900000);

        Gson gson=new Gson();
        String json=gson.toJson(car);

        System.out.println(json);
    }
}
