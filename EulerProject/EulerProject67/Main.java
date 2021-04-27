package EulerProject.EulerProject67;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*; 


//find optimal result, starting from @row and @col


public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<ArrayList<Integer>> array = createArray();
        ArrayList<ArrayList<Integer>> table = new ArrayList<ArrayList<Integer>>();
        for (ArrayList<Integer> x: array) {
            ArrayList<Integer> tableRow = new ArrayList<Integer>();
            for (int y : x) {
                tableRow.add(0);
            }
            table.add(tableRow);
        }
        System.out.println(findLargest(array, table, 0, 0));
    }

    private static ArrayList<ArrayList<Integer>> createArray() throws FileNotFoundException, IOException {
        ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
        File file = new File("C:\\Users\\eplus\\github\\EulerProject\\EulerProject\\EulerProject67\\p067_triangle.txt"); 
  
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String str;
    
        while ((str = br.readLine()) != null) {
            ArrayList<Integer> rowArray = new ArrayList<Integer>();
            InputStream stream = new ByteArrayInputStream(str.getBytes(StandardCharsets.US_ASCII));
            Scanner scanner = new Scanner(stream);
            while(scanner.hasNextInt()) {
                rowArray.add(scanner.nextInt());
            }
            array.add(rowArray);
            scanner.close();
        }

        br.close();
        return array;
    }

    private static int findLargest(ArrayList<ArrayList<Integer>> array, ArrayList<ArrayList<Integer>> table, int row, int column) {
        int leftOpt;
        int rightOpt;
        if (row == array.size() - 1) {
            table.get(row).set(column, array.get(row).get(column));
            return table.get(row).get(column);
        }

        if (table.get(row + 1).get(column) != 0) {
            leftOpt = table.get(row+1).get(column);
        } else {
            leftOpt = findLargest(array, table, row + 1, column);
        }
        if (table.get(row + 1).get(column + 1) != 0) {
            rightOpt = table.get(row+1).get(column+1);
        } else { 
            rightOpt = findLargest(array, table, row + 1, column + 1);
        }

        table.get(row).set(column, Math.max(leftOpt, rightOpt) + array.get(row).get(column));
        return table.get(row).get(column);
    }
}