package Signed_Complement_Implementation;/* This code shows operations in binary and make sure that the output is right*/

import java.util.Scanner;

public class Main {
        static final int SIZE = 8;

        public static void funcAnd(int[] a, int[] b, int[] result) {
            for (int i = 0; i < SIZE; i++) {
                result[i] = a[i] & b[i];
            }
        }

        public static void funcOr(int[] a, int[] b, int[] result) {
            for (int i = 0; i < SIZE; i++) {
                result[i] = a[i] | b[i];
            }
        }

        public static void funcNot(int[] a, int[] result) {
            for (int i = 0; i < SIZE; i++) {
                result[i] = (a[i] == 0) ? 1 : 0;
            }
        }

        public static void func1sComp(int[] a, int[] result) {
            funcNot(a, result);
        }

        public static void func2sComp(int[] a, int[] result) {
            int[] temp = new int[SIZE];
            func1sComp(a, temp);

            int carry = 1;
            for (int i = SIZE - 1; i >= 0; i--) {
                result[i] = temp[i] + carry;
                if (result[i] == 2) {
                    result[i] = 0;
                } else {
                    carry = 0;
                }
            }
        }

        public static void func2sCompStar(int[] a, int[] result) {
            int i;
            for (i = SIZE - 1; i >= 0; i--) {
                result[i] = a[i];
                if (a[i] == 1) {
                    break;
                }
            }
            for (i = i - 1; i >= 0; i--) {
                result[i] = (a[i] == 0) ? 1 : 0;
            }
        }

        public static void printBinary(int[] a) {
            for (int i = 0; i < SIZE; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
        }

        public static void getBinaryInput(int[] a) {
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < SIZE; i++) {
                do {
                    System.out.print("x" + i + " = ");
                    a[i] = scanner.nextInt();
                    if (a[i] != 0 && a[i] != 1) {
                        System.out.println("Invalid. Enter 0 or 1.");
                    }
                } while (a[i] != 0 && a[i] != 1);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int command;
            int[] x = new int[SIZE];
            int[] y = new int[SIZE];
            int[] result = new int[SIZE];

            while (true) {
                System.out.println("Enter the command number:");
                System.out.println("0) Exit");
                System.out.println("1) AND");
                System.out.println("2) OR");
                System.out.println("3) NOT");
                System.out.println("4) 1s complement");
                System.out.println("5) 2s complement");
                System.out.println("6) 2s complement*");
                command = scanner.nextInt();

                switch (command) {
                    case 0:
                        System.exit(0);

                    case 1:
                        System.out.println("Enter first binary number:");
                        getBinaryInput(x);
                        System.out.println("Enter second binary number:");
                        getBinaryInput(y);
                        funcAnd(x, y, result);
                        System.out.print("Answer: ");
                        printBinary(result);
                        break;

                    case 2:
                        System.out.println("Enter first binary number:");
                        getBinaryInput(x);
                        System.out.println("Enter second binary number:");
                        getBinaryInput(y);
                        funcOr(x, y, result);
                        System.out.print("Answer: ");
                        printBinary(result);
                        break;

                    case 3:
                        System.out.println("Enter binary number:");
                        getBinaryInput(x);
                        funcNot(x, result);
                        System.out.print("Result: ");
                        printBinary(result);
                        break;

                    case 4:
                        System.out.println("Enter binary number:");
                        getBinaryInput(x);
                        func1sComp(x, result);
                        System.out.print("Result: ");
                        printBinary(result);
                        break;

                    case 5:
                        System.out.println("Enter binary number:");
                        getBinaryInput(x);
                        func2sComp(x, result);
                        System.out.print("Result: ");
                        printBinary(result);
                        break;

                    case 6:
                        System.out.println("Enter binary number:");
                        getBinaryInput(x);
                        func2sCompStar(x, result);
                        System.out.print("Result: ");
                        printBinary(result);
                        break;

                    default:
                        System.out.println("Invalid. Enter a number between 0 and 6.");
                }
            }
        }

}
