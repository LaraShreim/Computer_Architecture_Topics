package Canonical_PoS_Implementation;

import java.util.Scanner;

public class Main {

    private static final int INPUT_VARIABLE_COUNT = 3;
    private static final int OUTPUT_VARIABLE_COUNT = 1;
    private static final int ROW_COUNT = 1 << INPUT_VARIABLE_COUNT;

    // Method to build the left side of the truth table (input combinations)
    public static void buildLeftSide(int[][] truthTable) {
        for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
                truthTable[i][j] = (i >> (INPUT_VARIABLE_COUNT - 1 - j)) & 1;
            }
        }
    }

    // Method to build the right side of the truth table (output values)
    public static void buildRightSide(int[][] truthTable, Scanner scanner) {
        for (int i = 0; i < ROW_COUNT; i++) {
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

    // Method to print the truth table
    public static void printTruthTable(int[][] truthTable) {
        char[] variables = {'Z', 'Y', 'X', 'F'};
        for (int i = 0; i < INPUT_VARIABLE_COUNT; i++) {
            System.out.print(variables[i] + ", ");
        }
        System.out.print(": " + variables[INPUT_VARIABLE_COUNT]);
        System.out.println();

        for (int[] row : truthTable) {
            for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
                System.out.print(row[j] + ", ");
            }
            System.out.println(": " + row[INPUT_VARIABLE_COUNT]);
        }
    }

    // Method to generate and print Canonical Sum of Products (SoP)
    public static void toMinterm(int[][] truthTable) {
        char[] variables = {'Z', 'Y', 'X'};
        boolean first = true;

        System.out.print("Output variable F1 = ");
        for (int i = 0; i < ROW_COUNT; i++) {
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

    // Method to generate and print Canonical Product of Sums (PoS)
    public static void toMaxterm(int[][] truthTable) {
        char[] variables = {'Z', 'Y', 'X'};
        boolean first = true;

        System.out.print("Output variable F1 = ");
        for (int i = 0; i < ROW_COUNT; i++) {
            if (truthTable[i][INPUT_VARIABLE_COUNT] == 0) {
                if (!first) {
                    System.out.print(")(");
                } else {
                    System.out.print("(");
                }
                first = false;

                for (int j = 0; j < INPUT_VARIABLE_COUNT; j++) {
                    if (truthTable[i][j] == 0) {
                        System.out.print(variables[j]);
                    } else {
                        System.out.print(variables[j] + "'");
                    }
                    if (j < INPUT_VARIABLE_COUNT - 1) {
                        System.out.print("+");
                    }
                }
            }
        }
        if (!first) {
            System.out.println(")");
        } else {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] truthTable = new int[ROW_COUNT][INPUT_VARIABLE_COUNT + OUTPUT_VARIABLE_COUNT];
        int command;

        do {
            System.out.println("Enter the command number:");
            System.out.println("0) Exit");
            System.out.println("1) Canonical SoP");
            System.out.println("2) Canonical PoS");
            command = scanner.nextInt();

            if (command == 1) {
                buildLeftSide(truthTable);
                buildRightSide(truthTable, scanner);
                printTruthTable(truthTable);
                toMinterm(truthTable);
            } else if (command == 2) {
                buildLeftSide(truthTable);
                buildRightSide(truthTable, scanner);
                printTruthTable(truthTable);
                toMaxterm(truthTable);
            } else if (command != 0) {
                System.out.println("Invalid command! Please enter 0, 1, or 2.");
            }
        } while (command != 0);

        scanner.close();
    }
}

