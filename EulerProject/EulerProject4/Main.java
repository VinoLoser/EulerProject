package EulerProject.EulerProject4;

public class Main {
    public static void main(String[] args) {
        int Largest_Palindrom = -1;
        for (int x = 999; x >= 100; x--) {
            for (int y = 999; y >= 100; y--) {
                // Find the number to be tested for palindrom and change integer into string
                int Number = x * y;
                // create stringbuilder variable
                StringBuilder stringNumber1 = new StringBuilder();
                // set stringbuilder variable to reverse of the real number
                stringNumber1.append(Number);
                stringNumber1 = stringNumber1.reverse();
                // check if string and reverse of string are equivelant (if it is not a
                // palindrome number)
                if (Number == Integer.parseInt(stringNumber1.toString())) {
                    if (Largest_Palindrom < Number) {
                        Largest_Palindrom = Number;
                    }
                }
            }
            
        }
        System.out.println(Largest_Palindrom);
    }
}