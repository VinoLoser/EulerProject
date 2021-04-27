package EulerProject.EulerProject57;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int numeratorMoreDigits = 0;
        fraction F = main.new fraction();
        int[] numerator = new int[500];
        numerator[0] = 3;
        int[] denominator = new int[500];
        denominator[0] = 2;
        F.numerator = numerator;
        F.denominator = denominator;
        for (int i = 2; i <= 1000; i++) {
            iterate(F);
            if (length(F.numerator) > length(F.denominator)) {
                numeratorMoreDigits++;
            }
        }
        System.out.println(numeratorMoreDigits);
    }
    public static void iterate(fraction F) {
        //numerator
        int[] Fnumerator = new int[500];
        multiplyArrays(2, F.denominator, Fnumerator);

        addArrays(Fnumerator, F.numerator);
        // denominator
        addArrays(F.denominator, F.numerator);
        F.numerator = Fnumerator;
    }
    public static void multiplyArrays(int num, int[] array, int[] x) {
        int carryBit = 0;
        for (int i = 0; i < array.length; i++) {
            x[i] = array[i] * num;
            x[i] += carryBit;
            carryBit = x[i] / 10;
            x[i] %= 10;
        }
    }
    public static void addArrays(int[] array, int[] add) {
        int carryBit = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] += add[i];
            array[i] += carryBit;
            carryBit = array[i] / 10;
            array[i] %= 10;
        }
    }
    public static int length(int[] array) {
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] != 0) {
                return i;
            }
        }
        return -1;
    }
    public class fraction {
        int[] numerator;
        int[] denominator;
    }
}
