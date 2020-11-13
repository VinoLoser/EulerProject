package EulerProject.EulerProject41;

public class Test {
    public static void main(String[] args) {
        int[] array = findPandigitalPrime(7);
        for (int i : array) {
            System.out.print(i);
        }
    }
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
    public static boolean checkPrime(int[] array) {
        String string = "";
        for (int i : array) {
            string += Integer.toString(i);
        }
        int num = Integer.parseInt(string);
        for (int divisor = 2; divisor < num; divisor++) {
            if (num%divisor == 0) {
                return false;
            }
        }
        return true;
    }
    public static int[] findPandigitalPrime(int arrayLength) {
        //create array
        int[] array = new int [arrayLength];
        int num = arrayLength;
        for (int pos = 0; pos < array.length; pos++) {
            array[pos] = num;
            num--;
        }
        //check array
        for (; ;) {
            int temp = find(array);
            swap(temp, array);
            reverse(temp + 1, array.length-1, array);
            if (checkPrime(array)) {
                return array;
            }
            if (find(array) == -1) {
                break;
            }
        }
        return findPandigitalPrime(arrayLength - 1);
    }
}