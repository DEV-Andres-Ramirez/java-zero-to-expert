package com.andres;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main Class!
 *
 */
public class App {

    // Logger instance
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        /*
         * Display information through the console
         */

        // Print Hello World
        logger.info("Hello World!\n");

        // Print all environment variables
        System.getenv().forEach((key, value) -> logger.info("{}: {}\n", key, value));

        // Print specific environment variable CLAVE
        String clave = System.getenv().get("CLAVE");
        logger.info("CLAVE: {}\n", clave);

        /*
         * Capturing information through the console
         */

        // Read a line from standard input
        Scanner scanner = new Scanner(System.in);
        String read = scanner.nextLine();
        logger.info("Read: {}\n", read);

        /*
         * Primitive data types in Java
         */

        // Integer data type
        int a = 5;
        logger.info("The value of a is: {}\n", a);

        // Double data type
        double b = 3.14;
        logger.info("The value of b is: {}\n", b);

        // Float data type
        float c = 2.71f;
        logger.info("The value of c is: {}\n", c);

        // Character data type
        char d = 'A';
        logger.info("The value of d is: {}\n", d);

        // String data type
        String e = "Hello, Java!";
        logger.info("The value of e is: {}\n", e);

        /*
         * Composite data types in Java
         */

        // Vector (Array) data type
        int[] numbers = new int[] { 1, 2, 3, 4, 5 };
        logger.info("The value of numbers[2] is: {}\n", numbers[2]);

        // Matrix (2D Array) data type
        int[][] matrix = new int[][] { { 1, 2 }, { 3, 4 } };
        logger.info("The value of matrix[1][0] is: {}\n", matrix[1][0]);

        // List data type
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        logger.info("The values of list are: {}\n", list);
        String item = list.get(0);
        logger.info("The value of the element at position 0 is: {}\n", item);

        // Map (Dictionary) data type
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        logger.info("The values of map are: {}\n", map);
        String value = map.get("key1");
        logger.info("The value associated with 'key1' is: {}\n", value);

        // Set data type
        Set<String> set = new HashSet<>();
        set.add("Element 1");
        set.add("Element 2");
        logger.info("The values of set are: {}\n", set);
        boolean contains = set.contains("Element 1");
        logger.info("Does the set contain 'Element 1'? {}\n", contains);

        // Queue data type
        Queue<String> queue = new ArrayDeque<>();
        queue.add("First");
        queue.add("Second");
        logger.info("The values of queue are: {}\n", queue);
        String firstElement = queue.poll();
        logger.info("The first element removed from the queue is: {}\n", firstElement);

        // Stack data type (Synchronized classes "Vector", "Hashtable", "Stack" and "StringBuffer" should not be used (java:S1149))
        Stack<String> stack = new Stack<>(); // NOSONAR
        stack.push("Bottom");
        stack.push("Top");
        logger.info("The values of stack are: {}\n", stack);
        String topElement = stack.pop();
        logger.info("The top element removed from the stack is: {}\n", topElement);

        // BigDecimal data type
        BigDecimal bigDecimalValue = new BigDecimal("123456789.123456789");
        logger.info("The value of bigDecimalValue is: {}\n", bigDecimalValue);

        scanner.close();
    }
}
