package Truth_Table_Implementation;

import java.util.Scanner;

public class Main {

    private static final int MAX = 8;
    private static final int INPUT_VARIABLE_COUNT = 3;
    private static final int OUTPUT_VARIABLE_COUNT = 1;
    private static final int TRUTH_TABLE_ROW_COUNT = 1 << INPUT_VARIABLE_COUNT; // 2^INPUT_VARIABLE_COUNT

    // Function to increment a binary number
    public static void funcIncrement(int[] a, int[] result) {
        int carry = 1;
        for (int i = INPUT_VARIABLE_COUNT - 1; i >= 0; i--) {
            int sum = a[i] + carry;
            result[i] = sum % 2;
            carry = sum / 2;
        }
    }

    // Build the left side of the truth table
    public static void buildLeftSide(int[][] truthTable) {
        int[] row = new int[INPUT_VARIABLE_COUNT];
        int[] result = new int[INPUT_VARIABLE_COUNT];

        for (int i = 0; i < TRUTH_TABLE_ROW_COUNT; i++) {
            System.arraycopy(row, 0, truthTable[i], 0, INPUT_VARIABLE_COUNT);
            funcIncrement(row, result);
            System.arraycopy(result, 0, row, 0, INPUT_VARIABLE_COUNT);
        }
    }

    // Build the right side of the truth table
    public static void buildRightSide(int[][] truthTable, Scanner scanner) {
        for (int i = 0; i < TRUTH_TABLE_ROW_COUNT; i++) {
            for (int j = 0; j < OUTPUT_VARIABLE_COUNT; j++) {
                int outputValue;
                do {
                    System.out.printf("Enter output value for row# %d of F output variable (0 or 1): ", i);
                    outputValue = scanner.nextInt();
                    if (outputValue != 0 && outputValue != 1) {
                        System.out.println("Invalid input. Please enter 0 or 1.");
                    }
                } while (outputValue != 0 && outputValue != 1);
                truthTable[i][INPUT_VARIABLE_COUNT + j] = outputValue;
            }
        }
    }

    // Print the truth table
    public static void printTruthTable(int[][] truthTable) {
        System.out.println("Z, Y, X : F");
        for (int i = 0; i < TRUTH_TABLE_ROW_COUNT; i++) {
            for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
                System.out.print(truthTable[i][j] + ", ");
            }
            System.out.print(": ");
            System.out.println(truthTable[i][INPUT_VARIABLE_COUNT]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] truthTable = new int[TRUTH_TABLE_ROW_COUNT][INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT];

        // Build the left side of the truth table
        buildLeftSide(truthTable);

        // Build the right side of the truth table
        buildRightSide(truthTable, scanner);

        // Print the truth table
        printTruthTable(truthTable);

        scanner.close();
    }
}
