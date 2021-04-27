package EulerProject.EulerProject14;

public class Test {
    public static void main(String[] args) {
        long greatestNumber = 0;
        int greatestChain = 0;
        for (long number = 2l; number < 10; number++) {
            int chain = 0;
            long originalNumber = number;
            for (; number > 1; chain++) {
                if (number % 2 == 0) {
                    number *= 2;
                } else {
                    number /= 3;
                    number++;
                }
            }
            if (chain > greatestChain) {
                greatestChain = chain;
                greatestNumber = originalNumber;
            }
        }
        System.out.println(greatestNumber);
    }
}