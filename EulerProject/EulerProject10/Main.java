package EulerProject.EulerProject10;

public class Main {
    public static void main(String[] args) {
        long sum = 0l;
        for (int number = 2; number < 20000000; number++) {
            
            if (checkPrime(number) == true) {
                sum += number;
            }
        }
        System.out.println(sum);
    }

    public static boolean checkPrime(int number) {
        for (int div = 2; div <= (int)Math.sqrt(number); div ++) {
            if (number%div == 0) return false;
        }
        return true;
    }
}