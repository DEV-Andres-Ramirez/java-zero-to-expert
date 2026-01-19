package com.andres.console.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates formatted console output using printf and Logger placeholders.
 * 
 * <p>
 * <strong>What is formatted output?</strong>
 * </p>
 * <p>
 * A way to display data with specific formatting, alignment, precision, and
 * structure, making output more readable and professional.
 * </p>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Reports and data tables</li>
 * <li>Aligned column output</li>
 * <li>Precise number formatting (decimals, padding)</li>
 * <li>Structured logs and diagnostics</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use Logger with placeholders {} for production code</li>
 * <li>Use printf for complex formatting needs (tables, reports)</li>
 * <li>Choose appropriate format specifiers for data types</li>
 * <li>Maintain consistent formatting across the application</li>
 * </ul>
 */
public final class FormattedOutput {

    private static final Logger logger = LoggerFactory.getLogger(FormattedOutput.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private FormattedOutput() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates formatted output using printf.
     * 
     * <p>
     * <strong>Common format specifiers:</strong>
     * </p>
     * <ul>
     * <li>%s - String</li>
     * <li>%d - Integer (decimal)</li>
     * <li>%f - Floating point number</li>
     * <li>%n - Newline (portable)</li>
     * <li>%.2f - Float with 2 decimal places</li>
     * <li>%10s - String with minimum width of 10 characters</li>
     * <li>%-10s - Left-aligned string with width 10</li>
     * </ul>
     * 
     * <p>
     * <strong>When to use:</strong> For reports, tables, or when precise
     * alignment and number formatting is required.
     * </p>
     */
    public static void demonstrateFormattedOutput() {
        logger.info("--- Formatted Console Output ---\n");

        String name = "Andrés";
        int age = 28;
        double height = 1.75;

        // Basic formatting
        System.out.printf("Name: %s%n", name);
        System.out.printf("Age: %d years%n", age);
        System.out.printf("Height: %.2f meters%n", height);

        // Formatted table with alignment
        System.out.println("\nExample of formatted table:");
        System.out.printf("%-15s | %5s | %8s%n", "Name", "Age", "Height");
        System.out.printf("%-15s-+-%5s-+-%8s%n", "---------------", "-----", "--------");
        System.out.printf("%-15s | %5d | %8.2fm%n", name, age, height);
        System.out.printf("%-15s | %5d | %8.2fm%n", "María", 25, 1.68);
        System.out.printf("%-15s | %5d | %8.2fm%n", "Carlos", 30, 1.82);

        // Using Logger with placeholders {} (recommended for production)
        logger.info("\nUsing Logger with placeholders:");
        logger.info("Name: {}, Age: {}, Height: {}m", name, age, height);

        // Advanced formatting: padding and precision
        System.out.println("\nAdvanced formatting examples:");
        double pi = Math.PI;
        System.out.printf("Pi with default precision: %f%n", pi);
        System.out.printf("Pi with 2 decimals: %.2f%n", pi);
        System.out.printf("Pi with 5 decimals: %.5f%n", pi);
        System.out.printf("Pi with padding (width 10): %10.2f%n", pi);

        System.out.println();
    }
}
