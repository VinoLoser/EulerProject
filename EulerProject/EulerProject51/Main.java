package EulerProject.EulerProject51;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (int i = 100000; ; i++) {
            if (checkNum(i) && checkNum(i)) {
                break;
            }
        }
    }
    public static boolean checkPrime(int num) {
        for (int i = 2; i < (int)Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkNum(int num) {
        String n = String.valueOf(num);
        ArrayList<String> permutes = findPermutes(num);
        for (String change : permutes) {
            int primes = 0;
            int[] array = new int[8];
            int pos = 0;
            for (int y = 0; y < 10; y++) {
                String temp = changeString(String.valueOf(num), change, y);
                if (temp.charAt(0) != '0') {
                    if (checkPrime(Integer.parseInt(temp))) {
                        primes++;
                        array[pos] = Integer.parseInt(temp);
                        pos++;
                    }
                }
            }
            if (primes == 8) {
                for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " , ");
                }
                System.out.println();
                return true;
            }
        }
        return false;
    }
    public static ArrayList<String> findPermutes(int num) {
        String string = String.valueOf(num);
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int q = 0; q < string.length(); q++) {
            for (int r = 0; r < string.length(); r++) {
                for (int s = 0; s < string.length(); s++) {
                    if (s != r && r != q && s != q) {
                        String temp = String.valueOf(q) + String.valueOf(r) + String.valueOf(s);
                        temp = sortString(temp);
                        if (!arrayList.contains(temp)) {
                            arrayList.add(temp);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
    public static String sortString(String inputString) { 
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray); 
    }
    public static String changeString(String inputString, String change, int num) {
        char tempArray[] = inputString.toCharArray();
        for (int i = 0; i < change.length(); i++) {
            tempArray[change.charAt(i) - '0'] = (char)(num+48);
        }
        return new String(tempArray);
    }
}