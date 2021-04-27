package EulerProject;

public class permutations {
    public static void main(String[] args) {
        int[] array = {0,1,2};
        int swap = array.length-3;
        for(; ;) {
            int temp = array[array.length-1];
            array[array.length-1] = array[array.length-2];
            array[array.length-2] = temp;
            for (int i : array) {
                System.out.print(i);
            }
            System.out.println();
            swap = findLargestNum(array) - 1;
            if (swap == -1) {
                break;
            }
            swapNum(array, swap);
            reverseNumber(array, swap);
            for (int i : array) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    private static int findLargestNum(int[] array) {
        int findlargest = array.length-1;
        while (findlargest > 0 && array[findlargest - 1] > array[findlargest]) {
            findlargest--;
        }
        return findlargest;
    }
    private static void reverseNumber(int[] array, int swap) {
        int numberChangeadd = swap + 1;
        int numberChangesubtract = array.length-1;
        while (numberChangeadd < numberChangesubtract) {
            int temp = array[numberChangeadd];
            array[numberChangeadd] = array[numberChangesubtract];
            array[numberChangesubtract] = temp;

            numberChangeadd++;
            numberChangesubtract--;
        }
    }
    private static void swapNum(int[] array, int swap) {
        int pos = array.length-1;
        while(array[pos]<array[swap])
            pos--;
        int temp = array[swap];
        array[swap] = array[pos];
        array[pos] = temp;
    }
}
