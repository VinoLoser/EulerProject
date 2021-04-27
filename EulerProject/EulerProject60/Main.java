package EulerProject.EulerProject60;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Main {
    private static HashSet<Integer> intersect(HashSet<Integer> x, HashSet<Integer> y)
    {
        if (x == null || y == null) {
            return new HashSet<Integer>();
        }
        HashSet<Integer> res = new HashSet<Integer>(x);
        res.retainAll(y);
        return res;
    }

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        int lowestSum = 0;
        final int N = 30000;

        int[] array = new int[N + 1];
        sift(array);
        int total = 0;
        for (int i = 0; i < N; ++i) {
            if (array[i] == 0) ++total;
        }

        int[] arrayList = new int[total];
        int pos = 0;
        for (int i = 0; i < N; ++i) {
            if (array[i] == 0) {
                arrayList[pos++] = i;
            }
        }
        HashMap<Integer, HashSet<Integer>> pairs = new HashMap<Integer, HashSet<Integer>>();
        for (int i1 = 0; i1 < arrayList.length - 1; i1++) {
            int num1 = arrayList[i1];
            for (int i2 = i1+1; i2 < arrayList.length; i2++) {
                int num2 = arrayList[i2];
                if (parseInts(num1, num2, array)) {
                    HashSet<Integer> v = pairs.get(num1);
                    if (v == null) {
                        v = new HashSet<Integer>();
                        pairs.put(num1, v);
                    }
                    v.add(num2);
                }
            }
        }
        for (Map.Entry<Integer, HashSet<Integer>> entry : pairs.entrySet()) {
            Integer i1 = entry.getKey();
            HashSet<Integer> s2 = entry.getValue();
            for (Integer i2 : s2) {
                HashSet<Integer> s3 = intersect(s2, pairs.get(i2));
                for (Integer i3 : s3) {
                    HashSet<Integer> s4 = intersect(s3, pairs.get(i3));
                    for (Integer i4 : s4) {
                        HashSet<Integer> s5 = intersect(s4, pairs.get(i4));
                        for (Integer i5 : s5) {
                            int s  = i1 + i2 + i3 + i4 + i5;
                            if (s < lowestSum || lowestSum == 0) {
                                lowestSum = s;
                            }
                        }
                    }
                }
            }
        }
        /*
        for (int i1 = 0; i1 < arrayList.length - 4; i1++) {
            int num1 = arrayList[i1];
            for (int i2 = i1+1; i2 < arrayList.length - 3; i2++) {
                int num2 = arrayList[i2];
                if (parseInts(num1, num2, array)) {
                    for (int i3 = i2+1; i3 < arrayList.length - 2; i3++) {
                        int num3 = arrayList[i3];
                        if (parseInts(num1, num3, array) && parseInts(num2, num3, array)) {
                            for (int i4 = i3+1; i4 < arrayList.length - 1; i4++) {
                                int num4 = arrayList[i4];
                                if (parseInts(num1, num4, array) && parseInts(num2, num4, array) && parseInts(num3, num4, array)) {
                                    for (int i5 = i4+1; i5 < arrayList.length; i5++) {
                                        int num5 = arrayList[i5];
                                        if (parseInts(num5, num1, array) && parseInts(num5, num2, array) && parseInts(num5, num3, array) && parseInts(num5, num4, array)) {
                                            int sum = num1 + num2 + num3 + num4 + num5;
                                            if (sum < lowestSum || lowestSum == 0) {
                                                lowestSum = sum;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        */
        final long endTime = System.currentTimeMillis();
        System.out.println(lowestSum);
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    public static boolean parseInts(int num1, int num2, int[] array) {
        String temp1 = String.valueOf(num1);
        String temp2 = String.valueOf(num2);
        return checkPrime(Long.parseLong(temp1 + temp2), array) && 
                checkPrime(Long.parseLong(temp2 + temp1), array);
    }

    public static void sift(int[] array) {
        array[0] = array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[i] == 0) {
                for (int multiply = 2; multiply * i < array.length; multiply++) {
                    array[multiply * i] = 1;
                }
            }
        }
    }

    public static boolean checkPrime(long num, int[] array) {
        if (num < array.length) {
            return array[(int)num] == 0;
        }
        return GFG.isPrime(num);
    }

    public static class GFG {
        // Utility function to do modular
        // exponentiation. It returns (x^y) % p
        static long power(long x, long y, long p) {
             
            long res = 1; // Initialize result
             
            //Update x if it is more than or
            // equal to p
            x = x % p;
     
            while (y > 0) {
                 
                // If y is odd, multiply x with result
                if ((y & 1) == 1)
                    res = (res * x) % p;
             
                // y must be even now
                y = y >> 1; // y = y/2
                x = (x * x) % p;
            }
             
            return res;
        }
         
        // This function is called for all k trials.
        // It returns false if n is composite and
        // returns false if n is probably prime.
        // d is an odd number such that d*2<sup>r</sup>
        // = n-1 for some r >= 1
        static boolean miillerTest(long d, long n, long a) {
             
            // Pick a random number in [2..n-2]
            // Corner cases make sure that n > 4
         
            // Compute a^d % n
            long x = power(a, d, n);
         
            if (x == 1 || x == n - 1)
                return true;
         
            // Keep squaring x while one of the
            // following doesn't happen
            // (i) d does not reach n-1
            // (ii) (x^2) % n is not 1
            // (iii) (x^2) % n is not n-1
            while (d != n - 1) {
                x = (x * x) % n;
                d *= 2;
             
                if (x == 1)
                    return false;
                if (x == n - 1)
                    return true;
            }
         
            // Return composite
            return false;
        }
         
        // It returns false if n is composite
        // and returns true if n is probably
        // prime. k is an input parameter that
        // determines accuracy level. Higher
        // value of k indicates more accuracy.
        static boolean isPrime(long n) {
             
            // Corner cases
            if (n <= 1 || n == 4)
                return false;
            if (n <= 3)
                return true;
         
            // Find r such that n = 2^d * r + 1
            // for some r >= 1
            long d = n - 1;
             
            while (d % 2 == 0)
                d /= 2;
         
            // Iterate given nber of 'k' times
            if (!miillerTest(d, n, 2))
                return false;
            if (!miillerTest(d, n, 3))
                return false;
            if (!miillerTest(d, n, 5))
                return false;
         
            return true;
        }
    }
}