package EulerProject.EulerProject32;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    //lower bound of d digit number
    //e.g d = 2, returns 10
    private static int getLB(int d) {
        return (int)(Math.pow(10, d - 1));
    }

    //upper bound of d digit number
    //e.g d = 2, returns 99
    private static int getUB(int d) {
        return getLB(d + 1) - 1;
    }

    public static void main(String[] args) {
        int result = 0;
        HashSet<Integer> num = new HashSet<Integer>();
        for (int ad = 1; ad < 3; ++ad) {
            int a1 = getLB(ad);
            int a2 = getUB(ad);
            int b1 = getLB(5 - ad);
            int b2 = getUB(5 - ad);
            for (int a = a1; a <= a2; ++a) {
                for (int b = b1; b <= b2; ++b) {
                    if (!num.contains(a*b) && checkNum(a, b, a * b)) {
                        num.add(a * b);
                        result += a * b;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static boolean checkNum(int a, int b, int product) {
        String num = String.valueOf(a) + String.valueOf(b) + String.valueOf(product);
        char tempArray[] = num.toCharArray(); 
        Arrays.sort(tempArray); 
        return new String(tempArray).equals("123456789"); 
    }
}