package EulerProject.EulerProject64;

public class Main {
    static class Pair {
        int extra;
        int denominator;
    }
    public static void main(String[] args) {
        int odds = 0;
        for (int sqrt = 2; sqrt <= 10000; sqrt++) {
            if (findPeriods(sqrt) % 2 != 0) {
                odds++;
            }
        }
        System.out.println(odds);
    }
    public static int findPeriods(int sqrt) {
        int temp = (int)Math.sqrt(sqrt);
        if (temp * temp == sqrt) {
            return 2;
        }
        var pair = new Pair();
        pair.extra = (int)Math.sqrt(sqrt);
        int extra = pair.extra;
        pair.denominator = sqrt - pair.extra * pair.extra;
        int denominator = pair.denominator;
        int periods = 1;
        for ( ; ; periods++) {
            pair = findPeriod(sqrt, pair);
            if (extra == pair.extra && denominator == pair.denominator) {
                break;
            }
        }
        return periods;
    }
    public static Pair findPeriod(int sqrt, Pair pair) {
        Pair newPair = new Pair();
        int whole = (pair.extra + (int)Math.sqrt(sqrt))/pair.denominator;
        newPair.extra = pair.extra - whole * pair.denominator;
        newPair.extra = Math.abs(newPair.extra);
        newPair.denominator = (sqrt - newPair.extra * newPair.extra) / pair.denominator;
        return newPair;
    }
}