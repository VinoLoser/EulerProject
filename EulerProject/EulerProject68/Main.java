package EulerProject.EulerProject68;

public class Main {

    private static String max = "";

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        permutate(array, 0);
        System.out.println(max);
    }

    private static String encode(int[] a) {
        String string = "";
        for (int i = 5; i < 10; i++) {
            string += "" + a[i] + a[i % 5] + a[(i + 1) % 5];
        }
        return string;
    }

    private static boolean checkSums(int[] a) {
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += a[i];
        }
        int x = 11 + total / 5;
        int minvalue = Integer.MAX_VALUE;
        for (int i = 5; i < 10; ++i) {
            a[i] = x - (a[i % 5] + a[(i + 1) % 5]);
            minvalue = Math.min(minvalue, a[i]);
        }
        int check = 0;
        for (int i : a) {
            if (i >= 1 && i <= 10) {
                check = check | (1 << (i - 1));
            }
        }
        return check == 1023 && a[5] == minvalue;
    }

    private static void permutate(int[] array, int i) {
        if (i == 5) {
            int[] temp = array.clone();
            if (checkSums(temp)) {
                String string = encode(temp);
                if (string.compareTo(max) > 0) {
                    max = string;
                }
            }
            return;
        }
        for (int pos = i; pos < array.length - 1; pos++) {
            swap(array, i, pos);
            permutate(array, i + 1);
            swap(array, i, pos);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}