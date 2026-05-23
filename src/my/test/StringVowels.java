package my.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringVowels {

    public static void main(String[] args) {
//        Given a list of strings, return a map:
//       String → Number of vowels.

        List<String> words = Arrays.asList(
                "apple",
                "banana",
                "sky",
                "rhythm",
                "education",
                "openai",
                "computer",
                "java",
                "stream",
                "beautiful"
        );
        Map<String, Integer> collect = words.stream().collect(
                Collectors.toMap(
                        e -> e,
                        e -> countVowels(e))
                );
        System.out.println(collect);


    }

    private static int countVowels(String str) {
        String vovels = "aeiou";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (vovels.contains(""+str.toLowerCase().charAt(i))) {
                count++;
            }
        }
        return count;
    }
}
