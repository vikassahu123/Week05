package org.example.Problem6;


import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;

    class Car {
        String brand;
        String model;
        int price;

        public Car(String brand, String model, int price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }
    }

    public class ListObjectIntoJSONArray {  // Follow your naming pattern
        public static void main(String[] args) {
            // Create a list of Car objects
            List<Car> cars = new ArrayList<>();
            cars.add(new Car("Toyota", "Corolla", 2000000));
            cars.add(new Car("Honda", "Civic", 500000));
            cars.add(new Car("Ford", "Mustang", 700000));

            // Convert list to JSON array
            Gson gson = new Gson();
            String jsonArray = gson.toJson(cars);

            // Print JSON array
            System.out.println(jsonArray);
        }
    }

