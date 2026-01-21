package com.andres.controlflow.loops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the enhanced for loop (for-each) in Java.
 * 
 * <p>
 * <strong>What is a for-each loop?</strong>
 * </p>
 * <p>
 * An enhanced version of the for loop (introduced in Java 5) designed
 * specifically
 * for iterating over collections and arrays. It's simpler, cleaner, and less
 * error-prone than traditional for loops when you don't need the index.
 * </p>
 * 
 * <p>
 * <strong>Syntax:</strong>
 * </p>
 * 
 * <pre>
 * for (Type element : collection) {
 *     // Use element
 * }
 * </pre>
 * 
 * <p>
 * <strong>When to Use for-each:</strong>
 * </p>
 * <ul>
 * <li>Iterating over all elements in a collection/array</li>
 * <li>When you don't need the index/position</li>
 * <li>Read-only operations (processing without modification)</li>
 * <li>When clarity and simplicity are priorities</li>
 * <li>MOST COMMON choice for simple iteration</li>
 * </ul>
 * 
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Need to access index/position</li>
 * <li>Need to modify the collection while iterating</li>
 * <li>Need to iterate in reverse or skip elements</li>
 * <li>Need to iterate over multiple collections simultaneously</li>
 * </ul>
 * 
 * <p>
 * <strong>Compatible Types:</strong>
 * </p>
 * <ul>
 * <li>Arrays (all types)</li>
 * <li>Collections (List, Set, Queue, etc.)</li>
 * <li>Any type implementing Iterable interface</li>
 * </ul>
 * 
 * <p>
 * <strong>Advantages over Traditional for:</strong>
 * </p>
 * <ul>
 * <li>Simpler syntax, more readable</li>
 * <li>No off-by-one errors</li>
 * <li>No index management needed</li>
 * <li>Works with any Iterable</li>
 * <li>Compiler optimizations possible</li>
 * </ul>
 * 
 * <p>
 * <strong>Limitations:</strong>
 * </p>
 * <ul>
 * <li>Cannot modify collection during iteration (throws
 * ConcurrentModificationException)</li>
 * <li>Cannot access index directly</li>
 * <li>Cannot iterate backwards</li>
 * <li>Forward-only iteration</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Prefer for-each for simple iteration (most readable)</li>
 * <li>Use traditional for loop when index is needed</li>
 * <li>Use descriptive variable names (fruit, not f)</li>
 * <li>Don't modify the collection inside the loop</li>
 * <li>Consider Stream API for complex transformations</li>
 * </ul>
 */
public final class ForEachLoopDemo {

    private static final Logger logger = LoggerFactory.getLogger(ForEachLoopDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private ForEachLoopDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates for-each loop usage.
     */
    public static void demonstrate() {
        logger.info("--- For-Each Loop (Enhanced For Loop) ---\n");

        // Basic for-each with arrays
        demonstrateArrayIteration();

        // For-each with collections
        demonstrateCollectionIteration();

        // For-each with Map
        demonstrateMapIteration();

        // Comparison with traditional for
        demonstrateComparison();

        // Limitations and workarounds
        demonstrateLimitations();

        // Real-world examples
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates for-each loop with arrays.
     */
    private static void demonstrateArrayIteration() {
        logger.info("--- For-Each with Arrays ---");

        // Array of strings
        String[] fruits = { "Apple", "Banana", "Orange", "Mango" };

        logger.info("Fruits:");
        for (String fruit : fruits) {
            logger.info("  {}", fruit);
        }

        // Array of integers
        int[] numbers = { 10, 20, 30, 40, 50 };

        logger.info("\nNumbers:");
        for (int number : numbers) {
            logger.info("  {}", number);
        }

        // Array of objects
        Person[] people = {
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        };

        logger.info("\nPeople:");
        for (Person person : people) {
            logger.info("  {} - {} years old", person.name(), person.age());
        }
    }

    /**
     * Demonstrates for-each loop with collections.
     */
    private static void demonstrateCollectionIteration() {
        logger.info("\n--- For-Each with Collections ---");

        // List
        List<String> languages = new ArrayList<>(Arrays.asList("Java", "Python", "JavaScript", "C++"));

        logger.info("Programming languages:");
        for (String language : languages) {
            logger.info("  {}", language);
        }

        // Set
        Set<Integer> uniqueNumbers = Set.of(5, 2, 8, 1, 9);

        logger.info("\nUnique numbers:");
        for (Integer num : uniqueNumbers) {
            logger.info("  {}", num);
        }

        // Processing list of objects
        List<Product> products = List.of(
                new Product("Laptop", 999.99),
                new Product("Mouse", 29.99),
                new Product("Keyboard", 79.99));

        logger.info("\nProducts:");
        for (Product product : products) {
            logger.info("  {} - ${}", product.name(), product.price());
        }
    }

    /**
     * Demonstrates for-each loop with Map.
     * 
     * <p>
     * <strong>Note:</strong> For maps, iterate over entrySet() for both key and
     * value.
     * </p>
     */
    private static void demonstrateMapIteration() {
        logger.info("\n--- For-Each with Map ---");

        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 25);
        ages.put("Bob", 30);
        ages.put("Charlie", 35);

        // Iterate over entries (key-value pairs)
        logger.info("Iterating over entries:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            logger.info("  {}: {} years old", entry.getKey(), entry.getValue());
        }

        // Iterate over keys only
        logger.info("\nIterating over keys only:");
        for (String name : ages.keySet()) {
            logger.info("  Name: {}", name);
        }

        // Iterate over values only
        logger.info("\nIterating over values only:");
        for (Integer age : ages.values()) {
            logger.info("  Age: {}", age);
        }
    }

    /**
     * Demonstrates comparison between traditional for and for-each.
     */
    private static void demonstrateComparison() {
        logger.info("\n--- For vs For-Each Comparison ---");

        String[] colors = { "Red", "Green", "Blue" };

        // Traditional for loop
        logger.info("Traditional for loop:");
        for (int i = 0; i < colors.length; i++) {
            logger.info("  [{}]: {}", i, colors[i]);
        }

        // For-each loop (simpler, no index)
        logger.info("\nFor-each loop:");
        for (String color : colors) {
            logger.info("  {}", color);
        }

        logger.info("\n✓ For-each is cleaner when index not needed");
        logger.info("✓ Traditional for when index is required");
    }

    /**
     * Demonstrates limitations of for-each and workarounds.
     */
    private static void demonstrateLimitations() {
        logger.info("\n--- For-Each Limitations ---");

        List<String> items = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        // Limitation 1: Cannot modify collection
        logger.info("Limitation 1: Cannot remove items during iteration");
        try {
            for (String item : items) {
                if (item.equals("B")) {
                    items.remove(item); // ConcurrentModificationException!
                }
            }
        } catch (Exception e) {
            logger.error("Error: {}", e.getClass().getSimpleName());
            logger.info("Workaround: Use Iterator.remove() or Stream API");
        }

        // Workaround: Use removeIf
        items = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));
        items.removeIf(item -> item.equals("B"));
        logger.info("After removeIf: {}", items);

        // Limitation 2: Cannot access index
        logger.info("\nLimitation 2: Cannot access index directly");
        logger.info("Workaround: Use traditional for loop or AtomicInteger");

        // Workaround with manual counter
        int index = 0;
        for (String item : items) {
            logger.info("  [{}]: {}", index++, item);
        }

        // Limitation 3: Cannot iterate backwards
        logger.info("\nLimitation 3: Cannot iterate backwards");
        logger.info("Workaround: Use traditional for loop");
        for (int i = items.size() - 1; i >= 0; i--) {
            logger.info("  {}", items.get(i));
        }
    }

    /**
     * Demonstrates real-world use cases.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Sum of values
        logger.info("Example 1: Sum of numbers");
        List<Integer> numbers = List.of(10, 20, 30, 40, 50);
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        logger.info("Numbers: {}", numbers);
        logger.info("Sum: {}", sum);

        // Example 2: Finding max value
        logger.info("\nExample 2: Finding maximum value");
        int max = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        logger.info("Maximum: {}", max);

        // Example 3: Filtering data
        logger.info("\nExample 3: Filtering even numbers");
        List<Integer> evenNumbers = new ArrayList<>();
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            }
        }
        logger.info("Even numbers: {}", evenNumbers);

        // Example 4: String concatenation
        logger.info("\nExample 4: Building comma-separated list");
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana");
        StringBuilder result = new StringBuilder();
        for (String name : names) {
            if (result.length() > 0) {
                result.append(", ");
            }
            result.append(name);
        }
        logger.info("Names: {}", result);

        // Example 5: Validation
        logger.info("\nExample 5: Validating all elements");
        List<Integer> scores = List.of(85, 90, 78, 92, 88);
        boolean allPassed = true;
        for (int score : scores) {
            if (score < 60) {
                allPassed = false;
                break;
            }
        }
        logger.info("All students passed: {}", allPassed);

        // Example 6: Processing nested data
        logger.info("\nExample 6: Total price calculation");
        List<Order> orders = List.of(
                new Order("Order1", List.of(19.99, 29.99)),
                new Order("Order2", List.of(49.99, 9.99, 39.99)));

        double totalRevenue = 0;
        for (Order order : orders) {
            double orderTotal = 0;
            for (Double price : order.prices()) {
                orderTotal += price;
            }
            logger.info("  {}: ${}", order.id(), orderTotal);
            totalRevenue += orderTotal;
        }
        logger.info("Total revenue: ${}", totalRevenue);
    }

    /**
     * Simple Person record for demonstration.
     */
    private record Person(String name, int age) {
    }

    /**
     * Simple Product record for demonstration.
     */
    private record Product(String name, double price) {
    }

    /**
     * Simple Order record for demonstration.
     */
    private record Order(String id, List<Double> prices) {
    }
}
