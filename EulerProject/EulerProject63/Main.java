package EulerProject.EulerProject63;

public class Main {
    public static void main(String[] args) {
        int numbers = 0;
        for (int base = 1; base <= 9; base++) {
            for (int exponent = 1; exponent <= 25; exponent++) {
                if (exponent == (int)(exponent*(Math.log10(base))) + 1) {
                    numbers++;
                } else {
                    break;
                }
            }
        }
        System.out.println(numbers);
    }
}