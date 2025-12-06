package my.test;

import java.util.*;
import java.util.stream.Collectors;
//Given a list of strings, return a frequency map sorted by key in reverse alphabetical order.
public class FrequencyValurSorting {
    void main() {

        List<String> words = List.of(
                "apple",
                "banana",
                "orange",
                "banana",
                "grape",
                "apple",
                "kiwi",
                "mango",
                "orange",
                "apple",
                "kiwi",
                "banana",
                "peach",
                "grape",
                "apple"
        );

        LinkedHashMap<String, Long> collect = words.stream().collect(
                Collectors.groupingBy(
                        e -> e,
                        Collectors.counting()
                )
        ).entrySet().stream()
                .sorted(Comparator.comparingLong( (Map.Entry<String, Long> a)-> a.getValue() ).thenComparing((e)-> e.getKey()))
                .collect(
                        Collectors.toMap(
                                a -> a.getKey(),
                                a -> a.getValue(),
                                (a, b) -> a,
                                LinkedHashMap::new
                        )
                );

  
        IO.println(collect);
    }


}
