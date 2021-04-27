package EulerProject.EulerProject65;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[101];
        makeSequence(array);
        System.out.println(findReverse(array));
    }
    public static void makeSequence(int[] array) {
        array[1] = 2;
        array[2] = 1;
        int multiple = 1;
        for (int pos = 3; pos < array.length; pos++) {
            array[pos] = 2 * multiple;
            multiple++;
            for (int i = 0; i <= 1; i++) {
                pos++;
                if (pos < array.length) {
                    array[pos] = 1;
                } else {
                    break;
                }
            }
        }
    }
    public static int findReverse(int[] array) {
        int add = array[array.length-2] * array[array.length-1] + 1;
        int[] numerator = new int[100];
        findSum(numerator, add);
        add = array[array.length-1];
        int[] denominator = new int[100];
        findSum(denominator, add);
        for (int i = array.length-3; i > 0; i--) {
            int[] temp = numerator;
            numerator = denominator;
            denominator = temp.clone();
            multiply(temp, array[i]);
            findSum(numerator, temp);
        }
        return findSum(numerator);

    }
    public static void multiply(int[] array, int multiply) {
        int carryBit = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] *= multiply;
            array[i] += carryBit;
            carryBit = array[i] / 10;
            array[i] %= 10;
        }
    }
    public static void findSum(int[] array, int[] add) {
        int carryBit = 0;
        for (int i = 0; i < add.length; i++) {
            array[i] += add[i];
            array[i] += carryBit;
            carryBit = array[i] / 10;
            array[i] %= 10;
        }
    }
    public static void findSum(int[] num, int add) {
        num[0] += add;
        int carryBit = 0;
        for (int i = 0; i < num.length; i++) {
            num[i] += carryBit;
            carryBit = num[i] / 10;
            num[i] %= 10;
        }
    }
    public static int findSum(int[] num) {
        int sum = 0;
        for (int i : num) {
            sum += i;
        }
        return sum;
    }
}