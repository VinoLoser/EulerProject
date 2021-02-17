package EulerProject.EulerProject46;

public class Main {
    public static void main(String[] args) {
        for (int i = 2; ; i++) {
            if (!isPrime(i) && i % 2 != 0) {
                if (!checkSquare(i)) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static boolean checkSquare(int i) {
        int square = 1;
        for (; square * square * 2 < i; square++) {
            if (checkNum(square, i)) {
                return true;
            }
        }
        //System.out.println(square);
        return false;
    }

    public static boolean isPrime(int i) {
        int squareRoot = (int)Math.sqrt(i);
        for (int temp = 2; temp <= squareRoot; temp++) {
            if (i%temp == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkNum(int square, int i) {
        int rem = i -  square * square * 2;
        if (rem <= 0) {
            System.out.println("Error");
        }
        boolean rc =  isPrime(rem);
        if (rc) {
            //System.out.println(String.format("%d = 2 * %d * %d + %d", i, square, square, rem ));
        }
        return rc;
    }
}
 