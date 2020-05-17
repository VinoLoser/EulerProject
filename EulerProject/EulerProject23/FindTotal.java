package EulerProject.EulerProject23;

public class FindTotal {
    public static void main(String[] args) {
        int num = 28122;

        int sum = 0;
        for (int i = 1; i < num; i++) {
            if (num%i == 0) {
                sum += i;
            }
        }
        System.out.print(sum);
    }
}