package EulerProject.EulerProject62;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        final int length = 10000;
        long[] set = new long[length + 1];
        for (int i = 1; i <= length; i++) {
            set[i] = (long) i * i * i;
        }
        var groups = new HashMap<String, ArrayList<Long>>();
        for (long i : set) {
            String rep = rep(i);
            if (!groups.containsKey(rep)) {
                var group = new ArrayList<Long>();
                group.add(i);
                groups.put(rep, group);
            } else {
                groups.get(rep).add(i);
            }
        }
        long smallestCube = Long.MAX_VALUE;
        for (var entry : groups.entrySet()) {
            var temp = entry.getValue();
            if (temp.size() >= 5) {
                if (temp.contains(1L)) {
                    printArrayList(temp);
                }
                for (long test : temp) {
                    if (test < smallestCube) {
                        smallestCube = test;
                    }
                }
            }
        }
        System.out.println(smallestCube);
    }
    private static String rep(long num) {
        String temp = String.valueOf(num);
        char tempArray[] = temp.toCharArray();
          
        // sort tempArray
        Arrays.sort(tempArray);
          
        // return new sorted string
        return new String(tempArray);
    }
    private static void printArrayList(ArrayList<Long> array) {
        for (long i : array) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}