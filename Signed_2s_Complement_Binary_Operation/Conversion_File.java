package Signed_2s_Complement_Binary_Operation;

import java.util.Scanner;

public class Conversion_File {
        public static void toOctal(int[] a) {
            int octal = 0, power = 1;

            for (int i = 7; i >= 0; i -= 3) {
                int group = 0;
                if (i >= 0) group += a[i] << 0;
                if (i - 1 >= 0) group += a[i - 1] << 1;
                if (i - 2 >= 0) group += a[i - 2] << 2;

                octal += group * power;
                power *= 10;
            }
            System.out.println("Result in octal: " + octal);
        }

        public static void toDecimal(int[] a) {
            int decimal = 0;

            for (int i = 0; i < 8; i++) {
                decimal += a[i] * (1 << (7 - i));
            }
            System.out.println("Result in decimal: " + decimal);
        }

        public static void toHexadecimal(int[] a) {
            int hex = 0, power = 1;

            for (int i = 7; i >= 0; i -= 4) {
                int group = 0;
                if (i >= 0) group += a[i] << 0;
                if (i - 1 >= 0) group += a[i - 1] << 1;
                if (i - 2 >= 0) group += a[i - 2] << 2;
                if (i - 3 >= 0) group += a[i - 3] << 3;

                hex += group * power;
                power *= 16;
            }
            System.out.printf("Result in hexadecimal: %X\n", hex);  // Prints the number in hexadecimal format
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] binary = new int[8];

            System.out.println("Enter an 8-bit binary number (one digit at a time):");
            for (int i = 0; i < 8; i++) {
                do {
                    System.out.print("x" + i + " = ");
                    binary[i] = scanner.nextInt();
                    if (binary[i] != 0 && binary[i] != 1) {
                        System.out.println("Invalid input. Enter 0 or 1.");
                    }
                } while (binary[i] != 0 && binary[i] != 1);
            }

            System.out.println("\nChoose conversion type:");
            System.out.println("1) Octal");
            System.out.println("2) Decimal");
            System.out.println("3) Hexadecimal");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    toOctal(binary);
                    break;
                case 2:
                    toDecimal(binary);
                    break;
                case 3:
                    toHexadecimal(binary);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            scanner.close();
        }

    }


