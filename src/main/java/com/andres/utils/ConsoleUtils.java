package com.andres.utils;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class providing reusable methods for console interaction.
 * 
 * <p>
 * This class provides type-safe input reading methods with built-in validation
 * and error handling. It implements the Singleton pattern for Scanner
 * management
 * to avoid common issues with System.in closure.
 * </p>
 * 
 * <p>
 * <strong>Key Features:</strong>
 * </p>
 * <ul>
 * <li>Single Scanner instance (prevents System.in closure issues)</li>
 * <li>Automatic input validation with user-friendly error messages</li>
 * <li>Type-safe reading methods for common data types</li>
 * <li>Buffer management to prevent input stream pollution</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Context:</strong>
 * </p>
 * <ul>
 * <li>CLI applications requiring user input</li>
 * <li>Interactive menus and prompts</li>
 * <li>Data validation in console applications</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use this utility instead of creating multiple Scanner instances</li>
 * <li>Call closeScanner() only at application termination</li>
 * <li>Leverage validation to ensure type safety</li>
 * </ul>
 */
public final class ConsoleUtils {

    private static final Logger logger = LoggerFactory.getLogger(ConsoleUtils.class);
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Private constructor to prevent instantiation of utility class.
     */
    private ConsoleUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Reads a complete line of text from console.
     * 
     * @param prompt Message displayed to the user before reading input
     * @return The complete line entered by the user
     */
    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    /**
     * Reads an integer from console with automatic validation.
     * 
     * <p>
     * If the user enters a non-numeric value, an error message is displayed
     * and the input is requested again until a valid integer is provided.
     * </p>
     * 
     * @param prompt Message displayed to the user before reading input
     * @return The valid integer entered by the user
     */
    public static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                return value;
            } catch (Exception e) {
                logger.error("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear buffer after error
            }
        }
    }

    /**
     * Reads a double from console with automatic validation.
     * 
     * <p>
     * If the user enters a non-numeric value, an error message is displayed
     * and the input is requested again until a valid double is provided.
     * </p>
     * 
     * @param prompt Message displayed to the user before reading input
     * @return The valid double entered by the user
     */
    public static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                scanner.nextLine(); // Clear buffer
                return value;
            } catch (Exception e) {
                logger.error("Invalid input. Please enter a valid decimal number.");
                scanner.nextLine(); // Clear buffer after error
            }
        }
    }

    /**
     * Pauses execution until the user presses Enter.
     * 
     * <p>
     * Useful in interactive menus to allow users to read displayed
     * information before continuing.
     * </p>
     */
    public static void pressEnterToContinue() {
        System.out.print("\nPress Enter to continue...");
        scanner.nextLine();
    }

    /**
     * Safely closes the scanner resource.
     * 
     * <p>
     * <strong>Important:</strong> This method should only be called at
     * application termination, as it closes System.in.
     * </p>
     */
    public static void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
