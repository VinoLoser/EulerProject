package EulerProject.EulerProject69;

public class Main {
    static final int size = 1000001;
    public static void main(String[] args) {
        int maxValue = 0;
        double max = 0;
        int[] array = new int[size];
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            int factor = findFactor(i);
            int power = findPower(factor, i);
            int firstTerm = (int)Math.pow(factor, power);
            if (firstTerm == i) {
                array[i] = i - i/factor;
                continue;
            }
            array[i] = array[firstTerm] * array[i / firstTerm];
            double compare = (double)i / array[i];
            if (compare > max) {
                max = compare;
                maxValue = i;
            }
        }
        System.out.println(maxValue);
    }
    public static int findPower(int factor, int num) {
        int power = 0;
        while (num % factor == 0) {
            num /= factor;
            power++;
        }
        return power;
    }
    public static int findFactor(int num) {
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return num;
    }
}