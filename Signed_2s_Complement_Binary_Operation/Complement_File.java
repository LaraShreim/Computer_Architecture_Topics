package Signed_2s_Complement_Binary_Operation;

public class Complement_File {

    public static void func1sComp(int[] a, int[] result) {
        for (int i = 0; i < 8; i++) {
            result[i] = (a[i] == 0) ? 1 : 0; // Flip each bit
        }
    }

    public static void func2sComp(int[] a, int[] result) {
        int carry = 1;
        func1sComp(a, result); // Get the 1's complement
        // Add 1 to the 1's complement to get 2's complement
        for (int i = 7; i >= 0; i--) {
            result[i] += carry;
            if (result[i] == 2) {
                result[i] = 0;
                carry = 1;
            } else {
                carry = 0;
            }
        }
    }

    public static void func2sCompStar(int[] a, int[] result) {
        // Alternative implementation or alias for 2's complement
        func2sComp(a, result);
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 1, 1, 0, 0, 1}; // Example binary number
        int[] result1s = new int[8];
        int[] result2s = new int[8];
        int[] result2sStar = new int[8];

        System.out.println("Original binary number:");
        for (int bit : a) {
            System.out.print(bit);
        }
        System.out.println();

        // 1's Complement
        func1sComp(a, result1s);
        System.out.println("1's Complement:");
        for (int bit : result1s) {
            System.out.print(bit);
        }
        System.out.println();

        // 2's Complement
        func2sComp(a, result2s);
        System.out.println("2's Complement:");
        for (int bit : result2s) {
            System.out.print(bit);
        }
        System.out.println();

        // 2's Complement (Star)
        func2sCompStar(a, result2sStar);
        System.out.println("2's Complement (Star):");
        for (int bit : result2sStar) {
            System.out.print(bit);
        }
        System.out.println();
    }
}

