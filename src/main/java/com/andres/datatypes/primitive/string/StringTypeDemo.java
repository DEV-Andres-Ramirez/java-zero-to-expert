package com.andres.datatypes.primitive.string;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates String type in Java (technically a reference type with special
 * treatment).
 * 
 * <p>
 * <strong>Important Clarification:</strong>
 * </p>
 * <p>
 * String is NOT a primitive type - it's a class (reference type).
 * However, it has special treatment in Java:
 * </p>
 * <ul>
 * <li>Can be created without 'new' keyword: String s = "text";</li>
 * <li>Immutable (cannot change after creation)</li>
 * <li>Stored in String Pool for optimization</li>
 * <li>'+' operator overloaded for concatenation</li>
 * <li>Literals are automatically interned</li>
 * </ul>
 * 
 * <p>
 * <strong>String Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Immutable: Any modification creates a new String object</li>
 * <li>Thread-safe due to immutability</li>
 * <li>Backed by char[] array internally (Java 8) or byte[] (Java 9+)</li>
 * <li>Can contain Unicode characters</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Text of any length</li>
 * <li>Messages, names, descriptions</li>
 * <li>Map keys, JSON values</li>
 * <li>File paths and URLs</li>
 * <li>User input and output</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>For multiple concatenations, use StringBuilder (more efficient)</li>
 * <li>Compare with .equals(), NOT with ==</li>
 * <li>Validate for null or empty before processing</li>
 * <li>Use String.format() or formatted() for complex formatting</li>
 * <li>Consider using text blocks (""") for multiline strings (Java 15+)</li>
 * </ul>
 */
public final class StringTypeDemo {

    private static final Logger logger = LoggerFactory.getLogger(StringTypeDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private StringTypeDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates String type usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- String Type (Special Reference Type) ---\n");

        String greeting = "Hello, Java!";
        String name = "Andrés";

        logger.info("Greeting: {}", greeting);
        logger.info("Name: {}", name);

        // String methods
        demonstrateStringMethods(greeting);

        // String comparison
        demonstrateStringComparison();

        // String pool behavior
        demonstrateStringPool();

        // StringBuilder for efficiency
        demonstrateStringBuilder();

        System.out.println();
    }

    /**
     * Demonstrates common String methods.
     */
    private static void demonstrateStringMethods(String text) {
        logger.info("\n--- Common String Methods ---");

        logger.info("Original: {}", text);
        logger.info("Length: {}", text.length());
        logger.info("Uppercase: {}", text.toUpperCase());
        logger.info("Lowercase: {}", text.toLowerCase());
        logger.info("Contains 'Java': {}", text.contains("Java"));
        logger.info("Starts with 'Hello': {}", text.startsWith("Hello"));
        logger.info("Ends with '!': {}", text.endsWith("!"));
        logger.info("Replace 'Java' with 'World': {}", text.replace("Java", "World"));
        logger.info("Substring (0, 5): {}", text.substring(0, 5));
        logger.info("Character at index 7: {}", text.charAt(7));
        logger.info("Index of 'Java': {}", text.indexOf("Java"));

        // Trimming whitespace
        String withSpaces = "  trim me  ";
        logger.info("\nOriginal with spaces: '{}'", withSpaces);
        logger.info("After trim(): '{}'", withSpaces.trim());
    }

    /**
     * Demonstrates proper String comparison.
     * 
     * <p>
     * <strong>CRITICAL:</strong> Always use .equals() for String comparison,
     * NOT == operator. The == operator compares object references, not content.
     * </p>
     */
    private static void demonstrateStringComparison() {
        logger.info("\n--- String Comparison ---");

        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");

        logger.info("str1 = \"Java\" (literal)");
        logger.info("str2 = \"Java\" (literal)");
        logger.info("str3 = new String(\"Java\") (explicit object)");

        logger.info("\nUsing == (compares references):");
        logger.info("str1 == str2: {} (same object in String Pool)", str1 == str2);
        logger.info("str1 == str3: {} (different objects)", str1 == str3);

        logger.info("\nUsing .equals() (compares content) - CORRECT METHOD:");
        logger.info("str1.equals(str2): {}", str1.equals(str2));
        logger.info("str1.equals(str3): {}", str1.equals(str3));

        // Case-insensitive comparison
        logger.info("\nCase-insensitive comparison:");
        logger.info("\"Java\".equalsIgnoreCase(\"JAVA\"): {}", "Java".equalsIgnoreCase("JAVA"));
    }

    /**
     * Demonstrates String Pool behavior for optimization.
     * 
     * <p>
     * <strong>String Pool:</strong> JVM maintains a pool of String literals
     * to optimize memory. Identical literals share the same memory location.
     * </p>
     */
    private static void demonstrateStringPool() {
        logger.info("\n--- String Pool Behavior ---");

        String literal1 = "Hello";
        String literal2 = "Hello";
        String object = new String("Hello");

        logger.info("literal1 = \"Hello\" (in String Pool)");
        logger.info("literal2 = \"Hello\" (references same pool object)");
        logger.info("object = new String(\"Hello\") (separate object in heap)");

        logger.info("\nliteral1 == literal2: {} (same pool reference)", literal1 == literal2);
        logger.info("literal1 == object: {} (different memory locations)", literal1 == object);

        // intern() method
        String interned = object.intern();
        logger.info("\nAfter intern():");
        logger.info("literal1 == object.intern(): {} (now in pool)", literal1 == interned);
    }

    /**
     * Demonstrates StringBuilder for efficient string concatenation.
     * 
     * <p>
     * <strong>Why StringBuilder?</strong>
     * </p>
     * <p>
     * String is immutable. Each concatenation creates a new object.
     * For multiple concatenations (especially in loops), StringBuilder
     * is much more efficient.
     * </p>
     * 
     * <p>
     * <strong>When to use:</strong>
     * </p>
     * <ul>
     * <li>StringBuilder: Single-threaded scenarios (most common)</li>
     * <li>StringBuffer: Multi-threaded scenarios (synchronized)</li>
     * </ul>
     */
    private static void demonstrateStringBuilder() {
        logger.info("\n--- StringBuilder for Efficiency ---");

        // Inefficient (creates many temporary String objects)
        String inefficient = "";
        for (int i = 0; i < 5; i++) {
            inefficient += i + " "; // Each iteration creates new String
        }
        logger.info("Inefficient concatenation result: {}", inefficient);

        // Efficient (single mutable object)
        StringBuilder efficient = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            efficient.append(i).append(" ");
        }
        logger.info("Efficient StringBuilder result: {}", efficient.toString());

        // StringBuilder methods
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ",");
        sb.delete(11, 16);
        sb.reverse();

        logger.info("\nStringBuilder operations: {}", sb.toString());
    }
}
