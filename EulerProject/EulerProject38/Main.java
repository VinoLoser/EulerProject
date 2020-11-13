package EulerProject.EulerProject38;

public class Main {
    public static void main(String[] args) {
        int n = 9;
        int largest = 0;
        int total = 0;
        for (int num = 0; num < 10; num++) {
            String string = checkNum(num, n);
            if (string.length() == 9) {
                for (int check = 1; check <= 9; check++) {
                    total = 0;
                    for (int pos = 0; pos < string.length(); pos++) {
                        if (string.charAt(pos) - '0' == check)
                            total++;
                    }
                    if (total != 1)
                        break;
                }
                if (Integer.valueOf(string) > largest && total == 1)
                    largest = Integer.valueOf(string);
            }
        }
        n -= 5;
        for (int num = 0; num < 10; num++) {
            String string = checkNum(num, n);
            if (string.length() == 9) {
                for (int check = 1; check <= 9; check++) {
                    total = 0;
                    for (int pos = 0; pos < string.length(); pos++) {
                        if (string.charAt(pos) - '0' == check)
                            total++;
                    }
                    if (total != 1)
                        break;
                }
                if (Integer.valueOf(string) > largest && total == 1)
                    largest = Integer.valueOf(string);
            }
        }
        n--;
        for (int num = 100; num < 1000; num++) {
            String string = checkNum(num, n);
            if (string.length() == 9) {
                for (int check = 1; check <= 9; check++) {
                    total = 0;
                    for (int pos = 0; pos < string.length(); pos++) {
                        if (string.charAt(pos) - '0' == check)
                            total++;
                    }
                    if (total != 1)
                        break;
                }
                if (Integer.valueOf(string) > largest && total == 1)
                    largest = Integer.valueOf(string);
            }
        }
        n--;
        for (int num = 1000; num < 10000; num++) {
            String string = checkNum(num, n);
            if (string.length() == 9) {
                for (int check = 1; check <= 9; check++) {
                    total = 0;
                    for (int pos = 0; pos < string.length(); pos++) {
                        if (string.charAt(pos) - '0' == check)
                            total++;
                    }
                    if (total != 1)
                        break;
                }
                if (Integer.valueOf(string) > largest && total == 1)
                    largest = Integer.valueOf(string);
            }
        }
        System.out.println(largest);
    }
    private static String checkNum(int num, int n) {
        String string = "";
        for (int pos = 1; pos <= n; pos++)
            string += String.valueOf(num*pos);
        return string;
    }
}