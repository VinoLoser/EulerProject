package EulerProject.EulerProject29;
       
public class Main {
    public static void main(String[] args) {
        int size = 100;
        int total = 0;
        int[][] array = new int [size * size + 1][size + 1];
        for (int a = 2; a <= size; a++) {
            for (int b = 2; b <= size; b++) {
                if (checkNum(a, array, b, total, size) == true) {
                    total++;
                }
            }
        }
        System.out.println(total);
    }
    private static boolean checkNum(int num, int[][] array, int b, int total, int size) {
        int[] temp = new int [size + 1];
        for (int i = 2; i <= num; i++) {
            int exponent = 0;
            while (num%i == 0 && num > 1) {
                num /= i;
                exponent++;
            }
            temp[i] = exponent * b;
        }
        for (int arrayList = 0; arrayList <= total; arrayList++) {
            int lastexponents = 0;
            while (array[arrayList][lastexponents] == temp[lastexponents]) {
                lastexponents++;
                if (lastexponents == temp.length) {
                    return false;
                }
            }
        }
        for (int exponents = 0; exponents < temp.length; exponents++) {
            array[total][exponents] = temp[exponents];
        }
        return true;
    }
}