package Signed_2s_Complement_Binary_Operation;

public class Arithmetic_File {

    public static void funcSigned2sAddition(int[] a, int[] b, int[] result) {
        int sign1 = a[0];
        int sign2 = b[0];

        int magn1 = 0, magn2 = 0;

        for (int i = 1; i < 8; i++) {
            magn1 = magn1 * 2 + a[i];
        }
        for (int i = 1; i < 8; i++) {
            magn2 = magn2 * 2 + b[i];
        }

        int magnitudeRes;
        int signRes;

        if (sign1 == sign2) {
            magnitudeRes = magn1 + magn2;
            signRes = sign1;
        } else {
            if (magn1 >= magn2) {
                magnitudeRes = magn1 - magn2;
                signRes = sign1;
            } else {
                magnitudeRes = magn2 - magn1;
                signRes = sign2;
            }
        }

        // Check for overflow
        int carry = 0;
        for (int i = 7; i > 0; i--) {
            int sum = a[i] + b[i] + carry;
            result[i] = sum % 2;
            carry = sum / 2;
        }

        if (carry != 0) {
            System.out.println("Overflow occurred");
        }
    }

    public static void funcSigned2sSubtraction(int[] a, int[] b, int[] result) {
        b[0] = (b[0] == 0) ? 1 : 0; // Flip the sign bit of b for subtraction
        funcSigned2sAddition(a, b, result);
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 1, 0, 0, 1}; // Example binary number
        int[] b = {1, 0, 0, 1, 1, 0, 1, 0}; // Another example binary number
        int[] result = new int[8];

        System.out.println("Performing signed 2's complement addition:");
        funcSigned2sAddition(a, b, result);
        System.out.print("Result: ");
        for (int bit : result) {
            System.out.print(bit);
        }
        System.out.println();

        System.out.println("Performing signed 2's complement subtraction:");
        funcSigned2sSubtraction(a, b, result);
        System.out.print("Result: ");
        for (int bit : result) {
            System.out.print(bit);
        }
        System.out.println();
    }
}
