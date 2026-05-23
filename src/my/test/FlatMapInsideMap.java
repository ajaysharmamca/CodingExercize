package my.test;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FlatMapInsideMap {
    //  Given a list of domain names, return only top-level domains (.com, .org, .in) using streams.
    static Map<String, Map<String, Integer>> data = Map.of(
            "A", Map.of(
                    "x", 10,
                    "y", 20
            ),
            "B", Map.of(
                    "p", 30,
                    "q", 40
            )
    );

    static void main() {
        Map<String, Integer> collect = data.entrySet()
                .stream()
                .flatMap(outerEntry -> outerEntry.getValue()
                        .entrySet()
                        .stream()
                        .map(innerEntry ->
                                Map.entry(
                                        outerEntry.getKey() + "," + innerEntry.getKey(),
                                        innerEntry.getValue())
                        )
                )
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,

                                Map.Entry::getValue,
                                (v1, v2) -> v2,
                                TreeMap::new
                        )
                );


        System.out.println("" + collect );
    }
}
