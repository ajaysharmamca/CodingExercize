package my.practise;

public class IntegerPalindrom {
    public static void main(String[] args) {
        System.out.println(isNumberPalindrome(121
        ));
    }

    private static boolean isNumberPalindrome(int number ) {
        int reverseNumber = 0;
        int originalNumber = number;
        int i = 0;
        do {
            int digit = number % 10;
            reverseNumber = reverseNumber * 10  + digit;
            number = number / 10;
        } while (number != 0 );

        return reverseNumber == originalNumber;
    }
}
