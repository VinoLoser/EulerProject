package EulerProject.EulerProject26;

public class Main {
    public static void main(String[] args) {
        int denominator = 2;
        int comparison = 0;
        int largest = 0;
        int largestDenominator = 2;
        while (denominator < 1000) {
            comparison = divideAndCheckNum(denominator);
            if (comparison > largest) {
                largest = comparison;
                largestDenominator = denominator;
            }
            denominator++;
        }
        System.out.print(largestDenominator);
    }
    private static int divideAndCheckNum(int d) {
        int[] array = new int [1000];
        int n = 1;
        for (int pos = 0; pos < array.length; pos++) {
            array[pos] = n%d;
            n %= d;
            if (n < d) {
                n*=10;
            }
            for (int i = 0; i < pos - 1; i++) {
                if (n/10 == array[i]) {
                    return pos - i;
                }
            }
        }
        return 0;
    }
}