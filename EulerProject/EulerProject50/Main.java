package EulerProject.EulerProject50;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        checkPrimes(array);
        int highestPrime = 0;
        int most = 0;
        for (int x = 1; x < array.length-1; x++) {
            int total = 0;
            int amountOfPrimes = 0;
            for (int i = 2 + x; total < array.length && i < array.length; i++) {
                if (array[i] == 0) {
                    total += i;
                    amountOfPrimes++;
                    if (total < array.length && array[total] == 0 && amountOfPrimes > most) {
                        highestPrime = total;
                        most = amountOfPrimes;
                    }
                }
            }
        }
        System.out.println(highestPrime);
        System.out.println(most);
    }
    public static void checkPrimes(int[] array) {
        for (int i = 2; i < array.length; i++) {
            if (array[i] == 0) {
                for (int temp = 2; temp * i < array.length; temp++) {
                    array[temp*i] = 1;
                }
            }
        }
    }
}
