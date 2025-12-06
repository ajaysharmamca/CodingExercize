package my.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatedCharacter {

    void main() {
        String str = "swiss";
        Character c1 = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(c1);
    }
}
