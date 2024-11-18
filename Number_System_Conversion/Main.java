package Number_System_Conversion;

import java.util.Scanner;

public class Main {

    public static void getBinaryInput(int[] a) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            int bit;
            do {
                System.out.print("x" + i + " = ");
                bit = scanner.nextInt();
                if (bit != 0 && bit != 1) {
                    System.out.println("Error: Enter a binary value (0 or 1)!");
                }
            } while (bit != 0 && bit != 1);
            a[i] = bit;
        }
    }

    public static void printMenu() {
        System.out.println("Enter the command number:");
        System.out.println("0) Exit");
        System.out.println("1) AND");
        System.out.println("2) OR");
        System.out.println("3) NOT");
        System.out.println("4) 1's complement");
        System.out.println("5) 2's complement");
        System.out.println("6) 2's complement*");
    }

    public static void outputBaseMenu() {
        System.out.println("Enter the output base:");
        System.out.println("1) Binary");
        System.out.println("2) Octal");
        System.out.println("3) Decimal");
        System.out.println("4) Hexadecimal");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int command, base;
        int[] x = new int[8];
        int[] y = new int[8];
        int[] result = new int[8];

        while (true) {
            printMenu();
            command = scanner.nextInt();

            if (command == 0) {
                break;
            }

            if (command >= 1 && command <= 6) {
                System.out.println("Enter the first binary number:");
                getBinaryInput(x);
            }

            if (command == 1 || command == 2) {
                System.out.println("Enter the second binary number:");
                getBinaryInput(y);
            }

            switch (command) {
                case 1:
                    Logic_File.funcAnd(x, y, result);
                    break;
                case 2:
                    Logic_File.funcOr(x, y, result);
                    break;
                case 3:
                    Logic_File.funcNot(x, result);
                    break;
                case 4:
                    Complement_File.func1sComp(x, result);
                    break;
                case 5:
                    Complement_File.func2sComp(x, result);
                    break;
                case 6:
                    Complement_File.func2sCompStar(x, result);
                    break;
                default:
                    System.out.println("Invalid command");
                    continue;
            }

            outputBaseMenu();
            base = scanner.nextInt();

            switch (base) {
                case 1:
                    System.out.print("Result in binary: ");
                    printBinary(result);
                    break;
                case 2:
                    Conversion_File.toOctal(result);
                    break;
                case 3:
                    Conversion_File.toDecimal(result);
                    break;
                case 4:
                    Conversion_File.toHexadecimal(result);
                    break;
                default:
                    System.out.println("Invalid base");
            }
        }
        scanner.close();
    }

    public static void printBinary(int[] binary) {
        for (int bit : binary) {
            System.out.print(bit);
        }
        System.out.println();
    }
}