package Signed_Magnitude_Binary_Operation;

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
}