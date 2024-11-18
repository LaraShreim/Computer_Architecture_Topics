package Truth_Table_Implementation;

public class Arithmetic_File {
    public void func_increment(int a[], int result[]) {
        int carry = 1;
        int Input_Variable_Count = 3;
        for(int i = Input_Variable_Count - 1; i >= 0; i--) {
            result[i] = a[i] + carry;
            if (result[i] > 1) {
                result[i] = 0;
                carry = 1;
            } else {
                carry = 0;
            }
        }
    }
}
