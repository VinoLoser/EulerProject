package EulerProject.EulerProject52;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            if (checkNum(i)) {
                System.out.println(i);
                break;
            }
        }
    }
    public static boolean checkNum(int i) {
        String temp = sortString(String.valueOf(i));
        for (int test = 2; test <= 6; test++) {
            String num = String.valueOf(i * test);
            if (!sortString(num).equals(temp)) {
                return false;
            }
        }
        return true;
    }
    public static String sortString(String inputString) 
    { 
        // convert input string to char array 
        char tempArray[] = inputString.toCharArray(); 
          
        // sort tempArray 
        Arrays.sort(tempArray); 
          
        // return new sorted string 
        return new String(tempArray); 
    } 
}
