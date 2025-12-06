package my.test;/*
 */


import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * charaver and ther count
 */
public class CountCharacters {
/*


 */

    void main() {
        String sentence = "this is test";
        Map<Character, Long> characterCount = sentence.chars()
                                    .mapToObj(c-> (char) c)
                                    .collect(
                                            Collectors.groupingBy(e->e, TreeMap::new, Collectors.counting())
                                            );

        System.out.println(characterCount);
    }



}
