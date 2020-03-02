public class Main {
    public static void main(String[] args) {
        int largestProduct = 0;
        int[][] array = initBeginningArray();
        for (int column = 0; column < 20; column++) {
            for (int row = 0; row < 20; row++) {
                int currentProduct = checkValue(column, row, array);
                if (currentProduct > largestProduct) largestProduct = currentProduct;
            }
        }
        System.out.println(largestProduct);
    }
    private static int[][] initBeginningArray() {
        int [][] array = new int [20][20];
        int x = 0;
        String numbers =
            "0802229738150040007504050778521250779108" +
            "4949994017811857608717409843694804566200" +
            "8149317355791429937140675388300349133665" +
            "5270952304601142692468560132567137023691" +
            "2231167151676389419236542240402866331380" +
            "2447326099034502447533537836842035171250" +
            "3298812864236710263840675954706618386470" +
            "6726206802621220956394396308409166499421" +
            "2455580566739926971778789683148834896372" +
            "2136230975007644204535140061339734313395" +
            "7817532822753167159403800462161409535692" +
            "1639054296353147555888240017542436298557" +
            "8656004835718907054444374460215851541758" +
            "1980816805944769287392138652177704895540" +
            "0452088397359916079757321626267933279866" +
            "8836688757622072034633674655123263935369" +
            "0442167338253911249472180846293240627636" +
            "2069364172302388346299698267598574043616" +
            "2073352978319001743149714886811623570554" +
            "0170547183515469169233486143520189196748" ;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                array[i][j] = (numbers.charAt(x) - '0')*10 + numbers.charAt(++x) - '0';
                x++;
            }
        }
        return array;
    }
    private static int checkValue(int column, int row, int[][] array) {
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        int diagonal = 0;
        int otherDiagonal = 0;
        if (column >= 3) up = array[row][column] * array[row][column-1] * array[row][column-2] * array[row][column-3];
        //if (column < 17) down = array[row][column] * array[row][column+1] * array[row][column+2] * array[row][column+3];
        if (row >= 3) left = array[row][column] * array[row-1][column] * array[row-2][column] * array[row-3][column];
        //if (row < 17) right = array[row][column] * array[row+1][column] * array[row+2][column] * array[row+3][column];
        if (row < 17 && column < 17) diagonal = array[row][column] * array[row+1][column+1] * array[row+2][column+2] * array[row+3][column+3];
        if (row < 17 && column >= 3) otherDiagonal = array[row][column] * array[row+1][column-1] * array[row+2][column-2] * array[row+3][column-3];
        return Math.max(diagonal, Math.max(otherDiagonal, Math.max(up, Math.max(down, Math.max(right,left)))));
    }
}
