package com.example.mynewpackage;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println("Connection to server successfully");

        // Check if the server is running
        System.out.println("Server is running: " + jedis.ping());

        // Set and Get Redis values

        Scanner scanner = new Scanner(System.in);

        // Ask the user how many key-value pairs they want to enter
        System.out.print("How many key-value pairs do you want to insert? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // Loop to insert key-value pairs manually
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter key for pair " + i + ": ");
            String key = scanner.nextLine();  // Get the key from the user

            System.out.print("Enter value for key '" + key + "': ");
            String value = scanner.nextLine();  // Get the value from the user

            // Insert the key-value pair into Redis
            jedis.set(key, value);
        }

        // Retrieve and display all the inserted key-value pairs
        System.out.println("\nInserted key-value pairs:");
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter the key you want to retrieve: ");
            String key = scanner.nextLine();  // User enters the key to retrieve the value
            String value = jedis.get(key);    // Get the value for the key from Redis

            if (value != null) {
                System.out.println(key + ": " + value);  // Print the key-value pair
            } else {
                System.out.println("Key '" + key + "' does not exist.");
            }
        }

        // Close the Jedis and Scanner connections
        jedis.close();
        scanner.close();
    }

}



