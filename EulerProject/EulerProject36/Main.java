package EulerProject.EulerProject36;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int num = 1; num < 1000000; num++) {
            if (checkNum(num) == true) {
                sum += num;
            }
        }
        System.out.println(sum);
        System.out.println("hi");
    }
    private static boolean checkNum(int num) {
        String number = String.valueOf(num);
        String reverseString = "";
        for (int i = number.length() - 1; i >= 0; i--)
            reverseString += number.charAt(i);
        if (reverseString.charAt(0) != 0 && reverseString.equals(number)) {
            int[] array = new int [20];
            int pos = 0;
            while (num > 0) {
                array[pos] = num % 2;
                num /= 2;
                pos++;
            }
            pos--;
            if (array[pos] != 0) {
                int reverse = pos;
                for (int forward = 0; forward <= pos; forward++, reverse--) {
                    if (array[reverse] != array[forward]) {
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}