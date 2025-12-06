package my.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByWordsCount {
    static void main() {
        String paragrah = "mango apple apple banana apple orange banana apple grape grape orange banana";
        LinkedHashMap<String, Long> collect = Arrays.stream(paragrah.split(" ")).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
        LinkedHashMap<String, Long> collect1 = collect.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry<String, Long>::getValue)
                        .reversed()).limit(2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        System.out.println(collect1);
    }
}