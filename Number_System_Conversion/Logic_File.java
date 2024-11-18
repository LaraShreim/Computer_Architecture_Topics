package Number_System_Conversion;

public class Logic_File {

        public static void funcAnd(int[] a, int[] b, int[] result) {
            for (int i = 0; i < 8; i++) {
                result[i] = a[i] & b[i];
            }
        }

        public static void funcOr(int[] a, int[] b, int[] result) {
            for (int i = 0; i < 8; i++) {
                result[i] = a[i] | b[i];
            }
        }

        public static void funcNot(int[] a, int[] result) {
            for (int i = 0; i < 8; i++) {
                result[i] = (a[i] == 0) ? 1 : 0; // Flip the bit
            }
        }

        public static void main(String[] args) {
            int[] binary1 = {1, 0, 1, 0, 1, 1, 0, 0}; // Example binary number
            int[] binary2 = {0, 1, 0, 1, 1, 0, 1, 1}; // Another example binary number
            int[] result = new int[8];

            System.out.println("Binary 1:");
            printBinary(binary1);

            System.out.println("Binary 2:");
            printBinary(binary2);

            funcAnd(binary1, binary2, result);
            System.out.println("Result of AND:");
            printBinary(result);

            funcOr(binary1, binary2, result);
            System.out.println("Result of OR:");
            printBinary(result);

            funcNot(binary1, result);
            System.out.println("Result of NOT on Binary 1:");
            printBinary(result);
        }

        public static void printBinary(int[] binary) {
            for (int bit : binary) {
                System.out.print(bit);
            }
            System.out.println();
        }

}
