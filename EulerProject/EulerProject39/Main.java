package EulerProject.EulerProject39;

public class Main {
    public static void main(String[] args) {
        int greatestSolutions = 0;
        int greatestSolutionsP = 0;
        for (int p = 3; p <= 1000; p++) {
            int solutions = checkSolutions(p);
            if (solutions > greatestSolutions) {
                greatestSolutions = solutions;
                greatestSolutionsP = p;
            }
        }
        System.out.print(greatestSolutionsP);
    }
    private static int checkSolutions(int p) {
        int solutions = 0;
        for (int a = 1; a < p/2; a++) {
            for (int b = 1; b < p/2; b++) {
                int c = p - a - b;
                if (a + b > c) {
                    if (Math.pow(a, 2) + Math.pow(b,2) == Math.pow(c, 2)) {
                        solutions++;
                    }
                }
            }
        }
        return solutions;
    }
}