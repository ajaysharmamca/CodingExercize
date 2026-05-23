package my.test;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ShowContByFirstCharacter {
   // Given a paragraph, return a map:
    //
    //First letter → Count of words starting with that letter.

    static void main() {
        String paragraph =
                "Java streams simplify data processing. " +
                        "Streams support functional style programming. " +
                        "Java provides powerful stream operations.";

        TreeMap<Character, Long> collect = Arrays.stream(paragraph.split("\\s+"))
                .map(String::toLowerCase)
                .map(word -> word.replaceAll("[^a-z]", ""))
                .filter(word -> !word.isEmpty())
                .collect(
                        Collectors.groupingBy(
                                s -> s.charAt(0),
                                TreeMap::new,
                                Collectors.counting()
                        )
                );
        System.out.printf("" + collect);
    }
}
