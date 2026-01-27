package com.andres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andres.console.input.InputReader;
import com.andres.console.output.BasicOutput;
import com.andres.console.output.FormattedOutput;
import com.andres.controlflow.conditionals.IfElseDemo;
import com.andres.controlflow.conditionals.SwitchDemo;
import com.andres.controlflow.conditionals.TernaryOperatorDemo;
import com.andres.controlflow.loops.DoWhileLoopDemo;
import com.andres.controlflow.loops.ForEachLoopDemo;
import com.andres.controlflow.loops.ForLoopDemo;
import com.andres.controlflow.loops.WhileLoopDemo;
import com.andres.controlflow.streams.StreamBasicsDemo;
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
import com.andres.functions.methods.MethodBasicsDemo;
import com.andres.functions.methods.MethodOverloadingDemo;
import com.andres.functions.methods.ParameterPassingDemo;
import com.andres.functions.methods.ReturnTypesDemo;
import com.andres.functions.methods.VariableArgumentsDemo;
import com.andres.functions.recursion.RecursionBasicsDemo;
import com.andres.functions.recursion.RecursionPatternsDemo;
import com.andres.functions.recursion.RecursionVsIterationDemo;
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
 * @version 2.1
 */
public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("=== Welcome to Java Zero to Expert ===\n");
        displayMainMenu();
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
            logger.info("| 5. Control Flow                        |");
            logger.info("| 6. Methods and Functions               |");
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
                case 5:
                    executeControlFlowMenu();
                    break;
                case 6:
                    executeMethodsAndFunctionsMenu();
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

    /**
     * Displays control flow submenu.
     */
    private static void executeControlFlowMenu() {
        boolean back = false;

        while (!back) {
            logger.info("|----------------------------------------|");
            logger.info("|     CONTROL FLOW                       |");
            logger.info("|----------------------------------------|");
            logger.info("| 1. If-Else Statements                  |");
            logger.info("| 2. Ternary Operator                    |");
            logger.info("| 3. Switch Statement                    |");
            logger.info("| 4. For Loop                            |");
            logger.info("| 5. For-Each Loop                       |");
            logger.info("| 6. While Loop                          |");
            logger.info("| 7. Do-While Loop                       |");
            logger.info("| 8. Stream Basics                       |");
            logger.info("| 0. Back to Main Menu                   |");
            logger.info("|----------------------------------------|\n");

            int option = ConsoleUtils.readInt("Select an option: ");

            switch (option) {
                case 1:
                    IfElseDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 2:
                    TernaryOperatorDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 3:
                    SwitchDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 4:
                    ForLoopDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 5:
                    ForEachLoopDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 6:
                    WhileLoopDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 7:
                    DoWhileLoopDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 8:
                    StreamBasicsDemo.demonstrate();
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
     * Displays methods and functions submenu.
     */
    private static void executeMethodsAndFunctionsMenu() {
        boolean back = false;

        while (!back) {
            logger.info("|----------------------------------------|");
            logger.info("|     METHODS AND FUNCTIONS              |");
            logger.info("|----------------------------------------|");
            logger.info("| 1. Method Basics                       |");
            logger.info("| 2. Parameter Passing                   |");
            logger.info("| 3. Return Types                        |");
            logger.info("| 4. Method Overloading                  |");
            logger.info("| 5. Variable Arguments (Varargs)        |");
            logger.info("| 6. Recursion Basics                    |");
            logger.info("| 7. Recursion Patterns                  |");
            logger.info("| 8. Recursion vs Iteration              |");
            logger.info("| 0. Back to Main Menu                   |");
            logger.info("|----------------------------------------|\n");

            int option = ConsoleUtils.readInt("Select an option: ");

            switch (option) {
                case 1:
                    MethodBasicsDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 2:
                    ParameterPassingDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 3:
                    ReturnTypesDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 4:
                    MethodOverloadingDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 5:
                    VariableArgumentsDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 6:
                    RecursionBasicsDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 7:
                    RecursionPatternsDemo.demonstrate();
                    ConsoleUtils.pressEnterToContinue();
                    break;
                case 8:
                    RecursionVsIterationDemo.demonstrate();
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
