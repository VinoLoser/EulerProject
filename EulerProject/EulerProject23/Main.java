package EulerProject.EulerProject23;

public class Main {
    public static void main(String[] args) {
        int max = 28123;
        int[] array = new int[28123];
        findAbundantNums(max, array);
        int arrayLength = 0;
        while (array[arrayLength] != 0) {
            arrayLength++;
        }
        System.out.println(findPosSum(arrayLength, array));
    }
     
    private static void findAbundantNums(int max, int[] array) {
        int arrayPos = 0;
        for (int i = 2; i <= max; i++) {
            int divisorTotal = 0;
            for (int divisor = 1; divisor < i; divisor++) {
                if (i % divisor == 0) {
                    divisorTotal += divisor;
                }
            }
            if (divisorTotal > i) {
                array[arrayPos] = i;
                arrayPos++;
            }
        }
    }

    private static int findPosSum(int arrayLength, int[] array) {
        int[] sum = new int [28124];
        for (int pos = 0; pos < sum.length; pos++) {
            sum[pos] = pos;
        }
        for (int arrayPos = 0; arrayPos < arrayLength-1; arrayPos++) {
            for (int pos = arrayPos; pos < arrayLength; pos++) {
                int num = array[arrayPos] + array[pos];
                if (num <= 28123) {
                    sum[num] = 0;
                }
            }
        }
        int total = 0;
        for (int pos = 0; pos < sum.length; pos++) {
            total += sum[pos];
        }
        return total;
    }
}