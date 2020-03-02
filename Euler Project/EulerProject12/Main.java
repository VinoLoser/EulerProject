public class Main {
    public static void main(String[] args) {
        int number = 0;
        for (int x = 1; ;x++) {
            number += x;
            if (findFactors(number) > 500) {
                System.out.println(number);
                break;
            }
        }
    }
    
    private static int findFactors(int number) {
        int numberOfFactors = 0;
        for (int divisor = 1; divisor <= Math.round(Math.sqrt(number)); divisor ++) {
            if (number % divisor == 0) {
                if (divisor *divisor == number) {
                    numberOfFactors ++;
                } else numberOfFactors += 2;
            }
        }
        return numberOfFactors;
    }
}