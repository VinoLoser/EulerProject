package EulerProject.EulerProject27;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int current;
        int largest = 0;
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        findPrimes(map);
        for (int a = -999; a <= 999; a += 2) {
            for (int b = -1000; b <= 1000; b++) {
                current = checkPrime(a, b, map);
                if (current > largest) {
                    answer = a * b;
                    largest = current;
                }
            }
        }
        System.out.println(answer);
        System.out.print(largest);
    }

    private static int checkPrime(int a, int b, HashMap<Integer, Integer> map) {
        if (map.containsKey(Math.abs(b))) {
            if (map.containsKey(Math.abs(a + b + 1))) {
                int n = 0;
                while (n < b) {
                    int num = (n * n) + (a * n) + b;
                    if (map.containsKey(Math.abs(num))) {
                        n++;
                    } else {
                        break;
                    }
                }
                return n;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    }

    private static void findPrimes(HashMap<Integer, Integer> map) {
        int[] array = new int [2100000];
        for (int pos = 2; pos < array.length; pos++) {
            if (array[pos] == 0) {
                for (int multiples = pos; multiples * pos < array.length ; multiples++) {
                    if (multiples * pos > 0) {
                        array[multiples * pos] = 1;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int pos = 2; pos < array.length; pos++) {
            if (array[pos] != 1) {
                map.put(pos, pos);
            }
        }
    }
}