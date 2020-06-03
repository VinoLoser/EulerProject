package EulerProject.EulerProject30;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int num = 2; num < 10000000; num++) {
            if (checkNum(num) == num) {
                sum += num;
            }
        }
        System.out.println(sum);
    }
 
    private static int checkNum(int num) {
        int sum = 0;
        while (num > 0) {
            int temp = 1;
            for (int exponent = 1; exponent <= 5; exponent++) {
                temp *= num%10;
            }
            sum += temp;
            num /= 10;
        }
        return sum;
    }
}