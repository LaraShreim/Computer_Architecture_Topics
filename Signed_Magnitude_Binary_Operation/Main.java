package Signed_Magnitude_Binary_Operation;

import java.util.Scanner;

public class Main {

    private static final int MAX = 8;

    public static void getBinaryInput(int[] arr, Scanner scanner) {
        for (int i = 0; i < MAX; i++) {
            int bit;
            while (true) {
                System.out.printf("x%d = ", i);
                bit = scanner.nextInt();
                if (bit == 0 || bit == 1) {
                    break;
                } else {
                    System.out.println("Error: Enter a binary value (0 or 1)!");
                }
            }
            arr[i] = bit;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] x = new int[MAX], y = new int[MAX], z = new int[MAX];

        while (true) {
            System.out.println("\nEnter the command number:");
            System.out.println("0) Exit");
            System.out.println("1) Addition in signed-magnitude");
            System.out.println("2) Subtraction in signed-magnitude");
            int command = scanner.nextInt();

            if (command == 0) {
                break;
            } else if (command == 1 || command == 2) {
                System.out.println("Enter the first binary number (8 bits):");
                getBinaryInput(x, scanner);

                System.out.println("Enter the second binary number (8 bits):");
                getBinaryInput(y, scanner);

                if (command == 1) {
                    funcSignedMagAddition(x, y, z);
                } else {
                    funcSignedMagSubtraction(x, y, z);
                }

                System.out.println("Enter the output base:");
                System.out.println("1) Binary");
                System.out.println("2) Octal");
                System.out.println("3) Decimal");
                System.out.println("4) Hexadecimal");
                int base = scanner.nextInt();

                switch (base) {
                    case 1 -> {
                        System.out.print("Result in binary: ");
                        for (int i : z) {
                            System.out.print(i);
                        }
                        System.out.println();
                    }
                    case 2 -> toOctal(z);
                    case 3 -> toDecimal(z);
                    case 4 -> toHexadecimal(z);
                    default -> System.out.println("Invalid base choice!");
                }
            } else {
                System.out.println("Invalid command! Please enter a valid command number.");
            }
        }
        scanner.close();
    }

    public static void funcSignedMagAddition(int[] x, int[] y, int[] z) {
        // Add logic for signed-magnitude addition
        System.out.println("Signed-magnitude addition not implemented yet.");
    }

    public static void funcSignedMagSubtraction(int[] x, int[] y, int[] z) {
        // Add logic for signed-magnitude subtraction
        System.out.println("Signed-magnitude subtraction not implemented yet.");
    }

    public static void toOctal(int[] z) {
        // Add logic to convert binary to octal
        System.out.println("Conversion to octal not implemented yet.");
    }

    public static void toDecimal(int[] z) {
        // Add logic to convert binary to decimal
        System.out.println("Conversion to decimal not implemented yet.");
    }

    public static void toHexadecimal(int[] z) {
        // Add logic to convert binary to hexadecimal
        System.out.println("Conversion to hexadecimal not implemented yet.");
    }
}
