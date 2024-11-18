package Number_System_Conversion;

public class Complement_File {

        public static void func1sComp(int[] a, int[] result) {
            for (int i = 0; i < 8; i++) {
                result[i] = (a[i] == 0) ? 1 : 0;
            }
        }

        public static void func2sComp(int[] a, int[] result) {
            int carry = 1;
            func1sComp(a, result);  // Get the 1's complement

            // Add 1 to the 1's complement
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
            // Same implementation as func2sComp; can be customized if needed
            func2sComp(a, result);
        }

        public static void main(String[] args) {
            int[] binary = {1, 0, 0, 1, 0, 1, 1, 0}; // Example binary number
            int[] result = new int[8];

            System.out.println("Original binary number:");
            printBinary(binary);

            func1sComp(binary, result);
            System.out.println("1's complement:");
            printBinary(result);

            func2sComp(binary, result);
            System.out.println("2's complement:");
            printBinary(result);

            func2sCompStar(binary, result);
            System.out.println("2's complement*:");
            printBinary(result);
        }

        public static void printBinary(int[] binary) {
            for (int bit : binary) {
                System.out.print(bit);
            }
            System.out.println();
        }

}
