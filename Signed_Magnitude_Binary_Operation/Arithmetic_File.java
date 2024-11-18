package Signed_Magnitude_Binary_Operation;

public class Arithmetic_File {

    private int a[];
    private int b[];
    private int result[];
    public Arithmetic_File(int a[], int b[], int result[]) {
        this.a = a;
        this.b = b;
        this.result = result;
    }
     public void func_signed_mag_addition(int a[], int b[], int result[]) {
        this.a = a;
        this.b = b;
        this.result = result;

        int sign1 = a[0];
        int sign2 = b[0];

        int magnitude1 = 0;
        int magnitude2 = 0;

        for(int i = 1; i < 8; i++) {
            magnitude1 = magnitude1 * 2 + a[i];
        }
        for(int i = 1; i < 8; i++) {
            magnitude2 = magnitude2 * 2 + b[i];
        }

        int magnResult;
        int signedResult;

        if(sign1 == sign2) {
            magnResult = magnitude1 + magnitude2;
            signedResult = sign1;
        }
        else {
            if(magnitude1 >= magnitude2) {
                magnResult = magnitude1 - magnitude2;
                signedResult = sign1;
            }
            else {
                magnResult = magnitude2 - magnitude1;
                signedResult = sign2;
            }
        }

        if(magnResult >= 128) {
            System.out.println("Overflow Occured!\n");
            magnResult %= 128;
        }

        result[0] = 0;
        for(int i = 7; i > 0; i--) {
            result[i] = magnResult % 2;
            magnResult /= 2;
        }
     }
     public void func_signed_mag_subtraction(int a[], int b[], int result[]) {
        this.a = a;
        this.b = b;
        this.result = result;

        b[0] = (b[0] == 0) ? 1 : 0;
        func_signed_mag_addition(a, b, result);
     }
}
