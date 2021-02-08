package EulerProject.EulerProject45;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        for (int n = 166; ; n++) {
            long temp = n * ((2 * n) - 1);
            if ((1 + Math.sqrt(1 + 24 * temp)) % 6 == 0) {
                System.out.println(temp);
                break;
            }
        }
    }
}
