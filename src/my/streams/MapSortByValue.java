package my.streams;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSortByValue {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        map.put("Ajay", 1 );
        map.put("Rajeev", 2 );
        map.put("Aman", 3 );
        map.put("Mahesh", 4 );
        map.put("Mahesh", 3 );
        map.forEach((k,v) -> System.out.println(k + " " + v));
        Map<String, Integer> collect = map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).
                collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
        collect.forEach((k,v) -> System.out.println(k + "  -- " + v));

    }
}
