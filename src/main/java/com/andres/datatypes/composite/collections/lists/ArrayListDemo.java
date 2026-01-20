package com.andres.datatypes.composite.collections.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates ArrayList, the most commonly used List implementation in Java.
 * 
 * <p>
 * <strong>ArrayList Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Dynamic size (grows automatically as needed)</li>
 * <li>Fast random access by index O(1)</li>
 * <li>Slow insertion/deletion in middle O(n)</li>
 * <li>Allows duplicates and maintains insertion order</li>
 * <li>Backed by resizable array internally</li>
 * <li>Not thread-safe (use Collections.synchronizedList() or
 * CopyOnWriteArrayList)</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use ArrayList:</strong>
 * </p>
 * <ul>
 * <li>Frequent access by index required</li>
 * <li>Primarily adding elements at the end (add)</li>
 * <li>Size changes but not frequently</li>
 * <li>MOST COMMON use case: lists of objects in applications</li>
 * <li>Iteration over elements</li>
 * </ul>
 * 
 * <p>
 * <strong>ArrayList vs LinkedList:</strong>
 * </p>
 * <ul>
 * <li><strong>ArrayList:</strong> Better for random access, worse for
 * insertions/deletions</li>
 * <li><strong>LinkedList:</strong> Better for frequent insertions/deletions,
 * worse for random access</li>
 * <li><strong>In most cases:</strong> Prefer ArrayList (better overall
 * performance)</li>
 * </ul>
 * 
 * <p>
 * <strong>Performance Characteristics:</strong>
 * </p>
 * <ul>
 * <li>get(index): O(1)</li>
 * <li>add(element): O(1) amortized (O(n) when resizing)</li>
 * <li>add(index, element): O(n)</li>
 * <li>remove(index): O(n)</li>
 * <li>contains(element): O(n)</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use interface type: List&lt;String&gt; instead of
 * ArrayList&lt;String&gt;</li>
 * <li>Initialize with capacity if size is known: new
 * ArrayList&lt;&gt;(100)</li>
 * <li>Use generics for type safety: List&lt;String&gt; not raw List</li>
 * <li>Use List.of() for immutable lists (Java 9+)</li>
 * <li>Leverage Stream API for complex operations</li>
 * </ul>
 */
public final class ArrayListDemo {

    private static final Logger logger = LoggerFactory.getLogger(ArrayListDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private ArrayListDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates ArrayList usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- ArrayList (List Implementation) ---\n");

        // Basic operations
        demonstrateBasicOperations();

        // Adding and removing elements
        demonstrateAddRemove();

        // Accessing and searching
        demonstrateAccessAndSearch();

        // Iteration methods
        demonstrateIteration();

        // Sorting and manipulating
        demonstrateSortingAndManipulation();

        // Stream API operations
        demonstrateStreamOperations();

        // Capacity and performance
        demonstrateCapacityManagement();

        System.out.println();
    }

    /**
     * Demonstrates basic ArrayList creation and initialization.
     */
    private static void demonstrateBasicOperations() {
        logger.info("--- Basic Operations ---");

        // Creation with generics (type safe)
        List<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple"); // Duplicates allowed

        logger.info("List: {}", fruits);
        logger.info("Size: {}", fruits.size());
        logger.info("Is empty: {}", fruits.isEmpty());

        // Alternative initialization (Java 9+)
        List<String> immutableFruits = List.of("Mango", "Grape", "Kiwi");
        logger.info("Immutable list: {}", immutableFruits);

        // Creating from existing collection
        List<String> copiedFruits = new ArrayList<>(fruits);
        logger.info("Copied list: {}", copiedFruits);
    }

    /**
     * Demonstrates adding and removing elements.
     */
    private static void demonstrateAddRemove() {
        logger.info("\n--- Adding and Removing Elements ---");

        List<String> languages = new ArrayList<>();

        // Add at end
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");
        logger.info("After adding: {}", languages);

        // Add at specific index
        languages.add(1, "C++");
        logger.info("After adding C++ at index 1: {}", languages);

        // Add all from another collection
        List<String> moreLanguages = List.of("Go", "Rust");
        languages.addAll(moreLanguages);
        logger.info("After addAll: {}", languages);

        // Remove by value
        languages.remove("Python");
        logger.info("After removing 'Python': {}", languages);

        // Remove by index
        languages.remove(0);
        logger.info("After removing index 0: {}", languages);

        // Remove all matching elements
        languages.removeIf(lang -> lang.startsWith("J"));
        logger.info("After removeIf (starts with 'J'): {}", languages);

        // Clear all elements
        languages.clear();
        logger.info("After clear, is empty: {}", languages.isEmpty());
    }

    /**
     * Demonstrates accessing and searching elements.
     */
    private static void demonstrateAccessAndSearch() {
        logger.info("\n--- Accessing and Searching ---");

        List<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Apple", "Mango"));

        // Access by index
        logger.info("First element (index 0): {}", fruits.get(0));
        logger.info("Last element (index {}): {}", fruits.size() - 1, fruits.get(fruits.size() - 1));
        logger.info("Element at index 2: {}", fruits.get(2));

        // Update element
        fruits.set(1, "Blueberry");
        logger.info("After updating index 1: {}", fruits);

        // Check if contains
        logger.info("Contains 'Orange': {}", fruits.contains("Orange"));
        logger.info("Contains 'Grape': {}", fruits.contains("Grape"));

        // Find index
        logger.info("Index of 'Apple': {}", fruits.indexOf("Apple"));
        logger.info("Last index of 'Apple': {}", fruits.lastIndexOf("Apple"));
        logger.info("Index of 'Grape' (not found): {}", fruits.indexOf("Grape"));

        // Sublist
        List<String> subList = fruits.subList(1, 4); // From index 1 (inclusive) to 4 (exclusive)
        logger.info("Sublist [1, 4): {}", subList);
    }

    /**
     * Demonstrates different iteration methods.
     */
    private static void demonstrateIteration() {
        logger.info("\n--- Iteration Methods ---");

        List<String> colors = List.of("Red", "Green", "Blue", "Yellow");

        // Method 1: Traditional for loop with index
        logger.info("Traditional for loop:");
        for (int i = 0; i < colors.size(); i++) {
            logger.info("  [{}]: {}", i, colors.get(i));
        }

        // Method 2: Enhanced for loop (for-each) - MOST COMMON
        logger.info("\nEnhanced for loop:");
        for (String color : colors) {
            logger.info("  {}", color);
        }

        // Method 3: Iterator
        logger.info("\nIterator:");
        var iterator = colors.iterator();
        while (iterator.hasNext()) {
            logger.info("  {}", iterator.next());
        }

        // Method 4: forEach with lambda (Java 8+)
        logger.info("\nforEach with lambda:");
        colors.forEach(color -> logger.info("  {}", color));

        // Method 5: Stream forEach
        logger.info("\nStream forEach:");
        colors.stream().forEach(color -> logger.info("  {}", color));
    }

    /**
     * Demonstrates sorting and list manipulation.
     */
    private static void demonstrateSortingAndManipulation() {
        logger.info("\n--- Sorting and Manipulation ---");

        List<Integer> numbers = new ArrayList<>(List.of(5, 2, 8, 1, 9, 3, 7));
        logger.info("Original list: {}", numbers);

        // Sort in natural order
        Collections.sort(numbers);
        logger.info("Sorted (ascending): {}", numbers);

        // Sort in reverse order
        Collections.sort(numbers, Collections.reverseOrder());
        logger.info("Sorted (descending): {}", numbers);

        // Shuffle
        Collections.shuffle(numbers);
        logger.info("Shuffled: {}", numbers);

        // Reverse
        Collections.reverse(numbers);
        logger.info("Reversed: {}", numbers);

        // Rotate
        Collections.rotate(numbers, 2);
        logger.info("Rotated by 2: {}", numbers);

        // Find min and max
        logger.info("Min: {}, Max: {}", Collections.min(numbers), Collections.max(numbers));

        // Replace all
        List<String> words = new ArrayList<>(List.of("hello", "world", "java"));
        words.replaceAll(String::toUpperCase);
        logger.info("After replaceAll (toUpperCase): {}", words);
    }

    /**
     * Demonstrates Stream API operations on ArrayList.
     * 
     * <p>
     * <strong>Stream API Benefits:</strong>
     * </p>
     * <ul>
     * <li>Functional programming style</li>
     * <li>Readable and concise code</li>
     * <li>Lazy evaluation (better performance)</li>
     * <li>Parallel processing capability</li>
     * </ul>
     */
    private static void demonstrateStreamOperations() {
        logger.info("\n--- Stream API Operations ---");

        List<String> fruits = List.of("Apple", "Banana", "Orange", "Mango", "Avocado", "Apricot");

        // Filter
        logger.info("Fruits starting with 'A':");
        fruits.stream()
                .filter(f -> f.startsWith("A"))
                .forEach(f -> logger.info("  {}", f));

        // Map (transform)
        logger.info("\nFruit lengths:");
        fruits.stream()
                .map(String::length)
                .forEach(len -> logger.info("  {} characters", len));

        // Filter and map combined
        logger.info("\nUppercase fruits with more than 5 letters:");
        fruits.stream()
                .filter(f -> f.length() > 5)
                .map(String::toUpperCase)
                .forEach(f -> logger.info("  {}", f));

        // Count
        long count = fruits.stream()
                .filter(f -> f.length() > 5)
                .count();
        logger.info("\nFruits with more than 5 letters: {}", count);

        // Collect to new list
        List<String> filtered = fruits.stream()
                .filter(f -> f.contains("n"))
                .toList(); // Java 16+, or use .collect(Collectors.toList())
        logger.info("Fruits containing 'n': {}", filtered);

        // Any match / All match / None match
        boolean anyStartsWithA = fruits.stream().anyMatch(f -> f.startsWith("A"));
        boolean allLongerThan3 = fruits.stream().allMatch(f -> f.length() > 3);
        boolean noneStartsWithZ = fruits.stream().noneMatch(f -> f.startsWith("Z"));

        logger.info("\nAny starts with 'A': {}", anyStartsWithA);
        logger.info("All longer than 3 chars: {}", allLongerThan3);
        logger.info("None starts with 'Z': {}", noneStartsWithZ);

        // Reduce (aggregate)
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        logger.info("\nSum of {}: {}", numbers, sum);
    }

    /**
     * Demonstrates capacity management for performance optimization.
     * 
     * <p>
     * <strong>Internal Mechanism:</strong>
     * </p>
     * <p>
     * ArrayList maintains an internal array that grows when capacity is exceeded.
     * Default growth: newCapacity = oldCapacity + (oldCapacity >> 1) (~1.5x)
     * </p>
     * 
     * <p>
     * <strong>When to specify initial capacity:</strong>
     * </p>
     * <ul>
     * <li>You know the approximate size in advance</li>
     * <li>Adding many elements (avoids multiple resizing operations)</li>
     * <li>Performance-critical code</li>
     * </ul>
     */
    private static void demonstrateCapacityManagement() {
        logger.info("\n--- Capacity Management ---");

        // Default capacity (10)
        List<String> defaultList = new ArrayList<>();
        logger.info("Default ArrayList created");
        logger.info(defaultList.toString());

        // With initial capacity
        List<String> optimizedList = new ArrayList<>(100);
        logger.info("ArrayList with initial capacity 100 created");
        logger.info(optimizedList.toString());

        // Trimming capacity to size (rarely needed)
        List<String> list = new ArrayList<>(100);
        list.add("A");
        list.add("B");
        list.add("C");
        logger.info("List size: {}", list.size());

        // Note: ArrayList doesn't expose capacity() publicly
        // Use ((ArrayList<String>) list).trimToSize() if you need to reduce memory
        if (list instanceof ArrayList) {
            ((ArrayList<String>) list).trimToSize();
            logger.info("Capacity trimmed to size");
        }

        // Performance tip
        logger.info("\nPerformance Tip:");
        logger.info("If adding 1000 elements, use: new ArrayList<>(1000)");
        logger.info("This avoids multiple resizing operations");
    }
}
