package EulerProject.EulerProject43;

public class Main {
    public static void main() {

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

    public static boolean checkSeven(int num, int d7) {
        if ((num - d7*2) % 7 == 0) {
            return true;
        } else return false;
    }
    
    public static boolean checkEleven(int num) {
        if (num % 11 == 0) {
            return true;
        } else return false;
    }

    public static boolean checkThirteen(String num) {
        if (num.charAt(0) + num.charAt(1) * 10 + num.charAt(2) * 9 == 0) {
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

    public static int[] findPandigitalPrime(int arrayLength) {
        //create array
        int[] array = new int [arrayLength];
        int num = arrayLength;
        for (int pos = 0; pos < array.length; pos++) {
            array[pos] = num;
            num--;
        }
        // actually do stuff to array
        int[] sum = new int[20];
        for (; ;) {
            //change array
            int temp = find(array);
            swap(temp, array);
            reverse(temp + 1, array.length-1, array);
            //check if array fits in circumstances
            if (checkTwo(array[3]) && checkThree(array[2] + array[3] + array[4]) && checkFive(array[5]) && checkSeven(array[4] * 100 + array[5] * 10 + array[6], array[6]) && checkEleven(array[5] * 100 + array[6] * 10 + array[7]) && checkThirteen(array[6] * 100 + array[7] * 10 + array[8]) && checkSeventeen(array[7] * 100 + array[8] * 10 + array[9])) {
                sum = findSum(sum, array);
            }
            if (find(array) == -1) {
                break;
            }
        }
        return sum;
    }

    public static int[] findSum(int[] currentSum, int[] add) {
        int carryBit = 0;
        for (int pos = add.length; pos >= 0; pos--) {
            currentSum[pos] += add[pos];
        }
    }
}
