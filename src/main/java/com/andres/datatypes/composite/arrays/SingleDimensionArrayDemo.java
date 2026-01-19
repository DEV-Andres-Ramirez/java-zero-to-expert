package com.andres.datatypes.composite.arrays;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates single-dimension arrays in Java.
 * 
 * <p>
 * <strong>Array Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Fixed size defined at creation time</li>
 * <li>Index-based access (zero-indexed)</li>
 * <li>Can contain primitives or objects</li>
 * <li>Very memory and access efficient</li>
 * <li>Continuous memory allocation</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use Arrays:</strong>
 * </p>
 * <ul>
 * <li>Size is known and fixed</li>
 * <li>Maximum performance required</li>
 * <li>Large volume processing of primitive data</li>
 * <li>Mathematical matrices or graphics</li>
 * <li>Low-level data structures implementation</li>
 * </ul>
 * 
 * <p>
 * <strong>When NOT to Use Arrays:</strong>
 * </p>
 * <ul>
 * <li>Dynamic size needed (use ArrayList instead)</li>
 * <li>Need utility methods (add, remove, contains) → use List</li>
 * <li>Complex operations → use Stream API with List</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Initialize with known size: new int[100]</li>
 * <li>Use Arrays utility class for operations</li>
 * <li>Check bounds before access to avoid IndexOutOfBoundsException</li>
 * <li>Prefer for-each loop when index not needed</li>
 * <li>Consider ArrayList for most use cases</li>
 * </ul>
 */
public final class SingleDimensionArrayDemo {

    private static final Logger logger = LoggerFactory.getLogger(SingleDimensionArrayDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private SingleDimensionArrayDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates single-dimension array usage.
     */
    public static void demonstrate() {
        logger.info("--- Single-Dimension Arrays ---\n");

        // Array declaration and initialization
        demonstrateArrayCreation();

        // Array access
        demonstrateArrayAccess();

        // Array iteration
        demonstrateArrayIteration();

        // Arrays utility methods
        demonstrateArraysUtility();

        System.out.println();
    }

    /**
     * Demonstrates different ways to create and initialize arrays.
     */
    private static void demonstrateArrayCreation() {
        logger.info("--- Array Creation and Initialization ---");

        // Method 1: Declare and initialize with values
        int[] numbers = { 1, 2, 3, 4, 5 };
        logger.info("Array literal: {}", Arrays.toString(numbers));

        // Method 2: Declare with size, then assign values
        String[] names = new String[3];
        names[0] = "Ana";
        names[1] = "Luis";
        names[2] = "María";
        logger.info("Array with size: {}", Arrays.toString(names));

        // Method 3: Using new with initialization
        double[] prices = new double[] { 19.99, 29.99, 39.99 };
        logger.info("New with values: {}", Arrays.toString(prices));

        // Array properties
        logger.info("\nArray properties:");
        logger.info("Length of numbers: {}", numbers.length);
        logger.info("Length of names: {}", names.length);
    }

    /**
     * Demonstrates array element access.
     */
    private static void demonstrateArrayAccess() {
        logger.info("\n--- Array Access ---");

        int[] numbers = { 10, 20, 30, 40, 50 };

        logger.info("Array: {}", Arrays.toString(numbers));
        logger.info("First element (index 0): {}", numbers[0]);
        logger.info("Last element (index {}): {}", numbers.length - 1, numbers[numbers.length - 1]);
        logger.info("Element at index 2: {}", numbers[2]);

        // Modifying elements
        numbers[2] = 99;
        logger.info("After modifying index 2: {}", Arrays.toString(numbers));

        // Safe access with bounds checking
        int index = 10;
        if (index >= 0 && index < numbers.length) {
            logger.info("Element at index {}: {}", index, numbers[index]);
        } else {
            logger.warn("Index {} is out of bounds (0 to {})", index, numbers.length - 1);
        }
    }

    /**
     * Demonstrates different array iteration methods.
     */
    private static void demonstrateArrayIteration() {
        logger.info("\n--- Array Iteration ---");

        String[] fruits = { "Apple", "Banana", "Orange", "Mango" };

        // Method 1: Traditional for loop
        logger.info("Traditional for loop:");
        for (int i = 0; i < fruits.length; i++) {
            logger.info("  [{}]: {}", i, fruits[i]);
        }

        // Method 2: Enhanced for loop (for-each) - PREFERRED when index not needed
        logger.info("\nEnhanced for loop:");
        for (String fruit : fruits) {
            logger.info("  Fruit: {}", fruit);
        }

        // Method 3: Arrays.stream() with forEach (Java 8+)
        logger.info("\nStream API:");
        Arrays.stream(fruits)
                .forEach(fruit -> logger.info("  {}", fruit));
    }

    /**
     * Demonstrates Arrays utility class methods.
     */
    private static void demonstrateArraysUtility() {
        logger.info("\n--- Arrays Utility Methods ---");

        int[] numbers = { 5, 2, 8, 1, 9, 3 };
        logger.info("Original array: {}", Arrays.toString(numbers));

        // Sorting
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        logger.info("Sorted array: {}", Arrays.toString(sortedNumbers));

        // Binary search (array must be sorted first)
        int searchValue = 8;
        int index = Arrays.binarySearch(sortedNumbers, searchValue);
        logger.info("Index of {} in sorted array: {}", searchValue, index);

        // Fill array
        int[] filled = new int[5];
        Arrays.fill(filled, 42);
        logger.info("Filled array with 42: {}", Arrays.toString(filled));

        // Copy array
        int[] copied = Arrays.copyOf(numbers, numbers.length);
        logger.info("Copied array: {}", Arrays.toString(copied));

        // Copy range
        int[] rangeCopy = Arrays.copyOfRange(numbers, 1, 4);
        logger.info("Copy of range [1, 4): {}", Arrays.toString(rangeCopy));

        // Equality check
        boolean areEqual = Arrays.equals(numbers, copied);
        logger.info("Arrays equal: {}", areEqual);

        // Convert to String
        logger.info("Array as String: {}", Arrays.toString(numbers));
    }
}
