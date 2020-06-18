package EulerProject.EulerProject34;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int[] array = new int [10];
        array = populateArray(array);
        for (int num = 3; num < 3000000; num++) {
            if (checkFactorial(array, num) == num) {
                sum += num;
            }
        }
        System.out.println(sum);
    }
    private static int checkFactorial(int[] array, int num) {
        int sum = 0;
        while (num != 0) {
            sum += array[num%10];
            num /= 10;
        }
        return sum;
    }
    private static int factorial(int num) {
        int Sum = 1;
        for (int i = num; i > 0; i--) {
            Sum *= i;
        }
        return Sum;
    }

    private static int[] populateArray(int[] array) {
        array[0] = 1;
        for (int pos = 0; pos < array.length; pos++) {
            array[pos] = factorial(pos);
        }
        return array;
    }
}