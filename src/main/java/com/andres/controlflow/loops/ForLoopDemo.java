package com.andres.controlflow.loops;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the for loop in Java.
 * 
 * <p>
 * <strong>What is a for loop?</strong>
 * </p>
 * <p>
 * A control flow statement that executes a block of code a specific number of
 * times.
 * It's the most common loop when you know in advance how many iterations you
 * need.
 * </p>
 * 
 * <p>
 * <strong>Syntax:</strong>
 * </p>
 * 
 * <pre>
 * for (initialization; condition; update) {
 *     // Code block to execute
 * }
 * </pre>
 * 
 * <p>
 * <strong>Components:</strong>
 * </p>
 * <ul>
 * <li><strong>Initialization:</strong> Executes once at the start (typically
 * int i = 0)</li>
 * <li><strong>Condition:</strong> Checked before each iteration (i < 10)</li>
 * <li><strong>Update:</strong> Executes after each iteration (i++)</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use for Loop:</strong>
 * </p>
 * <ul>
 * <li>Iterating a specific number of times</li>
 * <li>Accessing array/list elements by index</li>
 * <li>Counting up or down</li>
 * <li>When you need the index/counter value</li>
 * <li>Nested loops for matrices or combinations</li>
 * </ul>
 * 
 * <p>
 * <strong>When NOT to Use:</strong>
 * </p>
 * <ul>
 * <li>Simple iteration over collections (use for-each instead)</li>
 * <li>Unknown number of iterations (use while instead)</li>
 * <li>Condition-based looping (use while instead)</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Array/list processing with index access</li>
 * <li>Generating sequences or patterns</li>
 * <li>Mathematical calculations and algorithms</li>
 * <li>Batch processing with known size</li>
 * <li>Multi-dimensional array traversal</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use descriptive variable names (index, i, j for nested)</li>
 * <li>Prefer for-each loop when index not needed</li>
 * <li>Avoid modifying loop variable inside the loop body</li>
 * <li>Keep loop body simple - extract complex logic to methods</li>
 * <li>Be cautious with infinite loops (check condition carefully)</li>
 * <li>Use break/continue judiciously</li>
 * </ul>
 */
public final class ForLoopDemo {

    private static final Logger logger = LoggerFactory.getLogger(ForLoopDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private ForLoopDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates for loop usage.
     */
    public static void demonstrate() {
        logger.info("--- For Loop ---\n");

        // Basic for loop
        demonstrateBasicForLoop();

        // Counting variations
        demonstrateCountingVariations();

        // Looping through arrays
        demonstrateArrayIteration();

        // Nested loops
        demonstrateNestedLoops();

        // Loop control (break, continue)
        demonstrateLoopControl();

        // Real-world examples
        demonstrateRealWorldExamples();

        System.out.println();
    }

    /**
     * Demonstrates basic for loop structure.
     */
    private static void demonstrateBasicForLoop() {
        logger.info("--- Basic For Loop ---");

        // Standard counting loop (0 to 4)
        logger.info("Counting from 0 to 4:");
        for (int i = 0; i < 5; i++) {
            logger.info("  i = {}", i);
        }

        // Counting from 1 to 5
        logger.info("\nCounting from 1 to 5:");
        for (int i = 1; i <= 5; i++) {
            logger.info("  i = {}", i);
        }
    }

    /**
     * Demonstrates different counting variations.
     */
    private static void demonstrateCountingVariations() {
        logger.info("\n--- Counting Variations ---");

        // Counting down
        logger.info("Counting down from 5 to 1:");
        for (int i = 5; i >= 1; i--) {
            logger.info("  i = {}", i);
        }

        // Counting by twos
        logger.info("\nCounting by twos (0, 2, 4, 6, 8):");
        for (int i = 0; i < 10; i += 2) {
            logger.info("  i = {}", i);
        }

        // Multiple variables
        logger.info("\nMultiple variables:");
        for (int i = 0, j = 10; i < 5; i++, j--) {
            logger.info("  i = {}, j = {}", i, j);
        }

        // Custom increment
        logger.info("\nCounting by fives:");
        for (int i = 0; i <= 20; i += 5) {
            logger.info("  i = {}", i);
        }
    }

    /**
     * Demonstrates iterating through arrays with for loop.
     */
    private static void demonstrateArrayIteration() {
        logger.info("\n--- Array Iteration ---");

        String[] fruits = { "Apple", "Banana", "Orange", "Mango" };

        // Forward iteration
        logger.info("Forward iteration:");
        for (int i = 0; i < fruits.length; i++) {
            logger.info("  [{}]: {}", i, fruits[i]);
        }

        // Reverse iteration
        logger.info("\nReverse iteration:");
        for (int i = fruits.length - 1; i >= 0; i--) {
            logger.info("  [{}]: {}", i, fruits[i]);
        }

        // Processing with index
        logger.info("\nProcessing even indices:");
        for (int i = 0; i < fruits.length; i += 2) {
            logger.info("  [{}]: {}", i, fruits[i]);
        }

        // List iteration
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        logger.info("\nList iteration:");
        for (int i = 0; i < numbers.size(); i++) {
            logger.info("  [{}]: {}", i, numbers.get(i));
        }
    }

    /**
     * Demonstrates nested for loops.
     * 
     * <p>
     * <strong>Use Cases:</strong> Matrices, combinations, patterns, nested data
     * </p>
     */
    private static void demonstrateNestedLoops() {
        logger.info("\n--- Nested For Loops ---");

        // Simple nested loop
        logger.info("2D iteration:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                logger.info("  i = {}, j = {}", i, j);
            }
        }

        // Multiplication table
        logger.info("\nMultiplication table (3x3):");
        for (int i = 1; i <= 3; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 1; j <= 3; j++) {
                row.append(String.format("%4d", i * j));
            }
            logger.info("{}", row);
        }

        // Pattern printing
        logger.info("\nTriangle pattern:");
        for (int i = 1; i <= 5; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 1; j <= i; j++) {
                line.append("* ");
            }
            logger.info("{}", line.toString().trim());
        }

        // 2D array processing
        logger.info("\n2D Array processing:");
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Demonstrates loop control statements (break, continue).
     */
    private static void demonstrateLoopControl() {
        logger.info("\n--- Loop Control (break, continue) ---");

        // break - exit loop early
        logger.info("Using break (stop at 5):");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                logger.info("  Breaking at i = {}", i);
                break;
            }
            logger.info("  i = {}", i);
        }

        // continue - skip current iteration
        logger.info("\nUsing continue (skip odd numbers):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue; // Skip odd numbers
            }
            logger.info("  i = {} (even)", i);
        }

        // Labeled break (for nested loops)
        logger.info("\nLabeled break in nested loop:");
        outerLoop: for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    logger.info("  Breaking outer loop at i={}, j={}", i, j);
                    break outerLoop; // Breaks the outer loop
                }
                logger.info("  i = {}, j = {}", i, j);
            }
        }
    }

    /**
     * Demonstrates real-world use cases.
     */
    private static void demonstrateRealWorldExamples() {
        logger.info("\n--- Real-World Examples ---");

        // Example 1: Sum of numbers
        logger.info("Example 1: Sum of numbers 1-10");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        logger.info("Sum: {}", sum);

        // Example 2: Factorial calculation
        logger.info("\nExample 2: Factorial of 5");
        int factorial = 1;
        for (int i = 1; i <= 5; i++) {
            factorial *= i;
        }
        logger.info("5! = {}", factorial);

        // Example 3: Finding elements
        logger.info("\nExample 3: Finding first even number");
        int[] numbers = { 1, 3, 5, 8, 9, 11 };
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                logger.info("First even number: {} at index {}", numbers[i], i);
                break;
            }
        }

        // Example 4: Data processing
        logger.info("\nExample 4: Processing list of prices");
        List<Double> prices = List.of(19.99, 29.99, 39.99, 49.99);
        double total = 0;
        for (int i = 0; i < prices.size(); i++) {
            total += prices.get(i);
            logger.info("  Item {}: ${}", i + 1, prices.get(i));
        }
        logger.info("Total: ${}", total);

        // Example 5: Building string
        logger.info("\nExample 5: Building CSV string");
        String[] data = { "Java", "Python", "JavaScript", "C++" };
        StringBuilder csv = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            csv.append(data[i]);
            if (i < data.length - 1) {
                csv.append(", ");
            }
        }
        logger.info("CSV: {}", csv);

        // Example 6: Batch processing
        logger.info("\nExample 6: Processing in batches of 3");
        List<Integer> items = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int batchSize = 3;
        for (int i = 0; i < items.size(); i += batchSize) {
            int end = Math.min(i + batchSize, items.size());
            List<Integer> batch = items.subList(i, end);
            logger.info("  Batch {}: {}", (i / batchSize) + 1, batch);
        }
    }
}
