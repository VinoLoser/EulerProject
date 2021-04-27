package EulerProject.EulerProject14;


public class Main {
    public static void main(String[] args) {
        long [] array = new long [1000000];
        long currentGreatestChain = 0;
        long currentGreatestChainNumber = 0;
        // number we will test
        for (long number = 0; number < 1000000; number++) {
            // we check if the chain we make from the number is larger than our current largest chain
	        long tmpcount=checkChain(number, array);
            if (tmpcount > currentGreatestChain) {
                currentGreatestChainNumber = number;
                currentGreatestChain = tmpcount;
            }
        } 
        System.out.println(currentGreatestChainNumber);
    }

    private static long even(long number) {
        // if even do this
        return number/2;
    }

    private static long odd(long number) {
        // if odd do this
        return number*3+1;
    }

    private static long checkChain(long number, long [] array) {
        // we continue to add to chaincounter until the number is less than or equal to
        long originalNumber = number;
        long chainCounter = 0;
        while (number > 1) {
            if (number < originalNumber) {
                //I use a value I calcuated earlier to find my current number's chain
                chainCounter += array[ (int) number];
                break;
            } else {
            //if the number is larger than the original, values have not been inputed, so it is useless and we will not use it
            if (number % 2 == 0) number = even(number);
            else number = odd(number);
	        chainCounter++;
            }
        }
        array[(int) originalNumber] = chainCounter;
        return chainCounter;
    }
}