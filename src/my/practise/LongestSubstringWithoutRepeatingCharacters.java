package my.practise;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "sunilkumarmishra";
        System.out.println(longestSubstringLength(str));
    }

    private static int longestSubstringLength(String str) {
        int charCountLength = 0;
        Set<Integer > lengthSet = new TreeSet<Integer>((t1, t2) ->  t2.compareTo(t1) );
        //Set<Integer > lengthSet = new TreeSet(Comparator.reverseOrder());
        String characters = "";

        for (int i= 0; i < str.length(); i++ ) {
            if (characters.contains(""+str.charAt(i))) {
                lengthSet.add(charCountLength);
                charCountLength = 0;
                characters = "";

            } else {
                characters += str.charAt(i);
                charCountLength += 1;

            }
        }
        lengthSet.add(charCountLength);
        return lengthSet.stream().findFirst().orElse(-1);
    }
}
