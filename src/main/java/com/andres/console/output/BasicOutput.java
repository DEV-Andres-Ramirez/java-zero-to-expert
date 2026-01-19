package com.andres.console.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates basic console output operations in Java.
 * 
 * <p>
 * <strong>What are console output operations?</strong>
 * </p>
 * <p>
 * Mechanisms for displaying information to the user through the command line
 * interface, using standard output streams.
 * </p>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>CLI (Command Line Interface) applications</li>
 * <li>Automation scripts and development tools</li>
 * <li>Debugging and logging during development</li>
 * <li>Batch applications or background processes</li>
 * <li>Command-line tools (Maven, Gradle, Git-like tools)</li>
 * </ul>
 * 
 * <p>
 * <strong>Key Differences: System.out vs Logger:</strong>
 * </p>
 * <ul>
 * <li><strong>System.out:</strong> Standard output, simple and direct, no
 * levels or formatting</li>
 * <li><strong>Logger (SLF4J):</strong> Professional system with levels (INFO,
 * WARN, ERROR),
 * configurable format, file rotation, better for production</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use Logger instead of System.out for professional applications</li>
 * <li>Provide clear and descriptive messages</li>
 * <li>Use appropriate log levels (INFO for normal flow, WARN for warnings,
 * ERROR for errors)</li>
 * <li>Avoid excessive logging in production (performance impact)</li>
 * </ul>
 */
public final class BasicOutput {

    private static final Logger logger = LoggerFactory.getLogger(BasicOutput.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private BasicOutput() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates basic output using different methods.
     * 
     * <p>
     * <strong>Differences between print, println, and printf:</strong>
     * </p>
     * <ul>
     * <li><strong>print:</strong> Prints without newline at the end</li>
     * <li><strong>println:</strong> Prints with newline at the end</li>
     * <li><strong>printf:</strong> Prints with specific format (C-style)</li>
     * </ul>
     * 
     * <p>
     * <strong>When to use each:</strong>
     * </p>
     * <ul>
     * <li>print: When continuing on the same line</li>
     * <li>println: For independent messages (most common case)</li>
     * <li>printf: When specific formatting is needed (numbers, alignment)</li>
     * </ul>
     */
    public static void demonstrateBasicOutput() {
        logger.info("--- Basic Console Output ---\n");

        // Using System.out.println
        System.out.println("Message using println (with newline)");

        // Using System.out.print
        System.out.print("Message using print (without newline) - ");
        System.out.println("Continuation on same line\n");

        // Using Logger (Professional recommended method)
        logger.info("Message using Logger - INFO level");
        logger.warn("Message using Logger - WARN level");
        logger.error("Message using Logger - ERROR level\n");
    }

    /**
     * Demonstrates error output using System.err.
     * 
     * <p>
     * <strong>When to use System.err vs System.out?</strong>
     * </p>
     * <ul>
     * <li><strong>System.out:</strong> For normal program output</li>
     * <li><strong>System.err:</strong> For error messages and diagnostics</li>
     * </ul>
     * 
     * <p>
     * <strong>Advantage:</strong> Can be redirected independently in terminal:
     * </p>
     * 
     * <pre>
     * java App > output.txt 2> errors.txt
     * </pre>
     * 
     * <p>
     * <strong>Note:</strong> In production, use Logger instead of System.err
     * </p>
     */
    public static void demonstrateErrorOutput() {
        logger.info("--- Error Output ---\n");

        System.out.println("This is a normal message (System.out)");
        System.err.println("This is an error message (System.err)");

        logger.info("This is an INFO message from logger");
        logger.error("This is an ERROR message from logger");

        System.out.println();
    }
}
