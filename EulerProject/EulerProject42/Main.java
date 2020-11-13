package EulerProject.EulerProject42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) throws FileNotFoundException {
        final File file = new File("C:/Users/eplus/github/EulerProject/EulerProject/EulerProject42/words.txt");
        try (final Scanner scanner = new Scanner(file)) {
            scanner.useDelimiter(",");

            int triangleNumberTotal = 0;

            while (scanner.hasNext()) {
                String word = scanner.next();
                word = word.substring(1, word.length() - 1);

                if (check(calculateTotal(word))) {
                    triangleNumberTotal++;
                }
            }

            System.out.println(triangleNumberTotal);
        }
    }

    private static boolean check(int x) {
        final int n = (int) Math.sqrt(x + x);
        return n * (n + 1) == x + x;
    }

    private static int calculateTotal(String word) {
        int stringTotal = 0;
        for (int pos = 0; pos < word.length(); pos++) {
            stringTotal += word.charAt(pos) + 1 - 'A';
        }
        return stringTotal;
    }
}