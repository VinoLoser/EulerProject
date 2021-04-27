package EulerProject.EulerProject55;

public class Main {
    public static void main(String[] args) {
        int lychrelNum = 0;
        for (int num = 1; num < 10000; num++) {
            int[] array = new int[100];
            int pos = 0;
            array[pos] = num;
            while (array[pos] / 10 != 0) {
                array[pos + 1] = array[pos] / 10;
                array[pos] %= 10;
                pos++;
            }
            int i = 0;
            for (; i <= 50; i++) {
                array = addPalindromes(array);
                if (checkPalindrome(array)) {
                    break;
                }
            }
            if (i > 50) {
                lychrelNum++;
            }
        }
        System.out.println(lychrelNum);
    }

    public static boolean checkPalindrome(int[] array) {
        int length = checkLength(array)+1;
        for (int i = 0; i < length / 2 + 1; i++) {
            if (array[i] != array[length - i - 1]) {
                return false;
            }
        }
        return true;
    }
    public static int checkLength(int[] array) {
        for (int i = array.length-1; i >= 0; i--) {
            if (array[i] != 0) {
                return i;
            }
        }
        return -1;
    }
    public static int[] addPalindromes(int[] array) {
        int[] result = new int[100];
        int length = checkLength(array)+1;
        for (int i = 0; i < length; i++) {
            result[i] += array[i] + array[length - i - 1];
            result[i + 1] = result[i] / 10;
            result[i] %= 10;
        }
        return result;
    }
}