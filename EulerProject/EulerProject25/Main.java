package EulerProject.EulerProject25;

public class Main {
    public static void main(String[] args) {
        int[] n1 = new int [1100];
        int[] n2 = new int[1100];
        n1[n1.length - 1] = 1;
        n2[n2.length - 1] = 1;
        int pos = 0;
        int times = 2;
        
        while (pos < 1000) {
            //for (int i = pos; i >= 0; i--) {
            //    System.out.print(n1[i]);
            //}
            System.out.println("");
            pos = addNum(n1, n2);
            times++;
        }
        //System.out.println(pos);
        System.out.println(times);
    }

    private static int addNum(int[] n1, int[] n2) {
        int nextNum = 0;
        for (int pos = n2.length - 1; pos >= 0; pos--) {
            int temp = n2[pos];
            n2[pos] += n1[pos] + nextNum;
            nextNum = fixNum(n2, pos);

            n1[pos] = temp;
        }
        //System.out.println(pos - 1);
        int pos = 0;
        while (n2[pos] == 0) {
            pos++;
        }
        return n2.length - pos;
    }

    private static int fixNum(int[] n2, int pos) {
        if (n2[pos] >= 10) {
            int temp = n2[pos];
            n2[pos] %= 10;
            return temp / 10;
        } else {
            return 0;
        }
    }
}