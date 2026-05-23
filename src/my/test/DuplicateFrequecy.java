package my.test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateFrequecy {

    static void main() {
        // Given a list of integers, convert all duplicates to a frequency map sorted by frequency.
        List<Integer> numbers = List.of(
                5, 1, 3, 5, 2,
                1, 4, 3, 5, 2,
                2, 3, 6, 3, 5,
                4, 2, 1, 5, 3
        );
        LinkedHashMap<Integer, Long> collect = numbers.stream().collect(
                        Collectors.groupingBy(
                                e -> e,
                                Collectors.counting()
                        )
                ).entrySet()
                .stream()
                .sorted(Map.Entry.<Integer,Long>comparingByValue().reversed())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a, b) -> b,
                                LinkedHashMap::new
                        ));
        System.out.println(collect);
    }

}
