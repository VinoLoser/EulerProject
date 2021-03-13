package EulerProject.EulerProject53;

public class Main {

    static int amount = 0;
    public static void main(String[] args) {
        int[][] array = new int[101][101];
        for (int m = 0; m <= 100; m++) {
            for (int n = 0; n <= m; n++) {
                if (m == n || n == 0) {
                    array[m][n] = 1;
                } else {
                    array[m][n] = Math.min(1000001, array[m-1][n-1] + array[m-1][n]);
                    amount += array[m][n] > 1000000 ? 1 : 0;
                }
            }
        }
        System.out.println(amount);
        /*
        for (int temp = 0; temp < array[0].length; temp++) {
            for (int i : array[temp]) {
                System.out.print(i);
            }
            System.out.println();
        }
        */
    }
}