package EulerProject.EulerProject21;

public class Main {
    public static void main(String[] args) {
        int numbersTotal = 10000;
        int[] array = new int[numbersTotal];
        for (int number = 1; number < numbersTotal; number++) {
            checkDivisors(number, array);
        }
        int sumOfAmicableNumbers = 0;
        for (int number = 1; number < numbersTotal; number++) {
            int numbersPair = array[number];
            if (numbersPair < numbersTotal) {
                if (array[numbersPair] == number && number != numbersPair) {
                    sumOfAmicableNumbers += number;
                }
            }
        }
        System.out.print(sumOfAmicableNumbers);
        checkDivisors(220, array);
        //System.out.println(array[220]);
    }
    private static void checkDivisors(int number, int[] array) {
        int sumOfDivisors = 0;
        for (int divisor = number-1; divisor > 0; divisor--) {
            if (number%divisor == 0) {
                sumOfDivisors += divisor;
            }
        }
        array[number] = sumOfDivisors;
    }
}