package EulerProject.EulerProject7;

public class Main {
    public static void main(String[] args) {
        int number = 2;
        int prime = 1;
        int answerPrime = 0;
        while (prime <= 10001) {
            if (checkPrime(number) == true) {
                prime++;
                answerPrime = number;
            }
            number++;
        }
        System.out.println(answerPrime);
    }
    private static boolean checkPrime(int number) {
        for (int check = 2; check < number; check++) {
            if (number%check == 0) {
                return false;
            }
        }
        return true;
    }
}