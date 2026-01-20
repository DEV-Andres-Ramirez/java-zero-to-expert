package com.andres.datatypes.composite.collections.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates HashSet, a Set implementation that stores unique elements.
 * 
 * <p>
 * <strong>HashSet Characteristics:</strong>
 * </p>
 * <ul>
 * <li>No duplicate elements (each element is unique)</li>
 * <li>Does not maintain insertion order</li>
 * <li>Very fast operations: add, remove, contains O(1) average</li>
 * <li>Allows one null element</li>
 * <li>Not thread-safe (use Collections.synchronizedSet() or
 * ConcurrentHashSet)</li>
 * <li>Based on HashMap internally</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use HashSet:</strong>
 * </p>
 * <ul>
 * <li>Remove duplicates from a collection</li>
 * <li>Fast membership checking (contains)</li>
 * <li>Set operations (union, intersection, difference)</li>
 * <li>Store unique elements without caring about order</li>
 * <li>Implement mathematical sets</li>
 * </ul>
 * 
 * <p>
 * <strong>Set Implementations Comparison:</strong>
 * </p>
 * <ul>
 * <li><strong>HashSet:</strong> Best performance, no order</li>
 * <li><strong>LinkedHashSet:</strong> Maintains insertion order</li>
 * <li><strong>TreeSet:</strong> Maintains natural ordering (sorted)</li>
 * </ul>
 * 
 * <p>
 * <strong>Performance Characteristics:</strong>
 * </p>
 * <ul>
 * <li>add(element): O(1) average</li>
 * <li>remove(element): O(1) average</li>
 * <li>contains(element): O(1) average</li>
 * <li>size(): O(1)</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use interface type: Set&lt;T&gt; instead of HashSet&lt;T&gt;</li>
 * <li>Override hashCode() and equals() for custom objects</li>
 * <li>Use Set.of() for immutable sets (Java 9+)</li>
 * <li>Choose right Set type based on ordering needs</li>
 * <li>Use contains() instead of iterating to check membership</li>
 * </ul>
 */
public final class HashSetDemo {

    private static final Logger logger = LoggerFactory.getLogger(HashSetDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private HashSetDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates HashSet usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- HashSet (Set Implementation) ---\n");

        // Basic operations
        demonstrateBasicOperations();

        // Adding and removing
        demonstrateModifications();

        // Uniqueness enforcement
        demonstrateUniqueness();

        // Set mathematical operations
        demonstrateSetOperations();

        // Iteration
        demonstrateIteration();

        // Different Set types
        demonstrateSetTypes();

        // Real-world examples
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic HashSet creation and operations.
     */
    private static void demonstrateBasicOperations() {
        logger.info("--- Basic Operations ---");

        // Creation
        Set<String> languages = new HashSet<>();

        // Adding elements
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");

        logger.info("Set: {}", languages);
        logger.info("Size: {}", languages.size());
        logger.info("Is empty: {}", languages.isEmpty());

        // Immutable set (Java 9+)
        Set<String> frameworks = Set.of("Spring", "Django", "Express");
        logger.info("Immutable set: {}", frameworks);

        // Creating from collection
        List<String> list = Arrays.asList("A", "B", "C");
        Set<String> fromList = new HashSet<>(list);
        logger.info("Set from list: {}", fromList);
    }

    /**
     * Demonstrates adding and removing elements.
     */
    private static void demonstrateModifications() {
        logger.info("\n--- Modifications ---");

        Set<Integer> numbers = new HashSet<>();

        // Add elements
        boolean added1 = numbers.add(10);
        boolean added2 = numbers.add(20);
        boolean added3 = numbers.add(10); // Duplicate, won't be added

        logger.info("Add 10: {}", added1);
        logger.info("Add 20: {}", added2);
        logger.info("Add 10 again: {} (duplicate rejected)", added3);
        logger.info("Set: {}", numbers);

        // Add all from collection
        Set<Integer> moreNumbers = Set.of(30, 40, 50);
        numbers.addAll(moreNumbers);
        logger.info("After addAll: {}", numbers);

        // Remove element
        boolean removed = numbers.remove(20);
        logger.info("Remove 20: {}", removed);
        logger.info("After remove: {}", numbers);

        // Remove element that doesn't exist
        boolean notRemoved = numbers.remove(100);
        logger.info("Remove 100 (doesn't exist): {}", notRemoved);

        // Remove if condition matches
        numbers.removeIf(n -> n > 35);
        logger.info("After removeIf (> 35): {}", numbers);

        // Clear all
        numbers.clear();
        logger.info("After clear, is empty: {}", numbers.isEmpty());
    }

    /**
     * Demonstrates how HashSet enforces uniqueness.
     */
    private static void demonstrateUniqueness() {
        logger.info("\n--- Uniqueness Enforcement ---");

        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Apple"); // Duplicate
        fruits.add("Orange");
        fruits.add("Banana"); // Duplicate

        logger.info("Set (duplicates removed): {}", fruits);
        logger.info("Size: {} (only unique elements)", fruits.size());

        // Use case: Remove duplicates from list
        logger.info("\n--- Removing Duplicates from List ---");
        List<Integer> listWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 1, 3);
        logger.info("Original list: {}", listWithDuplicates);

        Set<Integer> uniqueSet = new HashSet<>(listWithDuplicates);
        logger.info("Unique elements (Set): {}", uniqueSet);

        // Convert back to list if needed
        List<Integer> uniqueList = uniqueSet.stream().sorted().toList();
        logger.info("Unique elements (sorted List): {}", uniqueList);
    }

    /**
     * Demonstrates mathematical set operations.
     * 
     * <p>
     * <strong>Set Theory Operations:</strong>
     * </p>
     * <ul>
     * <li>Union (A ∪ B): All elements from both sets</li>
     * <li>Intersection (A ∩ B): Common elements in both sets</li>
     * <li>Difference (A - B): Elements in A but not in B</li>
     * <li>Symmetric Difference: Elements in A or B but not in both</li>
     * </ul>
     */
    private static void demonstrateSetOperations() {
        logger.info("\n--- Set Operations (Mathematical) ---");

        Set<String> set1 = new HashSet<>(Set.of("A", "B", "C", "D"));
        Set<String> set2 = new HashSet<>(Set.of("C", "D", "E", "F"));

        logger.info("Set 1: {}", set1);
        logger.info("Set 2: {}", set2);

        // Union (A ∪ B)
        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);
        logger.info("\nUnion (Set1 ∪ Set2): {}", union);

        // Intersection (A ∩ B)
        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        logger.info("Intersection (Set1 ∩ Set2): {}", intersection);

        // Difference (A - B)
        Set<String> difference1 = new HashSet<>(set1);
        difference1.removeAll(set2);
        logger.info("Difference (Set1 - Set2): {}", difference1);

        // Difference (B - A)
        Set<String> difference2 = new HashSet<>(set2);
        difference2.removeAll(set1);
        logger.info("Difference (Set2 - Set1): {}", difference2);

        // Symmetric Difference ((A - B) ∪ (B - A))
        Set<String> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);
        Set<String> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        symmetricDiff.removeAll(temp);
        logger.info("Symmetric Difference: {}", symmetricDiff);

        // Subset check
        Set<String> subset = new HashSet<>(Set.of("A", "B"));
        boolean isSubset = set1.containsAll(subset);
        logger.info("\nIs {} a subset of Set1? {}", subset, isSubset);
    }

    /**
     * Demonstrates iteration over HashSet.
     */
    private static void demonstrateIteration() {
        logger.info("\n--- Iteration Methods ---");

        Set<String> colors = new HashSet<>(Set.of("Red", "Green", "Blue", "Yellow"));

        // Enhanced for loop
        logger.info("Enhanced for loop:");
        for (String color : colors) {
            logger.info("  {}", color);
        }

        // Iterator
        logger.info("\nIterator:");
        var iterator = colors.iterator();
        while (iterator.hasNext()) {
            logger.info("  {}", iterator.next());
        }

        // forEach with lambda
        logger.info("\nforEach with lambda:");
        colors.forEach(color -> logger.info("  {}", color));

        // Stream API
        logger.info("\nStream API (filter & process):");
        colors.stream()
                .filter(c -> c.length() > 3)
                .forEach(c -> logger.info("  {} (length > 3)", c));
    }

    /**
     * Demonstrates different Set implementation types.
     */
    private static void demonstrateSetTypes() {
        logger.info("\n--- Set Implementation Types ---");

        // HashSet: No order
        Set<Integer> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));
        logger.info("HashSet (unordered): {}", hashSet);

        // LinkedHashSet: Maintains insertion order
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));
        logger.info("LinkedHashSet (insertion order): {}", linkedHashSet);

        // TreeSet: Maintains natural order (sorted)
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(Arrays.asList(5, 2, 8, 1, 9, 3));
        logger.info("TreeSet (sorted): {}", treeSet);

        logger.info("\nWhen to use each:");
        logger.info("- HashSet: Best performance, order doesn't matter");
        logger.info("- LinkedHashSet: Need insertion order preserved");
        logger.info("- TreeSet: Need sorted elements (auto-sorted)");
    }

    /**
     * Demonstrates real-world use cases for HashSet.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Unique visitor tracking
        logger.info("Example 1: Unique Visitor Tracking");
        Set<String> visitors = new HashSet<>();
        visitors.add("user123");
        visitors.add("user456");
        visitors.add("user123"); // Duplicate, not counted
        visitors.add("user789");
        logger.info("Unique visitors: {}", visitors.size());
        logger.info("Visitors: {}", visitors);

        // Example 2: Email validation (no duplicate emails)
        logger.info("\nExample 2: Email Registration (No Duplicates)");
        Set<String> registeredEmails = new HashSet<>();

        boolean registered1 = registeredEmails.add("alice@example.com");
        boolean registered2 = registeredEmails.add("bob@example.com");
        boolean registered3 = registeredEmails.add("alice@example.com"); // Duplicate

        logger.info("Alice registered: {}", registered1);
        logger.info("Bob registered: {}", registered2);
        logger.info("Alice registered again: {} (already exists)", registered3);

        // Example 3: Tag system (unique tags)
        logger.info("\nExample 3: Article Tag System");
        Set<String> articleTags = new HashSet<>();
        articleTags.addAll(Arrays.asList("java", "programming", "backend", "java")); // Duplicate 'java'
        logger.info("Unique tags: {}", articleTags);

        // Example 4: Finding common elements
        logger.info("\nExample 4: Common Skills Between Users");
        Set<String> user1Skills = new HashSet<>(Set.of("Java", "SQL", "Spring"));
        Set<String> user2Skills = new HashSet<>(Set.of("Python", "SQL", "Django"));

        Set<String> commonSkills = new HashSet<>(user1Skills);
        commonSkills.retainAll(user2Skills);
        logger.info("User 1 skills: {}", user1Skills);
        logger.info("User 2 skills: {}", user2Skills);
        logger.info("Common skills: {}", commonSkills);

        // Example 5: Unique word counter
        logger.info("\nExample 5: Unique Words in Text");
        String text = "java is great java is powerful java is fun";
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(text.split("\\s+")));
        logger.info("Unique words: {}", uniqueWords);
        logger.info("Unique word count: {}", uniqueWords.size());
    }
}
