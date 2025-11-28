package my.leet.pattern.sliding;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String input = "swiss";
        Map<Character, Integer> firstNonRepeated = new LinkedHashMap<>();
        input.chars().forEach(e -> firstNonRepeated.put( (char)e, firstNonRepeated.getOrDefault((char)e, 0) + 1 ));
        Optional<Character> x = firstNonRepeated.entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).findFirst();
        System.out.println(x.orElseGet(null));
    }
}
