package com.andres.console.input;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andres.utils.ConsoleUtils;

/**
 * Demonstrates console input capture for different data types.
 * 
 * <p>
 * <strong>What is console input capture?</strong>
 * </p>
 * <p>
 * The process of reading data from the user through the command line interface,
 * typically using the Scanner class to read from System.in.
 * </p>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Interactive CLI applications</li>
 * <li>User data collection and validation</li>
 * <li>Configuration wizards and setup scripts</li>
 * <li>Interactive menus and prompts</li>
 * </ul>
 * 
 * <p>
 * <strong>Important Scanner Considerations:</strong>
 * </p>
 * <ul>
 * <li>Scanner.nextLine() reads entire line including spaces</li>
 * <li>Scanner.nextInt(), nextDouble() do NOT consume the newline</li>
 * <li>After nextInt() or nextDouble(), call nextLine() to clear buffer</li>
 * <li>InputMismatchException thrown if type doesn't match expected</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Always validate and handle exceptions</li>
 * <li>Provide clear messages about expected input</li>
 * <li>Use try-catch for numeric inputs</li>
 * <li>Implement reusable utilities (see ConsoleUtils)</li>
 * <li>Use single Scanner instance (avoid closing System.in)</li>
 * </ul>
 */
public final class InputReader {

    private static final Logger logger = LoggerFactory.getLogger(InputReader.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private InputReader() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates capturing different types of input from console.
     * 
     * <p>
     * This method shows how to safely read String, int, and double values
     * from user input using the ConsoleUtils utility class, which provides
     * automatic validation and error handling.
     * </p>
     * 
     * <p>
     * <strong>Example flow:</strong>
     * </p>
     * 
     * <pre>
     * 1. Prompt user for text input
     * 2. Capture and validate text
     * 3. Prompt user for integer input
     * 4. Capture and validate integer (retry if invalid)
     * 5. Prompt user for decimal input
     * 6. Capture and validate decimal (retry if invalid)
     * </pre>
     */
    public static void demonstrateInputCapture() {
        logger.info("--- Console Input Capture ---\n");

        // String capture
        String textInput = ConsoleUtils.readLine("Enter some text: ");
        logger.info("Text captured: {}", textInput);

        // Integer capture with validation
        int numberInput = ConsoleUtils.readInt("Enter an integer number: ");
        logger.info("Integer captured: {}", numberInput);

        // Double capture with validation
        double decimalInput = ConsoleUtils.readDouble("Enter a decimal number: ");
        logger.info("Decimal captured: {}", decimalInput);

        System.out.println();
    }

    /**
     * Demonstrates manual input capture without utility methods.
     * 
     * <p>
     * <strong>Note:</strong> This is for educational purposes to show
     * the underlying mechanics. In production code, prefer using
     * ConsoleUtils methods which handle validation automatically.
     * </p>
     * 
     * <p>
     * <strong>Common pitfalls demonstrated:</strong>
     * </p>
     * <ul>
     * <li>Buffer management after numeric reads</li>
     * <li>Exception handling for type mismatches</li>
     * <li>Proper resource management</li>
     * </ul>
     */
    public static void demonstrateManualInputCapture() {
        logger.info("--- Manual Input Capture (Educational) ---\n");
        logger.info("This demonstrates the underlying mechanics of input capture.");
        logger.info("In production, use ConsoleUtils methods instead.\n");

        // The actual implementation would go here
        // This method serves as documentation for the low-level approach
    }
}
