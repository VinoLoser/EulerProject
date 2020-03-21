public class FindLargestPrimeNumber{
    public static void main(String[] args) {
        LargestPrimeNumber ex=new LargestPrimeNumber();
        //findPrimeNumber(2, 0,Integer.parseInt(args[0]));
        ex.findPrimeNumber(2, 0, 600851475143l);
    }
}

class LargestPrimeNumber {
    //public static void main(String[] args) {

    public void findPrimeNumber(int i, int largestPrimeNumber, long number) {
        //check if dividend is less than or equal to number
        if (i <= number) {
            //check if number is divisible by dividend
            if (number%i != 0) {
                //if dividend is not divisible, I move on
                findPrimeNumber(i + 1, largestPrimeNumber, number);
            } else {
                //if number is divisble by dividend, I check if it is a prime number
                
                    largestPrimeNumber = i;
                    findPrimeNumber(i, largestPrimeNumber, number/i);
                
                /*
                    if (checkPrime(2, i) == i) {
                        //because it is a prime number and is divisble, I set largest prime number to dividend
                        largestPrimeNumber = i;
                        findPrimeNumber(i, largestPrimeNumber, number/i);
                    } else {
                        //because it is not, I continue with the old largest prime number
                        findPrimeNumber(i + 1, largestPrimeNumber, number/i);
                    }
                */
                }   
        //if dividend is greater than number, then I print and exit out of function
        } else
            System.out.println(largestPrimeNumber);
    }

    public int checkPrime(int o, int i) {
        if (i%o != 0) {
            return checkPrime(o + 1, i);
        }
        return o;
    }
}
