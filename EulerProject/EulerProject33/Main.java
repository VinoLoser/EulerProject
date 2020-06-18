package EulerProject.EulerProject33;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[2];
        int finalD = 1;
        int finalN = 1;
        for (int n = 10; n < 100; n++) {
            for (int d = n + 1; d < 100; d++) {
                if (n % 10 != 0 && d % 10 != 0) {
                    if (checkFrac(n, d) == true) {
                        finalN *= n;
                        finalD *= d;
                    }
                }
            }
        }
        array = divideFrac(finalN, finalD);
        System.out.println(array[1]);
    }

    private static boolean checkFrac(int n, int d) {
        int[] array = new int [2];
        int[] array2 = new int [2];
        String stringN = String.valueOf(n);
        String stringD = String.valueOf(d);
        for (int pos = 0; pos < stringN.length(); pos++) {
            for (int compareTo = 0; compareTo < stringD.length(); compareTo++) {
                if (stringN.charAt(pos) == stringD.charAt(compareTo)) {
                    stringN = stringN.substring(0, pos) + stringN.substring(pos + 1, stringN.length());
                    stringD = stringD.substring(0, compareTo) + stringD.substring(compareTo + 1, stringD.length());
                    int tempN = Integer.valueOf(stringN);
                    int tempD = Integer.valueOf(stringD);
                    array = divideFrac(n, d);
                    array2 = divideFrac(tempN, tempD);
                    if (array[0] == array2[0] && array[1] == array2[1]) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    private static int[] divideFrac(int n, int d) {
        int[] array = new int [2];
        for (int divisor = 2; divisor <= n; divisor++) {
            if (n % divisor == 0 && d % divisor == 0) {
                n /= divisor;
                d /= divisor;
                divisor = 1;
            }
        }
        array[0] = n;
        array[1] = d;
        return array;
    }
}