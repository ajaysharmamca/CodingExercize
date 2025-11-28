package my.practise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupConsecutiveCharacters {

    public static void main(String[] args) {
        String str = "aabbbccnnn";
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        String newString = new String();

        for(int i = 0; i < str.length(); i++) {
            charCount.put(str.charAt(i), charCount.getOrDefault(str.charAt(i), 0) + 1);
        }
        newString = charCount.entrySet().stream().map( e -> ""+ e.getKey() + e.getValue()).collect(Collectors.joining());
        System.out.println(newString);
    }

}
