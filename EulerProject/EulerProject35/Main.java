package EulerProject.EulerProject35;

public class Main {
    public static void main(String[] args) {
        int[] array = new int [1000000];
        createArray(array);
        int totalPrimes = 0;
        for (int num = 2; num < array.length; num++) {
            if (FindNum(num, array) == true) {
                totalPrimes++;
            }
        }
        System.out.print(totalPrimes);
    }
    private static boolean FindNum(int num, int[] array) {
        String value = String.valueOf(num);
        for (int i = 1; i <= value.length(); i++) {
            if (array[Integer.valueOf(value)] == 1) {
                return false;
            }
            value = value.substring(1, value.length()) + value.substring(0, 1);
        }
        return true;
    }
    private static void createArray(int[] array) {
        for (int i = 2; i < array.length; i++) {
            if (i != 1) {
                for (int multiplier = 2; multiplier * i < array.length; multiplier++) 
                    array[i * multiplier] = 1;
            }
        }
    }
}