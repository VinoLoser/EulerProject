package EulerProject.EulerProject43;

public class Main {
    public static void main(String[] args) {
        int[] array = findTotalSum();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }

    public static boolean checkTwo(int d4) {
        if (d4 % 2 == 0) {
            return true;
        } else return false;
    }

    public static boolean checkThree(int sumOfDigits) {
        if (sumOfDigits % 3 == 0) {
            return true;
        } else return false;
    }
    
    public static boolean checkFive(int d6) {
        if (d6 == 5 || d6 == 0) {
            return true;
        } else return false;
    }

    public static boolean checkSeven(int num) {
        if (num % 7 == 0) {
            return true;
        } else return false;
    }
    
    public static boolean checkEleven(int num) {
        if (num % 11 == 0) {
            return true;
        } else return false;
    }

    public static boolean checkThirteen(int[] array) {
        int num = array[6] * 100 + array[7] * 10 + array[8];
        if (num % 13 == 0) {
            return true;
        } else return false;
    }

    public static boolean checkSeventeen(int num) {
        if (num % 17 == 0) {
            return true;
        } else return false;
    }



    //stuffs

    public static int find(int[] array) {
        int current = array.length - 1;
        int next = current - 1;
        while (array[current] > array[next]) {
            current--;
            next--;
        }
        return next;
    }
    public static void swap(int swap, int[] array) {
        int pos = array.length - 1;
        while(array[pos]>array[swap]) 
            pos--;
        int temp = array[swap];
        array[swap] = array[pos];
        array[pos] = temp; 
    }

    public static int[] reverse(int end, int begin, int[] array) {
        if ((end + begin)%2 == 0) {
            if (end != begin) {
                int temp = array[end];
                array[end] = array[begin];
                array[begin] = temp;
                return reverse(end+1, begin-1, array);
            }
        } else {
            int temp = array[end];
            array[end] = array[begin];
            array[begin] = temp;
            if (end != begin - 1) {
                return reverse(end+1, begin-1, array);
            }
        }
        return array;
    }

    //ahhhh help

    public static int[] findTotalSum() {
        //create array
        int[] array = new int [10];
        int num = 9;
        for (int pos = 0; pos < array.length; pos++) {
            array[pos] = num;
            num--;
        }
        // actually do stuff to array
        int[] sum = new int[20];
        for (; ;) {
            //change array
            int decreasingOrder = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == i + 1) {
                    decreasingOrder++;
                }
            }
            if (decreasingOrder == array.length - 1) {
                return sum;
            }
            int temp = find(array);
            swap(temp, array);
            reverse(temp + 1, array.length-1, array);
            //check if array fits in circumstances
            int[] tempArray = array;
            if (checkTwo(array[3]) && checkThree(array[2] + array[3] + array[4]) && checkFive(array[5]) && checkSeven(array[4] * 100 + array[5] * 10 + array[6]) && checkEleven(array[5] * 100 + array[6] * 10 + array[7]) && checkThirteen(tempArray) && checkSeventeen(array[7] * 100 + array[8] * 10 + array[9])) {
                sum = findSum(sum, array);
            }
        }
    }

    public static int[] findSum(int[] currentSum, int[] add) {
        int extra = currentSum.length - add.length;
        for (int pos = add.length - 1; pos >= 0; pos--) {
            currentSum[pos + extra] += add[pos];
        }
        for (int pos = currentSum.length - 1; pos >= 0; pos--) {
            if (currentSum[pos] >= 10) {
                currentSum[pos - 1] += currentSum[pos] / 10;
                currentSum[pos] %= 10;
            }
        }
        return currentSum;
    }
}
