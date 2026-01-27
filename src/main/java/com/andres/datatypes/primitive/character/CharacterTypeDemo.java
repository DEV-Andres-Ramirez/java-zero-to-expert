package com.andres.datatypes.primitive.character;

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

    /**
     * Private constructor to prevent instantiation.
     */
    private CharacterTypeDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    // ========== Character Classification ==========

    /**
     * Checks if character is a letter.
     *
     * @param ch Character to check
     * @return true if ch is a letter (A-Z, a-z, or Unicode letter)
     */
    public static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    /**
     * Checks if character is a digit.
     *
     * @param ch Character to check
     * @return true if ch is a digit (0-9)
     */
    public static boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    /**
     * Checks if character is whitespace.
     *
     * @param ch Character to check
     * @return true if ch is whitespace (space, tab, newline, etc.)
     */
    public static boolean isWhitespace(char ch) {
        return Character.isWhitespace(ch);
    }

    /**
     * Checks if character is uppercase letter.
     *
     * @param ch Character to check
     * @return true if ch is uppercase letter
     */
    public static boolean isUpperCase(char ch) {
        return Character.isUpperCase(ch);
    }

    /**
     * Checks if character is lowercase letter.
     *
     * @param ch Character to check
     * @return true if ch is lowercase letter
     */
    public static boolean isLowerCase(char ch) {
        return Character.isLowerCase(ch);
    }

    /**
     * Checks if character is alphanumeric (letter or digit).
     *
     * @param ch Character to check
     * @return true if ch is letter or digit
     */
    public static boolean isAlphanumeric(char ch) {
        return Character.isLetterOrDigit(ch);
    }

    // ========== Case Conversion ==========

    /**
     * Converts character to uppercase.
     *
     * @param ch Character to convert
     * @return Uppercase version of ch
     */
    public static char toUpperCase(char ch) {
        return Character.toUpperCase(ch);
    }

    /**
     * Converts character to lowercase.
     *
     * @param ch Character to convert
     * @return Lowercase version of ch
     */
    public static char toLowerCase(char ch) {
        return Character.toLowerCase(ch);
    }

    // ========== Unicode Conversion ==========

    /**
     * Gets Unicode code point value of character.
     *
     * @param ch Character
     * @return Unicode code point (numeric value)
     */
    public static int charToCodePoint(char ch) {
        return (int) ch;
    }

    /**
     * Converts code point to character.
     *
     * @param codePoint Unicode code point
     * @return Character corresponding to code point
     */
    public static char codePointToChar(int codePoint) {
        return (char) codePoint;
    }

    // ========== Character Comparison ==========

    /**
     * Checks if first character is greater than second.
     * <p>
     * Compares based on Unicode values.
     * </p>
     *
     * @param a First character
     * @param b Second character
     * @return true if a > b (by Unicode value)
     */
    public static boolean isGreater(char a, char b) {
        return a > b;
    }

    /**
     * Checks if first character is less than second.
     *
     * @param a First character
     * @param b Second character
     * @return true if a < b (by Unicode value)
     */
    public static boolean isLess(char a, char b) {
        return a < b;
    }

    /**
     * Checks if two characters are equal.
     *
     * @param a First character
     * @param b Second character
     * @return true if a equals b
     */
    public static boolean areEqual(char a, char b) {
        return a == b;
    }

    // ========== Real-World Examples ==========

    /**
     * Checks if password contains at least one uppercase letter.
     * <p>
     * Password strength requirement: must have uppercase character.
     * </p>
     *
     * @param password Password to check
     * @return true if password contains at least one uppercase letter
     */
    public static boolean hasUppercase(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if password contains at least one digit.
     * <p>
     * Password strength requirement: must have numeric character.
     * </p>
     *
     * @param password Password to check
     * @return true if password contains at least one digit
     */
    public static boolean hasDigit(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if password contains at least one special character.
     * <p>
     * Special character: not letter, not digit, not whitespace.
     * </p>
     *
     * @param password Password to check
     * @return true if password contains special character
     */
    public static boolean hasSpecialChar(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        for (char ch : password.toCharArray()) {
            if (!Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Counts number of letters in string.
     *
     * @param text Text to analyze
     * @return Number of letter characters
     */
    public static int countLetters(String text) {
        if (text == null) return 0;

        int count = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Counts number of digits in string.
     *
     * @param text Text to analyze
     * @return Number of digit characters
     */
    public static int countDigits(String text) {
        if (text == null) return 0;

        int count = 0;
        for (char ch : text.toCharArray()) {
            if (Character.isDigit(ch)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Checks if string contains only alphanumeric characters.
     *
     * @param text Text to check
     * @return true if all characters are letters or digits
     */
    public static boolean isAlphanumericString(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }

        for (char ch : text.toCharArray()) {
            if (!Character.isLetterOrDigit(ch)) {
                return false;
            }
        }
        return true;
    }
}
