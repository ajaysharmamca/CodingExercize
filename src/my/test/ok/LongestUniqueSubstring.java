package my.test.ok;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    public static void main(String[] args) {
        String str = "abcadbd";

        int maxLength = longestUniqueSubstring(str);
        System.out.println("Length of longest substring with distinct characters: " + maxLength);
    }

    public static int longestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> set = new HashSet<>();
        int maxLen = 0;
        int start = 0, end = 0;

        while (end < s.length()) {
            char current = s.charAt(end);

            if (!set.contains(current)) {
                set.add(current);
                end++;
                maxLen = Math.max(maxLen, end - start);
            } else {
                // Remove the start character and move start forward
                set.remove(s.charAt(start));
                start++;
            }
        }

        return maxLen;
    }
}
