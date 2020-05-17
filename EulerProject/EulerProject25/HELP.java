package EulerProject.EulerProject25;

public class HELP {
    public static void main(String[] args) {
        int[] n1 = new int [2000];
        int[] n2 = new int [2000];
        int[] n = new int [2000];
        n1[0] = 1;
        n2[0] = 1;
        n[0] = 1;
        int pos = 0;
        int times = 0;
        while (pos <= 3) {
            for (int i = pos; i >= 0; i--) {
                System.out.print(n[i]);
            }
            System.out.println("");
            pos = newNum(n1, n2, n);
            times++;
        }
        System.out.println(pos);
        System.out.println(times);
    }
    
    private static int newNum(int[]n1, int[]n2, int[]n) {
        int pos = 0;
        for (;pos < n.length; pos++) {
            if (n1[pos] == 0 && n2[pos] == 0) {
                break;
            }
            //reset n
            n[pos] += n2[pos];
            fixNum(n, pos);
            //reset n1 and n2
            int temp = n2[pos];
            n1[pos] = temp;
            n2[pos] = n[pos] - n1[pos];
            
        }
        return pos-1;
    }

    private static void fixNum(int[]n, int pos) {
        if (n[pos] >= 10) {
            n[pos + 1] = n[pos] / 10;
            n[pos] %= 10;
        }
    }
}