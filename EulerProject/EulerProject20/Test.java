package EulerProject.EulerProject20;

public class Test {
    public static void main(String[] args) {
        int[] array = {4,5,6,7,0,0,0,0,0};
        int pos = array.length - 1;
        while (array[pos] == 0) {
            pos--;
        }
        System.out.print(pos); 
    }
}