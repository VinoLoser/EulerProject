package EulerProject.EulerProject47;

public class Main {
    public static void main(String[] args) {
        int[] num1 = {2};
        int[] num2 = {3};
        int[] num3 = {2};
        int[] num4 = {5};
        for (int i = 5; ; i++) {
            num1 = num2;
            num2 = num3;
            num3 = num4;
            num4 = findPrimeFactors(i);
            if (findLength(num1) == 4 && findLength(num2) == 4 && findLength(num3) == 4 && findLength(num4) == 4) { 
                System.out.println(i - 3);
                break;
            }
        }
    }
    public static int findLength(int[] array) {
        int num2Length = 0;
        for (int i : array) {
            if (i != 0) {
                num2Length++;
            }
        }
        return num2Length;
    }
    public static int[] findPrimeFactors(int num) {
        int[] array = new int[32];
        int pos = 0;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                array[pos] = i;
                pos++;
            }
            while (num % i == 0) {
                num /= i;
            }     
        }
        return array;
    }
}
