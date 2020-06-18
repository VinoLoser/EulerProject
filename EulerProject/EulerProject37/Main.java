package EulerProject.EulerProject37;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(2);
        queue.add(3);
        queue.add(5);
        queue.add(7);
        int[] array = { 1, 3, 9, 7 };
        int sum = 0;
        while (queue.size() != 0) {
            int firstNum = queue.remove();
            for (int pos = 0; pos < array.length; pos++) {
                int newNum = firstNum * 10 + array[pos];
                if (checkPrime(newNum))
                    queue.add(newNum);
                if (checkNum(newNum)) {
                    sum += newNum;
                    System.out.println(newNum);
                }
            }
        }
        System.out.println(sum);
    }
    private static boolean checkNum(int num) {
        String string = String.valueOf(num);
        String string1 = string;
        while (!string.equals("")) {
            if (!checkPrime(Integer.valueOf(string)) && !checkPrime(Integer.valueOf(string1)))
                return false;
            string = string.substring(1, string.length());
            string1 = string.substring(0, string1.length() - 1);
        }
        return true;
    }
    private static boolean checkPrime(int num) {
        if (num == 1) {
            return false;
        }
        int x = (int)Math.sqrt(num);
        for (int divisor = 2; divisor < x; divisor++) {
            if (num%divisor == 0) {
                return false;
            }
        }
        return true;
    }
}