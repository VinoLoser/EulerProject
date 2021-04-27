package EulerProject.EulerProject61;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, HashSet<String>> hashMap = new HashMap<Integer, HashSet<String>>();
        findFigurateNumbers(hashMap);
        final long startTime = System.currentTimeMillis();
        System.out.println(search(hashMap));
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime));
    }

    public static int search(HashMap<Integer,HashSet<String>> hashMap) {
        for (Map.Entry<Integer, HashSet<String>> num1 : hashMap.entrySet()) {
            HashSet<String> temp1 = num1.getValue();
            for (String string1 : temp1) {
                for (Map.Entry<Integer, HashSet<String>> num2 : hashMap.entrySet()) {
                    HashSet<String> temp2 = num2.getValue();
                    for (String string2 : temp2) {
                        if ((!string1.equals(string2)) && checkCircleNum(num1.getKey(), num2.getKey())) {
                            for (Map.Entry<Integer, HashSet<String>> num3 : hashMap.entrySet()) {
                                HashSet<String> temp3 = num3.getValue();
                                for (String string3 : temp3) {
                                    if ((!string1.equals(string3)) && (!string2.equals(string3)) && checkCircleNum(num2.getKey(), num3.getKey())) {
                                        for (Map.Entry<Integer, HashSet<String>> num4 : hashMap.entrySet()) {
                                            HashSet<String> temp4 = num4.getValue();
                                            for (String string4 : temp4) {
                                                if ((!string1.equals(string4)) && (!string2.equals(string4)) && (!string3.equals(string4)) && checkCircleNum(num3.getKey(), num4.getKey())) {
                                                    for (Map.Entry<Integer, HashSet<String>> num5 : hashMap.entrySet()) {
                                                        HashSet<String> temp5 = num5.getValue();
                                                        for (String string5 : temp5) {
                                                            if ((!string1.equals(string5)) && (!string2.equals(string5)) && (!string3.equals(string5)) && (!string4.equals(string5)) && checkCircleNum(num4.getKey(), num5.getKey())) {
                                                                for (Map.Entry<Integer, HashSet<String>> num6 : hashMap.entrySet()) {
                                                                    HashSet<String> temp6 = num6.getValue();
                                                                    for (String string6 : temp6) {
                                                                        if ((!string1.equals(string6)) && (!string2.equals(string6)) && (!string3.equals(string6)) && (!string4.equals(string6)) && (!string5.equals(string6)) && checkCircleNum(num5.getKey(), num6.getKey()) && checkCircleNum(num6.getKey(), num1.getKey())) {
                                                                            return num1.getKey() + num2.getKey() + num3.getKey() + num4.getKey() + num5.getKey() + num6.getKey();
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
                                }
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static boolean checkCircleNum(int num1, int num2) {
        String num1String = String.valueOf(num1);
        String num2String = String.valueOf(num2);
        if ((num1String.charAt(3) - '0') + (num1String.charAt(2) - '0')* 10 == 
        (num2String.charAt(1)-'0') + (num2String.charAt(0)-'0') * 10) {
            return true;
        } 
        return false;
    }
    public static void findFigurateNumbers(HashMap<Integer, HashSet<String>> hashMap) {
        for (int i = 1000; i < 10000; i++) {
            int n = (int)(Math.sqrt(1 + 8 * i) - 1)/2;
            if (n * n + n == 2 * i) {
                if (hashMap.containsKey(i)) {
                    hashMap.get(i).add("Triangle");
                } else {
                    HashSet<String> hashSet = new HashSet<String>();
                    hashSet.add("Triangle");
                    hashMap.put(i, hashSet);
                }
            }
            n = (int)Math.sqrt(i);
            if (n * n == i) {
                if (hashMap.containsKey(i)) {
                    hashMap.get(i).add("Square");
                } else {
                    HashSet<String> hashSet = new HashSet<String>();
                    hashSet.add("Square");
                    hashMap.put(i, hashSet);
                }
            }
            n = (int)(1 + Math.sqrt(1 + 24 * i))/6;
            if (3 * n * n - n == 2 * i) {
                if (hashMap.containsKey(i)) {
                    hashMap.get(i).add("Pentagonal");
                } else {
                    HashSet<String> hashSet = new HashSet<String>();
                    hashSet.add("Pentagonal");
                    hashMap.put(i, hashSet);
                }
            }
            n = (int)(1 + Math.sqrt(1 + 8 * i))/4;
            if (2 * n * n - n == i) {
                if (hashMap.containsKey(i)) {
                    hashMap.get(i).add("Hexagonal");
                } else {
                    HashSet<String> hashSet = new HashSet<String>();
                    hashSet.add("Hexagonal");
                    hashMap.put(i, hashSet);
                }
            }
            n = (int)(3 + Math.sqrt(9 + 40 * i))/10;
            if (5 * n * n - 3 * n == 2 * i) {
                if (hashMap.containsKey(i)) {
                    hashMap.get(i).add("Heptagonal");
                } else {
                    HashSet<String> hashSet = new HashSet<String>();
                    hashSet.add("Heptagonal");
                    hashMap.put(i, hashSet);
                }
            }
            n = (int)(2 + Math.sqrt(4 + 12 * i))/6;
            if (3 * n * n - 2 * n == i) {
                if (hashMap.containsKey(i)) {
                    hashMap.get(i).add("Octagonal");
                } else {
                    HashSet<String> hashSet = new HashSet<String>();
                    hashSet.add("Octagonal");
                    hashMap.put(i, hashSet);
                }
            }
        }
    }
}