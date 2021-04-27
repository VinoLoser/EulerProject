import java.util.Arrays;

public class Main {
    static final int size = (int)Math.pow(10, 7);
    public static void main(String[] args) {
        int minValue = 0;
        double min = Integer.MAX_VALUE;
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
            if (checkPermutations(i, array[i]) && compare < min) {
                min = compare;
                minValue = i;
            }
        }
        System.out.println(minValue);
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
    public static boolean checkPermutations(int num, int totient) {
        String n = sortString(String.valueOf(num));
        String result = sortString(String.valueOf(totient));
        return n.equals(result);
    }
    public static String sortString(String inputString) {
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
