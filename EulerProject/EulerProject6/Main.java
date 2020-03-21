public class Main {
    public static void main(String[] args) {
        int squareSum = 0;
        int total = 0;
        for (int i = 1; i <= 100; i++) {
            squareSum += i*i;
            total += i;

        }
        System.out.println(total * total - squareSum);
    }
}