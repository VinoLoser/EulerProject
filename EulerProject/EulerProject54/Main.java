package EulerProject.EulerProject54;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    class card {
        int value;
        char type;
    }
    public static void main (String[] args) throws FileNotFoundException {
        Main main = new Main();
        File file = new File("C:/Users/eplus/github/EulerProject/EulerProject/EulerProject54/p054_poker.txt");
        int p1wins = 0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            String temp = scanner.nextLine();
            
            card[] p1 = new card[5];
            createMap(temp, p1, 0, temp.length()/2, main);
            int[] p1numbers = new int[5];
            char[] p1cardType = new char[5];
            createArrays(p1numbers, p1cardType, p1, main);
            int p1num = compare(p1numbers, p1cardType);

            card[] p2 = new card[5];
            createMap(temp, p2, temp.length()/2 + 1, temp.length(), main);
            int[] p2numbers = new int[5];
            char[] p2cardType = new char[5];
            createArrays(p2numbers, p2cardType, p2, main);
            int p2num = compare(p2numbers, p2cardType);

            // check who wins
            if (p1num > p2num) {
                // Add 1 win to p1
                p1wins++;
            } else if (p1num == p2num) {
                if (p1num == 3) {
                    int[] p1temp = p1numbers;
                    int[] p2temp = p2numbers;
                    findLargestValue(p1numbers, p1cardType, 3);
                    findLargestValue(p2numbers, p2cardType, 3);
                    if (p1numbers[1] > p2numbers[1]) {
                        p1wins++;
                    } else if (p1numbers[1] == p2numbers[1]) {
                        if (p1numbers[0] > p2numbers[0]) {
                            p1wins++;
                        } else if (p1numbers[0] == p2numbers[0]) {
                            for (int i = p1temp.length-1; i >= 0; i--) {
                                if (p1temp[i] > p2temp[i]) {
                                    p1wins++;
                                    break;
                                } else if (p2temp[i] > p1temp[i]) {
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    p1num = findLargestValue(p1numbers, p1cardType, p1num);
                    p2num = findLargestValue(p2numbers, p2cardType, p2num);
                    if (p1num > p2num) {
                        p1wins++;
                    } else if (p1num == p2num) {
                        for (int i = p1numbers.length-1; i >= 0; i--) {
                            if (p1numbers[i] > p2numbers[i]) {
                                p1wins++;
                                break;
                            } else if (p2numbers[i] > p1numbers[i]) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(p1wins);
    }

    public static int compare(int[] numbers, char[] strings) {
        
        // test to see if person's cards fit with a flush
        int test = checkFlush(numbers);
        // check if cards are a royal flush
        int numOfSameSuit = 1;
        for (int i = strings.length - 1; i > 0; i--) {
            if (strings[i - 1] == strings[i]) {
                numOfSameSuit++;
            }
        }

        if (test == 10) {
            // if they are not royal flush, label as just a straight
            if (numOfSameSuit != 5) {
                test = 5;
            } else {
                // otherwise keep as royal flush
                test = 10;
            }
            // check if cards are a straight flush
        } else if (test == 5) {
            // if cards are a straight flush, label as straight flush
            if (numOfSameSuit == 5) {
                test = 9;
            } else {
                // otherwise, label as straight
                test = 5;
            }
        }
        // if cards are flush, label as flush
        if (numOfSameSuit == 5 && test < 6) {
            test = 6;
        }
        // check if cards have pairs
        int temp = checkPairs(numbers);
        // if after checked flush, already larger than the pairs, then just return
        if (temp < test) {
            return test;
        } else {
            // otherwise save temp as test
            test = temp;
        }
        // if test is still zero, that means the only option is highest value card
        if (test == 0) {
            test = 1;
        }
        return test;
    }
    public static int checkFlush(int[] array) {
        for (int i = array.length-1; i>0; i--) {
            if (array[i-1] + 1 != array[i]) {
                return 0;
            }
        }
        if (array[array.length-1] == 14) {
            return 10;
        } else {
            return 5;
        }
    }
    public static int checkPairs(int[] array) {
        int numofpairs = 0;
        int n = 1;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length-1 && array[i+1] == array[i]) {
                n++;
            } else {
                if (n == 4) {
                    return 8;
                }
                if (n == 3) {
                    numofpairs += 3;
                }
                if (n==2) {
                    numofpairs += 2;
                }
                n = 1;
            }
        }
        if (numofpairs == 3) {
            return 4;
        } else if (numofpairs == 5) {
            return 7;
        }
        if (numofpairs > 2 && numofpairs < 5) {
            return 3;
        } else if (numofpairs == 2) {
            return 2;
        }
        return 0;
    }
    public static void createMap(String temp, card[] array, int beginIndex, int endIndex, Main main) {
        int pos = 0;
        int hashmapPos = beginIndex;
        for (; hashmapPos < endIndex; hashmapPos+=3) {
            // set up p1 cards and strings
            char hallo = temp.charAt(hashmapPos);
            int p = 0;
            if (hallo == 'T') {
                // Ten
                p = 10;
            } else if (hallo == 'J') {
                // Jack
                p = 11;
            } else if (hallo == 'Q') {
                // Queen
                p = 12;
            } else if (hallo == 'K') {
                // King
                p = 13;
            } else if (hallo == 'A') {
                // Ace
                p = 14;
            } else {
                // 1, 2, 3, 4, 5, 6, 7, 8, or 9
                p = hallo - '0';
            }
            card card = main.new card();
            card.value = p;
            card.type = temp.charAt(hashmapPos+1);
            array[pos] = card;
            pos++;
        }
    }
    public static void createArrays(int[] p1numbers, char[] p1cardType, card[] array, Main main) {
            int p1pos = 0;
            // Save the card type and card numbers of the person 1
            for (card i : array) {
                p1numbers[p1pos] = i.value;
                p1cardType[p1pos] = i.type;
                p1pos++;
            }
            // Sort the 1st players' cards
            Arrays.sort(p1numbers);
    }
    public static int findLargestValue(int[] p1numbers, char[] p1cardType, int rank) {
        if (rank == 10) {
            return 14;
        } 
        if (rank == 9) {
            return p1numbers[p1numbers.length-1];
        }
        if (rank == 8) {
            for (int i = 0; i < p1numbers.length; i++) {
                if (p1numbers[i] == p1numbers[i+1]) {
                    return p1numbers[i];
                }
            }
        }
        if (rank == 7) {
            // full house
            int n = 1;
            for (int i = 0; i < p1numbers.length; i++) {
                if (p1numbers[i] == p1numbers[i+1]) {
                    n++;
                } else {
                    if (n == 3) {
                        return p1numbers[i];
                    }
                }
            }
        }
        if (rank == 6) {
            return p1numbers[p1numbers.length-1];
        }
        if (rank==5) {
            return p1numbers[p1numbers.length-1];
        }
        if (rank==4) {
            for (int i = 0; i < p1numbers.length; i++) {
                if (p1numbers[i] == p1numbers[i+1]) {
                    return p1numbers[i];
                }
            }
        }
        if (rank==3) {
            // two pair
            int[] array = new int[2];
            int pos = 0;
            int n = 1;
            for (int i = 0; i < p1numbers.length; i++) {
                if (p1numbers[i] == p1numbers[i+1]) {
                    n++;
                } else {
                    if (n == 2) {
                        array[pos] = p1numbers[i];
                        pos++;
                    }
                }
            }
            p1numbers = array;
            return 3;
        }
        if (rank==2) {
            for (int i = 0; i < p1numbers.length; i++) {
                if (p1numbers[i] == p1numbers[i+1]) {
                    return p1numbers[i];
                }
            }
        }
        return p1numbers[p1numbers.length-1];
    }
}