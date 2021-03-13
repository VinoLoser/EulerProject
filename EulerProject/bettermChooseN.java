package EulerProject;

import java.util.ArrayList;

public class bettermChooseN {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        choose(arrayList, 5, 3);
    }

    public static void choose(ArrayList<Integer> arrayList, int m, int n) {
        if (m == n || n == 0) {
            for (int i : arrayList) {
                System.out.print(i);
            }
            for (int i = 1; i <= n; i++) {
                System.out.print(i);
            }
            System.out.println();
        } else {
            choose(arrayList, m - 1, n);
            ArrayList<Integer> tmp = new ArrayList<>(arrayList);
            tmp.add(m);
            choose(tmp, m-1, n-1);
        }
    }
}
