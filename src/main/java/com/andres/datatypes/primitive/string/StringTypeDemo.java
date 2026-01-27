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

    // ========== Common String Methods ==========

    /**
     * Gets string length.
     *
     * @param text String to measure
     * @return Number of characters
     */
    public static int length(String text) {
        return text.length();
    }

    /**
     * Converts string to uppercase.
     *
     * @param text String to convert
     * @return Uppercase version
     */
    public static String toUpperCase(String text) {
        return text.toUpperCase();
    }

    /**
     * Converts string to lowercase.
     *
     * @param text String to convert
     * @return Lowercase version
     */
    public static String toLowerCase(String text) {
        return text.toLowerCase();
    }

    /**
     * Checks if string contains substring.
     *
     * @param text      String to search in
     * @param substring Substring to find
     * @return true if found
     */
    public static boolean contains(String text, String substring) {
        return text.contains(substring);
    }

    /**
     * Checks if string starts with prefix.
     *
     * @param text   String to check
     * @param prefix Prefix to look for
     * @return true if starts with prefix
     */
    public static boolean startsWith(String text, String prefix) {
        return text.startsWith(prefix);
    }

    /**
     * Checks if string ends with suffix.
     *
     * @param text   String to check
     * @param suffix Suffix to look for
     * @return true if ends with suffix
     */
    public static boolean endsWith(String text, String suffix) {
        return text.endsWith(suffix);
    }

    /**
     * Extracts substring.
     *
     * @param text  Source string
     * @param start Start index (inclusive)
     * @param end   End index (exclusive)
     * @return Substring
     */
    public static String substring(String text, int start, int end) {
        return text.substring(start, end);
    }

    /**
     * Replaces all occurrences.
     *
     * @param text        Source string
     * @param target      String to replace
     * @param replacement Replacement
     * @return New string with replacements
     */
    public static String replace(String text, String target, String replacement) {
        return text.replace(target, replacement);
    }

    /**
     * Removes leading/trailing whitespace.
     *
     * @param text String to trim
     * @return Trimmed string
     */
    public static String trim(String text) {
        return text.trim();
    }

    /**
     * Finds index of first occurrence.
     *
     * @param text      String to search in
     * @param substring Substring to find
     * @return Index, or -1 if not found
     */
    public static int indexOf(String text, String substring) {
        return text.indexOf(substring);
    }

    /**
     * Gets character at index.
     *
     * @param text  String
     * @param index Index
     * @return Character at index
     */
    public static char charAt(String text, int index) {
        return text.charAt(index);
    }

    // ========== String Comparison ==========

    /**
     * Compares strings for equality (content).
     * <p>
     * <strong>CRITICAL:</strong> Always use this, NOT ==.
     * </p>
     *
     * @param str1 First string
     * @param str2 Second string
     * @return true if same content
     */
    public static boolean areEqual(String str1, String str2) {
        return str1.equals(str2);
    }

    /**
     * Compares strings case-insensitively.
     *
     * @param str1 First string
     * @param str2 Second string
     * @return true if equal (ignoring case)
     */
    public static boolean areEqualIgnoreCase(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }

    // ========== Real-World Validation ==========

    /**
     * Checks if string is non-empty.
     *
     * @param text String to check
     * @return true if not null and not empty
     */
    public static boolean isNonEmpty(String text) {
        return text != null && !text.trim().isEmpty();
    }

    /**
     * Validates basic email format.
     *
     * @param email Email to validate
     * @return true if has @ with text before/after
     */
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        int atIndex = email.indexOf('@');
        return atIndex > 0 && atIndex < email.length() - 1;
    }

    /**
     * Extracts file extension.
     *
     * @param filename Filename
     * @return Extension without dot, or "" if none
     */
    public static String getFileExtension(String filename) {
        if (filename == null) return "";
        int lastDot = filename.lastIndexOf('.');
        if (lastDot == -1 || lastDot == filename.length() - 1) {
            return "";
        }
        return filename.substring(lastDot + 1);
    }

    /**
     * Checks if string is valid integer.
     *
     * @param text String to check
     * @return true if can be parsed as int
     */
    public static boolean isInteger(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(text.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Counts substring occurrences.
     *
     * @param text      Text to search
     * @param substring Substring to count
     * @return Number of occurrences
     */
    public static int countOccurrences(String text, String substring) {
        if (text == null || substring == null || substring.isEmpty()) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }

    // ========== StringBuilder for Efficiency ==========

    /**
     * Efficiently concatenates strings.
     *
     * @param strings Strings to concatenate
     * @return Concatenated result
     */
    public static String efficientConcat(String... strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s);
        }
        return sb.toString();
    }

    /**
     * Builds query string from key-value pairs.
     * <p>
     * Example: buildQueryString("name", "John", "age", "30") → "name=John&age=30"
     * </p>
     *
     * @param params Key-value pairs (even number required)
     * @return Query string
     */
    public static String buildQueryString(String... params) {
        if (params.length % 2 != 0) {
            throw new IllegalArgumentException("Params must be key-value pairs");
        }
        if (params.length == 0) return "";

        StringBuilder query = new StringBuilder();
        for (int i = 0; i < params.length; i += 2) {
            if (i > 0) query.append("&");
            query.append(params[i]).append("=").append(params[i + 1]);
        }
        return query.toString();
    }

    /**
     * Joins strings with delimiter.
     *
     * @param delimiter Delimiter
     * @param strings   Strings to join
     * @return Joined string
     */
    public static String join(String delimiter, String... strings) {
        if (strings.length == 0) return "";

        StringBuilder result = new StringBuilder(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            result.append(delimiter).append(strings[i]);
        }
        return result.toString();
    }

    /**
     * Repeats string n times.
     *
     * @param text  String to repeat
     * @param times Number of repetitions
     * @return Repeated string
     */
    public static String repeat(String text, int times) {
        if (times <= 0) return "";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(text);
        }
        return result.toString();
    }

    // ========== Demonstrations (Educational - with logging) ==========

    /**
     * Demonstrates String comparison (== vs .equals()).
     * <p>
     * <strong>Educational purpose:</strong> Shows why == fails for String comparison.
     * Always use .equals() for content comparison.
     * </p>
     */
    public static void demonstrateComparison() {
        logger.warn("=== STRING COMPARISON ===");

        String str1 = "Java";
        String str2 = "Java";
        String str3 = new String("Java");

        logger.info("str1 = \"Java\" (literal)");
        logger.info("str2 = \"Java\" (literal)");
        logger.info("str3 = new String(\"Java\") (object)");

        logger.warn("\nUsing == (compares references):");
        logger.info("  str1 == str2: {} (same String Pool object)", str1 == str2);
        logger.info("  str1 == str3: {} (different objects)", str1 == str3);

        logger.info("\nUsing .equals() (compares content) - CORRECT:");
        logger.info("  str1.equals(str2): {}", str1.equals(str2));
        logger.info("  str1.equals(str3): {}", str1.equals(str3));

        logger.error("ALWAYS use .equals() for String comparison!");
        logger.warn("========================\n");
    }

    /**
     * Demonstrates String Pool behavior.
     * <p>
     * <strong>Educational purpose:</strong> Shows how JVM optimizes String literals
     * by reusing them from String Pool.
     * </p>
     */
    public static void demonstrateStringPool() {
        logger.info("=== STRING POOL BEHAVIOR ===");

        String literal1 = "Hello";
        String literal2 = "Hello";
        String object = new String("Hello");

        logger.info("literal1 = \"Hello\" (in String Pool)");
        logger.info("literal2 = \"Hello\" (references same pool object)");
        logger.info("object = new String(\"Hello\") (separate heap object)");

        logger.info("\nliteral1 == literal2: {} (same pool reference)", literal1 == literal2);
        logger.info("literal1 == object: {} (different locations)", literal1 == object);

        String interned = object.intern();
        logger.info("\nAfter intern():");
        logger.info("literal1 == object.intern(): {} (now in pool)", literal1 == interned);

        logger.info("============================\n");
    }
}
