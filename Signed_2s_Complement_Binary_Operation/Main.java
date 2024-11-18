package Signed_2s_Complement_Binary_Operation;

import java.util.Scanner;

public class Main {

    private static final int MAX = 8;

    // Method to get binary input
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

    // Signed 2's complement addition
    public static void funcSigned2sAddition(int[] a, int[] b, int[] result) {
        int carry = 0;
        for (int i = MAX - 1; i >= 0; i--) {
            int sum = a[i] + b[i] + carry;
            result[i] = sum % 2;
            carry = sum / 2;
        }
        if (carry != 0) {
            System.out.println("Warning: Overflow occurred during addition.");
        }
    }

    // Signed 2's complement subtraction
    public static void funcSigned2sSubtraction(int[] a, int[] b, int[] result) {
        int[] bComplement = new int[MAX];
        func2sComp(b, bComplement); // Convert b to 2's complement
        funcSigned2sAddition(a, bComplement, result); // Perform addition
    }

    // 1's complement
    public static void func1sComp(int[] a, int[] result) {
        for (int i = 0; i < MAX; i++) {
            result[i] = (a[i] == 0) ? 1 : 0;
        }
    }

    // 2's complement
    public static void func2sComp(int[] a, int[] result) {
        int carry = 1;
        func1sComp(a, result); // Get 1's complement
        for (int i = MAX - 1; i >= 0; i--) {
            result[i] += carry;
            if (result[i] == 2) {
                result[i] = 0;
                carry = 1;
            } else {
                carry = 0;
            }
        }
    }

    // Convert to Decimal
    public static void toDecimal(int[] binary) {
        int value = 0;
        int sign = binary[0] == 1 ? -1 : 1;
        for (int i = 1; i < MAX; i++) {
            value = value * 2 + binary[i];
        }
        System.out.println("Result in decimal: " + (value * sign));
    }

    // Convert to Octal
    public static void toOctal(int[] binary) {
        int decimal = 0;
        for (int i = 0; i < MAX; i++) {
            decimal = decimal * 2 + binary[i];
        }
        System.out.println("Result in octal: " + Integer.toOctalString(decimal));
    }

    // Convert to Hexadecimal
    public static void toHexadecimal(int[] binary) {
        int decimal = 0;
        for (int i = 0; i < MAX; i++) {
            decimal = decimal * 2 + binary[i];
        }
        System.out.println("Result in hexadecimal: " + Integer.toHexString(decimal).toUpperCase());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] x = new int[MAX], y = new int[MAX], z = new int[MAX];

        while (true) {
            System.out.println("\nEnter the command number:");
            System.out.println("0) Exit");
            System.out.println("1) Addition in signed-2's-complement");
            System.out.println("2) Subtraction in signed-2's-complement");
            int command = scanner.nextInt();

            if (command == 0) {
                break;
            } else if (command == 1 || command == 2) {
                System.out.println("Enter the first binary number (8 bits):");
                getBinaryInput(x, scanner);

                System.out.println("Enter the second binary number (8 bits):");
                getBinaryInput(y, scanner);

                if (command == 1) {
                    funcSigned2sAddition(x, y, z);
                } else {
                    funcSigned2sSubtraction(x, y, z);
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
                        for (int bit : z) {
                            System.out.print(bit);
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
}

