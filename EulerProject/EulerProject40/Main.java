package EulerProject.EulerProject40;

public class Main {
    public static void main(String[] args) {
        int digit = 0;
        int number = 1;
        int targetDigit = 1;
        int product = 1;
        while (digit <= 1000000) {
            String num = String.valueOf(number);
            int temp = checkNum(num, digit, targetDigit);
            if (temp != -1) {
                targetDigit*=10;
                product *= temp;
            }
            digit += num.length();
            number++;
        }
        System.out.print(product);
    }
    private static int checkNum(String num, int digit, int targetDigit) {
        for (int i = 0; i < num.length(); i++) {
            digit++;
            if (targetDigit == digit) {
                return num.charAt(i) - '0';
            }
        }
        return -1;
    } 
}