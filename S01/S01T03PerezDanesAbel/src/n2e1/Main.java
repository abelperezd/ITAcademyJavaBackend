package n2e1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//https://www.w3schools.com/java/java_files_create.asp
//https://www.w3schools.com/java/java_files_read.asp
public class Main {

    public static void addRestaurant(HashSet<Restaurant> hs, Restaurant r) {
        if (!hs.stream().anyMatch(r2 -> r2.getNom() == r.getNom()))
            hs.add(r);

    }

    public static void main(String[] args) {

        Restaurants<Restaurant> restaurants = new Restaurants<>();

        restaurants.add(new Restaurant("Mardonals", 5));
        restaurants.add(new Restaurant("mardonals", 5));
        restaurants.add(new Restaurant("mardonals", 3));
        restaurants.add(new Restaurant("Mardonals", 5));
        restaurants.add(new Restaurant("Viena", 6));
        restaurants.add(new Restaurant("Abel's Restaurant", 75));
        restaurants.add(new Restaurant("Bruger Kins", 8));
        restaurants.add(new Restaurant("Bruger Kins", 8));
        restaurants.add(new Restaurant("Bruger Kins", 5));

        restaurants.getOrderedRestaurants().forEach(r -> System.out.println(r.getNom() + ": " + r.getPuntuacio()));
    }
}
