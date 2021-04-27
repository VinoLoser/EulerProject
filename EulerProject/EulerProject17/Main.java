package EulerProject.EulerProject17;

public class Main {
    public static void main(String[] args) {
        String[] firstDigit = {"","one","two","three","four","five","six","seven","eight","nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tensDigit = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        int letterCounter = 11;
        for (int number = 1; number < 1000; number++) {
            letterCounter = findLetters(number, letterCounter, firstDigit, tensDigit);
        }
        System.out.println(letterCounter);
    }

    private static int findLetters(int number, int letterCounter, String[] firstDigit, String[]tensDigit) {
        String hundredsPlace;
        String tensPlace;
        int tensPlaceNumber = 0;
        if (number >= 100) {
            hundredsPlace = firstDigit[number/100] + "hundredand";
        } else hundredsPlace = "";
        String hundredsPlaceCheck = firstDigit[number/100] + "hundred";
        number = number%100;  

        if (number > 19) {
            tensPlace = tensDigit[number/10-2];
            tensPlaceNumber = 1;
            number = number%10;
        } else {
            tensPlace = "";
            if (number >= 10) {
                tensPlaceNumber = 1;
            }
        }

        
        String onesPLace = firstDigit[number];
        if (number == 0 && tensPlaceNumber == 0) {
            hundredsPlace = hundredsPlaceCheck;
        }

        String theNumber = hundredsPlace + tensPlace + onesPLace;
        System.out.println(theNumber);
        letterCounter += theNumber.length();
        return letterCounter;
    }
}