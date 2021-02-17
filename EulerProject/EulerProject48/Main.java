package EulerProject.EulerProject48;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        solve(array);
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]);
        }
    }

    public static void solve(int[] array) {
        for (int i = 1; i <= 1000; i++) {
            int[] temp = new int[10];
            temp[0] = i;
            for (int n = 2; n <= i; n++) {
                multiply(temp, i);
            }
            add(temp, array);
        }
    }  
    public static void multiply(int[] temp, int i) {
        int carryBit = 0;
        for (int pos = 0; pos < temp.length; pos++) {
            temp[pos] *= i;
            temp[pos] += carryBit;
            carryBit = 0;
            if (temp[pos] >= 10) {
                carryBit = temp[pos] / 10;
                temp[pos] %= 10;
            }
        }
    }
    public static void add(int[] temp, int[] array) {
        int carryBit = 0;
        for (int pos = 0; pos < array.length; pos++) {
            array[pos] += temp[pos] + carryBit;
            carryBit = 0;
            if (array[pos] >= 10) {
                carryBit = array[pos] / 10;
                array[pos] %= 10;
            }
        }
    }
}