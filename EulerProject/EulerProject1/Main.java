public class Main {
    public static void main(String[] args) {
        int currentNumber = 0;
        int sum = 0;
        for(currentNumber = 0; currentNumber < 1000; currentNumber ++) {
            if (currentNumber%3 == 0 || currentNumber%5 == 0) {
                sum += currentNumber;
            }
        }
        System.out.println(sum);
    }
}