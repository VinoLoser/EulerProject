package EulerProject.EulerProject20;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[201];
        array[2] = 1;
        for (int multiplier = 99; multiplier > 0; multiplier--) {
            array = multiply(multiplier, array);
        }
        int sum = 0;
        for (int pos = checkDigits(array); pos >= 0; pos--) {
            sum += array[pos];
        }
        System.out.println(sum);
    }
    private static int[] multiply(int multiplier, int[] array) {
        for (int pos = 0; pos < array.length; pos++) {
            array[pos] *= multiplier;
        }
        array = checkNumber(array);
        return array;
    }
    private static int[] checkNumber(int[] array) {
        for (int pos = 0; pos < array.length-1; pos++) {
                array[pos+1] += array[pos]/10;
                array[pos] %= 10;
        }
        return array;
    }
    private static int checkDigits(int[] array) {
        int pos = array.length - 1;
        while (array[pos] == 0) {
            pos--;
        }
        return pos;
    }
}