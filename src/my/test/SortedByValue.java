package my.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Sort a map by values (ascending and descending) using streams.
 *
 */
public class SortedByValue {

    void main() {
        Map<String, Integer> citizens = Map.of(
                                            "Sanjay", 3,
                                            "Mahesh", 1,
                                            "Rohit", 2
                                        );
        Map<String, Integer> reversed = citizens.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a,b) -> a,
                        LinkedHashMap::new));
        System.out.println(reversed);
    }
}