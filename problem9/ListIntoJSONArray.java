package org.example.problem9;



    import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;
import java.util.ArrayList;

    class Car {
        public String brand;
        public String model;
        public double price; // Changed 'year' to 'price'

        public Car(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }
    }

    public class ListIntoJSONArray { // Follow your naming pattern
        public static void main(String[] args) {
            try {
                // Create a list of Car objects
                List<Car> cars = new ArrayList<>();
                cars.add(new Car("Toyota", "Corolla", 20000.50));
                cars.add(new Car("Honda", "Civic", 22000.75));
                cars.add(new Car("Ford", "Mustang", 35000.00));

                // Convert list to JSON array
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonArray = objectMapper.writeValueAsString(cars);

                // Print JSON array
                System.out.println(jsonArray);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

