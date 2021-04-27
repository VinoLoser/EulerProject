package EulerProject.EulerProject56;

public class Main {
    public static void main(String[] args) {
        int largestSum = 0;
        for (int a = 1; a < 100; a++) {
            int[] array = new int[201];
            array[0] = 1;
            for (int b = 1; b < 100; b++) {
                power(array, a);
                int temp = findSum(array);
                largestSum = temp > largestSum ? temp : largestSum;
            }
        }
        System.out.println(largestSum);
    }
    public static void power(int[] array, int power) {
        int carryBit = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] *= power;
            array[i] += carryBit;
            carryBit = array[i] / 10;
            array[i] %= 10;
        }
    }
    public static int findSum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}