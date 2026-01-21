package com.andres;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andres.console.input.InputReader;
import com.andres.console.output.BasicOutput;
import com.andres.console.output.FormattedOutput;
import com.andres.datatypes.composite.arrays.MultiDimensionArrayDemo;
import com.andres.datatypes.composite.arrays.SingleDimensionArrayDemo;
import com.andres.datatypes.composite.collections.lists.ArrayListDemo;
import com.andres.datatypes.composite.collections.maps.HashMapDemo;
import com.andres.datatypes.composite.collections.queues.DequeDemo;
import com.andres.datatypes.composite.collections.queues.QueueDemo;
import com.andres.datatypes.composite.collections.sets.HashSetDemo;
import com.andres.datatypes.composite.numeric.BigDecimalDemo;
import com.andres.datatypes.primitive.bool.BooleanTypeDemo;
import com.andres.datatypes.primitive.casting.TypeCastingDemo;
import com.andres.datatypes.primitive.character.CharacterTypeDemo;
import com.andres.datatypes.primitive.floatingpoint.FloatingPointTypesDemo;
import com.andres.datatypes.primitive.integers.IntegerTypesDemo;
import com.andres.datatypes.primitive.string.StringTypeDemo;
import com.andres.environment.EnvironmentVariableManager;
import com.andres.utils.ConsoleUtils;

/**
 * Main entry point for the Java Zero to Expert application.
 * 
 * <p>
 * This project serves as a comprehensive Java reference repository,
 * demonstrating
 * functionality from basic concepts to advanced modern features. Each topic is
 * organized
 * into dedicated packages and classes with well-documented examples and
 * specific use cases.
 * </p>
 * 
 * <p>
 * The application provides an interactive menu system for exploring different
 * Java topics in an organized and educational manner.
 * </p>
 * 
 * @author Andrés
 * @version 2.0
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("=== Welcome to Java Zero to Expert ===\n");
        displayMainMenu();

        /*
         * Adapt the following code to the Java base I am implementing and separate them
         * according to the topics, which are: if, else, ternary, switch, for, foreach,
         * while, do-while and streams (Just the basics of the latter, because we will
         * look at it in more detail later on)
         */

        // If and else and else if
        int age = 17;
        if (age < 18) {
            logger.info("You are underage.");
        } else if (age >= 18 && age < 65) {
            logger.info("You are an adult.");
        } else {
            logger.info("You are a senior citizen.");
        }

        // Ternary operator
        String access = (age >= 18) ? "granted" : "denied";
        logger.info("Access " + access + ".");

        // Switch
        String day = "MONDAY";
        switch (day) {
            case "MONDAY" -> logger.info("Start of the work week.");
            case "FRIDAY" -> logger.info("End of the work week.");
            case "SATURDAY" -> logger.info("Start of the weekend.");
            case "SUNDAY" -> logger.info("End of the weekend.");
            default -> logger.info("Midweek day.");
        }

        // For
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 3; j++) {
                logger.info("For loop iteration: i=" + i + ", j=" + j);
            }
        }

        // Foreach
        String[] fruits = { "Apple", "Banana", "Cherry" };
        for (String fruit : fruits) {
            logger.info("Fruit: " + fruit);
        }

        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        numbers.forEach(number -> logger.info("Number: " + number));

        // While
        int count = 1;
        while (count <= 5) {
            logger.info("While loop count: " + count);
            count++;
        }

        // Do-while
        int doCount = 1;
        do {
            logger.info("Do-while loop count: " + doCount);
            doCount++;
        } while (doCount <= 5);

        // Streams (basic example)
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> logger.info("Even number from stream: " + n));
                // The result of the example is: 2 and 4

        numbers.stream()
                .map(n -> n * n)
                .forEach(n -> logger.info("Squared number from stream: " + n));
                // The result of the example is: 1, 4, 9, 16 and 25

    }

    /**
     * Displays the main menu and handles user navigation.
     */
    private static void displayMainMenu() {
        boolean exit = false;

        while (!exit) {
            logger.info("|----------------------------------------|");
            logger.info("|         MAIN MENU                      |");
            logger.info("|----------------------------------------|");
            logger.info("| 1. Environment Variables               |");
            logger.info("| 2. Console Operations                  |");
            logger.info("| 3. Primitive Data Types                |");
            logger.info("| 4. Composite Data Types                |");
            logger.info("| 0. Exit                                |");
            logger.info("|----------------------------------------|\n");

            int option = ConsoleUtils.readInt("Select an option: ");

            switch (option) {
                case 1:
                    executeEnvironmentVariablesExamples();
                    break;
                case 2:
                    executeConsoleOperationsMenu();
                    break;
                case 3:
                    executePrimitiveDataTypesMenu();
                    break;
                case 4:
                    executeCompositeDataTypesMenu();
                    break;
                case 0:
                    exit = true;
                    logger.info("Goodbye!");
                    break;
                default:
                    logger.warn("Invalid option. Please try again.\n");
            }
        }
    }

    /**
     * Executes environment variable examples.
     */
    private static void executeEnvironmentVariablesExamples() {
        logger.info("=== ENVIRONMENT VARIABLES ===\n");

        EnvironmentVariableManager.displayAllEnvironmentVariables();
        EnvironmentVariableManager.displaySpecificVariable("PATH");
        EnvironmentVariableManager.displaySpecificVariable("JAVA_HOME");
        EnvironmentVariableManager.displaySpecificVariable("CLAVE");

        ConsoleUtils.pressEnterToContinue();
    }

    /**
     * Displays console operations submenu.
     */
    private static void executeConsoleOperationsMenu() {
        boolean back = false;

        while (!back) {
            logger.info("|----------------------------------------|");
            logger.info("|     CONSOLE OPERATIONS                 |");
            logger.info("|----------------------------------------|");
            logger.info("| 1. Basic Output                        |");
            logger.info("| 2. Formatted Output                    |");
            logger.info("| 3. Input Capture                       |");
            logger.info("| 0. Back to Main Menu                   |");
            logger.info("|----------------------------------------|\n");

            int option = ConsoleUtils.readInt("Select an option: ");

            switch (option) {
                case 1:
                    BasicOutput.demonstrateBasicOutput();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 2:
                    FormattedOutput.demonstrateFormattedOutput();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 3:
                    InputReader.demonstrateInputCapture();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    logger.warn("Invalid option. Please try again.\n");
            }
        }
    }

    /**
     * Displays primitive data types submenu.
     */
    private static void executePrimitiveDataTypesMenu() {
        boolean back = false;

        while (!back) {
            logger.info("|----------------------------------------|");
            logger.info("|     PRIMITIVE DATA TYPES               |");
            logger.info("|----------------------------------------|");
            logger.info("| 1. Integer Types                       |");
            logger.info("| 2. Floating Point Types                |");
            logger.info("| 3. Character Type                      |");
            logger.info("| 4. Boolean Type                        |");
            logger.info("| 5. String Type                         |");
            logger.info("| 6. Type Casting                        |");
            logger.info("| 0. Back to Main Menu                   |");
            logger.info("|----------------------------------------|\n");

            int option = ConsoleUtils.readInt("Select an option: ");

            switch (option) {
                case 1:
                    IntegerTypesDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 2:
                    FloatingPointTypesDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 3:
                    CharacterTypeDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 4:
                    BooleanTypeDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 5:
                    StringTypeDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 6:
                    TypeCastingDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    logger.warn("Invalid option. Please try again.\n");
            }
        }
    }

    /**
     * Displays composite data types submenu.
     */
    private static void executeCompositeDataTypesMenu() {
        boolean back = false;

        while (!back) {
            logger.info("|----------------------------------------|");
            logger.info("|     COMPOSITE DATA TYPES               |");
            logger.info("|----------------------------------------|");
            logger.info("| 1. Arrays (1D)                         |");
            logger.info("| 2. Arrays (Multidimensional)           |");
            logger.info("| 3. ArrayList                           |");
            logger.info("| 4. HashMap                             |");
            logger.info("| 5. HashSet                             |");
            logger.info("| 6. Queue                               |");
            logger.info("| 7. Deque                               |");
            logger.info("| 8. BigDecimal                          |");
            logger.info("| 0. Back to Main Menu                   |");
            logger.info("|----------------------------------------|\n");

            int option = ConsoleUtils.readInt("Select an option: ");

            switch (option) {
                case 1:
                    SingleDimensionArrayDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 2:
                    MultiDimensionArrayDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 3:
                    ArrayListDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 4:
                    HashMapDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 5:
                    HashSetDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 6:
                    QueueDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 7:
                    DequeDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 8:
                    BigDecimalDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    logger.warn("Invalid option. Please try again.\n");
            }
        }
    }
}
