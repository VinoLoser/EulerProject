package EulerProject.EulerProject15;

public class Main {
    public static void main(String[] args) {
        int squareDimension = 20;
        //array length should be a dimension of the square plus 1
        int arrayLength = squareDimension + 1;
        int lastDigit = arrayLength - 1;
        long [][] array = new long [arrayLength][arrayLength];
        for (int x = 0; x < arrayLength; x++) array[x][0] = 1;
        for (int y = 0; y < arrayLength; y++) array[0][y] = 1;
        for (int row = 1; row < arrayLength; row++) {
            for(int column = 1; column < arrayLength; column++) {
                checkAreas(array, column, row);
            }
        }
        System.out.println(array[lastDigit][lastDigit]);
    }

    private static void checkAreas(long [][] array, int column, int row) {
        array[column][row] = array[column][row - 1] + array[column - 1][row];
    }

}