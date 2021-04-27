package EulerProject.EulerProject16;

public class Main {
    public static void main(String[] args) {
        int[] array = new int [1005];
        array[0]  = 1;
        for (int timesMultiplied = 0; timesMultiplied < 1000; timesMultiplied++) {
            multiplyAndCheck(array);
        }
        int sum = 0;
        for(int addNumber = 0; addNumber < array.length; addNumber++) {
            sum += array[addNumber];
        }
        System.out.println(sum); 
    }
    private static void multiplyAndCheck(int[] array) {
        for (int arrayPosition = 0; arrayPosition < array.length; arrayPosition++) array[arrayPosition] *= 2;
        for (int arrayPosition = 0; arrayPosition < array.length; arrayPosition++) {
            if (array[arrayPosition] >= 10) {
                array[arrayPosition  + 1] += array[arrayPosition]/10;
                int remainder = array[arrayPosition]%10;
                array[arrayPosition] = remainder;
            }
        }
    }
}