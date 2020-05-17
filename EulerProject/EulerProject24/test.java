package EulerProject.EulerProject24;

public class test {
    public static void main(String[] args) {
        int[] array = {0,1,2};
        int swap = 0;
        int swapnum = 0;
        for (int amount = 0; amount < 1000000; amount++) {
            int temp = array[2];
            array[2] = array[1];
            array[1] = temp;

            while (array[swapnum - 1] < array[swapnum]) {
                swapnum--;
            }
            if (swapnum == swap - 1) {
                reverseNumber(array, swap);
                swapNumber(array, swap);
            }
        }
    }
private static void reverseNumber(int[] array, int swap) {
    for (int pos = swap + 1; pos < array.length; pos ++) {
        array[pos] = pos;
    }
}

private static void swapNumber(int[] array, int swap) {
    int temp = array[swap];
    array[swap] = array[swap + 1];
    array[swap + 1] = temp;
}
}