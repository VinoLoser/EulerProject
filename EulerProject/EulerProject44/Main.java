package EulerProject.EulerProject44;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        System.out.println(findPentagonalNum(hashMap));
    }
    
    public static double findPentagonalNum(HashMap<Integer, Integer> hashMap) {
        for (int n = 1; ; n++) {
            int firstNum = n * (3 * n - 1) / 2;
            hashMap.put(n, firstNum);
            for (int secondN = n - 1; secondN > 0; secondN--) {
                int secondNum = hashMap.get(secondN);
                if (hashMap.containsValue(firstNum - secondNum)) {
                    int sum = firstNum + secondNum;
                    double temp = (1 + Math.sqrt(1 + 24 * sum)) / 6;
                    if (temp == (int)temp) {
                        return Math.abs(firstNum - secondNum);
                    }
                }
            }
        }
    }
}
