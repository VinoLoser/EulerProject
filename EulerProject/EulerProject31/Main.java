package EulerProject.EulerProject31;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 10, 20, 50, 100, 200};
        System.out.println(checkSolution(array, 0, 200));
    }
    private static int checkSolution(int[] array, int pos, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (pos == array.length) {
            return 0;
        }
        if (array[pos] > sum) {
            return 0;
        }
        return checkSolution(array, pos+1, sum) + checkSolution(array, pos, sum - array[pos]);
    }
}