package EulerProject.EulerProject58;

public class Main {
    public static void main(String[] args) {
        findPercentage();
    }
    public static void findPercentage() {
        double primes = 0;
        double total = 1;
        int n = 1;
        int sideLength = 3;
        for (; ;) {
            for (int t = 0; t <= 3; t++) {
                n += sideLength-1;
                if (isPrime(n)) {
                    primes++;
                }
                total++;
            }
            double temp = primes / total;
            if (temp * 100 <= 10) {
                System.out.println(sideLength);
                break;
            }
            sideLength += 2;
        }
    }
    public static boolean isPrime(int num) {
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num  % i == 0) {
                return false;
            }
        }
        return true;
    }
}
