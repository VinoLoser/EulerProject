package EulerProject;

import java.util.ArrayList;
import java.util.Arrays;

public class mChooseN {
    public static void main(String[] args) {
        ArrayList<String> arrayList = mChooseN(4, 3);
        for (String i : arrayList) {
            System.out.println(i);
        }
    }
    public static ArrayList<String> mChooseN(int m, int n) {
        if (n == 0) {
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = 0; i <= m; i++) {
                arrayList.add(String.valueOf(i));
            }
            return arrayList;
        } else {
            ArrayList<String> arrayList = mChooseN(m, n-1);
            ArrayList<String> finish = new ArrayList<String>();
            for (String i : arrayList) {
                ArrayList<String> temp = changeString(i, arrayList, m);
                for (String x : temp) {
                    if (!finish.contains(x)) {
                        finish.add(x);
                    }
                }
            }
            return finish;
        }
    }
    public static ArrayList<String> changeString(String string, ArrayList<String> arrayList, int m) {
        ArrayList<String> done = new ArrayList<String>();
        for (int i = 0; i <= m; i++) {
            if (checkString(string, i)) {
                String temp = sortString(string + String.valueOf(i));
                if (!done.contains(temp)) {
                    done.add(temp);
                }
            }
            
        }
        return done;
    }

    public static boolean checkString(String n, int num) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i)-'0' == num) {
                return false;
            }
        }
        return true;
    }
    public static String sortString(String inputString) { 
        char tempArray[] = inputString.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray); 
    }
}
