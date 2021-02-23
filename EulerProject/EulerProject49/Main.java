package EulerProject.EulerProject49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int num = 1000; num < 10000; num++) {
            if (findPrime(num)) {
                int temp = Integer.valueOf(sortString(String.valueOf(num)));
                ArrayList<Integer> arrayList = null;
                if (hashMap.containsKey(temp)) {
                    arrayList = hashMap.get(temp);
                } else {
                    arrayList = new ArrayList<Integer>();
                    hashMap.put(temp, arrayList);
                }
                arrayList.add(num);
            }
        }
        for (Map.Entry<Integer,ArrayList<Integer>> entry : hashMap.entrySet()) {
            ArrayList<Integer> array = entry.getValue();
            for (int x = 0; x < array.size(); x++) {
                for (int y = x + 1; y < array.size(); y++) {
                    for (int z = y + 1; z < array.size(); z++) {
                        if (array.get(y) - array.get(x) == array.get(z) - array.get(y)) {
                            System.out.print(array.get(x));
                            System.out.print(array.get(y));
                            System.out.print(array.get(z));
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
    
    public static boolean findPrime(int num) {
        for (int i = 2; i < (int)Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
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
