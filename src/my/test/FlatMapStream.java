package my.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Flatten a Map<String, List<Integer>> into a single list of integers.

 Use flatMap + map.values().stream().**

 */
public class FlatMapStream {
    void main() {
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("A", List.of(1, 2, 3));
        map.put("B", List.of(4, 5));
        map.put("C", List.of(6, 7, 8, 9));

        List<Integer> list = map.entrySet().stream().flatMap(e -> e.getValue().stream()).toList();
        System.out.println(list);
    }


}