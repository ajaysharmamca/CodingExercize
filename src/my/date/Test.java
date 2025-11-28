package my.date;

public class Test {
    public static void main(String[] args) {
        String s = "abcd";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            for (int j = i; j <  s.length() ; j++) {
                System.out.print(s.charAt(j));
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 1; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            for (int j = 0; j < i ; j++) {
                System.out.print(s.charAt(j));
            }
            System.out.println("");
        }
        System.out.println("");
        for (int i = 1; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            for (int j = 0; j < i ; j++) {
                System.out.print(s.charAt(j));
            }
        }
        System.out.println("");
        for (int i = 3; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            for (int j = 0; j < i ; j++) {
                System.out.print(s.charAt(j));
            }
        }

    }
}
//Given a string S. The task is to print all the possible permutations of the given string.A
//permutation of a string S iis another string that contains the same characters, only the order
//of characters can be different.
//
//For example, “abcd” and “dabc” are permutations of each other.