package com.andres.datatypes.composite.arrays;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demonstrates multidimensional arrays (matrices) in Java.
 * 
 * <p>
 * <strong>Multidimensional Array Characteristics:</strong>
 * </p>
 * <ul>
 * <li>Arrays of arrays (can be irregular/jagged)</li>
 * <li>Useful for representing tables, mathematical matrices, grids</li>
 * <li>Access with multiple indices: matrix[row][column]</li>
 * <li>Memory stored in row-major order</li>
 * <li>Can have any number of dimensions (2D, 3D, etc.)</li>
 * </ul>
 * 
 * <p>
 * <strong>When to Use Multidimensional Arrays:</strong>
 * </p>
 * <ul>
 * <li>Tabular data representation (spreadsheets, databases)</li>
 * <li>Matrix operations (linear algebra, transformations)</li>
 * <li>Game grids (chess board, tic-tac-toe, pixel maps)</li>
 * <li>Image processing (pixel matrices)</li>
 * <li>Graph adjacency matrices</li>
 * <li>Dynamic programming tables</li>
 * </ul>
 * 
 * <p>
 * <strong>Types of Multidimensional Arrays:</strong>
 * </p>
 * <ul>
 * <li><strong>Rectangular:</strong> All rows have same length (traditional
 * matrix)</li>
 * <li><strong>Jagged:</strong> Rows can have different lengths (array of
 * arrays)</li>
 * </ul>
 * 
 * <p>
 * <strong>Best Practices:</strong>
 * </p>
 * <ul>
 * <li>Use 2D arrays for most matrix operations</li>
 * <li>Consider jagged arrays when rows have varying lengths</li>
 * <li>Document dimensions clearly in code</li>
 * <li>Use nested loops for iteration</li>
 * <li>For complex operations, consider using libraries (Apache Commons
 * Math)</li>
 * </ul>
 */
public final class MultiDimensionArrayDemo {

    private static final Logger logger = LoggerFactory.getLogger(MultiDimensionArrayDemo.class);

    /**
     * Private constructor to prevent instantiation.
     */
    private MultiDimensionArrayDemo() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Demonstrates multidimensional array usage.
     */
    public static void demonstrate() {
        logger.info("--- Multidimensional Arrays (Matrices) ---\n");

        // 2D arrays (rectangular)
        demonstrate2DArrays();

        // Jagged arrays (irregular)
        demonstrateJaggedArrays();

        // 3D arrays
        demonstrate3DArrays();

        // Matrix operations
        demonstrateMatrixOperations();

        System.out.println();
    }

    /**
     * Demonstrates 2D rectangular arrays (traditional matrices).
     * 
     * <p>
     * <strong>2D Array Structure:</strong>
     * </p>
     * 
     * <pre>
     * int[][] matrix = {
     *         { 1, 2, 3 }, // Row 0
     *         { 4, 5, 6 } // Row 1
     * };
     * </pre>
     * 
     * <p>
     * Access: matrix[row][column]
     * </p>
     */
    private static void demonstrate2DArrays() {
        logger.info("--- 2D Arrays (Rectangular Matrix) ---");

        // Declaration and initialization
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        logger.info("2x3 Matrix:");
        printMatrix(matrix);

        // Access individual elements
        logger.info("\nElement access:");
        logger.info("matrix[0][0] (top-left): {}", matrix[0][0]);
        logger.info("matrix[1][2] (bottom-right): {}", matrix[1][2]);
        logger.info("matrix[0][1] (top-middle): {}", matrix[0][1]);

        // Dimensions
        int rows = matrix.length;
        int cols = matrix[0].length;
        logger.info("\nDimensions: {} rows x {} columns", rows, cols);

        // Modify element
        matrix[0][0] = 99;
        logger.info("\nAfter modifying matrix[0][0] to 99:");
        printMatrix(matrix);

        // Alternative creation (empty matrix)
        logger.info("\n--- Creating Empty Matrix ---");
        int[][] emptyMatrix = new int[3][4]; // 3 rows, 4 columns
        logger.info("3x4 matrix initialized with zeros:");
        printMatrix(emptyMatrix);
    }

    /**
     * Demonstrates jagged arrays (irregular arrays with varying row lengths).
     * 
     * <p>
     * <strong>Jagged Array Use Cases:</strong>
     * </p>
     * <ul>
     * <li>Triangle matrices (lower/upper triangular)</li>
     * <li>Sparse data structures</li>
     * <li>Variable-length data per row</li>
     * <li>Memory optimization when rows have different sizes</li>
     * </ul>
     */
    private static void demonstrateJaggedArrays() {
        logger.info("\n--- Jagged Arrays (Irregular) ---");

        // Jagged array: each row has different length
        int[][] jagged = {
                { 1, 2 },
                { 3, 4, 5 },
                { 6 },
                { 7, 8, 9, 10 }
        };

        logger.info("Jagged array (varying row lengths):");
        for (int i = 0; i < jagged.length; i++) {
            logger.info("Row {}: {}", i, Arrays.toString(jagged[i]));
        }

        // Creating jagged array dynamically
        logger.info("\n--- Creating Jagged Array Dynamically ---");
        int[][] dynamicJagged = new int[4][]; // 4 rows, columns not specified
        dynamicJagged[0] = new int[2];
        dynamicJagged[1] = new int[3];
        dynamicJagged[2] = new int[1];
        dynamicJagged[3] = new int[4];

        // Fill with values
        int value = 1;
        for (int i = 0; i < dynamicJagged.length; i++) {
            for (int j = 0; j < dynamicJagged[i].length; j++) {
                dynamicJagged[i][j] = value++;
            }
        }

        logger.info("Dynamic jagged array:");
        for (int i = 0; i < dynamicJagged.length; i++) {
            logger.info("Row {}: {}", i, Arrays.toString(dynamicJagged[i]));
        }

        // Use case: Pascal's triangle
        demonstratePascalsTriangle();
    }

    /**
     * Demonstrates 3D arrays and higher dimensions.
     * 
     * <p>
     * <strong>3D Array Structure:</strong>
     * </p>
     * 
     * <pre>
     * int[depth][rows][columns]
     * </pre>
     * 
     * <p>
     * <strong>Use Cases:</strong>
     * </p>
     * <ul>
     * <li>3D graphics and game engines</li>
     * <li>Volumetric data (medical imaging, simulations)</li>
     * <li>Time-series matrices (data over time)</li>
     * <li>RGB image data (width x height x channels)</li>
     * </ul>
     */
    private static void demonstrate3DArrays() {
        logger.info("\n--- 3D Arrays ---");

        // 3D array: depth x rows x columns
        int[][][] cube = {
                { { 1, 2 }, { 3, 4 } },
                { { 5, 6 }, { 7, 8 } }
        };

        logger.info("3D Array (2x2x2 cube):");
        for (int i = 0; i < cube.length; i++) {
            logger.info("Layer {}:", i);
            printMatrix(cube[i]);
        }

        // Access 3D element
        logger.info("\nElement access:");
        logger.info("cube[0][0][0]: {}", cube[0][0][0]);
        logger.info("cube[1][1][1]: {}", cube[1][1][1]);
        logger.info("cube[0][1][0]: {}", cube[0][1][0]);

        // Dimensions
        int depth = cube.length;
        int rows = cube[0].length;
        int cols = cube[0][0].length;
        logger.info("\nDimensions: {}x{}x{} (depth x rows x columns)", depth, rows, cols);
    }

    /**
     * Demonstrates common matrix operations.
     */
    private static void demonstrateMatrixOperations() {
        logger.info("\n--- Matrix Operations ---");

        int[][] matrixA = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };

        int[][] matrixB = {
                { 7, 8, 9 },
                { 10, 11, 12 }
        };

        logger.info("Matrix A:");
        printMatrix(matrixA);

        logger.info("\nMatrix B:");
        printMatrix(matrixB);

        // Matrix addition
        logger.info("\n--- Matrix Addition (A + B) ---");
        int[][] sum = addMatrices(matrixA, matrixB);
        printMatrix(sum);

        // Transpose
        logger.info("\n--- Transpose of Matrix A ---");
        int[][] transposed = transpose(matrixA);
        printMatrix(transposed);

        // Find maximum value
        logger.info("\n--- Maximum Value in Matrix A ---");
        int max = findMax(matrixA);
        logger.info("Maximum value: {}", max);
    }

    /**
     * Demonstrates Pascal's Triangle as a practical jagged array example.
     */
    private static void demonstratePascalsTriangle() {
        logger.info("\n--- Pascal's Triangle (Jagged Array Example) ---");

        int rows = 6;
        int[][] pascal = new int[rows][];

        for (int i = 0; i < rows; i++) {
            pascal[i] = new int[i + 1];
            pascal[i][0] = 1;
            pascal[i][i] = 1;

            for (int j = 1; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }

        logger.info("Pascal's Triangle ({} rows):", rows);
        for (int i = 0; i < pascal.length; i++) {
            // Add spacing for visual triangle
            for (int k = 0; k < rows - i - 1; k++) {
                System.out.print("  ");
            }
            for (int j = 0; j < pascal[i].length; j++) {
                System.out.printf("%4d", pascal[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Utility method to print a 2D matrix.
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%3d", row[j]);
                if (j < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    /**
     * Adds two matrices (must have same dimensions).
     */
    private static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    /**
     * Transposes a matrix (swaps rows and columns).
     */
    private static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    /**
     * Finds maximum value in a matrix.
     */
    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;

        for (int[] row : matrix) {
            for (int value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }

        return max;
    }
}
