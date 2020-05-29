package EulerProject.EulerProject28;

public class Main {
    public static void main(String[] args) {
        int[][] array = new int [1002][1002];
        createArray(array);
        int Sum = 0;
        for (int left = 1; left < array.length; left++) {
            Sum += array[left][left];
        }
        int column = array.length - 1;
        for (int row = 1; row < array.length; row++) {
            Sum += array[row][column];
            column--;
        }
        System.out.print(Sum - array[(array.length - 1)/2 + 1][(array.length-1)/2 + 1]);
    }
    private static void createArray(int[][] array) {
        int column = (array.length - 1)/2 + 1;
        int row = column;
        array[row][column] = 1;
        for (int square = 3; square <= array.length - 1; square += 2) {
            row++;
            array[row][column] = array[row -  1][column] + 1;
            //down
            for (int max = 1; max < square - 1; max++) {
                column++;
                array[row][column] = array[row][column - 1] + 1;
            }
            //left
            for (int max = 1; max < square; max++) {
                row--;
                array[row][column] = array[row + 1][column] + 1;
            }
            //up
            for (int max = 1; max < square; max++) {
                column--;
                array[row][column] = array[row][column + 1] + 1;
            }
            //right
            for (int max = 1; max < square; max++) {
                row++;
                array[row][column] = array[row - 1][column] + 1;
            }
        }
    }
}


    