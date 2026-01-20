package com.andres.datatypes.composite.collections.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates HashMap, the most commonly used Map implementation in Java.
 * 
 * <p>
 * <strong>HashMap Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Stores key-value pairs</li>
 * <li>Keys must be unique (no duplicate keys)</li>
 * <li>Very fast access by key O(1) average case</li>
 * <li>Does not maintain order (use LinkedHashMap for insertion order)</li>
 * <li>Allows null key (only one) and null values</li>
 * <li>Not thread-safe (use ConcurrentHashMap for concurrent access)</li>
 * <li>Based on hash table internally</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use HashMap:</strong>
 * </p>
 * <ul>
 * <li>Fast lookup by key (dictionaries, caches)</li>
 * <li>Counting frequencies (word → count)</li>
 * <li>Storing configuration (key → value)</li>
 * <li>Indexes and mappings (ID → Object, username → User)</li>
 * <li>Very common in Back-End for DTOs and configurations</li>
 * </ul>
 * 
 * <p>
 * <strong>Map Implementations Comparison:</strong>
 * </p>
 * <ul>
 * <li><strong>HashMap:</strong> Best performance, no order guarantee</li>
 * <li><strong>LinkedHashMap:</strong> Maintains insertion order</li>
 * <li><strong>TreeMap:</strong> Maintains natural ordering (sorted keys)</li>
 * <li><strong>ConcurrentHashMap:</strong> Thread-safe for concurrent
 * access</li>
 * </ul>
 * 
 * <p>
 * <strong>Performance Characteristics:</strong>
 * </p>
 * <ul>
 * <li>get(key): O(1) average, O(n) worst case</li>
 * <li>put(key, value): O(1) average, O(n) worst case</li>
 * <li>remove(key): O(1) average, O(n) worst case</li>
 * <li>containsKey(key): O(1) average, O(n) worst case</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use interface type: Map&lt;K, V&gt; instead of HashMap&lt;K, V&gt;</li>
 * <li>Initialize with capacity if size is known: new HashMap&lt;&gt;(100)</li>
 * <li>Override hashCode() and equals() for custom key objects</li>
 * <li>Use Map.of() for immutable maps (Java 9+)</li>
 * <li>Prefer getOrDefault() over get() with null check</li>
 * </ul>
 */
public final class HashMapDemo {

    private static final Logger logger = LoggerFactory.getLogger(HashMapDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private HashMapDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates HashMap usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- HashMap (Map Implementation) ---\n");

        // Basic operations
        demonstrateBasicOperations();

        // Adding, updating, removing
        demonstrateModifications();

        // Searching and checking
        demonstrateSearching();

        // Iteration methods
        demonstrateIteration();

        // Useful methods (Java 8+)
        demonstrateModernMethods();

        // Comparison with other Map types
        demonstrateMapTypes();

        // Real-world examples
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic HashMap creation and operations.
     */
    private static void demonstrateBasicOperations() {
        logger.info("--- Basic Operations ---");

        // Creation with generics
        Map<String, Integer> ages = new HashMap<>();

        // Adding key-value pairs
        ages.put("Ana", 25);
        ages.put("Luis", 30);
        ages.put("María", 28);
        ages.put("Carlos", 35);

        logger.info("Map: {}", ages);
        logger.info("Size: {}", ages.size());
        logger.info("Is empty: {}", ages.isEmpty());

        // Immutable map (Java 9+)
        Map<String, String> capitals = Map.of(
                "Colombia", "Bogotá",
                "Argentina", "Buenos Aires",
                "Brazil", "Brasília");
        logger.info("Immutable map: {}", capitals);
    }

    /**
     * Demonstrates adding, updating, and removing entries.
     */
    private static void demonstrateModifications() {
        logger.info("\n--- Modifications ---");

        Map<String, Integer> scores = new HashMap<>();

        // Add entries
        scores.put("Player1", 100);
        scores.put("Player2", 85);
        scores.put("Player3", 92);
        logger.info("Initial scores: {}", scores);

        // Update existing entry
        scores.put("Player1", 110); // Overwrites previous value
        logger.info("After updating Player1: {}", scores);

        // putIfAbsent (only adds if key doesn't exist)
        scores.putIfAbsent("Player1", 120); // Won't change (key exists)
        scores.putIfAbsent("Player4", 75); // Will add (key doesn't exist)
        logger.info("After putIfAbsent: {}", scores);

        // Remove entry
        scores.remove("Player2");
        logger.info("After removing Player2: {}", scores);

        // Remove only if value matches
        boolean removed = scores.remove("Player1", 110);
        logger.info("Removed Player1 with value 110: {}", removed);
        logger.info("After conditional remove: {}", scores);

        // Replace value
        scores.replace("Player3", 95);
        logger.info("After replacing Player3 value: {}", scores);

        // Replace only if old value matches
        scores.replace("Player3", 95, 100);
        logger.info("After replace with condition: {}", scores);

        // Clear all entries
        scores.clear();
        logger.info("After clear, is empty: {}", scores.isEmpty());
    }

    /**
     * Demonstrates searching and checking operations.
     */
    private static void demonstrateSearching() {
        logger.info("\n--- Searching and Checking ---");

        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Laptop", 10);
        inventory.put("Mouse", 50);
        inventory.put("Keyboard", 30);

        logger.info("Inventory: {}", inventory);

        // Get value by key
        logger.info("Laptops in stock: {}", inventory.get("Laptop"));
        logger.info("Tablets in stock: {}", inventory.get("Tablet")); // null if not found

        // getOrDefault (safer than get)
        logger.info("Tablets (with default): {}", inventory.getOrDefault("Tablet", 0));

        // Check if key exists
        logger.info("Contains 'Mouse': {}", inventory.containsKey("Mouse"));
        logger.info("Contains 'Tablet': {}", inventory.containsKey("Tablet"));

        // Check if value exists
        logger.info("Contains value 50: {}", inventory.containsValue(50));
        logger.info("Contains value 100: {}", inventory.containsValue(100));

        // Get all keys
        logger.info("All products: {}", inventory.keySet());

        // Get all values
        logger.info("All quantities: {}", inventory.values());

        // Get all entries
        logger.info("All entries: {}", inventory.entrySet());
    }

    /**
     * Demonstrates different iteration methods.
     */
    private static void demonstrateIteration() {
        logger.info("\n--- Iteration Methods ---");

        Map<String, Integer> ages = Map.of(
                "Ana", 25,
                "Luis", 30,
                "María", 28);

        // Method 1: Iterate over entries (MOST COMMON)
        logger.info("Iterating over entries:");
        for (Map.Entry<String, Integer> entry : ages.entrySet()) {
            logger.info("  {}: {} years", entry.getKey(), entry.getValue());
        }

        // Method 2: Iterate over keys
        logger.info("\nIterating over keys:");
        for (String name : ages.keySet()) {
            logger.info("  {} → {}", name, ages.get(name));
        }

        // Method 3: forEach with lambda (Java 8+) - MODERN APPROACH
        logger.info("\nforEach with lambda:");
        ages.forEach((name, age) -> logger.info("  {}: {} years", name, age));

        // Method 4: Stream API
        logger.info("\nStream API:");
        ages.entrySet().stream()
                .filter(entry -> entry.getValue() > 26)
                .forEach(entry -> logger.info("  {} is older than 26", entry.getKey()));
    }

    /**
     * Demonstrates modern Map methods introduced in Java 8+.
     * 
     * <p>
     * These methods simplify common patterns and reduce boilerplate code.
     * </p>
     */
    private static void demonstrateModernMethods() {
        logger.info("\n--- Modern Methods (Java 8+) ---");

        Map<String, Integer> wordCount = new HashMap<>();

        // compute: compute new value for a key
        wordCount.compute("hello", (key, value) -> (value == null) ? 1 : value + 1);
        wordCount.compute("hello", (key, value) -> (value == null) ? 1 : value + 1);
        logger.info("After compute: {}", wordCount);

        // computeIfAbsent: compute value only if key is absent
        wordCount.computeIfAbsent("world", key -> 1);
        logger.info("After computeIfAbsent: {}", wordCount);

        // computeIfPresent: compute value only if key is present
        wordCount.computeIfPresent("hello", (key, value) -> value + 1);
        logger.info("After computeIfPresent: {}", wordCount);

        // merge: merge value with existing value
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Team A", 10);
        scores.merge("Team A", 5, Integer::sum); // 10 + 5 = 15
        scores.merge("Team B", 8, Integer::sum); // New key, uses 8
        logger.info("After merge: {}", scores);

        // replaceAll: replace all values
        Map<String, String> lowercase = new HashMap<>();
        lowercase.put("key1", "value1");
        lowercase.put("key2", "value2");
        lowercase.replaceAll((key, value) -> value.toUpperCase());
        logger.info("After replaceAll: {}", lowercase);
    }

    /**
     * Demonstrates different Map implementation types and their characteristics.
     */
    private static void demonstrateMapTypes() {
        logger.info("\n--- Map Implementation Types ---");

        // HashMap: No order guarantee
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("C", 3);
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        logger.info("HashMap (unordered): {}", hashMap);

        // LinkedHashMap: Maintains insertion order
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("C", 3);
        linkedHashMap.put("A", 1);
        linkedHashMap.put("B", 2);
        logger.info("LinkedHashMap (insertion order): {}", linkedHashMap);

        // TreeMap: Maintains natural order (sorted)
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("C", 3);
        treeMap.put("A", 1);
        treeMap.put("B", 2);
        logger.info("TreeMap (sorted by key): {}", treeMap);

        logger.info("\nWhen to use each:");
        logger.info("- HashMap: Best performance, order doesn't matter");
        logger.info("- LinkedHashMap: Need insertion order (e.g., LRU cache)");
        logger.info("- TreeMap: Need sorted keys (e.g., alphabetical listing)");
    }

    /**
     * Demonstrates real-world use cases for HashMap.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Word frequency counter
        logger.info("Example 1: Word Frequency Counter");
        String text = "java is great java is powerful java is fun";
        Map<String, Integer> frequency = countWordFrequency(text);
        logger.info("Word frequencies: {}", frequency);

        // Example 2: User database (simple cache)
        logger.info("\nExample 2: User Database (ID → User)");
        Map<Integer, String> users = new HashMap<>();
        users.put(1, "alice@example.com");
        users.put(2, "bob@example.com");
        users.put(3, "charlie@example.com");

        int userId = 2;
        String email = users.getOrDefault(userId, "not.found@example.com");
        logger.info("User {} email: {}", userId, email);

        // Example 3: Configuration storage
        logger.info("\nExample 3: Application Configuration");
        Map<String, String> config = new HashMap<>();
        config.put("db.host", "localhost");
        config.put("db.port", "5432");
        config.put("db.name", "myapp");
        config.put("app.env", "development");

        config.forEach((key, value) -> logger.info("  {}: {}", key, value));

        // Example 4: Grouping data
        logger.info("\nExample 4: Grouping Students by Grade");
        Map<String, Integer> studentGrades = Map.of(
                "Ana", 85,
                "Luis", 92,
                "María", 78,
                "Carlos", 92,
                "Sofia", 85);

        Map<Integer, Long> gradeDistribution = studentGrades.values().stream()
                .collect(java.util.stream.Collectors.groupingBy(
                        grade -> grade,
                        java.util.stream.Collectors.counting()));
        logger.info("Grade distribution: {}", gradeDistribution);
    }

    /**
     * Helper method to count word frequency in a text.
     */
    private static Map<String, Integer> countWordFrequency(String text) {
        Map<String, Integer> frequency = new HashMap<>();
        String[] words = text.split("\\s+");

        for (String word : words) {
            frequency.merge(word, 1, Integer::sum);
        }

        return frequency;
    }
}
