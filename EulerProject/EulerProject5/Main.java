public class Main {
    public static void main(String[] args) {
        for (int number = 20;; number++) {
            if (checkNumber(number) == true) {
                System.out.println(number);
                break;
            }
        }
    }

    private static boolean checkNumber(int number) {
        for (int divisor = 2; divisor <= 20; divisor++) {
            if (number % divisor != 0) {
                return false;
            }
        }
        return true;
    }
}