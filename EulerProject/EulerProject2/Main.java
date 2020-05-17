package EulerProject.EulerProject2;

public class Main {
    public static void main(String[] args) {
        int oldNumber = 1;
        int newNumber = 2;
        int sumOfEven = 2;
        int temp = 0;
        while (newNumber < 4000000) {
            if ((oldNumber + newNumber) % 2 == 0) {
                sumOfEven = sumOfEven + oldNumber + newNumber;
            }
            temp = newNumber;
            newNumber = oldNumber + newNumber;
            oldNumber = temp;
        }
        System.out.println(sumOfEven);

    }
}