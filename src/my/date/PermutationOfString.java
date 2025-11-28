package my.date;

public class PermutationOfString {

    // Function to print all permutations
    static void permute(String prefix, String remaining) {
        System.out.println("==== " + prefix + ", remaing " + remaining);
        if (remaining.length() == 0) {

            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            System.out.println("i = " + i);
            permute(

                prefix + remaining.charAt(i),
                remaining.substring(0, i) + remaining.substring(i + 1)
            );
        }
    }

    public static void main(String[] args) {
        String s = "abcd";   // Given string
        permute("", s);
    }
}