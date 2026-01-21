package com.andres.controlflow.streams;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates basic Stream API concepts in Java (Java 8+).
 * 
 * <p>
 * <strong>What is the Stream API?</strong>
 * </p>
 * <p>
 * A powerful abstraction for processing sequences of elements in a functional
 * programming style. Streams allow you to perform operations like filtering,
 * mapping, and reducing on collections in a declarative way.
 * </p>
 * 
 * <p>
 * <strong>Important Note:</strong>
 * </p>
 * <p>
 * This is a BASIC introduction to Streams. Advanced topics (parallel streams,
 * complex collectors, custom operations, performance considerations) will be
 * covered in detail in a dedicated section later.
 * </p>
 * 
 * <p>
 * <strong>Key Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Functional approach to data processing</li>
 * <li>Declarative (what to do, not how to do it)</li>
 * <li>Lazy evaluation (operations not executed until terminal operation)</li>
 * <li>Does not modify the source collection</li>
 * <li>Can be used only once (consumed after terminal operation)</li>
 * </ul>
 * 
 * <p>
 * <strong>Basic Stream Operations Covered Here:</strong>
 * </p>
 * <ul>
 * <li><strong>filter():</strong> Keep elements matching a condition</li>
 * <li><strong>map():</strong> Transform each element</li>
 * <li><strong>forEach():</strong> Perform action on each element</li>
 * <li><strong>collect():</strong> Gather results into a collection</li>
 * <li><strong>count():</strong> Count elements</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use Streams (Basic Cases):</strong>
 * </p>
 * <ul>
 * <li>Filtering collections (find even numbers, adults, etc.)</li>
 * <li>Transforming data (convert to uppercase, extract properties)</li>
 * <li>Simple data processing pipelines</li>
 * <li>When code readability is improved over loops</li>
 * </ul>
 * 
 * <p>
 * <strong>When NOT to Use (for now):</strong>
 * </p>
 * <ul>
 * <li>Very simple loops (for-each might be clearer)</li>
 * <li>When you need to modify the original collection in-place</li>
 * <li>Complex operations requiring multiple intermediate variables</li>
 * <li>When traditional loops are more readable to your team</li>
 * </ul>
 * 
 * <p>
 * <strong>Basic Stream Pipeline:</strong>
 * </p>
 * 
 * <pre>
 * collection.stream() // 1. Create stream
 *         .filter(condition) // 2. Intermediate operation(s)
 *         .map(transformation) // 3. More intermediate operations
 *         .collect(Collectors.toList()); // 4. Terminal operation
 * </pre>
 * 
 * <p>
 * <strong>Best Practices (Basic):</strong>
 * </p>
 * <ul>
 * <li>Use method references when possible (String::toUpperCase)</li>
 * <li>Keep lambda expressions short and readable</li>
 * <li>Chain operations for readability</li>
 * <li>Remember: streams are consumed after terminal operation</li>
 * <li>Don't use streams just for the sake of it - use when it improves
 * clarity</li>
 * </ul>
 * 
 * <p>
 * <strong>Topics NOT Covered Here (Advanced):</strong>
 * </p>
 * <ul>
 * <li>Parallel streams</li>
 * <li>Custom collectors</li>
 * <li>FlatMap and complex transformations</li>
 * <li>Reduction operations (reduce, grouping)</li>
 * <li>Performance considerations and benchmarking</li>
 * <li>Infinite streams</li>
 * </ul>
 */
public final class StreamBasicsDemo {

    private static final Logger logger = LoggerFactory.getLogger(StreamBasicsDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private StreamBasicsDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates basic Stream API usage.
     */
    public static void demonstrate() {
        logger.info("--- Stream API Basics (Introduction) ---\n");

        logger.info("Note: This is a basic introduction. Advanced Stream topics");
        logger.info("will be covered in detail in a dedicated section.\n");

        // Basic filtering
        demonstrateBasicFiltering();

        // Basic mapping
        demonstrateBasicMapping();

        // Combining filter and map
        demonstrateCombinedOperations();

        // forEach operation
        demonstrateForEach();

        // Collecting results
        demonstrateCollecting();

        // Counting elements
        demonstrateCounting();

        // Comparison with traditional loops
        demonstrateLoopComparison();

        System.out.println();
    }

    /**
     * Demonstrates basic filtering with streams.
     * 
     * <p>
     * <strong>filter():</strong> Keeps only elements that match a condition.
     * </p>
     */
    private static void demonstrateBasicFiltering() {
        logger.info("--- Basic Filtering with filter() ---");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        logger.info("Original list: {}", numbers);

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        logger.info("Even numbers: {}", evenNumbers);

        // Filter numbers greater than 5
        List<Integer> greaterThanFive = numbers.stream()
                .filter(n -> n > 5)
                .collect(Collectors.toList());

        logger.info("Numbers > 5: {}", greaterThanFive);

        // Example with strings
        List<String> names = List.of("Alice", "Bob", "Charlie", "Diana", "Eve");
        logger.info("\nOriginal names: {}", names);

        List<String> shortNames = names.stream()
                .filter(name -> name.length() <= 3)
                .collect(Collectors.toList());

        logger.info("Short names (≤3 chars): {}", shortNames);
    }

    /**
     * Demonstrates basic mapping (transformation) with streams.
     * 
     * <p>
     * <strong>map():</strong> Transforms each element to something else.
     * </p>
     */
    private static void demonstrateBasicMapping() {
        logger.info("\n--- Basic Mapping with map() ---");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        logger.info("Original numbers: {}", numbers);

        // Square each number
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());

        logger.info("Squared numbers: {}", squared);

        // Example with strings
        List<String> words = List.of("hello", "world", "java", "stream");
        logger.info("\nOriginal words: {}", words);

        // Convert to uppercase
        List<String> uppercase = words.stream()
                .map(String::toUpperCase) // Method reference
                .collect(Collectors.toList());

        logger.info("Uppercase: {}", uppercase);

        // Get string lengths
        List<Integer> lengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());

        logger.info("Lengths: {}", lengths);
    }

    /**
     * Demonstrates combining filter and map operations.
     * 
     * <p>
     * <strong>Pipeline:</strong> Multiple operations can be chained together.
     * </p>
     */
    private static void demonstrateCombinedOperations() {
        logger.info("\n--- Combining filter() and map() ---");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        logger.info("Original numbers: {}", numbers);

        // Filter even numbers, then square them
        List<Integer> evenSquared = numbers.stream()
                .filter(n -> n % 2 == 0) // Keep only even
                .map(n -> n * n) // Square each
                .collect(Collectors.toList());

        logger.info("Even numbers squared: {}", evenSquared);

        // Example with strings
        List<String> fruits = List.of("Apple", "Banana", "Avocado", "Mango", "Apricot");
        logger.info("\nOriginal fruits: {}", fruits);

        // Filter fruits starting with 'A', convert to uppercase
        List<String> aFruits = fruits.stream()
                .filter(f -> f.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        logger.info("Fruits starting with 'A' (uppercase): {}", aFruits);
    }

    /**
     * Demonstrates forEach for performing actions on each element.
     * 
     * <p>
     * <strong>forEach():</strong> Terminal operation that performs an action
     * on each element. Does not return a new collection.
     * </p>
     */
    private static void demonstrateForEach() {
        logger.info("\n--- forEach() Operation ---");

        List<String> languages = List.of("Java", "Python", "JavaScript");

        logger.info("Printing each language:");
        languages.stream()
                .forEach(lang -> logger.info("  - {}", lang));

        logger.info("\nProcessing numbers:");
        List<Integer> numbers = List.of(2, 4, 6, 8);

        numbers.stream()
                .forEach(n -> logger.info("  {} squared is {}", n, n * n));
    }

    /**
     * Demonstrates different ways to collect stream results.
     * 
     * <p>
     * <strong>collect():</strong> Terminal operation that gathers stream
     * elements into a collection or other data structure.
     * </p>
     */
    private static void demonstrateCollecting() {
        logger.info("\n--- Collecting Results with collect() ---");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // Collect to List
        List<Integer> doubled = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());

        logger.info("Doubled (List): {}", doubled);

        // Collect to specific implementation
        List<String> words = List.of("apple", "banana", "cherry");

        List<String> upperWords = words.stream()
                .map(String::toUpperCase)
                .toList(); // Java 16+ - creates unmodifiable list

        logger.info("Uppercase words: {}", upperWords);

        // Join strings
        String joined = words.stream()
                .collect(Collectors.joining(", "));

        logger.info("Joined: {}", joined);
    }

    /**
     * Demonstrates counting elements in a stream.
     * 
     * <p>
     * <strong>count():</strong> Terminal operation that returns the number
     * of elements in the stream.
     * </p>
     */
    private static void demonstrateCounting() {
        logger.info("\n--- Counting with count() ---");

        List<String> fruits = List.of("Apple", "Banana", "Avocado", "Mango", "Apricot");

        // Count fruits starting with 'A'
        long countA = fruits.stream()
                .filter(f -> f.startsWith("A"))
                .count();

        logger.info("Fruits: {}", fruits);
        logger.info("Fruits starting with 'A': {}", countA);

        // Count even numbers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long evenCount = numbers.stream()
                .filter(n -> n % 2 == 0)
                .count();

        logger.info("\nNumbers: {}", numbers);
        logger.info("Even numbers count: {}", evenCount);
    }

    /**
     * Demonstrates comparison between traditional loops and streams.
     */
    private static void demonstrateLoopComparison() {
        logger.info("\n--- Traditional Loop vs Stream Comparison ---");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Task: Get even numbers, square them, collect to list

        // Traditional for loop approach
        logger.info("Traditional for loop:");
        List<Integer> resultLoop = new java.util.ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                resultLoop.add(number * number);
            }
        }
        logger.info("Result: {}", resultLoop);

        // Stream approach (more declarative)
        logger.info("\nStream approach:");
        List<Integer> resultStream = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        logger.info("Result: {}", resultStream);

        logger.info("\n✓ Stream is more declarative (what, not how)");
        logger.info("✓ Traditional loop gives more control");
        logger.info("✓ Choose based on readability and team preference");

        // Another example: Sum of squares of even numbers
        logger.info("\n--- Example: Sum of Squares of Even Numbers ---");

        // Traditional approach
        int sumLoop = 0;
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                sumLoop += number * number;
            }
        }
        logger.info("Traditional loop sum: {}", sumLoop);

        // Stream approach (introduced here, will be detailed later)
        int sumStream = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .mapToInt(Integer::intValue)
                .sum();
        logger.info("Stream sum: {}", sumStream);
    }
}
