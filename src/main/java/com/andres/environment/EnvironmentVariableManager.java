package com.andres.environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages environment variable operations and provides utility methods for
 * accessing
 * system environment configuration.
 * 
 * <p>
 * <strong>What are environment variables?</strong>
 * </p>
 * <p>
 * Dynamic values that affect running processes on the operating system. They
 * are
 * used to configure applications without modifying source code.
 * </p>
 * 
 * <p>
 * <strong>Usage Contexts:</strong>
 * </p>
 * <ul>
 * <li>Environment-specific configuration (dev, staging, prod)</li>
 * <li>Storing credentials and secrets (API keys, passwords)</li>
 * <li>System path configuration (JAVA_HOME, PATH)</li>
 * <li>Configuration separation from code (12-Factor App principle)</li>
 * </ul>
 * 
 * <p>
 * <strong>Key Differences:</strong>
 * </p>
 * <ul>
 * <li>External to code and can vary between environments</li>
 * <li>Not compiled with the application</li>
 * <li>Can be modified without recompiling code</li>
 * <li>Ideal for sensitive information (should not be in code)</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>NEVER store secrets in source code</li>
 * <li>Use environment variables for environment-specific configuration</li>
 * <li>Document required environment variables</li>
 * <li>Provide default values when appropriate</li>
 * <li>Validate critical variables exist at application startup</li>
 * </ul>
 */
public final class EnvironmentVariableManager {

    private static final Logger logger = LoggerFactory.getLogger(EnvironmentVariableManager.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private EnvironmentVariableManager() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Displays all available environment variables in the system.
     * 
     * <p>
     * <strong>When to use:</strong> For debugging or environment auditing.
     * Not recommended in production due to security concerns.
     * </p>
     * 
     * <p>
     * <strong>Security Note:</strong> This method may expose sensitive
     * information. Use only in development environments.
     * </p>
     */
    public static void displayAllEnvironmentVariables() {
        logger.info("--- All Environment Variables ---");

        System.getenv().forEach((key, value) -> logger.info("{}: {}", key, value));

        logger.info("\nTotal variables: {}\n", System.getenv().size());
    }

    /**
     * Displays the value of a specific environment variable.
     * 
     * <p>
     * <strong>When to use:</strong> To retrieve specific configuration
     * such as paths, credentials, or configuration flags.
     * </p>
     * 
     * @param variableName Name of the environment variable to query
     */
    public static void displaySpecificVariable(String variableName) {
        logger.info("--- Environment Variable: {} ---", variableName);

        String value = System.getenv(variableName);

        if (value != null) {
            logger.info("{}: {}\n", variableName, value);
        } else {
            logger.warn("Variable '{}' is not defined in the environment.\n", variableName);
        }
    }

    /**
     * Retrieves an environment variable value with a default fallback.
     * 
     * <p>
     * <strong>When to use:</strong> When a default value is needed
     * if the variable is not defined, avoiding NullPointerException.
     * </p>
     * 
     * <p>
     * <strong>Example usage:</strong>
     * </p>
     * 
     * <pre>
     * String apiUrl = EnvironmentVariableManager.getVariable("API_URL", "http://localhost:8080");
     * </pre>
     * 
     * @param variableName Name of the environment variable
     * @param defaultValue Value to return if variable doesn't exist
     * @return The variable value or the default value
     */
    public static String getVariable(String variableName, String defaultValue) {
        String value = System.getenv(variableName);
        return value != null ? value : defaultValue;
    }

    /**
     * Validates that a required environment variable exists.
     * 
     * <p>
     * <strong>When to use:</strong> At application startup to validate
     * that all critical configurations are present.
     * </p>
     * 
     * @param variableName Name of the environment variable to validate
     * @return true if the variable exists, false otherwise
     */
    public static boolean isVariableDefined(String variableName) {
        return System.getenv(variableName) != null;
    }

    /**
     * Validates that multiple required environment variables exist.
     * 
     * <p>
     * <strong>When to use:</strong> To validate complete configuration
     * at application startup.
     * </p>
     * 
     * @param variableNames Names of variables to validate
     * @throws IllegalStateException if any variable is not defined
     */
    public static void validateRequiredVariables(String... variableNames) {
        for (String variableName : variableNames) {
            if (!isVariableDefined(variableName)) {
                throw new IllegalStateException(
                        String.format("Required environment variable not found: %s", variableName));
            }
        }
        logger.info("All required environment variables are properly configured.");
    }
}
