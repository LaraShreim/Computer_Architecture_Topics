package Canonical_SoP_Implementation;

import java.util.Scanner;

public class Main {

    private static final int INPUT_VARIABLE_COUNT = 3;
    private static final int OUTPUT_VARIABLE_COUNT = 1;

    public static void buildLeftSide(int[][] truthTable) {
        int rowCount = 1 << INPUT_VARIABLE_COUNT;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
                truthTable[i][j] = (i >> (INPUT_VARIABLE_COUNT - 1 - j)) & 1;
            }
        }
    }

    public static void buildRightSide(int[][] truthTable, Scanner scanner) {
        int rowCount = 1 << INPUT_VARIABLE_COUNT;

        for (int i = 0; i < rowCount; i++) {
            int value;
            do {
                System.out.printf("Output value for row# %d of F output variable: ", i);
                value = scanner.nextInt();
                if (value != 0 && value != 1) {
                    System.out.println("Invalid input! Please enter 0 or 1.");
                }
            } while (value != 0 && value != 1);

            truthTable[i][INPUT_VARIABLE_COUNT] = value;
        }
    }

    public static void printTruthTable(int[][] truthTable) {
        char[] variables = {'Z', 'Y', 'X', 'F'};

        for (int i = 0; i < INPUT_VARIABLE_COUNT; i++) {
            System.out.print(variables[i] + ", ");
        }
        System.out.print(": ");
        for (int i = INPUT_VARIABLE_COUNT; i < INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT; i++) {
            System.out.print(variables[i]);
        }
        System.out.println();

        int rowCount = 1 << INPUT_VARIABLE_COUNT;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
                System.out.print(truthTable[i][j] + ", ");
            }
            System.out.println(": " + truthTable[i][INPUT_VARIABLE_COUNT]);
        }
    }

    public static void toMinterm(int[][] truthTable) {
        int rowCount = 1 << INPUT_VARIABLE_COUNT;
        char[] variables = {'Z', 'Y', 'X'};

        System.out.print("Output variable F1 = ");

        boolean first = true;
        for (int i = 0; i < rowCount; i++) {
            if (truthTable[i][INPUT_VARIABLE_COUNT] == 1) {
                if (!first) {
                    System.out.print(" + ");
                }
                first = false;
                for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
                    if (truthTable[i][j] == 0) {
                        System.out.print(variables[j] + "'");
                    } else {
                        System.out.print(variables[j]);
                    }
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int TRUTH_TABLE_ROW_COUNT = 1 << INPUT_VARIABLE_COUNT;
        int[][] truthTable = new int[TRUTH_TABLE_ROW_COUNT][INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT];

        // Initialize the truth table with zeros
        for (int i = 0; i < TRUTH_TABLE_ROW_COUNT; i++) {
            for (int j = 0; j < INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT; j++) {
                truthTable[i][j] = 0;
            }
        }

        int command;
        do {
            System.out.println("Enter the command number:");
            System.out.println("0) Exit");
            System.out.println("1) Canonical SoP");
            command = scanner.nextInt();

            if (command == 1) {
                buildLeftSide(truthTable);
                buildRightSide(truthTable, scanner);
                printTruthTable(truthTable);
                toMinterm(truthTable);
            } else if (command != 0) {
                System.out.println("Invalid command! Please enter 0 or 1.");
            }
        } while (command != 0);

        scanner.close();
    }
}

