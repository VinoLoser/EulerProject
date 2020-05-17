package EulerProject.EulerProject26;

import java.util.HashMap;

public class FasterWay {
    public static void main(String[] args) {
        int denominator = 2;
        int comparison = 0;
        int largest = 0;
        int largestDenominator = 2;
        while (denominator < 1000) {
            comparison = divideAndCheckNum(denominator);
            if (comparison > largest) {
                largest = comparison;
                largestDenominator = denominator;
            }
            denominator++;
        }
        System.out.print(largestDenominator);
    }
    private static int divideAndCheckNum(int d) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = 1;
        for (int pos = 0; pos < 1000; pos++) {
            int temp = n;
            n %= d;
            if (n < d) {
                n*=10;
            }
            if (map.containsKey(n/10)) {
                return pos - map.get(n/10);
            }
            map.put(temp%d, pos);
        }
        return 0;
    }
    
}

/*
for (int i = 0; i < pos - 1; i++) {
                if (n/10 == array[i]) {
                    return pos - i;
                }
            }
*/


    