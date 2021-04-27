package EulerProject.EulerProject66;

import java.math.BigInteger;

public class Main {

    final static BigInteger one = new BigInteger("1");
    final static BigInteger zero = new BigInteger("0");
    static class Pair {
        int extra = 0;
        int denominator = 1;
        int whole = 0;
    }

    public static void main(String[] args) {
        BigInteger largestX = zero;
        int largestD = 0;
        for (int d = 0; d <= 1000; d++) {
            int sqrt = (int)Math.sqrt(d);
            if (sqrt * sqrt == d) {
                continue;
            }
            BigInteger numerator = findSmallestX(d);
            if (numerator.compareTo(largestX) > 0) {
                largestD = d;
                largestX = numerator;
            }
        }
        System.out.println(largestD);
    }
    public static BigInteger findSmallestX(int d) {
            int[] wholes = new int[100];
            var pair = new Pair();
            pair = findPeriod(d, pair);
            wholes[0] = pair.whole;
            BigInteger numerator = new BigInteger(String.valueOf(pair.whole));
            BigInteger denominator = one;
            int pos = 1;
            while (!checkXY(numerator, denominator, d)) {
                pair = findPeriod(d, pair);
                wholes[pos] = pair.whole;
                numerator = zero;
                denominator = one;
                for (int max = pos; max >= 0; max--) {
                    if (max != 0) {
                        BigInteger temp = denominator;
                        denominator = denominator.multiply(new BigInteger(String.valueOf(wholes[max]))).add(numerator);
                        numerator = temp;
                    } else {
                        numerator = numerator.add(denominator.multiply(new BigInteger(String.valueOf(wholes[max]))));
                    }
                }
                pos++;
            }
            //System.out.println("x = " + numerator + ", y = " + denominator + ", D = " + d);
            return numerator;
    }
    public static Pair findPeriod(int sqrt, Pair pair) {
        Pair newPair = new Pair();
        int whole = (pair.extra + (int)Math.sqrt(sqrt))/pair.denominator;
        newPair.extra = Math.abs(pair.extra - whole * pair.denominator);
        newPair.denominator = (sqrt - newPair.extra * newPair.extra) / pair.denominator;
        newPair.whole = whole;
        return newPair;
    }
    public static long gcd(long numerator, long denominator) {
        if (denominator == 0) return numerator;
        else return gcd(denominator, numerator % denominator);
    }
    public static boolean checkXY(BigInteger numerator, BigInteger denominator, int d) {
        var x = numerator.multiply(numerator);
        var y = denominator.multiply(denominator);
        var D = new BigInteger(String.valueOf(d));
        y = y.multiply(D);
        var result = x.subtract(y);
        return result.equals(one);
    }
}
