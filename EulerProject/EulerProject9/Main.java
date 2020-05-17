package EulerProject.EulerProject9;

public class Main {
    public static void main(String[] args) {
        for (int a = 1; a < 1000; a++) {
            for (int b = 1; b < 1000; b++) {
                for (int c = 1; c < 1000; c ++) {
                    if (checkPythagorean(a, b, c) == true && a + b + c == 1000) {
                        System.out.println(a * b * c);
                        break;
                    }
                }
            }
        }
    }
    public static boolean checkPythagorean(int a, int b, int c) {
        if (a * a + b * b == c * c) {
            return true;
        } 
        return false;
    }
}