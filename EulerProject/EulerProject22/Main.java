package EulerProject.EulerProject22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, NullPointerException {
        String[] array = makeArray();
        int arrayLength = 0;  
        while (array[arrayLength] != null) {
            arrayLength++;
        }
        arrayLength--;
        for (int pos = 0; pos < arrayLength; pos++) {
            compareNumbers(array, pos, arrayLength);
        }
        int sum = 0;
        for (int pos = 0; pos <= arrayLength; pos++) {
            int tempsum = 0;
            for (int charPos = 0; charPos < array[pos].length(); charPos++) {
                tempsum += array[pos].charAt(charPos) - '@';
            }
            sum += tempsum * (pos+1);
        }
        System.out.println(sum);
    }

    private static String[] makeArray() throws FileNotFoundException {
        String[] array = new String[1000033];
        File file = new File("C:\\Users\\eplus\\Desktop\\p022_names.txt");
        Scanner scanner = new Scanner(file);
        //create array
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int arrayPos = 0;
            array[arrayPos] = "";
            for (int pos = 0; pos < line.length(); pos++) {
                if (line.charAt(pos) == ',') {
                    arrayPos++;
                    array[arrayPos] = "";
                } else {
                    array[arrayPos] += line.charAt(pos);
                }
            }
        }
        scanner.close();
        int arrayLength = 0;
        while (array[arrayLength] != null) {
            arrayLength++;
        }
        for (int arrayPos = 0; arrayPos <= arrayLength-1; arrayPos++) {
                array[arrayPos] = array[arrayPos].substring(1, array[arrayPos].length() - 1);
        }
        return array;
    }
    private static void compareNumbers(String[] array, int pos, int arrayLength) {
        int smallestValue = pos;
        int comp = pos;
        while (comp < arrayLength) {
            comp++;
            if (array[comp].compareTo(array[smallestValue]) < 0) {
                smallestValue = comp;
            }
        }
        String temp = array[pos];
        array[pos] = array[smallestValue];
        array[smallestValue] = temp;
    }
}