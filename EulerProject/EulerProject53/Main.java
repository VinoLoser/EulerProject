package EulerProject.EulerProject53;

public class Main {

    static int amount = 0;
    public static void main(String[] args) {
        int[] array = new int[101];
        for (int m = 0; m <= 100; m++) {
            for (int n = m; n >= 0; n--) {
                if (m == n || n == 0) {
                    array[n] = 1;
                } else {
                    array[n] = Math.min(1000001, array[n-1] + array[n]);
                    amount += array[n] > 1000000 ? 1 : 0;
                }
            }
        }
        System.out.println(amount);
    }
}