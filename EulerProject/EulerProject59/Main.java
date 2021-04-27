package EulerProject.EulerProject59;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\eplus\\github\\EulerProject\\EulerProject\\EulerProject59\\p059_cipher.txt");
        Scanner scanner = new Scanner(file);
        String temp = scanner.nextLine();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < temp.length(); i++) {
            int num = 0;
            while (i < temp.length() && temp.charAt(i) != ',') {
                num *= 10;
                num += temp.charAt(i) - '0';
                i++;
            }
            arrayList.add(num);
        }
        int pos = 0;
        int[] array = new int[arrayList.size()];
        for (int i : arrayList) {
            array[pos] = i;
            pos++;
        }
        System.out.println(findSum(array));
    }
    public static int[] decode(int[] array, int[] key) {
        int[] decoded = new int[array.length];
        int i = 0;
        for (int pos = 0; pos < array.length; pos++) {
            decoded[pos] = array[pos] ^ key[i];
            i++;
            if (i == key.length) {
                i = 0;
            }
        }
        return decoded;
    }
    public static boolean testKey(int[] decoded) {
        int c = 0;
        for (int i : decoded) {
            boolean isCapital = i >= 'A' && i <= 'Z';
            boolean islowerCase = i >= 'a' && i <= 'z';
            boolean isSpace = i == ' ';

            if (isCapital || islowerCase || isSpace) {
                c++;
            }
        }
        return c >= decoded.length * 0.9;
    }
    public static int findSum(int[] array) {
        int sum = 0;
        for (char a = 'a'; a <= 'z'; a++) {
            for (char b = 'a'; b <= 'z'; b++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    int[] key = new int[3];
                    key[0] = a;
                    key[1] = b;
                    key[2] = c;
                    int[] decoded = decode(array, key);
                    if (testKey(decoded)) {
                        byte[] s = new byte[decoded.length];
                        for (int i = 0; i < decoded.length; ++i) {
                            s[i] = (byte)decoded[i];
                        }
                        System.out.println(new String(s, StandardCharsets.UTF_8));
                    }
                    if (testKey(decoded)) {
                        for (int i = 0; i < decoded.length; i++) {
                            sum += decoded[i];
                        }
                        return sum;
                    }
                }
            }
        }
        return sum;
    }
}