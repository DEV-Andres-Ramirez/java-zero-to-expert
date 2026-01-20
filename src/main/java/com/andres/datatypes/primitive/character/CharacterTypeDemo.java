package com.andres.datatypes.primitive.character;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates the character primitive data type in Java.
 * 
 * <p>
 * <strong>Character Type Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Represents a single Unicode character (16 bits)</li>
 * <li>Range: 0 to 65,535 (unsigned)</li>
 * <li>Defined using single quotes: 'A', '字', '💻'</li>
 * <li>Can represent any Unicode character (including emojis)</li>
 * <li>Internally stored as unsigned integer (Unicode code point)</li>
 * </ul>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Character-by-character text processing</li>
 * <li>Parsing specific formats (CSV, JSON manual parsing)</li>
 * <li>Individual character validation</li>
 * <li>Character frequency analysis</li>
 * <li>Text encoding/decoding operations</li>
 * </ul>
 * 
 * <p>
 * <strong>Key Differences:</strong>
 * </p>
 * <ul>
 * <li>char vs String: char is single character, String is character
 * sequence</li>
 * <li>char is primitive, String is object (reference type)</li>
 * <li>char uses single quotes ('A'), String uses double quotes ("ABC")</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>For text in general, use String (not char)</li>
 * <li>Use char for single character operations</li>
 * <li>Leverage Character wrapper class for utility methods</li>
 * <li>Be aware of Unicode support (can handle international characters)</li>
 * </ul>
 */
public final class CharacterTypeDemo {

    private static final Logger logger = LoggerFactory.getLogger(CharacterTypeDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private CharacterTypeDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates character type usage and operations.
     */
    public static void demonstrate() {
        logger.info("--- Character Data Type ---\n");

        char letter = 'A';
        char digit = '5';
        char symbol = '@';
        char unicode = '\u0041'; // 'A' in Unicode

        logger.info("Letter: {}", letter);
        logger.info("Digit: {}", digit);
        logger.info("Symbol: {}", symbol);
        logger.info("Unicode (\\u0041): {}", unicode);

        // Unicode code point (numeric value)
        logger.info("\nUnicode code point of 'A': {}", (int) letter);
        logger.info("Size: {} bits, Range: {} to {}",
                Character.SIZE, (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);

        // Character utility methods
        demonstrateCharacterMethods();

        // Character comparisons
        demonstrateComparisons();

        System.out.println();
    }

    /**
     * Demonstrates utility methods from Character wrapper class.
     */
    private static void demonstrateCharacterMethods() {
        logger.info("\n--- Character Utility Methods ---");

        char ch = 'A';

        logger.info("Character: {}", ch);
        logger.info("isLetter(): {}", Character.isLetter(ch));
        logger.info("isDigit(): {}", Character.isDigit(ch));
        logger.info("isUpperCase(): {}", Character.isUpperCase(ch));
        logger.info("isLowerCase(): {}", Character.isLowerCase(ch));
        logger.info("toLowerCase(): {}", Character.toLowerCase(ch));
        logger.info("toUpperCase(): {}", Character.toUpperCase(ch));

        char space = ' ';
        logger.info("\nCharacter: '{}' (space)", space);
        logger.info("isWhitespace(): {}", Character.isWhitespace(space));
    }

    /**
     * Demonstrates character comparisons.
     */
    private static void demonstrateComparisons() {
        logger.info("\n--- Character Comparisons ---");

        char a = 'A';
        char b = 'B';
        char lowerA = 'a';

        logger.info("'A' == 'A': {}", a == 'A');
        logger.info("'A' == 'B': {}", a == b);
        logger.info("'A' == 'a': {}", a == lowerA);
        logger.info("'A' < 'B': {}", a < b);

        // Numeric comparison (based on Unicode values)
        logger.info("\nNumeric values:");
        logger.info("'A' = {}", (int) a);
        logger.info("'B' = {}", (int) b);
        logger.info("'a' = {}", (int) lowerA);
    }
}
